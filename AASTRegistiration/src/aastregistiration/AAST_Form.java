package aastregistiration;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class AAST_Form extends Application{
    static String Text1="",Text2="";
    @Override
    public void start(Stage p) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aast_database","root","");
        Statement statement = connection.createStatement();
//        statement.executeUpdate("create table Students ( user_Name char(20) , pass integer , student_ID integer, first_name char(100),last_name char(100) ,Gender char(100) , date_of_birth date, local_address char(100) , department char(11), enrolled_year integer , CONSTRAINT pk PRIMARY KEY (student_ID) );");
//        statement.executeUpdate("create table Instructor ( faculty_ID integer , Instructor_department char(22) , CONSTRAINT pk PRIMARY KEY (faculty_ID,Instructor_department));");
//        statement.executeUpdate("create table Departrnent ( department_ID integer,name char(22),faculty_Name char(22) , CONSTRAINT pk PRIMARY KEY(department_ID , faculty_Name) );");
//        statement.executeUpdate("create table Course ( Course_number integer ,Course_name char(20) , Instructor_ID integer , Department_ID integer , Term integer , Credits integer , Classroom integer, Periods integer , Prerequisite_Courses char(20) , CONSTRAINT pk PRIMARY KEY ( Course_number,Prerequisite_Courses) )");
//        statement.executeUpdate("create table Student_Course ( Course_number integer , Student_ID integer, PRIMARY KEY (Course_number,Student_ID) ");
        ///-------------------------------------------------------------------------------------------------------------
        Image image = new Image("/images/4.png");
        ImageView imageview = new ImageView(image);
        BorderPane bp = new BorderPane();
        bp.setCenter(imageview);
        GridPane gp = new GridPane();
        Label L1 = new Label("Registiration Number:-");
        Label L2 = new Label("Password :-");
        Label L3 = new Label("TYPE :-");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        Button btSignIn = new Button("Sign in");
        Button btSignUp = new Button("Sign Up");
        btSignIn.setOnAction((e)->{
        Text1 = "'"+tf1.getText()+"'";
        Text2 = tf2.getText();
        String Text3 = tf3.getText();
        String Query2 = "select pass From Students where Registiration = "+Text1;
        String Query3 = "select pass From instructor where Registiration = "+Text1;
        if(Text3.compareTo("Student")==0){
          try {
                ResultSet resultset = statement.executeQuery(Query2);
                 resultset.next();
                 String X = resultset.getString(1);
                 System.out.println(X); 
                 p.close();
                 if(X.compareTo(Text2)!=0)
                    {
                         FalseValid F = new FalseValid();
                         F.start(new Stage());
                    } else {
                         System.out.println("DD");
                       Profile_Student2 PS = new Profile_Student2();
                       PS.start(new Stage());
                  }
            } catch (SQLException ex){
              //    System.out.println(ex.toString());        
                        p.close();
                        Stage Temp = new Stage();
                        FalseValid F = new FalseValid();
              try {
                   F.start(Temp);
               } catch (Exception ex1) {}
            }
              catch (Exception ex) {}
        }else if(Text3.compareTo("Instructor")==0){
            try {
                 ResultSet resultset = statement.executeQuery(Query3);
                 resultset.next();
                 String X = resultset.getString(1);
             //    System.out.println(X); 
                 p.close();
                 if(X.compareTo(Text2)!=0)
                    {
                         False_instructor F2 = new False_instructor();
                         F2.start(new Stage());
                    } else {
                       Profile_instructor PS2 = new Profile_instructor();
                       PS2.start(new Stage());
                  }
            } catch (SQLException ex){
//                        p.close();
//                        Stage Temp = new Stage();
//                        FalseValid F = new FalseValid();
//              try {
//                   F.start(Temp);
//               } catch (Exception ex1) {}
            }
              catch (Exception ex) {}
        }
        });
        gp.add(L1,0,0);
        gp.add(L2,0,1);
        gp.add(tf1,1,0);
        gp.add(tf2,1,1);
        gp.add(L3,0,2);
        gp.add(tf3,1,2);
        //gp.add(btSignUp, 0, 3);
        gp.add(btSignIn, 1, 3);
        gp.setHgap(10);
        gp.setVgap(10);
        bp.setBottom(gp);
        bp.setPadding(new Insets(0,0,10,20));
        Scene scene = new Scene(bp,400,400);
        p.setTitle("AAST_Register");
        p.setScene(scene);
        p.show();
    }
    public static void main(String [] args){
        launch();
    }
}
