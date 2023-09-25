package 工厂模式.抽象工厂模式.order;


import 工厂模式.抽象工厂模式.pizza.BJCheesePizza;
import 工厂模式.抽象工厂模式.pizza.BJPepperPizza;
import 工厂模式.抽象工厂模式.pizza.Pizza;

//这是工厂子类
public class BJFactory implements AbsFactory {

	@Override
	public Pizza createPizza(String orderType) {
		System.out.println("~使用的是抽象工厂模式~");
		// TODO Auto-generated method stub
		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new BJCheesePizza();
		} else if (orderType.equals("pepper")){
			pizza = new BJPepperPizza();
		}
		return pizza;
	}

}
