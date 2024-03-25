import java.util.Scanner;

public class UserInput {
    public int gatherCustomerInfo(){

        String name;
        String Id; //random number generated
        int moneyToDeposit;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Info: ");
        //name = sc.next();
        moneyToDeposit = sc.nextInt();

        return moneyToDeposit;
    }

//    public static void main(String[] args){
//        gatherCustomerInfo();
//    }
}
