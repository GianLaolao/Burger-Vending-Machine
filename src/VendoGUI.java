import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class VendoGUI extends JFrame implements ActionListener{
    
    JFrame frame;
    ImageIcon iconReg = new ImageIcon("../ImageFolder/vendo.png");
    ImageIcon iconBurg = new ImageIcon("../ImageFolder/burger.png");

    JButton mainte, regular, special, cancel, dispense; 

    CardLayout cardLayout;
    JPanel card;

    RegularPanel regPanel;
    SpecialPanel specPanel;

    PaymentPanel paymentPanel;
    JTextField payment;

    JTextField screen;
    Font s = new Font("Dialog Plain", Font.PLAIN, 15);
    Font font1 = new Font("Monospaced Bold", Font.BOLD, 20);
    Font font2 = new Font("Monospaced Bold", Font.BOLD, 15);
 
    RegularVendo reg = new RegularVendo();
    SpecialVendo spec = new SpecialVendo();

    public VendoGUI (int choice){ 

        frame = new JFrame("Regular Vending Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,870);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        screen = new JTextField();
        screen.setBounds(460, 30, 250, 300);
        screen.setEditable(false);
        screen.setFont(s);
        screen.setFocusable(false);
        screen.setBackground(Color.DARK_GRAY);

        payment = new JTextField("Php 0.00");
        payment.setBounds(460, 370, 250, 40);
        payment.setEditable(false);
        payment.setFocusable(false);  
        payment.setFont(font1);
        payment.setHorizontalAlignment(JTextField.CENTER);
        payment.setBackground(Color.DARK_GRAY);
        payment.setForeground(Color.WHITE);

        mainte = new JButton("Maintenance");
        special = new JButton("Special Vending Machine");
        dispense = new JButton("Dispense");
        cancel = new JButton("Cancel");

        dispense.setBounds(460, 660, 250, 30);
        dispense.setFont(font1);
        dispense.setFocusable(false);
        dispense.setBackground(Color.WHITE);
        dispense.setBorder(BorderFactory.createRaisedBevelBorder());

        cancel.setBounds(460, 700, 250, 30);
        cancel.setFont(font1);
        cancel.setFocusable(false);
        cancel.setBackground(Color.WHITE);
        cancel.setBorder(BorderFactory.createRaisedBevelBorder());
        cancel.addActionListener(this);

        mainte.setBounds(50, 750, 320, 60);
        mainte.setFont(font1);
        mainte.setFocusable(false);
        mainte.setBackground(Color.WHITE);
        mainte.setBorder(BorderFactory.createRaisedBevelBorder());

        special.setBounds(395, 750, 320, 60);
        special.setFont(font1);
        special.setFocusable(false);
        special.setBackground(Color.WHITE);
        special.setBorder(BorderFactory.createRaisedBevelBorder());
        special.addActionListener(this);
        
        regular = new JButton("Regular Vending Machine");
        regular.setBounds(395, 750, 320, 60);
        regular.setFont(font1);
        regular.setFocusable(false);
        regular.setBackground(Color.WHITE);
        regular.setBorder(BorderFactory.createRaisedBevelBorder());
        regular.addActionListener(this);

        regPanel = new RegularPanel(cancel, dispense);
        specPanel = new SpecialPanel(cancel, dispense);
        paymentPanel = new PaymentPanel(payment, cancel);

        card = new JPanel(new CardLayout());
        card.setBounds(30, 10, 400, 720);
        card.add(regPanel, "Regular");
        card.add(specPanel, "Special");

        cardLayout = (CardLayout) card.getLayout();

        switch(choice) {
            case 0:
                cardLayout.show(card, "Regular");
                frame.add(special);
                frame.setIconImage(iconReg.getImage());
                break;
            case 1:
                cardLayout.show(card, "Special");
                frame.add(regular);
                frame.setIconImage(iconBurg.getImage());
                break;
        }

        frame.add(card);
        frame.add(screen);
        frame.add(payment);
        frame.add(paymentPanel);  
        frame.add(mainte);   
        frame.add(dispense);
        frame.add(cancel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == dispense) {
            
        }
        if (e.getSource() == cancel) {
            payment.setText("Php 0.00");
        }
        if (e.getSource() == regular) {
            cardLayout.show(card, "Regular");
            frame.remove(regular);
            frame.add(special);
            frame.setIconImage(iconReg.getImage());
        }
        if (e.getSource() == special) {
            cardLayout.show(card, "Special");
            frame.remove(special);
            frame.add(regular);
            frame.setIconImage(iconBurg.getImage());
        }

    }
    
    public static void main(String[] args) {
        new VendoGUI(1);
    }
}
