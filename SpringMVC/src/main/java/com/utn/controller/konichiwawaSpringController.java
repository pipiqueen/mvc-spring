package com.utn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		@RequestMapping("holausuario/{nombre}/{apellido}")
		public ModelAndView holaUsuario (@PathVariable("nombre") String nombre,
										 @PathVariable("apellido") String apellido) {
											
			ModelAndView mv2 = new ModelAndView();
			
			mv2.addObject("SaludosConNombre", "Este es un saludo para: " +nombre + " " +apellido);
			mv2.setViewName("holaConNombre");
			
			return mv2;
			
		}
		
}
