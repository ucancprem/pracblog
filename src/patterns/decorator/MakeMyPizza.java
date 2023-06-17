package patterns.decorator;

public class MakeMyPizza {

	public static void main(String[] args) {
		Pizza pizza = new MozerralDecorator(new TomatoSauceDecorator(new BasicPizza()));
		System.out.println(pizza.getDescription());
		System.out.println(pizza.getCost());
	}
}
