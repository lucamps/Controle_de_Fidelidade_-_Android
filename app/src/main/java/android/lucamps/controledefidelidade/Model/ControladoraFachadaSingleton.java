package android.lucamps.controledefidelidade.Model;


import android.database.Cursor;
import android.lucamps.controledefidelidade.Util.BancoDadosSingleton;
import android.util.Pair;
import android.widget.AdapterView;

import java.util.ArrayList;


public class ControladoraFachadaSingleton {
    private ArrayList<Cliente> clientes;
    private ArrayList<Empresa> empresas;
    private ArrayList<Pontos> pontos;
    private ArrayList<CodigoDePontos> cdp;
    private static ControladoraFachadaSingleton INSTANCE = new ControladoraFachadaSingleton();

    private void daoCliente(){
        this.clientes = new ArrayList<Cliente>();
        Cursor c = BancoDadosSingleton.getInstance().buscar("cliente",new String[]{"idCliente","nome","email","cpf","senha","telefone","endereco","foto","dataNascimento"},"","");

        while(c.moveToNext()){
            int idCliente = c.getColumnIndex("idCliente");
            int nome = c.getColumnIndex("nome");
            int email = c.getColumnIndex("email");
            int cpf = c.getColumnIndex("cpf");
            int senha = c.getColumnIndex("senha");
            int telefone = c.getColumnIndex("telefone");
            int endereco = c.getColumnIndex("endereco");
            int foto = c.getColumnIndex("foto");
            int dataNascimento = c.getColumnIndex("dataNascimento");

            Cliente cliente = new Cliente(c.getInt(idCliente),c.getString(nome),c.getString(email),c.getString(cpf),
                    c.getString(senha),c.getString(telefone),c.getString(endereco));

            cliente.setFoto(c.getString(foto));
            cliente.setDataNascimento(c.getString(dataNascimento));
            clientes.add(cliente);
        }

        c.close();
    }

    private void daoEmpresa(){
        this.empresas = new ArrayList<Empresa>();
        Cursor c = BancoDadosSingleton.getInstance().buscar("empresa",new String[]{"idEmpresa","nome","email","cnpj","senha","telefone","endereco","foto","redesSociais","inadimplente"},"","");

        while(c.moveToNext()){
            int idEmpresa = c.getColumnIndex("idEmpresa");
            int nome = c.getColumnIndex("nome");
            int email = c.getColumnIndex("email");
            int cnpj = c.getColumnIndex("cnpj");
            int senha = c.getColumnIndex("senha");
            int telefone = c.getColumnIndex("telefone");
            int endereco = c.getColumnIndex("endereco");
            int foto = c.getColumnIndex("foto");
            int redesSociais = c.getColumnIndex("redesSociais");
            int inadimplente = c.getColumnIndex("inadimplente");

            Empresa empresa = new Empresa(c.getInt(idEmpresa),c.getString(nome),c.getString(email),c.getString(cnpj),
                    c.getString(senha),c.getString(endereco),c.getString(foto),c.getInt(inadimplente));

            empresa.setTelefone(c.getString(telefone));
            empresa.setRedesSociais(c.getString(redesSociais));

            empresas.add(empresa);
        }

        c.close();
    }
    private void daoPontos(){
        pontos = new ArrayList<Pontos>();
        Cursor c = BancoDadosSingleton.getInstance().buscar("pontos",new String[]{"idPontos","idCliente","idEmpresa","pontosTotal","pontosResgatados"},"","");

        while(c.moveToNext()){
            int idPontos = c.getColumnIndex("idPontos");
            int idCliente = c.getColumnIndex("idCliente");
            int idEmpresa = c.getColumnIndex("idEmpresa");
            int pontosTotal = c.getColumnIndex("pontosTotal");
            int pontosResgatados = c.getColumnIndex("pontosResgatados");

            Pontos ponto = new Pontos(idPontos,new Pair<Integer, Integer>(c.getInt(idCliente),c.getInt(idEmpresa)),c.getInt(pontosTotal),c.getInt(pontosResgatados));
            pontos.add(ponto);
        }

        c.close();
    }
    public String getNomeEmpresa(int id){
        for(Empresa e : empresas){
            if(e.getIdEmpresa() == id)
                return e.getNome();
        }
        return null;
    }

    public String getNomeCliente(int id){
        for(Cliente e : clientes){
            if(e.getIdCliente() == id)
                return e.getNome();
        }
        return null;
    }
    private void daoCodigoDePontos(){
        cdp = new ArrayList<CodigoDePontos>();
        Cursor c = BancoDadosSingleton.getInstance().buscar("codigopontos",new String[]{"idCodigo","pontos","validado","idEmpresa","metodo"},"","");

        while(c.moveToNext()){
            int idCodigo = c.getColumnIndex("idCodigo");
            int pontos = c.getColumnIndex("pontos");
            int validado = c.getColumnIndex("validado");
            int idEmpresa = c.getColumnIndex("idEmpresa");
            int metodo = c.getColumnIndex("metodo");

            CodigoDePontos cod = new CodigoDePontos(c.getInt(idCodigo),c.getInt(pontos),c.getInt(validado),c.getInt(idEmpresa),c.getString(metodo));
            cdp.add(cod);
        }

        c.close();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }

    public ArrayList<Pontos> getPontos() {
       /* if(pontos.isEmpty())
            return new ArrayList<Pontos>();*/
        return pontos;
    }

    public void setPontos(ArrayList<Pontos> pontos) {
        this.pontos = pontos;
    }

    public ArrayList<CodigoDePontos> getCdp() {
        return cdp;
    }

    public void setCdp(ArrayList<CodigoDePontos> cdp) {
        this.cdp = cdp;
    }

    private ControladoraFachadaSingleton() {
        daoCliente();
        daoEmpresa();
        daoPontos();
        daoCodigoDePontos();
    }

    public static ControladoraFachadaSingleton getInstance(){
        return INSTANCE;
    }
}
