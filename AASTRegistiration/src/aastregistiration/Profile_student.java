package aastregistiration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class Profile_student extends Application {
  
    public static void main(String [] args){
        System.out.println("DDDDDDDD");
        //launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Button("OD"));
        primaryStage.setScene(scene);
        primaryStage.show();
      }
    
}

