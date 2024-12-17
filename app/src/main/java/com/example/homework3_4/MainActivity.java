package com.example.homework3_4;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements InputFragment.OnMessageSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.chatFragmentContainer, new ChatFragment())
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.inputFragmentContainer, new InputFragment())
                .commit();
    }

    @Override
    public void onMessageSend(String message) {
        ChatFragment chatFragment = (ChatFragment) getSupportFragmentManager().findFragmentById(R.id.chatFragmentContainer);
        if (chatFragment != null) {
            chatFragment.addUserMessage(message);
        }
    }
}
