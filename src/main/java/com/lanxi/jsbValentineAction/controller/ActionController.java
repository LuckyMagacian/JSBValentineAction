package com.lanxi.jsbValentineAction.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanxi.jsbValentineAction.service.ActionService;
import com.lanxi.jsbValentineAction.util.AppException;

@Controller
public class ActionController {
	@Autowired
	ActionService service;
	@RequestMapping("/action.do")
	public String action(HttpServletRequest req,HttpServletResponse res){
		try {
			req.setCharacterEncoding("utf-8");
			String phone=req.getParameter("phone");
			return service.draw(phone); 
		} catch (Exception e) {
			throw new AppException("参与活动异常!",e);
		}
	}
}
