
package bd;

import bd.core.*;
import bd.daos.*;

public class BDSQLServer {
    public static final MeuPreparedStatement COMANDO;

    static {
        MeuPreparedStatement comando = null;

        try {
            comando = new MeuPreparedStatement("com.microsoft.sqlserver.jdbc.SQLServerDriver",
                    "jdbc:sqlserver://regulus.cotuca.unicamp.br;databasename=BD19170", "BD19170", "BD19170");
        } catch (Exception erro) {
            System.err.println("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }

        COMANDO = comando;
    }
}