package com.example.gridimage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private List<ItemBean> languageList;
    private Context context;

    public ImageAdapter(List<ItemBean> languageList, Context context) {
        this.languageList = languageList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return languageList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            //由于我们只需要将XML转化为View，并不涉及到具体的布局，所以第二个参数通常设置为null
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
            holder.title = convertView.findViewById(R.id.tv_title);
            holder.explain = convertView.findViewById(R.id.tv_explain);
            holder.path = convertView.findViewById(R.id.tv_path);
            holder.faraway = convertView.findViewById(R.id.tv_faraway);
            holder.iv_item = convertView.findViewById(R.id.iv_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(languageList.get(position).getTitle());
        holder.explain.setText(languageList.get(position).getExplain());
        holder.path.setText(languageList.get(position).getPath());
        holder.faraway.setText(languageList.get(position).getFaraway());
        holder.iv_item.setImageURI(Uri.fromFile(new File(languageList.get(position).getPath())));
        return convertView;
    }

    class ViewHolder {
        public TextView title;
        public TextView explain;
        public TextView path;
        public TextView faraway;
        public ImageView iv_item;
    }

}
