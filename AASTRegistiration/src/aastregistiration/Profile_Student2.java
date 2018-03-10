package aastregistiration;

import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Profile_Student2 extends Application{

    @Override
    public void start(Stage primaryStage)  {
        System.out.println("D@");
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aast_database","root","");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select user_Name,pass,first_name,last_name,Gender,date_of_birth,local_address,department,enrolled_year,Registiration from students where Registiration = "+AAST_Form.Text1);
        Label L1  = new  Label("Username :-");
        Label L2  = new  Label("Password :-");
        Label L3  = new  Label("First Name :-");
        Label L4  = new  Label("Last Name :-");
        Label L5  = new  Label("Gender :-");
        Label L6  = new  Label("DateOfBirth :-");        
        Label L7  = new  Label("Local address :-");
        Label L8  = new  Label("Departement :-");
        Label L9  = new  Label("enrolled Year :-");
        Label L10 = new  Label("Registiartion Number :-");
        TextField [] tf={new TextField(),new TextField(),new TextField(),new TextField(),new TextField(),new TextField(),new TextField(),new TextField(),new TextField(),new TextField()};
        result.next();
         tf[0].setText(result.getString(1));
         tf[1].setText(result.getString(2));
         tf[2].setText(result.getString(3));
         tf[3].setText(result.getString(4));
         tf[4].setText(result.getString(5));
         tf[5].setText(result.getString(6));
         tf[6].setText(result.getString(7));
         tf[7].setText(result.getString(8));
         tf[8].setText(result.getString(9));
         tf[9].setText(result.getString(10));
         Image image = new Image("/images/profile.jpg");
         ImageView imageview = new ImageView(image);
         imageview.setFitHeight(50);
         imageview.setFitWidth(50);
         GridPane GP = new GridPane();
         GP.add(imageview,0,0);
         GP.add(new Label("Welcome "+tf[0].getText()+" To Our Regisitration System:-"),1,0);
         GP.add(L1,0,1);
         GP.add(L2,0,2);
         GP.add(L3,0,3);
         GP.add(L4,0,4);
         GP.add(L5,0,5);
         GP.add(L6,0,6);
         GP.add(L7,0,7);
         GP.add(L8,0,8);
         GP.add(L9,0,9);
         GP.add(L10,0,10);
         //--------------\|/-------
         GP.add(tf[0],1,1);
         GP.add(tf[1],1,2);
         GP.add(tf[2],1,3);
         GP.add(tf[3],1,4);
         GP.add(tf[4],1,5);
         GP.add(tf[5],1,6);
         GP.add(tf[6],1,7);
         GP.add(tf[7],1,8);
         GP.add(tf[8],1,9);
         GP.add(tf[9],1,10);
         Button Update = new Button("  Update  ");
         Button Register = new Button("  Register  ");
         Button ViewSchedule = new Button("  View Schedule  ");
         Button Drop         = new Button("  Drop  ");
         Button pre          = new Button(" prerequist info ");
         Button TBks         = new Button("TextBooks");
         Button ListCourse   = new Button("ListCourseDI");
         Button ListCourseDP = new Button("ListCourseDP");
         Button ShowAllTaken = new Button("ShowAllTaken");
         Button Ask = new Button("Ask_For_gradutaion");
         GP.add(Update,0,11);
         GP.add(Register,1,11);
         GP.add(ViewSchedule,2,11);
         GP.add(Drop,0,12);
         GP.add(pre,1,12);
         GP.add(TBks,2,12);
         GP.add(ListCourse,0,13);
         GP.add(ListCourseDP,1,13);
         GP.add(ShowAllTaken,2,13);
         GP.add(Ask,0,14);
         Ask.setOnAction(e->{
            
            try{
                
                
                ResultSet r = statement.executeQuery("select count(Student_ID) from taken_courses where Student_ID = (Select Student_ID from students where registiration = "+AAST_Form.Text1+")");
                r.next();
                int X = Integer.parseInt(r.getString(1));
                StackPane sp = new StackPane();
                if(X>=10)
                  sp.getChildren().add(new Label("Accepted"));
                else
                  sp.getChildren().add(new Label("Refused"));     
              Scene ss = new Scene(sp);
              Stage stage = new Stage();
              stage.setScene(ss);
              stage.show();
            }catch(Exception ex){System.out.println(ex.toString());} 
             
         });
         ShowAllTaken.setOnAction(e->{
         try{
           ResultSet r = statement.executeQuery("select course_name,grade from taken_courses where Student_ID = (Select Student_ID from students where registiration = "+AAST_Form.Text1+")");
           GridPane GP2 = new GridPane();
           GP2.setHgap(50);
           GP2.setVgap(50);
           int i=0;
           while(r.next()){
            GP2.add(new Label(r.getString(1)), 0, i);
            GP2.add(new Label(r.getString(2)), 1, i);        
            i++;
           }
           Scene scene = new Scene(GP2);
           Stage s = new Stage(); 
           s.setTitle("All Taken");
           s.setScene(scene);
           s.show();
         }catch(Exception ex){System.out.println(ex.toString());}
         });
         ListCourseDP.setOnAction(e->{
           GridPane T = new GridPane();
           T.add(new Label("Day"),0,0);
           TextField Tf = new TextField();
           T.add(Tf,1,0);
           T.add(new Label("Period"),2,0);
           TextField Tf2 = new TextField();
           T.add(Tf2,3,0);
           Button Enter = new Button("Enter");
           T.add(Enter,4,0);
           Enter.setOnAction(e2 -> {
              try{
               ResultSet R = statement.executeQuery("select course_name from course where  Day = "+Tf.getText()+" And Period = "+Tf2.getText());
               int i=2;
               while(R.next()){
                 T.add(new Label(R.getString(1)),0,i);
                 i++;   
               }
              }catch(Exception ex){System.out.println(ex.toString());}
           });
          Scene scene3 = new Scene(T,500,500);
          Stage s4 = new Stage();
          s4.setScene(scene3);
          s4.setTitle("ListCourses");
          s4.show();
         });
         //------------------------------------------------------
         ListCourse.setOnAction(e->{
           GridPane T = new GridPane();
           T.add(new Label("instructor"),0,0);
           TextField Tf = new TextField();
           T.add(Tf,1,0);
           T.add(new Label("Departments"),2,0);
           TextField Tf2 = new TextField();
           T.add(Tf2,3,0);
           Button Enter = new Button("Enter");
           T.add(Enter,4,0);
           Enter.setOnAction(e2 -> {
              int i=2;
              try{
               ResultSet R = statement.executeQuery("select department_ID from departrnent where name = '"+Tf2.getText()+"'");
               R.next();
               String T1 = R.getString(1);
               ResultSet R2 = statement.executeQuery("select faculty_ID from instructor where fname = '"+Tf.getText()+"'");
               R2.next();
               String T2 = R2.getString(1);
               ResultSet R3 = statement.executeQuery("select Course_name from course where instructor_ID = "+T2+" AND department_ID = "+T1);
               
               while(R3.next()){
                 T.add(new Label(R3.getString(1)),0,i);
                 i++;   
               }
              }catch(Exception ex){T.add(new Label("null"),0,i);}
           });
          Scene scene3 = new Scene(T,400,400);
          Stage s4 = new Stage();
          s4.setScene(scene3);
          s4.setTitle("ListCourses");
          s4.show();
         });
         pre.setOnAction(e->{
            FlowPane FP = new FlowPane();             
            Label L21 = new Label("Course :-");
            TextField Tf21 = new TextField();
            String Text = Tf21.getText();
            Label L22 = new Label("Prerequist :-");
            TextField Tf22 = new TextField();
            FP.getChildren().add(L21);
            FP.getChildren().add(Tf21);
            FP.getChildren().add(L22);
            FP.getChildren().add(Tf22);
            Scene scene = new Scene(FP,500,100);
            Stage SS = new Stage();
            SS.setTitle("Pre Info");
            SS.setScene(scene);
            SS.show();
            Button BtEnter = new Button("Enter");
            FP.getChildren().add(BtEnter);
            BtEnter.setOnAction(e1->{
                try{
                  String T = "'"+Tf21.getText()+"'";
                  ResultSet R = statement.executeQuery("select Prerequisite_Courses from course where course_name = "+T);
                  R.next();
                  Tf22.setText(R.getString(1));
                }catch(Exception ex){
                System.out.println(ex.toString());
                };
             });
         });
         Drop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    ResultSet rsult = statement.executeQuery("select course_name from course where course_number in (select course_number from student_course where student_ID = (select student_ID from students where Registiration = "+tf[9].getText()+" ) ) ");
                    GridPane GP3 = new GridPane();
                    Label [] L20 = new Label[3];
                    int j=0;
                    while(rsult.next()){
                     L20[j]= new Label(rsult.getString(1));
                     GP3.add(L20[j],0,j);
                     j++;
                    }
                    if(j>0)
                    L20[0].setOnMousePressed(e2->{
                    try{
                        String text = L20[0].getText();
                        System.out.println(text);
                        statement.executeUpdate("DELETE FROM `student_course` WHERE `Course_number` = (select Course_number from course where Course_name = '"+text+"' )");
                        ResultSet RS = statement.executeQuery("select seats from course where course_name = '"+text+"'");
                        RS.next();
                        int X = Integer.parseInt(RS.getString(1));
                        X++;
                        System.out.println(X);
                        statement.executeUpdate("UPDATE `course` SET `Seats` = "+X+" WHERE `Course_name` = '"+text+"'");
                    } catch(Exception ex){};
                    
                    });
                    if(j>1)
                    L20[1].setOnMousePressed(e2->{
                    try{
                        String text = L20[1].getText();
                        statement.executeUpdate("DELETE FROM `student_course` WHERE `Course_number` = (select Course_number from course where Course_name = '"+text+"' )");
                        ResultSet RS = statement.executeQuery("select seats from course where course_name = '"+text+"'");
                        RS.next();
                        int X = Integer.parseInt(RS.getString(1));
                        X++;
                        statement.executeUpdate("UPDATE `course` SET `Seats` = "+X+" WHERE `Course_name` = '"+text+"'");
                    } catch(Exception ex){};
                    
                    });
                    if(j>2)
                    L20[2].setOnMousePressed(e2->{
                    try{
                        String text = L20[2].getText();
                        statement.executeUpdate("DELETE FROM `student_course` WHERE `Course_number` = (select Course_number from course where Course_name = '"+text+"' )");
                        ResultSet RS = statement.executeQuery("select seats from course where course_name = '"+text+"'");
                        RS.next();
                        int X = Integer.parseInt(RS.getString(1));
                        X++;
                        statement.executeUpdate("UPDATE `course` SET `Seats` = "+X+" WHERE `Course_name` = '"+text+"'");
                    } catch(Exception ex){};
                    
                    });
                    Scene ss = new Scene(GP3);
                    Stage stage = new Stage();
                    stage.setScene(ss);
                    stage.show();
                }catch(Exception ex){System.out.println(ex.toString());}
                ;
            }
        });
         ViewSchedule.setOnAction(e->{
           try {
             GridPane GP2 = new GridPane();
             GP2.setHgap(50);
             GP2.setVgap(50);
             GP2.add(new Label("Saturday"),0,1);
             GP2.add(new Label("Sunday"),0,2);
             GP2.add(new Label("Monday"),0,3);
             GP2.add(new Label("Teusday"),0,4);             
             GP2.add(new Label("Wednesday"),0,5); 
             GP2.add(new Label("Thrusday"),0,6);              
             GP2.add(new Label("Friday"),0,7);
             GP2.add(new Label("8:00"),1,0);
             GP2.add(new Label("10:00"),2,0);
             GP2.add(new Label("12:00"),3,0);
             GP2.add(new Label("2:00"),4,0);
             ResultSet rsult = statement.executeQuery("select course_name,Day,Period from course where course_number in (select course_number from student_course where student_ID = (select student_ID from students where Registiration = "+tf[9].getText()+" ) ) ");
             
             while(rsult.next()){
                 int X =Integer.parseInt(rsult.getString(3));
                 if(X==8)
                     X=1;
                 else if(X==10)
                     X=2;
                 else if(X==12)
                     X=3;
                 else X=4;
                 GP2.add(new Label(rsult.getString(1)),Integer.parseInt(rsult.getString(2)),X);
             
             }
             Scene s3 = new Scene(GP2,600,600);
             Stage S3 = new Stage();
             S3.setTitle("Schedule");
             S3.setScene(s3);
             S3.show();
           } catch (SQLException ex) {System.out.println(ex.toString());};
         });
         Update.setOnAction(e -> {
             
        String T1 = tf[0].getText();
        String T2 = tf[1].getText();
        String T3 = tf[2].getText();
        String T4 = tf[3].getText();//yy/mm//dd
        String T5 = tf[4].getText();
        String T6 = tf[5].getText();
        String T7 = tf[6].getText();
        String T8 = tf[7].getText();
        String T9 = tf[8].getText();
        String T10 = tf[9].getText();
        try{
        ResultSet r = statement.executeQuery("select Student_ID from students where registiration = "+AAST_Form.Text1);
        r.next();
        statement.executeUpdate("UPDATE `students` SET `user_Name` = '"+T1+"',`pass` = '"+T2+"',`first_Name` = '"+T3+"',`last_Name` = '"+T4+"',`Gender` = '"+T5+"',`date_of_birth` = '"+T6+"',`local_address` = '"+T7+"',`department` = '"+T8+"',`enrolled_year` = '"+T9+"',`Registiration` = '"+T10+"' where Student_ID = "+r.getString(1));
        }catch(Exception Ex){System.out.println(Ex.toString());}; 
        });
         Register.setOnAction(e->{
            try {
                ResultSet res = statement.executeQuery("select Count(*) From student_course where Student_ID = (select Student_ID from Students where Registiration = "+tf[9].getText()+")");
                res.next();
                int X = Integer.parseInt(res.getString(1));
                //System.out.println(x);
                if(X>=3){
                    GridPane v = new GridPane();
                    Label Temp = new Label("    YOU Registired Max Courses   ");
                    Button close = new Button("  close  ");
                    v.add(Temp,0,0);
                    v.add(close,1,4);
                    ResultSet s2 = statement.executeQuery("select Course_name from course where course_number in (select course_number from student_course where student_ID = (select student_ID from Students where  registiration = "+tf[9].getText()+" ))");
                    int i=1; 
                    while(s2.next()){
                        v.add(new Label("  "+s2.getString(1)),0,i);
                        i++;
                    };
                    Scene scene = new Scene(v);
                    Stage s = new Stage();
                    s.setScene(scene);
                    s.setTitle("Invalid_Case");
                    s.show();
                    close.setOnAction( new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent event) {
                         s.close();
                        }
                      });
                }else {
                    
                   // BorderPane BP = new BorderPane();
                    FlowPane FP = new FlowPane();
                    FP.getChildren().add(new Label("Course_Name :-"));
                    TextField Tf = new TextField();
                    FP.getChildren().add(Tf);
                    Button Enter = new Button("Enter");
                    FP.getChildren().add(Enter);
                    Scene scene = new Scene(FP);
                    Stage stage = new Stage();
                    stage.setTitle("Register :-");
                    stage.setScene(scene);
                    stage.show();
                    Enter.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                      try{
                    ResultSet s = statement.executeQuery("select Prerequisite_Courses from course where Course_name = '"+Tf.getText()+"'");
                    s.next();
                    String Prequest=s.getString(1);
                    int ff=0;
                    if(Prequest.compareTo("None")==0){ff=1;}
                    s = statement.executeQuery("select Course_name from course where course_number in (select course_number from student_course where student_ID = (select student_ID from Students where  registiration = "+tf[9].getText()+" ))");
                    String text = "'"+Tf.getText()+"'";
                    //--------------------------------------------------------------------------------------
                    int f = 0;
                    while(s.next()){
                        if(s.getString(1)==text)
                            f=1;
                        if(Prequest.compareTo(s.getString(1))==0)
                            ff=1; 
                    }
                    s = statement.executeQuery("select seats from course where course_name = "+text);
                    //--------------------------------------------------------------------------------------
                    s.next();
                    int XX = Integer.parseInt(s.getString(1));
                    if(XX<=0)
                        f=1;
                    System.out.println(ff+" "+Prequest);
                    
                    if(f==1){
                    GridPane v = new GridPane();
                    Label Temp = new Label("    YOU Registired Max Courses   ");
                    Button close = new Button("  close  ");
                    v.add(Temp,0,0);
                    v.add(close,1,4);
                    Scene scene2 = new Scene(v);
                    Stage s2 = new Stage();
                    s2.setScene(scene);
                    s2.setTitle("Invalid_Case");
                    s2.show();
                    close.setOnAction( new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent event) {
                         s2.close();
                        }
                      });
                    }
                    else if(ff==1) {
                     ff=0;   
                     s = statement.executeQuery("select course_number from course where course_name = "+text);
                     s.next();
                     String Q1 = s.getString(1);
                     s = statement.executeQuery("select Student_ID from students where registiration = "+tf[9].getText());
                     s.next();
                     String Q2 = s.getString(1);
                     statement.executeUpdate("INSERT INTO `student_course` (`Student_ID`, `Course_number`) values ('"+Q2+"','"+Q1+"')");
                     
                     s = statement.executeQuery("select Seats from course where course_name = "+text);
                     s.next();
                     int Y = Integer.parseInt(s.getString(1));
                     Y--;
                     String T= Y+"";
                     statement.executeUpdate("UPDATE `course` SET `Seats` = '"+T+"' WHERE `Course_name` = "+text);
                    }
                     stage.close();
                      }catch(Exception ex){System.out.println(ex.toString());};
                  };         
             });
                         }
            } catch (Exception ex) {System.out.println(ex.toString());}
            
         });
         GP.setHgap(10);
         GP.setVgap(10);
         Scene scene = new Scene(GP,500,500);
         primaryStage.setTitle("Profile_Student");
         primaryStage.setScene(scene);
         primaryStage.show();                 
      }catch(Exception e){System.out.println(e.toString());}  
    }
}
