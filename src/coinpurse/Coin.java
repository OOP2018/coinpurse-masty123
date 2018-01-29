package coinpurse;


/**
* Coin represents coinage (money) with a fixed value and currency.
* @author Theeruth Borisuth
*/
public class Coin implements Valuable {
	private double value;
	String currency;
	
	Coin(double value, String currency){
			this.value = value ;
			this.currency = currency;

	}
	/**
	 * Get the value of the coin
	 * @return value
	 */
	public double getValue(){
		return this.value;
	}
	/**
	 * Get the currency of the coin.
	 * @return
	 */
	public String getCurrency(){
		return this.currency;
	}
	/**
	 * Check if the value of the coins are equal.
	 * @return true if the object are equal.
	 * @return false if the object are not equal.
	 */
	public boolean equals(Object obj){
		if (obj.getClass() != this.getClass() || obj == null){
			return false;
		}
		Valuable coins = (Valuable) obj;
		return this.getValue() == coins.getValue() && this.getCurrency().equals(coins.getCurrency());
	}
	/**
	 * Compare the value of 2 coins.
	 * @return int of compareTo method.
	 */
	public int compareTo(Valuable coin){
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
	/**a message of coin.
	 * @return  value and the currency of the coin.
	 */
	public String toString(){
		return String.format("%.2f-%s", this.value, this.currency);
	}

	
}
