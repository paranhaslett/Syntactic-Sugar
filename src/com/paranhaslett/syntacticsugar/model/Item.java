package com.paranhaslett.syntacticsugar.model;
import java.util.HashSet;
import java.util.Set;


public class Item {
  private String menuId;
  private String name;
  private Set<String> tags;
  
  ////////////// Methods //////////////
 
  public Item(String name, String menuId) {
    this.name = name;
    this.menuId = menuId;
    this.tags = new HashSet<String>();
  }

  public void addTag(String tag){
    //add a menuId as a tag to each item
    tags.add(tag);
  }
  
  public void removeTag(String tag){
    //remove a menuId
    tags.remove(tag);
  }
  
  public void open() {
    // TODO Auto-generated method stub

  }
  
  
  public String getMenuId() {
    return menuId;
  }

  public String getName() {
    return name;
  }

  public Set<String> getTags() {
    return tags;
  }
  
  public void setName(String text) {
    this.name = text;
    
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(name).append(':').append(menuId).append("[");
    for(String tag: tags){
      sb.append(tag).append(',');
    }
    sb.append(']');
    return sb.toString();
  }

}
