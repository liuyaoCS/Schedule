package com.example.ly.schedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.TreeSet;

/**
 * Created by ly on 2016/2/27.
 */
public class TaskAdapter extends BaseAdapter {
    List<Task> mDataSet;
    Context mContext;
    public TaskAdapter(List<Task> dataSet,Context context){
        mDataSet=dataSet;
        mContext=context;
    }
    public void setDataSet(List<Task> dataSet){
        mDataSet=dataSet;
    }

    @Override
    public int getCount() {
        return mDataSet.size();
    }

    @Override
    public Task getItem(int position) {
        return mDataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView=LayoutInflater.from(mContext).inflate(R.layout.task_item,null);
            holder=new ViewHolder();
            holder.name= (TextView) convertView.findViewById(R.id.name);
            holder.score= (TextView) convertView.findViewById(R.id.score);
            holder.type= (TextView) convertView.findViewById(R.id.type);
            holder.importance= (TextView) convertView.findViewById(R.id.importance);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.name.setText(position+1+" "+getItem(position).getName());
        holder.score.setText("总分:"+getItem(position).getScore());
        holder.type.setText(Constants.type_score2name.get(getItem(position).getType()));
        holder.importance.setText(Constants.importance_score2name.get(getItem(position).getImportance()));
        return convertView;
    }
    class ViewHolder{
        TextView name;
        TextView score;
        TextView type;
        TextView importance;
    }

}
