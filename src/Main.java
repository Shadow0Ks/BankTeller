import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Window screen = new Window();

        //UserInput b = new UserInput();
        BinaryTree tree = new BinaryTree();
        //Node trees = new BinaryTree();

        //int answer = b.gatherCustomerInfo();


        //base of the tree
        tree.root = new Node(10);
        tree.insert(5);
        tree.insert(6);




        //figure how to get the value out of the branch
        if (tree.search(10) == true) {
            System.out.println("its working");
        }
//        if (tree.search(5) == true){
//            System.out.println("Make a deposit");
//        }
        //asking a question based on what the customer answers




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
}

//if persons I wanna check and then traverse down