package coinpurse;


/**
* Coin represents coinage (money) with a fixed value and currency.
* @author Theeruth Borisuth
*/
public class Coin extends Money  {
	/**
	 * A banknote with given value and serialNumber.
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency){
		super(value, currency);

	}
	/**a message of coin.
	 * @return  value and the currency of the coin.
	 */
	public String toString(){
		return String.format("%.2f-%s", getValue(), getCurrency());
	}

	
}
