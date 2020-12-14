package android.lucamps.controledefidelidade.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.lucamps.controledefidelidade.Model.Cliente;
import android.lucamps.controledefidelidade.Model.Pontos;
import android.lucamps.controledefidelidade.R;
import android.lucamps.controledefidelidade.Util.BancoDadosSingleton;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ValidarActivity extends AppCompatActivity {

    private Cliente cli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar);

        Intent it = new Intent();
        cli = (Cliente) it.getSerializableExtra("cli");

        EditText codigo = findViewById(R.id.editTextValidar);
        Button validar = findViewById(R.id.button2);

        validar.setOnClickListener(view -> {
            int codigoInt = Integer.parseInt(codigo.getText().toString());

            String msg = validaPontos(codigoInt);

            Toast.makeText(this, msg,Toast.LENGTH_LONG).show();

        });
    }
    public void somarPontos(int num){
        Cursor c = BancoDadosSingleton.getInstance().buscar("pontos p, codigopontos cp",
                new String[]{"p.idPontos idPontos", "p.idCliente idCliente", "p.idEmpresa idEmpresa",
                        "p.pontosTotal pontosTotal", "p.pontosResgatados pontosResgatados"},
                "cp.idEmpresa = p.idEmpresa AND p.idCliente = '" + cli.getIdCliente() + "'",null);

        c.moveToNext(); //obs: fora do while pois deve haver apenas uma linha de resposta

        //Salvando os índices da tabela
        int idPontos = c.getInt(c.getColumnIndex("idPontos"));
        int pontosTotal = c.getColumnIndex("pontosTotal");

        //Prepara valores para serem persistidos no banco
        ContentValues valores = new ContentValues();
        valores.put("pontosTotal",c.getInt(pontosTotal)+num);

        //Atualizando o banco
        BancoDadosSingleton.getInstance().atualizar("pontos",valores,"idPontos = '"  + idPontos + "'");

    }

    private String validaPontos(int codigoInt){
        Cursor c = BancoDadosSingleton.getInstance().buscar("codigopontos",new String[]{"idCodigo", "pontos", "validado", "idEmpresa", "metodo"},
                "validado = 0 AND idCodigo = '" + codigoInt + "'","");

        while(c.moveToNext()){
            //Salvando os índices da tabela
            int idCodigo = c.getColumnIndex("idCodigo");
            int pontos = c.getColumnIndex("pontos");
            int validado = c.getColumnIndex("validado");
            int idEmpresa = c.getColumnIndex("idEmpresa");
            int metodo = c.getColumnIndex("metodo");

            //Prepara valores para serem persistidos no banco
            ContentValues valores = new ContentValues();
            valores.put("idCodigo",c.getInt(idCodigo));
            valores.put("pontos",c.getInt(pontos));
            valores.put("validado", 1);
            valores.put("idEmpresa",c.getInt(idEmpresa));
            valores.put("metodo",c.getString(metodo));

            //Atualizando o banco
            BancoDadosSingleton.getInstance().atualizar("codigopontos",valores,"idCodigo = '"  +c.getInt(idCodigo) + "'");

            int valor = c.getInt(pontos);
            c.close();

            //somarPontos(valor);

            return "Codigo validado!";
        }
        c.close();
        return "Código inexistente ou validado anteriormente.";
    }
}