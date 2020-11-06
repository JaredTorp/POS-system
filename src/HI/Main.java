package HI;

import POSPD.*;
import Test.Test;

public class Main 
{
	private Store myStore;
	
	public static void main(String[] args)
	{
		
		
		Store store = new Store();
		store.loadStore();
		
	
		POSFrame.run(store);

		
		
		
		
	}
	
		
		
		
		
	
	
	
}
