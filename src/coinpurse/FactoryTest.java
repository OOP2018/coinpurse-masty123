package coinpurse;

import java.util.ResourceBundle;
/**
 * This class's purpose is only for testing .
 * @author Theeruth Borisuth
 *
 */
public class FactoryTest {
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String classFactory = bundle.getString("moneyfactory");
		MoneyFactory factory = null;

		try {
			factory = (MoneyFactory) Class.forName(classFactory).newInstance();
		} catch (ClassCastException e) {
			System.out.println(classFactory + " is not type MoneyFactory");
		} catch (Exception e) {
			System.out.println("Error creating MoneyFactory " + e.getMessage());
		}
		
		if (factory == null)
			System.exit(1);
		else
			MoneyFactory.setMoney(factory);
		
	
		//FOR TESTING ONLY
		Purse p = new Purse(100);
		p.insert(factory.createMoney(0.5));
		p.insert(factory.createMoney(5));
		p.insert(factory.createMoney(10));
		p.insert(factory.createMoney(20));
		p.insert(factory.createMoney(50));		
		p.insert(factory.createMoney(100));
		p.insert(factory.createMoney("1000"));
		for(Valuable value : p.getMoney()) {
			System.out.println(value);
		}
	}
}
