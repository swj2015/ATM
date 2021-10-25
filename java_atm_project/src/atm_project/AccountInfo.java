package atm_project;

import java.util.List;

class AccountInfo {
//    protected List<Account> acc;
//    protected List<Transaction> trans;

    protected String accUser;       //계좌소유유저이름
    protected String accNum;		//계좌번호
    protected int accBal;			//계좌잔액
    protected int accType;			//계좌종류 => 1.입출금, 2.정기예금, 3.정기적금
    protected int accPWD;			//계좌 비밀번호

    public AccountInfo(){

    }

    protected AccountInfo(String accUser, String accNum, int accBal, int accType, int accPWD){
        this.accUser = accUser;
        this.accNum = accNum;
        this.accBal = accBal;
        this.accType = accType;
        this.accPWD = accPWD;
    }

    protected String getAccUser() { return accUser; }
    protected String getAccNum() { return  accNum; }
    protected int getAccBal() { return accBal; }
    protected int getAccType() { return  accType; }
    protected int getAccPWD() { return accPWD; }
    protected void setAccBal(int accBal) { this.accBal = accBal; }


}
