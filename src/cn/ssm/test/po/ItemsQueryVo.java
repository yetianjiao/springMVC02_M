/**
 * 
 */
package cn.ssm.test.po;

import java.util.List;

/**
 * @author Yetianjiao
 *商品包装对象
 *vo：表现层，该对象可以从表现层一直传到持久层
 */
public class ItemsQueryVo {
	//商品信息
	private  Items items;
	//商品信息扩展类
	private ItemsCustom itemsCustom;
	//批量商品信息
	private List<ItemsCustom> itemsList;
	
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}
	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}
}
