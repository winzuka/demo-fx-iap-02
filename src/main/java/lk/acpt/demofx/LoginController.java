package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

public class LoginController {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    void login(ActionEvent event) {
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        if(email.equals("admin@gmail.com") && password.equals("admin123")) {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirmation");
            confirmationAlert.setHeaderText("You Are Logged In Successfully");
            confirmationAlert.showAndWait();

        }
        else{
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning");
            warningAlert.setHeaderText("Login Failed");
            warningAlert.showAndWait();

        }
    }

}
