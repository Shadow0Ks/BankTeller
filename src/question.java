import java.util.Objects;
import java.util.Scanner;


public class question {
    public static String objectName;
    public boolean haveAnAccount() {
        //not if: I HAVE an account base on button input

        Customer customer = getCustomerInfo();
        //search by Customer ID


        //finish working on this tonight\
        //create an arraylist then grab
        //grab customer array location and check if it exists within the relay
//        if (customer !=) {
//
//        }

        return false;
    }
//

//    public boolean doesNotHaveAccount(){
//        if (/*account does not exist*/){
//
//        }
//    }
    public Customer getCustomerInfo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your customer id");
        int customerID_ = sc.nextInt();
        System.out.println("How much do you want to deposit?");
        double deposit = sc.nextDouble();

        System.out.println("Enter First name");
        String fName = sc.next();

        System.out.println("Enter last name");
        String lName =  sc.next();

        System.out.println("Enter credit score");
        int customerCreditScore = sc.nextInt();

        objectName = fName;
        Customer objectName = new Customer(fName,lName, deposit,customerCreditScore, customerID_);

        System.out.println("This is a test to see if the first name is there: "+ objectName.getFirstName());
        //Main.userList.add(objectName);

        return objectName;
    }
}
