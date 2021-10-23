package atm_project;

import java.util.ArrayList;
import java.util.List;

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

    }
}
