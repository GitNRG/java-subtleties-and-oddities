package examples.variables;

import helpers.Description;
import helpers.Difficulty;

import java.util.Arrays;

import static helpers.Difficulty.EASY;
import static helpers.Topic.*;

public class Declarations {
    /**
     * Number systems
     */
    @Description(topics = {PRIMITIVES}, difficulty = Difficulty.EASY)
    public static void usingDifferentRadix() {
        int decimal_42 = 42;
        int hexadecimal_42 = 0x2a;
        int binary_42 = 0b101010;
        int octal_42 = 052;
        long number_base_32 = Long.valueOf("itsnumber", Character.MAX_RADIX); // 53114931150147
    }

    /**
     * It's ok to use underscores in literal values.
     * Exceptions:
     *  -At the beginning or end of a number
     *  -Adjacent to a decimal point in a floating point literal
     *  -Prior to an F or L suffix
     *  -In positions where a string of digits is expected
     */
    @Description(topics = {PRIMITIVES}, difficulty = Difficulty.EASY)
    public static void unsingUnderscores() {
        long creditCardNumber = 1234_5678_9012_3456L;
        long socialSecurityNumber = 999_99_9999L;
        float pi = 3.14_15F;
        long hexBytes = 0xFF_EC_DE_5E;
        long hexWords = 0xCAFE_BABE;
        long maxLong = 0x7fff_ffff_ffff_ffffL;
        byte nybbles = 0b0010_0101;
        long bytes = 0b11010010_01101001_10010100_10010010;
        int x3 = 5_______2;
        int x6 = 0x5_2;
        //    errors
        //    float pi1 = 3_.1415F;
        //    float pi2 = 3._1415F;
        //    int x2 = 52_;
        //    int x4 = 0_x52;
        //    int x5 = 0x_52;
        //    int x7 = 0x52_;
    }

    /**
     * These are equivalent declarations
     */
    @Description(topics = {ARRAYS}, difficulty = Difficulty.EASY)
    public static void arrays() {
        // case 1
        int[] a;
        int b[];
        // case 2
        int[][] c;
        int[] d[];
        int e[][];
        // case 3
        int[] f = new int[]{1, 2};
        int[] g = {1, 2};
    }

    /**
     * Weird looking though valid array
     */
    @Description(topics = {ARRAYS, WEIRD_SYNTAX}, difficulty = Difficulty.EASY)
    public static void weirdArraySynatax() {
        int[][][][][][] h = {{{{{{7}}}}}};
    }

    /**
     * Compiler won't complain on something like this,
     * although at runtime some examples here will cause an exception
     */
    @Description(topics = {PRIMITIVES}, difficulty = Difficulty.EASY)
    public static void declaringNaN() {
        double nan1 = 3.0 / 0;           // Infinity
        double nan2 = 3.0 / Double.NaN;  // NaN
        double nan3 = Double.NaN / 0;    // any operation with NaN returns NaN
        double nan4 = Double.NaN / Double.POSITIVE_INFINITY; // NaN
        double nan5 = Double.NEGATIVE_INFINITY * Double.POSITIVE_INFINITY; // -Infinity
        double nan6 = Double.POSITIVE_INFINITY * Double.NEGATIVE_INFINITY; // -Infinity
    }


    /**
     * Since char is basically number you can do something like this
     * But not that numeric types are assigned char codes, not the values you can read.
     */
    @Description(topics = {PRIMITIVES, WEIRD_SYNTAX}, difficulty = Difficulty.EASY)
    public static void treatingCharAsNumber() {
        byte v1 = '1';      // note v1 != 1. in fact v1 == 49
        short v2 = '2';
        int v3 = '3';
        long v4 = '4';
        float v5 = '5';
        double v6 = '6';
    }

    /**
     * Empty char is forbidden
     */
    @Description(topics = {PRIMITIVES}, difficulty = EASY)
    public static void thisWontCompile() {
        // char x = '';
    }

    /**
     * It's not forbidden to apply casting multiple times
     */
    @Description(topics = {PRIMITIVES, WEIRD_SYNTAX}, difficulty = Difficulty.EASY)
    public void extraCasting() {
        int intVal = 120; // char for 120 is 'x'
        char c1 = (char) (char) (char) (char) (char) intVal; // still 'x'
        char c2 = (char) (int) (float) (int) intVal;  // still 'x'
    }

    /**
     * Char has range 0 - 65536, which is always positive
     * What would happen on an attempt to assign negative value?
     */
    @Description(topics = {PRIMITIVES}, difficulty = Difficulty.MEDIUM)
    public void usingCharWithNegativeValue() {
        int i = -1;
        char c1 = (char) i; // c1 will be 65535
        short s = -1;
        char c2 = (char) s; // c2 will be 65535
        byte b = -1;
        char c3 = (char) b; // c3 will be 65535
    }

    /**
     * Some examples of neat array declaration that's not always possible
     */
    @Description(topics = {ARRAYS}, difficulty = Difficulty.EASY)
    static void arrayDeclaration() {
        // you can declare an array like this
        String[] arr1 = {"say", "hi"};
        // although
        String[] arr2;
        // wrong
        // arr2 = {"say", "hello"};
        // right
        arr2 = new String[]{"say", "hello"};

        // also you can't pass it as argument
        // wrong
        // Arrays.asList({"el1", "el2"});
        // right
        Arrays.asList(new String[]{"el1", "el2"});
    }


    /**
     * It's possible to access static variable before initialization, but not instance variable.
     */
    @Description(topics = {STATIC}, difficulty = Difficulty.MEDIUM)
    static class UsingNotIniailizedVariable {
        static int b = UsingNotIniailizedVariable.a;
        static int a = 3;

        // forbidden forward reference
        // int y = x;
        // int x = 3;

        // this is ok
        int u = 8;
        int v = u;

        public static void printState() {
            System.out.println("a = " + a + ", b = " + b); // prints 'a = 3, b = 0'
        }
    }


    public static void main(String... args) {
    }
}
