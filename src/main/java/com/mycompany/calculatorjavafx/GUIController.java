package com.mycompany.calculatorjavafx;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
    * JavaFX App
    * DarkWizard
 */
public class GUIController implements Initializable {

    @FXML
    private Label result;
    @FXML
    private Label prevnumber;
    @FXML
    private Button btnexit;
    @FXML
    private Button clear;

    private double num1 = 0;
    private double total = 0;
    private String operator = "";
    private boolean checking = true;

    public Double create(double num1, double num2, String operator) {

        switch (operator) {
            case "+":
                return (num1 + num2);
            case "-":
                return (num1 - num2);
            case "*":
                return (num1 * num2);
            case "/":
                if (num2 == 0) {
                    prevnumber.setText("ERROR");
                }
                return (num1 / num2);
            default:
                break;
        }
        return 0.0;
    }

    public void number(String number) {
        result.setText(result.getText() + number);
    }

    public void prevNumber(String number) {
        prevnumber.setText(prevnumber.getText() + number);
    }

    public void prevOperator(String operator) {
        prevnumber.setText(prevnumber.getText() + " " + operator + " ");
    }

    public void Process(ActionEvent event) {

        if (checking) {

            result.setText("");
            prevnumber.setText("");

            checking = false;
        }

        Button button = (Button) event.getSource();
        String value = button.getText();

        number(value);
        prevNumber(value);
    }

    public void operationsProcess(ActionEvent event) {

        Button button = (Button) event.getSource();
        String value = button.getText();

        if (!value.equals("=")) {

            if (!operator.isEmpty()) {
                return;
            }

            operator = value;
            prevOperator(operator);

            //num1 parseDouble
            num1 = Double.parseDouble(result.getText());
            result.setText("");

        } else {

            if (operator.isEmpty()) {
                return;
            }

            double num2 = Double.parseDouble(result.getText());

            total = create(num1, num2, operator);

            result.setText(String.valueOf(total));

            operator = "";
            checking = true;

        }

    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void clear(ActionEvent event) {
        if (event.getSource() == clear) {

            result.setText("0");
            prevnumber.setText("");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
