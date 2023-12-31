package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Icon;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.IconRepository;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileController {

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	UserRepository userRepository;

	@Autowired
	IconRepository iconRepository;

	@GetMapping("/profile")
	public String profile(Model m) {

		//アカウント情報表示用
		User user = userRepository.findById(account.getId()).get();
		m.addAttribute("user", user);

		//プロフィールアイコン表示用
		Icon icon = iconRepository.findById(user.getIconId()).get();
		m.addAttribute("icon", icon.getIconUrl());
		
		return "profile";
	}

	//名前変更用メソッド
	@PostMapping("/profile/edit/name")
	public String editNmae(Model m,
			@RequestParam(name = "name", defaultValue = "") String name) {

		List<String> error = new ArrayList<>();
		User user = userRepository.findById(account.getId()).get();
		Icon icon = iconRepository.findById(user.getIconId()).get();
		
		//名前のエラーチェック
		if (name.equals("") == true) {
			error.add("名前は1文字以上で記入してください");
		}
		if (name.length() > 9) {
			error.add("名前は9文字以内です");
		}
		if (error.size() > 0) {
			m.addAttribute("error", error);
		} else {
			//エラーがなければ変更
			userRepository.save(new User(account.getId(), icon.getId(), name, user.getEmail(), user.getPassword()));
			account.setName(name);
		}
		m.addAttribute("icon", icon.getIconUrl());
		m.addAttribute("user", user);

		return "profile";
	}

	//メールアドレス変更用メソッド
	@PostMapping("/profile/edit/email")
	public String editEmail(Model m,
			@RequestParam(name = "email", defaultValue = "") String email) {

		List<String> error = new ArrayList<>();
		User user = userRepository.findById(account.getId()).get();
		Icon icon = iconRepository.findById(user.getIconId()).get();

		//メールアドレスのエラーチェック
		if (email.equals("") == true) {
			error.add("メールアドレスは1文字以上で記入してください");
		} else if (!isMailAddress(email)) {
			error.add("メールアドレスを入力してください");
		} else if (userRepository.findByEmail(email).isPresent()) {
			error.add("登録済みのメールアドレスです");
		}
		if (error.size() > 0) {
			m.addAttribute("error", error);
		} else {
			//エラーがなければ変更
			userRepository.save(new User(account.getId(), icon.getId(), user.getName(), email, user.getPassword()));
		}
		m.addAttribute("icon", icon.getIconUrl());
		m.addAttribute("user", user);

		return "profile";
	}

	//パスワード変更用メソッド
	@PostMapping("/profile/edit/password")
	public String editPassword(Model m,
			@RequestParam(name = "password", defaultValue = "") String password) {

		List<String> error = new ArrayList<>();
		User user = userRepository.findById(account.getId()).get();
		Icon icon = iconRepository.findById(user.getIconId()).get();

		//パスワードのエラーチェック
		if (password.equals("") == true) {
			error.add("パスワードは1文字以上で記入してください");
		}
		
		if (error.size() > 0) {
			m.addAttribute("error", error);
		} else {
			//エラーがなければ変更
			userRepository.save(new User(account.getId(), icon.getId(), user.getName(), user.getEmail(), password));
		}
		m.addAttribute("icon", icon.getIconUrl());
		m.addAttribute("user", user);

		return "profile";
	}

	//アイコンリスト表示用メソッド
	@PostMapping("/profile/iconList")
	public String IconList(Model m) {

		List<Icon> icons = iconRepository.findAll();
		m.addAttribute("icons", icons);

		User user = userRepository.findById(account.getId()).get();
		m.addAttribute("user", user);

		return "iconList";
	}

	//アイコン変更用メソッド
	@GetMapping("/profile/edit/icon/{icon_id}")
	public String editIcon(Model m,
			@PathVariable("icon_id") Integer icon_id) {

		// ログインしているアカウントのアカウント情報
		User user = userRepository.findById(account.getId()).get();
		// アイコンURLをIDから検索
		Icon icon = iconRepository.findById(icon_id).get();
		// 変更したアイコン情報の保存
		userRepository.save(new User(user.getId(), icon.getId(), user.getName(), user.getEmail(), user.getPassword()));
		account.setIcon(icon.getIconUrl());

		return "redirect:/profile";
	}

	// メールアドレスかどうかを判定
	public static boolean isMailAddress(String value) {
		boolean result = false;
		if (value != null) {
			Pattern pattern = Pattern.compile("^([a-zA-Z0-9])+([a-zA-Z0-9._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9._-]+)+$");
			result = pattern.matcher(value).matches();
		}
		return result;
	}

}
