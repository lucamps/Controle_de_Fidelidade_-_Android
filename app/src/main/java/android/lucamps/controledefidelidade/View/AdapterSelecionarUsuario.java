package android.lucamps.controledefidelidade.View;

import android.app.Activity;
import android.lucamps.controledefidelidade.Model.Cliente;
import android.lucamps.controledefidelidade.Model.ControladoraFachadaSingleton;
import android.lucamps.controledefidelidade.R;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterSelecionarUsuario extends BaseAdapter  {
    private List<Cliente> clientes;
    private Activity act;

    public AdapterSelecionarUsuario(List<Cliente> clientes, Activity act) {
        try {
            this.clientes = clientes;
            this.act = act;
        }catch (Exception e){
            Log.e("PONTOS", "ERRO: " + e.getMessage());
        }
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int position) {
        return clientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return clientes.get(position).getIdCliente();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            View view = act.getLayoutInflater().inflate(R.layout.lista_clientes, parent, false);

            Cliente cli = clientes.get(position);

            TextView nomeCliente = (TextView)
                    view.findViewById(R.id.txtNomeCliente);
            ImageView imagem = (ImageView)
                    view.findViewById(R.id.imagemCliente);

            nomeCliente.setText(ControladoraFachadaSingleton.getInstance().getNomeCliente(cli.getIdCliente()));
            imagem.setImageResource(R.drawable.ic_foto_padrao);

            return view;
        }catch (Exception e){
            Log.e("LISTA_CLIENTES", "ERRO: " + e.getMessage());
            return null;
        }
    }

}
