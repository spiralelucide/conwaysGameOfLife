package com.spiraledlogic.web.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SolutionController{
	
	@RequestMapping(value="/solution", method=RequestMethod.GET)
	public String displaySolution(HttpServletRequest request, ModelMap model){
		request.setAttribute("Width", model.get("width"));
		request.setAttribute("height", model.get("height"));
		request.setAttribute("board", model.get("board"));
		request.setAttribute("oldboard", model.get("oldboard"));
		return "solution";
	}
}