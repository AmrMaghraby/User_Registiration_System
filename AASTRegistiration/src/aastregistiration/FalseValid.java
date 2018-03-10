package aastregistiration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

 public class FalseValid extends Application{
   @Override  
   public void start(Stage P) throws Exception{    
     VBox pane = new VBox();
     Button Register = new Button("                                Register                                 ");
     Image image = new Image("/images/index.jpg"); 
     ImageView imageview = new ImageView(image);
     pane.getChildren().add(imageview);
     pane.getChildren().add(Register);
     Register.setOnAction(e->{
     Stage Temp = new Stage();
     RegisterForm_Students RF = new RegisterForm_Students();
         try {
             P.close();
             RF.start(Temp);
         } catch (Exception ex) {}
     });
     Scene scene = new Scene (pane);
     P.setTitle("Failed_Login_Students");
     P.setScene(scene);
     P.show();
   }
}




