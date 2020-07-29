package cap.bean;

public class Items {
	private Integer itemid;
	private String itemname;
	private String type;
	private Integer price;
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Items [itemid=" + itemid + ", itemname=" + itemname + ", type=" + type + ", price=" + price + "]";
	}
	
	

}