package problem1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

import print.Writer;
import testcases.TestCaseGenerator;
/* Daily Coding Problem Problem #1
**********************************************************************************************************************************************************
* Good morning! Here's your coding interview problem for today.
* This problem was recently asked by Google.
* Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
* For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
* Bonus: Can you do this in one pass?
* Upgrade to premium and get in-depth solutions to every problem, including this one.
* If you liked this problem, feel free to forward it along so they can subscribe here! As always, shoot us an email if there's anything we can help with!
* Master algorithms together on Binary Search. Create a room, invite your friends, and race to finish the problem!
* No more? Snooze or unsubscribe.
**********************************************************************************************************************************************************
*/
class BruteForce {
    public static boolean twoSum(int[] numbers, int n, int target) {
        Writer.write("Brute Force Solution");
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(numbers[i] + numbers[j] == target) {
                    // System.out.println(String.format("X: %d Y: %d", numbers[i], numbers[j]));
                    return true;
                }
            }
        }
        return false;
    }
}
class SortingInputArray {
    public static boolean twoSum(int[] numbers, int n, int target) {
        Writer.write("Sorting Input Array Solution");
        boolean result = false;
        Arrays.sort(numbers);
        int left = 0;
        int right = n - 1;
        while(left < right) {
            int curr_sum = numbers[left] + numbers[right];
            if(curr_sum == target) {
                result = true;
                break;
            }
            else if(curr_sum < target) {
                left += 1;
            }
            else {
                right -= 1;
            }
        }
        return result;
    }
}
class BestCase {
    public boolean twoSum(int[] numbers, int target) {
        HashSet<Integer> difference = new HashSet<Integer>();
        for(int number : numbers) {
            if(difference.contains(target - number)) {
                return true;
            }
            difference.add(number);
        }
        return false;
    }
}
public class Solutions {
    public static void main(String[] args) throws NumberFormatException, IOException {
        try {
            System.out.println("Daily Coding Problem #1");
            // Input
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
            // Reading the total number of Test cases
            String testcases = bufferReader.readLine();
            int number_of_test_cases = Integer.parseInt(testcases);
            // Bestcase
            BestCase bestcase = new BestCase();
            int testcase_number = 1;
            while (testcase_number <= number_of_test_cases) {
                Writer.write(String.format("Testcase %d:", testcase_number));
                int number_of_elements = TestCaseGenerator.generateRandomNumber(2, 20);
                Writer.write(String.format("Number of Elements: %d", number_of_elements));
                int[] numbers = TestCaseGenerator.generaterandom_array(number_of_elements, 1, 100);
                Writer.write(String.format("Elements: %s", Arrays.toString(numbers)));
                int target = TestCaseGenerator.generateRandomNumber(1, 100);
                Writer.write(String.format("Target: %s", target));
                boolean bestcase_result = bestcase.twoSum(numbers, target);
                // BruteForce
                boolean bruteforce_result = BruteForce.twoSum(numbers, number_of_elements, target);
                Writer.write(bruteforce_result, bestcase_result);
                // SortingInputArray
                boolean sorting_input_result = SortingInputArray.twoSum(numbers, number_of_elements, target);
                Writer.write(sorting_input_result, bestcase_result);
                testcase_number++;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format");
        } catch (IOException e) {
            System.out.println("Error: I/O Exception");
        }
    }
}