package android.lucamps.controledefidelidade.Util;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import android.lucamps.controledefidelidade.R;

public final class BancoDadosSingleton {

    protected SQLiteDatabase db;
    private final String NOME_BANCO = "controle_fidelidade_bd";
    private static final BancoDadosSingleton INSTANCE = new BancoDadosSingleton();

    private final String[] SCRIPT_DATABASE_CREATE = new String[] {
            "CREATE TABLE cliente (" +
                    "  idCliente INTEGER PRIMARY KEY," +
                    "  nome TEXT NOT NULL," +
                    "  email TEXT NOT NULL," +
                    "  cpf TEXT NOT NULL," +
                    "  senha TEXT NOT NULL," +
                    "  telefone TEXT NOT NULL," +
                    "  endereco TEXT NOT NULL," +
                    "  foto TEXT," +
                    "  dataNascimento TEXT" +
                    ");",

            "INSERT INTO cliente (idCliente, nome, email, cpf, senha, telefone, endereco, foto, dataNascimento) VALUES" +
                    "(1, 'Fulano da Silva', 'fulano@gmail.com', '12457862121', '#bjadjkdabjs','3138917070','Rua Sei La, num 1000',"+ R.drawable.ic_foto_padrao+", '21/02/1987')," +
                    "(2, 'Nilson', 'nilson@gmail.com', '34512412455', 'dasd1sa6452','3138917070', 'Rua Sei La, num 1000',"+ R.drawable.ic_foto_padrao+", '21/02/1987')," +
                    "(3, 'Daniela', 'daniela@gmail.com', '45414212451', 'sd56adsdsasd','3138917070', 'Rua Sei La, num 1000',"+ R.drawable.ic_foto_padrao+", '21/02/1987')," +
                    "(4, 'Lucas', 'lucas@gmail.com', '55414212451', 'sd56adsdsasd','3138917070', 'Rua Sei La, num 1000',"+ R.drawable.ic_foto_padrao+", '21/02/1987');",

            "CREATE TABLE empresa (" +
                    "  idEmpresa INTEGER PRIMARY KEY ," +
                    "  nome TEXT NOT NULL," +
                    "  email TEXT NOT NULL," +
                    "  cnpj TEXT NOT NULL," +
                    "  senha TEXT NOT NULL," +
                    "  telefone TEXT," +
                    "  endereco TEXT NOT NULL," +
                    "  foto TEXT NOT NULL," +
                    "  redesSociais TEXT," +
                    "  inadimplente INTEGER NOT NULL DEFAULT 0" +
                    ");",

            "INSERT INTO empresa (idEmpresa, nome, email, cnpj, senha, telefone, endereco, foto, redesSociais, inadimplente) VALUES" +
                    "(1, 'Empresa Aleatória', 'fulano1@gmail.com', '12457862121', '#bjadjkd1bjs','3138917170','Rua Tal num 440','FAZER_DEPOIS', '@empresa1',0)," +
                    "(2, 'Bar do Fulano de Tal', 'fulano2@gmail.com', '12457562121', '#bjadjk2bjs','3138917070','Rua Tal num 150','FAZER_DEPOIS', '@empresa1',0)," +
                    "(3, 'Janaina\''s Coffe', 'fulano2@gmail.com', '12457562121', '#bjadjk2bjs','3138917070','Rua Tal num 150','FAZER_DEPOIS', '@empresa1',0)," +
                    "(4, 'Outra Empresa Aleatória', 'fulano2@gmail.com', '12457562121', '#bjadjk2bjs','3138917070','Rua Tal num 150','FAZER_DEPOIS', '@empresa1',0)," +
                    "(5, 'Churrascaria Lorem Ipsum', 'fulano2@gmail.com', '12457562121', '#bjadjk2bjs','3138917070','Rua Tal num 150','FAZER_DEPOIS', '@empresa1',0)," +
                    "(6, 'Sweet Doces', 'fulano2@gmail.com', '12457562121', '#bjadjk2bjs','3138917070','Rua Tal num 150','FAZER_DEPOIS', '@empresa1',0)," +
                    "(7, 'Fliperama do João', 'fulano2@gmail.com', '12457562121', '#bjadjk2bjs','3138917070','Rua Tal num 150','FAZER_DEPOIS', '@empresa1',0)," +
                    "(8, 'Papelaria Central', 'fulano2@gmail.com', '12457562121', '#bjadjk2bjs','3138917070','Rua Tal num 150','FAZER_DEPOIS', '@empresa1',0)," +
                    "(9, 'Açougue do Zé', 'fulano2@gmail.com', '12457562121', '#bjadjk2bjs','3138917070','Rua Tal num 150','FAZER_DEPOIS', '@empresa1',0)," +
                    "(10, 'Loja Criatividade LDTA', 'fulano3@gmail.com', '12457812121', '#bjadj2kdabjs','3138911070','Rua Tal num 1140','FAZER_DEPOIS', '@empresa1',0)",

            "CREATE TABLE pontos (" +
                    "  idPontos INTEGER NOT NULL PRIMARY KEY," +
                    "  idCliente INTEGER NOT NULL," +
                    "  idEmpresa INTEGER NOT NULL," +
                    "  pontosTotal INTEGER NOT NULL," +
                    "  pontosResgatados INTEGER NOT NULL," +
                    "  CONSTRAINT fk_pontos_cliente FOREIGN KEY (idCliente) REFERENCES cliente (idCliente)," +
                    "  CONSTRAINT fk_pontos_empresa FOREIGN KEY (idEmpresa) REFERENCES empresa (idEmpresa)" +
                    ");",

            "INSERT INTO pontos (idPontos, idCliente, idEmpresa, pontosTotal, pontosResgatados) VALUES" +
                    "(1, 1, 1, 10, 1)," +
                    "(2, 1, 2, 210, 50)," +
                    "(3, 1, 3, 4440, 545)," +
                    "(4, 2, 4, 14144, 545)," +
                    "(5, 2, 5, 1000, 10)," +
                    "(6, 2, 6, 1600, 5)," +
                    "(7, 2, 7, 1200, 50)," +
                    "(8, 2, 8, 500, 40)," +
                    "(9, 3, 9, 515691, 5151)," +
                    "(10, 3, 10, 4441, 445)," +
                    "(11, 4, 10, 1800, 90)",

            "CREATE TABLE codigopontos (" +
                    "  idCodigo INTEGER PRIMARY KEY," +
                    "  pontos INTEGER NOT NULL," +
                    "  validado INTEGER NOT NULL," +
                    "  idEmpresa INTEGER NOT NULL," +
                    "  metodo TEXT NOT NULL," +
                    "  CONSTRAINT fk_codigo_empresa FOREIGN KEY (idEmpresa) REFERENCES empresa (idEmpresa)" +
                    ");"};

    private BancoDadosSingleton() {
        Context ctx = MyApp.getAppContext();
        // Abre o banco de dados já existente ou então cria um banco novo
        db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);

        //busca por tabelas existentes no banco = "show tables" do MySQL
        //SELECT * FROM sqlite_master WHERE type = "table"
        Cursor c = buscar("sqlite_master", null, "type = 'table'", "");

        //Cria tabelas do banco de dados caso o mesmo estiver vazio.
        //Sempre os bancos criados pelo método openOrCreateDatabase() possuem uma tabela padrão "android_metadata"
        if(c.getCount() == 1){
            for(int i = 0; i < SCRIPT_DATABASE_CREATE.length; i++){
                db.execSQL(SCRIPT_DATABASE_CREATE[i]);
            }
            Log.i("BANCO_DADOS", "Criou tabelas do banco e as populou.");
        }

        c.close();
        Log.i("BANCO_DADOS", "Abriu conexão com o banco.");
    }

    public static BancoDadosSingleton getInstance(){
        return INSTANCE;
    }

    // Insere um novo registro
    public long inserir(String tabela, ContentValues valores) {
        long id = db.insert(tabela, null, valores);

        Log.i("BANCO_DADOS", "Cadastrou registro com o id [" + id + "]");
        return id;
    }

    // Atualiza registros
    public int atualizar(String tabela, ContentValues valores, String where) {
        int count = db.update(tabela, valores, where, null);

        Log.i("BANCO_DADOS", "Atualizou [" + count + "] registros");
        return count;
    }

    // Deleta registros
    public int deletar(String tabela, String where) {
        int count = db.delete(tabela, where, null);

        Log.i("BANCO_DADOS", "Deletou [" + count + "] registros");
        return count;
    }

    // Busca registros
    public Cursor buscar(String tabela, String colunas[], String where, String orderBy) {
        Cursor c;
        if(!where.equals(""))
            c = db.query(tabela, colunas, where, null, null, null, orderBy);
        else
            c = db.query(tabela, colunas, null, null, null, null, orderBy);

        Log.i("BANCO_DADOS", "Realizou uma busca e retornou [" + c.getCount() + "] registros.");
        return c;
    }

    // Abre conexão com o banco
    public void abrir() {
        Context ctx = MyApp.getAppContext();
        // Abre o banco de dados já existente
        db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
        Log.i("BANCO_DADOS", "Abriu conexão com o banco.");
    }

    // Fecha o banco
    public void fechar() {
        // fecha o banco de dados
        if (db != null) {
            db.close();
            Log.i("BANCO_DADOS", "Fechou conexão com o Banco.");
        }
    }
}
