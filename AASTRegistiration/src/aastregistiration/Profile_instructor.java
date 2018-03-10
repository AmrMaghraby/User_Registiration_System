package aastregistiration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Profile_instructor extends Application {
    @Override
    public void start(Stage primaryStage)  {
        System.out.println("D@");
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aast_database","root","");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select Fname,lname,Gender,email,`local address`,user_Name,Registiration,pass from instructor where Registiration = "+AAST_Form.Text1);
        Label L1  = new  Label("First Name :-");
        Label L2  = new  Label("Last Name :-");
        Label L3  = new  Label("Gender :-");
        Label L4  = new  Label("email :-");
        Label L5  = new  Label("Local address :-");
        Label L6  = new  Label("Username :-");
        Label L7 =  new  Label("Registiartion Number :-");
        Label L8  = new  Label("Password :-");
        
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
         Image image = new Image("/images/profile.jpg");
         ImageView imageview = new ImageView(image);
         imageview.setFitHeight(50);
         imageview.setFitWidth(50);
         GridPane GP = new GridPane();
         GP.add(imageview,0,0);
         GP.add(new Label("Welcome Instructor "+tf[0].getText()+" To Our Regisitration System:-"),1,0);
         GP.add(L1,0,1);
         GP.add(L2,0,2);
         GP.add(L3,0,3);
         GP.add(L4,0,4);
         GP.add(L5,0,5);
         GP.add(L6,0,6);
         GP.add(L7,0,7);
         GP.add(L8,0,8);
         //--------------/|\-------
         GP.add(tf[0],1,1);
         GP.add(tf[1],1,2);
         GP.add(tf[2],1,3);
         GP.add(tf[3],1,4);
         GP.add(tf[4],1,5);
         GP.add(tf[5],1,6);
         GP.add(tf[6],1,7);
         GP.add(tf[7],1,8);
         Button Update = new Button("  Update  ");
         Button ViewStudent = new Button("  ViewStudents  ");
         Button ViewSchedule = new Button("  View Schedule  ");
         Button CourseDetails = new Button(" CourseDetails ");
         Button AddCourse = new Button("AddCourse");
         GP.add(Update,0,9);
         GP.add(ViewStudent,0,10);
         GP.add(ViewSchedule,1,9);
         GP.add(CourseDetails,1,10);
         GP.add(AddCourse,1,12);
         Update.setOnAction(e->{
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
            
        ResultSet r = statement.executeQuery("select faculty_ID from instructor where registiration = "+AAST_Form.Text1);
        r.next();
        statement.executeUpdate("UPDATE `instructor` SET `Fname` = '"+T1+"',`lname` = '"+T2+"',`gender` = '"+T3+"',`email` = '"+T4+"',`local address` = '"+T5+"',`User_Name` = '"+T6+"',`Registiration` = "+T7+",`pass` = "+T8+" where faculty_ID = "+r.getString(1));
        }catch(Exception Ex){System.out.println(Ex.toString());};
        });
         AddCourse.setOnAction(e->{
           Label L30 = new Label("Course Name :-"); 
           //Label L31 = new Label("Course Number :-");
           Label L32 = new Label("Class Capcity :-");
           Label L33 = new Label("Class room :-");
           Label L34 = new Label("Credits :-");
           Label L35 = new Label("Departement Name :-");
           Label L36 = new Label("Instructor ID :-");
           Label L37 = new Label("Periods :-");
           Label L38 = new Label("Prerequist Course :-");
           Label L39 = new Label("Seats :-");
           Label L40 = new Label("Term :-");
           Label L41 = new Label("TextBook :-");
           Label L42 = new Label("Day :-");
           Label L43 = new Label("Period :-");
           TextField Tf30 = new TextField();
           //TextField Tf31 = new TextField();
           TextField Tf32 = new TextField();
           TextField Tf33 = new TextField();
           TextField Tf34 = new TextField();
           TextField Tf35 = new TextField();
           TextField Tf36 = new TextField();
           TextField Tf37 = new TextField();
           TextField Tf38 = new TextField();
           TextField Tf39 = new TextField();
           TextField Tf40 = new TextField();
           TextField Tf41 = new TextField();  
           TextField Tf42 = new TextField();
           TextField Tf43 = new TextField();
            GridPane V = new GridPane();
            V.add(L30,0,0);
            //V.add(L31,0,1);
            V.add(L32,0,2);
            V.add(L33,0,3);
            V.add(L34,0,4);
            V.add(L35,0,5);
            V.add(L36,0,6);
            V.add(L37,0,7);
            V.add(L38,0,8);
            V.add(L39,0,9);
            V.add(L40,0,10);
            V.add(L41,0,11);
            V.add(L42,0,12);
            V.add(L43,0,13);
            V.add(Tf30,1,0);
            //V.add(Tf31,1,1);
            V.add(Tf32,1,2);
            V.add(Tf33,1,3);
            V.add(Tf34,1,4);
            V.add(Tf35,1,5);
            V.add(Tf36,1,6);
            V.add(Tf37,1,7);
            V.add(Tf38,1,8);
            V.add(Tf39,1,9);
            V.add(Tf40,1,10);
            V.add(Tf41,1,11);
            V.add(Tf42,1,12);
            V.add(Tf43,1,13);
            Button Reg = new Button("Reg");
            V.add(Reg,1,14);
            
            Scene S50 = new Scene(V);
            Stage S = new Stage();
            S.setTitle("YARAB");
            S.setScene(S50);
            S.show();
            Reg.setOnAction(e2->{
                
            //String T1 = Tf31.getText();
            String T2 = Tf30.getText();
            String T3 = Tf36.getText();
            String T4 = Tf35.getText();//yy/mm//dd
            String T5 = Tf40.getText();
            String T6 = Tf34.getText();
            String T7 = Tf33.getText();
            String T8 = Tf37.getText();
            String T9 = Tf38.getText();
            String T10= Tf39.getText();
            String T11= Tf41.getText();
            String T12= Tf32.getText();
            String T13= Tf42.getText();
            String T14= Tf43.getText();
                         try{
                           ResultSet r = statement.executeQuery("Select faculty_ID from instructor where Registiration = "+AAST_Form.Text1);
                           r.next();
                           String Instructor_ID = r.getString(1);
                           r = statement.executeQuery("Select Department_ID from departrnent where name = '"+T4+"'");
                           r.next();
                           statement.executeUpdate("INSERT INTO `course` ( `Course_name`, `Instructor_ID`, `Department_ID`, `Term`, `Credits`, `Classroom`, `Periods`, `Prerequisite_Courses`, `Seats`, `TextBooks`, `Class_Capacity`, `Day`, `Period`) VALUES ( '"+T2+"', "+Instructor_ID+", "+r.getString(1)+", "+T5+", "+T6+", "+T7+", "+T8+", '"+T9+"', "+T10+", '"+T11+"', "+T12+", "+T13+", "+T14+");");
                           S.close();
                         }catch(Exception Ex){System.out.println(Ex.toString());}
            
            });
              
         });
        CourseDetails.setOnAction(e2->{
         try{
          FlowPane FP = new FlowPane();
          FP.getChildren().add(new Label(""));
          FP.getChildren().add(new Label("Course"));
          TextField TFF = new TextField();
          FP.getChildren().add(TFF);
          Button Retrive = new Button("Retrive");
          FP.getChildren().add(Retrive);
          Scene S5 = new Scene(FP);
          Stage S6 =new Stage();
          S6.setScene(S5);
          S6.show();
          Retrive.setOnAction(e->{
           try{
           Label L30 = new Label("Course Name :-"); 
           //Label L31 = new Label("Course Number :-");
           Label L32 = new Label("Class Capcity :-");
           Label L33 = new Label("Class room :-");
           Label L34 = new Label("Credits :-");
           Label L35 = new Label("Departement ID :-");
           Label L36 = new Label("Instructor ID :-");
           Label L37 = new Label("Periods :-");
           Label L38 = new Label("Prerequist Course :-");
           Label L39 = new Label("Seats :-");
           Label L40 = new Label("Term :-");
           Label L41 = new Label("TextBook :-");
           TextField Tf30 = new TextField();
           TextField Tf31 = new TextField();
           TextField Tf32 = new TextField();
           TextField Tf33 = new TextField();
           TextField Tf34 = new TextField();
           TextField Tf35 = new TextField();
           TextField Tf36 = new TextField();
           TextField Tf37 = new TextField();
           TextField Tf38 = new TextField();
           TextField Tf39 = new TextField();
           TextField Tf40 = new TextField();
           TextField Tf41 = new TextField();  
               
           ResultSet r = statement.executeQuery("select * from course where course_name = '"+TFF.getText()+"'");
           r.next();
           Tf30.setText(r.getString(2));
           Tf31.setText(r.getString(1));
           Tf33.setText(r.getString(7));
           Tf34.setText(r.getString(6));
           Tf35.setText(r.getString(4));
           Tf36.setText(r.getString(3));
           Tf37.setText(r.getString(8));
           Tf38.setText(r.getString(9));
           Tf39.setText(r.getString(10));
           Tf40.setText(r.getString(5));
           Tf41.setText(r.getString(11));
//           String T1 = Tf31.getText();
     
           GridPane GP4 = new GridPane();
           Button OKay = new Button("Modify");
           Button Close = new Button("Close");
           GP4.add(L30, 0, 0);
           //GP4.add(L31, 0, 1);
           GP4.add(L32, 0, 2);
           GP4.add(L33, 0, 3);
           GP4.add(L34, 0, 4);
           GP4.add(L35, 0, 5);
           GP4.add(L36, 0, 6);
           GP4.add(L37, 0, 7);
           GP4.add(L38, 0, 8);
           GP4.add(L39, 0, 9);
           GP4.add(L40, 0, 10);
           GP4.add(L41, 0, 11);
           GP4.add(Tf30, 1, 0);
           //GP4.add(Tf31, 1, 1);
           GP4.add(new Label(r.getString(12)), 1, 2);
           GP4.add(Tf33, 1, 3);
           GP4.add(Tf34, 1, 4);
           GP4.add(Tf35, 1, 5);
           GP4.add(Tf36, 1, 6);
           GP4.add(Tf37, 1, 7);
           GP4.add(Tf38, 1, 8);
           GP4.add(Tf39, 1, 9);
           GP4.add(Tf40, 1, 10);
           GP4.add(Tf41, 1, 11);
           GP4.add(OKay,1,12);
           GP4.add(Close,2,12);
           
           String TT = r.getString(12);
           OKay.setOnAction(e10->{
           String T2 = Tf30.getText();
           String T3 = Tf33.getText();
           String T4 = Tf34.getText();
           String T5 = Tf35.getText();
           String T6 = Tf36.getText();
           String T7  = Tf37.getText();
           String T8  = Tf38.getText();;
           String T9  = Tf39.getText(); ;
           String T10 = Tf40.getText(); ;
           String T11 = Tf41.getText(); ;
           try{
          System.out.println(T2+T3+T4+T5 +T6+T7+T8+T9+T10+T11);     
          StackPane sp = new StackPane();
          Label Tx = new Label();
          Label LL = new Label(); 
          if(Integer.parseInt(Tf39.getText())<=Integer.parseInt(TT))
           {    
              Tx.setText("Modified");
              ResultSet RR = statement.executeQuery("select Course_number from course where course_name = '"+T2+"'");
              RR.next();
              String T = RR.getString(1);
              statement.executeUpdate("UPDATE `course` SET `Course_name` ='"+T2+"' ,`Classroom`="+T3+" ,`Credits`="+T4+",`Department_ID`="+T5+",`Instructor_ID`="+T6+" ,`Periods`="+T7+"  ,`Prerequisite_Courses`='"+T8+"' ,`Seats`="+T9+",`Term`="+T10+" ,`TextBooks`= '"+T11+"'  WHERE Course_number = "+T);
           }
           else{
                Tx.setText("NOT Modified");
           }
          Scene scene = new Scene(Tx);
          Stage s33 = new Stage();
          s33.setScene(scene);
          s33.show();
          }catch(Exception Ex){System.out.println(Ex.toString());}
         });
           Scene scene =new Scene(GP4);
           Stage stage = new Stage();
           stage.setTitle("CourseDetails");
           stage.setScene(scene);
           stage.show();
          Close.setOnAction(e1->{
           stage.close();
           
           });
          
           }catch(SQLException ex){System.out.println(ex.toString());}
         });
         }catch(Exception ex){};
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
             ResultSet rsult = statement.executeQuery("select course_name,Day,Period from course where course_number in (select course_ID from inst_course where inst_ID = (select faculty_ID from instructor where Registiration = "+tf[6].getText()+" ) ) ");
             while(rsult.next())
             GP2.add(new Label(rsult.getString(1)),Integer.parseInt(rsult.getString(2)),(Integer.parseInt(rsult.getString(3))%3)+1);
             
             Scene s3 = new Scene(GP2,600,600);
             Stage S3 = new Stage();
             S3.setTitle("Schedule");
             S3.setScene(s3);
             S3.show();
           } catch (SQLException ex) {System.out.println(ex.toString());};
         });
   ViewStudent.setOnAction(e->{
     try{
        int k =0;
      GridPane GP5 = new  GridPane();  
      ResultSet res = statement.executeQuery("select course_ID from inst_course where inst_ID = (select faculty_ID from instructor where registiration = "+AAST_Form.Text1+")");
      ArrayList <String> s= new ArrayList<>();
      while(res.next())
       s.add(res.getString(1));
      for(int i=0;i<s.size();i++){

         ResultSet s1 = statement.executeQuery("select course_name from course where course_number = "+s.get(i));
          s1.next();
          GP5.add(new Label("-----------------"+s1.getString(1)+"------------------"),0,k);
          k++;
          ResultSet res2 = statement.executeQuery("select student_Id from student_course where course_number = " +s.get(i));
          ArrayList <String> s2= new ArrayList<>();
          while(res2.next())
             s2.add(res2.getString(1));
          for(int i1=0;i1<s2.size();i1++){
                ResultSet res3 = statement.executeQuery("select first_name,last_name from students where student_ID = " +s2.get(i1) );
               while(res3.next()){
                GP5.add(new Label(res3.getString(1)+" "+res3.getString(2)),0,k);
                k++;
               }
           }
       }
      Scene s33 = new Scene(GP5);
      Stage sss = new Stage();
      sss.setScene(s33);
      sss.show();
    }catch(Exception ex){System.out.println(ex.toString());};
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

