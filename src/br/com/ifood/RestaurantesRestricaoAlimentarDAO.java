package br.com.ifood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantesRestricaoAlimentarDAO {

    private Connection conexao;

    public List<Integer> getAllIdRestaurantes(int idPais){

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Integer> listIdRestaurantes = new ArrayList<Integer>();

        try {
            conexao = DBManager.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM restaurantes_restricao_alimentar WHERE restricao_alimentar_id = ?");
            stmt.setInt(1, idPais);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("restaurantes_id");
                listIdRestaurantes.add(id);
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

        return listIdRestaurantes;
    }

}
