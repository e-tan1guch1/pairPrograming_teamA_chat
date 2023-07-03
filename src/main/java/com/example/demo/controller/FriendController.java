package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Friend;
import com.example.demo.entity.Request;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.FriendRepository;
import com.example.demo.repository.RequestRepository;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class FriendController {
	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	UserRepository userRepository;

	@Autowired
	FriendRepository friendRepository;

	@Autowired
	RequestRepository requestRepository;

	@GetMapping("/friends")
	public String index(Model m) {

		//自分とフレンドの人のユーザIdを含むレコード一覧
		List<Friend> friendListNumber = friendRepository.findFriend(account.getId());
		//フレンドリスト格納用
		List<User> friendList = new ArrayList<>();

		for (Friend friendNumber : friendListNumber) {
			//自分とフレンドの人のユーザIdからユーザ情報を取得
			Optional<User> opt = userRepository.findById(friendNumber.getUser2Id());
			if (opt.isPresent()) {
				friendList.add(opt.get());
			}
		}

		m.addAttribute("friends", friendList);
		return "friends";
	}

	@GetMapping("/friends/add")
	public String add(Model m,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "search", defaultValue = "") String search

	) {
		m.addAttribute("error", "メールアドレスを入力して検索");
		if (!search.equals("")) {
			if (!email.equals("")) {
				Optional<User> opt = userRepository.findByEmail(email);
				if (opt.isPresent()) {
					if (opt.get().getEmail().equals(userRepository.findById(account.getId()).get().getEmail())) {
						m.addAttribute("error", "自分のメールアドレスです");
					} else {
						m.addAttribute("friend", opt.get());
					}
				} else {
					m.addAttribute("error", "そのアカウントは見つかりません");
				}
			} else {
				m.addAttribute("error", "メールアドレスを入力してください");
			}
		}

		m.addAttribute("email", email);
		return "addFriend";
	}

	@GetMapping("/friends/list")
	public String requestList(Model m) {

		List<Request> recieveRequestNumners = requestRepository.findByUser2Id(account.getId());
		List<User> recieveRequests = new ArrayList<>();
		for (Request recieveRequestNumber : recieveRequestNumners) {
			User user = userRepository.findById(recieveRequestNumber.getUserId()).get();
			recieveRequests.add(user);
		}

		List<Request> sendRequestNumners = requestRepository.findByUserId(account.getId());
		List<User> sendRequests = new ArrayList<>();
		for (Request sendRequestNumber : sendRequestNumners) {
			User user = userRepository.findById(sendRequestNumber.getUser2Id()).get();
			sendRequests.add(user);
		}

		m.addAttribute("recieveRequests", recieveRequests);
		m.addAttribute("sendRequests", sendRequests);
		requestRepository.findByUserId(null);

		return "friendRequestList";
	}

	@GetMapping("/friends/request")
	public String request(
			Model m,
			@RequestParam(name = "friendId", defaultValue = "") Integer friendId) {

		//自分とフレンドの人のユーザIdを含むレコード一覧
		List<Friend> friendListNumber = friendRepository.findFriend(account.getId());
		for (Friend friendNumber : friendListNumber) {

			if (friendNumber.getUser2Id() == friendId && friendNumber.getUserId() == account.getId()) {
				m.addAttribute("error", "既にフレンドです");
				return "addFriend";
			}
		}

		//既にリクエストがあるかどうか確認
		List<Request> requestListNumber = requestRepository.findByUserId(account.getId());
		for (Request requestNumber : requestListNumber) {

			if (requestNumber.getUser2Id() == friendId && requestNumber.getUserId() == account.getId()) {
				m.addAttribute("error", "リクエストの承認待ちです");
				return "addFriend";
			}
		}

		requestListNumber = requestRepository.findByUserId(friendId);
		for (Request requestNumber : requestListNumber) {

			if (requestNumber.getUser2Id() == account.getId() && requestNumber.getUserId() == friendId) {
				m.addAttribute("error", "相手からリクエストが届いています");
				return "addFriend";
			}
		}

		requestRepository.save(new Request(friendId, account.getId()));
		return "redirect:/friends/list";
	}

	@PostMapping("/friend/delete")
	public String delete(
			@RequestParam(name = "friendId", defaultValue = "") Integer friendId,
			Model m) {
		System.out.println("フレンドID" + friendId);

		Optional<Friend> opt1 = friendRepository.findOnlyFriendId(friendId, account.getId());
		Optional<Friend> opt2 = friendRepository.findOnlyFriendId(account.getId(), friendId);

		if (opt1.isPresent() && opt2.isPresent()) {
			friendRepository.delete(opt1.get());
			friendRepository.delete(opt2.get());
		}

		return "redirect:/friends";
	}

	@PostMapping("/friend/deleteRequest")
	public String deleteRequest(
			@RequestParam(name = "recieveUserId", defaultValue = "") Integer recieveUserId,
			Model m) {

		Optional<Request> opt = requestRepository.findOnlyRequest(recieveUserId, account.getId());

		if (opt.isPresent()) {
			Request request = opt.get();
			requestRepository.delete(request);
		}

		return "redirect:/friends/list";
	}

	@PostMapping("/friend/refuseRequest")
	public String refuseRequest(
			@RequestParam(name = "sendUserId", defaultValue = "") Integer sendUserId,
			Model m) {

		Optional<Request> opt = requestRepository.findOnlyRequest(account.getId(), sendUserId);

		if (opt.isPresent()) {
			Request request = opt.get();
			requestRepository.delete(request);
		}

		return "redirect:/friends/list";
	}

	@PostMapping("/friend/approveRequest")
	public String approveRequest(
			@RequestParam(name = "sendUserId", defaultValue = "") Integer sendUserId,
			Model m) {

		Optional<Request> opt = requestRepository.findOnlyRequest(account.getId(), sendUserId);

		if (opt.isPresent()) {
			friendRepository.save(new Friend(account.getId(), sendUserId));
			friendRepository.save(new Friend(sendUserId, account.getId()));
			Request request = opt.get();
			requestRepository.delete(request);
		}

		return "redirect:/friends/list";
	}

}
