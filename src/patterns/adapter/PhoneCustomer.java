package patterns.adapter;

public class PhoneCustomer {
	
	private int id;
	private String name;
	private String phone;
	
	public PhoneCustomer(int id, String name, String phone){
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getPhone() {
		// TODO Auto-generated method stub
		return phone;
	}
	
	public String toString(){
		return String.format("%d, %s, %s",id, name, phone);
	}

}
