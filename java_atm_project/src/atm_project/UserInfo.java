package atm_project;

import java.util.ArrayList;

class UserInfo {
    protected String userName;			//고객이름
    protected String userId;			//고객 아이디
    protected int userPWD;				//고객 비밀번호
    protected int userIdx;				//고객 인덱스
    protected String userDW;			//고객 입출금 계좌
    protected String userTDeposit;		//고객 정기예금 계좌
    protected String userSavings;		//고객 정기적금 계좌


    protected String getUserName() { return userName; }
    protected String getUserId() {return userId; }
    protected int getUserPWD() { return userPWD; }
    protected int getUserIdx() { return userIdx; }
    protected String getUserTDeposit() { return userTDeposit; }
    protected String getUserSavings() { return userSavings; }


    protected UserInfo(String userName, String userId, int userPWD, int userIdx, String userDW, String userTDeposit, String userSavings){
        this.userName = userName;
        this.userId = userId;
        this.userPWD = userPWD;
        this.userIdx = userIdx;
        this.userDW = userDW;
        this.userTDeposit = userTDeposit;
        this.userSavings = userSavings;
    }
}