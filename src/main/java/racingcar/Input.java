package racingcar;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int getInteger() throws IllegalArgumentException {
        String rawUserInput = Console.readLine();
        try {
            return Integer.parseInt(rawUserInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("NaN");
        }
    }

    public static List<String> getWordsInLimitedSize(String wordSepertor, int maxWordSize) throws IllegalArgumentException {
        String rawUserInput = Console.readLine();
        List<String> words = Arrays.asList(rawUserInput.split(wordSepertor));
        words.forEach(word -> checkLengthOfWord(word, maxWordSize));
        return words;
    }

    private static void checkLengthOfWord(String word, int maxWordSize) throws IllegalArgumentException {
        if (word.length() > maxWordSize) {
            throw new IllegalArgumentException("Word is too long");
        }
    }
}
