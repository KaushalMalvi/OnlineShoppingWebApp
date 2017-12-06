package com.ksm.OnlineShoppingTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping (value = {"/","/index","/home"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
	//	mv.addObject("message", "Welcome To My Web Page..");
		return mv;
	}
	
	//Request Param is use in url with (key,value) pair
	//In our project url is -http://localhost:8085/OnlineShoppingTest/test?hello=hi
	
	/*@RequestMapping(value = {"/test"})
	public ModelAndView index(@RequestParam(value="hello",required=false)String hi) {

		ModelAndView mv = new ModelAndView("page");
			
		if(hi==null) {
				
			hi = "Bye";
		}
		
		mv.addObject("message", hi);
		return mv;
	} 
*/	

	//Path variable is use for make url clean and SEO friendly 
	//Using it can make url dynemic
	
	/*@RequestMapping(value = {"/test/{hello}"})
	public ModelAndView index(@PathVariable(value="hello",required=false)String hi) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("message", hi);
		return mv;
	} 
*/
}
