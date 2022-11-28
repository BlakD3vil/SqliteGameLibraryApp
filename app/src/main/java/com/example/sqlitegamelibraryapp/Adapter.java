package com.example.sqlitegamelibraryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private ArrayList game_id, game_name, game_developer, game_genre;

    Adapter(Context context, ArrayList game_id, ArrayList game_name, ArrayList game_developer, ArrayList game_genre){
        this.context = context;
        this.game_id = game_id;
        this.game_name = game_name;
        this.game_developer = game_developer;
        this.game_genre = game_genre;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.game_id_text.setText(String.valueOf(game_id.get(position)));
        holder.game_name_text.setText(String.valueOf(game_name.get(position)));
        holder.game_developer_text.setText(String.valueOf(game_developer.get(position)));
        holder.game_genre_text.setText(String.valueOf(game_genre.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return game_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView game_id_text, game_name_text, game_developer_text, game_genre_text;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            game_id_text = itemView.findViewById(R.id.game_id_text);
            game_name_text = itemView.findViewById(R.id.game_name_text);
            game_developer_text = itemView.findViewById(R.id.game_developer_text);
            game_genre_text = itemView.findViewById(R.id.game_genre_text);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
