/**
 * 
 */
package cn.ssm.test.po;

import cn.ssm.test.mapper.ItemsMapperCustom;

/**
 * @author Yetianjiao
 *商品包装对象
 *vo：表现层，该对象可以从表现层一直传到持久层
 */
public class ItemsQueryVo {
	//商品信息
	private  Items items;
	//商品信息扩展类
	private ItemsCustom itemscustom;
	
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public ItemsCustom getItemscustom() {
		return itemscustom;
	}
	public void setItemscustom(ItemsCustom itemscustom) {
		this.itemscustom = itemscustom;
	}

}
