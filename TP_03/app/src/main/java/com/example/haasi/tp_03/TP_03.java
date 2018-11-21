package com.example.haasi.tp_03;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class TP_03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_03);

        final SharedPreferences sharedPreferences = getSharedPreferences("pref_key", Context.MODE_PRIVATE);
        String result = sharedPreferences.getString("user_id", "");

        if(result.equals("")) {
            final EditText edittext = new EditText(getApplicationContext());
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Please Set a UserName");

            alert.setView(edittext);

            alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    String YouEditTextValue = edittext.getText().toString();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("user_id", YouEditTextValue);
                    editor.apply();
                }
            });

            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    // what ever you want to do with No option.
                }
            });

            alert.show();
        }

        String result2 = sharedPreferences.getString("user_id", "");
        Toast toast = Toast.makeText(getApplicationContext(), result2, Toast.LENGTH_SHORT);
        toast.show();



        ListView languagesListView = findViewById(R.id.chats_list);
        languagesListView.setAdapter(new ChatAdapter(this));

        languagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TP_03.this, ChatActivity.class);
                startActivity(intent);
            }
        });

    }
}



