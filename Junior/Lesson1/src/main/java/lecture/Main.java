package lecture;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        PlainInterface plainInterface = new PlainInterface() {
//            @Override
//            public String action(int x, int y) {
//                return String.valueOf(x + y);
//            }
//        };

//        PlainInterface plainInterface = (x, y) -> x + y; // lambda
//
//        PlainInterface plainInterface1 = (x, y) -> Integer.compare(x, y);
//
//        PlainInterface plainInterface2 = Integer::compare;
//
//        System.out.println(plainInterface.action(5, 3));
//        System.out.println(plainInterface1.action(1, 5));
//        List<String> list = Arrays.asList("Hi", "world", "!", "born");

//        list.stream().
//                filter(str -> str.length() > 3).
//                filter(str -> str.contains("w")).
//                forEach(System.out::println);
//
//        Arrays.asList(1, 10, 0, 5, 5).stream().sorted().distinct().map(x -> x*x).forEach(System.out::println);

        List<User> list = Arrays.asList(new User("Pavel", 25),
                new User("Vasiliy", 19),
                new User("Ivan", 43)
        );


        list.stream().
                map(user -> new User(user.name, user.age - 5)).
                filter(user -> user.age > 20).
                forEach(System.out::println);
    }
}
