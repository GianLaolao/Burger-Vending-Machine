import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class VendoGUI extends JFrame implements ActionListener{
    
    JFrame frame;
    ImageIcon iconReg = new ImageIcon("Images/vendo.png");
    ImageIcon iconBurg = new ImageIcon("Images/burger.png");
    ImageIcon iconWrench =  new ImageIcon("Images/mainte.png");

    JButton mainte, regular, special, cancel, dispense; 

    CardLayout cardLayout;
    JPanel card;

    RegularPanel regPanel;
    SpecialPanel specPanel;
    MaintenancePanel maintePanel;

    JPanel paymentHolder;
    PaymentPanel paymentPanel;
    JTextField payment;
    JTextField screen;

    Font s = new Font("Dialog Plain", Font.PLAIN, 15);
    Font font1 = new Font("Monospaced Bold", Font.BOLD, 20);
    Font font2 = new Font("Monospaced Bold", Font.BOLD, 15);
 
    VendingMachine reg = new RegularVendo();
    VendingMachine spec = new SpecialVendo();
    Initialize initialize = new Initialize();

    public VendoGUI (int choice){ 
        
        VendingMachine.sellableInfos = initialize.initialize("src/ItemSellable.txt");
        VendingMachine.nonSellableInfos = initialize.initialize("src/ItemNonSell.txt");

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,870);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        paymentHolder = new JPanel();
        paymentHolder.setBounds(440,30, 280, 700);
        paymentHolder.setLayout(null);
        paymentHolder.setBackground(Color.LIGHT_GRAY);
        
        screen = new JTextField();
        screen.setBounds(20, 0, 250, 300);
        screen.setEditable(false);
        screen.setFont(s);
        screen.setFocusable(false);
        screen.setBackground(Color.DARK_GRAY);

        payment = new JTextField("Php 0.00");
        payment.setBounds(20, 330, 250, 40);
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

        dispense.setBounds(20, 630, 250, 30);
        dispense.setFont(font1);
        dispense.setFocusable(false);
        dispense.setBackground(Color.WHITE);
        dispense.setBorder(BorderFactory.createRaisedBevelBorder());

        cancel.setBounds(20, 670, 250, 30);
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
        mainte.addActionListener(this);

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
        maintePanel = new MaintenancePanel(reg, spec);
        paymentPanel = new PaymentPanel(payment, cancel);

        card = new JPanel(new CardLayout());
        card.setBounds(30, 10, 400, 720);
        card.add(regPanel, "Regular");
        card.add(specPanel, "Special");
        cardLayout = (CardLayout) card.getLayout();

        maintePanel.regularB.addActionListener(this);
        maintePanel.specB.addActionListener(this);
    
        switch(choice) {
            case 0:
                frame.add(card);   
                cardLayout.show(card, "Regular");
                frame.setTitle("Regular Vending Machine");
                frame.add(special);
                frame.add(mainte);   
                frame.setIconImage(iconReg.getImage());
                frame.add(paymentHolder);  
                break;
            case 1:
                frame.add(card);   
                cardLayout.show(card, "Special");
                frame.setTitle("Special Vending Machine");
                frame.add(regular);
                frame.add(mainte);   
                frame.setIconImage(iconBurg.getImage());
                frame.add(paymentHolder);  
                break;
            case 2: 
                frame.add(maintePanel);
                frame.setTitle("Vending Machine Maintenance");
                frame.setIconImage(iconWrench.getImage());
                break;
        }

        paymentHolder.add(paymentPanel);
        paymentHolder.add(payment);
        paymentHolder.add(screen);
        paymentHolder.add(dispense);
        paymentHolder.add(cancel);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == dispense) {
            
        }
        if (e.getSource() == cancel) {
            payment.setText("Php 0.00");
        }   
        if (e.getSource() == regular) {
            
            frame.revalidate();
            frame.repaint();

            frame.setTitle("Regular Vending Machine");
            frame.remove(regular);
            cardLayout.show(card, "Regular");
            frame.add(special);

            frame.revalidate();
            frame.repaint();

            frame.setIconImage(iconReg.getImage());
        }
        if (e.getSource() == special) {
            
            frame.revalidate();
            frame.repaint();

            frame.setTitle("Special Vending Machine");
            frame.remove(special);
            cardLayout.show(card, "Special");
            frame.add(regular);

            frame.revalidate();
            frame.repaint();

            frame.setIconImage(iconBurg.getImage());
        }
        if (e.getSource() == maintePanel.regularB){
           
            frame.remove(maintePanel);

            frame.revalidate();
            frame.repaint();

            frame.add(paymentHolder);
            frame.add(card);
            cardLayout.show(card, "Regular");
            frame.add(mainte);
            frame.add(special);

            frame.revalidate();
            frame.repaint();

            frame.setIconImage(iconReg.getImage());
        }
        if (e.getSource() == maintePanel.specB) {
    
            frame.remove(maintePanel);

            frame.revalidate();
            frame.repaint();

            frame.add(card);
            frame.add(paymentHolder);
            frame.add(card);
            cardLayout.show(card, "Special");
            frame.add(mainte);
            frame.add(regular);
            
            frame.revalidate();
            frame.repaint();

            frame.setIconImage(iconBurg.getImage());
        }
        if (e.getSource() == mainte){

            frame.setTitle("Vending Machine Maintenance");
            frame.remove(paymentHolder);

            if(frame.isAncestorOf(regPanel)) {
                frame.remove(regular);
                frame.remove(special);
            }
            if(frame.isAncestorOf(specPanel)) {
                frame.remove(regular);
                frame.remove(special);
            }
            frame.remove(card);
            frame.remove(mainte);

            frame.revalidate();
            frame.repaint();

            frame.add(maintePanel);

            frame.revalidate();
            frame.repaint();
    
            frame.setIconImage(iconWrench.getImage());
        } 

    }
    
    public static void main(String[] args) {
        new VendoGUI(1);
    }
}
