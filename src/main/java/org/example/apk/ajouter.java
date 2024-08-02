package org.example.apk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ajouter {
    @FXML
    private Label type,id,marque,modele;

    @FXML
    private Button valider_ajout, supprimer;

    @FXML
    private TextField idV;

    @FXML
    private TextField Type_vehicule,ID_vehicule,Marque_vehicule,modele_vehicule;

    public void ajout_enregistrer(ActionEvent actionEvent) {
        Data data=new Data();
        data.inserer(ID_vehicule.getText(), Type_vehicule.getText(), Marque_vehicule.getText(), modele_vehicule.getText());
        Stage stage=(Stage) ((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        stage.close();

    }



    public void suprimer_vehicule(ActionEvent actionEvent) throws SQLException {
        Data data=new Data();
        data.supprimerCompte(idV.getText());
        Stage stage=(Stage) ((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
