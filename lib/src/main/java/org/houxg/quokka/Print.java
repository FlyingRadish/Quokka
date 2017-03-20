package org.houxg.quokka;


import android.view.MotionEvent;

public class Print {
    public static String motionEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                return "up";
            case MotionEvent.ACTION_DOWN:
                return "down";
            case MotionEvent.ACTION_CANCEL:
                return "cancel";
            case MotionEvent.ACTION_MOVE:
                return "move";
            default:
                return String.valueOf(event.getAction());
        }
    }
}
