package com.example.homework3_4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements InputFragment.OnMessageSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Добавляем фрагмент чата
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.chatFragmentContainer, new ChatFragment())
                .commit();

        // Добавляем фрагмент ввода
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
