package android.lucamps.controledefidelidade.Controller;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.lucamps.controledefidelidade.Model.Cliente;
import android.lucamps.controledefidelidade.Model.ControladoraFachadaSingleton;
import android.lucamps.controledefidelidade.R;
import android.lucamps.controledefidelidade.View.AdapterSelecionarUsuario;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import java.io.Serializable;
import java.util.List;
import java.util.List;

public class SelecionarUsuario extends Activity implements AdapterView.OnItemClickListener{
    private List<Cliente> clientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_usuario);

        try{
            //Prepara a listview customizada de clientes
            clientes = ControladoraFachadaSingleton.getInstance().getClientes();
            ListView listView = (ListView) findViewById(R.id.lista_clientes);

            AdapterSelecionarUsuario adapter = new AdapterSelecionarUsuario(clientes, this);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }
        catch (Exception e){
            Log.e("clientes",e.getMessage());
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
            //Click em um item da listView customizada
            Cliente cli = (Cliente) parent.getAdapter().getItem(position);
            Intent itAux = getIntent();
            boolean validar = itAux.getBooleanExtra("validar",false);
            Intent it;

            if (validar)
                it = new Intent(this,ValidarActivity.class);
            else
                it = new Intent(this,GerenciarPontosActivity.class);

            it.putExtra("cli", (Serializable) cli);
            startActivity(it);
        }catch (Exception e){
            Log.e("ITEM_LISTA", "ERRO no click: " + e.getMessage());
        }

    }
}