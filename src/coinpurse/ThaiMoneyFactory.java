package coinpurse;
/**
 * Factory class to create Thai money object.
 * @author Theeruth Borisuth
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	/**
	 * Create a Thai money.
	 * @param value - value of a Thai money
	 * @return Valuable object of Thai money
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable money ;
		String currency = "Baht";
		String subCurrency = "Satang";
		if(isSatang(value)) money = new Coin(value, currency, subCurrency);
		else if(isCoin(value)) money = new Coin(value,currency);
		else if (isBankNote(value)) money = new BankNote(value, currency);
		else throw new NumberFormatException("Invalid input.. Please Try Again");
		return money;
	}
	/**
	 * Check if value can be consider as Thai coin.
	 * @param value - value that you want to check
	 * @return true if it is Thai coin, false if it is not
	 */
	public boolean isCoin(double value){
		return 	(value == 1 | value == 2 | value == 5 || value == 10) ;

	}
	/**
	 * Check if value can be consider as Thai coin that is a subCurrency called "Satang".
	 * @param value - value that you want to check
	 * @return trUe if it is  0.5,0.25 Satang.
	 */
	public boolean isSatang(double value){
		return (value == 0.5 || value == 0.25);
	}
	/**
	 * Check if value can be consider as Thai BankNote.
	 * @param value - value that we want to check
	 * @return true if it is Thai BankNote, false if it is not
	 */
	public boolean isBankNote(double value){
		return (value == 20 | value == 50 | value == 100 | value == 500 | value == 1000);
	}

}
