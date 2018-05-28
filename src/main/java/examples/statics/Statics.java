package examples.statics;

import helpers.Description;

import static helpers.Difficulty.*;
import static helpers.Topic.*;

public class Statics {
    /**
     * 'Overriding' static methods is tricky.
     * At runtime actual behaviour will be defined by reference type, not by instance type
     */
    @Description(topics = {STATIC, INHERITANCE, POLYMORPHISM}, difficulty = MEDIUM)
    static class A {
        public static void m1() {
            System.out.println("A.m1()");
        }

        public void m2() {
            System.out.println("A.m2()");
        }
    }
    static class B extends A {
        // @Override - compilation error
        public static void m1() {
            System.out.println("B.m1()");
        }

        @Override
        public void m2() {
            System.out.println("B.m2()");
        }
    }
    public static void staticMethodOverride() {
        System.out.println("Class method");
        A.m1();         // will print A.m1()
        B.m1();         // will print B.m1()
        A a;
        a = new A();
        a.m1();         // will print A.m1()
        a = new B();
        a.m1();         // will print A.m1()
        B b;
        b = new B();
        b.m1();         // will print B.m1()
        System.out.println("Instance method");
        a = new A();
        a.m2();         // will print A.m2()
        a = new B();
        a.m2();         // will print B.m2()
    }


    /**
     * Static blocks are initialized consequently, but pay attention that
     * no matter is it static block or static variable - sequence is the same
     */
    @Description(topics = {STATIC}, difficulty = EASY)
    static class BlockBeforeVariable {
        static {
            x = 10;
        }
        static int x = 5;
    }
    static class VariableBeforeBlock {
        static int x = 77;
        static {
            x = 99;
        }
    }
    public static void staticBlockStaticField() {
        System.out.println(BlockBeforeVariable.x); // will print 5
        System.out.println(VariableBeforeBlock.x); // will print 99
    }

    public static void main(String... args) {
    }
}
