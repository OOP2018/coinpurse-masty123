package coinpurse;
import java.util.ResourceBundle;

/**
 * A class that used to create money object. It can choose more than 1 currency.
 * @author Theeruth Borisuth
 *
 */
public abstract class MoneyFactory {
	//Attribute for Moneyfactory
	private static MoneyFactory factory 	 ;
	protected static long nextSerialNumber = 1000000;
	/**
	 * Constructor
	 */
	public MoneyFactory(){}
	/**
	 * Get an instance of MoneyFactory, return object of a subclass likes ThaiMoneyFactory, MalaysiaFactory etc.
	 * @return factory : the factory that was declared.
	 */
	static MoneyFactory getInstance(){ 	
		return factory; 
	}
	/*
	 * Create new money object in the local currency if the value is invalid throw illegalArgumentExcepton.
	 */
	public abstract Valuable createMoney(double valuable);
	/**
	 *  Set type of money.
	 * @param difference : type of money
	 */
	public static  void setMoneyFactory(MoneyFactory difference){ factory = difference ; }
	/**
	 * Accept money value as String. If value is an invalid number throw  illegalArgumentExcepton. 
	 * @param value : value of the money as string
	 * @return return : Valuable Object.
	 */
	public Valuable createMoney(String value)
	{
		double valuable = 0 ;
		try {
		    valuable = Double.parseDouble( value );
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}
		return this.createMoney(valuable) ;
	}	
}

