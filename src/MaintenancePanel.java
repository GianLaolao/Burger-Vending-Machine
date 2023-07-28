
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.*;

public class MaintenancePanel extends JPanel implements ActionListener, ChangeListener {

    JLabel lSell, lNonSell, lCreate, lMoney, lSlot;
    
    JPanel mainteCard;
    CardLayout mainteCardLayout;
    JPanel pSellable, pNonSellableCreated, pMoneySlot;

    JPanel moneyPanel, slotPanel;
    JLabel one, five, ten, twenty, fifty, hundred, twoHun, fiveHun, thou; 
    JButton[] bAddMoney = new JButton[9];
    JSpinner[] moneySpinner = new JSpinner[9];

    String[] sellableItems;
    JComboBox[] itemSell = new JComboBox[8];

    JSpinner[] sellSpinners = new JSpinner[10];
    JButton[] restockSell = new JButton[10];
    JButton[] priceSell = new JButton[10];

    JSpinner[] nonSellSpinners = new JSpinner[8];
    JButton[] restockNonSell = new JButton[8];
    JButton[] priceNonSell = new JButton[8];

    JSpinner[] createdSpinners = new JSpinner[3];
    JButton[] restockCreated = new JButton[3];
    JButton[] priceCreated = new JButton[3];

    JButton sell, nonCre, monSlo;
    JButton regularB, specB, collectB, recordB;

    VendingMachine reg;
    VendingMachine spec;

    Item[] slotItems = new Item[8];
    int[] slotQuantity = new int[8];

    Font money = new Font ("Courier Bold",  Font.BOLD, 19);
    Font font2 = new Font("Monospaced Bold", Font.BOLD, 15);
    Font font3 = new Font("Monospaced Bold", Font.BOLD, 21);


    //TODO
    /*
     * Implement Set Price
     * use CardLayout
     */


    public MaintenancePanel(VendingMachine reg, VendingMachine spec) {

        this.reg = reg;
        this.spec = spec;

        setLayout(null);
        setBounds(10,10,715,820);
        setBackground(Color.LIGHT_GRAY);

        mainteCard = new JPanel(new CardLayout());
        mainteCard.setBounds(5, 10, 705, 580);
        mainteCardLayout = (CardLayout) mainteCard.getLayout();

        pSellable = new JPanel();
        pSellable.setBounds(0, 0, 705, 580);
        pSellable.setBackground(Color.WHITE);
        pSellable.setLayout(null); 
        pSellable.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.DARK_GRAY));

        lSell = new JLabel("Sellable Items");
        lSell.setBounds(270, 20, 200, 20);
        lSell.setFont(font3);
        lSell.setBackground(Color.LIGHT_GRAY);
        lSell.setHorizontalTextPosition(JLabel.CENTER);

        pSellable.add(lSell);

        

        for (int i = 0; i < 10; i++) {
                
            JLabel name = new JLabel("Item " + (i+1));
            name.setBounds(20, 60+(50*i), 100, 30);
            name.setBackground(Color.LIGHT_GRAY);
            name.setFont(font2);

            SpinnerModel value = new SpinnerNumberModel(0, 0, 10, 1);
            JSpinner spinner = new JSpinner(value);       
            spinner.setBounds(170, 60+(50*i), 60, 30);
            spinner.setFocusable(false);
            spinner.addChangeListener(this);
            spinner.setEditor(new JSpinner.DefaultEditor(spinner)); 

            JComponent editor = spinner.getEditor();
            ((JSpinner.DefaultEditor)editor).getTextField().setFocusable(false);
            
            sellSpinners[i] = spinner;
            
            JButton restock = new JButton("Restock");
            restock.setBounds(250, 60+(50*i), 100 , 30);
            restock.setFocusable(false);
            restock.setBorder(BorderFactory.createRaisedBevelBorder());
            restock.setBackground(Color.DARK_GRAY);
            restock.setForeground(Color.WHITE);
            restock.setFont(font2);
            restock.addActionListener(this);

            restockSell[i] = restock;

            JLabel php = new JLabel("Php:");
            php.setBounds(420, 60+(50*i), 50, 30);
            php.setBackground(Color.LIGHT_GRAY);
            php.setFont(font2);

            JTextField newPr = new JTextField();
            newPr.setBounds(460, 60+(50*i), 100, 30);
            newPr.setBackground(Color.LIGHT_GRAY);
            newPr.setHorizontalAlignment(JTextField.CENTER);
            newPr.setFont(font2);

            JButton price = new JButton("Set Price");
            price.setBounds(585, 60+(50*i), 100, 30);
            price.setFocusable(false);
            price.setBorder(BorderFactory.createRaisedBevelBorder());
            price.setBackground(Color.DARK_GRAY);
            price.setForeground(Color.WHITE);
            price.setFont(font2);
            price.addActionListener(this);

            priceSell[i] = price;

            pSellable.add(name);    
            pSellable.add(spinner);
            pSellable.add(restock);
            pSellable.add(php);
            pSellable.add(newPr);
            pSellable.add(price);
        }

        mainteCard.add(pSellable, "Sellable");

        pNonSellableCreated = new JPanel();
        pNonSellableCreated.setBounds(0, 0, 705, 580);
        pNonSellableCreated.setBackground(Color.WHITE);
        pNonSellableCreated.setLayout(null);
        pNonSellableCreated.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.DARK_GRAY));

        lNonSell = new JLabel("Non - Sellable Items");
        lNonSell.setBounds(270, 20, 200, 20);
        lNonSell.setFont(font2);
        lNonSell.setBackground(Color.LIGHT_GRAY);
        lNonSell.setHorizontalTextPosition(JLabel.CENTER);

        pNonSellableCreated.add(lNonSell);

        for (int i = 0; i < 8; i++) {

            JLabel name = new JLabel("Slot " + (i+1));
            name.setBounds(20, 50+(40*i), 100, 30);
            name.setBackground(Color.LIGHT_GRAY);
            name.setFont(font2);

            SpinnerModel value = new SpinnerNumberModel(0, 0, 10, 1);
            JSpinner spinner = new JSpinner(value);       
            spinner.setBounds(170, 50+(40*i), 60, 30);
            spinner.setFocusable(false);
            spinner.addChangeListener(this);

            spinner.setEditor(new JSpinner.DefaultEditor(spinner)); 
            JComponent editor = spinner.getEditor();
            ((JSpinner.DefaultEditor)editor).getTextField().setFocusable(false);

            nonSellSpinners[i] = spinner;

            JButton restock = new JButton("Restock");
            restock.setBounds(250, 50+(40*i), 100 , 30);
            restock.setFocusable(false);
            restock.setBorder(BorderFactory.createRaisedBevelBorder());
            restock.setBackground(Color.DARK_GRAY);
            restock.setForeground(Color.WHITE);
            restock.setFont(font2);
            restock.addActionListener(this);

            restockNonSell[i] = restock;
            
            JLabel php = new JLabel("Php:");
            php.setBounds(420, 50+(40*i), 50, 30);
            php.setBackground(Color.LIGHT_GRAY);
            php.setFont(font2);

            JTextField newPr = new JTextField();
            newPr.setBounds(460, 50+(40*i), 100, 30);
            newPr.setBackground(Color.LIGHT_GRAY);
            newPr.setHorizontalAlignment(JTextField.CENTER);
            newPr.setFont(font2);

            JButton price = new JButton("Set Price");
            price.setBounds(585, 50+(40*i), 100, 30);
            price.setFocusable(false);
            price.setBorder(BorderFactory.createRaisedBevelBorder());
            price.setBackground(Color.DARK_GRAY);
            price.setForeground(Color.WHITE);
            price.setFont(font2);
            price.addActionListener(this);

            priceNonSell[i] = price;

            pNonSellableCreated.add(name);
            pNonSellableCreated.add(spinner);
            pNonSellableCreated.add(restock);
            pNonSellableCreated.add(php);
            pNonSellableCreated.add(newPr);
            pNonSellableCreated.add(price);
        }

        lCreate = new JLabel("Created Items");
        lCreate.setBounds(300, 400, 250, 20);
        lCreate.setFont(font2);
        lCreate.setBackground(Color.LIGHT_GRAY);
        lCreate.setHorizontalTextPosition(JLabel.CENTER);

        pNonSellableCreated.add(lCreate);
        
        for (int i = 0; i < 3; i++) {

           JLabel name = new JLabel("Created " + (i+1));
            name.setBounds(20, 440+(40*i), 100, 30);
            name.setBackground(Color.LIGHT_GRAY);
            name.setFont(font2);

            SpinnerModel value = new SpinnerNumberModel(0, 0, 10, 1);
            JSpinner spinner = new JSpinner(value);       
            spinner.setBounds(170, 440+(40*i), 60, 30);
            spinner.setFocusable(false);
            spinner.addChangeListener(this);

            spinner.setEditor(new JSpinner.DefaultEditor(spinner)); 
            JComponent editor = spinner.getEditor();
            ((JSpinner.DefaultEditor)editor).getTextField().setFocusable(false);

            createdSpinners[i] = spinner;

            JButton restock = new JButton("Restock");
            restock.setBounds(250, 440+(40*i), 100 , 30);
            restock.setFocusable(false);
            restock.setBorder(BorderFactory.createRaisedBevelBorder());
            restock.setBackground(Color.DARK_GRAY);
            restock.setForeground(Color.WHITE);
            restock.setFont(font2);
            restock.addActionListener(this);

            restockCreated[i] = restock;
            
            JLabel php = new JLabel("Php:");
            php.setBounds(420, 440+(40*i), 50, 30);
            php.setBackground(Color.LIGHT_GRAY);
            php.setFont(font2);

            JTextField newPr = new JTextField();
            newPr.setBounds(460, 440+(40*i), 100, 30);
            newPr.setBackground(Color.LIGHT_GRAY);
            newPr.setHorizontalAlignment(JTextField.CENTER);
            newPr.setFont(font2);

            JButton price = new JButton("Set Price");
            price.setBounds(585, 440+(40*i), 100, 30);
            price.setFocusable(false);
            price.setBorder(BorderFactory.createRaisedBevelBorder());
            price.setBackground(Color.DARK_GRAY);
            price.setForeground(Color.WHITE);
            price.setFont(font2);
            price.addActionListener(this);

            priceCreated[i] = price;

            pNonSellableCreated.add(name);
            pNonSellableCreated.add(spinner);
            pNonSellableCreated.add(restock);
            pNonSellableCreated.add(php);
            pNonSellableCreated.add(newPr);
            pNonSellableCreated.add(price);
        }

        mainteCard.add(pNonSellableCreated, "NonSellCreated");

        pMoneySlot = new JPanel();
        pMoneySlot.setBounds(0, 0, 705, 580);
        pMoneySlot.setBackground(Color.WHITE);
        pMoneySlot.setLayout(null);
        pMoneySlot.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.DARK_GRAY));

        moneyPanel = new JPanel();
        moneyPanel.setBounds(10,10, 340, 560);
        moneyPanel.setBackground(Color.WHITE);
        moneyPanel.setLayout(null);
        moneyPanel.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.DARK_GRAY));

        lMoney = new JLabel("Money Box");
        lMoney.setBounds(110, 10, 100, 20);
        lMoney.setFont(font2);
        lMoney.setBackground(Color.LIGHT_GRAY);
        lMoney.setHorizontalTextPosition(JLabel.CENTER);

        moneyPanel.add(lMoney);

        one = new JLabel("(1)");
        one.setFont(money);
        one.setBounds(20, 60, 100, 20);

        five = new JLabel("(5)");
        five.setFont(money);
        five.setBounds(20, 110, 100, 20);

        ten = new JLabel("(10)");
        ten.setFont(money);
        ten.setBounds(20, 160, 100, 20);    

        twenty = new JLabel("(20)");
        twenty.setFont(money);
        twenty.setBounds(20, 210, 100, 20);

        fifty = new JLabel("[ 50 ]");
        fifty.setFont(money);
        fifty.setBounds(20, 260, 100, 20);

        hundred = new JLabel("[ 100 ]");
        hundred.setFont(money);
        hundred.setBounds(20, 310, 100, 20);

        twoHun = new JLabel("[ 200 ]");
        twoHun.setFont(money);
        twoHun.setBounds(20, 360,100, 20);
        
        fiveHun = new JLabel("[ 500 ]");
        fiveHun.setFont(money);
        fiveHun.setBounds(20, 410, 100, 20);

        thou = new JLabel("[ 1000 ]");
        thou.setFont(money);
        thou.setBounds(20,460,100, 20);

        moneyPanel.add(one);
        moneyPanel.add(five);
        moneyPanel.add(ten);
        moneyPanel.add(twenty);
        moneyPanel.add(fifty);
        moneyPanel.add(hundred);
        moneyPanel.add(twoHun);
        moneyPanel.add(fiveHun);
        moneyPanel.add(thou);

        for (int i = 0; i < 9; i++) {

            SpinnerModel value = new SpinnerNumberModel(0, 0, 99, 1);
            JSpinner spinner = new JSpinner(value);       
            spinner.setBounds(120, 60+(50*i), 80, 30);
            spinner.setFocusable(false);
            spinner.addChangeListener(this);

            spinner.setEditor(new JSpinner.DefaultEditor(spinner)); 
            JComponent editor = spinner.getEditor();
            ((JSpinner.DefaultEditor)editor).getTextField().setFocusable(false);

            moneySpinner[i] = spinner;

            JButton add = new JButton("Add");
            add.setBounds(220, 60+(50*i), 100 , 30);
            add.setFocusable(false);
            add.setBorder(BorderFactory.createRaisedBevelBorder());
            add.setBackground(Color.DARK_GRAY);
            add.setForeground(Color.WHITE);
            add.setFont(font2);
            add.addActionListener(this);

            bAddMoney[i] = add;

            moneyPanel.add(spinner);
            moneyPanel.add(add);
        }
        
        pMoneySlot.add(moneyPanel);

        slotPanel = new JPanel();
        slotPanel.setBounds(355,10, 340, 560);
        slotPanel.setBackground(Color.WHITE);
        slotPanel.setLayout(null);
        slotPanel.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.DARK_GRAY));

        lSlot = new JLabel("Item Slots");
        lSlot.setBounds(120, 10, 100, 20);
        lSlot.setFont(font2);
        lSlot.setBackground(Color.LIGHT_GRAY);
        lSlot.setHorizontalTextPosition(JLabel.CENTER);

        slotPanel.add(lSlot);

        String[] sellableItems = {"Item 1","Item 2", "Item 3", "Item 4"};

        for (int i = 0; i < 8; i++) {

            JLabel slot = new JLabel("Slot " + (i+1));
            slot.setBounds(20, 80+(50*i), 100, 30);
            slot.setBackground(Color.LIGHT_GRAY);
            slot.setFont(font2);

            JComboBox items = new JComboBox(sellableItems);
            items.setBounds(140, 80+(50*i), 150, 30);
            items.setFont(font2);
            items.setEditable(false);
            items.setFocusable(false);
            items.addActionListener(this);

            slotPanel.add(slot);
            slotPanel.add(items);

        }

        pMoneySlot.add(slotPanel);

        mainteCard.add(pMoneySlot, "MonSlo");

        sell = new JButton("Sellable Items");
        sell.setBounds(40, 600, 200, 40);
        sell.setFocusable(false);
        sell.setBackground(Color.WHITE);
        sell.setBorder(BorderFactory.createRaisedBevelBorder());
        sell.setFont(font2);
        sell.addActionListener(this);

        nonCre = new JButton("Non-Sellable Items");
        nonCre.setBounds(260, 600, 200, 40);
        nonCre.setFocusable(false);
        nonCre.setBackground(Color.WHITE);
        nonCre.setBorder(BorderFactory.createRaisedBevelBorder());
        nonCre.setFont(font2);
        nonCre.addActionListener(this);


        monSlo = new JButton("Vending Settings");
        monSlo.setBounds(480, 600, 200, 40);
        monSlo.setFocusable(false);
        monSlo.setBackground(Color.WHITE);
        monSlo.setBorder(BorderFactory.createRaisedBevelBorder());
        monSlo.setFont(font2);
        monSlo.addActionListener(this);

        collectB = new JButton ("Collect Money");
        collectB.setBounds(40, 680, 300, 50);
        collectB.setFont(font3);
        collectB.setFocusable(false);
        collectB.setBackground(Color.WHITE);
        collectB.setBorder(BorderFactory.createRaisedBevelBorder());
        collectB.addActionListener(this);

        recordB = new JButton ("Print Records");
        recordB.setBounds(40, 740, 300,50);
        recordB.setFont(font3);
        recordB.setFocusable(false);
        recordB.setBackground(Color.WHITE);
        recordB.setBorder(BorderFactory.createRaisedBevelBorder());
        recordB.addActionListener(this);

        regularB = new JButton("Regular Vending Machine");
        regularB.setBounds(380, 680, 300, 50);
        regularB.setFont(font2);
        regularB.setFocusable(false);
        regularB.setBackground(Color.WHITE);
        regularB.setBorder(BorderFactory.createRaisedBevelBorder());
        regularB.addActionListener(this);

        specB = new JButton("Special Vending Machine");
        specB.setBounds(380, 740, 300, 50);
        specB.setFont(font2);
        specB.setFocusable(false);
        specB.setBackground(Color.WHITE);
        specB.setBorder(BorderFactory.createRaisedBevelBorder());
        specB.addActionListener(this);

        mainteCardLayout.show(mainteCard, "MonSlo");

        add(mainteCard);
        add(sell);
        add(nonCre);
        add(monSlo);

        add(collectB);
        add(recordB);
        add(regularB);
        add(specB);
    
    }

    private boolean priceVerify (String price) {
        
        if(price.matches("^\\d+$"))
            return true;
           
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == collectB) {

        }
        if (e.getSource() == sell) {
            mainteCardLayout.show(mainteCard, "Sellable");
        }
        if (e.getSource() == nonCre) {
            mainteCardLayout.show(mainteCard, "NonSellCreated");
        }
        if (e.getSource() == monSlo){
             mainteCardLayout.show(mainteCard, "MonSlo");
        }
      
    }

    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        
    }


}   
