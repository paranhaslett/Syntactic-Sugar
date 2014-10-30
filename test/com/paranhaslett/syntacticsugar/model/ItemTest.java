package com.paranhaslett.syntacticsugar.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

  @Test
  public void testItem() {
    Item item = new Item("testName", "menuId.txt");
    assertEquals(item.getName(), "testName");
    assertEquals(item.getMenuId(), "menuId.txt");
    assertNotSame(item.getName(), "badName");
    assertNotSame(item.getMenuId(), "badId.txt");
    
  }

  @Test
  public void testAddTag() {
    Item item = new Item("testName", "menuId.txt");
    item.addTag("testTag");
    assertTrue(item.getTags().contains("testTag"));
    assertFalse(item.getTags().contains("badTag"));
  }

  @Test
  public void testGetTags() {
    Item item = new Item("testName", "menuId.txt");
    item.addTag("testTag");
    assertTrue(item.getTags().contains("testTag"));
    assertFalse(item.getTags().contains("badTag"));
  }

  @Test
  public void testDrillInto() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetMenuId() {
    Item item = new Item("testName", "menuId.txt");
    assertEquals(item.getMenuId(), "menuId.txt");
    assertFalse(item.getMenuId().equals("badId.txt"));
  }

  @Test
  public void testGetName() {
    Item item = new Item("testName", "menuId.txt");
    assertEquals(item.getName(), "testName");
    assertFalse(item.getName().equals("badName"));
  }

}
