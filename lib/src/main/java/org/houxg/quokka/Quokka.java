package org.houxg.quokka;


import android.content.Context;

public class Quokka {

    private CommandReceiver receiver;
    private static class Singleton {
        private static Quokka INSTANCE = new Quokka();
    }

    private Quokka() {
        receiver = new CommandReceiver();
    }

    public static Quokka init(Context context) {
        Quokka instance = Singleton.INSTANCE;
        instance.initial(context);
        return instance;
    }

    private void initial(Context context) {
        context.registerReceiver(receiver, receiver.getIntentFiler());
    }

    public void subscribeCommand(Subscriber<String> subscriber) {
        Singleton.INSTANCE.receiver.getPublisher().addSubscriber(subscriber);
    }

}
