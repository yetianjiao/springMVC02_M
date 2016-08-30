package cn.ssm.test.service;

import cn.ssm.test.po.ItemsQueryVo;
import cn.ssm.test.po.ItemsCustom;
import java.util.*;
/**
 * 
 * 商品查询service
 * @author Yetianjiao
 *
 */
public interface ItemsService{
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) 
			throws Exception;
	//根据id查找商品
	public ItemsCustom findItemsById(int id) throws Exception;
	
	//根据id修改商品
	public void updateitems(Integer id,ItemsCustom itemsCustom)throws Exception;
	
	public void deleteItemsQuery(String[] names);
}
