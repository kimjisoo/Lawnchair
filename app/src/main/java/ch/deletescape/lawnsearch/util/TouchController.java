package ch.deletescape.lawnsearch.util;

import android.view.MotionEvent;

public interface TouchController {

    boolean onControllerTouchEvent(MotionEvent ev);
    boolean onControllerInterceptTouchEvent(MotionEvent ev);
}
