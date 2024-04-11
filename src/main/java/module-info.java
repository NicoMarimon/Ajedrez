module com.example.practica_ajedrez {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica_ajedrez to javafx.fxml;
    exports com.example.practica_ajedrez;
}