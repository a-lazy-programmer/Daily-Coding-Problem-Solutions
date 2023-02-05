package testcases;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
public class TestCaseGenerator {

    private static Random random = new Random();

    public static int generateRandomNumber(int lower_bound, int higher_bound) {
        int random_number = random.nextInt(higher_bound) + lower_bound;
        return random_number;
    }

    public static int[] generaterandom_array(int numberOfElements, int lower_bound, int higher_bound) {
        int[] random_array = new int[numberOfElements];
        Set<Integer> unique_array = new HashSet<>();
        for (int i = 0; i < numberOfElements; i++) {
            int number;
            do {
                number = generateRandomNumber(lower_bound, higher_bound);
            } while (unique_array.contains(number));
            random_array[i] = number;
            unique_array.add(number);
        }
        return random_array;
    }

    public static void main(String[] args) {
        // Sample Usage
        int[] random_array = TestCaseGenerator.generaterandom_array(10, 1, 100);
        System.out.println(Arrays.toString(random_array));
        int random_number = TestCaseGenerator.generateRandomNumber(1, 100);
        System.out.println("Random Number: " + random_number);
    }
}
