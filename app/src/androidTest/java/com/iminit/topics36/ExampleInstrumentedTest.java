package com.iminit.topics36;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.iminit.topics36", appContext.getPackageName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getNextRandom(colorCurrentIndex));
        }
    }
    static int colorCurrentIndex = 0;
    private static int getNextRandom(int oldColorIndex) {
        int index = (int) Math.ceil(Math.random() * 10);
        if(index == oldColorIndex){
            index = getNextRandom(index);
        }
        colorCurrentIndex = index;
        return index;
    }
}
