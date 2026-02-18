package com.example.projectmap;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    public static final int REQ_ADD = 100;
    public static final String PREFS = "NotePrefs";


    private RecyclerView recyclerView;
    private NotesAdapter adapter;
    private List<Note> noteList;
    private FloatingActionButton fab;
    private TextView emptyView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler);
        fab = findViewById(R.id.fabAdd);
        emptyView = findViewById(R.id.emptyView);


        noteList = loadNotes();
        updateEmptyView();


        adapter = new NotesAdapter(this, noteList, position -> {

            new androidx.appcompat.app.AlertDialog.Builder(MainActivity.this)
                    .setTitle("Delete Note")
                    .setMessage("Are you sure you want to delete this note?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        noteList.remove(position);
                        adapter.notifyItemRemoved(position);
                        saveNotes();
                        updateEmptyView();
                    })
                    .setNegativeButton("No", null)
                    .show();

        });



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        fab.setOnClickListener(v -> {
            startActivityForResult(new Intent(this, AddNoteActivity.class), REQ_ADD);
        });
    }


    private void updateEmptyView() {
        emptyView.setVisibility(noteList.isEmpty() ? View.VISIBLE : View.GONE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_ADD && resultCode == RESULT_OK && data != null) {
            Note n = (Note) data.getSerializableExtra("new_note");
            noteList.add(0, n); // add to top
            adapter.notifyItemInserted(0);
            saveNotes();
            updateEmptyView();
        }
    }


    private List<Note> loadNotes() {
        SharedPreferences sp = getSharedPreferences(PREFS, MODE_PRIVATE);
        String json = sp.getString("notes_json", "");
        if (json.isEmpty()) return new ArrayList<>();
        Gson g = new Gson();
        Type type = new TypeToken<List<Note>>(){}.getType();
        List<Note> list = g.fromJson(json, type);
        return list != null ? list : new ArrayList<>();
    }


    private void saveNotes() {
        SharedPreferences sp = getSharedPreferences(PREFS, MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        Gson g = new Gson();
        ed.putString("notes_json", g.toJson(noteList));
        ed.apply();
    }
}