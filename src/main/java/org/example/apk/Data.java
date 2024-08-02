package org.example.apk;

import java.sql.*;

public class Data {

    public void inserer(String id,String typev,String marque_vehicule,String Modele_véhicule){
        DatabaseConnection con=new DatabaseConnection();
        Connection conn= con.connect();
        String sql="INSERT INTO vehic(id,marque_vehicule,Modele_véhicule,typev) VALUES(?,?,?,?)" +
                "ON DUPLICATE KEY UPDATE id=VALUES(id),marque_vehicule=VALUES(marque_vehicule)," +
                "Modele_véhicule=VALUES(Modele_véhicule)" +
                ",typev=VALUES(typev)";
        try {
            PreparedStatement st= conn.prepareStatement(sql);
            st.setString(1,id);
            st.setString(2,marque_vehicule);
            st.setString(3,Modele_véhicule);
            st.setString(4,typev);
            st.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }



    public void supprimerCompte(String id) throws SQLException {
        String query = "DELETE FROM vehic WHERE id = ?";
        DatabaseConnection con=new DatabaseConnection();
        Connection conn= con.connect();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
    public void modifier(String  newMarque,String newMedel,String newType,String id) throws SQLException {
        DatabaseConnection con=new DatabaseConnection();
        Connection conn= con.connect();
        String query = "UPDATE vehic SET marque_vehicule=?,Modele_véhicule= ?,typev = ? WHERE id = ?";
        try (
              PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newMarque);
            stmt.setString(2, newMedel);
            stmt.setString(3, newType);
            stmt.setString(4, id);
            stmt.executeUpdate();
        }
    }

    public void affciher(){
        DatabaseConnection con=new DatabaseConnection();
        Connection conn= con.connect();
        String sql="SELECT * FROM vehic";
        try {
            Statement st= conn.createStatement();
            ResultSet result=st.executeQuery(sql);


                    } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
