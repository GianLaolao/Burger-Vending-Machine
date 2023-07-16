import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class RegularGUI extends JFrame implements ActionListener{
    
    JFrame frame;
    JPanel itemHolder;
    JPanel itemPanel[] = new JPanel[8];
    JButton itemButton[] = new JButton[8];

    public RegularGUI (){ 

        frame = new JFrame("Regular Vending Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720,820);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);

        itemHolder = new JPanel(new GridLayout(4, 2,10,10));
        itemHolder.setBounds(0, 0, 420, 820);
        itemHolder.setBackground(Color.LIGHT_GRAY);

        


        frame.add(itemHolder);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
