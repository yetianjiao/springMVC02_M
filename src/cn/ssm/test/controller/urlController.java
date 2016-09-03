package cn.ssm.test.controller;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ssm.test.po.ItemsCustom;
import cn.ssm.test.service.ItemsService;

@Controller 
@RequestMapping("/urlformat")
public class urlController {

	@Autowired
	public ItemsService itemsService;
	@RequestMapping("/itemsView/{id}")
	//表示将该位置的参数传入pathvariable指定的名称id中去
	//@PathVariable用于将请求URL中的模板变量映射到功能处理方法的参数上。
	//eg:@RequestMapping("/itemsView/{id}/{type}")
	//形参为：(@PathVariable("id") Integer id,@PathVariable("type") String X),
	//此时将指定url中第二个{}中的type赋给形参中的X
	public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id)
			throws Exception{
		return itemsService.findItemsById(id);  
	}

	
}
