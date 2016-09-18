
package auto.newsky.coding.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auto.newsky.coding.po.User;
import auto.newsky.coding.serviceImpl.UserImpl;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * <p>Title: HandlerInterceptor1</p>
 * <p>Description:登陆认证拦截器 </p>
 * <p>Company: www.newsky.auto</p> 
 * @author	徐新宇
 * @version 1.0
 */

public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private UserImpl userService;
	//进入 Handler方法之前执行
	//用于身份认证、身份授权
	//比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	//return false表示拦截，不向下执行
	//return true表示放行
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		//获取请求的url
		String url = request.getRequestURI();
		//判断url是否是公开 地址（实际使用时将公开 地址配置配置文件中）
		//这里公开地址是登陆提交的地址


		User user = null;
		user = new User();
		user.setUserId(1);
		//User user = userService.getUserByToken(request.getParameter("token"));
		if (user == null){//token 不匹配，没登录
			request.setAttribute("myUserId",-1);
		}else{//登录了的直接进入
			request.setAttribute("myUserId",user.getUserId());
			return true;
		}

          //不管有没有登录都可以访问的公开接口
		if(url.indexOf("invitation/getInvitations")>=0){
			//如果获取邀约列表，放行
			return true;
		}else if(url.indexOf("user/login")>=0){
			//如果进行登陆，放行
			return true;
		}else if(url.indexOf("user/registerVertification")>=0){
			//如果注册验证，放行
			return true;
		}else if(url.indexOf("user/getVertificationCode")>=0){
			//如果获取验证码，放行
			return true;
		}else if(url.indexOf("user/register")>=0){
			//如果注册，放行
			return true;
		}else if(url.indexOf("user/findBackPassWord")>=0){
			//如果找回密码，放行
			return true;
		}

		//既没登录，访问的也不是公开接口，不许访问
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String errorJson = "{\"code\":401,\"msg\":\"用户未登录\"}";
		response.getWriter().write(errorJson);//new Gson().toJson(new )
		return false;
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//System.out.println("LoginInterceptor...postHandle");
		
	}

	//执行Handler完成执行此方法
	//应用场景：统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		//System.out.println("LoginInterceptor...afterCompletion");
	}

}

