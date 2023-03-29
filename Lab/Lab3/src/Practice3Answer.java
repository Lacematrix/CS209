import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Practice3Answer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = """
            Please input the function No:
            1 - Get even numbers
            2 - Get odd numbers
            3 - Get prime numbers
            4 - Get prime numbers that are bigger than 5
            0 - Quit
            """;
        while (true) {
            System.out.print(s);
            int model = scanner.nextInt();
            if (model == 0){
                break;
            }
            System.out.println("Input size of the list:");
            int size = scanner.nextInt();
            System.out.println("Input elements of the list:");
            int[] list = new int[size];
            for (int i = 0; i < size; i++) {
                list[i] = scanner.nextInt();
            }
            Predicate<Integer> isEven = t -> t % 2 == 0;
            Predicate<Integer> isPrime = t -> {
                for (int i = 2; i < t; i++) {
                    if (t % i == 0){
                        return false;
                    }
                }
                return true;
            };
            Predicate<Integer> isBigger = t -> t > 5;
            ArrayList<Integer> result = new ArrayList<>();

            switch (model) {
                case 1:
                    for (int i = 0; i < size; i++) {
                        if (isEven.test(list[i])){
                            result.add(list[i]);
                        }
                    }
                    System.out.println("Filter results:");
                    System.out.println(result);
                    break;
                case 2:
                    for (int i = 0; i < size; i++) {
                        if (!isEven.test(list[i])){
                            result.add(list[i]);
                        }
                    }
                    System.out.println("Filter results:");
                    System.out.println(result);
                    break;
                case 3:
                    for (int i = 0; i < size; i++) {
                        if (isPrime.test(list[i])){
                            result.add(list[i]);
                        }
                    }
                    System.out.println("Filter results:");
                    System.out.println(result);
                    break;
                case 4:
                    for (int i = 0; i < size; i++) {
                        if (isBigger.and(isPrime).test(list[i])){
                            result.add(list[i]);
                        }
                    }
                    System.out.println("Filter results:");
                    System.out.println(result);
                    break;
            }
        }
    }

}
