package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
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
	public static <E extends Valuable> List<E> filterByCurrency(final List<E> coinlist, String currency) {
		if (currency == null) {
			throw new IllegalArgumentException("Currency cannot be null");
		}
		List<E> temp = new ArrayList<E>();
		for (E c : coinlist) {
			if (c.getCurrency().equalsIgnoreCase(currency)) {
				temp.add(c);
			}
		}
		return temp;
	}
	/**
	 * This method's purpose is only use to sort the coin by using the Collections.sort
	 * @param money : An object called coin.
	 */
	static void sortMoney(List<? extends Valuable> money){
		Comparator<Valuable> comp = new ValueComparator();
		Collections.sort(money, comp); 
		printCoins(money);
		
	}
	/**
	 * This method is use for printing coins.
	 * @param money
	 */
	static void printCoins(List<? extends Valuable> money) {
		for (Valuable c : money){
			System.out.println(c.toString());
		}
	}
	
	/** 
	 * Return the larger argument, based on sort order, using  
	 * the objects' own compareTo method for comparing. 
	 * @param args one or more Comparable objects to compare. 
	 * @return the argument that would be last if sorted the elements. 
	 * @throws IllegalArgumentException if no arguments given. 
	 */
	public static <E extends Comparable<? super E>> E max(E ... args){
		E max  = null ;
		for (E arg : args){
		if (max == null){
			max = arg;
		} else if (arg.compareTo(max) > 0){
			max = arg;		
		 }
		}
		return max;
	}	
	
	/**
	 * For checking Coin class.
	 * @param args
	 */
	public static void main(String[] args) {

//		Purse p = new Purse(5);
//		p.insert(new Coin(10,"Baht"));
//		p.insert(new Coin(5, "b"));
//		p.insert(new Coin(1, "a"));
//		p.insert(new Coin(5, "Baht"));
//		p.withdraw(new Money(1, "a"));
//		System.out.println(p.toString());
//		Purse p = new Purse(10);
//		p.insert(new Coin(1,"Baht"));
//		p.insert(new BankNote(2,"Dollar"));
//		p.insert(new Coin(4,"Baht"));
//		p.insert(new Coin(5,"Dollar"));
//		p.insert(new Coin(8,"Baht"));
//		p.insert(new Coin(10,"Baht"));
//		p.insert(new BankNote(30,"Baht"));
//		p.withdraw(13);
//		System.out.println(p.toString());
	
		String max = MoneyUtil.max("dog", "zebra", "cat", "elephant");
		System.out.println(max);
		System.out.println("-----------------");
		
		Money m1 = new BankNote(100, "Baht");
		Money m2 = new BankNote(500, "Baht");
		Money m3 = new Coin(20, "Baht");
		Money max1 = MoneyUtil.max(m1,m2,m3);
		System.out.println(max1);
		System.out.println("-----------------");
		
		List<BankNote> list = new ArrayList<BankNote>(); 
		list.add( new BankNote(500.0, "Baht") ); 
		list.add( new BankNote(10.0, "USD") ); 
		MoneyUtil.sortMoney( list );
		System.out.println("-----------------");
		
		List<Coin> coins = Arrays.asList( new Coin(5,"Baht"), new Coin(0.1,"Ringgit"), new Coin(5,"Cent") ); 
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
		printCoins(result);
		


		
		
	}
}
