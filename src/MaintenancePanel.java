
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MaintenancePanel extends JFrame implements ActionListener {

    
    JFrame frame;

    JComboBox itemSellable;
    JComboBox itemNotSell;

    JPanel itemPanel;

    public MaintenancePanel() {

        frame = new JFrame("Maintenance Mode");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720,850);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        itemSellable = new JComboBox<>();
        
       
        
    }

    
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    
    }

}
