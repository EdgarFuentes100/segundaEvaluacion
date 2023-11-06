package com.example.segundaevaluacion.UI;
import static com.example.segundaevaluacion.TODOApplication.firebaseFirestore;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.segundaevaluacion.R;
import com.example.segundaevaluacion.clases.Compras;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btnCompra;
    BottomSheetDialog dialogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCompra = findViewById(R.id.btnCompra);

        dialogo = new BottomSheetDialog(this);

        CrearDialogo();

        btnCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.show();
            }
        });

        dialogo.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

    }

    private void CrearDialogo() {

        View v = getLayoutInflater().inflate(R.layout.item_bottom, null, false);
        Button btnGuardar = v.findViewById(R.id.btnGuardar);
        EditText edtPresupuesto = v.findViewById(R.id.edtPresupuesto);
        EditText edtTitulo = v.findViewById(R.id.edtTitulo);

        firebaseFirestore.collection("users")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                            String firstName = document.getString("first");
                            String lastName = document.getString("last");
                            Long born = document.getLong("born");

                            if(firstName.equals("Luis")){
                                edtPresupuesto.setText(firstName);
                                edtTitulo.setText(lastName);
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Maneja el error de recuperación de datos
                    }
                });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.dismiss();
                if(!edtPresupuesto.getText().equals("") && !edtTitulo.getText().equals("")){
                    Compras compra = new Compras();
                    compra.setTitulo(edtTitulo.getText().toString());
                    compra.setPresupuesto(Double.parseDouble(edtPresupuesto.getText().toString()));
                    compra.setActiva(true);

                    /*Map<String, Object> user = new HashMap<>();
                    user.put("first", "Luis");
                    user.put("last", "Ruiz");
                    user.put("born", 1071);
                    // Add a new document with a generated ID
                    firebaseFirestore.collection("users")
                    .add(user)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference)
                        {
                            //Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            Toast.makeText(MainActivity.this, "TODO OK", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            //Log.w(TAG, "Error adding document", e);
                            Toast.makeText(MainActivity.this, "Ocurrio problema" + e, Toast.LENGTH_SHORT).show();
                        }
                    });*/
                }
            }
        });
        dialogo.setContentView(v);
    }
}