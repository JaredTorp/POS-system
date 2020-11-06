package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Credit is a child class for authorized payment and represents the credit card payment
 */
public class Credit extends AuthorizedPayment
{

	/**
	 * A credit Card has a card type
	 */
	private String cardType;
	/**
	 * The card has an accounting number
	 */
	private String acctNumber;
	/**
	 * a card has an expiring date
	 */
	private LocalDate expireDate;

	public String getCardType()
	{
		return this.cardType;
	}

	public void setCardType(String cardType)
	{
		this.cardType = cardType;
	}

	public String getAcctNumber()
	{
		return this.acctNumber;
	}

	public void setAcctNumber(String acctNumber)
	{
		this.acctNumber = acctNumber;
	}

	public LocalDate getExpireDate()
	{
		return this.expireDate;
	}

	public void setExpireDate(LocalDate expireDate)
	{
		this.expireDate = expireDate;
	}

	/**
	 * The default constructor for the credit
	 */
	public Credit()
	{
		setAmount(new BigDecimal(0));
		setAmtTendered(new BigDecimal(0));
		setAuthorizationCode("");
		this.cardType = "";
		this.acctNumber = "";

	}

	/**
	 * The Constructor with parameters
	 * @param cardType We pass the card type
	 * @param acctNumber we pass the accounting number
	 * @param expireDate we pass the expiration date
	 */
	public Credit(String cardType, String acctNumber, String expireDate)
	{
		this.cardType = cardType;
		this.acctNumber = acctNumber;
		this.expireDate = LocalDate.parse(expireDate, DateTimeFormatter.ofPattern("M/d/yyyy"));
	}

	/**
	 * this method checks to see if the credit is authorized
	 * @return returns true or false depending if it is authorized
	 */
	public Boolean isAuthorized()
	{
		return true;
	}

	/**
	 * the toString function for the for the Credit class
	 */
	public String toString()
	{
		// TODO - implement Credit.toString
		throw new UnsupportedOperationException();
	}

}