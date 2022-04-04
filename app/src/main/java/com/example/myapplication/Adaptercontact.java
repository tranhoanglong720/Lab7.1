package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Adaptercontact extends BaseAdapter {
    public Adaptercontact(Context context, int layout, List<Contact> listcontact) {
        this.context = context;
        Layout = layout;
        this.listcontact = listcontact;
    }

    private Context context;
    private int Layout;
    private List<Contact> listcontact;
    @Override
    public int getCount() {
        return listcontact.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(listcontact.size()!=0 || listcontact.isEmpty())
        {
           convertView = LayoutInflater.from(parent.getContext()).inflate(Layout,parent,false);
        }
        TextView txtten=(TextView) convertView.findViewById(R.id.txtten);

        final Contact c=listcontact.get(position);
        txtten.setText(c._name);

        return convertView;
    }
}
