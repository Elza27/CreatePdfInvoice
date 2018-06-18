package sample;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void closeAll(ActionEvent event){
        Platform.exit();
        System.exit(0);
    }


    public void newVAT(ActionEvent event) throws IOException {
        Parent fParent = FXMLLoader.load(getClass().getResource("fvat.fxml"));
        Scene fScene = new Scene(fParent, 650, 600);
        Stage appStage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(fScene);
        appStage.show();
    }

}
