package com.example.demo.controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalenderController {
	@GetMapping("calender")
	public String index(Model m,
			@RequestParam(name = "nowYear", required=false)String nowYear,
			@RequestParam(name = "nowMonth", required=false)String nowMonth,
			@RequestParam(name = "prevOrNext", required=false)String prevOrNext
			) {

		// 現在時刻を取得
		LocalDate day = LocalDate.now();
		
		// 「yyyy年MM月」の形に変更
		YearMonth yyyyMM = YearMonth.of(day.getYear(), day.getMonth());
		
		// 「yyyy年MM月」の初日（一日）
		LocalDate firstDate = LocalDate.of(day.getYear(), day.getMonth(), 1);
		
		// 初日の曜日を調べる（Sunday: 1 Monday: 2 ... Saturday: 7）
		int dayOfWeek = firstDate.getDayOfWeek().getValue();
		if (dayOfWeek == 7) {
			dayOfWeek = 1;
		}else {
			dayOfWeek++;
		}

		//　その月が何日まであるか調べる
		int lom = yyyyMM.lengthOfMonth();

		// カレンダーで日付がない日を０として、３５日分リストに入れる
		List<Integer> list = new ArrayList<>();

		int j = 1;
		for (int i = 1; i <= 35; i++) {
			if (i < dayOfWeek) {
				list.add(0);
				continue;
			}

			if (j > lom) {
				list.add(0);
			} else {
				list.add(j++);
			}
		}
		
		
		m.addAttribute("dayList", list);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月");
		m.addAttribute("yearMonth", yyyyMM.format(dtf));

		return "calender";
	}

}
