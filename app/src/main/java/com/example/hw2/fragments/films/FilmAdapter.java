package com.example.hw2.fragments.films;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw2.data.models.Film;

import java.util.List;

import kg.geektech.android3.lesson2.R;

class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmViewHolder> {

    private List<Film> filmList;
    private FilmCallback callback;


    public FilmsAdapter(List<Film> list, FilmCallback callback){
        this.filmList = list;
        this.callback = callback;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.bind(filmList.get(position));
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public Film getItem(int pos){
        return filmList.get(pos);
    }

    class FilmViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_rc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.clicked(getAdapterPosition());
                }
            });
        }

        public void bind(Film film) {
            title.setText(film.getTitle());
        }
    }

    public interface FilmCallback{
        void clicked(int pos);
    }
}
