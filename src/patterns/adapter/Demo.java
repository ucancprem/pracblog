package patterns.adapter;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	
	public static void main(String[] args) {
		List<Customer> mergeCustomers = new ArrayList<Customer>();
		//old object that matches the interface - `Customer`
		mergeCustomers.add(new OldSchoolCustomer(1, "Customer1", "customer@hotmail.com"));  
		mergeCustomers.add(new PhoneCustomerAdapter(new PhoneCustomer(1, "PhoneGuy", "999999999")));  
		mergeCustomers.add(new OnlineCustomerAdapter(new OnlineCustomer(1, "FName", "Lname", "fname@gmail.com", "xxx-xxxx-xxxx")));
		System.out.println(mergeCustomers);
	}
}
