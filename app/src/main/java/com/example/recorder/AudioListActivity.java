package com.example.recorder;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AudioListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_list);

        ListView listView = findViewById(R.id.list_audio);

        File audioDir = new File(Environment.getExternalStorageDirectory(), "haha");
        List<String> files = new ArrayList<>();
        if (audioDir.exists() && audioDir.isDirectory()) {
            File[] list = audioDir.listFiles();
            if (list != null) {
                for (File f : list) {
                    files.add(f.getName());
                }
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, files);
        listView.setAdapter(adapter);
    }
}
