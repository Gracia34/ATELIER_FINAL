package org.example.apk;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Lister implements Initializable {

    @FXML
    private TableView<Enregistrement> table;
    @FXML
    private TableColumn<Enregistrement, String> idch;
    @FXML
    private TableColumn<Enregistrement, String> marqch;
    @FXML
    private TableColumn<Enregistrement, String> modch;
    @FXML
    private TableColumn<Enregistrement, String> typch;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    afficher();
    }

    public void afficher() {
        ObservableList<Enregistrement> ligne = FXCollections.observableArrayList();
        DatabaseConnection con = new DatabaseConnection();
        Connection conn = con.connect();
        String sql = "SELECT * FROM vehic";
        try {
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                String id = result.getString(1);
                String marque = result.getString(2);
                String modele = result.getString(3);
                String type = result.getString(4);
                ligne.add(new Enregistrement(id, marque, modele, type));
            }
            idch.setCellValueFactory(new PropertyValueFactory<>("id"));
            marqch.setCellValueFactory(new PropertyValueFactory<>("marque"));
            modch.setCellValueFactory(new PropertyValueFactory<>("modele"));
            typch.setCellValueFactory(new PropertyValueFactory<>("type"));
            table.setItems(ligne);
        } catch (Exception e) {
            // Handle the exception appropriately (e.g., log or show an error message)
            e.printStackTrace();
        }
    }

    public void aceuil(ActionEvent actionEvent) {
        Stage stage=(Stage) ((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
