package org.CA.jdbc;

import org.CA.jdbc.dao.FournisseurDAO;
import org.CA.jdbc.dao.jdbc.FournisseurDAOJDBC;

import java.sql.SQLException;

public class TestUpdateDAO {
    public static void main(String[] args) {
        FournisseurDAO dao = new FournisseurDAOJDBC();
        try {
            int updatedName = dao.update("La Maison De La Peinture", "La Maison Des Peintures");
            System.out.println("Updated rows: " + updatedName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


