package BankSystem;
import java.util.Scanner;
import java.util.Random;
import java.io.*;


public class accInfo {

    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public int createAcc(int n , account AccArr[]){         // n => number of accouts in account array( AccArr[] )

        String accType=null;
        int accNo;
        double accBal;

        if(n==20){
            System.out.println("Account capacity overflowed");
        }else{
            System.out.println("\n--------------------------------------------------\nWelcome to Bank of Golmaal...\n--------------------------------------------------\n");
            
            System.out.println("Enter your name : ");
            String name = sc.next();
            System.out.println("\n--------------------------------------------------");
            
            do{
                System.out.println("Press 1 - for Savings account\nPress 2 - for Current account\n\nEnter your choice : ");
                int ch = sc.nextInt();
                System.out.println("--------------------------------------------------\n");
                if(ch==1){
                    accType = "Savings";
                }else if(ch==2){
                    accType = "Current";
                }else{
                    System.out.println("\nInvalid choice...");
                }
            }while(accType==null);

            accNo = rd.nextInt();
            if(accNo<0){
                accNo=-accNo;
            }
            System.out.println("\n--------------------------------------------------\n"+name+" your Account Number is "+accNo+"\n--------------------------------------------------\n");
            do{
                System.out.println("\nEnter amount to deposite in your account\nTake care that minimum balance of your account should be Rs.500\n\n--------------------------------------------------\nEnter Amount to deposite : ");
                accBal = sc.nextDouble();
                System.out.println("--------------------------------------------------\n");

                if(accBal<500){
                    System.out.println("\nWarning !!! Account balance should be greater than Rs.500.");
                }
            }while(accBal<500);

            System.out.println("\n--------------------------------------------------\n"+accBal+" deposited to Account "+accNo+" Successfully...\n--------------------------------------------------\n");

            System.out.println("\n--------------------------------------------------\nCreate password for you account : ");
            String pass = sc.next();
            System.out.println("--------------------------------------------------\n");

            System.out.println("\n--------------------------------------------------\nAccount Creaeted Successfully...\n--------------------------------------------------\n\nAccount No : "+accNo+"\nAccount Holder Name : "+name+"\nAccount Type : "+accType+"\nAccount Balance : "+accBal+"\n\n--------------------------------------------------\n");

            account accobj = new account(accNo , name , accType , accBal , pass);
            AccArr[n] = accobj;
            
            n++;
        }   

        return n;

    }
    
    public int Login(account arr[] , int n){

        int accNo;
        String Pass;

        boolean flag=false;

        System.out.println("\nEnter your Account Number  : ");
        accNo = sc.nextInt();
        int i;
        for(i=0 ; i<n ; i++){
            if(arr[i].getAccNo()==accNo){
                flag=true;
                int cnt=0;
                while(cnt<3){
                    System.out.println("\nEnter Password : ");
                    Pass = sc.next();
                    if(Pass.equals(arr[i].getPass())){
                        System.out.println("\n--------------------------------------------------\nHello "+arr[i].getAccHoldName()+"\n--------------------------------------------------\nAccount Number : "+arr[i].getAccNo()+"\nAccount Holder Name : "+arr[i].getAccHoldName()+"\nAccount Balance : "+arr[i].getAccBal()+"\n--------------------------------------------------");
                        cnt=3;
                    }else{
                        System.out.println("\n--------------------------------------------------\nWarning !!!\n--------------------------------------------------\nEntered Password is incorrect...\n--------------------------------------------------");
                    }
                    cnt++;
                    if(cnt==2){
                        System.out.println("\n--------------------------------------------------\nWarning !!!\n--------------------------------------------------\nLast attempt for password\n--------------------------------------------------");
                    }
                }
            }
            if(flag){
                break;
            }
        }

        if(flag==false ){
            System.out.println("\n--------------------------------------------------\nWarning !!!\n--------------------------------------------------\nAccount Number doesn't Exist\n--------------------------------------------------");
        }

        return i;

    }


    public void DisplayAcc(account AccArr[] , int n){
        System.out.println("\nFollowing is list of accounts created : \n\n");
        for(int i=0 ; i<n ; i++){
            System.out.println("\n-------------------------------------------------------");
            System.out.println("Account "+(i+1));
            System.out.println("-------------------------------------------------------");
            System.out.println("Account No : "+AccArr[i].getAccNo()+"\nAccount Holder Name : "+AccArr[i].getAccHoldName()+"\nAccount Type : "+AccArr[i].getAccType()+"\nAccount Balance : "+AccArr[i].getAccBal());
            System.out.println("-------------------------------------------------------");
            
        }

    }

   


}
