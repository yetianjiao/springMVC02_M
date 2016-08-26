package cn.ssm.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.ssm.test.po.ItemsCustom;
import cn.ssm.test.service.ItemsService;


/**
 * 
 * @author Yetianjiao
 * 控制器
 */

@Controller
public class ItemsController {
	@Autowired
	public ItemsService itemsService;
	//商品查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception{
			// 调用service查找数据库，查询商品列表，此处用静态数据模拟
			List<ItemsCustom> itemsList = itemsService.findItemsList(null);
			
			//返回modleandview
			ModelAndView mv =new ModelAndView();
			//相当于request的setAttribut，在jsp页面通过itemsList取值
			mv.addObject("itemsList", itemsList);
			
			//指定视图
			mv.setViewName("items/itemsList");
			
			return mv;
	}
}
