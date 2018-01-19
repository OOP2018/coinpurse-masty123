package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoneyUtil  {
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
	
	static void sortCoins(List<Coin> coins){
		java.util.Collections.sort( coins );
	}
	
	private static void printCoins(List<Coin> coins) {
		for (Coin c : coins){
			System.out.println(c.toString());
		}
		
	}
	
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
