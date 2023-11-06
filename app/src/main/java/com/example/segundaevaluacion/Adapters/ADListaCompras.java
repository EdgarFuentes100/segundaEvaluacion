package com.example.segundaevaluacion.Adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.segundaevaluacion.R;
import com.example.segundaevaluacion.ViewHolder.viewHolderCompras;

public class ADListaCompras extends RecyclerView.Adapter<viewHolderCompras> {

    @NonNull
    @Override
    public viewHolderCompras onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_compras_diarias, parent,false);
        return new viewHolderCompras(view);    }
    @Override
    public void onBindViewHolder(@NonNull viewHolderCompras holder, int position) {
    }
    @Override
    public int getItemCount() {return 0;}
}
