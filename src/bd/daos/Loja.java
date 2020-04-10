
package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Loja {
    /**
     * Método que confere se a loja está cadastrada
     * 
     * @param codigo é o código da loja que será procurada
     * @return se a loja está cadastrado
     * @throws Exception se ocorrer algum erro na procura
     */
    public static boolean cadastrado(int codigo) throws Exception {
        boolean retorno = false;
        try {
            String sql;
            sql = "select * from Loja where codLoja = ?";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, codigo);
            MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
            retorno = resultado.first();
        } catch (Exception ex) {
            throw new Exception("Erro ao procurar loja");
        }

        return retorno;
    }

    /**
     * 
     * @param codLoja é o código da loja que será selecionada
     * @return a loja selecionada
     * @throws Exception se ocorrer algum erro na procura
     */
    public static Loja selecionar(int codLoja) throws Exception {

        Loja loja;

        try {
            String sql;
            sql = "select * from Loja where codLoja = ?";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, codLoja);

            MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

            loja = new Loja(resultado.getInt("codLoja"), resultado.getString("nome"), resultado.getInt("cep"),
                    resultado.getInt("numero"), resultado.getString("complemento"), resultado.getString("telefone"),
                    resultado.getString("categoria"), resultado.getInt("qtdFuncionarios"));

        } catch (Exception ex) {
            throw new Exception("Erro ao procurar loja");
        }
        return loja;
    }

    /**
     * Método que inclui uma nova loja
     * 
     * @param loja objeto da classe Loja que será incluido
     * @throws Exception se o objeto dado for inválidos
     */
    public static void incluir(Loja loja) throws Exception {
        if (loja == null)
            throw new Exception("Valores não fornecidos");
        if (Loja.cadastrado(loja.getCodigo()))
            throw new Exception("Loja já cadastrada");
        try {
            String sql;
            sql = "insert into Loja values(?, ?, ?, ?, ?, ?)";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, loja.getCodigo());
            BDSQLServer.COMANDO.setString(2, loja.getNome());
            BDSQLServer.COMANDO.setInt(3, loja.getCep());
            BDSQLServer.COMANDO.setInt(4, loja.getNumero());
            BDSQLServer.COMANDO.setString(5, loja.getComplemento());
            BDSQLServer.COMANDO.setString(6, loja.getTelefone());
            BDSQLServer.COMANDO.setString(7, loja.getCategoria());
            BDSQLServer.COMANDO.setInt(8, loja.getQtdFuncionarios());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        } catch (Exception ex) {
            throw new Exception("Erro ao cadastrar/ Verifique todos os campos");
        }
    }

    /**
     * Método que altera as informações de uma Loja já inserida
     * 
     * @param loja objeto da classe loja que será alterada
     * @throws Exception se o objeto for inválido ou se ocorrer erros na conexão
     */
    public static void alterar(Loja loja) throws Exception {
        if (loja == null)
            throw new Exception("Preencha todos os espaços");

        try {
            String sql;
            sql = "update Loja set nome= ?, cep = ?, numero = ?, complemento = ?,telefone = ?, categoria = ?, qtdFuncionarios = ? where codLoja = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, loja.getCodigo());
            BDSQLServer.COMANDO.setString(2, loja.getNome());
            BDSQLServer.COMANDO.setInt(3, loja.getCep());
            BDSQLServer.COMANDO.setInt(4, loja.getNumero());
            BDSQLServer.COMANDO.setString(5, loja.getComplemento());
            BDSQLServer.COMANDO.setString(6, loja.getTelefone());
            BDSQLServer.COMANDO.setString(7, loja.getCategoria());
            BDSQLServer.COMANDO.setInt(8, loja.getQtdFuncionarios());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        } catch (Exception ex) {
            throw new Exception("Erro ao alterar os dados");
        }
    }

    /**
     * 
     * @param codLoja é o código da loja que será deletada
     * @throws Exception se ocorrer algum erro durante a exclusão
     */
    public static void deletar(int codLoja) throws Exception {
        try {
            String sql;
            sql = "delete from Loja where codLoja = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, codLoja);
            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        } catch (Exception ex) {
            throw new Exception("Erro ao deletar loja");
        }
    }

    /**
     * Método que retorna uma Loja.
     * 
     * @param codigo é o código da Loja a ser retornado
     * @return o objeto da Loja do respectivo código
     * @throws Exception se a Loja não estiver cadastrada, ou problemas no bd
     */
    public static Loja getLoja(int codigo) throws Exception {
        Loja loja = null;
        try {
            String sql = "select * from Loja where codLoja = ?";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, codigo);
            MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
            if (!resultado.first())
                throw new Exception("Nao cadastrado");

            loja = new Loja(codigo, resultado.getString("Nome"), resultado.getInt("Cep"), resultado.getInt("Numero"),
                    resultado.getString("Complemento"), resultado.getString("Telefone"),
                    resultado.getString("Categoria"), resultado.getInt("qtdFuncionarios"));
        } catch (Exception ex) {
            throw new Exception("Erro ao procurar Loja");
        }
        return loja;
    }
}