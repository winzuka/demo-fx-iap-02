package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteVehicleViewController {
    @FXML
    private TextField idLabel;

    @FXML
    void deleteData(ActionEvent event) {

        int id = Integer.parseInt(idLabel.getText());

        try {

            //load the installed driver to this class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database server and database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap2","root","root123");

            //dynamic query statement
            PreparedStatement preparedStatement = conn.prepareStatement("delete from vehicles where id=?");
            preparedStatement.setObject(1, id);

            //execute statement
            int i = preparedStatement.executeUpdate();

            if(i>0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("alert");
                alert.setHeaderText("Successfully Deleted Vehicle");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failed");
                alert.showAndWait();
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
