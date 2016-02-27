package com.example.ly.schedule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends Activity {

    Button add;
    ListView list;
    TaskAdapter adapter;
    List<Task> dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add= (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addTask=new Intent(MainActivity.this,TaskActivity.class);
                startActivityForResult(addTask,Constants.ADD_TASK_REQUEST);
            }
        });
        list= (ListView) findViewById(R.id.list);
        dataSet=new ArrayList<Task>();
        adapter=new TaskAdapter(dataSet,MainActivity.this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==Constants.ADD_TASK_REQUEST && resultCode==Constants.ADD_TASK_RESULT){
            if(data!=null){
                Task task= (Task) data.getSerializableExtra("task");
                dataSet.add(task);
                Collections.sort(dataSet);
                //adapter.setDataSet(dataSet);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
