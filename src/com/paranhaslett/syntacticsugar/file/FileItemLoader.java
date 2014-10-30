package com.paranhaslett.syntacticsugar.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.paranhaslett.syntacticsugar.model.Item;

public class FileItemLoader extends ItemLoader {
  private BufferedReader br;

  void setBufferedReader(BufferedReader br) {
    this.br = br;
  }

  @Override
  List<Item> loadAllItems() {
    List<Item> items = new ArrayList<Item>();
    String name;
    try {
      while ((name = br.readLine()) != null) {
        String menuId;
        if ((menuId = br.readLine()) != null) {
          Item item = new Item(name, menuId);
          String tag;
          while ((tag = br.readLine()) != null && !tag.equals("~")) {
            item.addTag(tag);
          }
          items.add(item);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return items;
  }

  public Item getItem() {
    Item item = null;
    String name;
    try {
      if ((name = br.readLine()) != null) {
        String menuId;
        if ((menuId = br.readLine()) != null) {
          item = new Item(name, menuId);
          String tag;
          while ((tag = br.readLine()) != null && !tag.equals("~")) {
            item.addTag(tag);
          }
        } else {
          item = new Item(name,null);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return item;
  }

}
