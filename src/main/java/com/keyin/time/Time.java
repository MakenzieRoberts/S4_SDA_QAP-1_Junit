/**
 * @author Makenzie Roberts
 */

/*
    Comment Legend:
         ❗ --- Note to Professor
        🧠 --- Logic
*/

package com.keyin.time;

public class Time {
    /* Instance Variables */
    private int hour;   /* 0 - 23 */
    private int minute; /* 0 - 59 */
    private int second; /* 0 - 59 */

    /* Constructor (Parameterized) */
    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /* Getters */
    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minute;
    }

    /* Setters */
    public int getSecond(){
        return second;
    }

    public void setHour(int hour){
        this.hour = hour;
    }

    public void setMinute(int minute){
        this.minute = minute;
    }

    public void setSecond(int second){
        this.second = second;
    }

    public void setTime(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /* Methods */

    public Time nextSecond(){
        /*
            I read that the modulo operator is often used to roll over/wrap around a value, so I decided to
            try using it here 😊
        */
        this.second = (this.second + 1) % 60;
        if (this.second == 0) {
            this.minute = (this.minute + 1) % 60;
            if (this.minute == 0) {
                this.hour = (this.hour + 1) % 24;
            }
        }
        return this;
    }

    public Time previousSecond(){
        /*
            🧠 Logic:

            When adding 59 to any valid this.second value (other than 0) and then finding the remainder of
            dividing by 60, the result is the original value minus 1 (aka. the previous second).
                Equation: (x + 59) % 60 = x - 1

            If the this.second value is 0, then the result is 59 (aka. rolling over to the previous second).
                Equation: (0 + 59) % 60 = 59
        */
        this.second = (this.second + 59) % 60;
        if (this.second == 59) {
            this.minute = (this.minute + 59) % 60;
            if (this.minute == 59) {
                this.hour = (this.hour + 23) % 24;
            }
        }
        return this;
    }

    @Override
    public String toString(){
        String hourOutput = String.format("%02d", hour);
        String minuteOutput = String.format("%02d", minute);
        String secondOutput = String.format("%02d", second);

        return hourOutput + ":" + minuteOutput + ":" + secondOutput;
    }
}

