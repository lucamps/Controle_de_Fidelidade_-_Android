package android.lucamps.controledefidelidade.View;

import android.app.Activity;
import android.lucamps.controledefidelidade.Model.ControladoraFachadaSingleton;
import android.lucamps.controledefidelidade.Model.Pontos;
import android.lucamps.controledefidelidade.R;
import android.lucamps.controledefidelidade.Util.BancoDadosSingleton;
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

            TextView nomeEmpresa = (TextView)
                    view.findViewById(R.id.txtNomeEmpresa);
            TextView pontosObtidos = (TextView)
                    view.findViewById(R.id.txtPontosObtidos);
            TextView pontosResgatados = (TextView)
                    view.findViewById(R.id.txtPontosResgatados);
            ImageView imagem = (ImageView)
                    view.findViewById(R.id.imagemEmpresa);

            nomeEmpresa.setText(ControladoraFachadaSingleton.getInstance().getNomeEmpresa(pnt.getIdEmpresa()));
            pontosObtidos.setText("Pontos obtidos: "+ pnt.getPontosTotal());
            pontosResgatados.setText("resgatados: "+ pnt.getPontosResgatados());
            imagem.setImageResource(R.drawable.ic_foto_padrao);

            return view;
        }catch (Exception e){
            Log.e("LISTA", "ERRO: " + e.getMessage());
            return null;
        }
    }

}
