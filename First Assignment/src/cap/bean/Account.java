package cap.bean;

import cap.dao.Dao;
import cap.dao.DaoImpl;

public class Account {
	Dao dao=new DaoImpl();
	private String accountid;
	private String accountname;
	private String address;
	private Double depositAmount;

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Account getDetails(String accountId, Account accounts[]) {
		return(dao.getDetails(accountId,accounts));
	}

	public void showDetails(String accountId, Account accounts[]) {
		Account demo=new Account();
		demo.getDetails(accountId,accounts);

	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", accountname=" + accountname + ", address=" + address
				+ ", depositAmount=" + depositAmount + "]";
	}

}


