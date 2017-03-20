package org.houxg.quokka;


public interface Subscriber<T> {
    void onUpdate(Publisher<T> publisher, T data);
}
