package com.example.listcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;


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
        final ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>() ;


        // 커스텀 다이얼로그에서 입력한 메시지를 출력할 TextView 를 준비한다.
        final TextView main_label = (TextView) findViewById(R.id.main_label);
        final Switch switch1 = findViewById(R.id.switch1);

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

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                ListViewItem item =(ListViewItem)adapter.getItem(0);
                Toast.makeText(getApplicationContext(),item.name+"삭제되었습니다.",Toast.LENGTH_LONG).show();
                adapter.removeitem(0); //0번째가 삭제되게 임의로 설정
                adapter.notifyDataSetChanged();
                return true;
            }
        });


        for(int i=0;i<adapter.getCount();i++){
            ListViewItem item=(ListViewItem)adapter.getItem(i);

            if (item.getCheck()){
                listview.setBackgroundColor(Color.parseColor("#ffffff"));
                adapter.notifyDataSetChanged();
            }
            else {
                listview.setBackgroundColor(Color.parseColor("#B7DBF4"));
                adapter.notifyDataSetChanged();
            }

        }





    }
}

