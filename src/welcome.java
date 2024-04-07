import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class welcome extends JFrame implements ItemListener {
    int SCREEN_WIDTH = 800;
    int SCREEN_HEIGHT = 600;
    /*-------------------------------------------------------------------------------------------------------*/

    private Font font;
    /*--------------------------------------------------------*/
    //Next page and previous page buttons
    JButton nextPage;
    JButton prevPage;


    static String file = "src\\customer_data.csv";
    List<Customer> customers = new ArrayList<>();


    public welcome(){
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        //set title screen
        setTitle("Bank Teller");
        setLocationRelativeTo(null);
        setVisible(true);


        // WHY DOES THIS STILL HAVE IT OPEN
        //fixed

        int nextPageX = SCREEN_WIDTH - 150;
        int nextPageY = SCREEN_HEIGHT - 80;
        nextPage = new JButton("Next page");
    
        nextPage.setBounds(nextPageX ,  nextPageY,100,30);
        add(nextPage, BorderLayout.SOUTH);

        //when next button is clicked jumps tp
        nextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); //CLOSES WINDOW

                //just closes the window
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                       
                        accountquestion window = new accountquestion();
                        window.initialize();
                    }
                });
            }
        });
        
    }
        


        

    void drawRectangles(Graphics graphics){
        //x,y location of the rectangle
        //w,h size of it
        int rectWidth = 100;
        int rectHeight  = 50;
        int rectX = (SCREEN_WIDTH - rectWidth) / 2;
        int rectY = (SCREEN_HEIGHT - rectHeight) / 2;

        graphics.setColor(Color.BLACK);
        graphics.drawRect(rectX, rectY, rectWidth,rectHeight);
        welcomeScreen(graphics);

    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        drawRectangles(graphics);
    }



    public void welcomeScreen(Graphics graphics){
        //set the font of the text
        //font = new Font("Arial", Font.ITALIC, 50);
        font = new Font("Arial", Font.ITALIC, calculateFontSize());
        paintComponents(graphics);
        graphics.setFont(font);
        graphics.setColor(Color.BLACK);

        String message = "Welcome to the Bank :3!";

        //set the location of the text
        int x = (getWidth() - graphics.getFontMetrics().stringWidth(message)) / 2;
        int y = getHeight() / 2;
        //display the text on the screen
        graphics.drawString(message, x, y);
        //(optional) set a background of the screen
        //when button is clicked on screen take me to the next screen


        //clear the screen
    }

    private int calculateFontSize(){
        int screenSize = getWidth() * getHeight();
        int fontSize = (int)(Math.sqrt(screenSize) / 50);
        return fontSize;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }


    //NO WINDOW
    public class NoAccountWindow extends JFrame {
        final private Font mainFont = new Font("Segeo Print", Font.BOLD, 18);
        
        //this defines the text fields of the screen
        JTextField TextFirstName, TextLastName, TextMoneyBox, TextCreditScore,TextCustomerID;
        JLabel lbtest;

        public void initialize() {

            TextFirstName = new JTextField();
            TextFirstName.setFont(mainFont);

            TextLastName = new JTextField();
            TextLastName.setFont(mainFont);

            TextMoneyBox = new JTextField();
            TextMoneyBox.setFont(mainFont);

            TextCreditScore = new JTextField();
            TextCreditScore.setFont(mainFont);

            TextCustomerID = new JTextField();
            TextCustomerID.setFont(mainFont);

            JLabel JFirstName = new JLabel("First Name");
            JFirstName.setFont(mainFont);


            JLabel JLastName = new JLabel("Last Name");
            JLastName.setFont(mainFont);

            JLabel JMoneyInBank = new JLabel("Money to deposit in Bank");
            JMoneyInBank.setFont(mainFont);

            JLabel JCreditScore = new JLabel("Your Credit Score");
            JCreditScore.setFont(mainFont);


            JLabel JCustomerID = new JLabel("Give yourself a 4 digit number ID");
            JCustomerID.setFont(mainFont);



            JPanel formPanel = new JPanel();
            formPanel.setLayout(new GridLayout(6, 1, 5, 5));

            formPanel.add(JFirstName);
            formPanel.add(TextFirstName);

            formPanel.add(JLastName);
            formPanel.add(TextLastName);

            formPanel.add(JMoneyInBank);
            formPanel.add(TextMoneyBox);

            formPanel.add(JCreditScore);
            formPanel.add(TextCreditScore);

            formPanel.add(JCustomerID);
            formPanel.add(TextCustomerID);


            lbtest = new JLabel();
            lbtest.setFont(mainFont);

            JButton btnOK = new JButton("Next");
            btnOK.setFont(mainFont);
            btnOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    writeDataToCSV();
                    dispose();
                    new welcome();
                }
            });

            JButton btnClear = new JButton("clear");
            btnClear.setFont(mainFont);
            btnClear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TextFirstName.setText("");
                    TextLastName.setText("");
                    TextMoneyBox.setText("");
                    TextCreditScore.setText("");
                    TextCustomerID.setText("");
                    lbtest.setText("");
                }
            });

            JPanel buttonpanel = new JPanel();
            buttonpanel.setLayout(new GridLayout(1, 2, 5, 5));
            buttonpanel.add(btnOK);
            buttonpanel.add(btnClear);

            JPanel window2 = new JPanel();
            window2.setLayout(new BorderLayout());
            window2.setBackground(new Color(128, 128, 255));
            window2.add(formPanel, BorderLayout.NORTH);
            window2.add(lbtest, BorderLayout.CENTER);
            window2.add(buttonpanel, BorderLayout.SOUTH);

            add(window2);

            setTitle("Enter Your Name");
            setSize(600, 840);
            setMinimumSize(new Dimension(600, 100));
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setVisible(true);
        }
        private void writeDataToCSV() {
            try (FileWriter writer = new FileWriter(file, true)) { // Append mode enabled
                StringBuilder sb = new StringBuilder();
                sb.append(TextFirstName.getText()).append(",");
                sb.append(TextLastName.getText()).append(",");
                sb.append(TextMoneyBox.getText()).append(",");
                sb.append(TextCreditScore.getText()).append(",");
                sb.append(TextCustomerID.getText()).append("\n");

                writer.write(sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public class accountquestion extends JFrame {
        final private Font mainFont = new Font("Segeo Print", Font.BOLD, 18);
        JTextField tftitle, tftitle2;
        JLabel lbtest;

        public void initialize() {
            JLabel JFirstName = new JLabel("Do you have an account with us?");
            JFirstName.setFont(mainFont);

            JPanel formPanel = new JPanel();
            formPanel.setLayout(new GridLayout(4, 1, 5, 5));
            formPanel.add(JFirstName);

            lbtest = new JLabel();
            lbtest.setFont(mainFont);

            //has a bank account button
            JButton btnYesButton = new JButton("Yes, I do have an Account");
            btnYesButton.addActionListener(e -> {
                dispose();
                new name().initialize();
            });

            btnYesButton.setFont(mainFont);




            //does not hav a bank account button
            JButton btnNoButton = new JButton("No I don't have an account");
            btnNoButton.setFont(mainFont);
            btnNoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new NoAccountWindow().initialize();
                }
            });

            JPanel panel = new JPanel();
            panel.add(btnYesButton);
            add(panel);

            //clears typed in text from the page
            JButton btnClear = new JButton("clear");
            btnClear.setFont(mainFont);
            btnClear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tftitle.setText("");
                    tftitle2.setText("");
                    lbtest.setText("");
                }
            });



            JPanel buttonpanel = new JPanel();
            buttonpanel.setLayout(new GridLayout(1, 2, 5, 5));
            buttonpanel.add(btnYesButton);
            buttonpanel.add(btnNoButton);

            JPanel window1 = new JPanel();
            window1.setLayout(new BorderLayout());
            window1.setBackground(new Color(128, 128, 255));
            window1.add(formPanel, BorderLayout.NORTH);
            window1.add(lbtest, BorderLayout.CENTER);
            window1.add(buttonpanel, BorderLayout.SOUTH);

            add(window1);

            setTitle("Bank Teller");
            setSize(400, 300);
            setMinimumSize(new Dimension(600, 400));
            setLocationRelativeTo(null);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setVisible(true);
        }
    }

}

    
    

    


