package android.lucamps.controledefidelidade.Model;

public class Cliente {
    private int idCliente;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String telefone;
    private String endereco;
    private String data_nasc = ""; // opcional
    private String foto = ""; // opcional

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(int idCliente, String nome, String email, String cpf, String senha, String tel, String end) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        telefone = tel;
        endereco = end;
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

    public String getEndereco() {
        return endereco;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public String getFoto() {
        return foto;
    }

    public String getTelefone() {
        return telefone;
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

    public void setDataNascimento(String nova) {
        data_nasc = nova;
    }

    public void setFoto(String nova) {
        foto = nova;
    }

    public void setTelefone(String novo) {
        telefone = novo;
    }
}
