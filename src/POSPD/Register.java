package POSPD;

/**
 * Register class represents a register in the store
 */
public class Register
{

	/**
	 * A Register has a specific number bound to it
	 */
	private String number;
	/**
	 * A Register has a CashDrawer
	 */
	private CashDrawer cashDrawer;

	public String getNumber()
	{
		return this.number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public CashDrawer getCashDrawer()
	{
		return this.cashDrawer;
	}

	public void setCashDrawer(CashDrawer cashDrawer)
	{
		this.cashDrawer = cashDrawer;
	}

	/**
	 * The default constructor for the Register
	 */
	public Register()
	{
		this.number = "";
		this.cashDrawer = new CashDrawer();
	}

	/**
	 * The constructor with parameters for the Register class
	 * @param number We pass the number of the specific register
	 */
	public Register(String number)
	{
		this();
		this.number = number;
	}

	/**
	 * The toString function of the Register Class
	 */
	public String toString()
	{
		return this.getNumber();
	}

}