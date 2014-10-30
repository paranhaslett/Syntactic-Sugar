package com.paranhaslett.syntacticsugar.panels;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

import com.paranhaslett.syntacticsugar.ItemPanelUpdater;
import com.paranhaslett.syntacticsugar.model.Item;

public class DnDItemPanel extends ItemPanel implements Transferable,
DragSourceListener, DragGestureListener, DropTargetListener{
  
  private static final long serialVersionUID = -7932538983244567092L;
  private DragSource source;
  private TransferHandler t;
  private Item item;

  public DnDItemPanel(Item item, ItemPanelUpdater ipu) {  
    super(item);
    super.setIpu(ipu);
    this.item = item;
    t = new TransferHandler() {
      private static final long serialVersionUID = 4461250028564360152L;

      public Transferable createTransferable(JComponent c) {
        DnDItemPanel ip = (DnDItemPanel)c;
        return new DnDItemPanel(ip.item, ip.ipu);
      }
    };

    setTransferHandler(t);
    itemLabel.setTransferHandler(t);
    itemTextField.setTransferHandler(t);
  }

  
  
  @Override
  public void dragGestureRecognized(DragGestureEvent dge) {
    source.startDrag(dge, DragSource.DefaultMoveDrop, new DnDItemPanel(item, ipu), this);
  }

  @Override
  public void dragDropEnd(DragSourceDropEvent arg0) {
    repaint();
  }

  @Override
  public void dragEnter(DragSourceDragEvent arg0) {
    System.out.println("DragSourceDragEvent Drag Enter");
  }

  @Override
  public void dragExit(DragSourceEvent arg0) {
    System.out.println("DragSourceEvent Drag Exit");
  }

  @Override
  public void dragOver(DragSourceDragEvent arg0) {
    System.out.println("DragSourceEvent Drag Over");
  }

  @Override
  public void dropActionChanged(DragSourceDragEvent arg0) {
    System.out.println("DragSourceEvent Drop Action Changed");
  }

  @Override
  public Object getTransferData(DataFlavor arg0)
      throws UnsupportedFlavorException, IOException {
    return this;
  }

  @Override
  public DataFlavor[] getTransferDataFlavors() {
    return new DataFlavor[] { new DataFlavor(ButtonItemPanel.class, "ItemPanel") };
  }

  @Override
  public boolean isDataFlavorSupported(DataFlavor arg0) {
    return true;
  }

  @Override
  public void dragEnter(DropTargetDragEvent dtde) {
    System.out.println("DropTargetDragEvent Drag Enter");
    
  }

  @Override
  public void dragExit(DropTargetEvent dte) {
    System.out.println("DropTargetDragEvent Drag Exit");
    
  }

  @Override
  public void dragOver(DropTargetDragEvent dtde) {
    System.out.println("DropTargetDragEvent Drag Over");
  }

  @Override
  public void drop(DropTargetDropEvent dtde) {
    System.out.println("Drop");  
  }

  @Override
  public void dropActionChanged(DropTargetDragEvent dtde) {
    System.out.println("DropTargetDragEvent Drop Action Changed");
  }

}
