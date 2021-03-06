package auto.newsky.coding.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * 
 * <p>Title: CustomExceptionResolver</p>
 * <p>Description:全局异常处理器</p>
 * <p>Company: www.newsky.auto</p> 
 * @author	徐新宇
 * @version 1.0
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	/**
	 * <p>Title: resolveException</p>
	 * <p>Description: </p>
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex 系统 抛出的异常
	 * @return
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		CustomException customException = null;
		try {
			ex.printStackTrace();
			response.getWriter().write(ex.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(ex instanceof CustomException){
			customException = (CustomException)ex;
		}else{
			customException = new CustomException("未知错误");
		}
		
		//错误信息
		String message = customException.getMessage();
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		//将错误信息传到页面
		modelAndView.addObject("message", message);
		
		//指向错误页面
		modelAndView.setViewName("error/error");
		return modelAndView;
	}

}
