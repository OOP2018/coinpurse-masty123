package coinpurse;
import java.util.ResourceBundle;

/**
 * A class that used to create money object. It can choose more than 1 currency.
 * @author Theeruth Borisuth
 *
 */
public abstract class MoneyFactory {
	//Attribute for Moneyfactory
	private static MoneyFactory factory = null ;
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
			ResourceBundle bundle = ResourceBundle.getBundle("purse");
			String classFactory = bundle.getString("moneyfactory");
			
			try {
				factory = (MoneyFactory) Class.forName(classFactory).newInstance();
			} catch (ClassCastException e) {
				System.out.println(classFactory + " is not type MoneyFactory");
			} catch (Exception e) {
				System.out.println("Error creating MoneyFactory " + e.getMessage());
			}
			
			if (factory == null)
				System.exit(1);
			else
				MoneyFactory.setMoney(factory);
			
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
	public static  void setMoney(MoneyFactory difference){ factory = difference ; }
	/**
	 * Accept money value as String. If value is an invalid number throw  illegalArgumentExcepton. 
	 * @param value : value of the money as string
	 * @return return : Valuable Object.
	 */
	public Valuable createMoney(String value)
	{
		double valuable ;
		try {
		    valuable = Double.parseDouble( value );
		} catch (IllegalArgumentException E) {
		    throw new IllegalArgumentException("Sorry, it's is not a valid amount.");
		}
		return this.createMoney(valuable) ;
	}	
}

