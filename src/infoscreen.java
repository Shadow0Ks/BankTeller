import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class infoscreen extends JFrame {
    final private Font mainFont = new Font("Segeo Print", Font.BOLD, 18);

    //this defines the text fields of the screen
    JLabel lbtest;

    static JLabel JFirstName;
    static JLabel JLastName;
    static JLabel JMoneyInBank;
    static JLabel JCreditScore;
    static JLabel JCustomerID;
    public infoscreen() {
        JFirstName = new JLabel("First Name:");
        JFirstName.setFont(mainFont);

        JLastName = new JLabel("Last Name:");
        JLastName.setFont(mainFont);

        JMoneyInBank = new JLabel("Money in Bank:");
        JMoneyInBank.setFont(mainFont);

        JCreditScore = new JLabel("Your Credit Score:");
        JCreditScore.setFont(mainFont);


        JCustomerID = new JLabel("4 digit number ID:");
        JCustomerID.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 1, 5, 5));



        formPanel.add(JFirstName);
        //formPanel.add(TextFirstName);

        formPanel.add(JLastName);
        //formPanel.add(TextLastName);

        formPanel.add(JMoneyInBank);
        //formPanel.add(TextMoneyBox);

        formPanel.add(JCreditScore);
        //formPanel.add(TextCreditScore);

        formPanel.add(JCustomerID);
        //formPanel.add(TextCustomerID);



        lbtest = new JLabel();
        lbtest.setFont(mainFont);

        JButton btnOK = new JButton("Next");
        //btnOK.setFont(mainFont);
        Font largerFont = new Font("Segeo Print", Font.BOLD, 24); // Larger font size
        Dimension largerButtonSize = new Dimension(200, 50); // Larger button size (width, height)
        btnOK.setPreferredSize(largerButtonSize);   
        btnOK.setFont(largerFont);  
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                //new welcome();
                // prop up either new frame or box
            }
        });
         
        JPanel buttonpanel = new JPanel();
        buttonpanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonpanel.add(btnOK);

        JButton btnWithdraw = new JButton("withdraw");
        btnWithdraw.setFont(mainFont);
        btnWithdraw.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                 //withdraw button
                    JOptionPane.showInputDialog(null, "How much do you want to withdraw?");
                }
});

        JButton btnDeposit = new JButton("deposit");
        btnDeposit.setFont(mainFont);
        btnDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // deposit button
                JOptionPane.showInputDialog(null, "How much do you want to deposit?");
            }
        });

        JButton btnLoan = new JButton("Loan");
        btnLoan.setFont(mainFont);
        btnLoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // loan button
                int res = JOptionPane.showConfirmDialog(null, "Do you want a loan?");
                if (res == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Congrats you got a free loan!");
                }
                else if (res == JOptionPane.NO_OPTION){
                    JOptionPane.showMessageDialog(null,"Okay then, no loan then :(");
                }
    }
});
buttonpanel.add(btnWithdraw);
buttonpanel.add(btnDeposit);
buttonpanel.add(btnLoan);

// Add button panel to the window
       // window.add(buttonpanel, BorderLayout.SOUTH)


        JPanel window = new JPanel();
        window.setLayout(new BorderLayout());
        window.setBackground(new Color(128, 128, 255));
        window.add(formPanel, BorderLayout.NORTH);
        window.add(lbtest, BorderLayout.CENTER);
        window.add(buttonpanel, BorderLayout.SOUTH);

        add(window);

        setSize(600, 840);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setTitle("Here is your info good sir");
        setLocationRelativeTo(null);
        setVisible(true);

        // Initialize components
        initComponents();
    }

    private void initComponents() {
        // Create a panel for customer information
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5, 2, 5, 5));

        // Add infoPanel and backButton to JFrame
        add(infoPanel, BorderLayout.CENTER);

    }


//    public void initialize() {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
//    }



    public static void displayCustomerInfo(String[] customerInfo){
                JFirstName.setText("First Name: " + customerInfo[0]);
                JLastName.setText("Last Name: " + customerInfo[1]);
                JMoneyInBank.setText("Money in Bank: " + customerInfo[2]);
                JCreditScore.setText("Your Credit Score: " + customerInfo[3]);
                JCustomerID.setText("4 digit number ID: " + customerInfo[4]);

    }
}