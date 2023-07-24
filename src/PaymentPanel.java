import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class PaymentPanel extends JPanel implements ActionListener {

    JButton one, five, ten, twenty, fifty, hundred, twoHun, fiveHun, thou;
    JButton moneyButton[] = new JButton[9];
    JTextField payment;

    JButton cancel;

    Font font1 = new Font("Monospaced Bold", Font.BOLD, 20);
    Font font2 = new Font("Monospaced Bold", Font.BOLD, 15);

    VendingMachine vending;

    double total = 0.00;

    public PaymentPanel(JTextField payment, JButton cancel) {

        this.payment = payment;
        
        this.cancel = cancel;
        cancel.addActionListener(this);

        moneyButton[0] = one = new JButton("1");
        moneyButton[1] = five = new JButton("5");
        moneyButton[2] = ten = new JButton("10");
        moneyButton[3] = twenty = new JButton("20");
        moneyButton[4] = fifty = new JButton("50");
        moneyButton[5] = hundred = new JButton("100");
        moneyButton[6] = twoHun = new JButton("200");
        moneyButton[7] = fiveHun = new JButton("500");
        moneyButton[8] = thou = new JButton("1000");

        this.setLayout(new GridLayout(3, 3, 2, 2));
        this.setBounds(475, 420, 220, 220);
        this.setBackground(Color.LIGHT_GRAY);

        for(int i = 0; i < 9; i++) {
            moneyButton[i].setBounds(0, 0, 50, 50);
            moneyButton[i].setFont(font2);
            moneyButton[i].addActionListener(this);
            moneyButton[i].setFocusable(false);
            moneyButton[i].setBackground(Color.WHITE);
            moneyButton[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));

            this.add(moneyButton[i]);
        }
    }



    public void actionPerformed(ActionEvent e) {
    
        if (e.getSource() == one){
            total += 1;
            payment.setText("Php " + String.format("%.2f", total));
        }
        if (e.getSource() == five){
            total += 5;
            payment.setText("Php " + String.format("%.2f", total));
        }
        if (e.getSource() == ten){
            total += 10;
            payment.setText("Php " + String.format("%.2f", total));
        }
        if (e.getSource() == twenty){
            total += 20;
            payment.setText("Php " + String.format("%.2f", total));
        }
        if (e.getSource() == fifty){
            total += 50;
            payment.setText("Php " + String.format("%.2f", total));
        }
        if (e.getSource() == hundred){
            total += 100;
            payment.setText("Php " + String.format("%.2f", total));
        }
        if (e.getSource() == twoHun){
            total += 200;
            payment.setText("Php " + String.format("%.2f", total));
        }
        if (e.getSource() == fiveHun){
            total += 500;
            payment.setText("Php " + String.format("%.2f", total));
        }
        if (e.getSource() == thou){
            total += 1000;
            payment.setText("Php " + String.format("%.2f", total));
        }
        if (e.getSource() ==  cancel) {
            total = 0.00;        
        }
        
    }
    
}
