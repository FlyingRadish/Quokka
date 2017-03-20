package org.houxg.quokkademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.houxg.quokka.Publisher;
import org.houxg.quokka.Quokka;
import org.houxg.quokka.Subscriber;

public class MainActivity extends AppCompatActivity {

    TextView messageTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageTv = (TextView) findViewById(R.id.tvMessage);
        Quokka.subscribeCommand(new Subscriber<String>() {
            @Override
            public void onUpdate(Publisher<String> publisher, String data) {
                messageTv.setText("command:" + data);
            }
        });
    }
}
