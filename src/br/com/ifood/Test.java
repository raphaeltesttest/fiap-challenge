package br.com.ifood;

import java.util.List;

public class Test {
    public static void main(String[] args) {

//        insertRestaurantes();
//        getAllRestaurantes();
//
//        insertRestricaoAlimentar();
//        getAllRestricaoAlimentar();

//        insertPaisesCopa2022();
//        getAllPaisesCopa2022();

//        insertBlackFriday();
//        getAllBlackFriday();

        //get restautantes_id from restaurantes.restaurantes_paises_copa2022

    }
    public static void insertRestaurantes() {
        RestaurantesDAO restaurantesDAO = new RestaurantesDAO();

            Restaurantes restaurantes = new Restaurantes(5, "Mexicanosss", "11.111.111/1111-11", "Ruas Mexicanos", "Sao Paulo",
            "11111-111", "SP", "https://images-na.ssl-images-amazon.com/images/M/CHILENosSHzHJzhjGJG", 9.8f, "Verdadeiros Tacos Mexicanos");
            restaurantesDAO.cadastrar(restaurantes);
        }

    public static void getAllRestaurantes() {

        RestaurantesDAO restaurantesDAO = new RestaurantesDAO();
        List<Restaurantes> restaurantes = restaurantesDAO.getAll();

        for (Restaurantes rt : restaurantes) {
            System.out.println(rt.toString());
        }
    }

    //----------------------------------------------------------------------------------------------

    public static void insertRestricaoAlimentar() {
        RestricaoAlimentarDAO restricaoAlimentarDAO = new RestricaoAlimentarDAO();

        RestricaoAlimentar restricaoAlimentar = new RestricaoAlimentar(5, "Glúten", "Intolerância à Glúten");
        restricaoAlimentarDAO.cadastrar(restricaoAlimentar);
    }

    public static void getAllRestricaoAlimentar() {

        RestricaoAlimentarDAO restricaoAlimentarDAO = new RestricaoAlimentarDAO();
        List<RestricaoAlimentar> restricaoAlimentar = restricaoAlimentarDAO.getAll();

        for (RestricaoAlimentar ra : restricaoAlimentar) {
            System.out.println(ra.toString());
        }
    }

    //----------------------------------------------------------------------------------------------

    public static void insertPaisesCopa2022() {
        PaisesCopa2022DAO paisesCopa22DAO = new PaisesCopa2022DAO();

        PaisesCopa2022 paisesCopa2022 = new PaisesCopa2022(3, "França", "Possui 2 títulos: 2018, 1998");
        paisesCopa22DAO.cadastrar(paisesCopa2022);
    }

    public static void getAllPaisesCopa2022() {

        PaisesCopa2022DAO paisesCopa22DAO = new PaisesCopa2022DAO();
        List<PaisesCopa2022> paisesCopa2022 = paisesCopa22DAO.getAll();

        for (PaisesCopa2022 pc : paisesCopa2022) {
            System.out.println(pc.toString());
        }
    }

    //----------------------------------------------------------------------------------------------

    public static void insertBlackFriday() {
        BlackFridayDAO blackFridayDAO = new BlackFridayDAO();

        BlackFriday blackFriday = new BlackFriday(5, 50, "Descontos com 50%");
        blackFridayDAO.cadastrar(blackFriday);
    }

    public static void getAllBlackFriday() {

        BlackFridayDAO blackFridayDAO = new BlackFridayDAO();
        List<BlackFriday> blackFriday = blackFridayDAO.getAll();

        for (BlackFriday bf : blackFriday) {
            System.out.println(bf.toString());
        }
    }

    //----------------------------------------------------------------------------------------------

}

