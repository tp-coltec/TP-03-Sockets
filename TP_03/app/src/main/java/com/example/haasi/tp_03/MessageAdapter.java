package com.example.haasi.tp_03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageAdapter extends BaseAdapter {

    // lista que conterá a linguagens a serem exibidas
    static ArrayList<Message> messages;
    private Context context;

    public MessageAdapter(Context context) {
        this.context = context;
        messages = new ArrayList<>();
        this.messages.add(new Message("Ola", false));
        this.messages.add(new Message("Oi", true));
    }

    @Override
    public int getCount() {
        return this.messages.size();
    }

    @Override
    public Object getItem(int i) {
        return this.messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Message message = this.messages.get(i);

        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_messages, viewGroup, false);

        TextView lblMessage = newView.findViewById(R.id.lbl_messages);

        if (message.isControl_mine()) {
            lblMessage.setText("You: " + message.getMessage());
        } else {
            lblMessage.setText("User: " +  message.getMessage());
        }

        return newView;
    }

}
