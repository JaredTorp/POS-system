package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Sale class represents the sale being made at the register
 */
public class Sale
{

	/**
	 * A sale will have a Date and Time
	 */
	private LocalDateTime dateTime;
	/**
	 * A Sale will know if it is tax free
	 */
	private Boolean taxFree;
	/**
	 * A Sale will know the Payment of the specific sale
	 */
	private ArrayList<Payment> payments;
	/**
	 * The sale knows about the array of saleLineItems
	 */
	private ArrayList<SaleLineItem> saleLineItems;

	public LocalDateTime getDateTime()
	{
		return this.dateTime;
	}

	public void setDateTime(LocalDateTime dateTime)
	{
		this.dateTime = dateTime;
	}

	public Boolean getTaxFree()
	{
		return this.taxFree;
	}

	public void setTaxFree(Boolean taxFree)
	{
		this.taxFree = taxFree;
	}

	public ArrayList<SaleLineItem> getSaleLineItems()
	{
		return saleLineItems;
	}
	public ArrayList<Payment> getPayments()
	{
		return payments;
	}
	
	
	
	/**
	 * The default constructor for a sale
	 */
	public Sale()
	{
		this.taxFree = false;
		payments = new ArrayList<Payment>();
		saleLineItems = new ArrayList<SaleLineItem>();
		this.dateTime = (LocalDateTime.now());
		
	}

	/**
	 * The constructor with parameters
	 * @param taxFree We pass if the sale is taxfree
	 */
	public Sale(String taxFree)
	{
		//come back to this
		this();
		if (taxFree.toLowerCase().equals("y"))
		{
			this.taxFree = true;
		}
		else 
		{
			this.taxFree = false;
		}
	
		
	}

	/**
	 * This method adds a payment of the sale
	 * @param payment We pass the payment to add it
	 */
	public void addPayment(Payment payment)
	{
		payments.add(payment);
	}

	/**
	 * This function removes the payment from the sale
	 * @param payment We pass the payment to be removed
	 */
	public void removePayment(Payment payment)
	{
		payments.remove(payment);
	}

	/**
	 * This function adds a saleLineItem
	 * @param sli We pass the SaleLineItem to be added
	 */
	public void addSaleLineItem(SaleLineItem sli)
	{
		saleLineItems.add(sli);
	}

	/**
	 * This method removed the SaleLineItem from the sale
	 * @param sli we pass the salelineitem to be removed
	 */
	public void removeSaleLineItem(SaleLineItem sli)
	{
		saleLineItems.remove(sli);
	}

	/**
	 * This method calculates the total of the sale
	 * @return This will return the total of the sale
	 */
	public BigDecimal calcTotal()
	{
		return this.calcSubTotal().add(this.calcTax());
	}

	/**
	 * This method will calculate the subtotal of the sale
	 * @return returns the subtotal as a BigDecimal
	 */
	public BigDecimal calcSubTotal()
	{
		BigDecimal subtotal = new BigDecimal("0.00");
		for (SaleLineItem sli: this.getSaleLineItems())
		{
			subtotal = subtotal.add(sli.calcSubTotal());
		}
		return subtotal;
	}

	/**
	 * This method calculates the tax
	 * @return This method returns the tax
	 */
	public BigDecimal calcTax()
	{
		BigDecimal taxtotal = new BigDecimal("0.00");
		if (!this.getTaxFree())
		{
			for (SaleLineItem sli: this.getSaleLineItems())
			{
				taxtotal = taxtotal.add(sli.calcTax());
			}
		}
		
		return taxtotal;	
	}

	/**
	 * This method calculates and returns the total payment of the sale
	 * @return returns the total payment
	 */
	public BigDecimal getTotalPayments()
	{
		BigDecimal total = new BigDecimal("0.00");
		for (Payment payment : this.getPayments())
		{
			total = total.add(payment.getAmount());
		}
		
		return total;
	}

	/**
	 * This method checks to see if the payment is enough
	 * @return reutrns true or false if the sale is enough
	 */
	public Boolean isPaymentEnough()
	{
		boolean enough = false;
		if (this.calcTotal().compareTo(this.getTotalPayments()) <= 0.00)
		{
			enough = true;
		}
		
		return enough;
	}

	/**
	 * This method Calculates the amount
	 * @param amTendered We pass the amount tendered
	 */
	
	//do this for each calc amount
	public BigDecimal calcAmount(BigDecimal amTendered)
	{
		BigDecimal amount;
		if(amTendered.compareTo(this.calcTotal().subtract(this.getTotalPayments())) <= 0.00)
		{
			amount = amTendered;
		}
		else
		{
			amount = this.calcTotal().subtract(this.getTotalPayments());
			
		}
		return amount;
	}

	/**
	 * This method calculates how much change to give back to the customer
	 * @return Returns the the change
	 */
	public BigDecimal calcChange()
	{
		
		return this.calcAmtTendered().subtract(this.calcTotal());
	}

	/**
	 * This method calculates the amount tendered
	 * @return returns the amount tendered
	 */
	public BigDecimal calcAmtTendered()
	{
		BigDecimal total = new BigDecimal("0.00");
		for (Payment payment : this.getPayments())
		{
			total = total.add(payment.getAmtTendered());
		}
		
		return total;
	}

	/**
	 * The toString function for the Sale class
	 */
	public String toString()
	{
		return "Sale: " + "Subtotal = " + this.calcSubTotal() + " Tax = " + this.calcTax() + " Total: " + this.calcTotal() + "Payment: " + this.getTotalPayments() + "Change: " + this.calcChange();
	}

	public BigDecimal getTotalCash() {
		BigDecimal total = new BigDecimal("0.00");
		
		for (Payment payment : this.getPayments())
		{
			if (payment instanceof Cash)
			{
				total = total.add(payment.getAmount());
			}
		}
		
		return total;
	}

	public BigDecimal getTotalCheck() {
	BigDecimal total = new BigDecimal("0.00");
		
		for (Payment payment : this.getPayments())
		{
			if (payment instanceof Check)
			{
				total = total.add(payment.getAmount());
			}
		}
		
		return total;
	}

	public BigDecimal getTotalCredit() {
	BigDecimal total = new BigDecimal("0.00");
		
		for (Payment payment : this.getPayments())
		{
			if (payment instanceof Credit)
			{
				total = total.add(payment.getAmount());
			}
		}
		
		return total;
	}
}