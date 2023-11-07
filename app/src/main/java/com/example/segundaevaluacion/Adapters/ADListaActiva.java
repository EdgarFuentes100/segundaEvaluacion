package com.example.segundaevaluacion.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.segundaevaluacion.R;
import com.example.segundaevaluacion.ViewHolder.viewHolderActiva;
import com.example.segundaevaluacion.clases.Compras;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class ADListaActiva extends RecyclerView.Adapter<viewHolderActiva> {
    private OnItemClickListener onItemClickListener;
    private List<Compras> datos;

    public ADListaActiva(List<Compras> querySnapshot, OnItemClickListener itemClickListener) {
        this.datos = querySnapshot;
        this.onItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public viewHolderActiva onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        return new viewHolderActiva(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderActiva holder, int position) {
        final Compras compra = datos.get(position);
        holder.getTvTitulo().setText(datos.get(position).getTitulo() + "");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(compra);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Compras compra);
    }
}

