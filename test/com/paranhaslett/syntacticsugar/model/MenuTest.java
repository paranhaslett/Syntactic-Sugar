package com.paranhaslett.syntacticsugar.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class MenuTest {

  @Test
  public void testMenu() {
    Menu menu = Menu.load("Testing");
    System.out.println(menu);
    assertEquals(
        menu.toString(),
        "This is for Testing purposes only[Test Entry One:TestEntry1.txt[Does.txt,Foo.txt,Bar.txt,Isa.txt,Hasa.txt,],Test Entry Two:TestEntry2.txt[Foo.txt,Bar.txt,Isa.txt,],Test Entry Three :TestEntry3.txt[Foo.txt,Hasa.txt,],Test Entry Four:TestEntry4.txt[Ouch.txt,Foo.txt,],]");
    
  }

  @Test
  public void testGetAllItems() {
    Menu menu = Menu.load("Testing");
        
    List<Item> items = menu.getItems();
    assertEquals(items.size(), 4);
    assertEquals(items.get(0).getMenuId(), "TestEntry1.txt");
    assertEquals(items.get(0).getName(), "Test Entry One");
    assertFalse(items.get(0).getMenuId().equals("TestEntry2.txt"));  
    assertEquals(items.get(1).getMenuId(), "TestEntry2.txt");
    assertEquals(items.get(2).getMenuId(), "TestEntry3.txt");
    assertEquals(items.get(3).getMenuId(), "TestEntry4.txt");
    assertTrue(items.get(3).getTags().contains("Ouch.txt"));
    assertFalse(items.get(3).getTags().contains("Hasa.txt"));
  }

  @Test
  public void testGetItems() {
    Menu menu = Menu.load("Testing");
    List<Item> items = menu.getItems("Hasa.txt");
    assertEquals(2, items.size());
    assertEquals(items.get(0).getMenuId(), "TestEntry1.txt");
    assertEquals(items.get(0).getName(), "Test Entry One");
    assertFalse(items.get(1).getMenuId().equals("TestEntry2.txt"));  
    assertEquals(items.get(1).getMenuId(), "TestEntry3.txt");
    items = menu.getItems("Foo.txt");
    assertEquals(items.size(), 4);
    assertEquals(items.get(0).getMenuId(), "TestEntry1.txt");
    assertFalse(items.get(0).getMenuId().equals("TestEntry2.txt"));  
    assertEquals(items.get(1).getMenuId(), "TestEntry2.txt");
    assertEquals(items.get(2).getMenuId(), "TestEntry3.txt");
    assertEquals(items.get(3).getMenuId(), "TestEntry4.txt");
    assertTrue(items.get(3).getTags().contains("Ouch.txt"));
    assertFalse(items.get(3).getTags().contains("Hasa.txt"));
  }

  @Test
  public void testCreateNew() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetTitle() {
    Menu menu = Menu.load("Testing");
    assertEquals(menu.getTitle(), "This is for Testing purposes only");
  }

}
