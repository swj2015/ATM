package atm_project;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
//

public class ATM extends JFrame { //

	int leftManWon = 1000;            //만원권 남은 장수
	int left5ManWon = 200;           //5만원권 남은 장수
	int leftCheonWon = 0;            //천원권 남은 장수
	int left5CheonWon = 0;            //5천원권 남은 장수
	//
	private static String is_id;
	private static String is_PWD;
	private static int a = 0;	// admin or user
	private static int num = 0;	// 로그인 성공여부
	private static int adPWD;
	//
	private static JFrame atmFr = new JFrame("ATM");
	private static JLabel Loginlabel = new JLabel("< ATM Login >");
	private static JLabel idlabel = new JLabel("ID : ");
	private static JLabel pwlabel = new JLabel("Password : ");
	
	
	private static JTextField LoginId = new JTextField();
	private static JTextField LoginPw = new JTextField();
	private static JButton okay = new JButton("로그인");
	
	
	void billAdd(int cheonWon, int ohCheonWon, int manWon, int ohManWon){
		leftManWon += manWon;
		left5ManWon += ohManWon;
		leftCheonWon += cheonWon;
		left5CheonWon += ohCheonWon;
	}

    public static void main(String[] args) {
    	
    	// GUI
    	
    	JRadioButton adLogin = new JRadioButton("Admin Login");
    	JRadioButton userLogin = new JRadioButton("User Login");
    	ButtonGroup group = new ButtonGroup();
    	
    	atmFr.setLayout(null);
    	atmFr.setSize(400,400);
    	atmFr.setLocationRelativeTo(null);
    	atmFr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	atmFr.setVisible(true);
    	
    	group.add(adLogin);
    	group.add(userLogin);
    	
    	Loginlabel.setBounds(150, 20, 200, 30);
    	adLogin.setBounds(40,50,200,30);	// x,y,가로,세로
    	userLogin.setBounds(40,80,200,30);
    	idlabel.setBounds(70, 130, 60, 30);
    	pwlabel.setBounds(30, 170, 70, 30);
    	
    	LoginId.setBounds(110, 130, 200, 30);
    	LoginPw.setBounds(110,170, 200, 30);
    	okay.setBounds(70, 230, 250, 30);
    	
    	
    	atmFr.add(Loginlabel);
    	atmFr.add(adLogin);
    	atmFr.add(userLogin);
    	atmFr.add(idlabel);
    	atmFr.add(pwlabel);
    	atmFr.add(LoginId);
    	atmFr.add(LoginPw);
    	atmFr.add(okay);
    	
    	
		ATM atm = new ATM();

    	ArrayList<AdminInfo> admin = new ArrayList<>();
        ArrayList<UserInfo> user = new ArrayList<>();
        ArrayList<AccountInfo> acc = new ArrayList<>();


        UserInfo newUser1 = new UserInfo("성우진", "test1", 1123, 1, "38180204-266350", null, null);
        user.add(newUser1);
        UserInfo newUser2 = new UserInfo("최준혁", "test2", 2449, 2, "123456-789012", "123412-341234", null);
        user.add(newUser2);
        UserInfo newUser3 = new UserInfo("정수현", "test3", 6631, 3, "999988-887777", "666655-554444", "333322-221111");
        user.add(newUser3);

        AdminInfo newAdmin1 = new AdminInfo("admin1", 1234, "관리자1");
        admin.add(newAdmin1);
        AdminInfo newAdmin2 = new AdminInfo("admin2", 5678, "관리자2");
        admin.add(newAdmin2);

        AccountInfo newAcc1 = new AccountInfo("성우진", "38180204-266350", 1250000, 1,1111);
        acc.add(newAcc1);
        AccountInfo newAcc2 = new AccountInfo("최준혁", "123456-789012", 3800000, 1, 1111);
        acc.add(newAcc2);
        AccountInfo newAcc3 = new AccountInfo("최준혁", "123412-341234", 5000000, 2, 2222);
        acc.add(newAcc3);
        AccountInfo newAcc4 = new AccountInfo("정수현", "999988-887777", 1800000, 1, 1111);
        acc.add(newAcc4);
        AccountInfo newAcc5 = new AccountInfo("정수현", "666655-554444", 800000, 2, 2222);
        acc.add(newAcc5);
        AccountInfo newAcc6 = new AccountInfo("정수현", "333322-221111", 240000, 3, 3333);
        acc.add(newAcc6);

        Admin ad = new Admin(admin);
        User us = new User(user);
        Account ac = new Account(acc);
        Transaction trans = new Transaction();
//        ATMInfo atmInfos;
        Scanner s = new Scanner(System.in);

		int newcheonWon=0;
		int newohCheonWon =0;
		int newmanWon =0;
		int newohManWon=0;

		String accNum;
		int accPWD;
		int total;
		String sendAccNum;
		int sendAccPWD;
		String sentAccNum;
		
		
		System.out.println("--- System : ATM 프로그램을 실행합니다. ---");

		
			int n = 0;
			
			
			
			adLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					a = 1;
				}
			});
			
			userLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					a = 2;
					System.out.println(a);
				}
			});
			
			
			okay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				
			   		is_id = LoginId.getText();
			  		is_PWD = LoginPw.getText();
		 			adPWD = Integer.parseInt(is_PWD);
					
					
		 			System.out.println(a);
		 			System.out.println(is_id);
		 			System.out.println(adPWD);
			
		 		if(a == 1) {
					
					num = ad.adminIdentification(is_id, adPWD);		// 관리자 로그인 성공 실패 메소드
					System.out.println(num);
						
					    if(num == 1000) {
					    	System.out.println("> 1을 누르면 관리자 지폐 입금을, 2을 누르면 관리자 지폐 출금, 3을 누르면 ATM 내 남은 지폐 확인, 4를 누르면 로그인 화면으로 돌아갑니다.");
					    	atmFr.dispose();
					    }
					    else {
					    	
					    	JOptionPane.showConfirmDialog(null, "아이디나 비밀번호가 일치하지 않습니다.", "로그인 실패(Admin)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			    		}
				}
				

//					while(n != 4) {
//
//
//						n = s.nextInt();
//
//
//						switch(n){
//
//							case 1:
//								System.out.print("지폐 입금을 시작합니다.\n");
//
//								//입금할 지폐 장수 입력
//								System.out.print("입금하실 천원권을 입력해주세요.\n");
//								newcheonWon = s.nextInt();
//								System.out.print("입금하실 오천원권을 입력해주세요.\n");
//								newohCheonWon = s.nextInt();
//								System.out.print("입금하실 만원권을 입력해주세요.\n");
//								newmanWon = s.nextInt();
//								System.out.print("입금하실 오만원권을 입력해주세요.\n");
//								newohManWon = s.nextInt();
//								atm.billAdd(newcheonWon,newohCheonWon,newmanWon,newohManWon);
//								System.out.println("성공적으로 출금되었습니다!");	//
//								break;
//								
//							case 2:
//								System.out.print("지폐 출금을 시작합니다.\n");
//								System.out.print("출금하실 천원권을 입력해주세요.\n");
//								newcheonWon = s.nextInt();
//								System.out.print("출금하실 오천원권을 입력해주세요.\n");
//								newohCheonWon = s.nextInt();
//								System.out.print("출금하실 만원권을 입력해주세요.\n");
//								newmanWon = s.nextInt();
//								System.out.print("출금하실 오만원권을 입력해주세요.\n");
//								newohManWon = s.nextInt();
//								if(atm.leftCheonWon < newcheonWon) { System.out.println("천원권의 매수가 부족합니다!");  break; }
//								if(atm.left5CheonWon < newohCheonWon) { System.out.println("오천원권의 매수가 부족합니다!");  break; }
//								if(atm.leftManWon < newmanWon) { System.out.println("만원권의 매수가 부족합니다!");  break; }
//								if(atm.left5ManWon < newohManWon) { System.out.println("오만원권의 매수가 부족합니다!");  break; }
//								atm.billAdd(-newcheonWon,-newohCheonWon,-newmanWon,-newohManWon);
//
//								System.out.println("성공적으로 출금되었습니다!");
//								System.out.println("ATM기 안에 남은 천원권 장 수는 : " + atm.leftCheonWon);
//								System.out.println("ATM기 안에 남은 오천원권 장 수는 : " + atm.left5CheonWon);
//								System.out.println("ATM기 안에 남은 만원권 장 수는 : " + atm.leftManWon);
//								System.out.println("ATM기 안에 남은 오만원권 장 수는 : " + atm.left5ManWon);
//								break;
//							case 3:
//								//trans.getATMLeft();
//								System.out.println("ATM기 안에 남은 천원권 장 수는 : " + atm.leftCheonWon);
//								System.out.println("ATM기 안에 남은 오천원권 장 수는 : " + atm.left5CheonWon);
//								System.out.println("ATM기 안에 남은 만원권 장 수는 : " + atm.leftManWon);
//								System.out.println("ATM기 안에 남은 오만원권 장 수는 : " + atm.left5ManWon);
//								break;
//							case 4:
//
//								System.out.println("--- System : 로그아웃 성공 ---");
//								break;
//
//						}
//
//
//					}
////					continue;
			

//				case 2:		
			//유저로 로그인
				
				if(a == 2) {
					num = us.userIdentification(is_id, adPWD);
					System.out.println(num);
					
					int num2;
					
					if(is_id.equals("test1")) {
						num2 = 0;
					}else if(is_id.equals("test2")) {
						num2 = 1;
					}else {
						num2 = 2;
					}
					
					if(num == 1000){
						System.out.println("> 1을 누르면 입금, 2을 누르면 출금, 3을 누르면 계좌간 거래, 4를 계좌조회, 5를 누르면 로그인 화면으로 돌아갑니다.");
						atmFr.dispose();
					}
					else if(num == 2000) {
						// 로그인 실패 시
						JOptionPane.showConfirmDialog(null, "아이디나 비밀번호가 일치하지 않습니다.", "로그인 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					}
					
					
					
				}
//					//	n = s.nextInt();
				}
			
				
			});
			
			
//
//						switch(n){
//
//							case 1:
//								int vali;
//								System.out.print("입금을 시작합니다.\n");
//
//								System.out.print("입금 계좌를 입력해주세요.\n");
//								accNum = s.next();
//								System.out.print("계좌 비밀번호를 입력해주세요.\n");
//								accPWD = s.nextInt();
//								System.out.print("총 금액을 입력해주세요.\n");
//								total = s.nextInt();
//								System.out.print("입금하실 천원권 장 수를 입력해주세요.\n");
//								newcheonWon = s.nextInt();
//								System.out.print("입금하실 오천원권 장 수를 입력해주세요.\n");
//								newohCheonWon = s.nextInt();
//								System.out.print("입금하실 만원권 장 수를 입력해주세요.\n");
//								newmanWon = s.nextInt();
//								System.out.print("입금하실 오만원권 장 수를 입력해주세요.\n");
//								newohManWon = s.nextInt();
//								
//								if ((1000 * newcheonWon + 5000 * newohCheonWon + 10000 * newmanWon + 50000 * newohManWon) == total){
//									vali = ac.depositReq(accNum, accPWD, total, newcheonWon, newohCheonWon, newmanWon, newohManWon);
//									if(vali == 1000) {
//										atm.billAdd(newcheonWon,newohCheonWon,newmanWon,newohManWon);
//									}
//									
//								}else System.out.println("알맞은 장 수의 지폐를 넣어야 합니다!");
//			
//								
//								break;
//							case 2:
//								System.out.print("출금을 시작합니다.\n");
//								System.out.print("출금 계좌를 입력해주세요.\n");
//								accNum = s.next();
//								System.out.print("계좌 비밀번호를 입력해주세요.\n");
//								accPWD = s.nextInt();
//								System.out.print("총 금액을 입력해주세요.\n");
//								total = s.nextInt();
//								System.out.print("출금하실 천원권 장 수를 입력해주세요.\n");
//								newcheonWon = s.nextInt();
//								System.out.print("출금하실 오천원권 장 수를 입력해주세요.\n");
//								newohCheonWon = s.nextInt();
//								System.out.print("출금하실 만원권 장 수를 입력해주세요.\n");
//								newmanWon = s.nextInt();
//								System.out.print("출금하실 오만원권 장 수를 입력해주세요.\n");
//								newohManWon = s.nextInt();
//								if ((1000 * newcheonWon + 5000 * newohCheonWon + 10000 * newmanWon + 50000 * newohManWon) == total){
//									if (atm.leftCheonWon < newcheonWon) { System.out.println("ATM 내에 천원권 지폐가 부족합니다!"); break; }
//									if (atm.left5CheonWon < newohCheonWon) { System.out.println("ATM 내에 오천원권 지폐가 부족합니다!"); break; }
//									if (atm.leftManWon < newmanWon) { System.out.println("ATM 내에 만원권 지폐가 부족합니다!"); break; }
//									if (atm.left5ManWon < newohManWon) { System.out.println("ATM 내에 오만원권 지폐가 부족합니다!"); break; }
//									vali = ac.withdrawReq(accNum, accPWD, total, newcheonWon, newohCheonWon, newmanWon, newohManWon);
//									if(vali == 1000) {
//										atm.billAdd(-newcheonWon,-newohCheonWon,-newmanWon,-newohManWon);
//									}
//								}else System.out.println("알맞은 장 수의 지폐로 출금해야 합니다!");
//								
//								
//								break;
//							case 3:
//								System.out.print("계좌간 거래를 시작합니다.\n");
//								System.out.print("보내는 계좌번호를 입력해주세요.\n");
//
//								sendAccNum = s.next();
//								System.out.print("계좌 비밀번호를 입력해주세요.\n");
//
//								sendAccPWD = s.nextInt();
//								System.out.print("받는 계좌번호를 입력해주세요.\n");
//
//								sentAccNum = s.next();
//								System.out.print("보낼 총금액을 입력해주세요.\n");
//
//								total = s.nextInt();
//
//								ac.remitReq(sendAccNum,sendAccPWD,sentAccNum,total);
//								break;
//							case 4:
//								System.out.print("계좌 조회를 시작합니다.\n");
//								ac.depositSearch(user.get(num2).getUserName());						//처음 입력받은 고객이름에 해당하는 계좌 조회
//								break;
//							case 5:
//								System.out.println("--- System : 로그아웃 성공 ---");
//								break;
//						}
//					}
//			}
//		}
    }

}
