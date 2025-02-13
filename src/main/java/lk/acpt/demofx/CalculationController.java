package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculationController {

    @FXML
    private TextField num1;

    @FXML
    private TextField num2;

    @FXML
    private Label labelAnswer;

    int Answer = 0;
    int Answer1 = 0;
    int Answer2 = 0;
    int Answer3 = 0;
    int Answer4 = 0;
    @FXML
    int addition(ActionEvent event) {

       int number1 = Integer.parseInt(num1.getText());
       int number2 = Integer.parseInt(num2.getText());

       Answer1 = number1 + number2;
       Answer = Answer1;
       return Answer1;
    }

    @FXML
    int devide(ActionEvent event) {
        int number1 = Integer.parseInt(num1.getText());
        int number2 = Integer.parseInt(num2.getText());

        Answer2 = number1 / number2;
        Answer = Answer2;
        return Answer2;
    }

    @FXML
    void equal(ActionEvent event) {

        if(Answer == Answer1) {
            labelAnswer.setText("Answer is: "+Answer1);
        } else if (Answer == Answer2) {
            labelAnswer.setText("Answer is: "+Answer2);
        } else if (Answer == Answer3) {
            labelAnswer.setText("Answer is: "+Answer3);
        } else if (Answer == Answer4) {
            labelAnswer.setText("Answer is: "+Answer4);
        }

    }

    @FXML
    int multiple(ActionEvent event) {
        int number1 = Integer.parseInt(num1.getText());
        int number2 = Integer.parseInt(num2.getText());

        Answer3 = number1 * number2;
        Answer = Answer3;
        return Answer3;
    }

    @FXML
    int substract(ActionEvent event) {

        int number1 = Integer.parseInt(num1.getText());
        int number2 = Integer.parseInt(num2.getText());

        Answer4 = number1 - number2;
        Answer = Answer4;
        return Answer4;
    }
}
