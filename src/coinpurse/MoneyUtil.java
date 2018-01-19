package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Some Money utility methods filtering the currency of the coin and sorting coins
 * @author Theeruth Borisuth
 */
public class MoneyUtil  {
	/**
	 * 
	 * @param coins : is a List of Coin objects. This list is not modified.
	 * @param currency : is the currency we want. Must not be null.
	 * @throws IllegalArgumentException
	 *             if currency is null.
	 * @return a new List containing only the elements from coinlist that have
	 *         the requested currency.
	 */
	static List<Coin> filterBycurrency(List<Coin> coins,String currency){
		if (currency == null){
			throw new IllegalArgumentException("Currency cannot be null");
		}
		List<Coin> coin = new ArrayList<>();
		for (Coin cash : coin){
			if (cash.getCurrency().equalsIgnoreCase(currency)){
				coin.add(cash);
			}
		}
		return Collections.unmodifiableList(coins);
	}
	/**
	 * This method's purpose is only use to sort the coin by using the Collections.sort
	 * @param coins : An object called coin.
	 */
	static void sortCoins(List<Coin> coins){
		java.util.Collections.sort( coins );
	}
	/**
	 * This method is use for printing coins.
	 * @param coins
	 */
	private static void printCoins(List<Coin> coins) {
		for (Coin c : coins){
			System.out.println(c.toString());
		}
	}
	/**
	 * For checking Coin class.
	 * @param args
	 */
	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>( );
		coins.add( new Coin(10.0, "Baht") );
		coins.add( new Coin(0.5, "Baht") );
		coins.add( new Coin(2.0, "Baht") ); 
		coins.add( new Coin(1.0, "Baht") );
		printCoins( coins );
		printCoins( coins ); // the coins should be sorted by value now
	}
}
