package android.lucamps.controledefidelidade.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.lucamps.controledefidelidade.Model.Cliente;
import android.lucamps.controledefidelidade.Model.ControladoraFachadaSingleton;
import android.lucamps.controledefidelidade.Model.Pontos;
import android.lucamps.controledefidelidade.R;
import android.lucamps.controledefidelidade.Util.ActionBarUtil;
import android.lucamps.controledefidelidade.View.AdapterGerenciarPontos;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class GerenciarPontosActivity extends AppCompatActivity {
    private List<Pontos> pontos;
    Cliente cli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_pontos);
        ActionBarUtil.configureActionBar(this);
        Intent it = getIntent();
        cli = (Cliente) it.getSerializableExtra("cli");
        try{
            //Prepara a listview customizada de pontos
            pontos = ControladoraFachadaSingleton.getInstance().getPontos();
            ListView listView = (ListView) findViewById(R.id.lista_de_pontos);

            AdapterGerenciarPontos adapter = new AdapterGerenciarPontos(pontos, this,cli);
            listView.setAdapter(adapter);
            //listView.setOnItemClickListener(this);
        }
        catch (Exception e){
            Log.e("PONTOS",e.getMessage());
        }

    }

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