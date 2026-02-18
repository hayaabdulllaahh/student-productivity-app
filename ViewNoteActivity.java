package com.example.projectmap;


import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;



public class ViewNoteActivity extends AppCompatActivity {
    private TextView titleTv, contentTv, dateTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);


        titleTv = findViewById(R.id.viewTitle);
        contentTv = findViewById(R.id.viewContent);
        dateTv = findViewById(R.id.viewDate);


        int index = getIntent().getIntExtra("note_index", -1);
        if (index == -1) { finish(); return; }


        List<Note> list = loadNotes();
        if (index < 0 || index >= list.size()) { finish(); return; }


        Note n = list.get(index);
        titleTv.setText(n.getTitle());
        contentTv.setText(n.getContent());
        String formatted = new SimpleDateFormat("d MMM yyyy - hh:mm a", Locale.getDefault()).format(new Date(n.getTimestamp()));
        dateTv.setText(formatted);
    }


    private List<Note> loadNotes() {
        SharedPreferences sp = getSharedPreferences(MainActivity.PREFS, MODE_PRIVATE);
        String json = sp.getString("notes_json", "");
        if (json.isEmpty()) return new java.util.ArrayList<>();
        Gson g = new Gson();
        Type type = new TypeToken<List<Note>>(){}.getType();
        List<Note> list = g.fromJson(json, type);
        return list != null ? list : new java.util.ArrayList<>();
    }
}