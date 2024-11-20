
import java.util.Scanner;
class BankAccount{
    private double balance;
    public BankAccount(double InitialBalance)
    {
        this.balance = InitialBalance;
    }
    public String deposite(double amount)
    {
        if(amount< 0)
        {
            return "OOpsyy!! you have deposite a positive number.";
        }
        balance+=amount;
        return "Hurray the money is deposited new balance is "+ balance+".";
    }
    public String withdraw(double amount)
    {
        if(amount < 0)
        {
            return "please enter positive amount to withdraw!!";
        }
        if(amount > balance)
        {
            return "Insufficient Balance!! to withdraw";
        }
        balance-=amount;
        return "money is withdrawed succesfully!! your new acc balance is "+ balance+".";
    }
    public String checkbalance (){
        return "BALANCE AMOUNT IS: "+ balance+".";
    }
}
    class ATM{
        private BankAccount account; 

        public ATM(BankAccount  account)
        {
            this.account = account;
        }
        public void displayMenu()
        {
            System.out.println("welcome to our friendly ATM");
            System.out.println("how can we help you today??");

            Scanner scanner = new Scanner(System.in);
            int choice ;
            do{
                System.out.println("--ENTER ANY ONE--");
                System.out.println("1. withdraw money");
                System.out.println("2.deposite money");
                System.out.println("3.check balance");
                System.out.println("4.Exit");
                System.out.println("please choose an option from 1-4");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                          System.out.println("How much money you want to withdraw");
                          double withdrawMoney = scanner.nextInt();
                          System.out.println(account.withdraw(withdrawMoney));
                        break;
                    case 2:
                          System.out.println("How much money you want to deposite");
                          double depositeMoney = scanner.nextInt();
                          System.out.println(account.deposite(depositeMoney));
                          break;
                    case 3:
                          System.out.println(account.checkbalance());
                          break;
                    case 4:
                          System.out.println("thankyou for using our friendly atm have a great day!!"); 
                          break;    
                    default:
                    System.out.println(" Please choose a valid option.");
                }
            }while(choice!=4);
            scanner.close();
        }
        
    }

public class ATMSystem{
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500.00);//start with 500 
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}



