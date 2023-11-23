package org.CA.jdbc;

import org.CA.jdbc.dao.FournisseurDAO;
import org.CA.jdbc.dao.jdbc.FournisseurDAOJDBC;
import org.CA.jdbc.entites.Fournisseur;

public class TestInsertionDAO {public static void main(String[] args) {
    FournisseurDAO dao = new FournisseurDAOJDBC();
    try {
        dao.insert(new Fournisseur("La Maison De La Peinture"));
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
}
