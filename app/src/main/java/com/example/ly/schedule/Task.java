package com.example.ly.schedule;

import java.io.Serializable;

/**
 * Created by ly on 2016/2/27.
 */
public class Task implements Serializable,Comparable{
    String name;
    int score=0;
    int type; //
    int importance;//

    public Task(String n,int t,int i){
        name=n;
        type=t;
        importance=i;
        score=type+importance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }


    @Override
    public int compareTo(Object another) {
        Task o=(Task)another;
        return score==o.score?0:score>o.score?-1:1;
    }
}
