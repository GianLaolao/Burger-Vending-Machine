
import javax.swing.*;

public class Main{
    public static void main(String[] args) {
        
        String[] options = {"Regular Vending Machine", "Special Vending Machine", "Exit Program"};
        int num = JOptionPane.showOptionDialog(null, "               Pick a Vending Machine:", "Vending Machine", 
                                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, 2);                    

        if (num != 2) 
            new VendoGUI(num);
        else 
            JOptionPane.showMessageDialog(null, "Thank You for your Patronage!", "Vending Machine", JOptionPane.PLAIN_MESSAGE);
                
    }

}
