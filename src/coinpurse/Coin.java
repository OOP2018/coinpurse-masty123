package coinpurse;

import java.util.List;

/**
* Coin represents coinage (money) with a fixed value and currency.
* @author Theeruth Borisuth
*/
public class Coin implements Comparable<Coin> {
	private double value;
	String currency;
	
	Coin(double value, String currency){
		if(value > 0){
			this.value = value ;
			this.currency = currency;
		}
		
		else {System.out.println("value invalid");}
	}
	
	double getValue(){
		return value;
	}
	
	String getCurrency(){
		return currency;
	}
	
	public boolean equals(Object obj){
		if (obj.getClass() != this.getClass() || obj == null){
			return false;
		}
		Coin coins = (Coin) obj;
		return this.getValue() == coins.getValue() && this.currency == coins.getCurrency();
	}
	
	public int compareTo(Coin coin){
		if(this.value < coin.getValue()){
			return -1;
		}
		else if(this.value > coin.getValue()){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	public static void printCoins(List<Coin> coins) {
		for (int i = 0 ; i < coins.size() - 1 ;i++){
			System.out.println(coins.indexOf(i));		
		}	
	}
	
	public String toString(){
		return String.format("%.2f-%s", value, currency);
	}	
}
