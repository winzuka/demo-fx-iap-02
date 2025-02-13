package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    private TextField textAddress;

    @FXML
    private TextField textMobileNo;

    @FXML
    private TextField textNic;

    @FXML
    private TextField txtName;

    Student[] student = new Student[5];
    int index = 0;

    @FXML
    void submit(ActionEvent event) {
        String address = textAddress.getText();
        String mobileNo = textMobileNo.getText();
        String nic = textNic.getText();
        String name = txtName.getText();

        Student stu = new Student(address, mobileNo, nic, name);

        student[index] = stu;

        System.out.println(stu.getName());
        System.out.println(stu.getAddress());
        System.out.println(stu.getMobileNo());
        System.out.println(stu.getNic());
        index++;

    }

}
