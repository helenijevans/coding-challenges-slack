import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int rankedCount = Integer.parseInt(br.readLine().trim());
        List<Integer> ranked = Arrays.stream(br.readLine().trim().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int playerCount = Integer.parseInt(br.readLine().trim());
        List<Integer> player = Arrays.stream(br.readLine().trim().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = climbingLeaderboard(ranked, player);

        for (int score : result) {
            bw.write(score + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        ranked = new ArrayList<>(new HashSet<>(ranked));
        ranked.sort(Collections.reverseOrder());
        // System.out.println(ranked + " " + player);
        List<Integer> answer = new ArrayList<>();

        for (int play : player) {
            if (ranked.get(ranked.size() - 1) > play) {
                ranked.add(play);
                answer.add(ranked.indexOf(play) + 1);
            } else if (ranked.get(0) < play) {
                ranked.add(0, play);
                answer.add(ranked.indexOf(play) + 1);
            } else if (ranked.contains(play)) {
                answer.add(ranked.indexOf(play) + 1);
            } else {
                ranked = putInRank(play, ranked);
                answer.add(ranked.indexOf(play) + 1);
            }
        }

        return answer;
    }

    public static List<Integer> putInRank(int value, List<Integer> ranked) {
        List<Integer> newRanking = new ArrayList<>();
        boolean placed = false;
        for (int item : ranked) {
            if (value > item && !placed) {
                newRanking.add(value);
                newRanking.add(item);
                placed = true;
            } else {
                newRanking.add(item);
            }
        }
        return newRanking;
    }
}
