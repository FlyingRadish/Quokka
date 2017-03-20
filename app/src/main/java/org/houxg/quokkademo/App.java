package org.houxg.quokkademo;


import android.app.Application;

import org.houxg.quokka.Quokka;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Quokka.init(this);
    }
}
