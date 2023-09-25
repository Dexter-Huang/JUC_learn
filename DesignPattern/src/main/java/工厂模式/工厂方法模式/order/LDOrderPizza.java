package 工厂模式.工厂方法模式.order;


import 工厂模式.工厂方法模式.pizza.LDCheesePizza;
import 工厂模式.工厂方法模式.pizza.LDPepperPizza;
import 工厂模式.工厂方法模式.pizza.Pizza;

public class LDOrderPizza extends OrderPizza {


	@Override
	Pizza createPizza(String orderType) {

		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new LDCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new LDPepperPizza();
		}
		// TODO Auto-generated method stub
		return pizza;
	}

}
