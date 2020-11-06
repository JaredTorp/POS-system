package POSPD;

/**
 * Authorizedpayment is a parent class to both check and credit and represents a non-cash payment
 */
public class AuthorizedPayment extends Payment
{

	/**
	 * An authorized payment know about its authorization code
	 */
	private String authorizationCode;

	public String getAuthorizationCode()
	{
		return this.authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode)
	{
		this.authorizationCode = authorizationCode;
	}

	/**
	 * This method checks to see if the payment is authorized
	 * @return will return true or false depending on if it is authorized
	 */
	public Boolean isAuthorized()
	{
		return true;
	}

	/**
	 * This function sees whether or not the payment is cash or not
	 */
	public Boolean countAsCash()
	{
		// TODO - implement AuthorizedPayment.countAsCash
		throw new UnsupportedOperationException();
	}

}