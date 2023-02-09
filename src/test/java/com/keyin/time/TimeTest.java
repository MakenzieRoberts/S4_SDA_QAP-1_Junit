/**
 * @author Makenzie Roberts
 */

/*
    Comment Legend:
         ❗ --- Note to Professor
        🧠 --- Logic
*/

package com.keyin.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @see com.keyin.time.Time
 */
public class TimeTest {
    /*
        ❗ NOTES:

          I hope you don't mind that I use assertEquals() instead of assertTrue() in my test classes. I
          prefer to use assertEquals() because it's more explicit and I find it easier to read, whereas
          I only prefer to use assertTrue() when testing a boolean value.

          When I was researching unit testing, many programmers mentioned that it's usually bad practice to
          add print statements to unit tests, so I omitted them. Instead, I tried to make the test names and
          code as descriptive and readable as possible, so I hope that's okay.

          I believe you mentioned that we don't need to test setters and getters, so I didn't. I also didn't
          test my constructor, since it didn't contain any logic and is effectively just another basic setter.
    */

    /**
     * @see com.keyin.time.Time#Time(int, int, int)
     */
    @Test
    public void testConstructorInitialValues(){
        Time time = new Time(12, 3, 4);

        int actualHour = time.getHour();
        int actualMinute = time.getMinute();
        int actualSecond = time.getSecond();
        Assertions.assertEquals(12, actualHour);
        Assertions.assertEquals(3, actualMinute);
        Assertions.assertEquals(4, actualSecond);
    }

    /**
     * @see com.keyin.time.Time#toString()
     */
    @Test
    public void testToString(){
        Time time = new Time(12, 3, 4);

        String actualString = time.toString();
        Assertions.assertEquals("12:03:04", actualString);
    }

    /**
     * @see com.keyin.time.Time#nextSecond()
     */
    @Test
    public void testNextSecond(){
        Time time = new Time(12,3,4);

        time.nextSecond();

        int actualHour = time.getHour();
        int actualMinute = time.getMinute();
        int actualSecond = time.getSecond();
        Assertions.assertEquals(12, actualHour);
        Assertions.assertEquals(3, actualMinute);
        Assertions.assertEquals(5, actualSecond);
    }

    /**
     * @see com.keyin.time.Time#previousSecond()
     */
    @Test
    public void testPreviousSecond(){
        Time time = new Time(12, 3, 4);

        time.previousSecond();

        int actualHour = time.getHour();
        int actualMinute = time.getMinute();
        int actualSecond = time.getSecond();
        Assertions.assertEquals(12, actualHour);
        Assertions.assertEquals(3, actualMinute);
        Assertions.assertEquals(3, actualSecond);
    }

    /*
        ❗ NOTE: While I was writing the code for the nextSecond() and previousSecond() rollover feature, I
                found myself testing it often with print statements, so I thought it'd be neat to write tests
                for that as well.
    */
    /**
     * @see com.keyin.time.Time#nextSecond()
     */
    @Test
    public void testNextSecondRollover(){
        Time time = new Time(23, 59, 59);

        time.nextSecond();

        int actualHour = time.getHour();
        int actualMinute = time.getMinute();
        int actualSecond = time.getSecond();
        Assertions.assertEquals(0, actualHour);
        Assertions.assertEquals(0, actualMinute);
        Assertions.assertEquals(0, actualSecond);
    }

    /**
     * @see com.keyin.time.Time#previousSecond()
     */
    @Test
    public void testPreviousSecondRollover(){
        Time time = new Time(0, 0, 0);

        time.previousSecond();

        int actualHour = time.getHour();
        int actualMinute = time.getMinute();
        int actualSecond = time.getSecond();
        Assertions.assertEquals(23, actualHour);
        Assertions.assertEquals(59, actualMinute);
        Assertions.assertEquals(59, actualSecond);
    }
}

