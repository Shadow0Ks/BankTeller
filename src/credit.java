import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class credit extends JFrame{

    final private Font mainFont = new Font ("Segeo Print", Font.BOLD, 18);
    JTextField tftitle, tftitle2;
    JLabel lbtest;


    public void initialize()   {
//panel
        JLabel lbtitle = new JLabel("What is your credit score?");
        lbtitle.setFont(mainFont);


        tftitle = new JTextField();
        tftitle.setFont(mainFont);
        
//        JLabel lbtitle2 =  new JLabel("Last Name");
//        lbtitle2.setFont(mainFont);
//
//        tftitle2 = new JTextField();
//        JTextFieldtftitle2.setFont(mainFont);


        JPanel formPanel= new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.add(lbtitle);
        formPanel.add(tftitle);
//      formPanel.add(lbtitle2);
//        formPanel.add(tftitle2);

        //test or whatever panel   
        lbtest = new JLabel();
        lbtest.setFont(mainFont);

        // buttons panel or some
        JButton btnOK = new JButton ("Enter");
        btnOK.setFont(mainFont);
        btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
          //  String title = lbtitle.getText();
            //String title2 = lbtitle2.getText();
                dispose();
                int res = JOptionPane.showConfirmDialog(null, "Do you want a loan?");
                if (res == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Congrats you got a free loan!");
                }
                else if (res == JOptionPane.NO_OPTION){
                    JOptionPane.showMessageDialog(null,"Okay then, no loan then :(");
                }
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

        setTitle("Credit");
        setSize(600,400);
        setMinimumSize(new Dimension(400,400));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

    }
}
