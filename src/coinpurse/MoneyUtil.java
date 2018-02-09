package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
/**
 * Some Money utility methods filtering the currency of the coin and sorting coins
 * @author Theeruth Borisuth
 */
public class MoneyUtil  {
	/**
	 * Method that examines all the coins in a List and returns only the coins
	 * that have a currency that matches the parameter value.
	 * 
	 * @param coinlist
	 *            is a List of Coin objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @throws IllegalArgumentException
	 *             if currency is null.
	 * @return a new List containing only the elements from coinlist that have
	 *         the requested currency.
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> coinlist, String currency) {
		if (currency == null) {
			throw new IllegalArgumentException("Currency cannot be null");
		}
		List<Valuable> temp = new ArrayList<Valuable>();
		for (Valuable c : coinlist) {
			if (c.getCurrency().equalsIgnoreCase(currency)) {
				temp.add(c);
			}
		}
		return temp;
	}
	/**
	 * This method's purpose is only use to sort the coin by using the Collections.sort
	 * @param coins : An object called coin.
	 */
	static void sortCoins(List<Valuable> coins){
		Collections.sort(coins, new Comparator<Valuable>(){

			@Override
			public int compare(Valuable v1, Valuable v2) {
				if (v1.getValue() < v2.getValue()) return -1;
				else if (v1.getValue() > v2.getValue()) return 1;
				return 0;
			}
			
		}); printCoins(coins);

	}
	/**
	 * This method is use for printing coins.
	 * @param coins
	 */
	static void printCoins(List<Valuable> coins) {
		for (Valuable c : coins){
			System.out.println(c.toString());
		}
	}
	/**
	 * For checking Coin class.
	 * @param args
	 */
	public static void main(String[] args) {
//		List<Valuable> coins = new ArrayList<Valuable>( );
//		coins.add( new Coin(10.0, "Baht") );
//		coins.add( new Coin(0.5, "Baht") );
//		coins.add( new Coin(2.0, "Baht") ); 
//		coins.add( new Coin(1.0, "Baht") );
//		printCoins( coins ); // the coins should be sorted by value now
		Purse p = new Purse(5);
		p.insert(new Coin(10,"Baht"));
		p.insert(new Coin(5, "b"));
		p.insert(new Coin(1, "a"));
		p.insert(new Coin(5, "Baht"));
//		filterByCurrency(p.getMoney(), "Baht");
//		sortCoins(filterByCurrency(p.getMoney(), "Baht"));
//		Money m1 = new Coin(0.000001,"Baht");
//		Money m2 = new BankNote(10000,"Rupee");
//		Money m3 = new BankNote(100,"Baht");
//		BankNote m4 = new BankNote(100,"Baht");
//		System.out.println(m1.equals(m2));
//		System.out.println(m2.equals(m3));
//		System.out.println(m3.equals(m4));
//		System.out.println(m2);
//		System.out.println(m3);
		p.withdraw(new Money(1, "a"));
		System.out.println(p.toString());
	}
}
