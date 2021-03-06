package cn.ssm.test.mapper;

import java.util.List;

import cn.ssm.test.po.Items;
import cn.ssm.test.po.ItemsCustom;
import cn.ssm.test.po.ItemsQueryVo;

public interface ItemsMapperCustom {
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) 
    		throws Exception;

	public void deleteItemsQuery(String[] names);
	
	int insert(Items record);
}