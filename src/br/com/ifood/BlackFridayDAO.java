package br.com.ifood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlackFridayDAO {

    private Connection conexao;
    private int idBlackFriday;

    public void cadastrar (BlackFriday blackFriday) {

        PreparedStatement stmt = null;

        try {
            conexao = DBManager.obterConexao();
            String sql = "INSERT INTO black_friday(id, desconto, descricao) VALUES (?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, blackFriday.getId());
            stmt.setInt(2, blackFriday.getDesconto());
            stmt.setString(3, blackFriday.getDescricao());
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

    public List<BlackFriday> getAll(){

        List<BlackFriday> lista = new ArrayList<BlackFriday>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = DBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM black_friday");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int desconto = rs.getInt("desconto");
                String descricao = rs.getString("descricao");
                BlackFriday blackFriday = new BlackFriday(id, desconto, descricao);
                lista.add(blackFriday);
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

    public int getIdByDesconto(int desconto) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = DBManager.obterConexao();
            String sql = "SELECT id FROM black_friday WHERE desconto = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, desconto);
            rs = stmt.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            idBlackFriday = id;

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
        return idBlackFriday;
    }
}
