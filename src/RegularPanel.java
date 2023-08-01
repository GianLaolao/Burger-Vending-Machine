
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;

import java.io.*;
import java.util.ArrayList;

import javax.imageio.*;

public class RegularPanel extends JPanel implements ActionListener{

    JPanel pSlot1, pSlot2, pSlot3, pSlot4, pSlot5, pSlot6, pSlot7, pSlot8;
    JButton bSlot1, bSlot2, bSlot3,bSlot4, bSlot5, bSlot6, bSlot7, bSlot8; 
    JButton itemButton[] = new JButton[8];
    JPanel itemPanel[] = new JPanel[8];
    JTextField[] amountTF = new JTextField[8];
    JTextField[] numTF = new JTextField[8];

    JButton cancel, dispense, special, mainte;
    JTextArea screen;
    JTextField total;

    ArrayList<Item> order = new ArrayList<>();

    RegularVendo reg;
    VendingMachine vendo;

    private final String indent = "                             ";

    RegularPanel(JButton cancel, JButton dispense, JButton special, JButton mainte, JTextArea screen, JTextField total, VendingMachine vendo) {

        this.cancel = cancel;
        cancel.addActionListener(this);
        
        this.dispense = dispense;
        dispense.addActionListener(this);

        this.special = special;
        special.addActionListener(this);

        this.mainte = mainte;
        mainte.addActionListener(this);

        this.screen = screen;
        this.total = total;

        reg = vendo.getRegular();
        this.vendo = vendo;

        itemButton[0] = bSlot1 = new JButton();
        itemButton[1] = bSlot2 = new JButton();
        itemButton[2] = bSlot3 = new JButton();
        itemButton[3] = bSlot4 = new JButton();
        itemButton[4] = bSlot5 = new JButton();
        itemButton[5] = bSlot6 = new JButton();
        itemButton[6] = bSlot7 = new JButton();
        itemButton[7] = bSlot8 = new JButton();

        itemPanel[0] = pSlot1 = new JPanel();
        itemPanel[1] = pSlot2 = new JPanel();
        itemPanel[2] = pSlot3 = new JPanel();
        itemPanel[3] = pSlot4 = new JPanel();
        itemPanel[4] = pSlot5 = new JPanel();
        itemPanel[5] = pSlot6 = new JPanel();
        itemPanel[6] = pSlot7 = new JPanel();
        itemPanel[7] = pSlot8 = new JPanel();

        setLayout(new GridLayout(4, 2,10,10));
        setBounds(20, 30, 400, 700);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createLoweredBevelBorder());

        for(int i = 0; i < 8; i++) {
            itemPanel[i].setLayout(null);
            itemPanel[i].setBackground(Color.LIGHT_GRAY);

            itemButton[i].setBounds(20, 10, 150,90);
            itemButton[i].addActionListener(this);
            itemButton[i].setFocusable(false);
            itemButton[i].setHorizontalTextPosition(JButton.CENTER);
            itemButton[i].setVerticalTextPosition(JButton.BOTTOM);
            itemButton[i].setBorder(BorderFactory.createRaisedBevelBorder());

            itemButton[i].setBackground(Color.DARK_GRAY);
            itemButton[i].setEnabled(false);
            
            JLabel price = new JLabel("Price:");
            price.setBounds(35, 110, 50, 20);

            JTextField amount = new JTextField();
            amount.setBounds(85, 110, 60, 20);
            amount.setEditable(false);
            amount.setFocusable(false);
            
            amountTF[i] = amount;

            JLabel stock = new JLabel("Stock:");
            stock.setBounds(34,135, 50, 20);
            
            JTextField num = new JTextField();
            num.setBounds(85, 135, 60, 20);
            num.setEditable(false);
            num.setFocusable(false);

            numTF[i] = num;

            itemPanel[i].add(price);
            itemPanel[i].add(amount);
            itemPanel[i].add(stock);
            itemPanel[i].add(num);
            itemPanel[i].add(itemButton[i]);

            add(itemPanel[i]);
        }

    }

    private ImageIcon buttonIcon (String path) {

        File image = new File(path);   
        
        try {
            BufferedImage origImage = ImageIO.read(image);
            Image o = origImage.getScaledInstance(80, 60, Image.SCALE_SMOOTH);
            ImageIcon newImage = new ImageIcon(o);
            
            return newImage; 
        }
        catch(IOException e) {

        }
        return null;
    }

    private void printScreen() {

        String s = "\t        Order: \n\n" + "  Item\t\t            Price \n\n";
        int t = 0;

        for (Item item : order) {
            String string = item.getName();
            string += indent.substring(0, indent.length() - string.length());
            string = String.format("  %s \t            %d\n", string,item.getPrice());
            s += string;

            t += item.getPrice();
        }

        total.setText(" Php: " + Integer.toString(t));
        screen.setText(s);
    }

    public void updateSlots () {

        for (int i = 0; i < 8; i++) {
            if (reg.getSlotsItem()[i] != null) {

                itemButton[i].setText(reg.getSlotsItem()[i].getName());
                
                itemButton[i].setIcon(buttonIcon( reg.getSlotsItem()[i].getPath()));

                amountTF[i].setText(Integer.toString( reg.getSlotsItem()[i].getPrice()));
                numTF[i].setText(Integer.toString( reg.getSlotsItem()[i].getStock().size()));

                if ( reg.getSlotsItem()[i].getStock().size() != 0) {
                    itemButton[i].setBackground(Color.WHITE);
                    itemButton[i].setEnabled(true);   
                }
                else {
                    itemButton[i].setBackground(Color.DARK_GRAY);
                    itemButton[i].setEnabled(false);   
                }
            }
            else if ( reg.getSlotsItem()[i] == null) {
                itemButton[i].setIcon(null);
                itemButton[i].setText(null);
                itemButton[i].setBackground(Color.DARK_GRAY);
                itemButton[i].setEnabled(false); 

                numTF[i].setText(null);
                amountTF[i].setText(null);
                 
            }
            else {
                itemButton[i].setEnabled(false);
                itemButton[i].setBackground(Color.DARK_GRAY);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bSlot1) {
            if (order.size() != 5) {
                order.add(reg.getSlotsItem()[0]);
                printScreen();
            }
            else 
                JOptionPane.showMessageDialog(null, "Order Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
        }
        if (e.getSource() == bSlot2) {
            if (order.size() != 5) {
                order.add( reg.getSlotsItem()[1]);
                printScreen();
            }
            else 
                JOptionPane.showMessageDialog(null, "Order Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
        }
        if (e.getSource() == bSlot3) {
            if (order.size() != 5) {
                order.add( reg.getSlotsItem()[2]);
                printScreen();
            }
            else 
                JOptionPane.showMessageDialog(null, "Order Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
        }
        if (e.getSource() == bSlot4) {
            if (order.size() != 5) {
                order.add( reg.getSlotsItem()[3]);
                printScreen();
            }
            else 
                JOptionPane.showMessageDialog(null, "Order Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
        }
        if (e.getSource() == bSlot5) {
            if (order.size() != 5) {
                order.add( reg.getSlotsItem()[4]);
                printScreen();
            }
            else 
                JOptionPane.showMessageDialog(null, "Order Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
        }
        if (e.getSource() == bSlot6) {
            if (order.size() != 5) {
                order.add( reg.getSlotsItem()[5]);
                printScreen();
            }
            else 
                JOptionPane.showMessageDialog(null, "Order Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
        }
        if (e.getSource() == bSlot7) {
            if (order.size() != 5) {
                order.add( reg.getSlotsItem()[6]);
                printScreen();
            }
            else 
                JOptionPane.showMessageDialog(null, "Order Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
        }
        if (e.getSource() == bSlot8) {
            if (order.size() != 5) {
                order.add( reg.getSlotsItem()[7]);
                printScreen();
            }
            else 
                JOptionPane.showMessageDialog(null, "Order Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
        }
        if (e.getSource() == special || e.getSource() == mainte) {
            order.clear();
        }
        if (e.getSource() == dispense) {
            
        }
        if (e.getSource() == cancel) {
            order.clear();
        } 
    }
    
}
