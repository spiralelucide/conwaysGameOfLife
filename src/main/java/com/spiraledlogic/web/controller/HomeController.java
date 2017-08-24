package com.spiraledlogic.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spiraledlogic.web.model.ConwayGameOfLife;

@Controller
@SessionAttributes({"width","height","board", "oldboard"})
public class HomeController{
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String displayHome() {
		return "home";
	}
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String displaySolution(@RequestParam Integer height, @RequestParam Integer width, @RequestParam Double probability, ModelMap model) {
		model.addAttribute("width",width);
		model.addAttribute("height",height);
		ConwayGameOfLife cgol = new ConwayGameOfLife(height,width,probability);
		Boolean[][] nextGeneration = cgol.generateNextState();
		model.addAttribute("oldboard",cgol.getGameboard());
		model.addAttribute("board", nextGeneration);
		return "redirect:/solution";
	}
}