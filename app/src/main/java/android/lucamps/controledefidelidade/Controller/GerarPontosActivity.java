package android.lucamps.controledefidelidade.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.lucamps.controledefidelidade.R;
import android.lucamps.controledefidelidade.Util.ActionBarUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class GerarPontosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_pontos);

        // Criando botão "voltar"
        ActionBarUtil.configureActionBar(this);

        EditText editTextPontos = findViewById(R.id.editTextNumber);
        Button button1 = findViewById(R.id.button1);

        button1.setOnClickListener(view -> {
            // Aceitando apenas números válidos
            try {
                String temp = editTextPontos.getText().toString();
                if(temp.isEmpty() || temp.equals("0")){
                    Toast.makeText(this,"Digite um número maior que zero",Toast.LENGTH_LONG).show();
                    return;
                }

                Integer pontos = Integer.parseInt(temp);
            }
            catch (NumberFormatException e){
                Toast.makeText(this,"Número inválido, favor digite um número menor",Toast.LENGTH_LONG).show();
            }
        });
    }

    // Tratando método de clique do botão voltar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}