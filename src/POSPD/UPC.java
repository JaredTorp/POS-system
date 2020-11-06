package POSPD;

public class UPC
{

	private Item Item;
	/**
	 * a upc has a upc
	 */
	private String uPC;
	/**
	 * a upc is bound to an item
	 */
	private Item item;

	public String getUPC()
	{
		return this.uPC;
	}

	public void setUPC(String uPC)
	{
		this.uPC = uPC;
	}

	public Item getItem()
	{
		return this.item;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}

	/**
	 * the default constructor for the UPC class
	 */
	public UPC()
	{
		this.uPC = "";
	}

	/**
	 * Constructor with a string parameter
	 * @param upc we pass the specific UPC
	 */
	public UPC(String upc)
	{
		this.uPC = upc;
	}

	/**
	 * the toString function of the UPC class
	 */
	public String toString()
	{
		return this.getUPC();
	}

}