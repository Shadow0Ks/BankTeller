import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class name extends JFrame{

    static String fileName = "src\\customer_data.csv";

     final private Font mainFont = new Font ("Segeo Print", Font.BOLD, 18);
     static JTextField TextCustomerID;
     //JTextField tftitle2;
     JLabel lbtest;


     public void initialize()   {

         JLabel JCustomerID = new JLabel("Customer ID");
         JCustomerID.setFont(mainFont);
         TextCustomerID = new JTextField();
         TextCustomerID.setFont(mainFont);

//         JLabel JCustomerID2 =  new JLabel("Last Name");
//         JCustomerID2.setFont(mainFont);
//
//         tftitle2 = new JTextField();
//         tftitle2.setFont(mainFont);


         JPanel formPanel= new JPanel();
         formPanel.setLayout(new GridLayout(4, 1, 5, 5));
         formPanel.add(JCustomerID);
         formPanel.add(TextCustomerID);
//         formPanel.add(JCustomerID2);
//         formPanel.add(tftitle2);

         //test or whatever panel
         lbtest = new JLabel();
         lbtest.setFont(mainFont);

         // buttons panel or some
         JButton btnOK = new JButton ("Next");
         btnOK.setFont(mainFont);
         btnOK.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                //UPDATE OVER HERE
                //check if the customer is in the files
                checkCustomerID();




                 //goes to new screen if the customer is here
//                 dispose();
//                 infoscreen infroscreen = new infoscreen();
//                 infroscreen.initialize();

                 // TODO Auto-generated method stub
           //  String title = JCustomerID.getText();
             //String title2 = JCustomerID2.getText();
           //  lbtest.setText("hi :3");
             // could string more text or add more under this or create a whole new screen
             // lbtest.setText("hi :3" + title + title2);
             // ^^test if string
             }


         });
         JButton btnClear = new JButton("clear");
         btnClear.setFont(mainFont);
         btnClear.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 // TODO Auto-generated method stub
                 TextCustomerID.setText("");
                 //tftitle2.setText("");
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
         window2.add (buttonpanel, BorderLayout.SOUTH);


         add(window2);

         setTitle("Bank Teller");
         setSize(600,840);
         setMinimumSize(new Dimension(600,100));
         setLocationRelativeTo(null);
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setVisible(true);

     }
//     private void OpenNewPage(){
//
//         //new page
//         JFrame secondFrame = new JFrame();
//         secondFrame.setTitle("Second Page");
//         secondFrame.setSize(400, 400);
//         secondFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//         JLabel label = new JLabel("test");
//         label.setFont(mainFont);
//         secondFrame.add(label);
//
//         secondFrame.setVisible(true);
//     }


    public void checkCustomerID() {
        String customerIDCheck = TextCustomerID.getText();
        boolean customerDoesExist = false;
        try (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = read.readLine()) != null) {
                String[] data = line.split(",");

                String customerID = data[4].trim();
                if (customerID.equals(customerIDCheck)) {
                    // Customer ID exists
                    System.out.println("Customer ID does exist");
                    customerDoesExist = true;

                    // Create an ArrayList to store customer information
                    List<String> customerInfo = new ArrayList<>();

                    for (int i = 0; i < data.length; i++) {
                        customerInfo.add(data[i]);
                    }

                    // Display customer information on the infoscreen
                    infoscreen infroscreen = new infoscreen();
                    infroscreen.displayCustomerInfo(customerInfo.toArray(new String[0]));

                    dispose();
                    break;
                }
            }

            if (!customerDoesExist) {
                // Customer ID does not exist
                System.out.println("Customer ID does not Exist");
                dispose();
                accountquestion aq = new accountquestion();
                aq.initialize();
                // Take me back to the main screen if needed
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
     }
 }


    

