package com.example.pizzaria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edtMarguerita;
    private EditText edtFrango;
    private EditText edtQuatroQueijos;
    private EditText edtPepperoni;
    private Button btnPedido;
    private TextView txtValorTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtMarguerita = findViewById(R.id.edtMarguerita);
        edtFrango = findViewById(R.id.edtFrango);
        edtQuatroQueijos = findViewById(R.id.edtQuatroQueijos);
        edtPepperoni = findViewById(R.id.edtPepperoni);
        btnPedido = findViewById(R.id.btnPedido);
        txtValorTotal = findViewById(R.id.txtValorTotal);
    }

    public void pedido(View view) {
        int marguerita = Integer.parseInt(edtMarguerita.getText().toString());
        int frango = Integer.parseInt(edtFrango.getText().toString());
        int quatroQueijos = Integer.parseInt(edtQuatroQueijos.getText().toString());
        int pepperoni = Integer.parseInt(edtPepperoni.getText().toString());
        int valorTotal = 0;

        if(marguerita >= 1)
            valorTotal = valorTotal + (marguerita*42);
        if(frango >= 1)
            valorTotal = valorTotal + (frango*46);
        if(quatroQueijos >= 1)
            valorTotal = valorTotal + (quatroQueijos*49);
        if(pepperoni >= 1)
            valorTotal = valorTotal + (pepperoni*55);

        txtValorTotal.setText("Valor Total: R$" + valorTotal + ",00");
        Toast.makeText(MainActivity.this, "Obrigada pela preferência!", Toast.LENGTH_LONG).show();
    }
}