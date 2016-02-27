package com.example.ly.schedule;

import java.util.HashMap;

/**
 * Created by ly on 2016/2/27.
 */
public class Constants {
    public static final int ADD_TASK_REQUEST = 100;
    public static final int ADD_TASK_RESULT = 101;
    public static HashMap<String ,Integer> type_name2score=new HashMap<String ,Integer>(){
        {
            put("工作",6);
            put("学习",4);
            put("兴趣",2);
        }
    };
    public static HashMap<Integer,String > type_score2name=new HashMap<Integer,String>(){
        {
            put(6,"工作");
            put(4,"学习");
            put(2,"兴趣");
        }
    };
    public static HashMap<String ,Integer> importance_name2score=new HashMap<String ,Integer>(){
        {
            put("重要",5);
            put("一般",3);
            put("不重要",1);
        }
    };
    public static HashMap<Integer,String > importance_score2name=new HashMap<Integer,String>(){
        {
            put(5,"重要");
            put(3,"一般");
            put(1,"不重要");
        }
    };

}
