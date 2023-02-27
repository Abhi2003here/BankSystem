package BankSystem;

import java.util.Scanner;

public class transaction {
    
    private int trscID;
    private int fromAcc;
    private int toAcc; 
    private double amt;

    
    public int gettrscID(){
        return this.trscID;
    }

    public void setfromAcc(int acc){
        this.fromAcc = acc;
    }

    public int getfromAcc(){
        return this.fromAcc;
    }

    public void settoAcc(int acc){
        this.toAcc = acc;
    }

    public int gettoAcc(){
        return this.toAcc;
    }

    public void setamt(double amt){
        this.amt = amt;
    }

    public double getamt(){
        return this.amt;
    }

    Scanner sc = new Scanner(System.in);

    public int getAcc(account arr[] , int accNo){
        int i;
        boolean flag=false;
        for(i=0 ; i<arr.length ; i++){
            if(arr[i].getAccNo()==accNo){
                flag = true;
                break;
            }
        }

        if(flag==false){
            return -1;
        }else{
            return i;
        }
        
    }


    public void Transfer(account arr[] , int i){
        System.out.println("\n************** Money Transfer **************");
        fromAcc = arr[i].getAccNo();
        System.out.println("\nEnter Account number to which you want to transfer money : ");
        int Acc = sc.nextInt();

        int c = getAcc(arr, Acc);

        if(c!=-1){
            System.out.println("Enter how much money you want to transfer : ");
            amt = sc.nextDouble();
            if(amt>(arr[i].getAccBal()-500)){
                System.out.println("Transfer Failed...\nDue to insufficent balance in yor account !\nYou need to keep at least Rs.500 in your account as a deposite.\n\nAccount Balance : "+arr[i].getAccBal());
            }else{
                arr[i].setAccBal((arr[i].getAccBal()-amt));
                arr[c].setAccBal((arr[c].getAccBal()+amt));
                System.out.println("\nTransfer Completed !\nRs."+amt+" transfered Successfully from account "+arr[i].getAccNo()+" to account "+arr[c].getAccNo());
            }
        }else{
            System.out.println("\nTranfer Failed ! \nAccount to that you want to transfer money doesn't exist...");
        }

    }

    public void AddMoney(int i , account arr[]){

        System.out.println("\n************** Money Add **************");
        System.out.println("\n\nEnter how much money you want to add : ");
        int amt = sc.nextInt();

        arr[i].setAccBal(amt+(arr[i].getAccBal()));

        System.out.println("\nRs."+amt+" added to account "+arr[i].getAccNo()+" Successfully. ");

    }


    public void Withdraw(int i , account arr[]){
        System.out.println("\n************** Money Withdraw **************");
        System.out.println("\n\nEnter how much money you want to Withdraw : ");
        int amt = sc.nextInt();

        if(amt>(arr[i].getAccBal()-500)){
            System.out.println("\nMoney withdrawal Failed ! \nDue to insufficent balance in yor account !\nYou need to keep at least Rs.500 in your account as a deposite.\n\nAccount Balance : "+arr[i].getAccBal());
        }

        arr[i].setAccBal((arr[i].getAccBal())-amt);

        System.out.println("\nRs."+amt+" withdrawed to account "+arr[i].getAccNo()+" Successfully.");    
    }

}
