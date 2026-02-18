package com.example.projectmap;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {
    private List<Note> notes;
    private Context ctx;
    private OnDeleteListener deleteListener;


    public interface OnDeleteListener { void onDelete(int position); }


    public NotesAdapter(Context ctx, List<Note> notes, OnDeleteListener l) {
        this.ctx = ctx;
        this.notes = notes;
        this.deleteListener = l;
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.title.setText(note.getTitle());
        holder.content.setText(note.getContent());
        String date = new SimpleDateFormat("d MMM, yyyy", Locale.getDefault()).format(new Date(note.getTimestamp()));
        holder.date.setText(date);


        holder.card.setOnClickListener(v -> {
            Intent i = new Intent(ctx, ViewNoteActivity.class);
            i.putExtra("note_index", position);
            ctx.startActivity(i);
        });


        holder.deleteBtn.setOnClickListener(v -> {
            if (deleteListener != null) deleteListener.onDelete(position);
        });
    }



    @Override
    public int getItemCount() { return notes.size(); }


    static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView title, content, date;
        ImageButton deleteBtn; CardView card;
        NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.itemTitle);
            content = itemView.findViewById(R.id.itemContent);
            date = itemView.findViewById(R.id.itemDate);
            deleteBtn = itemView.findViewById(R.id.itemDelete);
            card = itemView.findViewById(R.id.itemCard);
        }
    }
}