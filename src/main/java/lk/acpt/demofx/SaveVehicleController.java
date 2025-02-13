package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveVehicleController {

    @FXML
    private TextField brandLabel;

    @FXML
    private TextField gearLabel;

    @FXML
    private TextField modelLabel;

    @FXML
    private TextField priceLabel;

    @FXML
    void canselSaveData(ActionEvent event) {
            System.exit(0);
    }

    @FXML
    void saveData(ActionEvent event) {
        String brand = brandLabel.getText();
        String model = modelLabel.getText();
        int gear = Integer.parseInt(gearLabel.getText());
        double price = Double.parseDouble(priceLabel.getText());

        try {

            //load the installed driver to this class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database server and database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap2","root","root123");

            //dynamic query statement
            PreparedStatement preparedStatement = conn.prepareStatement("insert into vehicles(brand,model,no_of_gears,price) values(?,?,?,?)");
            preparedStatement.setObject(1, brand);
            preparedStatement.setObject(2, model);
            preparedStatement.setObject(3, gear);
            preparedStatement.setObject(4, price);

            //execute statement
            int i = preparedStatement.executeUpdate();

            if(i>0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successfully Saved Vehicle");
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
