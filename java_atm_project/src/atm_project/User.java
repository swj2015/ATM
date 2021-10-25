package atm_project;

import java.util.List;
import java.util.ArrayList;

public class User {

	ArrayList<UserInfo> user;
	ArrayList<AccountInfo> acc;

	public User(ArrayList<UserInfo> user) {
		this.user = user;
	}

	protected int userIdentification(String userId, int userPWD){			//유저신원조회(로그인 할때)
		for(int i=0; i<user.size() ; i++){
			if (userId.equals(user.get(i).getUserId()) && userPWD == user.get(i).getUserPWD()){
				System.out.printf("%s 회원이 로그인에 성공했습니다! \n", user.get(i).getUserName());
				return 1000;
			}
		}
			System.out.println("존재하지 않는 아이디 혹은 비밀번호입니다! \n");
			return 2000;
	} //1000 : 성공 2000 : 오류

//	protected void depositSearch(String userId){//유저 계좌 조회 -> 가지고 있는 전체 계좌를 보여줌. 로그인 한 상태이고 무조건 1개 이상의 계좌가 있다고 가정. 오류처리 안함
//		for(int i=0; i<user.size() ; i++){
//			if(userId.equals(user.get(i).getUserId())){
//				for(int j=0 ; j<acc.size() ; j++){
//					if(user.get(i).getUserName().equals(acc.get(j).getAccUser())){
//						if(acc.get(j).getAccType() == 1) {
//							System.out.printf("유저의 %s 입출금 계좌의 잔액은 %d원 입니다! \n", acc.get(j).getAccNum(), acc.get(j).getAccBal());
//						}
//						if(acc.get(j).getAccType() == 2) {
//							System.out.printf("유저의 %s 정기예금 계좌의 잔액은 %d원 입니다! \n", acc.get(j).getAccNum(), acc.get(j).getAccBal());
//						}
//						if(acc.get(j).getAccType() == 3) {
//							System.out.printf("유저의 %s 정기적금 계좌의 잔액은 %d원 입니다! \n", acc.get(j).getAccNum(), acc.get(j).getAccBal());
//						}
//					}
//				}
//			}
//		}
//	}
}