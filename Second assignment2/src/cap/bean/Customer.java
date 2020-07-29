package cap.bean;

public class Customer {
	private Integer custid;
	private String period;
	private String custname;
	private Integer affid;
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public Integer getAffid() {
		return affid;
	}
	public void setAffid(Integer affid) {
		this.affid = affid;
	}
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", period=" + period + ", custname=" + custname + ", affid=" + affid
				+ "]";
	}
	
}