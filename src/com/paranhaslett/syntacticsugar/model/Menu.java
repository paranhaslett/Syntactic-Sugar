package com.paranhaslett.syntacticsugar.model;

import java.util.ArrayList;
import java.util.List;

import com.paranhaslett.syntacticsugar.file.FileMenuLoader;
import com.paranhaslett.syntacticsugar.file.MenuLoader;

public class Menu {
  
  private static String highestId;
  private static MenuLoader ml = new FileMenuLoader();
  
  private String id;
  private List<Item> items = new ArrayList<Item>();
  private List<Menu> inherited = new ArrayList<Menu>();
  //Protection against recursive inheritance loops
  private boolean paril = false;
  private String title;
  
  
  
  ////////////// methods /////////////////


  public static Menu load(String id) {
    ml.getId(id);
    Menu menu = new Menu();
    menu.id = id;
    menu.title = ml.getTitle();
    // load all inheritance 
    // recursiv/e
    // load all the items
    while(ml.hasItems()){
      menu.items.add(ml.loadNextItem());
    }  
    return menu;
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public String display() {
    StringBuilder sb = new StringBuilder();
    sb.append(title).append("~");
    //get filters
    //got though all the all items applying the filters
    return sb.toString();
  }

  public String getId() {
    return id;
  }

  public List<Item> getItems() {
    return items;
  }
  
  public List<Item>getInheritedItems(){
    return null;
  }

  public List<Item> getItems(String tagId) {
    List<Item> result = new ArrayList<Item>();
    // TODO get appropriate items for the global filter and local filter
    for (Item item : items) {
      if (item.getTags().contains(tagId)) {
        result.add(item);
      }
      // find out if the item has a tag that matches the current tab
      // find out if it also matches the current set filter
    }
    // fold the items displayed depending on the tags they have
    return result;
  }

  public String getTitle() {
    return title;
  }

  public void save() {
    if(id == null){
      if(highestId == null){
        highestId ="0x00";
      }
      String highestHex = highestId;
      long highestValue = Long.parseLong(highestHex, 16);
      highestValue++;
      id = Long.toHexString(highestValue);
    }
    ml.setId(id);
    ml.setTitle(title);
    for(Item item:items){
      ml.saveItem(item);
    }
    
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(title).append('[');
    for (Item item : items) {
      sb.append(item).append(',');
    }
    sb.append(']');
    return sb.toString();
  }
}
