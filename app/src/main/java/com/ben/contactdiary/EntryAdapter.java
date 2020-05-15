package com.ben.contactdiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class EntryAdapter extends BaseAdapter {

    List<String> entries;
    LayoutInflater mInflater;

    public EntryAdapter(Context c, List<String> entries) {
        this.entries = entries;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return entries.size();
    }

    @Override
    public Object getItem(int position) {
        return entries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.past_entries_listview_detail, null);
        TextView pastEntries = v.findViewById(R.id.entryName);

        String name = entries.get(position);

        pastEntries.setText(name);
        return v;
    }
}
