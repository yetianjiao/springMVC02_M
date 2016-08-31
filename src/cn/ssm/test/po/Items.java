package cn.ssm.test.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cn.ssm.test.validateGroup.ValidateGroup1;
import cn.ssm.test.validateGroup.ValidateGroup2;

public class Items {
    private Integer id;
    //校验名称1~30中间
    @Size(min=1,max=30,message="{items.name.length.error}"
    		,groups={ValidateGroup1.class,ValidateGroup2.class})
    private String name;

    private Float price;

    private String pic;
    //校验输入日期不为空
    @NotNull(message="{items.createtime.idNull}"
    		,groups={ValidateGroup1.class})
    private Date createtime;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Items [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", createtime=");
		builder.append(createtime);
		builder.append(", detail=");
		builder.append(detail);
		builder.append("]");
		return builder.toString();
	}
    
}