package patterns.adapter;

public class OldSchoolCustomer implements Customer {
	
	private int id;
	private String name;
	private String email;
	
	public OldSchoolCustomer(int id, String name, String email){
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	
	public String toString(){
		return String.format("%d, %s, %s",id, name, email);
	}

}
