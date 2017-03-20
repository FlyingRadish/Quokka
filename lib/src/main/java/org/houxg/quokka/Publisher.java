package org.houxg.quokka;


import java.util.ArrayList;

public class Publisher<T> {
    private ArrayList<Subscriber<T>> subscribers;
    private boolean changed = false;

    public Publisher() {
        subscribers = new ArrayList<>();
    }

    public synchronized void addSubscriber(Subscriber<T> subscriber) {
        if (subscriber == null)
            throw new NullPointerException();
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    public synchronized void deleteObserver(Subscriber<T> o) {
        subscribers.remove(o);
    }


    public void notifySubscribers() {
        notifySubscribers(null);
    }


    public void notifySubscribers(T data) {
        /*
         * a temporary array buffer, used as a snapshot of the state of
         * current Observers.
         */
        Subscriber[] arrLocal;

        synchronized (this) {
            /* We don't want the Observer doing callbacks into
             * arbitrary Observables while holding its own Monitor.
             * The code where we extract each Observable from
             * the ArrayList and store the state of the Observer
             * needs synchronization, but notifying subscribers
             * does not (should not).  The worst result of any
             * potential race-condition here is that:
             *
             * 1) a newly-added Observer will miss a
             *   notification in progress
             * 2) a recently unregistered Observer will be
             *   wrongly notified when it doesn't care
             */
            if (!hasChanged())
                return;

            arrLocal = subscribers.toArray(new Subscriber[subscribers.size()]);
            clearChanged();
        }

        for (int i = arrLocal.length-1; i>=0; i--)
            arrLocal[i].onUpdate(this, data);
    }


    public synchronized void deleteObservers() {
        subscribers.clear();
    }


    protected synchronized void setChanged() {
        changed = true;
    }


    protected synchronized void clearChanged() {
        changed = false;
    }


    public synchronized boolean hasChanged() {
        return changed;
    }


    public synchronized int countObservers() {
        return subscribers.size();
    }
}
