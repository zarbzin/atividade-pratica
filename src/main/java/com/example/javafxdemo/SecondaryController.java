package com.example.javafxdemo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SecondaryController {

  @FXML
  private Button btnBack;

  @FXML
  private void switchToPrimary() {
    try {
      Stage stage = (Stage) btnBack.getScene().getWindow();
      stage.close();

      Stage primaryStage = new Stage();
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Primary.fxml"));
      Parent root = loader.load();
      primaryStage.setScene(new Scene(root));
      primaryStage.setTitle("Primary Window");
      primaryStage.show();
    } catch (Exception e) {
      showAlert("Error", "Failed to open primary window.");
      e.printStackTrace();
    }
  }

  private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
