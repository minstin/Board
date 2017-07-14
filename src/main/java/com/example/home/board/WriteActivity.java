package com.example.home.board;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by home on 2017-07-07.
 */


public class WriteActivity extends AppCompatActivity {
    EditText et1, et2, pass;
    Button okbtn;

    FirebaseDatabase database;
    DatabaseReference myRef2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        et1 = (EditText) findViewById(R.id.edit_Title);
        et2 = (EditText) findViewById(R.id.edit_Memo);
        pass = (EditText) findViewById(R.id.password);
        okbtn = (Button) findViewById(R.id.button2);

        database = FirebaseDatabase.getInstance();
        myRef2 = database.getReference("list");

        //버튼 이벤트
        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = et1.getText().toString();
                String content = et2.getText().toString();
                String password = pass.getText().toString();

                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = df.format(c.getTime());

                Chat data = new Chat(title, content, formattedDate, password);

                myRef2.child(formattedDate).setValue(data);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_SINGLE_TOP|intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
