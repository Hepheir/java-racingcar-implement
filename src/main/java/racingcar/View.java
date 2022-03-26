package racingcar;

import java.util.List;

public class View {
    static void printLineBreak() {
        Output.print('\n');
    }

    static void printInputGuideForCarName() {
        Output.print(Text.INPUT_GUIDE_FOR_CAR_NAMES);
    };

    static void printInputGuideForTries() {
        Output.print(Text.INPUT_GUIDE_FOR_TRIES);
    };

    static void printResultHeader() {
        Output.print(Text.RESULT_HEADER);
    };

    static void printCar(Car car) {
        String name = car.getName();
        String position = repeat(Text.BAR, car.getPosition());
        Output.print(String.format(Text.RESULT_OF_CAR, name, position));
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
        Output.print(String.format(Text.WINNER, joinedNames));
    };

    static void printError(String message) {
        Output.print(String.format(Text.ERROR, message));
    };
}
