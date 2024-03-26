import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Window extends JFrame implements ItemListener {
    int SCREEN_WIDTH = 800;
    int SCREEN_HEIGHT = 600;
    /*-------------------------------------------------------------------------------------------------------*/

    private Font font;
    /*--------------------------------------------------------*/
    //Next page and previous page buttons
    JButton nextPage;
    JButton prevPage;




    public Window(){
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setTitle("Bank Teller");
        setLocationRelativeTo(null);
        setVisible(true);





        int nextPageX = SCREEN_WIDTH - 150;
        int nextPageY = SCREEN_HEIGHT - 80;
        nextPage = new JButton("Next page");
        //nextPage.setPreferredSize(new Dimension(100,30));
        nextPage.setBounds(nextPageX ,  nextPageY,100,30);
        add(nextPage, BorderLayout.SOUTH);


//        prevPage = new JButton("Previous Page");
//        prevPage.setBounds(nextPageX, nextPageY, 100, 30);
//        add(prevPage, BorderLayout.NORTH);

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

    @Override
    public void itemStateChanged(ItemEvent e) {

    }


    public void welcomeScreen(Graphics graphics){
        //set the font of the text
        //font = new Font("Arial", Font.ITALIC, 50);
        font = new Font("Arial", Font.ITALIC, calculateFontSize());
        paintComponents(graphics);
        graphics.setFont(font);
        graphics.setColor(Color.BLACK);

        String message = "Welcome to the Bank, how can I be help for you today";

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

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == nextPage) {
//
//        }
//
//    }

}
