package patterns.adapter;

public class OnlineCustomer {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String creditCard;
	
	public OnlineCustomer(int id, String firstName, String lastName, String email, String creditCard){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creditCard = creditCard;
	}

	public int getId() {

		return id;
	}

	public String getFirstName() {

		return firstName;
	}

	public String getLastName() {

		return lastName;
	}
	
	public String getEmail() {

		return email;
	}
	
	public String getCreditCard() {
		return creditCard;
	}
	
	
	public String toString(){
		return String.format("%d, %s, %s, %s,%s",id, firstName, lastName, email, creditCard);
	}

}
