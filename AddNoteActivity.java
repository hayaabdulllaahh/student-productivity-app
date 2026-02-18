package com.example.projectmap;



import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class AddNoteActivity extends AppCompatActivity {
    private EditText titleEt, contentEt;
    private Button addBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);


        titleEt = findViewById(R.id.titleEditText);
        contentEt = findViewById(R.id.contentEditText);
        addBtn = findViewById(R.id.addButton);


        addBtn.setOnClickListener(v -> {
            String t = titleEt.getText().toString().trim();
            String c = contentEt.getText().toString().trim();
            if (TextUtils.isEmpty(t)) { titleEt.setError("Enter title"); return; }
            if (TextUtils.isEmpty(c)) { contentEt.setError("Enter content"); return; }


            Note n = new Note(t, c, System.currentTimeMillis());
            getIntent().putExtra("new_note", n);
            setResult(Activity.RESULT_OK, getIntent());
            finish();
        });
    }
}