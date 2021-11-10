package br.com.ifood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestricaoAlimentarDAO {

    private Connection conexao;
    private int idRestricaoAlimentar;

    public void cadastrar (RestricaoAlimentar restricaoAlimentar) {

        PreparedStatement stmt = null;

        try {
            conexao = DBManager.obterConexao();
            String sql = "INSERT INTO restricao_alimentar(id, nome, descricao) VALUES (?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, restricaoAlimentar.getId());
            stmt.setString(2, restricaoAlimentar.getNome());
            stmt.setString(3, restricaoAlimentar.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

           public List<RestricaoAlimentar> getAll(){

            List<RestricaoAlimentar> lista = new ArrayList<RestricaoAlimentar>();

            PreparedStatement stmt = null;
            ResultSet rs = null;

            try {
                conexao = DBManager.obterConexao();
                stmt = conexao.prepareStatement("SELECT * FROM restricao_alimentar");
                rs = stmt.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String descricao = rs.getString("descricao");
                    RestricaoAlimentar restricaoAlimentar = new RestricaoAlimentar(id, nome, descricao);
                    lista.add(restricaoAlimentar);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    stmt.close();
                    rs.close();
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        return lista;
    }

    public int getIdByName(String nome) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = DBManager.obterConexao();
            String sql = "SELECT id FROM restricao_alimentar WHERE nome = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            idRestricaoAlimentar = id;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idRestricaoAlimentar;
    }

}
