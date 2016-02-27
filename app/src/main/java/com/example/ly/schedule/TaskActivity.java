package com.example.ly.schedule;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class TaskActivity extends Activity {
    EditText edit_name;
    RadioGroup group_type,group_importance;
    RadioButton type_work,type_study,type_interest;
    RadioButton importance_5,importance_3,importance_1;
    Button submit;

    String taskName;
    int  taskType,taskImportance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        initView();
    }

    private void initView() {
        edit_name= (EditText) findViewById(R.id.input_name);
        group_type= (RadioGroup) findViewById(R.id.radio_group_type);
        group_importance= (RadioGroup) findViewById(R.id.radio_group_importance);
        submit= (Button) findViewById(R.id.submit);

        type_work= (RadioButton) findViewById(R.id.type_work);
        type_study=(RadioButton) findViewById(R.id.type_study);
        type_interest=(RadioButton) findViewById(R.id.type_interest);
        type_work.setChecked(true);
        taskType=6;

        importance_5=(RadioButton) findViewById(R.id.importance_5);
        importance_3=(RadioButton) findViewById(R.id.importance_3);
        importance_1=(RadioButton) findViewById(R.id.importance_1);
        importance_5.setChecked(true);
        taskImportance=5;

        group_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == type_study.getId()) {
                    taskType = Constants.type_name2score.get(type_study.getText().toString());
                } else if (checkedId == type_interest.getId()) {
                    taskType = Constants.type_name2score.get(type_interest.getText().toString());
                } else {
                    taskType = Constants.type_name2score.get(type_work.getText().toString());
                }
            }
        });
        group_importance.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == importance_3.getId()) {
                    taskImportance = Constants.importance_name2score.get(importance_3.getText().toString());
                } else if (checkedId == importance_1.getId()) {
                    taskImportance = Constants.importance_name2score.get(importance_1.getText().toString());
                } else {
                    taskImportance = Constants.importance_name2score.get(importance_5.getText().toString());
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskName = edit_name.getText().toString();
                if (TextUtils.isEmpty(taskName)) {
                    Toast.makeText(TaskActivity.this, "请输入项目名称", Toast.LENGTH_SHORT).show();
                    return;
                }
                Task task=new Task(taskName,taskType,taskImportance);
                Intent result=new Intent();
                result.putExtra("task",task);
                setResult(Constants.ADD_TASK_RESULT, result);
                finish();
            }
        });
    }


}
