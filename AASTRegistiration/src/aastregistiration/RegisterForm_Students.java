package aastregistiration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RegisterForm_Students extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane GP = new GridPane();
        Label L1  = new Label("First Name :-");
        Label L2  = new Label("Last Name :-");
        Label L3  = new Label("Gender :-");
        Label L4  = new Label("DateOfBirth :-");        
        Label L5  = new Label("Local address :-");
        Label L6  = new Label("Departement :-");
        Label L7  = new Label("enrolled Year :-");
        Label L8  = new Label("Username :-");
        Label L9  = new Label("Registiartion Number :-");
        Label L10  = new Label("Password :-");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        TextField tf5 = new TextField();
        TextField tf6 = new TextField();
        TextField tf7 = new TextField();
        TextField tf8 = new TextField();
        TextField tf9 = new TextField();
        TextField tf10 = new TextField();
        Image image = new Image("/images/student-portal_icon.png");
        ImageView imageview = new ImageView(image);
        GP.add(L1,1,1);
        GP.add(L2,1,2);
        GP.add(L3,1,3);
        GP.add(L4,1,4);
        GP.add(L5,1,5);
        GP.add(L6,1,6);
        GP.add(L7,1,7);
        GP.add(L8,1,8);
        GP.add(L9,1,9);
        GP.add(L10,1,10);
        //------------------------
        GP.add(tf1,2,1);
        GP.add(tf2,2,2);
        GP.add(tf3,2,3);
        GP.add(tf4,2,4);
        GP.add(tf5,2,5);
        GP.add(tf6,2,6);
        GP.add(tf7,2,7);
        GP.add(tf8,2,8);
        GP.add(tf9,2,9);
        GP.add(tf10,2,10);
        //--------------------------
        GP.add(imageview,2,0);
        GP.setHgap(5);
        GP.setVgap(5);
        Button New_Student = new Button("New_Student");
        GP.add(New_Student,2,11);
        New_Student.setOnAction(e -> {
        String T1 = tf1.getText();
        String T2 = tf2.getText();
        String T3 = tf3.getText();
        String T4 = tf4.getText();//yy/mm//dd
        String T5 = tf5.getText();
        String T6 = tf6.getText();
        String T7 = tf7.getText();
        String T8 = tf8.getText();
        String T9 = tf9.getText();
        String T10 = tf10.getText();
        //System.out.println(T4+" "+T6);     
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aast_database","root","");
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO `students` (  `first_name`, `last_name`, `Gender`, `date_of_birth`, `local_address`, `department`, `enrolled_year`,`user_Name`, `Registiration` ,`pass`) VALUES ('"+T1+"', '"+T2+"', '"+T3+"', '"+T4+"', '"+T5+"', '"+T6+"', '"+T7+"', '"+T8+"', '"+T9+"', '"+T10+"');");
                primaryStage.close();
                AAST_Form AF = new AAST_Form();
                AF.start(new Stage());
            } catch (Exception ex) {System.out.println(ex.toString());}
        });
        Scene scene = new Scene(GP,500,570);
        primaryStage.setTitle("Rigster Student");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String [] args){
        launch();
    }
    
}
