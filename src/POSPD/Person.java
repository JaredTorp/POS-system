package POSPD;

/**
 * Person is an object that represents (Usually) the customer making a purchase
 */
public class Person
{

	private Cashier Cashier;
	/**
	 * Person has a name as a string
	 */
	private String name;
	/**
	 * The Person has an address saved as a string
	 */
	private String address;
	/**
	 * The person has city stored as a string
	 */
	private String city;
	/**
	 * Person has a State stored as a string
	 */
	private String state;
	/**
	 * A Person has a Zip Code as a string
	 */
	private String zip;
	/**
	 * A Person has a phone number stored as a string
	 */
	private String phone;
	/**
	 * A Person has a Social Security Number stored as a string
	 */
	private String sSN;
	/**
	 * A Person Should know about their Cashiers
	 */
	private Cashier cashier;

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return this.city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getZip()
	{
		return this.zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}

	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getSSN()
	{
		return this.sSN;
	}

	public void setSSN(String sSN)
	{
		this.sSN = sSN;
	}

	public Cashier getCashier()
	{
		return this.cashier;
	}

	public void setCashier(Cashier cashier)
	{
		this.cashier = cashier;
	}

	/**
	 * A default constructor for Person Class
	 */
	public Person()
	{
		this.name = "";
		this.address = "";
		this.city = "";
		this.state = "";
		this.zip = "";
		this.phone = "";
		this.sSN = "";
		
				
		
	}

	/**
	 * A constructor for person with all of the parameters passed
	 * @param name Pass their name
	 * @param address pass their address
	 * @param city pass their city
	 * @param state pass their state
	 * @param zip pass their zip code
	 * @param phone pass their phone number
	 * @param sSN pass their social security number
	 * @param cashier
	 */
	public Person(String name, String address, String city, String state, String zip, String phone, String sSN)
	{
		this();
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.sSN = sSN;
		
	}

	/**
	 * The toString function of the Person class
	 * @return This returns the string about the Person
	 */
	public String toString()
	{
		// TODO - implement Person.toString
		throw new UnsupportedOperationException();
	}

}