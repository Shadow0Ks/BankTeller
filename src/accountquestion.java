import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class accountquestion extends JFrame{

    final private Font mainFont = new Font ("Segeo Print", Font.BOLD, 18);
    JTextField tftitle, tftitle2;
    JLabel lbtest;


    public void initialize()   {
//panel
        JLabel lbtitle = new JLabel("Do you have an account with us?");
        lbtitle.setFont(mainFont);


        JPanel formPanel= new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.add(lbtitle);


        //test or whatever panel
        lbtest = new JLabel();
        lbtest.setFont(mainFont);

        //when this button is pressed it will take me to the search page
        JButton btnYesButton = new JButton ("Yes, I do have an Account");
        btnYesButton.addActionListener(e ->{
            dispose();
            new name().initialize();

        });
        btnYesButton.setFont(mainFont);
        btnYesButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e ) {
                // TODO Auto-generated method stub
                //  String title = lbtitle.getText();
                //String title2 = lbtitle2.getText();
                //lbtest.setText("Hello, welcome to the bank how may we assist you today?");
                //JOptionPane.showMessageDialog(null, ".");
                //repetitive!!!!
                // could string more text or add more under this or create a whole new screen
                // lbtest.setText("hi :3" + title + title2);
                // ^^test if string
            }
        });

        JPanel panel = new JPanel();
        panel.add(btnYesButton);
        add(panel);
        setVisible(true);




        JButton btnClear= new JButton("No I don't have an account");
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
        buttonpanel.add(btnYesButton
        );
        buttonpanel.add(btnClear);





        JPanel window1 = new JPanel();
        window1.setLayout(new BorderLayout());
        window1.setBackground(new Color(128, 128, 255));
        window1.add(formPanel, BorderLayout.NORTH);
        window1.add(lbtest, BorderLayout.CENTER);
        window1.add (buttonpanel, BorderLayout.SOUTH);



        add(window1);

        setTitle("Bank Teller");
        setSize(400,300);
        setMinimumSize(new Dimension(600,400));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

    }




}
