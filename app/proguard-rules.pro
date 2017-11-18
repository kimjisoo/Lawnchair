-keep,allowshrinking,allowoptimization class ch.deletescape.lawnsearch.** {
  *;
}

-keep class ch.deletescape.lawnsearch.BaseRecyclerViewFastScrollBar {
  public void setThumbWidth(int);
  public int getThumbWidth();
  public void setTrackWidth(int);
  public int getTrackWidth();
}

-keep class ch.deletescape.lawnsearch.BaseRecyclerViewFastScrollPopup {
  public void setAlpha(float);
  public float getAlpha();
}

-keep class ch.deletescape.lawnsearch.ButtonDropTarget {
  public int getTextColor();
}

-keep class ch.deletescape.lawnsearch.CellLayout {
  public float getBackgroundAlpha();
  public void setBackgroundAlpha(float);
}

-keep class ch.deletescape.lawnsearch.CellLayout$LayoutParams {
  public void setWidth(int);
  public int getWidth();
  public void setHeight(int);
  public int getHeight();
  public void setX(int);
  public int getX();
  public void setY(int);
  public int getY();
}

-keep class ch.deletescape.lawnsearch.dragndrop.DragLayer$LayoutParams {
  public void setWidth(int);
  public int getWidth();
  public void setHeight(int);
  public int getHeight();
  public void setX(int);
  public int getX();
  public void setY(int);
  public int getY();
}

-keep class ch.deletescape.lawnsearch.FastBitmapDrawable {
  public void setDesaturation(float);
  public float getDesaturation();
  public void setBrightness(float);
  public float getBrightness();
}

-keep class ch.deletescape.lawnsearch.PreloadIconDrawable {
  public float getAnimationProgress();
  public void setAnimationProgress(float);
}

-keep class ch.deletescape.lawnsearch.pageindicators.CaretDrawable {
  public float getCaretProgress();
  public void setCaretProgress(float);
}

-keep class ch.deletescape.lawnsearch.Workspace {
  public float getBackgroundAlpha();
  public void setBackgroundAlpha(float);
}

-keep class com.google.android.libraries.launcherclient.* {
  *;
}

-dontwarn javax.**
-dontwarn org.codehaus.mojo.animal_sniffer.**

-keep class ch.deletescape.lawnsearch.DeferredHandler {
 *;
}

# Proguard will strip new callbacks in LauncherApps.Callback from
# WrappedCallback if compiled against an older SDK. Don't let this happen.
-keep class ch.deletescape.lawnsearch.compat.** {
  *;
}
