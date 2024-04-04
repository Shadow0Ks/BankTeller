import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 public class name extends JFrame{

     final private Font mainFont = new Font ("Segeo Print", Font.BOLD, 18);
     JTextField tftitle, tftitle2;
     JLabel lbtest;


     public void initialize()   {
 //panel
         JLabel lbtitle = new JLabel("First Name");
         lbtitle.setFont(mainFont);


         tftitle = new JTextField();
         tftitle.setFont(mainFont);

         JLabel lbtitle2 =  new JLabel("Last Name");
         lbtitle2.setFont(mainFont);

         tftitle2 = new JTextField();
         tftitle2.setFont(mainFont);


         JPanel formPanel= new JPanel();
         formPanel.setLayout(new GridLayout(4, 1, 5, 5));
         formPanel.add(lbtitle);
         formPanel.add(tftitle);
         formPanel.add(lbtitle2);
         formPanel.add(tftitle2);

         //test or whatever panel
         lbtest = new JLabel();
         lbtest.setFont(mainFont);

         // buttons panel or some
         JButton btnOK = new JButton ("Next");
         btnOK.setFont(mainFont);
         btnOK.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {


                 dispose();
                 credit creditWindow = new credit();
                 creditWindow.initialize();
                 // TODO Auto-generated method stub
           //  String title = lbtitle.getText();
             //String title2 = lbtitle2.getText();
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
                 tftitle.setText("");
                 tftitle2.setText("");
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

         setTitle("welcome or whatever");
         setSize(600,840);
         setMinimumSize(new Dimension(600,100));
         setLocationRelativeTo(null);
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setVisible(true);

     }
     private void OpenNewPage(){

         //new page
         JFrame secondFrame = new JFrame();
         secondFrame.setTitle("Second Page");
         secondFrame.setSize(400, 400);
         secondFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

         JLabel label = new JLabel("test");
         label.setFont(mainFont);
         secondFrame.add(label);

         secondFrame.setVisible(true);
     }

 }
        


        // new component?s
    

    

