
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class RegularPanel extends JPanel implements ActionListener{

    JPanel pSlot1, pSlot2, pSlot3, pSlot4, pSlot5, pSlot6, pSlot7, pSlot8;
    JButton bSlot1, bSlot2, bSlot3,bSlot4, bSlot5, bSlot6, bSlot7, bSlot8;
    JButton cancel, dispense; 
    JButton itemButton[] = new JButton[8];
    JPanel itemPanel[] = new JPanel[8];

    RegularPanel(JButton cancel, JButton dispense) {

        this.cancel = cancel;
        cancel.addActionListener(this);
        
        this.dispense = dispense;
        dispense.addActionListener(this);

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
        setBounds(30, 30, 400, 700);
        setBackground(Color.LIGHT_GRAY);

        for(int i = 0; i < 8; i++) {
            itemPanel[i].setLayout(null);
            itemPanel[i].setBackground(Color.WHITE);

            itemButton[i].setBounds(20, 20, 150,80);
            itemButton[i].addActionListener(this);
            itemButton[i].setFocusable(false);
            itemButton[i].setBackground(Color.LIGHT_GRAY);
            itemButton[i].setBorder(BorderFactory.createRaisedBevelBorder());

            JLabel price = new JLabel("Price:");
            price.setBounds(35, 110, 50, 20);

            JTextField amount = new JTextField("Php 1000");
            amount.setBounds(85, 110, 60, 20);
            amount.setEditable(false);
            amount.setFocusable(false);

            JLabel stock = new JLabel("Stock:");
            stock.setBounds(34,135, 50, 20);
            
            JTextField n = new JTextField("Num");
            n.setBounds(85, 135, 60, 20);
            n.setEditable(false);
            n.setFocusable(false);

            itemPanel[i].add(price);
            itemPanel[i].add(amount);
            itemPanel[i].add(stock);
            itemPanel[i].add(n);
            itemPanel[i].add(itemButton[i]);

            add(itemPanel[i]);
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bSlot1) {
            System.out.println("Slot 1");
        }
        if (e.getSource() == bSlot2) {

        }
        if (e.getSource() == bSlot3) {
            
        }
        if (e.getSource() == bSlot4) {
            
        }
        if (e.getSource() == bSlot5) {
            
        }
        if (e.getSource() == bSlot6) {
            
        }
        if (e.getSource() == bSlot7) {
            
        }
        if (e.getSource() == bSlot8) {
            
        }
    }
    
}
