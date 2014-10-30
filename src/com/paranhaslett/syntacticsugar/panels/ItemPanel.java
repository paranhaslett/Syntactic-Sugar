package com.paranhaslett.syntacticsugar.panels;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.paranhaslett.syntacticsugar.ItemPanelUpdater;
import com.paranhaslett.syntacticsugar.model.Item;

public class ItemPanel extends JPanel{
  private static final long serialVersionUID = -7000063689558494455L;
  protected JLabel itemLabel;
  protected JTextField itemTextField;
  protected String text;
  protected ItemPanelUpdater ipu;
  private Item item;
  
  public void setIpu(ItemPanelUpdater ipu) {
    this.ipu = ipu;
  }

  public ItemPanel(Item item) {
    this.item = item;
    setLayout(new CardLayout(0, 0));
    itemTextField = new JTextField();
    itemLabel = new JLabel(item.getName());
    itemLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        labelClicked();
        //also do change when enter is hit

      }
    });
    add(itemLabel, "name_11332662810991");
    itemLabel.setHorizontalAlignment(SwingConstants.CENTER);
    itemLabel.setLabelFor(this);

    add(itemTextField, "name_11338291216196");
    itemTextField.setHorizontalAlignment(SwingConstants.CENTER);
    itemTextField.setColumns(20);
    itemTextField.setText(item.getName());
    itemTextField.setVisible(false);
  }
  
  protected void labelClicked() {
    ipu.update();
    itemTextField.setVisible(true);
    itemLabel.setVisible(false);
  }

  public void updateItem() {
    itemLabel.setText(itemTextField.getText());
    // TODO tell item to save as it has been changed
    item.setName(itemTextField.getText());
    itemTextField.setVisible(false);
    itemLabel.setVisible(false);
  }
}
