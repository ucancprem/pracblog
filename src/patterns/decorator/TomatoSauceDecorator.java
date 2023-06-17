package patterns.decorator;

public class TomatoSauceDecorator extends PizzaDecorator {

	public TomatoSauceDecorator(Pizza pizza) {
		super(pizza);
	}
	
	public String getDescription(){
		return pizzaDecorator.getDescription() + " + Tomato Sauce";
	}
	
	public double getCost(){
		return pizzaDecorator.getCost() + 2.00;
	}

}
