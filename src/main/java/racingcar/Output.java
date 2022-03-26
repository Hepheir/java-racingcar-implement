package racingcar;

import java.util.function.Consumer;

public class Output {
    private static final Consumer<Object> printFunction = x -> System.out.print(x);

    public static void print(Object x) {
        printFunction.accept(x);
    }
}
