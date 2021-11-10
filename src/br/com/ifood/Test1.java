package br.com.ifood;

import java.util.List;

public class Test1 {

    public static void main(String[] args) {

        listAllRestaurantesByPaisNome("Itália");

        listAllRestaurantesByRestricaoAlimentar("Lactose");

        listAllRestaurantesByBlackFriday(30);
    }

    public static List<Restaurantes> listAllRestaurantesByPaisNome(String paisName) {
        PaisesCopa2022DAO paisesCopa2022DAO = new PaisesCopa2022DAO();
        int idPaisByName = paisesCopa2022DAO.getIdByName(paisName);

        RestaurantesPaisesCopa2022DAO restaurantesPaisesCopa2022DAO = new RestaurantesPaisesCopa2022DAO();
        List<Integer> allIdRestaurantes = restaurantesPaisesCopa2022DAO.getAllIdRestaurantes(idPaisByName);

        RestaurantesDAO restaurantesDAO = new RestaurantesDAO();
        List<Restaurantes> restaurantesList = restaurantesDAO.getRestaurantesByIdList(allIdRestaurantes);

        for (Restaurantes rs : restaurantesList) {
            System.out.println(rs);
        }

        return restaurantesList;
    }

    public static List<Restaurantes> listAllRestaurantesByRestricaoAlimentar(String restricaoAlimentar) {
        RestricaoAlimentarDAO restricaoAlimentarDAO = new RestricaoAlimentarDAO();
        int idByName = restricaoAlimentarDAO.getIdByName(restricaoAlimentar);

        RestaurantesRestricaoAlimentarDAO restaurantesRestricaoAlimentarDAO = new RestaurantesRestricaoAlimentarDAO();
        List<Integer> allIdRestaurantes = restaurantesRestricaoAlimentarDAO.getAllIdRestaurantes(idByName);

        RestaurantesDAO restaurantesDAO = new RestaurantesDAO();
        List<Restaurantes> restaurantesList = restaurantesDAO.getRestaurantesByIdList(allIdRestaurantes);

        for (Restaurantes rs : restaurantesList) {
            System.out.println(rs);
        }

        return restaurantesList;
    }

    public static List<Restaurantes> listAllRestaurantesByBlackFriday(int descontoBlackFriday) {

        BlackFridayDAO blackFridayDAO = new BlackFridayDAO();
        int idByDesconto = blackFridayDAO.getIdByDesconto(descontoBlackFriday);

        RestaurantesBlackFridayDAO restaurantesBlackFridayDAO = new RestaurantesBlackFridayDAO();
        List<Integer> allIdRestaurantes = restaurantesBlackFridayDAO.getAllIdRestaurantes(idByDesconto);

        RestaurantesDAO restaurantesDAO = new RestaurantesDAO();
        List<Restaurantes> restaurantesList = restaurantesDAO.getRestaurantesByIdList(allIdRestaurantes);

        for (Restaurantes rs : restaurantesList) {
            System.out.println(rs);
        }

        return restaurantesList;
    }
}
