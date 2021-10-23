package atm_project;

import java.util.ArrayList;
import java.util.List;

public class ATM {
    public static void main(String[] args) {

        List<Admin> admin = new ArrayList<>();
        List<User> user = new ArrayList<>();
        List<Account> acc = new ArrayList<>();

        User newUser1 = new User("성우진", "test1", 0000, 1, "111122223333", null, null);
        user.add(newUser1);
        User newUser2 = new User("최준혁", "test2", 2449, 2, "123456789012", "123412341234", null);
        user.add(newUser2);
        User newUser3 = new User("정수현", "test3", 6631, 3, "999988887777", "666655554444", "333322221111");
        user.add(newUser3);
        Admin newAdmin1 = new Admin("admin1", 1234, "관리자1");
        admin.add(newAdmin1);
        Admin newAdmin2 = new Admin("admin2", 5678, "관리자2");
        admin.add(newAdmin2);
        Account newAcc1 = new Account("성우진", "111122223333", 1250000, 1,1111);
        acc.add(newAcc1);
        Account newAcc2 = new Account("최준혁", "123456789012", 3800000, 1, 1111);
        acc.add(newAcc2);
        Account newAcc3 = new Account("최준혁", "123412341234", 5000000, 2, 2222);
        acc.add(newAcc3);
        Account newAcc4 = new Account("정수현", "999988887777", 1800000, 1, 1111);
        acc.add(newAcc4);
        Account newAcc5 = new Account("정수현", "666655554444", 800000, 2, 2222);
        acc.add(newAcc5);
        Account newAcc6 = new Account("정수현", "333322221111", 240000, 3, 3333);
        acc.add(newAcc6);


        //기존정보저장역할하던애들 다 빼고 입력 총액이랑 지폐별 장수 합산한 금액 같은지는 여기서 판별해서 넘겨주세요!
    }
}
