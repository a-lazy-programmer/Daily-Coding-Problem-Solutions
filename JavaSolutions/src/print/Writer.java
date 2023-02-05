package print;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Writer {

    private static PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

    public static void write(String string) {
        writer.println(string);
        writer.flush();
    }

    public static void write(boolean result, boolean bestcase) {
        writer.println(String.format("Result: %s BestCase: %s", result, bestcase));
        if(result == bestcase) {
            writer.println("Testcase Passed");
        }
        else {
            writer.println("Testcase Failed");
        }
        writer.flush();
    }

    public void write(int testcase_number, int result, int bestcase) {
        writer.println(String.format("Result: %d BestCase: %d", result, bestcase));
        if(result == bestcase) {
            writer.println("Testcase Passed");
        }
        else {
            writer.println("Testcase Failed");
        }
        writer.flush();
    }
}
