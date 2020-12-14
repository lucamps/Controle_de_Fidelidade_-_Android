package android.lucamps.controledefidelidade.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.lucamps.controledefidelidade.R;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gerenciarBt = findViewById(R.id.buttonGerenciar);
        Button gerarBt = findViewById(R.id.buttonGerar);

        gerenciarBt.setOnClickListener(view -> {
            //Intent it = new Intent(getBaseContext(), GerenciarPontosActivity.class);
            Intent it = new Intent(getBaseContext(), SelecionarUsuario.class);
            startActivity(it);
        });

        gerarBt.setOnClickListener(view -> {
            Intent it = new Intent(getBaseContext(), GerarPontosActivity.class);
            startActivity(it);
        });

    }
}