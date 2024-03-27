import java.io.*;
public class CSVForCustomerInfo {



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

}
