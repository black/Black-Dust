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

       // getAllImageFolders(files);
        getItems(root);
    }

    public void getItems(String path){
        File f = new File(path);
        File[] files = f.listFiles();
        ArrayAdapter<File> adapter = new ArrayAdapter<File>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, files);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getItems(parent.getItemAtPosition(position).toString());
            }
        });
    }

    public void getAllImageFolders(File[] fileList){
        for (int i = 0; i < fileList.length; i++) {
            if(fileList[i].isDirectory()){
                //Then go inside it to search for specific file
                File subList[] = fileList[i].listFiles();
                Log.d("ROOT", Arrays.toString(subList));
                //search for jpg..
            }
        }
    }

}