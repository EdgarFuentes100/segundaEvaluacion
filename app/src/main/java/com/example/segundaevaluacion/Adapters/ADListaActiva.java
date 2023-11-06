package com.example.segundaevaluacion.Adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.segundaevaluacion.R;
import com.example.segundaevaluacion.ViewHolder.viewHolderActiva;

public class ADListaActiva extends RecyclerView.Adapter<viewHolderActiva> {
    @NonNull
    @Override
    public viewHolderActiva onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        return new viewHolderActiva(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderActiva holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
