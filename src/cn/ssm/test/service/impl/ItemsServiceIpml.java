package cn.ssm.test.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.xml.internal.bind.v2.model.core.ID;

import cn.ssm.test.mapper.ItemsMapper;
import cn.ssm.test.mapper.ItemsMapperCustom;
import cn.ssm.test.po.Items;
import cn.ssm.test.po.ItemsCustom;
import cn.ssm.test.po.ItemsQueryVo;
import cn.ssm.test.service.ItemsService;

public class ItemsServiceIpml implements ItemsService {
	//mapper自动注入,在spring/applicationContext-dao.xml中已经设置了自动扫描
	@Autowired
		private ItemsMapperCustom itemsMapperCustom;
	@Autowired
		private ItemsMapper itemsmapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) 
			throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(int id) throws Exception {
		Items items=itemsmapper.selectByPrimaryKey(id);
		//考虑到程序的扩展性
		//对商品信息进行处理，最终返回处理后的东西而不是原始数据库的内容
		//本例没有进行处理，只是简单的吧items的内容赋给itemsCustom
		ItemsCustom itemsCustom=new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	public void updateitems(Integer id, ItemsCustom itemsCustom) throws Exception {
		//业务校验，通常是在service接口对关键参数进行校验
		//校验id是否为空吗，为空抛出异常，此处略
		//……
		//更新商品信息
		//(1)updateByPrimaryKeyWithBLOBs:根据id跟新所有的字段，包括大文本类型，
		//故必须传入id，以确保准确性
		itemsCustom.setId(id);
		itemsmapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
		//
	}

	@Override
	public void deleteItemsQuery(String[] names) {
		itemsMapperCustom.deleteItemsQuery(names);
	}
	
//	使用逆向生成的ItemsMapper
//	@Override
//	public void insertItems(ItemsCustom itemsCustom) {
//		Items items=new Items();
//		BeanUtils.copyProperties(itemsCustom, items);
//		System.out.println("items"+items);
//		System.out.println("itemscustom"+itemsCustom);
//		int i=itemsmapper.insert(items);
//		System.out.println(~~~~~~~~~~~~~~i);
//	}
	
	//使用自己定义的ItemsMapperCustem
	@Override
	public void insertItems(ItemsCustom itemsCustom) {
		Items items=new Items();
		BeanUtils.copyProperties(itemsCustom, items);
		System.out.println("items"+items);
		System.out.println("itemscustom"+itemsCustom);
		int i=itemsMapperCustom.insert(items);
		System.out.println(~~~~~~~~~~~~~~i);
	}

}
