package HI;

import javax.swing.JPanel;

import POSPD.Store;

import javax.swing.JLabel;

public class POSHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public POSHome(Store store)
	{
		
		JLabel lblNewLabel = new JLabel(store.getName());
		add(lblNewLabel);

	}

}
