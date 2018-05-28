package examples.oop;

import helpers.Description;

import java.util.List;
import java.util.Map;

import static helpers.Difficulty.EASY;
import static helpers.Difficulty.MEDIUM;
import static helpers.Topic.INHERITANCE;
import static helpers.Topic.OVERLOADING;
import static helpers.Topic.POLYMORPHISM;

public class OOP {
    /**
     * Accessing field directly uses ref type to get value.
     * We use inheritance to override method and get appropriate value.
     */
    @Description(topics = {INHERITANCE, POLYMORPHISM}, difficulty = EASY)
    public static class Snack {
        private String name = "Cookie";
        private double price = 0.15;

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
    public static class SnackAndBeverage extends Snack {
        private String name = "Cookie And Milk";
        private double price = 0.27;

        public String getName() {
            return name;
        }
    }
    public static void snackTester() {
        Snack s = new SnackAndBeverage();
        // method getName() is overloaded and can reach updated value
        System.out.println(s.name);         // Cookie
        System.out.println(s.getName());    // Cookie And Milk

        // method getPrice() is NOT overloaded and can NOT reach updated value
        System.out.println(s.price);         // 0.15
        System.out.println(s.getPrice());    // 0.15
    }


    /**
     * Overloaded method is defined at compilation time using reference type.
     * In case of null method with the most subclassed version will be called
     */
    @Description(topics = {OVERLOADING, POLYMORPHISM}, difficulty = MEDIUM)
    static class OverloadedMethods {
        static class RootClass {
        }

        interface RootInterface {
        }

        static class SubClass extends RootClass implements RootInterface {
        }

        static void shoot(RootClass r) {
            System.out.println("Using RootClass");
        }
        static void shoot(RootInterface i) {
            System.out.println("Using RootInterface");
        }
        static void shoot(SubClass s) {
            System.out.println("Using SubClass");
        }


        public static void shooter() {
            RootClass r = new SubClass(); // will print:
            shoot(r);                     // Using RootClass
            shoot((RootInterface) r);     // Using RootInterface
            shoot((SubClass) r);          // Using SubClass
            shoot(null);                  // Using SubClass
        }

        /**
         * We can also define one more class SubClass2 on the same level on hierarchy as SubClass
         * But in this case code won't compile as it's not clear what method to call
         */
        // static class SubClass2 extends RootClass implements RootInterface {
        // }
        // static void shoot(SubClass2 s) {
        //     System.out.println("Using SubClass");
        // }
        // public static void shooter() {
        //     shoot(null);
        // }
    }

    /**
     * You can cast null to some type;
     */
    @Description(topics = {POLYMORPHISM}, difficulty = EASY)
    static int getNumber(List x) {
        return 5;
    }
    static int getNumber(Map x) {
        return 10;
    }
    int five = getNumber((List)null);
    int ten = getNumber((Map)null);


    /**
     * This will compile (at least with early version of jdk8),
     * but an attempt to call any of these methods will cause runtime error.
     * Although signature is different at runtime due to boxing/unboxing
     * mechanism we can't define what method is required
     */
    @Description(topics = {POLYMORPHISM}, difficulty = MEDIUM)
    static class OverloadErrorExample {
        static void noOp(int... elements){
        }
        static void noOp(Integer... elements){
        }
    }


    public static void main(String... args) {
    }
}
