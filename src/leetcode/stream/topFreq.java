ackage leetcode;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.*;

public class topKfreq {

    public static void main(String[] args) {
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words1, 3));
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent(words2, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Long> pairs = Arrays.stream(words)
                .collect(Collectors
                        .groupingBy(Function.identity(),
                                Collectors.counting()
                        )
                );
        System.out.println(pairs);
        return Arrays.stream(words) .distinct()
                .sorted((y, x) -> compare(pairs, x, y))
                .limit(k)
                .collect(Collectors.toList());
    }
    public static int compare(Map<String, Long> pairs, String x, String y){
        if (pairs.get(x) - pairs.get(y) == 0) {
            return y.compareTo(x);
        }
        return (int) (pairs.get(x) - pairs.get(y));
    }
}
