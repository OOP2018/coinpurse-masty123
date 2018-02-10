package coinpurse;

import java.util.ResourceBundle;

public class TestFactory {
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory factory = null;

		// get the actual money factory.
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException e) {
			System.out.println(factoryclass + " is not type MoneyFactory");
		} catch (Exception e) {
			System.out.println("Error creating MoneyFactory " + e.getMessage());
		}
		if (factory == null)
			System.exit(1);
		else
			MoneyFactory.setMoney(factory);
		
		
		
		
		
		//FOR TESTING ONLY
		Purse p = new Purse(100);
		p.insert(factory.createMoney(10));
		p.insert(factory.createMoney(1));
		p.insert(factory.createMoney(50));
		p.insert(factory.createMoney(5));
		p.insert(factory.createMoney(20));
		p.insert(factory.createMoney(100));
		p.insert(factory.createMoney("1000"));
		for(Valuable money : p.getMoney()) {
			System.out.println(money);
		}
	}
}
