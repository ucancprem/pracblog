package patterns.decorator;

public class MozerralDecorator extends PizzaDecorator {

	public MozerralDecorator(Pizza pizza) {
		super(pizza);
	}
	
	public String getDescription(){
		return pizzaDecorator.getDescription() + " + Mozerralla";
	}
	
	public double getCost(){
		return pizzaDecorator.getCost() + 4.00;
	}

}
