package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private static Consumer<Object> printFunction = System.out::print;

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

    static void printWinners() {
        String names = String.join(Text.WORD_SEPERATOR, Model.getFurthestCarNames());
        printFunction.accept(String.format(Text.WINNER, names));
    };

    static void printError(String message) {
        printFunction.accept(String.format(Text.ERROR, message));
    };

    static List<String> getUserInputForCarNames() {
        String rawUserInput = Console.readLine();
        String[] names = rawUserInput.split(Text.WORD_SEPERATOR);
        return new ArrayList<>(Arrays.asList(names));
    }

    static int getUserInputForTries() {
        String rawUserInput = Console.readLine();
        return Integer.parseInt(rawUserInput);
    }
}
