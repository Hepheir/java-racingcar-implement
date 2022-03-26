package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private static final Consumer<Object> printFunction = x -> System.out.print(x);

    static void printLineBreak() {
        printFunction.accept('\n');
    }

    static void printInputGuideForCarName() {
        printFunction.accept(Text.INPUT_GUIDE_FOR_CAR_NAMES);
    };

    static void printInputGuideForTries() {
        printFunction.accept(Text.INPUT_GUIDE_FOR_TRIES);
    };

    static void printResultHeader() {
        printFunction.accept(Text.RESULT_HEADER);
    };

    static void printCar(Car car) {
        String name = car.getName();
        String position = repeat(Text.BAR, car.getPosition());
        printFunction.accept(String.format(Text.RESULT_OF_CAR, name, position));
    }

    private static String repeat(String source, int times) {
        String retval = "";
        for (int i = 0; i < times; i++) {
            retval = retval.concat(source);
        }
        return retval;
    }

    static void printWinners(List<String> namesOfWinners) {
        String joinedNames = String.join(Text.WORD_SEPERATOR, namesOfWinners);
        printFunction.accept(String.format(Text.WINNER, joinedNames));
    };

    static void printError(String message) {
        printFunction.accept(String.format(Text.ERROR, message));
    };

    static List<String> getUserInputForCarNames() {
        List<String> names;
        while (true) {
            try {
                names = getStrictUserInputForCarNames();
                return names;
            } catch (IllegalArgumentException exception) {
                printError("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static List<String> getStrictUserInputForCarNames() throws IllegalArgumentException {
        String rawUserInput = Console.readLine();
        String[] rawNames = rawUserInput.split(Text.WORD_SEPERATOR);
        List<String> names = new ArrayList<>(Arrays.asList(rawNames));
        names.forEach(name -> checkLengthOfCarName(name));
        return names;
    }

    private static void checkLengthOfCarName(String name) throws IllegalArgumentException {
        if (name.length() <= 5) {
            return;
        }
        throw new IllegalArgumentException("");
    }

    static int getUserInputForTries() {
        int tries;
        while (true) {
            try {
                tries = getStrictUserInputForTries();
                return tries;
            } catch (IllegalArgumentException exception) {
                printError("잘못된 값을 입력하였습니다.");
            }
        }
    }

    private static int getStrictUserInputForTries() throws IllegalArgumentException {
        String rawUserInput = Console.readLine();
        int userInput;
        try {
            userInput = Integer.parseInt(rawUserInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("");
        }
        return userInput;
    }
}
