package patterns.adapter;

public class PhoneCustomerAdapter implements Customer {

	private PhoneCustomer phoneCustomer;
	
	public PhoneCustomerAdapter(PhoneCustomer phoneCustomer){
		this.phoneCustomer = phoneCustomer;
	}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return phoneCustomer.getId();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return phoneCustomer.getName();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return "N/A";
	}
	
	public String toString(){
		return String.format("%d, %s, %s",getId(), getName(), getEmail());
	}

}
