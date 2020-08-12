package com.zkr.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.zkr.pojo.User;
import com.zkr.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam String username,@RequestParam String password, Model model) {
		User user=new User();
		ModelAndView modelAndView = new ModelAndView();
		try{
			user = userService.login(username);
		}catch(Exception e){
			System.out.println("无此用户");
			model.addAttribute("message", "无此用户");
			modelAndView.setViewName("loginInfo");
		}

		if (user!=null) {
			if (user.getPassword().equals(password)) {
				//登录成功
				modelAndView.setViewName("redirect:/usersPage?page=1&size=10");
				return modelAndView;

			} else {
				modelAndView.addObject("message", "密码错误");
				modelAndView.setViewName("loginInfo");
				return modelAndView;
			}
		} else {
			model.addAttribute("message", "无此用户");
			modelAndView.setViewName("loginInfo");
			return modelAndView;
		}
	}



	//查询所有用户
	/*@GetMapping("/findUser")
	@ResponseBody
	public List<User> findAlarmCustom(HttpServletResponse response) {
		System.out.println("findUser");
		return userService.findUser();
	}*/

	@GetMapping("/listAll")
	public ModelAndView listAll() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<User> companys=userService.findUser();
		modelAndView.addObject("companys", companys);
		modelAndView.setViewName("user/listAll");
		return modelAndView;
	}




	//分页查询
	@GetMapping("/usersPage")
	public ModelAndView workersPage(int page,int size) {
		if(page == size)
		{
			page = 1;size = 5;
		}
		int count = userService.findUser().size();
		int num = (count-1)/size+1;
		List<User> listWorker = userService.findByPage(page, size);
		ModelAndView modelAndView = new ModelAndView();
		if(listWorker == null || listWorker.isEmpty())
		{
			modelAndView.setViewName("index");
		}else{
			modelAndView.setViewName("user/listAll");
			modelAndView.addObject("companys", listWorker);
			modelAndView.addObject("page", page);
			modelAndView.addObject("size", size);
			modelAndView.addObject("num", num);
		}
		return modelAndView;
	}

	//新增用户信息
	@GetMapping("/toAdd")
	public ModelAndView toAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("user/addUserInfo");
		return modelAndView;
	}
	@PostMapping("/addUser")
	public ModelAndView addUser(HttpServletResponse response,User user) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int success=userService.addUser(user);
		System.out.println("success:"+success);
		//		modelAndView.setViewName("redirect:/listAll");
		modelAndView.setViewName("redirect:/usersPage?page=1&size=10");
		return modelAndView;
	}


	//修改用户信息
	@GetMapping("/toUpd")
	public ModelAndView toUpd(int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView();


		User user = userService.findUserById(id);
		modelAndView.addObject("company", user);
		modelAndView.setViewName("user/updUserInfo");
		return modelAndView;
	}
	@PutMapping("/updateUser")
	@ResponseBody
	public ModelAndView updateUser(HttpServletResponse response,User user) {
		ModelAndView modelAndView = new ModelAndView();
		userService.updateUser(user);
		//		modelAndView.setViewName("redirect:/listAll");
		modelAndView.setViewName("redirect:/usersPage?page=1&size=10");
		return modelAndView;
	}

	//删除用户信息
	@DeleteMapping("/deleteUser")
	@ResponseBody
	public int deleteUser(HttpServletResponse response, int id) {
		return userService.deleteUser(id);
	}
}
