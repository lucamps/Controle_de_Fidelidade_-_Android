package android.lucamps.controledefidelidade.View;

import android.app.Activity;
import android.lucamps.controledefidelidade.Model.Pontos;
import android.lucamps.controledefidelidade.R;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Lucas on 20/12/2016.
 */
public class AdapterGerenciarPontos extends BaseAdapter {

    private List<Pontos> pontos;
    private Activity act;

    public AdapterGerenciarPontos(List<Pontos> pontos, Activity act) {
        try {
            this.pontos = pontos;
            this.act = act;
        }catch (Exception e){
            Log.e("PONTOS", "ERRO: " + e.getMessage());
        }
    }

    @Override
    public int getCount() {
        return pontos.size();
    }

    @Override
    public Object getItem(int position) {
        return pontos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pontos.get(position).getIdEmpresa();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            View view = act.getLayoutInflater().inflate(R.layout.lista_de_pontos, parent, false);

            Pontos pnt = pontos.get(position);

           // Log.i("POKEDEX", "Montando lista pokedex para " + pkmn.getNome());

            TextView nomeEmpresa = (TextView)
                    view.findViewById(R.id.txtNomeEmpresa);
            TextView pontosObtidos = (TextView)
                    view.findViewById(R.id.txtPontosObtidos);
            TextView pontosResgatados = (TextView)
                    view.findViewById(R.id.txtPontosResgatados);
            ImageView imagem = (ImageView)
                    view.findViewById(R.id.imagemEmpresa);

            //Decide se vai ter informações do pokemon ou não
           /* if(ControladoraFachadaSingleton.getInstance().getUsuario().getQuantidadeCapturas(pkmn) > 0) {
                nomePokemon.setText(pkmn.getNome());

                //ajusta o visual do número acrescendo zeros ao lado
                if(pkmn.getNumero() < 10)
                    numeroPokemon.setText("#00"+pkmn.getNumero());
                else if(pkmn.getNumero() < 100)
                    numeroPokemon.setText("#0"+pkmn.getNumero());
                else
                    numeroPokemon.setText("#" + pkmn.getNumero());

                imagem.setImageResource(pkmn.getIcone());
            }else {
                nomePokemon.setText("???");

                //ajusta o visual do número acrescendo zeros ao lado
                if(pkmn.getNumero() < 10)
                    numeroPokemon.setText("#00"+pkmn.getNumero());
                else if(pkmn.getNumero() < 100)
                    numeroPokemon.setText("#0"+pkmn.getNumero());
                else
                    numeroPokemon.setText("#"+pkmn.getNumero());

                imagem.setImageResource(R.drawable.help);
            }
            */
            return view;
        }catch (Exception e){
            Log.e("POKEDEX", "ERRO: " + e.getMessage());
            return null;
        }
    }

}
