package atm_project;

import java.util.ArrayList;

public class User {
	
	protected String userName;			//고객이름 
	protected String userId;			//고객 아이디
	protected int userPWD;				//고객 비밀번호
	protected int userIdx;				//고객 인덱스 
	protected String userDW;			//고객 입출금 계좌
	protected String userTDeposit;		//고객 정기예금 계좌
	protected String userSavings;		//고객 정기적금 계좌


	
	protected int userIdentification(){			//유저신원조회(로그인 할때)
		return 0;
	}
	
	protected int depositSearch(){			//유저 계좌 조회
		return 0;
	}
	
}
