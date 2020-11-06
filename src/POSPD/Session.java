package POSPD;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * The Session is an object that knows about the specific session of a transaction
 */
public class Session
{

	/**
	 * Session will have a specific Register
	 */
	private Register register;
	/**
	 * The session will have a specific start time of that particular session
	 */
	private LocalDateTime startDateTime;
	/**
	 * The session has a specific end time for when the session is complete
	 */
	private LocalDateTime endDateTime;
	/**
	 * Session will know about a particular sale of that session
	 */
	private ArrayList<Sale> sales;
	/**
	 * A session will have a cashier who made the session
	 */
	private Cashier cashier;
	
	private BigDecimal Difference;
	
	private int salesCount;

	public Register getRegister()
	{
		return this.register;
	}

	public void setRegister(Register register)
	{
		this.register = register;
	}

	public LocalDateTime getStartDateTime()
	{
		return this.startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime)
	{
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime()
	{
		return this.endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime)
	{
		this.endDateTime = endDateTime;
	}

	public ArrayList<Sale> getSales()
	{
		return this.sales;
	}



	public Cashier getCashier()
	{
		return this.cashier;
	}

	public void setCashier(Cashier Cashier)
	{
		this.cashier = Cashier;
	}

	/**
	 * Default constructor of the Session class
	 */
	public Session()
	{
		sales = new ArrayList<Sale>();
	}

	/**
	 * The session has a constructor with parameters
	 * @param cashier We pass the cashier
	 * @param register we pass the specific register
	 */
	public Session(Cashier cashier, Register register)
	{
		this();
		this.cashier = cashier;
		this.register = register;
	}

	/**
	 * Addsale will add the specific sale of the session
	 * @param sale We pass the sale to be added
	 */
	public void addSale(Sale sale)
	{
		sales.add(sale);
	}

	/**
	 * Remove sale will remove the specific sale
	 * @param sale we pass the sale we want to remove
	 */
	public void removeSale(Sale sale)
	{
		sales.remove(sales);
	}

	/**
	 * I think this method detects the difference of the register count and the drawer count?
	 * @param cash
	 */
	public BigDecimal calcCashCountDiff(BigDecimal cash)
	{
		return cash.subtract(this.getRegister().getCashDrawer().getCashAmount());
	}

	/**
	 * The toString method of the Session
	 */
	public String toString()
	{
		return "Session: " + "Cashier:  " + this.getCashier().getPerson().getName() + " Register: " + this.getRegister().getNumber();
	}

	//this method adds up all the sales made in the session
	public BigDecimal totalSales() 
	{
		BigDecimal total = new BigDecimal(0.00);
		for (Sale sale : this.getSales())	
		{
			total = total.add(sale.calcTotal());
		}
		return total;
	}




	public int getSalesCount() {
		return salesCount;
	}

	public void setSalesCount(int salesCount) {
		this.salesCount = salesCount;
	}

	public BigDecimal getDifference() {
		return Difference;
	}

	public void setDifference(BigDecimal difference) {
		Difference = difference;
	}

}