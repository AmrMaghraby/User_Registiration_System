package aastregistiration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class False_instructor extends Application {

    public void start(Stage primaryStage) throws Exception {
        GridPane GP = new GridPane();
        Label L1 = new Label("First Name :-");
        Label L2 = new Label("Last Name :-");
        Label L3 = new Label("Gender :-");
        Label L4 = new Label("Email :-");
        Label L5 = new Label("Local address :-");
        Label L6 = new Label("Username :-");
        Label L7 = new Label("Registiartion Number :-");
        Label L8 = new Label("Password :-");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        TextField tf5 = new TextField();
        TextField tf6 = new TextField();
        TextField tf7 = new TextField();
        TextField tf8 = new TextField();
        GP.add(L1, 0, 0);
        GP.add(L2, 0, 1);
        GP.add(L3, 0, 2);
        GP.add(L4, 0, 3);
        GP.add(L5, 0, 4);
        GP.add(L6, 0, 5);
        GP.add(L7, 0, 6);
        GP.add(L8, 0, 7);
        //------------------------------------
        GP.add(tf1, 1, 0);
        GP.add(tf2, 1, 1);
        GP.add(tf3, 1, 2);
        GP.add(tf4, 1, 3);
        GP.add(tf5, 1, 4);
        GP.add(tf6, 1, 5);
        GP.add(tf7, 1, 6);
        GP.add(tf8, 1, 7);
        Button Reg = new Button("Register");
        Button More = new Button("Departements");
        Button Close = new Button("Close");
        GP.add(Reg, 0, 9);
        GP.add(More, 1, 9);
        GP.add(Close, 2, 9);
        More.setOnAction(e -> {

            FlowPane FP = new FlowPane();
            Label L22 = new Label("Departements");
            TextField Tf11 = new TextField();
            Button OK = new Button("OK");
            OK.setOnAction(e5 -> {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aast_database", "root", "");
                    Statement statement = connection.createStatement();
                    ResultSet r = statement.executeQuery("select department_ID from departrnent where name = '" + Tf11.getText() + "'");
                    r.next();
                    statement.executeUpdate("INSERT INTO `inst_dept` ( `Depar_ID`, `Instructor_ID`) VALUES ( " + Integer.parseInt(r.getString(1)) + ", 105);");

                } catch (ClassNotFoundException ex) {
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
            });
            FP.getChildren().add(L22);
            FP.getChildren().add(Tf11);
            FP.getChildren().add(OK);
            Scene scene = new Scene(FP);
            Stage stage = new Stage();
            stage.setTitle("More");
            stage.setScene(scene);
            stage.show();

        });
        Close.setOnAction(e -> {
            primaryStage.close();
        });
        Reg.setOnAction(e -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aast_database", "root", "");
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO `instructor` (`faculty_ID`, `Fname`, `Lname`, `Gender`, `Email`, `Local address`, `User_Name`, `Registiration`, `pass`) VALUES ('105', '" + tf1.getText() + "', '" + tf2.getText() + "', '" + tf3.getText() + "', '" + tf4.getText() + "', '" + tf5.getText() + "', '" + tf6.getText() + "', '" + tf7.getText() + "', '" + tf8.getText() + "');");

            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        });
        Scene scene = new Scene(GP);
        primaryStage.setTitle("Register");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}
