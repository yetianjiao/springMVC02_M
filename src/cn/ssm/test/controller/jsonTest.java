package cn.ssm.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ssm.test.po.ItemsCustom;

/**
 * jason交互测试
 * @author Yetianjiao
 *
 */
@Controller
public class jsonTest {
	
	//请求json(商品信息)，返回json(商品信息)
	//@ResponseBody、@RequestBody表示接收到和响应的均为json
	@RequestMapping("requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom)
	{
		return itemsCustom;
	}
	
	@RequestMapping("responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom)
	{
		return itemsCustom;
	}
}
