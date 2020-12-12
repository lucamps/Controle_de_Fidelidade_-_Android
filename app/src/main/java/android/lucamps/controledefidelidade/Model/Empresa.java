package android.lucamps.controledefidelidade.Model;

import java.util.ArrayList;

public class Empresa {
    private String nome;
    private String email;
    private String cpf = "";
    private String cnpj = "";
    private String endereco;
    private String senha;
    private String logo;
    private boolean pontoCompra = false;
    private boolean pontoGasto = false;
    private float pontoArbitrario = (float) 0.0;
    private String telefone; // opcional
    private ArrayList<String> redesSocias; //opcional
    private boolean inadimplente = false;

    public boolean getInadimplente() {
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

    public Empresa(String n, String e, String cpf, String cnpj, String end, String s, String logo) {
        nome = n;
        email = e;
        endereco = end;
        senha = s;
        this.logo = logo;
        this.cnpj = cnpj;
        this.cpf = cpf;

        // como vai definir o método de conversão?
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

    public String getCPF() {
        return cpf;
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
        for(String rs : redesSocias) {
            if(rs == redeSocial) {
                return;
            }
        }

        redesSocias.add(redeSocial);
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
