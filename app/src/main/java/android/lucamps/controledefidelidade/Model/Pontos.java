package android.lucamps.controledefidelidade.Model;

import android.util.Pair;

public class Pontos {
    private int idPontos;
    private Pair<Integer, Integer> idGeral; // idCliente, idEmpresa
    private int pontosTotal;
    private int pontosResgatados;

    public int getIdPontos() {
        return idPontos;
    }

    public Pontos(){
        idGeral = new Pair<Integer,Integer>(0,0);
    }

    public Pontos(int idPontos,Pair<Integer,Integer> idGeral, int pontosTotal, int pontosResgatados) {
        this.idPontos = idPontos;
        this.idGeral = idGeral;
        this.pontosTotal = pontosTotal;
        this.pontosResgatados = pontosResgatados;
    }
    public Pontos(int idCliente, int idEmpresa, int pontosTotal, int pontosResgatados) {
        idGeral = new Pair<Integer,Integer>(idCliente,idEmpresa);
        this.pontosTotal = pontosTotal;
        this.pontosResgatados = pontosResgatados;
    }

    public int getIdCliente() {
        return idGeral.first;
    }

    public int getIdEmpresa() {
        return idGeral.second;
    }
    public Pair<Integer, Integer> getIdGeral() {
        return idGeral;
    }

    public void setIdGeral(Pair<Integer, Integer> idGeral) {
        this.idGeral = idGeral;
    }

    public int getPontosTotal() {
        return pontosTotal;
    }

    public void setPontosTotal(int pontosTotal) {
        this.pontosTotal = pontosTotal;
    }

    public int getPontosResgatados() {
        return pontosResgatados;
    }

    public void setPontosResgatados(int pontosResgatados) {
        this.pontosResgatados = pontosResgatados;
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

            Pontos pnt = (Pontos) obj;

            //Compara os dois objetos pelo estado interno
            if(this.getIdCliente() == pnt.getIdCliente() && this.getIdEmpresa() == pnt.getIdEmpresa())
                return true;
            else
                return false;

        }catch (Exception e){
            return false;
        }
    }
}
