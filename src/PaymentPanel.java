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

    VendingMachine vendo;

    private final String indent = "                  ";

    public PaymentPanel(JTextField payment, JButton cancel, VendingMachine vendo) {

        this.payment = payment;
        
        this.cancel = cancel;
        cancel.addActionListener(this);

        this.vendo = vendo;

        moneyButton[0] = one = new JButton("1");
        moneyButton[1] = five = new JButton("5");
        moneyButton[2] = ten = new JButton("10");
        moneyButton[3] = twenty = new JButton("20");
        moneyButton[4] = fifty = new JButton("50");
        moneyButton[5] = hundred = new JButton("100");
        moneyButton[6] = twoHun = new JButton("200");
        moneyButton[7] = fiveHun = new JButton("500");
        moneyButton[8] = thou = new JButton("1000");

        setLayout(new GridLayout(3, 3, 2, 2));
        setBounds(35, 400, 220, 220);
        setBackground(Color.LIGHT_GRAY);

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
            vendo.getMoneyCalc().getUserMoney().setDenom(0, 1);
            payment.setText("Php " + String.format("%.2f", Float.valueOf( vendo.getMoneyCalc().getUserMoney().getTotal())));
        }
        if (e.getSource() == five){
             vendo.getMoneyCalc().getUserMoney().setDenom(1, 1);
            payment.setText("Php " + String.format("%.2f", Float.valueOf( vendo.getMoneyCalc().getUserMoney().getTotal())));
        }
        if (e.getSource() == ten){
             vendo.getMoneyCalc().getUserMoney().setDenom(2, 1);
            payment.setText("Php " + String.format("%.2f", Float.valueOf( vendo.getMoneyCalc().getUserMoney().getTotal())));
        }
        if (e.getSource() == twenty){
             vendo.getMoneyCalc().getUserMoney().setDenom(3, 1);
            payment.setText("Php " + String.format("%.2f", Float.valueOf( vendo.getMoneyCalc().getUserMoney().getTotal())));
        }
        if (e.getSource() == fifty){
             vendo.getMoneyCalc().getUserMoney().setDenom(4, 1);
            payment.setText("Php " + String.format("%.2f", Float.valueOf( vendo.getMoneyCalc().getUserMoney().getTotal())));
        }
        if (e.getSource() == hundred){
             vendo.getMoneyCalc().getUserMoney().setDenom(5, 1);
            payment.setText("Php " + String.format("%.2f", Float.valueOf( vendo.getMoneyCalc().getUserMoney().getTotal())));
        }
        if (e.getSource() == twoHun){
             vendo.getMoneyCalc().getUserMoney().setDenom(6, 1);
            payment.setText("Php " + String.format("%.2f", Float.valueOf( vendo.getMoneyCalc().getUserMoney().getTotal())));
        }
        if (e.getSource() == fiveHun){
             vendo.getMoneyCalc().getUserMoney().setDenom(7, 1);
            payment.setText("Php " + String.format("%.2f", Float.valueOf( vendo.getMoneyCalc().getUserMoney().getTotal())));
        }
        if (e.getSource() == thou){
             vendo.getMoneyCalc().getUserMoney().setDenom(8, 1);
            payment.setText("Php " + String.format("%.2f", Float.valueOf( vendo.getMoneyCalc().getUserMoney().getTotal())));
        }
        if (e.getSource() ==  cancel) {
            MoneyBox x =  vendo.getMoneyCalc().getUserMoney();
            String message = "         Payment Returned \n\n" +
                            "Value:\t\tQuantity: \n";

            JTextArea text = new JTextArea();
            text.setEditable(false);
            text.setFont(font2);
            text.setBackground(new Color(0xEEEEEE));
           
            for (int i = 0; i < 9; i++) {
                if (x.getDenominations()[i].getQuantity() != 0) {
                    String a = Integer.toString(x.getDenominations()[i].getValue());
                    a += indent.substring(0, indent.length() - a.length());
                    message += " " + a + "\t\t " + x.getDenominations()[i].getQuantity() + "\n"; 
                }
            }

            text.setText(message);

             vendo.getMoneyCalc().resetUserMoney();
            JOptionPane.showMessageDialog(null, text, "Payment Return", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
}
