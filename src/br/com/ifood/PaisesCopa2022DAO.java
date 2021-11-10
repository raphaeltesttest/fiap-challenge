package br.com.ifood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisesCopa2022DAO {

    private Connection conexao;
    private int idPais;

    public void cadastrar(PaisesCopa2022 paisesCopa2022) {

        PreparedStatement stmt = null;

        try {
            conexao = DBManager.obterConexao();
            String sql = "INSERT INTO paises_copa2022(id, nome, descricao) VALUES (?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, paisesCopa2022.getId());
            stmt.setString(2, paisesCopa2022.getNome());
            stmt.setString(3, paisesCopa2022.getDescricao());
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

    public List<PaisesCopa2022> getAll() {

        List<PaisesCopa2022> lista = new ArrayList<PaisesCopa2022>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = DBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM paises_copa2022");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                PaisesCopa2022 paisesCopa22 = new PaisesCopa2022(id, nome, descricao);
                lista.add(paisesCopa22);
            }
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

        return lista;
    }

    public int getIdByName(String nome) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = DBManager.obterConexao();
            String sql = "SELECT id FROM paises_copa2022 WHERE nome = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            idPais = id;

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
        return idPais;
    }
}
