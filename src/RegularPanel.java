
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;

import java.io.*;
import javax.imageio.*;

public class RegularPanel extends JPanel implements ActionListener{

    JPanel pSlot1, pSlot2, pSlot3, pSlot4, pSlot5, pSlot6, pSlot7, pSlot8;
    JButton bSlot1, bSlot2, bSlot3,bSlot4, bSlot5, bSlot6, bSlot7, bSlot8;
    JButton cancel, dispense;
    JTextArea screen; 
    JButton itemButton[] = new JButton[8];
    JPanel itemPanel[] = new JPanel[8];
    JTextField[] amountTF = new JTextField[8];
    JTextField[] numTF = new JTextField[8];

    private final String indent = "                             ";

    RegularPanel(JButton cancel, JButton dispense, JTextArea screen) {

        this.cancel = cancel;
        cancel.addActionListener(this);
        
        this.dispense = dispense;
        dispense.addActionListener(this);

        this.screen = screen;

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

            // if (RegularVendo.slotsItem[i] != null) {
            //     itemButton[i].setText(RegularVendo.slotsItem[i].getName());
            //     itemButton[i].setBackground(Color.WHITE);
            //     amount.setText(Integer.toString(RegularVendo.slotsItem[i].getPrice()));
            //     num.setText(Integer.toString(RegularVendo.slotsItem[i].getStock().size()));
            // }
            // else {
            //     itemButton[i].setEnabled(false);
            //     itemButton[i].setBackground(Color.DARK_GRAY);
            // }

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

    public void updateSlots () {

        for (int i = 0; i < 8; i++) {
            if (RegularVendo.slotsItem[i] != null) {

                itemButton[i].setText(RegularVendo.slotsItem[i].getName());
                
                itemButton[i].setIcon(buttonIcon(RegularVendo.slotsItem[i].getIcon()));

                amountTF[i].setText(Integer.toString(RegularVendo.slotsItem[i].getPrice()));
                numTF[i].setText(Integer.toString(RegularVendo.slotsItem[i].getStock().size()));

                if (RegularVendo.slotsItem[i].getStock().size() != 0) {
                    itemButton[i].setBackground(Color.WHITE);
                    itemButton[i].setEnabled(true);   
                }
                else {
                    itemButton[i].setBackground(Color.DARK_GRAY);
                    itemButton[i].setEnabled(false);   
                }
            }
            else if (RegularVendo.slotsItem[i] == null) {
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
            String string = RegularVendo.slotsItem[0].getName();
            string += indent.substring(0, indent.length() - string.length());
            string = String.format("  %s \t            %d\n", string,RegularVendo.slotsItem[0].getPrice());
            screen.append(string); 
        }
        if (e.getSource() == bSlot2) {
            String string = RegularVendo.slotsItem[1].getName();
            string += indent.substring(0, indent.length() - string.length());
            string = String.format("  %s \t            %d\n", string,RegularVendo.slotsItem[1].getPrice());
            screen.append(string);
        }
        if (e.getSource() == bSlot3) {
            String string = RegularVendo.slotsItem[2].getName();
            string += indent.substring(0, indent.length() - string.length());
            string = String.format("  %s \t            %d\n", string,RegularVendo.slotsItem[2].getPrice());
            screen.append(string);
        }
        if (e.getSource() == bSlot4) {
            String string = RegularVendo.slotsItem[3].getName();
            string += indent.substring(0, indent.length() - string.length());
            string = String.format("  %s \t            %d\n", string,RegularVendo.slotsItem[3].getPrice());
            screen.append(string);
        }
        if (e.getSource() == bSlot5) {
            String string = RegularVendo.slotsItem[4].getName();
            string += indent.substring(0, indent.length() - string.length());
            string = String.format("  %s \t            %d\n", string,RegularVendo.slotsItem[4].getPrice());
            screen.append(string);
        }
        if (e.getSource() == bSlot6) {
            String string = RegularVendo.slotsItem[5].getName();
            string += indent.substring(0, indent.length() - string.length());
            string = String.format("  %s \t            %d\n", string,RegularVendo.slotsItem[5].getPrice());
            screen.append(string);
        }
        if (e.getSource() == bSlot7) {
            String string = RegularVendo.slotsItem[6].getName();
            string += indent.substring(0, indent.length() - string.length());
            string = String.format("  %s \t            %d\n", string,RegularVendo.slotsItem[6].getPrice());
            screen.append(string);
        }
        if (e.getSource() == bSlot8) {
            String string = RegularVendo.slotsItem[7].getName();
            string += indent.substring(0, indent.length() - string.length());
            string = String.format("  %s \t            %d\n", string,RegularVendo.slotsItem[7].getPrice());
            screen.append(string);
        }
        if (e.getSource() == dispense) {
            
        }
        if (e.getSource() == cancel) {

        } 
    }
    
}
