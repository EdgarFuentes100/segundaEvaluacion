package com.example.segundaevaluacion.ViewHolder;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.segundaevaluacion.R;

public class viewHolderActiva  extends RecyclerView.ViewHolder {
    private TextView tvTitulo;

    public TextView getTvTitulo() {
        return tvTitulo;
    }
    public viewHolderActiva(@NonNull View itemView) {
        super(itemView);
        this.tvTitulo = itemView.findViewById(R.id.tvTitulo);
    }
}
