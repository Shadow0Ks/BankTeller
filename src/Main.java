import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static String fileName = "src\\customer_data.csv";
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Window screen = new Window();

        UserInput b = new UserInput();
        BinaryTree tree = new BinaryTree();

        //Node trees = new BinaryTree();
        /*
        Displaying file content
         */
        //Load customer inforamtion to the screen
        List<Customer> customerList = CSVForCustomerInfo.loadCustomer(fileName);







//        int answer = b.gatherCustomerInfo();
//
//        //base of the tree
//        tree.root = new Node(10);
//        tree.insert(5);
//        tree.insert(6);




        //figure how to get the value out of the branch
//        if (tree.search(10) == true) {
//            System.out.println("its working");
//        }

//        if (tree.root.left.data == answer){
//            System.out.println("hi");
//            //question.doesNotHaveAnAccount();
//
//
//        }
//        if (tree.root.left.right.data == answer){
//            System.out.println("shoud be wrong");
//        }
//
        //asking a question based on what the customer answers





        ////////////////////////////////////////////////////
        //list data stored in arraylist
        for (Customer customer : customerList) {
            System.out.println("Customer First Name: " + customer.getFirstName());
            System.out.println("Customer Last Name: " + customer.getLastName());
            System.out.println("Customer Money in Bank: " + customer.getMoneyInBank());
            System.out.println("Customer Credit Score: " + customer.getCreditScore());
            System.out.println("Customer ID: " + customer.getCustomerID());
            System.out.println(); // Add a blank line for separation
        }


        //adds you customer information to the csv file
        System.out.println("adding new customer to system");
        CSVForCustomerInfo.addCustomerInfoToExistingCSVFile();


    }
}



    // TO DO LIST:
    /*
    - Store customer data in a csv files (if it doesn't work use a json file)
        - the data will have first name and last name
        - it will also have the amount of money stored
        - customers credit score




        What Will I need first:
        - Class for Customer (done)
        - fill out the data of the customer
            - Make a screen with a box that allows you customers data

        - Read data for the file
     */

//if persons I wanna check and then traverse down