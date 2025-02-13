package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;

public class UpdateVehicleViewController {
    @FXML
    private TextField brandLbel;

    @FXML
    private TextField gearsLbel;

    @FXML
    private TextField idLbel;

    @FXML
    private TextField modelLbel;

    @FXML
    private TextField priceLbel;

    @FXML
    void cansel(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void search(ActionEvent event) {

        int id = Integer.parseInt(idLbel.getText());

        try {

            //load the installed driver to this class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database server and database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap2","root","root123");

            //dynamic query statement
            PreparedStatement preparedStatement = conn.prepareStatement("select * from vehicles where id=?");
            preparedStatement.setObject(1, id);

            //execute statement
            ResultSet resultSet = preparedStatement.executeQuery();

           if(resultSet.next()) {
               brandLbel.setText(resultSet.getString(2));
               modelLbel.setText(resultSet.getString(3));
               gearsLbel.setText(resultSet.getString(4));
               priceLbel.setText(resultSet.getString(5));
           }else{
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error");
           }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void update(ActionEvent event) {

        int id = Integer.parseInt(idLbel.getText());

        String brand = brandLbel.getText();
        String model = modelLbel.getText();
        int gear = Integer.parseInt(gearsLbel.getText());
        double price = Double.parseDouble(priceLbel.getText());

        try {

            //load the installed driver to this class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database server and database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap2","root","root123");

            //dynamic query statement
            PreparedStatement preparedStatement = conn.prepareStatement("update vehicles set brand=?, model=?, no_of_gears=?, price=? where id=?");
            preparedStatement.setObject(1, brand);
            preparedStatement.setObject(2, model);
            preparedStatement.setObject(3, gear);
            preparedStatement.setObject(4, price);
            preparedStatement.setObject(5, id);

            //execute statement
            int i = preparedStatement.executeUpdate();

            if(i>0) {
                System.out.println("success");
            }else{
                System.out.println("failed");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
