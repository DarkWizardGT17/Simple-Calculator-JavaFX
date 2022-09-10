/*
    * JavaFX App
    * DarkWizard
*/
module com.mycompany.simplecalculatormaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.calculatorjavafx to javafx.fxml;
    exports com.mycompany.calculatorjavafx;
}
