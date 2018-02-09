package coinpurse;

public class Money implements Valuable {

	protected double value;
	protected String currency;

	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Get the value of the coin
	 * @return value of the coin
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of the coin.
	 * @return currency of the coin
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Check if the value of the coins are equal.
	 * @return true if the object are equal.
	 * @return false if the object are not equal.
	 */
	public boolean equals(Object obj) {
		if (obj.getClass() != this.getClass() || obj == null){
			return false;
		}
		Valuable coins = (Valuable) obj;
		return this.getValue() == coins.getValue() && this.getCurrency().equals(coins.getCurrency());
	}

	/**
	 * Compare the value of 2 coins.
	 * @return Integer of compareTo method.
	 */
	public int compareTo(Valuable money) {
		if(this.getCurrency().equals(money.getCurrency())){
			if(this.value < money.getValue()) return -1;
			if(this.value > money.getValue()) return 1;
			else return 0;
		}
		return this.getCurrency().compareToIgnoreCase(money.getCurrency());
	}

}