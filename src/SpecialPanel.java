
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SpecialPanel extends JPanel implements ActionListener, ItemListener {

    JLabel b, m, c, s, addOn;
    JRadioButton sesame, wheat, brioche;
    ButtonGroup bread;
    JRadioButton beef, vegan, chicken;
    ButtonGroup meat;
    JRadioButton american, cheddar, swiss, noC;
    ButtonGroup cheese;
    JRadioButton bbq, ket, mayo, thouIsl, noS;
    ButtonGroup sauce;
    JRadioButton bacon, egg,  ham, sausage, tomato, lettuce, pickle, onion;

    JButton cancel, dispense;

    Font font1 = new Font("Monospaced Bold", Font.BOLD, 20);
    Font font2 = new Font("Monospaced Bold", Font.BOLD, 15);
 

    SpecialPanel(JButton cancel, JButton dispense) {  

        this.cancel = cancel;
        cancel.addActionListener(this);

        this.dispense = dispense;
        dispense.addActionListener(this);

        b = new JLabel("Choose Bun:");
        b.setBounds(0,0, 400, 20);
        b.setFont(font2);
        b.setOpaque(true);
        b.setBackground(Color.LIGHT_GRAY);
        b.setHorizontalAlignment(JLabel.CENTER);

        m = new JLabel("Choose Meat:");
        m.setBounds(0, 120, 400, 20);
        m.setFont(font2);
        m.setOpaque(true);
        m.setBackground(Color.LIGHT_GRAY);
        m.setHorizontalAlignment(JLabel.CENTER);

        c = new JLabel("Choose Cheese:");
        c.setBounds(0, 240,400, 20);
        c.setFont(font2);
        c.setOpaque(true);
        c.setBackground(Color.LIGHT_GRAY);
        c.setHorizontalAlignment(JLabel.CENTER);

        s = new JLabel("Choose Sauce:");
        s.setBounds(0, 390, 400, 20);
        s.setFont(font2);
        s.setOpaque(true);
        s.setBackground(Color.LIGHT_GRAY);
        s.setHorizontalAlignment(JLabel.CENTER);

        addOn = new JLabel("Choose Add-ons:");
        addOn.setBounds(0, 570,400, 20);
        addOn.setFont(font2);
        addOn.setOpaque(true);
        addOn.setBackground(Color.LIGHT_GRAY);
        addOn.setHorizontalAlignment(JLabel.CENTER);
        
        sesame = new JRadioButton("Sesame Seed Bun");
        sesame.setFont(font2);
        sesame.setBounds(50, 30, 300, 20);
        sesame.setFocusable(false);
        sesame.setBackground(Color.white);

        wheat = new JRadioButton("Whole Wheat Bun");
        wheat.setFont(font2);
        wheat.setBounds(50, 60, 300, 20);
        wheat.setFocusable(false);
        wheat.setBackground(Color.white);

        brioche = new JRadioButton("Soft Brioche Bun");
        brioche.setFont(font2);
        brioche.setBounds(50, 90, 300,20);
        brioche.setFocusable(false);
        brioche.setBackground(Color.white);

        bread = new ButtonGroup();
        bread.add(sesame);
        bread.add(wheat);
        bread.add(brioche);

        beef = new JRadioButton("Beef Patty");
        beef.setFont(font2);
        beef.setBounds(50, 150, 300, 20);
        beef.setFocusable(false);
        beef.setBackground(Color.white);

        vegan = new JRadioButton("Plant Based Patty");
        vegan.setFont(font2);
        vegan.setBounds(50, 180, 300, 20);
        vegan.setFocusable(false);
        vegan.setBackground(Color.white);

        chicken = new JRadioButton("Crispy Chicken");
        chicken.setFont(font2);
        chicken.setBounds(50, 210, 300, 20);
        chicken.setFocusable(false);
        chicken.setBackground(Color.white);

        meat = new ButtonGroup();
        meat.add(beef);
        meat.add(vegan);
        meat.add(chicken);

        american = new JRadioButton("American Cheese");
        american.setFont(font2);
        american.setBounds(50, 270, 300, 20);
        american.setFocusable(false);
        american.setBackground(Color.white);

        cheddar = new JRadioButton("Cheddar Cheese");
        cheddar.setFont(font2);
        cheddar.setBounds(50, 300, 300, 20);
        cheddar.setFocusable(false);
        cheddar.setBackground(Color.white);
        
        swiss = new JRadioButton("Swiss Cheese");
        swiss.setFont(font2);
        swiss.setBounds(50, 330, 300, 20);
        swiss.setFocusable(false);
        swiss.setBackground(Color.white);
    
        noC = new JRadioButton("No Cheese");
        noC.setFont(font2);
        noC.setBounds(50, 360, 300, 20);
        noC.setFocusable(false);
        noC.setBackground(Color.white);

        cheese = new ButtonGroup();
        cheese.add(american);
        cheese.add(cheddar);
        cheese.add(swiss);
        cheese.add(noC);

        bbq = new JRadioButton("Barbeque Sauce");
        bbq.setFont(font2);
        bbq.setBounds(50, 420, 300, 20);
        bbq.setFocusable(false);
        bbq.setBackground(Color.white);

        ket = new JRadioButton("Tomato Ketchup");
        ket.setFont(font2);
        ket.setBounds(50, 450, 300, 20);
        ket.setFocusable(false);
        ket.setBackground(Color.white);

        mayo = new JRadioButton("Mayonnaise");
        mayo.setFont(font2);
        mayo.setBounds(50, 480, 300, 20);
        mayo.setFocusable(false);
        mayo.setBackground(Color.white);

        thouIsl = new JRadioButton("Thousand Island");
        thouIsl.setFont(font2);
        thouIsl.setBounds(50, 510, 300, 20);
        thouIsl.setFocusable(false);
        thouIsl.setBackground(Color.white);

        noS = new JRadioButton("No Sauce");
        noS.setFont(font2);
        noS.setBounds(50, 540, 300, 20);
        noS.setFocusable(false);
        noS.setBackground(Color.white);

        sauce = new ButtonGroup();
        sauce.add(bbq);
        sauce.add(ket);
        sauce.add(mayo);
        sauce.add(thouIsl);
        sauce.add(noS);

        bacon = new JRadioButton("Crispy Bacon Strips");
        bacon.setFont(font2);
        bacon.setBounds(10, 600, 180, 20);
        bacon.setFocusable(false);
        bacon.setBackground(Color.white);

        egg = new JRadioButton("Sunny Side ");
        egg.setFont(font2);
        egg.setBounds(10, 630, 180, 20);
        egg.setFocusable(false);
        egg.setBackground(Color.white);

        ham = new JRadioButton("Sweet Smoked Ham");
        ham.setFont(font2);
        ham.setBounds(10, 660, 180, 20);
        ham.setFocusable(false);
        ham.setBackground(Color.white);

        sausage = new JRadioButton("Smoked Sausage");
        sausage.setFont(font2);
        sausage.setBounds(10, 690, 180, 20);
        sausage.setFocusable(false);
        sausage.setBackground(Color.white);

        lettuce = new JRadioButton("Iceberg Lettuce");
        lettuce.setFont(font2);
        lettuce.setBounds(210, 600, 180, 20);
        lettuce.setFocusable(false);
        lettuce.setBackground(Color.white);

        onion = new JRadioButton("Sweet Red Onion");
        onion.setFont(font2);
        onion.setBounds(210, 630, 180, 20);
        onion.setFocusable(false);
        onion.setBackground(Color.white);

        pickle = new JRadioButton("Fresh Pickles");
        pickle.setFont(font2);
        pickle.setBounds(210, 660, 180, 20);
        pickle.setFocusable(false);
        pickle.setBackground(Color.white);

        tomato = new JRadioButton("Fresh Tomato Slices");
        tomato.setFont(font2);
        tomato.setBounds(210, 690, 180, 20);
        tomato.setFocusable(false);
        tomato.setBackground(Color.white);

        setBounds(30, 10, 400, 720);
        setBackground(Color.WHITE);
        setLayout(null);
        add(b);
        add(m);
        add(c);
        add(s);
        add(addOn);
        add(sesame);
        add(wheat);
        add(brioche);
        add(beef);
        add(vegan);
        add(chicken);
        add(american);
        add(cheddar);
        add(swiss);
        add(noC);
        add(bbq);
        add(ket);
        add(mayo);
        add(thouIsl);
        add(noS);
        add(bacon);
        add(egg);
        add(ham);
        add(sausage);
        add(lettuce);
        add(onion);
        add(pickle);
        add(tomato);

    }

    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == cancel) {
            bread.clearSelection();
            meat.clearSelection();
            sauce.clearSelection();
            cheese.clearSelection();
            bacon.setSelected(false);
            egg.setSelected(false);
            ham.setSelected(false);
            sausage.setSelected(false);
            tomato.setSelected(false);
            lettuce.setSelected(false); 
            pickle.setSelected(false);
            onion.setSelected(false);
        }
    }    
}
