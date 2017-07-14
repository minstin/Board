package com.example.home.board;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by home on 2017-07-07.
 */

public class ReadActivity extends AppCompatActivity{

    public static final String TAG = "Test_Alert_Dialog";

    TextView title, content;
    Button backBtn, delete;
    FirebaseDatabase database;
    DatabaseReference myRef;
    Vibrator mVibe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("list");
        mVibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        title = (TextView) findViewById(R.id.textView4);
        content = (TextView) findViewById(R.id.text_Memo);
        backBtn = (Button) findViewById(R.id.backBtn);
        delete = (Button) findViewById(R.id.delete);

        Intent intent = getIntent();

        String a = intent.getStringExtra("title");
        String b = intent.getStringExtra("content");
        final String c = intent.getStringExtra("date");
        final String d = intent.getStringExtra("pass");


        title.setText(a);
        content.setText(b);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(ReadActivity.this);
                final EditText et = new EditText(ReadActivity.this);
                ad.setView(et);
                et.setInputType(InputType.TYPE_CLASS_NUMBER);

                ad.setTitle("게시글 삭제");       // 제목 설정
                ad.setMessage("패스워드를 입력하세요.");   // 내용 설정

                // 확인 버튼 설정
                ad.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String value = et.getText().toString();
                        if(value.equals(d)){
                            myRef.child(c).removeValue();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_SINGLE_TOP|intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();}
                        else {
                            Toast.makeText(getApplication(), "잘못된 입력입니다." , Toast.LENGTH_SHORT).show();
                            mVibe.vibrate(800);
                        }
                    }
                });

                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();     //닫기
                    }
                });

                ad.show();
            }
        });
    }
}
