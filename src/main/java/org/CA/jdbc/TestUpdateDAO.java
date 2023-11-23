package org.CA.jdbc;

import org.CA.jdbc.dao.FournisseurDAO;
import org.CA.jdbc.dao.jdbc.FournisseurDAOJDBC;

public class TestUpdateDAO {
    public static void main(String[] args) {
        try {
            FournisseurDAO dao = new FournisseurDAOJDBC();
            dao.update("La Maison De La Peinture", "La Maison Des Peintures");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}


