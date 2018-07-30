package examples.concurrency;

import helpers.Description;

import java.util.concurrent.atomic.AtomicLong;

import static helpers.Difficulty.*;
import static helpers.Topic.*;

public class Concurrency {
    /**
     * Java synchronized blocks are re-entrant. This means that if thread has acquired some lock it will
     * internally increment lock counter but will be able to re-enter it many times. When leaving this block it
     * will decrement internal counter to 0 and will release it
     */
    @Description(topics = {CONCURRENCY}, difficulty = MEDIUM)
    static class A {
        protected synchronized void m1() {
            System.out.println("A.m1");
        }
    }

    static class B extends A {
        @Override
        protected synchronized void m1() {
            System.out.println("B.m1");
            // will enter another synchronized block as they are using the same lock (instance of B)
            super.m1();
        }
    }

    public static void testReEntrancy() {
        new B().m1();
    }


    /**
     * Operations on primitives that take up to 32 bits are atomic, so single operation could be considered thread safe.
     * Operations on 64-bit long primitives (long and double) are NOT thread safe. To make them thread safe they have to be
     * either volatile, synchronized or replaces with thread safe wrapper.
     * Note: this doesn't NOT apply to non-atomic operations, like increment. These operations are still NOT thread safe
     */
    @Description(topics = {CONCURRENCY}, difficulty = MEDIUM)
    byte threadSafe1 = 1;
    char threadSafe2 = 1;
    short threadSafe3 = 1;
    int threadSafe4 = 1;
    float threadSafe5 = 1;
    boolean threadSafe6 = true;
    // not thread safe assingment
    long notThredSafe1 = 1;
    double notThredSafe2 = 1;
    // make it safe again
    AtomicLong threadSafeAgain1 = new AtomicLong(1);
    volatile long threadSafeAgain2 = 1;
    volatile double threadSafeAgain3 = 1;
    // not thread safe operation (read-modify-write operation)
    byte notThreadSafeAgain = threadSafe1++;



    public static void main(String... args) {
    }
}
