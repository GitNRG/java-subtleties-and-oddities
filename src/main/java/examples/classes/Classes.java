package examples.classes;


import helpers.Description;

import static helpers.Difficulty.*;
import static helpers.Topic.*;

public class Classes {
    /**
     * You can access private variables of inner class
     */
    @Description(topics = {INNER_CLASSES, ACCESS_MODIFIERS}, difficulty = EASY)
    private static class Inner {
        private static final Object CONST_1 = new Object();
        private Object notConst = new Object();
    }
    private void intruder() {
        Object o1 = Inner.CONST_1;
        Object o2 = new Inner().notConst;
    }


    /**
     * Cyclic dependencies are forbidden
     * it's compilation time error
     */
    @Description(topics = {INHERITANCE}, difficulty = EASY)
    public static void cyclicDependency() {}
    // static class XXX extends YYY{}
    // static class YYY extends XXX {}

    // static interface AAA extends BBB {}
    // static interface BBB extends AAA {}

    // static class A1 extends A3 {}
    // static class A2 extends A1 {}
    // static class A3 extends A2 {}


    /**
     * This class name is String, so it hides java.lang.String, so
     * assigning string literal to non-string reference is compilation time error
     */
    @Description(topics = {WEIRD_SYNTAX}, difficulty = MEDIUM)
    public static void stringHidding() {
        class String {
            // String x = "value";          // not ok
            java.lang.String y = "value";   // ok
        }
    }


    public static void main(String... args) {
    }
}
