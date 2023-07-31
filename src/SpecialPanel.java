
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
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
    JPanel addOnPanel;
    JScrollPane scrollAddOn;

    JTextField sellField[] = new JTextField[10];
    JTextField nonSellField[] = new JTextField[8];

    JRadioButton[] sellable = new JRadioButton[10];
    JRadioButton[] nonSellable = new JRadioButton[8];

    JLabel[] sellLabels = new JLabel[10];
    JLabel[] nonSellLabels = new JLabel[8];

    JButton cancel, dispense;
    JTextArea screen;

    Item order[] = new Item[4];
    ArrayList<Item> addOns = new ArrayList<>();

    Font font1 = new Font("Monospaced Bold", Font.BOLD, 20);
    Font font2 = new Font("Monospaced Bold", Font.BOLD, 15);
 

    SpecialPanel(JButton cancel, JButton dispense, JTextArea screen) {  

        this.cancel = cancel;
        cancel.addActionListener(this);

        this.dispense = dispense;
        dispense.addActionListener(this);

        this.screen = screen;

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
        sesame.setBounds(20, 30, 200, 20);
        sesame.setFocusable(false);
        sesame.setBackground(Color.white);

        wheat = new JRadioButton("Whole Wheat Bun");
        wheat.setFont(font2);
        wheat.setBounds(20, 60, 200, 20);
        wheat.setFocusable(false);
        wheat.setBackground(Color.white);

        brioche = new JRadioButton("Soft Brioche Bun");
        brioche.setFont(font2);
        brioche.setBounds(20, 90, 200,20);
        brioche.setFocusable(false);
        brioche.setBackground(Color.white);

        for (int i = 0; i < 3; i++) {
            JLabel price = new JLabel("Php: " + Integer.toString(RegularVendo.sellableItems[i].getPrice()));
            price.setBounds(240, 30+(30*i), 80, 20);
            price.setFont(font2);
            price.setBackground(Color.WHITE);

            sellLabels[i] = price;

            JTextField stockTF = new JTextField();
            stockTF.setBounds(340, 30+(30*i), 30, 20);
            stockTF.setEditable(false);
            stockTF.setFocusable(false);
            stockTF.setText(Integer.toString(RegularVendo.sellableItems[i].getStock().size()));

            sellField[i] = stockTF;

            add(price);
            add(stockTF);
        }        

        bread = new ButtonGroup();
        bread.add(sesame);
        bread.add(wheat);
        bread.add(brioche);

        beef = new JRadioButton("Beef Patty");
        beef.setFont(font2);
        beef.setBounds(20, 150, 200, 20);
        beef.setFocusable(false);
        beef.setBackground(Color.white);

        vegan = new JRadioButton("Plant Based Patty");
        vegan.setFont(font2);
        vegan.setBounds(20, 180, 200, 20);
        vegan.setFocusable(false);
        vegan.setBackground(Color.white);

        chicken = new JRadioButton("Crispy Chicken");
        chicken.setFont(font2);
        chicken.setBounds(20, 210, 200, 20);
        chicken.setFocusable(false);
        chicken.setBackground(Color.white);

        for (int i = 0; i < 3; i++) {
            JLabel price = new JLabel("Php: " + Integer.toString(RegularVendo.sellableItems[i+3].getPrice()));
            price.setBounds(240, 150+(30*i), 80, 20);
            price.setFont(font2);
            price.setBackground(Color.WHITE);

            sellLabels[i+3] = price;

            JTextField stockTF = new JTextField();
            stockTF.setBounds(340, 150+(30*i), 30, 20);
            stockTF.setEditable(false);
            stockTF.setFocusable(false);
            stockTF.setText(Integer.toString(RegularVendo.sellableItems[i+3].getStock().size()));

            sellField[i+3] = stockTF;

            add(price);
            add(stockTF);
        }        

        meat = new ButtonGroup();
        meat.add(beef);
        meat.add(vegan);
        meat.add(chicken);

        american = new JRadioButton("American Cheese");
        american.setFont(font2);
        american.setBounds(20, 270, 200, 20);
        american.setFocusable(false);
        american.setBackground(Color.white);

        cheddar = new JRadioButton("Cheddar Cheese");
        cheddar.setFont(font2);
        cheddar.setBounds(20, 300, 200, 20);
        cheddar.setFocusable(false);
        cheddar.setBackground(Color.white);
        
        swiss = new JRadioButton("Swiss Cheese");
        swiss.setFont(font2);
        swiss.setBounds(20, 330, 200, 20);
        swiss.setFocusable(false);
        swiss.setBackground(Color.white);

        noC = new JRadioButton("No Cheese");
        noC.setFont(font2);
        noC.setBounds(20, 360, 300, 20);
        noC.setFocusable(false);
        noC.setBackground(Color.white);

        for (int i = 0; i < 3; i++) {
            JLabel price = new JLabel("Php: " + Integer.toString(SpecialVendo.nonSellableItems[i+4].getPrice()));
            price.setBounds(240, 270+(30*i), 80, 20);
            price.setFont(font2);
            price.setBackground(Color.WHITE);

            nonSellLabels[i+4] = price;

            JTextField stockTF = new JTextField();
            stockTF.setBounds(340, 270+(30*i), 30, 20);
            stockTF.setEditable(false);
            stockTF.setFocusable(false);
            stockTF.setText(Integer.toString(SpecialVendo.nonSellableItems[i+4].getStock().size()));

            nonSellField[i+4] = stockTF;

            add(price);
            add(stockTF);
        }        
    
        cheese = new ButtonGroup();
        cheese.add(american);
        cheese.add(cheddar);
        cheese.add(swiss);
        cheese.add(noC);

        bbq = new JRadioButton("Barbeque Sauce");
        bbq.setFont(font2);
        bbq.setBounds(20, 420, 200, 20);
        bbq.setFocusable(false);
        bbq.setBackground(Color.white);

        ket = new JRadioButton("Tomato Ketchup");
        ket.setFont(font2);
        ket.setBounds(20, 450, 200, 20);
        ket.setFocusable(false);
        ket.setBackground(Color.white);

        mayo = new JRadioButton("Mayonnaise");
        mayo.setFont(font2);
        mayo.setBounds(20, 480, 200, 20);
        mayo.setFocusable(false);
        mayo.setBackground(Color.white);

        thouIsl = new JRadioButton("Thousand Island");
        thouIsl.setFont(font2);
        thouIsl.setBounds(20, 510, 200, 20);
        thouIsl.setFocusable(false);
        thouIsl.setBackground(Color.white);
        
        for (int i = 0; i < 4; i++) {
            JLabel price = new JLabel("Stock: ");
            price.setBounds(240, 420+(30*i), 80, 20);
            price.setFont(font2);
            price.setBackground(Color.WHITE);

            JTextField stockTF = new JTextField();
            stockTF.setBounds(340, 420+(30*i), 30, 20);
            stockTF.setEditable(false);
            stockTF.setFocusable(false);

            if (i == 0) {
                stockTF.setText(Integer.toString(SpecialVendo.nonSellableItems[7].getStock().size()));
                nonSellField[7] = stockTF;
            }        
            add(price);
            add(stockTF);
        }        

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

        addOnPanel = new JPanel();
        addOnPanel.setLayout(new GridLayout(8, 3));
        addOnPanel.setSize(new Dimension(400, 135));
        addOnPanel.setBackground(Color.WHITE);

        bacon = new JRadioButton("Crispy Bacon Strips");
        bacon.setFont(font2);
        bacon.setFocusable(false);
        bacon.setBackground(Color.white);

        ham = new JRadioButton("Sweet Smoked Ham");
        ham.setFont(font2);
        ham.setFocusable(false);
        ham.setBackground(Color.white);

        egg = new JRadioButton("Sunny Side ");
        egg.setFont(font2);
        egg.setFocusable(false);
        egg.setBackground(Color.white);

        sausage = new JRadioButton("Smoked Sausage");
        sausage.setFont(font2);
        sausage.setFocusable(false);
        sausage.setBackground(Color.white);

        for (int i = 0; i < 4; i++) {
            JLabel price = new JLabel("Php: " + Integer.toString(SpecialVendo.sellableItems[i+6].getPrice()));
            price.setSize(new Dimension(80, 20));
            price.setFont(font2);
            price.setBackground(Color.WHITE);
            price.setHorizontalAlignment(JLabel.CENTER);

            sellLabels[i+6] = price;

            JTextField stockTF = new JTextField();
            stockTF.setSize(new Dimension(30, 20));
            stockTF.setEditable(false);
            stockTF.setFocusable(false);
            stockTF.setText(Integer.toString(RegularVendo.sellableItems[i+6].getStock().size()));

            sellField[i+6] = stockTF;
        }

        tomato = new JRadioButton("Fresh Tomato Slices");
        tomato.setFont(font2);
        tomato.setFocusable(false);
        tomato.setBackground(Color.white);

        lettuce = new JRadioButton("Iceberg Lettuce");
        lettuce.setFont(font2);
        lettuce.setFocusable(false);
        lettuce.setBackground(Color.white);

        pickle = new JRadioButton("Fresh Pickles");
        pickle.setFont(font2);
        pickle.setFocusable(false);
        pickle.setBackground(Color.white);

        onion = new JRadioButton("Sweet Red Onion");
        onion.setFont(font2);
        onion.setFocusable(false);
        onion.setBackground(Color.white);
        
        for (int i = 0; i < 4; i++) {
            JLabel price = new JLabel("Php: " + Integer.toString(SpecialVendo.nonSellableItems[i].getPrice()));
            price.setSize(new Dimension(80, 20));
            price.setFont(font2);
            price.setBackground(Color.WHITE);
            price.setHorizontalAlignment(JLabel.CENTER);

            nonSellLabels[i] = price;

            JTextField stockTF = new JTextField();
            stockTF.setSize(new Dimension(30, 20));
            stockTF.setEditable(false);
            stockTF.setFocusable(false);
            stockTF.setText(Integer.toString(SpecialVendo.nonSellableItems[i].getStock().size()));

            nonSellField[i] = stockTF;
        }
        
        addOnPanel.add(bacon);
        addOnPanel.add(sellLabels[6]);
        addOnPanel.add(sellField[6]);
        addOnPanel.add(ham);
        addOnPanel.add(sellLabels[7]);
        addOnPanel.add(sellField[7]);
        addOnPanel.add(egg);
        addOnPanel.add(sellLabels[8]);
        addOnPanel.add(sellField[8]);
        addOnPanel.add(sausage);
        addOnPanel.add(sellLabels[9]);
        addOnPanel.add(sellField[9]);
        addOnPanel.add(tomato);
        addOnPanel.add(nonSellLabels[0]);
        addOnPanel.add(nonSellField[0]);
        addOnPanel.add(lettuce);
        addOnPanel.add(nonSellLabels[1]);
        addOnPanel.add(nonSellField[1]);
        addOnPanel.add(pickle);
        addOnPanel.add(nonSellLabels[2]);
        addOnPanel.add(nonSellField[2]);
        addOnPanel.add(onion);
        addOnPanel.add(nonSellLabels[3]);
        addOnPanel.add(nonSellField[3]);

        scrollAddOn = new JScrollPane(addOnPanel);
        scrollAddOn.setBounds(0, 590, 400, 135);
        scrollAddOn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollAddOn.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        setBounds(20, 10, 400, 720);
        setBackground(Color.WHITE);
        setLayout(null);
        setBorder(BorderFactory.createLoweredBevelBorder());
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
        add(scrollAddOn);

    }

    public void updateStock () {

        for (int i = 0; i < 10; i++) { 
            sellField[i].setText(Integer.toString(RegularVendo.sellableItems[i].getStock().size()));
            sellLabels[i].setText("Php: " + Integer.toString(RegularVendo.sellableItems[i].getPrice()));
            
            if(i < 7) {
                nonSellField[i].setText(Integer.toString(SpecialVendo.sellableItems[i].getStock().size()));
                nonSellLabels[i].setText("Php: " + Integer.toString(SpecialVendo.nonSellableItems[i].getPrice()));
            }        
        }
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
