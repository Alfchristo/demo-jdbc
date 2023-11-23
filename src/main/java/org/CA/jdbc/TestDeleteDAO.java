package org.CA.jdbc;

import org.CA.jdbc.dao.FournisseurDAO;
import org.CA.jdbc.dao.jdbc.FournisseurDAOJDBC;
import org.CA.jdbc.entites.Fournisseur;

public class TestDeleteDAO {
    public static void main(String[] args) {
        FournisseurDAO dao = new FournisseurDAOJDBC();
        dao.delete(new Fournisseur("La Maison Des Peintures"));
    }
}
