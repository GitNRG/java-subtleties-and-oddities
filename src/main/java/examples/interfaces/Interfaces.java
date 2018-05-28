package examples.interfaces;

import helpers.Description;

import static helpers.Difficulty.*;
import static helpers.Topic.*;

public class Interfaces {
    /**
     * At runtime java will first look for method implementation in classes and only if nothing was found
     * it will fall back to default implementations.
     * In case below method getName() is defined, but has private modifier, so it remains unreachable.
     */
    @Description(topics = {INTERFACES, POLYMORPHISM}, difficulty = HARD)
    interface Nameable {
        default String getName() {return "NoName";};
    }
    static class Jane {
        private String getName() {return "Jane";};
    }
    static class Clash extends Jane implements Nameable {
    }
    public static void roadToException() {
        // Exception in thread "main" java.lang.IllegalAccessError:
        // tried to access method examples.interfaces.Interfaces$Jane.getName()Ljava/lang/String;
        // from class examples.interfaces.Interfaces
        new Clash().getName();
    }

    public static void main(String... args) {
        roadToException();
    }
}
