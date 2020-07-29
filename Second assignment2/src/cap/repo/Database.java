package cap.repo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cap.bean.Customer;
import cap.bean.Items;



public class Database {
	public Map<Integer,Customer> mapcust;
	public Map<Integer,Items> mapitem;
	public Set<Integer> empid;
	public Set<Integer> affilid;
	
	public Database()
	{
		mapcust=new HashMap<Integer,Customer>();
		//customer with affiliate id
		Customer c=new Customer();
		c.setCustid(1);
		c.setCustname("vinyas");
		c.setAffid(600);
		c.setPeriod("2019-04-12");
		mapcust.put(c.getCustid(),c);
		//customer of 2019 period
		Customer c5=new Customer();
		c5.setCustid(5);
		c5.setCustname("bellam");
		c5.setAffid(0);
		c5.setPeriod("2019-04-12");
		mapcust.put(c5.getCustid(),c5);
		//customer of 2017 period
		Customer c2=new Customer();
		c2.setCustid(3);
		c2.setCustname("tharanath");
		c2.setAffid(0);
		c2.setPeriod("2017-04-23");
		mapcust.put(c2.getCustid(),c2);
		//customer is an employee
		Customer c3=new Customer();
		c3.setCustid(500);
		c3.setCustname("dhoni");
		c3.setAffid(0);
		c3.setPeriod(null);
		mapcust.put(c3.getCustid(),c3);
		mapitem=new HashMap<Integer,Items>();
		//not grocery
		Items item1=new Items();
		item1.setItemid(1000);
		item1.setItemname("kitkat");
		item1.setPrice(20);
		item1.setType("ng");
		mapitem.put(item1.getItemid(), item1);
		// grocery
		Items item2=new Items();
		item2.setItemid(2000);
		item2.setItemname("carrot");
		item2.setPrice(30);
		item2.setType("g");
		mapitem.put(item2.getItemid(), item2);
		
		empid=new HashSet();
		empid.add(500);
		empid.add(501);
		
		affilid=new HashSet();
		affilid.add(600);
		affilid.add(601);
		
	}
}