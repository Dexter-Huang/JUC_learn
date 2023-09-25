package 工厂模式.工厂方法模式.order;


import 工厂模式.工厂方法模式.pizza.BJCheesePizza;
import 工厂模式.工厂方法模式.pizza.BJPepperPizza;
import 工厂模式.工厂方法模式.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {


	@Override
	Pizza createPizza(String orderType) {

		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new BJCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new BJPepperPizza();
		}
		// TODO Auto-generated method stub
		return pizza;
	}

}
