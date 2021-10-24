package atm_project;

import java.util.List;

public class User {

	List<User> user;
	List<Account> acc;

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

	static ArrayList<String> userString = new ArrayList<>();
	static ArrayList<Integer> userInt = new ArrayList<>();
	

	protected User(String userName, String userId, String userDW, String userTDeposit, String userSavings){
//		this.userName = userName;
//		this.userId = userId;
//		this.userDW = userDW;
//		this.userTDeposit = userTDeposit;
//		this.userSavings = userSavings;
		
		userString.add(userName);
		userString.add(userId);
		userString.add(userDW);
		userString.add(userTDeposit);
		userString.add(userSavings);
		
		
	}
	
	protected static void UserInteger(int userPWD, int userIdx) {
		userInt.add(userPWD);
		userInt.add(userIdx);
	}
	
	String uName(int cnt) {
		return userString.get(0 + cnt*5);
	}
	String uId(int cnt) {
		return userString.get(1 + cnt*5);
	}
	String uDW(int cnt) {
		return userString.get(2 + cnt*5);
	}
	String uTDe(int cnt) {
		return userString.get(3 + cnt*5);
	}
	String uSave(int cnt) {
		return userString.get(4 + cnt*5);
	}
	int uPWD(int cnt) {
		return userInt.get(0 + cnt*2);
	}
	int uIdx(int cnt) {
		return userInt.get(1 + cnt*2);
	}
	
	
	protected int userIdentification(String userId, int userPWD){			//유저신원조회(로그인 할때)
		
		
		for(int i = 0; i<3; i++) {
			
			//System.out.println(adminId);
			String name = uName(i);
			String Id = uId(i);
			
			if (userId.equals(Id)) {
				if(userPWD == uPWD(i)){
					System.out.printf("%s 회원님이 로그인에 성공했습니다!\n", name);
					return 1000;
				}
				else continue;
				
			}
		}
		
		System.out.println("존재하지 않는 아이디 혹은 비밀번호입니다!");
				
		return 2000;
	} //1000 : 성공 2000 : 오류

	protected void depositSearch(String userId){			//유저 계좌 조회 -> 가지고 있는 전체 계좌를 보여줌. 로그인 한 상태이고 무조건 1개 이상의 계좌가 있다고 가정. 오류처리 안함
		for(int i=0; i<user.size() ; i++){
			if(userId == user.get(i).getUserName()){
				for(int j=0 ; j<acc.size() ; j++){
					if(user.get(i).getUserName() == acc.get(j).getAccUser()){
						if(acc.get(j).getAccType() == 1) {
							System.out.printf("유저의 %c 입출금 계좌의 잔액은 %d원 입니다! \n", acc.get(j).getAccNum(), acc.get(j).getAccBal());
						}
						if(acc.get(j).getAccType() == 2) {
							System.out.printf("유저의 %c 정기예금 계좌의 잔액은 %d원 입니다! \n", acc.get(j).getAccNum(), acc.get(j).getAccBal());
						}
						if(acc.get(j).getAccType() == 3) {
							System.out.printf("유저의 %c 정기적금 계좌의 잔액은 %d원 입니다! \n", acc.get(j).getAccNum(), acc.get(j).getAccBal());
						}
					}
				}
			}
		}
	}
}
