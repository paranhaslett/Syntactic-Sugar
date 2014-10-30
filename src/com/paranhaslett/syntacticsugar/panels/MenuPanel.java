package com.paranhaslett.syntacticsugar.panels;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.paranhaslett.syntacticsugar.ItemPanelUpdater;
import com.paranhaslett.syntacticsugar.file.FileMenuLoader;
import com.paranhaslett.syntacticsugar.model.Item;
import com.paranhaslett.syntacticsugar.model.Menu;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class MenuPanel extends JPanel {

  private static final long serialVersionUID = -4636156400750711750L;
  private static SyntacticSugarFrame frmMenu;
  Menu currentMenu;

  public static void setFrame(SyntacticSugarFrame frmMenu) {
    MenuPanel.frmMenu = frmMenu;
  }

  public MenuPanel(String id) {
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    currentMenu = Menu.load(id);
    
    setLayout(new BorderLayout(0, 0));
    
    ItemPanelUpdater allIpu = new ItemPanelUpdater();
    
    Item createItem = new Item("Create New", null);
    
    final ItemPanel createNewPanel = new ItemPanel(createItem);
    createNewPanel.itemLabel.addPropertyChangeListener(new PropertyChangeListener() {
      public void propertyChange(PropertyChangeEvent arg0) {
        System.out.println("Create New " + createNewPanel.text);
      }
    });
   
    add(createNewPanel, BorderLayout.SOUTH);
    
    Item titleItem = new Item(currentMenu.getTitle(), null);
    ItemPanel titlePanel = new ItemPanel(titleItem);
    add(titlePanel, BorderLayout.NORTH);
    add(tabbedPane, BorderLayout.CENTER);
    
    createNewPanel.setIpu(allIpu);
    titlePanel.setIpu(allIpu);
    
    allIpu.register(createNewPanel);
    allIpu.register(titlePanel);
    
    // get tabs
    Menu tabMenu = Menu.load("Tabs");
    List<Item> tabs = tabMenu.getItems();
    for (Item tab : tabs) {
      ItemPanelUpdater ipu = new ItemPanelUpdater();
      TabPanel tabPanel = new TabPanel(ipu);
      tabPanel.addItems(currentMenu, tab);
      tabbedPane.addTab(tab.getName(), null, tabPanel);  
    }
    frmMenu.update(currentMenu.getTitle(), this);
  }
  
  @Override
  public String toString(){
    return currentMenu.toString();
  }
}
