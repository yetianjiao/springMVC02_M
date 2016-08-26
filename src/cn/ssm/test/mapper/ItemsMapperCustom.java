package cn.ssm.test.mapper;

import java.util.List;

import cn.ssm.test.po.ItemsCustom;
import cn.ssm.test.po.ItemsQueryVo;

public interface ItemsMapperCustom {
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) 
    		throws Exception;
}