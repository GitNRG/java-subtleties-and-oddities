package examples.operators;

import helpers.Description;
import helpers.Difficulty;

import static helpers.Difficulty.*;
import static helpers.Topic.*;

public class Operators {

    /**
     * Variables of type byte,char,short are converted to int
     * so operations will result to in as well
     * Commented lines won't compile
     */
    @Description(topics = {PRIMITIVES, CASTING}, difficulty = EASY)
    public static void subIntTypes() {
        byte b1 = 1;
        byte b2 = 1;
        // byte x = b1 * b2;
        // char c = b1 - b2;
        // short s = b1 * 3;

        // byte x = b1 + 1;
        byte z1 = b1++;
        // byte x = b1 * '2';
        byte z2 = 2 * '2';

        short z3 = b1++;
        // char c = b1++;
        // short x  = b1 + 1;
        // char x  = b1 + 1;
    }

    /**
     * Operations on primitives return value
     */
    @Description(topics = {PRIMITIVES}, difficulty = EASY)
    public static void operationOnPrimitives() {
        int x = 5;
        int a = x - 7;
        int b = a += 2;
        int c = b * 3;
        int d = c / 1;
        int e = d % 2;
        int f = e >> 2;
        int hell = (a * b ^ (c << (d ^ e)) + f % x);
    }

    /**
     * Just a few examples of using - and + with primitives
     */
    @Description(topics = {PRIMITIVES, WEIRD_SYNTAX}, difficulty = EASY)
    public static void testNegation() {
        // unary + or - is ok
        int v1 = 7;
        int v2 = -v1;
        int positive = 1;
        int positive2 = -+-+positive;
        int positive3 = -(-positive);
        int negative = +-positive;
        int negative2 = +(-positive);
        int dontDoThis = +-+-+-+-+-+-+-positive;
        // consecutive + - is forbidden (except pre/post increment/decrement ++ and --)
        // int error = ---positive;
        // int error = +++++positive;
        // int error = ++-positive;
    }

    /**
     * Negation of x is 0-x, so negation of min value leads to overflow and back to min value
     */
    @Description(topics = {PRIMITIVES, WEIRD_SYNTAX}, difficulty = HARD)
    public static void justDealWithIt() {
        boolean willBeTrue = Integer.MIN_VALUE == -Integer.MIN_VALUE;
    }


    /**
     * Just an examples of char/int overflow
     */
    @Description(topics = {PRIMITIVES}, difficulty = EASY)
    public static void overflowExample() {
        // just an example of overflow
        char maxChar = 0xFFFF;
        maxChar++; // now it's 0
        int maxInt = Integer.MAX_VALUE;
        maxInt++; // now it's Integer.MIN_VALUE, -2147483648
    }


    /**
     * Just an examples of using NaN and Infinity
     */
    @Description(topics = {PRIMITIVES}, difficulty = MEDIUM)
    public static void usingNaNAndInfinity() {
        // operations on NaN
        double itsNaN = 0.0 / 0.0; // ok at compile time. not ok at runtime
        boolean b1 = itsNaN == Double.NaN; // false
        boolean b2 = itsNaN != Double.NaN; // true
        boolean b3 = Double.NaN == Double.NaN; // false (nothing equals NaN)
        boolean b4 = Double.isNaN(itsNaN);  // true
        boolean b5 = Double.isNaN(itsNaN * 0); // true (any operation with NaN -> NaN)

        // operations on Infinity
        b1 = -1 / 0.0 == Double.POSITIVE_INFINITY;  // false
        b2 = 1 / 0.0 == Double.POSITIVE_INFINITY;   // true
        b3 = 1 / 0.0 == Double.NEGATIVE_INFINITY;   // false
        b4 = -1 / 0.0 == Double.NEGATIVE_INFINITY;  // true
        b5 = Double.isInfinite(1 / 0.0) && Double.isInfinite(-1 / 0.0); // true
    }

    /**
     * A little be tricky conversion
     * x += 1 will eventually be x = (type of x)(x + 1)
     * x = x + 1 will be to casted to int, as 1 is of type int
     */
    @Description(topics = {PRIMITIVES, OPERATORS}, difficulty = Difficulty.MEDIUM)
    public void sumTypeConvertion() {
        // ok
        byte x1 = 1;
        x1 += 1;

        // not ok. x2 + 1 is of type int
        byte x2 = 1;
        //x2 = x2 + 1;
    }

    /**
     * Adding chars is basically adding char codes
     */
    @Description(topics = {PRIMITIVES, WEIRD_SYNTAX}, difficulty = Difficulty.EASY)
    public void charManipulations() {
        char c1 = '5'; // 53
        char c2 = '7'; // 55
        // this won't compile as char + char -> int
        // char c3 = c1 + c2;
        int i3 = c1 + c2; // 53 + 55 = 108. it's 'l'
        System.out.println(i3); // will print 108
        System.out.println((char) i3);  // will print 'l'. not 57

        String s1 = "5";
        String s2 = "7";
        String s3 = s1 + s2;
        System.out.println(s3); // will print 57

        // just a few more weird examples
        char x1 = (char) ('3' * '0');
        System.out.println(x1);  // x1 = 2448. it's ঐ, not 0
        char x2 = (char) ('\u1000' / '0');
        System.out.println(x2);  //x2 = 85. it's U
        char x3 = (char) ('3' * 5 - 1234 / '0');
        System.out.println(x3);  //x3 = 230. it's æ
    }

    /**
     * Inversion converts type to int, so it's impossible to assign it to byte without explicit casting
     */
    @Description(topics = {PRIMITIVES, OPERATORS}, difficulty = Difficulty.MEDIUM)
    public void negationOfSubIntegerTypes() {
        int a1 = 5;
        int a2 = -a1; // ok
        byte b1 = 5;
        // byte b2 = -b1; // this wont compile
    }

    /**
     * Explicit null with instanceof is ok
     */
    @Description(topics = {OPERATORS, NULL}, difficulty = EASY)
    public static void usingNullWithInstanceOf() {
        if (null instanceof Object) {
            // totally fine for compiler although this code is unreachable
        }
    }

    /**
     * Ternary operator is casting result to the broadest possible type
     */
    @Description(topics = {OPERATORS}, difficulty = MEDIUM)
    public static void ternaryOperatorCasting() {
        // due to type casting 10 will be of type Double
        Object result = true ? new Integer(10) : new Double(20.0);
        boolean thisIsFalse1 = result.equals(10);
        boolean thisIsFalse2 = result instanceof Integer;
        boolean thisIsTrue1 = result.equals(10.0);
        boolean thisIsTrue2 = result instanceof Double;
    }

    public static void main(String... args) {
        // rarely used operations
        // todo ~ and >>>
    }
}
