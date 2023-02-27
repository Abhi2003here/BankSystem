package BankSystem;

public class account {

    private int accNo;
    private String accHoldName;
    private String accType;
    private double accBal;
    private String pass;

    public account(int accNo , String Name , String accType , double accBal , String pass ){
        this.accNo = accNo;
        this.accHoldName = Name;
        this.accType = accType;
        this.accBal = accBal;
        this.pass = pass;
    }


    public void setAccNo(int accNo){
        this.accNo=accNo;
    }

    public int getAccNo(){
        return this.accNo;
    }

    public void setAccHoldName(String Name){
        this.accHoldName = Name;
    }

    public String getAccHoldName(){
        return this.accHoldName;
    }

    public void setAccBal(Double accBal){
        this.accBal=accBal;
    }

    public double getAccBal(){
        return this.accBal;
    }

    public void setAccType(String accType){
        this.accType=accType;
    }

    public String getAccType(){
        return this.accType;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public String getPass(){
        return this.pass;
    }


}
