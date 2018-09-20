package com.example.black.lunartest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private String root="";
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        root = Environment.getExternalStorageDirectory().getPath();
        lv = findViewById(R.id.list);
        getItems(root);
    }

    public void getItems(String path){
        File f = new File(path);
        checkDirectory(f);
        File[] files = f.listFiles();
        ArrayAdapter<File> adapter = new ArrayAdapter<File>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, files);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dir = parent.getItemAtPosition(position).toString();
                getItems(dir);
            }
        });
    }

    public void checkDirectory(File f){
        File[] files = f.listFiles(new ImageFileFilter());
        for (File file : files) {
            if (file.isDirectory() && file.listFiles(new ImageFileFilter()).length > 0) {
                Log.d("FILEEEEE",file.toString());
            } else {
                Log.d("FILOOOOO",file.toString());
            }
        }
    }

}