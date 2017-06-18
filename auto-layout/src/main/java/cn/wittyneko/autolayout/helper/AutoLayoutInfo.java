package cn.wittyneko.autolayout.helper;

import android.view.ViewGroup;

/**
 * 布局信息
 * Created by Brady on 2016/5/2.
 */
public class AutoLayoutInfo {

    public float widthDesign;
    public float heightDesign;
    public boolean isWidth;
    public boolean usePadding;

    public AutoValue width;
    public AutoValue height;

    public AutoValue leftMargin;
    public AutoValue topMargin;
    public AutoValue rightMargin;
    public AutoValue bottomMargin;
    public AutoValue startMargin;
    public AutoValue endMargin;

    public AutoValue maxWidth;
    public AutoValue maxHeight;
    public AutoValue minWidth;
    public AutoValue minHeight;

    public AutoValue paddingLeft;
    public AutoValue paddingRight;
    public AutoValue paddingTop;
    public AutoValue paddingBottom;

    public AutoValue textSize;

    /* package */
    ViewGroup.MarginLayoutParams mPreservedParams;


    public AutoLayoutInfo()
    {
        clear();
        mPreservedParams = new ViewGroup.MarginLayoutParams(0, 0);
    }

    public void clear(){
        widthDesign = 0;
        heightDesign = 0;
        isWidth = false;
        usePadding = false;

        width = null;
        height = null;

        leftMargin = null;
        topMargin = null;
        rightMargin = null;
        bottomMargin = null;
        startMargin = null;
        endMargin = null;

        maxWidth = null;
        maxHeight = null;
        minWidth = null;
        minHeight = null;

        paddingLeft = null;
        paddingRight = null;
        paddingTop = null;
        paddingBottom = null;

        textSize = null;
    }
}
