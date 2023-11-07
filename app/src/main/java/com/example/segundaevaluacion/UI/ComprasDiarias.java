package com.example.segundaevaluacion.UI;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.segundaevaluacion.R;
import com.example.segundaevaluacion.clases.Compras;

public class ComprasDiarias extends AppCompatActivity {

    TextView tvPresupuesto, tvTotal;
    EditText edtNombre, edtCantidad, edtPrecio;
    Button btnGuardar, btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras_diarias);

        tvPresupuesto = findViewById(R.id.tvPresupuesto);
        tvTotal = findViewById(R.id.tvTotal);
        edtNombre = findViewById(R.id.edtNombre);
        edtCantidad = findViewById(R.id.edtCantidd);
        edtPrecio = findViewById(R.id.edtPrecio);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnGuardar = findViewById(R.id.btnGuadar);

        // Recupera el Bundle del Intent
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            // Recupera el objeto Compras del Bundle
            Compras compra = bundle.getParcelable("compra");

            // Realiza operaciones con el objeto Compras
            if (compra != null) {
                tvPresupuesto.setText(compra.getPresupuesto() + "");
                tvTotal.setText(compra.getTotal() + "");
            }
        }
    }
}