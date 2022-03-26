package racingcar;

import java.util.List;
import java.util.function.Consumer;

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
}
