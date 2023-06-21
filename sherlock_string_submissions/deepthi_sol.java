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
                //map to get the frequency of each character
        Map<Character, Integer> charFrequency = new HashMap<>();
        for(char c: s.toCharArray()){
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        //map to get the count of frequencies
        Map<Integer, Integer> freqCount = new HashMap<>();
        for(int count : charFrequency.values()){
            freqCount.put(count, freqCount.getOrDefault(count, 0) + 1);
        }
        if (freqCount.size() > 2) {
            return "NO";
        }

        int minFreq = Collections.min(charFrequency.values());
        int maxFreq = Collections.max(charFrequency.values());

        int minCount = freqCount.get(minFreq);
        int maxCount = freqCount.get(maxFreq);

        // If the minimum frequency occurs only once and it is equal to 1
        if (minCount == 1 && minFreq == 1) {
            return "YES";
        }

        // If the maximum frequency occurs only once and its value is one more than the minimum frequency
        if (maxCount == 1 && maxFreq == minFreq + 1) {
            return "YES";
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
