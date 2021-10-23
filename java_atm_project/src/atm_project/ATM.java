package atm_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        List<User> user = new ArrayList<>();
        User newUser1 = new User("성우진", "test1", 0000, 1, "111122223333", null, null);
        user.add(newUser1);
        User newUser2 = new User("최준혁", "test2", 2449, 2, "123456789012", "123412341234", null);
        user.add(newUser2);
        User newUser3 = new User("정수현", "test3", 6631, 3, "999988887777", "666655554444", "333322221111");
        user.add(newUser3);

        System.out.println(user);
        
        Scanner s = new Scanner(System.in);
		
		ATM us = new ATM();
		
		System.out.println("관리자는 1번, 고객은 2번을 입력해주세요");
		
		int a = s.nextInt();
		switch(a){
		
		case 1:
				System.out.print("관리자 아이디를 입력해주세요");
				String adminId = us.adminId;
				adminId = s.nextLine();
				System.out.println("비밀번호를 입력해주세요");
				int adminPWD = us.adminPWD;
				adminPWD = s.nextInt();
				if(adminId=="1234" && adminPWD == 1234) {					//관리자 로그인 성공
					System.out.println("로그인에 성공하였습니다.");
					System.out.println("1을 누르면 관리자 지폐 입금을, 2을 누르면 관리자 지폐 출금을 합니다.");		
					
					int n = s.nextInt();
					switch(n){
					
					case 1:
							System.out.print("관리자 지폐 입금을 시작합니다");
							//관리자 지폐 입금 메소드
					case 2:	
							System.out.print("관리자 지폐 출금을 시작합니다");
							//관리자 지폐 출금 메소드
					}
				}else System.out.println("잘못된 아이디나 비밀번호입니다.");

				
		case 2:	
				System.out.print("고객 아이디를 입력해주세요");
				String userId = us.userId;
				userId = s.nextLine();
				System.out.println("비밀번호를 입력해주세요");
				int userPWD = us.userPWD;
				userPWD = s.nextInt();
				if(userId=="1234" && userPWD == 1234) {
					System.out.println("로그인에 성공하였습니다.");
					System.out.println("1을 누르면 입금, 2을 누르면 출금, 3을 누르면 계좌간 거래, 4를 누르면 계좌 조회, 5를 누르면 exit");	
					int n = s.nextInt();
					switch(n){
					
					case 1:
							System.out.print("입금을 시작합니다");
							//
							break;
					case 2:	
							System.out.print("출금을 시작합니다");
							//
							break;
					case 3:
							System.out.print("계좌간 거래를 시작합니다");
							//
							break;
					case 4:	
							System.out.print("계좌 조회를 시작합니다");
							//
							break;
					case 5:	
							System.out.print("exit");
							//
							break;
					}
				}
		}

        
        
    }
}
