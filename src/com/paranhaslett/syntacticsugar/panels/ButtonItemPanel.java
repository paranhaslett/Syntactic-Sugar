package com.paranhaslett.syntacticsugar.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.paranhaslett.syntacticsugar.file.FileMenuLoader;
import com.paranhaslett.syntacticsugar.model.Item;
import com.paranhaslett.syntacticsugar.model.Menu;

public class ButtonItemPanel extends JPanel {
  private static final long serialVersionUID = -8020781578598821636L;
  private Item item;
  private Menu menu;
  private DnDItemPanel dndpanel;

  public Item getItem() {
    return item;
  }

  public ButtonItemPanel(Menu menu, Item item, DnDItemPanel dndpanel) {
    this.item = item;
    this.dndpanel = dndpanel;
    this.menu = menu;

    setBorder(null);

    JButton btnNewButton = new JButton("");
    btnNewButton.setIcon(new ImageIcon(ButtonItemPanel.class
        .getResource("/icons/buttons/arrow-small.png")));
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        drillInto();
      }

    });
    btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
    setLayout(new BorderLayout(0, 0));
    add(btnNewButton, BorderLayout.EAST);
    add(dndpanel, BorderLayout.CENTER);
  }

  protected void drillInto() {
    dndpanel.updateItem();
    menu.save();
    new MenuPanel(item.getMenuId());
  }

}
