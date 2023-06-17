package patterns.decorator;

public class BasicPizza implements Pizza {
	
	public String getDescription(){
		return "NY style dough";
	}
	
	public double getCost(){
		return 10.00;
	}

}
