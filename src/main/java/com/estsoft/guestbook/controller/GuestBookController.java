package com.estsoft.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.estsoft.guestbook.domain.Guestbook;
import com.estsoft.guestbook.service.GuestBookService;


@Controller
@RequestMapping("")
public class GuestBookController {

	@Autowired
	private GuestBookService guestbookService;

	@RequestMapping("/")
	public String list(Model model) {
		List<Guestbook> list = guestbookService.getList();
		model.addAttribute("list", list);

		return "index";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String add(@ModelAttribute Guestbook guestbook) {
		
		guestbookService.add(guestbook);					
		return "redirect:/";
	}

	@RequestMapping("/deleteform")
	public String deleteform(@RequestParam(value = "no", required = true, defaultValue = "") int no,Model model) {

//		ModelAndView mav = new ModelAndView();
//		mav.addObject("no", no);
//		mav.setViewName("deleteform");
//		return mav;

		model.addAttribute("no", no);
		return "deleteform";
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam(value = "no", required = true, defaultValue = "") int no,
			@RequestParam(value = "password", required = true, defaultValue = "") String password) {
		ModelAndView mav = new ModelAndView();

		// 성공하면 list, 실패하면 deletefail
		Boolean ret = guestbookService.delete(no, password);

		if (ret) { // 성공
			mav.setViewName("redirect:/");
		} else { // 실패
			mav.addObject("no", no);
			mav.setViewName("deletefail");
		}

		return mav;
	}

}
