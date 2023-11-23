package org.CA.jdbc;

import org.CA.jdbc.dao.FournisseurDAO;
import org.CA.jdbc.dao.jdbc.FournisseurDAOJDBC;
import org.CA.jdbc.entites.Fournisseur;
import java.sql.SQLException;
import java.util.List;

public class TestSelectDAO {
    public static void main(String[] args) {
        FournisseurDAO dao = new FournisseurDAOJDBC();
        try {
            List<Fournisseur> fournisseur = dao.extraire();
            for (Fournisseur item: fournisseur){
                System.out.println(item);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
