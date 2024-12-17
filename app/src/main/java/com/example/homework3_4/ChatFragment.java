package com.example.homework3_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatFragment extends Fragment {
    private RecyclerView recyclerView;
    private ChatAdapter adapter;
    private ArrayList<Message> messages;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);

        messages = new ArrayList<>();
        adapter = new ChatAdapter(messages);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    public void addUserMessage(String message) {
        if (message != null && !message.isEmpty()) {
            messages.add(new Message(message, true)); // Добавляем сообщение от пользователя
            messages.add(new Message("Автоответ: " + message, false)); // Добавляем автоответ
            adapter.notifyItemRangeInserted(messages.size() - 2, 2); // Сообщаем адаптеру о добавлении
            recyclerView.scrollToPosition(messages.size() - 1); // Прокручиваем к последнему сообщению
        }
    }
}