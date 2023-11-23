package org.CA.jdbc.dao.jdbc;

import org.CA.jdbc.dao.FournisseurDAO;
import org.CA.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDAOJDBC implements FournisseurDAO {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        System.out.println("Bloc static");
        ResourceBundle bundle = ResourceBundle.getBundle(
                "database");
        DB_URL= bundle.getString("db.url");
        DB_USER = bundle.getString( "db.user");
        DB_PWD = bundle.getString ("db.password");
    }

    private static final String INSERT_QUERY = "INSERT INTO fournisseur (NOM) VALUES ('%s')";

    @Override
    public List<Fournisseur> extraire() throws SQLException {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        try(Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM FOURNISSEUR")){
            while(rs.next()) {
                int id = rs.getInt("ID");
                String nom = rs.getString("NOM");
                Fournisseur itemFournisseur = new Fournisseur(id, nom);
                fournisseurs.add(itemFournisseur);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fournisseurs;
    }

    @Override
    public void insert(Fournisseur fournisseurACreer) throws SQLException {
        try(Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            Statement st = cnx.createStatement()){
            st.executeUpdate(String.format(INSERT_QUERY, fournisseurACreer.getNom()));
        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) {
        try
            (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            Statement st = cnx.createStatement()){
            st.executeUpdate("UPDATE FOURNISSEUR SET nom = 'Exemple' WHERE id = 4");
            } catch (SQLException e) {
            System.out.println("Attention : " + e.getMessage());
        }
        return Integer.parseInt(nouveauNom);
    }


    @Override
    public boolean delete(Fournisseur fournisseur) {
        return false;
    }
}
