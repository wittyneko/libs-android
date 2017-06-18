package cn.wittyneko.autolayout.helper;

import cn.wittyneko.autolayout.helper.base.BaseModel;

/**
 * 参数信息
 * Created by Brady on 2016/5/2.
 */
public class AutoValue {
    public float value;
    public BaseModel model;
    public float measureValue;

    public AutoValue() {
    }

    public AutoValue(float value, BaseModel model) {
        this.value = value;
        this.model = model;
    }

    public float getMeasureValue() {
        measureValue = value * model.getBaseValue();
        return measureValue;
    }
}
