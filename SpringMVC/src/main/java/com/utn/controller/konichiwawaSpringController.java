package com.utn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class konichiwawaSpringController {

		@RequestMapping("konichiwawaSpring")
		public ModelAndView knochiwawaSpring(){
			ModelAndView mv = new ModelAndView();
			mv.addObject("chiwawa", "Hola Worldwide Xd");
			mv.setViewName("konichiwawa");
			
			
			return mv;
			
		}
		
}
