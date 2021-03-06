package coinpurse;
/**
 * Factory class to create malay money object.
 * @author Theeruth Borisuth
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	private String currency = "Ringgit";
	private String subCurrency = "Sen";
	/**
	 * Create a Malaysia money.
	 * @param value - value of a Malaysia money
	 * @return Valuable object of Malaysia money
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable malaymoney = null ;
		if (isCoin(value)) malaymoney = new Coin(value,currency,subCurrency);
		else if (isBankNote(value)) malaymoney = new BankNote(value,currency,nextSerialNumber++);
		else throw new NumberFormatException("Invalid input Please try again...");
		return malaymoney;
	}
	/**
	 * Check if value can be consider as Malaysia coin.
	 * @param value - value that you want to check
	 * @return true if it is Malaysia coin, false if it is not
	 */
	public boolean isCoin(double value){
		return (value == 0.05 || value == 0.5 || value == 0.1 || value == 0.2);	
	}
	/**
	 * Check if value can be consider as Malaysia BankNote.
	 * @param value - value that we want to check
	 * @return true if it is Malaysia BankNote, false if it is not
	 */
	public boolean isBankNote(double value){
		return (value == 1 || value == 2 || value == 5  || value == 10 || value == 20 || value == 50 || value == 100) ;
	}
	
	/**
	 * @return currency of MalayMoneyFactory.
	 */
	@Override
	public String getCurrency() {
		return currency;
	}
	/**
	 * @return subCurrency of MalayMoneyFactory.
	 */
	@Override
	public String getSubCurrecy() {
		return subCurrency;
	}
}
