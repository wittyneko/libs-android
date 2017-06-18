package cn.wittyneko.base;

import android.app.Application;
import android.content.Context;

import java.lang.reflect.Method;

import cn.wittyneko.utils.LogUtil;


/**
 * 初始化
 * Created by wittyneko .
 * @since 2017/4/18
 */
public final class Base {
    
    private static boolean debug;
    private static Application application;

    private Base() {
    }

    public static void init(Application application) {
        if (Base.application == null) {
            Base.application = application;
        }
    }

    public static boolean isDebug() {
        return debug;
    }

    public static Application getApplication() {
        if (application == null) {
            try {
                // 在IDE进行布局预览时使用
                Class<?> renderActionClass = Class.forName("com.android.layoutlib.bridge.impl.RenderAction");
                Method method = renderActionClass.getDeclaredMethod("getCurrentContext");
                Context context = (Context) method.invoke(null);
                application = new MockApplication(context);
            } catch (Throwable ignored) {
                throw new RuntimeException("please invoke Base.init(application) on Application#onCreate()"
                        + " and register your Application in manifest.");
            }
        }
        return application;
    }

    public static class Builder {

        Base mBase;

        private Builder() {
            mBase = new Base();
        }

        public Builder setDebug(boolean debug) {
            mBase.debug = debug;
            LogUtil.setDebug(debug);
            return this;
        }

        public Base builder() {
            return mBase;
        }
    }

    private static class MockApplication extends Application {
        public MockApplication(Context baseContext) {
            this.attachBaseContext(baseContext);
        }
    }
}
