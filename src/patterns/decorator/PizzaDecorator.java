package patterns.decorator;

public abstract class PizzaDecorator implements Pizza {
	
	protected Pizza pizzaDecorator;
	
	public PizzaDecorator(Pizza pizza){
		this.pizzaDecorator = pizza;
	}
	
	public String getDescription(){
		return pizzaDecorator.getDescription();
	}
	
	public double getCost(){
		return pizzaDecorator.getCost();
	}
}
