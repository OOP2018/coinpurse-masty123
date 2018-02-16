package coinpurse;

public class MoneyFactoryDemo {
	
	public static void main(String[] args) {
		MoneyFactory mf = MoneyFactory.getInstance();
		Purse p = new Purse(5);
		p.insert(mf.createMoney(0.25));
		p.insert(mf.createMoney(1));
		p.insert(mf.createMoney(50));
		p.insert(mf.createMoney(0.5));
		p.insert(mf.createMoney(20));
		for (Valuable money : p.getMoney()) {
				System.out.println(money);
		}
		System.out.println("--------------------");

		
	}
}
