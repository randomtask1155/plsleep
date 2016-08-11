package io.pivotal.support;

/**
 * Created by danl on 8/10/16.
 */
public class plsleep {

    /*
        CREATE FUNCTION gotosleep(integer)
        RETURNS integer
        AS 'io.pivotal.support.plsleep.GoToSleep(java.lang.Integer)'
        LANGUAGE java;
     */
    static int GoToSleep(Integer dur) throws java.lang.InterruptedException {
        Thread.sleep(dur * 1000);
        return 1;
    }

    /*
        CREATE FUNCTION gospin(integer)
        RETURNS integer
        AS 'io.pivotal.support.plsleep.GoSpin(java.lang.Integer)'
        LANGUAGE java;
     */
    static int GoSpin(Integer dur) throws java.lang.InterruptedException {
        spin(dur * 1000);
        return 1;
    }

    private static void spin(int milliseconds) {
        long sleepTime = milliseconds*1000000L; // convert to nanoseconds
        long startTime = System.nanoTime();
        while ((System.nanoTime() - startTime) < sleepTime) {}
    }

    /*
        CREATE FUNCTION gotosleepfail(integer)
        RETURNS integer
        AS 'io.pivotal.support.plsleep.GoToSleepFail(java.lang.Integer)'
        LANGUAGE java;
     */
    static int GoToSleepFail(Integer dur) throws java.lang.InterruptedException {
        Thread.sleep(dur * 1000);

        // avoid compilation error by adding a test
        if (dur > 0) {
            throw new InterruptedException(new String("Generating plsleep failure"));
        }
        return 1;
    }
}


