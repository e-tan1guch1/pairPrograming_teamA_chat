package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Chat;
import com.example.demo.entity.Friend;
import com.example.demo.entity.Icon;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.model.UserForDisplay;
import com.example.demo.repository.ChatRepository;
import com.example.demo.repository.FriendRepository;
import com.example.demo.repository.IconRepository;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChatController {

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	ChatRepository chatRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FriendRepository friendRepository;

	@Autowired
	IconRepository iconRepository;

	@GetMapping("/chat")
	public String chat(
			Model m) {

		ArrayList<String> demo = new ArrayList<String>();

		demo.add(new String("ここにメッセージが表示されます"));
		demo.add(new String("左のリストから送信先を選択して、 チャットを始めよう！"));

		//自分以外の連絡先を取得
		List<User> userList = userRepository.findAllOrderByNameAsc();
		List<UserForDisplay> addressList = new ArrayList<>();
		List<UserForDisplay> friendList = new ArrayList<>();

		
		// パスワードを抜いたリストを作成
		for (User user : userList) {
			//icon_idからicon_urlを取得しリストに追加する
			Icon icon = iconRepository.findById(user.getIconId()).get();
			if (user.getId() != account.getId()) {
				addressList.add(new UserForDisplay(user.getId(), user.getName(), user.getEmail(), icon.getIconUrl()));
			}
		}
		//フレンドリスト取得
		//自分とフレンドの人のユーザIdを含むレコード一覧
		List<Friend> friendListNumber = friendRepository.findFriend(account.getId());

		for (Friend friendNumber : friendListNumber) {
			//自分とフレンドの人のユーザIdからユーザ情報を取得
			Optional<User> opt = userRepository.findById(friendNumber.getUser2Id());
			if (opt.isPresent()) {
				User user = opt.get();
				Icon icon = iconRepository.findById(user.getIconId()).get();
				friendList.add(new UserForDisplay(user.getId(), user.getName(), user.getEmail(), icon.getIconUrl()));
			}
		}

		for (UserForDisplay address : friendList) {
			if (friendList.contains(address)) {
				addressList.remove(address);
			}
		}
		
		m.addAttribute("addressName", "チャットアプリ君");
		m.addAttribute("addressList", addressList);
		m.addAttribute("demo", demo);
		m.addAttribute("friends", friendList);

		return "Chat";

	}

	@PostMapping("/chat/add")
	public String add(
			Model m,
			@RequestParam(name = "text", defaultValue = "") String text,
			@RequestParam(name = "addressId", defaultValue = "") Integer addressId) {

		System.out.println("addressId:" + addressId);
		LocalDateTime timeNow = LocalDateTime.now();

		if (!text.equals("")) {
			chatRepository.save(new Chat(account.getId(), text, addressId, timeNow));
		}

		if (addressId == null) {
			return "redirect:/chat";
		} else {
			return "redirect:/chat/" + addressId;
		}
	}

	// 宛先ごとのチャット履歴表示
	@GetMapping("/chat/{addressId}")
	public String chatEachUser(
			@PathVariable("addressId") Integer addressId,
			Model m) {

		// 個人チャットの履歴を検索
		List<Chat> chats = chatRepository.findEachChat1(account.getId(), addressId);
		List<Chat> chats2 = chatRepository.findEachChat2(account.getId(), addressId);
		chats.addAll(chats2);

		// チャット履歴を時間でソート
		Collections.sort(
				chats,
				new Comparator<Chat>() {
					@Override
					public int compare(Chat obj1, Chat obj2) {
						if (obj2.getDate().isBefore(obj1.getDate())) {
							return 1;
						} else {
							return -1;
						}
					}
				});

		//自分以外の連絡先を取得
		List<User> userList = userRepository.findAllOrderByNameAsc();
		List<UserForDisplay> addressList = new ArrayList<>();
		List<UserForDisplay> friendList = new ArrayList<>();
		for (User user : userList) {
			if (user.getId() != account.getId()) {
				Icon icon = iconRepository.findById(user.getIconId()).get();
				addressList.add(new UserForDisplay(user.getId(), user.getName(), user.getEmail(), icon.getIconUrl()));
			}
		}
		//フレンドリスト取得
				//自分とフレンドの人のユーザIdを含むレコード一覧
				List<Friend> friendListNumber = friendRepository.findFriend(account.getId());

				for (Friend friendNumber : friendListNumber) {
					//自分とフレンドの人のユーザIdからユーザ情報を取得
					Optional<User> opt = userRepository.findById(friendNumber.getUser2Id());
					if (opt.isPresent()) {
						User user = opt.get();
						Icon icon = iconRepository.findById(user.getIconId()).get();
						friendList.add(new UserForDisplay(user.getId(), user.getName(), user.getEmail(), icon.getIconUrl()));
					}
				}

				for (UserForDisplay address : friendList) {
					if (friendList.contains(address)) {
						addressList.remove(address);
					}
				}

		m.addAttribute("addressId", addressId);
		m.addAttribute("addressName", userRepository.findById(addressId).get().getName());
		m.addAttribute("chats", chats);
		m.addAttribute("addressList", addressList);
		m.addAttribute("friends", friendList);

		return "Chat";
	}

	@GetMapping("/chat/{addressId}/reload")
	public String reload(
			@PathVariable("addressId") Integer addressId,
			Model m) {

		System.out.println("更新");
		return "redirect:/chat/" + addressId;
	}

	@PostMapping("chat/{chatId}/delete")
	public String delete(
			@PathVariable("chatId") Integer chatId,
			@RequestParam("addressId") Integer addressId,
			Model m) {
		
		chatRepository.deleteById(chatId);

		return "redirect:/chat/" + addressId;
		//		return "redirect:/chat/"+  ;
	}

	@PostMapping("/chat/{addressId}/like_button")
	public String like(
			@RequestParam("id") Integer id,
			@RequestParam("userId") Integer userId,
			@RequestParam("text") String text,
			@PathVariable("addressId") Integer addressId,
			@RequestParam("date") LocalDateTime date,
			@RequestParam(name = "likeButton", defaultValue = "false") Boolean likeButton,
			Model m) {

		chatRepository.save(new Chat(id, userId, text, addressId, date, likeButton));

		return "redirect:/chat/" + userId;
	}

}
