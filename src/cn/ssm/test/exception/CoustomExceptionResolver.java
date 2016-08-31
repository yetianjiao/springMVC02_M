package cn.ssm.test.exception;

/**
 * 全局异常处理器
 * @param handler是处理器适配器要执行的handler对象
 * @param ex系统抛出的异常
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CoustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, 
			Object handler,Exception ex) {
		// 解析异常，通过判断异常类型实现
		// 如果该异常类型是系统 自定义的异常，直接取出异常信息，在错误页面展示
		CustomException customException=null;
		if (ex instanceof CustomException) {
			customException=(CustomException)ex;
		} else {
		// 如果该异常类型不是系统 自定义的异常，则构建一个自定义的异常，在错误页面展示"未知错误"
			customException=new CustomException("未知错误");
		}
		String message=customException.getMessage();
		ModelAndView mv=new ModelAndView();
		mv.addObject("message", message);
		mv.setViewName("error");
		
		return mv;
	}

}
