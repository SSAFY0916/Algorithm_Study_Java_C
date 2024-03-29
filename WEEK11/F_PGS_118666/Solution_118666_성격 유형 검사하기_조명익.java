import java.util.*;

public class Solution {

    int[] scoreByChoice = {0, -3, -2, -1, 0, 1, 2, 3};

    Map<Character, Character> typeByType = Map.of(
            'R', 'T',
            'T', 'R',
            'C', 'F',
            'F', 'C',
            'J', 'M',
            'M', 'J',
            'A', 'N',
            'N', 'A'
    );

    Map<Character, Integer> scoreByType = new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        char[] types = {'T', 'F', 'M', 'N'};
        for (char type : types) {
            scoreByType.put(type, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            int c = choices[i];

            if (s.contains("T")) {
                setScore(s, c, 'T');
            } else if (s.contains("F")) {
                setScore(s, c, 'F');
            } else if (s.contains("M")) {
                setScore(s, c, 'M');
            } else if (s.contains("N")) {
                setScore(s, c, 'N');
            }
        }

        StringBuilder result = new StringBuilder();
        for (char type : types) {
            int score = scoreByType.get(type);
            if (score > 0) {
                result.append(type);
            } else {
                result.append(typeByType.get(type));
            }
        }

        return result.toString();
    }

    private void setScore(String s, int c, char target) {
        int temp;
        if (s.charAt(0) == target) {
            temp = -scoreByChoice[c];
        } else {
            temp = scoreByChoice[c];
        }

        scoreByType.put(target, scoreByType.get(target) + temp);
    }

}
