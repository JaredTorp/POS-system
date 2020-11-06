package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

/**
 * A Cashier is an object that represents a cashier and their data
 */
public class Cashier
{

	/**
	 * A Cashier has a specific number (maybe an ID)
	 */
	private String number;
	/**
	 * A Cashier will have a password
	 */
	private String password;
	/**
	 * A cashier will know about a Person
	 */
	private Person person;
	/**
	 * a cashier knows about the session
	 */
	private ArrayList<Session> sessions;

	public String getNumber()
	{
		return this.number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Person getPerson()
	{
		return this.person;
	}

	public void setPerson(Person person)
	{
		this.person = person;
	}

	public ArrayList<Session> getSessions()
	{
		return this.sessions;
	}

	/**
	 * Default constructor for the Cashier Class
	 */
	public Cashier()
	{
		this.number = "";
		this.password = "";
		this.person = new Person();
		sessions = new ArrayList<Session>();
	}

	/**
	 * Constructor with parameters for the Cashier Class
	 * @param number pass the number for the Cashier
	 * @param person Pass the Person for the Cashier
	 * @param password Pass the Password of the Cashier
	 */
	public Cashier(String number, Person person, String password)
	{
		this();
		this.number = number;
		this.person = person;
		person.setCashier(this);
		this.password = password;
	
	}

	/**
	 * Method will add a session
	 * @param session
	 * @param parameter Pass the session that we want to add
	 */
	public void addSession(Session session)
	{
		sessions.add(session);
	}

	/**
	 * This method will remove the session from the arraylist
	 * @param session Pass the session that we want to remove
	 */
	public void removeSession(Session session)
	{
		sessions.remove(session);
	}

	/**
	 * This method will check the password if it lines up with their actual password
	 * @param password we pass the string of the password to be checked
	 * @return Boolean will return if the cashier is authorized or not
	 */
	public boolean isAuthorized(String password)
	{
		boolean authorized = false;
		if(this.getPassword().equals(password))
		{
			authorized = true;
		}
		
		return authorized;
	}

	/**
	 * toString function of the Cashier class
	 */
	public String toString()
	{
		return this.getNumber() + " " + person.getName();
	
	
	}

	public BigDecimal getSalesForDate(LocalDate date) {

		BigDecimal total = new BigDecimal("0.00");
		
		for (Session s : this.getSessions())
		{
			if(date.equals(s.getStartDateTime().toLocalDate()))
					{
						total = total.add(s.totalSales());
					}
		}
		
		return total;
		
	}

	public int getSalesCountForDate(LocalDate date) 
	{
		
		int total = 0;
		
		for (Session s : this.getSessions())
		{
			if((date.equals(s.getStartDateTime().toLocalDate())))
					{
						total = total + s.getSalesCount();
					}
		}
		
		return total;
	}

	
	public BigDecimal getDifferenceForDate(LocalDate date)
	{
		BigDecimal total = new BigDecimal("0.00");
		
		for (Session s : this.getSessions())
		{
			if((date.equals(s.getStartDateTime().toLocalDate())))
					{
						total = total.add(s.getDifference());
					}
		}
		
		return total;
	}

}