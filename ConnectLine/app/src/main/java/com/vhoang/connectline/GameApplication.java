package com.vhoang.connectline;

import android.app.Application;
import android.content.Context;

import com.vhoang.D2GameComponent;
import com.vhoang.DaggerD2GameComponent;

public class GameApplication extends Application {

    private D2GameComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerD2GameComponent.create();
    }

    public static D2GameComponent component(Context context) {
        return ((GameApplication) context.getApplicationContext()).component;
    }
}
