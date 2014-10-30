package com.paranhaslett.syntacticsugar;

import java.util.ArrayList;
import java.util.List;

import com.paranhaslett.syntacticsugar.panels.ItemPanel;

public class ItemPanelUpdater {
  private List<ItemPanel> tabItemPanels = new ArrayList<ItemPanel>();
  public void register(ItemPanel ip){
    tabItemPanels.add(ip);
  }
  
  public void update() {
    for (ItemPanel itemPanel :tabItemPanels) {
      itemPanel.updateItem();
    } 
  }
}
