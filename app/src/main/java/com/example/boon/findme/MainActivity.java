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
                String message = txtTitle.getText() + "####" + txtMessage.getText();
                mqttHelper.publishToTopic("msg", message);
                Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_LONG).show();
            }
        });


    }
}
