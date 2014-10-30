package com.paranhaslett.syntacticsugar.panels;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import com.paranhaslett.syntacticsugar.ItemPanelUpdater;
import com.paranhaslett.syntacticsugar.model.Item;
import com.paranhaslett.syntacticsugar.model.Menu;


public class TabPanel extends JPanel {
	
	private static final long serialVersionUID = 1308887504279794542L;
	private JPanel mainPanel;
	private ItemPanelUpdater ipu;
	

	/**
	 * Create the panel.
	 */
	public TabPanel(ItemPanelUpdater ipu) {
	  this.ipu = ipu;
			setLayout(new CardLayout(0, 0));
			
			mainPanel = new JPanel();
			
			JScrollPane scrollPane = new JScrollPane(mainPanel);
			mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
			add(scrollPane, "name_17710810873751");
			scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		}
	
	public void addItems(Menu currentMenu, Item tab){
	  //get items for each tab
	 
    for (Item item :currentMenu.getItems(tab.getMenuId())) {
      DnDItemPanel dip = new DnDItemPanel(item, ipu);
      ButtonItemPanel itemPanel = new ButtonItemPanel(currentMenu,item, dip);
      ipu.register(dip);
      mainPanel.add(itemPanel);
    }
	}

  
}
