package coinpurse;

import java.text.DecimalFormat;

/**
* Coin represents coinage (money) with a fixed value and currency.
* @author Theeruth Borisuth
*/
public class Coin extends Money  {
	String denominator;
    double exchange ;
	/**
	 * A coin with given value using the default currency.
	 * @param value
	 */
	public Coin( double value ) {
		super(value, "Baht");
	}
	/**
	 * A banknote with given value and serialNumber.
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency){
		super(value, currency);
	}
	/**
     * Create a coin with denomination
     * @param value - value of a coin with currency
     * @param currency - currency of a coin
     * @param denomination - currenct's different denomination of a coin
     * @param exchange - ratio to exchange from main currency to different denomination
     */
    public Coin(double value, String currency, String denomination, double exchange) {
    	super( value, currency);
    	this.denominator = denomination;
    	this.exchange = exchange;
    }
	/**a message of coin.
	 * @return  value and the currency of the coin.
	 */
	public String toString(){
		if(currency.equals("Ringgit")) return String.format("%.2f - %s coin", value , "Sen");
		return String.format("%.2f - %s coin", value, currency);
	}

	
}
