package org.example.apk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Modifier {

    @FXML
    private TextField Type_vehicule,ID_vehicule,Marque_vehicule,modele_vehicule;
    public void modifier_vehicule(ActionEvent actionEvent) throws SQLException {

        Data data=new Data();
        data.modifier(Marque_vehicule.getText(),modele_vehicule.getText(),Type_vehicule.getText(),ID_vehicule.getText());
    }
}
