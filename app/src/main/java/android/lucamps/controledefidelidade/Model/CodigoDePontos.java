package android.lucamps.controledefidelidade.Model;

import java.util.Random;

public class CodigoDePontos {
    private String codigo;
    private Empresa empresa;
    private String dataGeracao;

    private int idCodigo;
    private int pontos = 0;
    private boolean validado = false;
    private int idEmpresa;
    String metodo;

    CodigoDePontos(int idCodigo,int pontos,int validado, int idEmpresa, String metodo){
        this.idCodigo = idCodigo;
        this.pontos = pontos;
        this.validado = (validado == 1);
        this.idEmpresa = idEmpresa;
        this.metodo = metodo;
    }

    CodigoDePontos(Empresa empresa, float valor, String data, ConversaoStrategy strategy) {
        this.empresa = empresa;
        dataGeracao = data;

        strategy.converteValor();

        pontos = strategy.getPontos();
        gerarCodigo();
    }

    void gerarCodigo() {
        // intervalo para números - 48 - 57
        // intervalo A-Z            65 - 90
        // intervalo a-z            97 - 122
        Random random = new Random();

        String aux = "";

        for(int i=0 ; i<10 ; i++) {
            int num = random.nextInt(123) + 48;

            while(num < 48 || (num > 57 && num < 65) || (num > 90 && num < 97) || num > 122) {
                num = random.nextInt(123) + 48;
            }

            aux += (char)num;
        }

        codigo = aux;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean getValidado() {
        return validado;
    }
}
