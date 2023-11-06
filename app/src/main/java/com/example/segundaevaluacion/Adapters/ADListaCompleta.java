package com.example.segundaevaluacion.Adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.segundaevaluacion.R;
import com.example.segundaevaluacion.ViewHolder.viewHolderCompleta;

public class ADListaCompleta extends RecyclerView.Adapter<viewHolderCompleta> {
    @NonNull
    @Override
    public viewHolderCompleta onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent,false);
        return new viewHolderCompleta(view);
    }
    @Override
    public void onBindViewHolder(@NonNull viewHolderCompleta holder, int position) {
    }

    @Override
    public int getItemCount() {return 0;}
}