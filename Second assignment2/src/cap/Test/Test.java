package cap.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import cap.bean.Customer;
import cap.bean.Items;
import cap.repo.Database;



public class Test {

	public static void main(String[] args) throws ParseException{
		Integer totalamt=0;
		Integer nongroceryamt=0,discount=0;
		Integer groceryamt=0;
		String type=null;
	
		Scanner sc=new Scanner(System.in);
		Database db=new Database();
		System.out.println("enter the customer id");
		int customerid=	sc.nextInt();
		System.out.println("enter the total number of items");
		int totalitems=sc.nextInt();
		for(int i=0;i<totalitems;i++)
			{
				System.out.println("enter the quantity id");
				Integer quantityid=sc.nextInt();
				System.out.println("enter the number of quantities of "+quantityid);
				Integer quantitycount=sc.nextInt();
			
			if(db.mapitem.containsKey(quantityid))
			{
				Items item=db.mapitem.get(quantityid);
				
				type=item.getType();
				if(type.equalsIgnoreCase("ng")) {
					nongroceryamt=nongroceryamt+(quantitycount*item.getPrice());
				}
				else {
					groceryamt=groceryamt+(quantitycount*item.getPrice());
				}
				totalamt=nongroceryamt+groceryamt;
				System.out.println("total amount"+totalamt);
				
			}
			else {
				System.out.println("Quantity id not present");
				break;
			}
			}
		
		if(db.mapcust.containsKey(customerid)) {
			Customer customer=db.mapcust.get(customerid);
			if(db.empid.contains(customer.getCustid())) {
				discount=(nongroceryamt*30)/100;
				nongroceryamt-=discount;
				totalamt=groceryamt+nongroceryamt;
				System.out.println("total amount after discount"+(nongroceryamt+groceryamt));
				
			}
			else if(db.affilid.contains(customer.getAffid()))
			{
				discount=(nongroceryamt*10)/100;
				nongroceryamt-=discount;
				totalamt=groceryamt+nongroceryamt;
				System.out.println("total amount after discount"+(nongroceryamt+groceryamt));
			}
			else if(customer.getPeriod()!=null) {
				LocalDate presentdate=LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String firstdate = customer.getPeriod();
				LocalDate localDate = LocalDate.parse(firstdate, formatter);
				Integer difference=presentdate.compareTo(localDate);
				if(difference >=2)
					{
					discount=(nongroceryamt*5)/100;
					nongroceryamt-=discount;
					totalamt=groceryamt+nongroceryamt;
					System.out.println("total amount after discount"+(nongroceryamt+groceryamt));
					}
				else {
					discount=(nongroceryamt/100)*5;
					nongroceryamt-=discount;
					totalamt=groceryamt+nongroceryamt;
					System.out.println("total amount after discount "+(nongroceryamt+groceryamt));
					
				}
			}
		}
		else {
			System.out.println("customer is not present");
			Customer newcustomer=new Customer();
			newcustomer.setCustid(customerid);
			System.out.println("enter  new customer name");
			newcustomer.setCustname(sc.next());
			newcustomer.setAffid(0);
			newcustomer.setPeriod(LocalDate.now().toString());
			db.mapcust.put(newcustomer.getCustid(),newcustomer);
			discount=(nongroceryamt/100)*5;
			nongroceryamt-=discount;
			totalamt=groceryamt+nongroceryamt;
			System.out.println("Today's date (Period set to): "+newcustomer.getPeriod());
			System.out.println("total amount after discount "+(nongroceryamt+groceryamt));
		}
		

}
}