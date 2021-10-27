package studit.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import studit.core.mainpage.ForumPost;

public class ForumController {

  @FXML
  private BorderPane rootPane;

  @FXML
  private Button information_btn;

  @FXML
  private Button forum_btn;

  @FXML
  private Label courseCode;

  @FXML
  private Label courseName;

  @FXML
  private Button mainPageAction;

  @FXML
  private Button chatbot_btn;

  @FXML
  private Button logoutAction;

  @FXML
  private TextField newPostInputField;

  @FXML
  private Button handleAddNewPost;

  @FXML
  private ListView<ForumPost> forumList;

  private ObservableList<ForumPost> listView = FXCollections.observableArrayList();

  // add some Students

  public void initialize(URL location, ResourceBundle resources) {

    // Henter en liste med ForumPoster fra CourseController som har data fra DB om
    // det spesifike kurset.

    this.listView.addAll(new ForumPost("hei", 0, 0), new ForumPost("nei", 0, 0), new ForumPost("ja", 0, 0));

    forumList.setItems(listView);

    forumList.setCellFactory(param -> new ForumListCell());

  }

  @FXML
  void handleAddNewPost(ActionEvent event) {
    String comment = newPostInputField.getText();
    // hent brukernavn fra innlogget bruker
    String username = "user";
    ForumMessage forumMessage = new ForumMessage(username, comment);
    publishPost(forumMessage);
  }

  public void publishPost(ForumMessage forumMessage){
    
  }

  @FXML
  void handleLogoutAction(ActionEvent event) {

  }

  @FXML
  void handleMainPageAction(ActionEvent event) {

  }

  @FXML
  void handleNtnuAction(ActionEvent event) {

  }

  @FXML
  void openChatBot(ActionEvent event) {

  }

}
