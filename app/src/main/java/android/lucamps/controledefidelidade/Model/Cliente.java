package android.lucamps.controledefidelidade.Model;

import java.io.Serializable;

public class Cliente implements Serializable {
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

    @Override
    public boolean equals(Object obj) {
        try {
            //Verificando se o segundo participante está nulo
            if (obj == null)
                return false;

            //verifica se são da mesma classe
            if (this.getClass() != obj.getClass())
                return false;

            //verifica se ocupam o mesmo lugar na memória
            if (super.equals(obj))
                return true;

            Cliente cli = (Cliente) obj;

            //Compara os dois objetos pelo estado interno
            if(this.getIdCliente() == cli.getIdCliente())
                return true;
            else
                return false;

        }catch (Exception e){
            return false;
        }
    }

    /*@Override
    public int hashCode() {
        //geração própria da hashCode para evitar colisão - objetos de classes diferentes com o mesmo hashCode
        //evita também que NÃO se retorne o mesmo hashCode para o mesmo objeto
        try {
            int numPrimo = 17;
            int hash = 1;

            //TÉCNICA: somar os hashCodes de todos os atributos da classe e multiplicar por um número primo
            hash = numPrimo * hash + ((this.nome == null) ? 0 : this.nome.hashCode());
            hash = numPrimo * hash + ((this.categoria == null) ? 0 : this.categoria.hashCode());
            hash = numPrimo * hash + (this.numero);
            hash = numPrimo * hash + (this.foto);
            hash = numPrimo * hash + (this.icone);
            hash = numPrimo * hash + (this.tipos.get(0).getIdTipo());
            hash = numPrimo * hash + ((this.tipos.get(0).getNome() == null) ? 0 : this.tipos.get(0).getNome().hashCode());
            if (this.tipos.size() > 1){
                hash = numPrimo * hash + (this.tipos.get(1).getIdTipo());
                hash = numPrimo * hash + ((this.tipos.get(1).getNome() == null) ? 0 : this.tipos.get(1).getNome().hashCode());
            }

            return hash;
        }catch (Exception e){
            return super.hashCode();
        }
    }*/
}
