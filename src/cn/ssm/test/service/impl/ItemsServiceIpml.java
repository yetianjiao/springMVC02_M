package cn.ssm.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ssm.test.mapper.ItemsMapper;
import cn.ssm.test.mapper.ItemsMapperCustom;
import cn.ssm.test.po.ItemsCustom;
import cn.ssm.test.po.ItemsQueryVo;
import cn.ssm.test.service.ItemsService;
@Service
public class ItemsServiceIpml implements ItemsService {
	//mapper自动注入,在spring/applicationContext-dao.xml中已经设置了自动扫描
	@Autowired
		private ItemsMapperCustom itemsMapperCustom;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) 
			throws Exception {
		// TODO Auto-generated method stub
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

}
