package BankSystem;
import java.util.Scanner;

import static java.lang.System.out;


public class BankMain {

    public static void main(String[] args){
  
        int m=20,ch;
        account Accarr[] = new account[m];

        Scanner sc = new Scanner(System.in);
        int n=0;

        accInfo ainf = new accInfo();
        transaction tran = new transaction();

        do{
            
            System.out.println("\n\nMenus :\n\n1.Create Account\n2.Display Accounts\n3.Login\n4.Transactions\n5.Exit\n\nEnter your choice : ");
            ch = sc.nextInt();

            switch(ch){

                

                case 1:

                    n = ainf.createAcc(n, Accarr);
                    break;
                
                case 2:

                    ainf.DisplayAcc(Accarr, n);
                    break;

                case 3:

                    int a = ainf.Login(Accarr, n);
                    break;

                case 4:

                    int i = ainf.Login(Accarr, n);
                    
                    System.out.println("\nMenus :\n\n1.Add Money\n2.Withdraw Money\n3.Transfer Money\n\nEnter your choice : ");
                    int s = sc.nextInt();
                    
                    switch(s){
                        case 1:

                            tran.Transfer(Accarr, i);
                            break;
                        
                        case 2:

                            tran.Withdraw(i, Accarr);
                            break;

                        case 3:

                            tran.Transfer(Accarr, i);
                            break;

                        default:
                            System.out.println("Invalid Choice...");
                    }
                    
                    break;
                    
                default:
                    System.out.println("\nInvalid Choice...");

            }


        }while(ch!=5);


    }
    
}
