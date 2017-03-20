package org.houxg.quokka;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class CommandReceiver extends BroadcastReceiver {

    private static final String COMMAND = "command";
    private static final String ACION = "quokka.action.command";
    private Publisher<String> publisher;

    @Override
    public void onReceive(Context context, Intent intent) {
        String command = intent.getStringExtra(COMMAND);
        publisher.notifySubscribers(command);
    }

    public CommandReceiver() {
        publisher = new Publisher<>();
    }

    public IntentFilter getIntentFiler() {
        IntentFilter filter = new IntentFilter(ACION);
        return filter;
    }

    Publisher<String> getPublisher() {
        return publisher;
    }
}
