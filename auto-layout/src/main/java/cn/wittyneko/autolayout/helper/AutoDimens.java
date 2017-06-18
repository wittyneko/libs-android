package cn.wittyneko.autolayout.helper;

import android.view.View;

import cn.wittyneko.autolayout.helper.base.BaseDisplay;
import cn.wittyneko.autolayout.helper.base.SampleModel;

/**
 * 单位换算
 * Created by Tutu on 2016/7/26.
 */
public class AutoDimens {

    //Auto | PercentScreen 获取方式
    public static float getUniversalDimens(AutoValue value, BaseDisplay display){
        return getUniversalDimens(value, display.getDisplayWidth(), display.getDisplayHeight());
    }

    public static float getUniversalDimens(AutoValue value, View view){
        return getUniversalDimens(value, view.getLayoutParams().width, view.getLayoutParams().height);
    }

    public static float getUniversalDimens(AutoValue value, int widthHint, int heightHint) {
        SampleModel model = (SampleModel) value.model;
        model.setBaseWidth(widthHint);
        model.setBaseHeight(heightHint);
        return value.value * model.getBaseValue();
    }

}
