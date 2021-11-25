package atm_project;

import java.util.ArrayList;

class User {

	ArrayList<UserInfo> user;

	User(ArrayList<UserInfo> user) {
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
}
