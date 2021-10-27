package studit.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application {

  @Override
  public void start(final Stage primaryStage) throws Exception {
    final Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
    parent.getStylesheets().add(getClass().getResource("mainPage.css").toExternalForm());

    primaryStage.setScene(new Scene(parent));
    primaryStage.setTitle("Login");
    primaryStage.show();
  }

  public static void main(final String[] args) {
    launch(args);
  }

}
