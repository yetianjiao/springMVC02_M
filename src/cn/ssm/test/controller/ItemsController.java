package cn.ssm.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.ssm.test.po.ItemsCustom;
import cn.ssm.test.service.ItemsService;

/**
 * 
 * @author Yetianjiao
 * 控制器
 */

@Controller
@RequestMapping("/items")
//窄化请求映射为了对url进行分类管理，可以在这里定义根路径，
//之前是:http://localhost:8080/springMVC02_M/queryItems.action
//现在是http://localhost:8080/springMVC02_M/iterms/queryItems.action
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
	
	//商品信息修改页面
	//@RequestMapping("/editItems")
	
	
	/**
	 * controller返回方法1
	 * 返回视图：方法内指定视图的内容和url
	 * @return ModelAndView
	 * @throws Exception
	 */
//@RequestMapping(value="/editItems",method={RequestMethod.GET,RequestMethod.POST})	
//	public ModelAndView editItems() throws Exception{
//		
//		//调用service根据id查询
//		ItemsCustom itemsCustom=itemsService.findItemsById(1);
//		ModelAndView mv=new ModelAndView();
//		mv.addObject(itemsCustom);
//		mv.setViewName("items/editItems");
//		return mv;
//	}

	/**
	 * controller返回方法2
	 * 返回视图的url
	 * @return String
	 * @throws Exception
	 */
@RequestMapping(value="/editItems",method={RequestMethod.GET,RequestMethod.POST})

	//	为使用@RequestParam，此时的id和jsp页面的id必须对应
	//	public String editItems(Model model,Integer id) throws Exception{

	//@RequestParam 若形参跟jsp页面参数不一致可以通过value设置，
	//此外，还可以通过defaultvalue指定默认值，当没有id传入的时候，将默认值和形参绑定
	//也可以设置required=true限定id必须有值传入，否则页面报400错误
	public String editItems(Model model,
			@RequestParam(value="id",defaultValue="1") Integer items_id) throws Exception{
		ItemsCustom itemsCustom=itemsService.findItemsById(items_id);
		//通过形参中的model将model数据传到页面
		//等价于ModelAndView.addObject(itemsCustom);
		model.addAttribute(itemsCustom);
		//返回视图
		return "items/editItems";
	}
	
	/**
	 * controller返回方法3
	 * 无返回值
	 * @throws Exception
	 */
//	@RequestMapping(value="/editItems",method={RequestMethod.GET,RequestMethod.POST})
//	public void editItems(HttpServletRequest request,HttpServletResponse response) 
//			throws Exception{
//		ItemsCustom itemsCustom=itemsService.findItemsById(1);
//		request.setAttribute("itemsCustom", itemsCustom);
//		request.getRequestDispatcher("/WEB-INF/jsp/items/editItems.jsp").forward(request, response);
//	}
	
	//商品修改信息提交
//	@RequestMapping("/editItemsSubmit")
//	public ModelAndView editItemsSubmit() throws Exception{
//		//调用service更新商品信息，页面将页面信息
//		//返回视图view
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("success");
//		return mv;
//		}

@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Integer id,ItemsCustom itemsCustom) throws Exception{
//		重定向至商品展示页面，浏览器地址栏中的url会变化。
//		修改提交的request数据无法传到重定向的地址。因为重定向后重新进行request（request无法共享）
//		redirct提交
		
		itemsService.updateitems(id, itemsCustom);
		return "redirect:queryItems.action";
	
	}
}
