import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static int countOccurrences(Map<Character, Integer> map, int targetValue) {
    int count = 0;
      for (int value : map.values()) {
            if (value == targetValue) {
                count++;
            }
        }
    return count;
}

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        Map<Character, Integer> analysis = new HashMap<>();
        for (char c : s.toCharArray()) {
            analysis.put(c, analysis.getOrDefault(c, 0) + 1);
        }

        int minimumOccurrence = Collections.min(analysis.values());
        char mostCommonLetter = ' ';
        int maxFrequency = 0;
        for (Map.Entry<Character, Integer> entry : analysis.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostCommonLetter = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        if (minimumOccurrence == maxFrequency) {
            return "YES";
        } else if (minimumOccurrence == maxFrequency - 1) {
            analysis.put(mostCommonLetter, analysis.get(mostCommonLetter) - 1);
            System.out.println(analysis);
            System.out.println(analysis.size());
            if (countOccurrences(analysis, minimumOccurrence) == analysis.size()) {
                return "YES";
            }
        }
        return "NO";
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
