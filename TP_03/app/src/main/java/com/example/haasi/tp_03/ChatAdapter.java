package com.example.haasi.tp_03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {

    // lista que conterá a linguagens a serem exibidas
    static ArrayList<Chat> chats;
    private Context context;

    public ChatAdapter(Context context) {
        this.context = context;
        chats = new ArrayList<>();
        this.chats.add(new Chat("Geral", "5000", R.mipmap.ic_general_fore));
        this.chats.add(new Chat("Eventos", "5001", R.mipmap.ic_events_fore));
        this.chats.add(new Chat("Oportunidades", "5002", R.mipmap.ic_oport_fore));
        this.chats.add(new Chat("OffTopics", "5003", R.mipmap.ic_all_fore));
    }
    @Override
    public int getCount() {
        return this.chats.size();
    }
    @Override
    public Object getItem(int i) {
        return this.chats.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Chat chat = this.chats.get(i);

        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_chat, viewGroup, false);

        TextView lblName = newView.findViewById(R.id.lbl_chat_name);
        TextView lblAuthor = newView.findViewById(R.id.lbl_port_number);
        ImageView lblFoto = newView.findViewById(R.id.lbl_image);

        lblName.setText(chat.getNome());
        lblAuthor.setText(chat.getPorta());
        lblFoto.setBackgroundResource(chat.getFoto());

        return newView;
    }

}
