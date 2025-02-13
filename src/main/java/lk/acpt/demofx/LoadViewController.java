package lk.acpt.demofx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadViewController implements Initializable {
    @FXML
    private TableView<Vehicle> tblVehicle;

   public ArrayList<Vehicle> loadData(){
        try {

                //load the installed driver to this class
                Class.forName("com.mysql.cj.jdbc.Driver");

                //create a connection with database server and database
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap2","root","root123");

                //dynamic query statement
                PreparedStatement preparedStatement = conn.prepareStatement("select * from vehicles");
            ArrayList<Vehicle> list = new ArrayList<>();
                //execute statement
                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()) {

                    Vehicle vehicle = new Vehicle();

                    vehicle.setId(resultSet.getInt(1));
                    vehicle.setBrand(resultSet.getString(2));
                    vehicle.setModel(resultSet.getString(3));
                    vehicle.setGear(Integer.parseInt(resultSet.getString(4)));
                    vehicle.setPrice(Double.parseDouble(resultSet.getString(5)));

                    list.add(vehicle);
                }
                return list;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void load(ActionEvent event) {

    }
        //fx table config

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gear"));
        tblVehicle.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        ArrayList<Vehicle> vehicles = loadData();
        tblVehicle.setItems(FXCollections.observableArrayList(vehicles));
    }

    public void getValues(){
       //just make a function to commit
    }

    public void getDetails(){
        //just make a function to commit Details
    }

    public void getVehicleBrand(){
        //just make a function to commit Vehicle Brand
        System.out.println("Edited the function");
    }
}
