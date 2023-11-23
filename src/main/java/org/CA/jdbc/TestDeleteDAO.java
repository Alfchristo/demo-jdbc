package org.CA.jdbc;

import org.CA.jdbc.dao.FournisseurDAO;
import org.CA.jdbc.dao.jdbc.FournisseurDAOJDBC;
import org.CA.jdbc.entites.Fournisseur;

import java.sql.SQLException;

public class TestDeleteDAO {
    public static void main(String[] args) {
        FournisseurDAO dao = new FournisseurDAOJDBC();
        try {
            dao.delete(new Fournisseur("La Maison Des Peintures"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
