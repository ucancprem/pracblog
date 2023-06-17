package patterns.adapter;

public class OnlineCustomerAdapter implements Customer {

	private OnlineCustomer onlineCustomer;
	
	public OnlineCustomerAdapter(OnlineCustomer onlineCustomer){
		this.onlineCustomer = onlineCustomer;
	}
	
	@Override
	public int getId() {
		return onlineCustomer.getId();
	}

	@Override
	public String getName() {
		return String.format("%s %s", onlineCustomer.getFirstName(), onlineCustomer.getLastName());
	}

	@Override
	public String getEmail() {
		return onlineCustomer.getEmail();
	}
	
	public String toString(){
		return String.format("%d, %s, %s",getId(), getName(), getEmail());
	}

}
