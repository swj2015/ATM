package atm_project;


import java.util.ArrayList;


public class Account {
	
	protected String accNum;		//계좌번호
	protected long accBal;			//계좌잔액
	protected int accType;			//계좌종류 => 1.입출금, 2.정기예금, 3.정기적금
	protected int accPWD;			//계좌 비밀번호	
	protected ArrayList<String> accPreInfo = new ArrayList<>();	//계좌변경 이전 정보를 저장하는 객체
	
	
	protected void depositReq(){			//입금요청
		
	}
	
	protected void withdrawReq(){			//출금요청
		
	}
	
	protected void remitReq(){				//거래요청(타계좌간거래)
		
	}
	
	
	
	
}
