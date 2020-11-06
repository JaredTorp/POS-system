package POSPD;

import java.time.LocalDate;
import java.util.*;

import POSDMP.StoreDM;

/**
 * The Store is an object that represent the entire store
 */
public class Store
{

	/**
	 * a store has a specific number
	 */
	private String number;
	/**
	 * a store has a name
	 */
	private String name;
	/**
	 * a store has taxcategories
	 */
	private TreeMap<String, TaxCategory> taxCategories;
	/**
	 * a store has a group of items
	 */
	private TreeMap<String, Item> items;
	/**
	 * a store has a group of cahiers
	 */
	private TreeMap<String, Cashier> cashiers;
	/**
	 * a store has registers
	 */
	private TreeMap<String, Register> registers;
	/**
	 * a store has sessions of the registers
	 */
	private ArrayList<Session> sessions;
	/**
	 * a store has UPCs
	 */
	private TreeMap<String, UPC> upcs;

	public String getNumber()
	{
		return this.number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public TreeMap<String, TaxCategory> getTaxCategories()
	{
		return this.taxCategories;
	}

	public TreeMap<String, Item> getItems()
	{
		return this.items;
	}

	public TreeMap<String, Cashier> getCashiers()
	{
		return this.cashiers;
	}

	public TreeMap<String, Register> getRegisters()
	{
		return this.registers;
	}

	public ArrayList<Session> getSessions()
	{
		return this.sessions;
	}

	public TreeMap<String, UPC> getUpcs()
	{
		return this.upcs;
	}

	/**
	 * the default constructor for the store
	 */
	public Store()
	{
		this.number = "0";
		this.name = "default";
		taxCategories = new TreeMap<String, TaxCategory>();
		items = new TreeMap<String, Item>();
		cashiers = new TreeMap<String, Cashier>();
		registers = new TreeMap<String, Register>();
		sessions = new ArrayList<Session>();
		upcs = new TreeMap<String, UPC>();
	}

	/**
	 * constructor with parameters for a store
	 * @param number we pass the number of the store
	 * @param name we pass the name of the store
	 */
	public Store(String number, String name)
	{
		this();
		this.number = number;
		this.name = name;
	}

	/**
	 * this method adds an item to the store
	 * @param item pass the item to be added
	 */
	public void addItem(Item item)
	{
		items.put(item.getNumber(), item); 
	}

	/**
	 * this method removes an item of the store
	 * @param item
	 */
	public void removeItem(Item item)
	{
		items.remove(item.getNumber());
	}

	/**
	 * this method adds a upc
	 * @param upc we pass the upc to be added
	 */
	public void addUPC(UPC upc)
	{
		upcs.put(upc.getUPC(), upc);
	}

	/**
	 * this method removes a upc from the store
	 * @param upc we pass the upc to be removed
	 */
	public void removeUPC(UPC upc)
	{
		upcs.remove(upc.getUPC());
	}

	/**
	 * this method adds a register to the store
	 * @param register
	 */
	public void addRegister(Register register)
	{
		registers.put(register.getNumber(), register);
	}

	/**
	 * this method removes the register from the store
	 * @param register we pass the register to be removed to the store
	 */
	public void removeRegister(Register register)
	{
		registers.remove(register.getNumber());
	}

	/**
	 * this method adds a cashier to the store
	 * @param cashier we pass the cashier to be added to the store
	 */
	public void addCashier(Cashier cashier)
	{
		cashiers.put(cashier.getNumber(), cashier);
	}

	/**
	 * this method removes a cashier from the store
	 * @param cashier we pass the cashier to be removed to the store
	 */
	public void removeCashier(Cashier cashier)
	{
		cashiers.remove(cashier.getNumber());
	}

	/**
	 * this method adds a taxcategory to the store
	 * @param taxCategory we pass the taxcategory to be added to the store
	 */
	public void addTaxCategory(TaxCategory taxCategory)
	{
		taxCategories.put(taxCategory.getCategory(), taxCategory);
	}

	/**
	 * this method removes the taxCategory of the store
	 * @param taxCategory we pass the taxcategory to be removed to the store
	 */
	public void removeTaxCategory(TaxCategory taxCategory)
	{
		taxCategories.remove(taxCategory.getCategory());
	}

	/**
	 * this method adds a session to the store
	 * @param session
	 * @param parameter pass the session to be added
	 */
	public void addSession(Session session)
	{
		sessions.add(session);
	}

	/**
	 * this method removes a session that we pass
	 * @param sesson pass the session to be removed
	 */
	public void removeSession(Session session)
	{
		sessions.remove(session);
	}

	/**
	 * this method finds a register given a number
	 * @param number we pass the number to find the register
	 * @return returns the register
	 */
	public Register findRegisterByNumber(String number)
	{
		return registers.get(number);
	}

	/**
	 * this method searches for an item given a upc
	 * @param upc we pass the UPC to find
	 * @return returns the item
	 */
	public Item findItemForUPC(String upc)
	{
		
		for (Item item : getItems().values())
		{
			for (UPC UPC : item.getUPCs().values())
			{
				if (UPC.getUPC().equals(upc))
				{
					return item;
				}
				
			}
			
		}
		
		
		return null;
		
	}

	/**
	 * this method searches for an item given a number
	 * @param number we pass the number to find the item
	 * @return returns the item
	 */
	public Item findItemForNumber(String number)
	{
		return items.get(number);
	}

	/**
	 * this method finds a cashier based on their number
	 * @param number pass the number to search
	 * @return returns the cashier
	 */
	public Cashier findCashierForNumber(String number)
	{
		return cashiers.get(number);
	}

	/**
	 * this method finds the tax category by the name
	 * @param category we pass the category to find
	 * @return returns the tax category
	 */
	public TaxCategory findTaxCategoryByName(String category)
	{
		return taxCategories.get(category);
	}

	/**
	 * toString function of the Store class
	 * @return displays the string of information
	 */
	public void loadStore()
	{
		StoreDM.loadstore(this);
	}
	
	public boolean isTaxCategoryUsed(TaxCategory otherTaxCat)
	{
		boolean isUsed = false;
		for (Item item  : this.getItems().values())
		{
			if (item.getTaxCategory().equals(otherTaxCat))
			{
				isUsed = true;
			}
		}
		
		return isUsed;
	}
	public boolean isCashierUsed(Cashier otherCashier)
	{
		boolean isUsed = false;
		for (Session session : this.getSessions())
		{
			if (session.getCashier().equals(otherCashier))
			{
				isUsed = true;
			}
		}
		
		return isUsed;
	}
	
	
	public boolean isRegisterUsed(Register otherRegister)
	{
		boolean isUsed = false;
		for (Session session : this.getSessions())
		{
			if (session.getRegister().equals(otherRegister))
			{
				isUsed = true;
			}
		}
		
		return isUsed;
	}
	

	
	
	
	
	public String toString()
	{
		
		
		return this.getName() + this.getNumber();
		
		
		
	
		
	}

	public int getSoldForDate(LocalDate date)
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

	

}