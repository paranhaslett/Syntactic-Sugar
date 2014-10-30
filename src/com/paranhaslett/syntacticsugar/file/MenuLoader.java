package com.paranhaslett.syntacticsugar.file;

import com.paranhaslett.syntacticsugar.model.Item;


public interface MenuLoader {
  
  void setId(String id);
  
  void getId(String id);

  String getTitle();

  boolean hasItems();

  Item loadNextItem();

  void setTitle(String title);

  void saveItem(Item item);
  

}
