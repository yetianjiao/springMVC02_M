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
public interface ItemsService {
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) 
			throws Exception;
}
