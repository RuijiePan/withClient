/*
package auto.newsky.coding.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import auto.newsky.coding.service.IUser;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
    private IUser userImpl;
	
	@RequestMapping("modifyPassword")
	public String modifyPassword(HttpSession session) throws Exception {
		// 判断session
		// 从session中取出用户身份信息
		User user_session = (User) session.getAttribute("User");
		if (user_session != null) {
			// 身份存在，放行
			return "password/modifyPassword";
		}
		return "login";
	}
	
	@RequestMapping("modifyedPassword")
	public @ResponseBody
	Result modifyedPassword(Integer userId,String old_password,String new_password)
			throws Exception {
		return userImpl.modifyPasswordByUserId(userId, old_password, new_password);
	}

	@RequestMapping("login")
	public String login(HttpSession session) throws Exception {
		// 判断session
		// 从session中取出用户身份信息
		User user_session = (User) session.getAttribute("User");

		if (user_session != null) {
			// 身份存在，放行
			return "main";
		}
		return "login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) throws Exception {
		// 判断session
		session.invalidate();
		return "login";
	}
	
	@RequestMapping("logined")
	public String logined(@Validated @ModelAttribute("user") User user,BindingResult result, HttpSession session,Model model) throws Exception {
		// 从session中取出用户身份信息
		User user_session = (User) session.getAttribute("User");
		if (user_session != null) {
			// 身份存在，放行
			return "main";
		}
		
		if(result.hasErrors()){
			model.addAttribute("errors", result);
			return "login";
		}
		
		//数据库中的用户对象
		User u = userImpl.findUserByUserName(user.getUserName());
		
		if(u == null){
			result.addError(new ObjectError("defaultMessage", "用户不存在！"));
			model.addAttribute("errors", result);
			return "login";
		}else{
			if(u.getPassword().equals(user.getPassword())){
				session.setAttribute("User",u);
				return "main";
			}else{
				result.addError(new ObjectError("defaultMessage", "密码错误！"));
				model.addAttribute("errors", result);
				return "login";
			}
		}
	}

	 @RequestMapping("main")
	 public ModelAndView main() throws Exception{
		 return new ModelAndView("main");
	 }
	
	
	*/
/**
	 * 404页
	 *//*

	@RequestMapping("error/404")
	public String error404() {
		return "error/404";
	}

	*/
/**
	 * 405页
	 *//*

	@RequestMapping("error/unauthorized")
	public String unauthorized() {
		return "error/unauthorized";
	}

	*/
/**
	 * 500页
	 *//*

	@RequestMapping("error/500")
	public String error500() {
		return "/error/500";
	}

}
*/
