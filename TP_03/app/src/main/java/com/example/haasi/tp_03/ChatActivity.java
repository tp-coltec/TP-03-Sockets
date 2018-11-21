package com.example.haasi.tp_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Button button = findViewById(R.id.button_chatbox_send);

        ListView messagesListView = findViewById(R.id.reyclerview_message_list);
        messagesListView.setAdapter(new MessageAdapter(this));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText texto = findViewById(R.id.edittext_chatbox);
                Toast toast = Toast.makeText(getApplicationContext(), texto.getText(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
