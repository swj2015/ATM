package atm_project;

public class User {

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
	protected void setUserName(String userName) { this.userName = userName;}
	protected void setUserId (String userId) { this.userId = userId; }
	protected void setUserPWD (int userPWD) { this.userPWD = userPWD; }
	protected void setUserIdx (int userIdx) { this.userIdx = userIdx; }
	protected void setUserDW (String userDW) { this.userDW = userDW; }
	protected void setUserTDeposit (String userTDeposit) { this.userTDeposit = userTDeposit; }
	protected void setUserSavings (String userSavings) { this.userSavings = userSavings; }

	//protected List<User> user = new ArrayList<>();

	public User(String userName, String userId, int userPWD, int userIdx, String userDW, String userTDeposit, String userSavings){
		this.userName = userName;
		this.userId = userId;
		this.userPWD = userPWD;
		this.userIdx = userIdx;
		this.userDW = userDW;
		this.userTDeposit = userTDeposit;
		this.userSavings = userSavings;
	}

	protected int userIdentification(){			//유저신원조회(로그인 할때)
		return 0;
	}

	protected int depositSearch(){			//유저 계좌 조회
		return 0;
	}

}
