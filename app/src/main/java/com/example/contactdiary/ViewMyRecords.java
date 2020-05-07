package com.example.contactdiary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewMyRecords extends AppCompatActivity {

    DatabaseHelper myDb;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_records);

        // get all the data from the db
        myDb = new DatabaseHelper(this);
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            // show some message that says there's no data
            showMessage("Error", "nothing found");
            return;
        }

        // take the data from the database and place it into lists
        List<String> titles = new ArrayList<>();
        List<String> entryBodies = new ArrayList<>();
        while (res.moveToNext()) {
            titles.add(res.getString(1));
            entryBodies.add(res.getString(2));
        }

//        // set up the listview
        listView = findViewById(R.id.pastEntriesList);
        EntryAdapter entryAdapter = new EntryAdapter(this, titles);
        listView.setAdapter(entryAdapter);

        // make the listview clickable
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showEntryDetail = new Intent(getApplicationContext(), ViewRecord.class);
                showEntryDetail.putExtra("com.example.concussiondiary.ENTRY_BODY", entryBodies.get(position));
                showEntryDetail.putExtra("com.example.concussiondiary.ENTRY_TITLE", titles.get(position));
                startActivity(showEntryDetail);
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
