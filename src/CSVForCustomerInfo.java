import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVForCustomerInfo {

    List<Object> list = new ArrayList<>();
    static String file = "src\\customer_data.csv";


    public static List<Customer> loadCustomer(String fileName){
        List<Customer> customers = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){

            //this will skip the first line which is the headers(names)
            String header = reader.readLine();

            //this will read the CSV file and add to an array list
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if (data.length >= 5) {

                    String customerFirstName = data[0];
                    String customerLastName = data[1];

                    //makes sure that the data is stored properly
                    try {
                        double customerMoneyInBank = Double.parseDouble(data[2]);
                        int customerCreditScore = Integer.parseInt(data[3]);
                        int customerID = Integer.parseInt(data[4]);
                        customers.add(new Customer(customerFirstName, customerLastName, customerMoneyInBank, customerCreditScore, customerID));

                    } catch (NumberFormatException e){
                        System.out.println("Error parsing data: " + line);
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return  customers;
    }



    public static void addCustomerInfoToExistingCSVFile(){
        Scanner sc = new Scanner(System.in);

        //specifying the file I want to write too



        //make this work with the screen
        System.out.println("add a first name");
        String newFirstName = sc.next();
        System.out.println("add a last name");
        String newLastName = sc.next();;
        System.out.println("Enter your first deposit");
        double alreadyExistingMoneyInBank = sc.nextDouble();
        System.out.println("Enter your credit score");
        int newCustomerCreditScore = sc.nextInt();
        System.out.println("4 digit customer id");
        int newCustomerId = sc.nextInt();

        //Make sure this works with the screen
        try {
            //calls a function from the java.io library to write on CSV files and the file is already specified
            FileWriter writer = new FileWriter(file, true);
            writer.write(newFirstName + "," + newLastName + "," +
                    alreadyExistingMoneyInBank + "," +
                    newCustomerCreditScore + "," +
                    newCustomerId + "\n");

            writer.close();
            System.out.println("information is added");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




    public static void printCSVList(){
        List<Customer> customerList = CSVForCustomerInfo.loadCustomer(file);

        for (Customer customer : customerList) {
            System.out.println("Customer First Name: " + customer.getFirstName());
            System.out.println("Customer Last Name: " + customer.getLastName());
            System.out.println("Customer Money in Bank: " + customer.getMoneyInBank());
            System.out.println("Customer Credit Score: " + customer.getCreditScore());
            System.out.println("Customer ID: " + customer.getCustomerID());
            System.out.println(); // Add a blank line for separation
        }

    }
}
