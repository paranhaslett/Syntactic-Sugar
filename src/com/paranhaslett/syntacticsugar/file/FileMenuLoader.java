package com.paranhaslett.syntacticsugar.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.paranhaslett.syntacticsugar.model.Item;
import com.paranhaslett.syntacticsugar.model.Menu;

public class FileMenuLoader implements MenuLoader {

  BufferedReader br = null;
  BufferedWriter bw = null;
  Item nextItem = null;
  FileItemLoader fil = new FileItemLoader();

  public void saveMenu(Menu menu) {
    try {
      File file = new File(menu.getId());
      if (!file.exists()) {
        file.createNewFile();
      }
      FileOutputStream fstream = new FileOutputStream(file);
      DataOutputStream out = new DataOutputStream(fstream);
      bw = new BufferedWriter(new OutputStreamWriter(out));

      // The first line is the title
      bw.write(menu.getTitle());
      bw.write('\n');
      for (Item item : menu.getItems()) {
        bw.write(item.getName());
        bw.write('\n');
        bw.write(item.getMenuId());
        bw.write('\n');
        for (String tag : item.getTags()) {
          bw.write(tag);
          bw.write('\n');
        }
        bw.write("~");
        bw.write('\n');
      }
      bw.close();
    } catch (Exception e) {// Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
  }

  @Override
  public void getId(String id) {
    bw = null;
    try {
      File file = new File(id + ".txt");

      if (file.exists()) {
        FileInputStream fstream = new FileInputStream(id);
        DataInputStream in = new DataInputStream(fstream);
        br = new BufferedReader(new InputStreamReader(in));
      } else {
        br = null;
      }
    } catch (Exception e) {// Catch exception if any
      System.err.println("Error: " + e.getMessage());
      br = null;
    }
  }

  @Override
  public void setId(String id) {
    br = null;
    try {
      File file = new File(id + ".txt");
      if (!file.exists()) {
        file.createNewFile();
      }
      FileOutputStream fstream = new FileOutputStream(file);
      DataOutputStream out = new DataOutputStream(fstream);
      bw = new BufferedWriter(new OutputStreamWriter(out));
    } catch (Exception e) {// Catch exception if any
      System.err.println("Error: " + e.getMessage());
      bw = null;
    }
  }

  @Override
  public String getTitle() {
    if (br != null) {
      try {
        return br.readLine();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return "New";
  }

  @Override
  public boolean hasItems() {
    if (br != null) {
      if (nextItem == null) {
        fil.setBufferedReader(br);
        nextItem = fil.getItem();
        return nextItem != null;
      } else {
        return true;
      }
    }
    return false;
  }

  @Override
  public Item loadNextItem() {
    Item item = nextItem;
    nextItem = null;
    return item;
  }

  @Override
  public void setTitle(String title) {
    // TODO Auto-generated method stub

  }

  @Override
  public void saveItem(Item item) {
    // TODO Auto-generated method stub

  }
}
