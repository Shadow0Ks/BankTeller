import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVForCustomerInfo {

    List<Object> list = new ArrayList<>();



    public static void CSVFileStore(){
        String file = "src\\customer_data.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null){
                String[] row = line.split(",");
                for (String index : row){
                    System.out.printf("%-10s", index);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static List<Customer> loadCustomer(String fileName){
        List<Customer> customers = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){

            String header = reader.readLine();
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if (data.length >= 5) {

                    String customerFirstName = data[0];
                    String customerLastName = data[1];

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
}
