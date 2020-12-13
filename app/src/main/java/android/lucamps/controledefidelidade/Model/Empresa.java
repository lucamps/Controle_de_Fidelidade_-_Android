package android.lucamps.controledefidelidade.Model;

import android.util.Log;

import java.util.ArrayList;

public class Empresa {
    private int idEmpresa;
    private String nome;
    private String email;
    private String cnpj = "";
    private String endereco;
    private String senha;
    private String logo;
    private boolean pontoCompra = false;
    private boolean pontoGasto = false;
    private float pontoArbitrario = (float) 0.0;
    private String telefone; // opcional
    private ArrayList<String> redesSociais; //opcional
    private int inadimplente = 0;

    public int getInadimplente() {
        return inadimplente;
    }

    public boolean pontoCompra() {
        return pontoCompra;
    }

    public boolean pontoGasto() {
        return pontoGasto;
    }

    public float pontoArbitrario() {
        return pontoArbitrario;
    }

    public Empresa(int idEmpresa,String n, String e, String cnpj, String s, String end, String logo, int inadimplente) {
        this.idEmpresa = idEmpresa;
        nome = n;
        email = e;
        endereco = end;
        senha = s;
        this.logo = logo;
        this.cnpj = cnpj;
        this.inadimplente = inadimplente;
        redesSociais = new ArrayList<>();
        // como vai definir o método de conversão?
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getLogo() {
        return logo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void addRedeSocial(String redeSocial) {
        for(String rs : redesSociais) {
            if(rs.equals(redeSocial)) {
                return;
            }
        }

        redesSociais.add(redeSocial);
    }

    public void setRedesSociais(String texto){
        try {
            String[] redesSociais = texto.split(";");
            for(String i: redesSociais)
                addRedeSocial(i);
        }
        catch (Exception e){
            Log.e("REDES_SOCIAIS", e.getMessage());
        }

    }
    public void setNome(String novo) {
        nome = novo;
    }

    public void setSenha(String nova) {
        senha = nova;
    }

    public void setEndereco(String novo) {
        endereco = novo;
    }

    public void setLogo(String nova) {
        logo = nova;
    }

    public void setTelefone(String novo) {
        telefone = novo;
    }
}
