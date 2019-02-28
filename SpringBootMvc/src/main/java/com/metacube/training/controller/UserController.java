package com.metacube.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.User;
import com.metacube.training.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	//object will be initialize from bean using @Autowired  
	@Autowired
	private UserService userService;
	
	/*
	 * @param m Model type
	 * @return  "user/add" 
	 * 
	 * getting request from welcome.jsp page for add user
	 * calling add.jsp page
	 * */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		m.addAttribute("x",new User());
		return "user/add";
	}
	
	
	/*
	 * @param user
	 * @return  "redirect:/user/all" calling @RequestMapping( value ="user/all" GET) in this calss
	 * 
	 * getting request from add.jsp page for adding user
	 * After adding user in database redirecting page to showing list of all user
	 * 
	 * */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(User user) {
		userService.add(user);
		return "redirect:/user/all";
	}
	
	/*
	 * @param userId id of user
	 * @return  ModelAndView which is setting list of user i.e. Model an view both
	 * 
	 * getting request for edit user with user id
	 * 
	 * 
	 * */
	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public ModelAndView get( @PathVariable("userId") Integer userId) {
		User user = userService.get(userId);
		
		//will show edit.jsp page, first param "user" is variable which is using in edit.jsp file ,second param user which is declared in method
		return new ModelAndView("user/edit", "user",user);
	}
	
	
	/*
	 * @param user
	 * @return "redirect:/user/all" redirecting for showig list
	 * 
	 * 
	 * */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(User user) {
		userService.update(user);
		return "redirect:/user/all";
	}
	
	/*
	 * @return  "user/search" will call search.jsp page
	 * */
	@RequestMapping(value="search",method = RequestMethod.GET)
	public String search() {
		return "user/search";
	}
	
	
	/*
	 * @param searchUserBy, by which info user searching will happen
	 * @param userInfo,userInfo like phone number or firstName etc
	 * @return ModelAndView which is calling all.jsp page
	 * 
	 * 
	 * */
	@RequestMapping(value="/searchBy",method = RequestMethod.POST)
	public ModelAndView searchBy(@RequestParam("searchUserBy")String searchUserBy,@RequestParam("userInfo")String userInfo) {
		List<User> users = userService.searchBy(searchUserBy,userInfo);
		//first @param "users" which is variable using in all.jsp page
		return new ModelAndView("user/all", "users", users);
	}

	/*
	 * @return ModelAndView which is calling all.jsp page
	 *  */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getAll() {
		List<User> users = userService.getAll(); 
		//first @param "users" which is variable using in all.jsp page
		return new ModelAndView("user/all", "users", users);
	}
	
	/*
	 * @param employeeId, 
	 * @return "redirect:/user/all" which will call all.jsp page
	 * 
	 * */
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public String delete(@PathVariable("userId") Integer employeeId) {
		userService.delete(employeeId);
		return "redirect:/user/all";
	}

}
