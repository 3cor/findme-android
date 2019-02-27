package com.example.boon.findme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import helpers.MqttHelper;

public class MainActivity extends AppCompatActivity {

    Button btnSend;
    EditText txtTitle;
    EditText txtMessage;

    MqttHelper mqttHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = (Button) findViewById(R.id.btnSend);
        txtTitle = (EditText) findViewById(R.id.txtTitle);
        txtMessage = (EditText) findViewById(R.id.txtMessage);

        mqttHelper = new MqttHelper(getApplicationContext());
        mqttHelper.connect();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subscribe_topic = "msg/response/001";
                String publish_topic = "msg/request/001";
                String message = txtTitle.getText() + "####" + txtMessage.getText();
                //mqttHelper.subscribeToTopic(subscribe_topic);
                mqttHelper.publishToTopic(publish_topic, message);
            }
        });


    }
}
