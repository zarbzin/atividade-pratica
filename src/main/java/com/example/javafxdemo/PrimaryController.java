package com.example.javafxdemo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    private Button btnOpenSecondary;

    @FXML
    private void switchToSecondary() {
        try {
            Stage stage = (Stage) btnOpenSecondary.getScene().getWindow();
            stage.close();
            
            Stage secondaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Secondary.fxml"));
            Parent root = loader.load();
            secondaryStage.setScene(new Scene(root));
            secondaryStage.setTitle("Secondary Window");
            secondaryStage.show();
        } catch (Exception e) {
            showAlert("Error", "Failed to open secondary window.");
            e.printStackTrace();
        }
    }

    private void showAlert(String string, String string2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showAlert'");
    }

}

