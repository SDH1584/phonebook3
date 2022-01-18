package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value="/phone")
public class PhoneController {

	
	//필드
	//생성자
	//메소드gs
	//메소드일반
	@RequestMapping (value="/writeForm",method= {RequestMethod.GET,RequestMethod.POST})
	public String writeForm() {
		System.out.println("writeForm");
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	@RequestMapping (value="/write",method= {RequestMethod.GET,RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("write");
		
	
		PhoneDao phoneDao=new PhoneDao();
		phoneDao.personInsert(personVo);
		
		System.out.println(personVo);
		
		
		//redirect
		
		return "redirect:/phone/list";
	}
	
	@RequestMapping (value="/list",method= {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model) {
		System.out.println("list");
		
		PhoneDao phoneDao=new PhoneDao();
		List<PersonVo> personList=phoneDao.getPersonList();
		System.out.println(personList.toString());
			
		model.addAttribute("personList",personList);
			
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping(value="/update",method= {RequestMethod.GET,RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("update");
	
		PhoneDao phoneDao=new PhoneDao();
		phoneDao.personUpdate(personVo);
		System.out.println(personVo);
		
		return "redirect:/phone/list";
	}
	
	@RequestMapping(value="/updateForm",method= {RequestMethod.GET,RequestMethod.POST})
	public String updateForm(@ModelAttribute("personId")int peorsnId, Model model) {
		System.out.println("updateForm");

		PersonVo personVo = new PhoneDao().getPerson(peorsnId);

		model.addAttribute("personVo", personVo);

		return "/WEB-INF/views/updateForm.jsp";
	}
	
	@RequestMapping (value="/delete",method= {RequestMethod.GET,RequestMethod.POST})
	public String delete(@RequestParam("person_id") int personId) {
		System.out.println("delete");
		PhoneDao phoneDao= new PhoneDao();
		phoneDao.personDelete(personId);
		System.out.println(personId);
		
		return "redirect:/phone/list";
	}
	
}
