package br.com.ifood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantesDAO {

    private Connection conexao;

    public void cadastrar(Restaurantes restaurantes) {

        PreparedStatement stmt = null;

        try {
            conexao = DBManager.obterConexao();
            String sql = "INSERT INTO restaurantes(id, nome, cnpj, endereco, cidade, cep, estado, image_url, avaliacao, descricao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, restaurantes.getId());
            stmt.setString(2, restaurantes.getNome());
            stmt.setString(3, restaurantes.getCnpj());
            stmt.setString(4, restaurantes.getEndereco());
            stmt.setString(5, restaurantes.getCidade());
            stmt.setString(6, restaurantes.getCep());
            stmt.setString(7, restaurantes.getEstado());
            stmt.setString(8, restaurantes.getImage_url());
            stmt.setFloat(9, restaurantes.getAvaliacao());
            stmt.setString(10, restaurantes.getDescricao());
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

    public List<Restaurantes> getAll() {

        List<Restaurantes> lista = new ArrayList<Restaurantes>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = DBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM restaurantes");
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");
                String endereco = rs.getString("endereco");
                String cidade = rs.getString("cidade");
                String cep = rs.getString("cep");
                String estado = rs.getString("estado");
                String image_url = rs.getString("image_url");
                float avaliacao = rs.getFloat("avaliacao");
                String descricao = rs.getString("descricao");
                Restaurantes restaurantes = new Restaurantes(id, nome, cnpj, endereco, cidade, cep, estado, image_url, avaliacao, descricao);
                lista.add(restaurantes);
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

    public List<Restaurantes> getRestaurantesByIdList(List<Integer> list) {


        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Restaurantes> listRestaurantes = new ArrayList<Restaurantes>();

        for (int i = 0; i < list.size(); i++) {

            try {
                conexao = DBManager.obterConexao();
                stmt = conexao.prepareStatement("SELECT * FROM restaurantes WHERE id = ?");
                stmt.setInt(1, list.get(i));
                rs = stmt.executeQuery();

                while (rs.next()) {

                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String cnpj = rs.getString("cnpj");
                    String endereco = rs.getString("endereco");
                    String cidade = rs.getString("cidade");
                    String cep = rs.getString("cep");
                    String estado = rs.getString("estado");
                    String image_url = rs.getString("image_url");
                    float avaliacao = rs.getFloat("avaliacao");
                    String descricao = rs.getString("descricao");
                    Restaurantes restaurantes = new Restaurantes(id, nome, cnpj, endereco, cidade, cep, estado, image_url, avaliacao, descricao);
                    listRestaurantes.add(restaurantes);
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
        }
        return listRestaurantes;
    }
}
