package com.example.listcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
//import com.example.listcustom.ListViewItem;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    ImageButton btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listview;

        btn1 = findViewById(R.id.btn1);
        final ListViewAdapter adapter;
        adapter = new ListViewAdapter();

        // 커스텀 다이얼로그에서 입력한 메시지를 출력할 TextView 를 준비한다.
        final TextView main_label = (TextView) findViewById(R.id.main_label);


        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                CustomDialog customDialog=new CustomDialog(MainActivity.this);
               customDialog.setAdapter(adapter);
                customDialog.callFunction(main_label);
           }

       });



    }
}

