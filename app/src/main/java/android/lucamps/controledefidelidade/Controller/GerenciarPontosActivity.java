package android.lucamps.controledefidelidade.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.lucamps.controledefidelidade.R;
import android.lucamps.controledefidelidade.Util.ActionBarUtil;
import android.os.Bundle;
import android.view.MenuItem;

public class GerenciarPontosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_pontos);
        ActionBarUtil.configureActionBar(this);
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