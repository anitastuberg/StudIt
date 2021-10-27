package studit.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import studit.core.chatbot.Response;
import studit.core.chatbot.prompt.PromptManager;
import studit.ui.chatbot.Commands;
import studit.ui.chatbot.Message;
import studit.ui.chatbot.Prompt;

public class ChatbotController implements Initializable {

  private Stage stage = null;
  private double xOffset = 0;
  private double yOffset = 0;
  // This value is hardcoded as it is based on current font, size and more, hard
  // to make dynamic.
  public static final int lineBreakLength = 48;
  public PromptManager promptManager;
  private ChatbotController chatbotController;
  public Commands commands;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    chatbotController = this;
    commands = new Commands(chatbotController);
    promptManager = new PromptManager();
    txt_user_entry.textProperty().addListener(l -> checkForLineBreak());

    ObservableList<Message> chatMessages = FXCollections.observableArrayList();

    list_chat.setItems(chatMessages); // attach the observable list to the listview
    list_chat.setCellFactory(param -> {

      ListCell<Message> cell = new ListCell<Message>() {
        Label lblUserLeft = new Label();
        TextFlow flowTextLeft = new TextFlow();
        HBox hBoxLeft = new HBox(lblUserLeft, flowTextLeft);

        Label lblUserRight = new Label();
        Label lblTextRight = new Label();
        HBox hBoxRight = new HBox(lblTextRight, lblUserRight);

        {
          hBoxLeft.setAlignment(Pos.CENTER_LEFT);
          hBoxRight.setAlignment(Pos.CENTER_RIGHT);
          hBoxRight.setPadding(new Insets(5, 0, 5, 0));
          hBoxLeft.setPadding(new Insets(5, 0, 5, 0));
        }

        @Override
        protected void updateItem(Message item, boolean empty) {
          super.updateItem(item, empty);

          if (empty) {
            setText(null);
            setGraphic(null);
          } else {
            if (item.getUser().equals("chatbot")) {
              flowTextLeft
                  .setStyle("-fx-background-color: linear-gradient(to left, #ff512f, #dd2476);\r\n"
                      + "    -fx-background-insets: -5 -25 -5 -5;\r\n"
                      + "    -fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.08),2,1.0,0.5,0.5);\r\n"
                      + "    -fx-shape: \"M 94.658379,129.18587 H 46.277427 c -3.545458,0.23354 -5.32763,-1.59167 -5.14193,-4.67449\r\n"
                      + "    v -19.39913 c 0.405797,-3.73565 2.470637,-4.56641 5.14193,-4.90821 h 43.706464 c 2.572701,0.2361 4.604321,\r\n"
                      + "    1.68288 4.674488,4.90821 v 19.39913 c 0.436089,3.14572 2.890695,3.57304 4.908212,4.67449 z\";");
              flowTextLeft.getChildren().clear();

              Text text = new Text(item.getText());
              text.setFill(Color.WHITE);

              // We want the user to choose between a certain set of options
              if (item.getPrompt() != null) {
                text.setText(text.getText() + "\n");
                flowTextLeft.getChildren().add(text);
                new Prompt(item.getPrompt(), flowTextLeft, list_chat, item, chatbotController);
              } else {
                flowTextLeft.getChildren().add(text);
              }
              setGraphic(hBoxLeft);
            } else {
              lblTextRight
                  .setStyle("-fx-background-color: linear-gradient(to left, #4776e6, #8e54e9);\r\n"
                      + "    -fx-background-insets: -5 -5 -5 -34;\r\n"
                      + "    -fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.08),2,1.0,-0.5,-0.5);\r\n"
                      + "    -fx-shape: \"m 46.030545,129.18592 h 48.380952 c 3.54546,0.23355 5.32763,-1.59167 5.14193,-4.67449\r\n"
                      + "    V 105.1123 c -0.4058,-3.73565 -2.47064,-4.56641 -5.14193,-4.90821 H 50.705033\r\n"
                      + "    c -2.572701,0.2361 -4.604321,1.68288 -4.674488,4.90821 v 19.39913\r\n"
                      + "    c -0.436089,3.14572 -2.890695,3.57304 -4.908212,4.67449 z\";");
              lblTextRight.setText(item.getText());
              setGraphic(hBoxRight);
            }
          }
        }

      };

      return cell;
    });

    list_chat.getItems()
        .add(new Message(
            "Hei! Jeg er din nye assistent, chatbotten Gunnar. Hva kan jeg hjelpe deg med?",
            "chatbot"));
  }

  /**
   * Checks if wee need to add a line break to the user input to avoid text out of bounds.
   */
  private void checkForLineBreak() {

    if (txt_user_entry.getText().length() % lineBreakLength == 0) {
      txt_user_entry.setText(txt_user_entry.getText() + "\n");
    }

  }

  // ----------------------------------Member
  // Initialization-----------------------------------

  @FXML
  private BorderPane pane_chatbot;

  @FXML
  private Button btn_minimize;

  @FXML
  private Button btn_exit;

  @FXML
  ListView<Message> list_chat;

  @FXML
  private TextArea txt_user_entry;

  // ----------------------------------------Widget
  // Logic-----------------------------------------

  @FXML
  public void exitChatbot(ActionEvent event) {
    AppController.closeChatbot();
    if (stage == null) {
      final Node source = (Node) event.getSource();
      stage = (Stage) source.getScene().getWindow();
    }
    stage.close();

  }

  @FXML
  void minimizeChatbot(ActionEvent event) {

    if (stage == null) {
      final Node source = (Node) event.getSource();
      stage = (Stage) source.getScene().getWindow();
    }

    stage.setIconified(true);
  }

  /**
   * Moves our chatbot window when dragged by the toolbar.
   */
  @FXML
  void moveWindow(MouseEvent event) {
    if (stage != null) {
      stage.setX(event.getScreenX() - xOffset);
      stage.setY(event.getScreenY() - yOffset);
    }
  }

  /**
   * Sets new cursor location (x & yOffset) so that we can drag our application by the toolbar.
   */
  @FXML
  private void setOffset(MouseEvent event) {
    // If we have not yet loaded the current stage, load it from the event
    if (stage == null) {
      Node source = (Node) event.getSource();
      stage = (Stage) source.getScene().getWindow();
    }
    xOffset = event.getSceneX();
    yOffset = event.getSceneY();
  }

  /**
   * When user presses enter key, send the input to the Chatbot to perform an action accordingly.
   */
  @FXML
  private void userEntry(KeyEvent event) {
    
    if (stage == null) {
      final Node source = (Node) event.getSource();
      stage = (Stage) source.getScene().getWindow();
    }

    if (event.getCode() == KeyCode.ENTER) {
      String userInput = txt_user_entry.getText();
      txt_user_entry.setText("");
      list_chat.getItems().add(new Message(userInput, "user"));
      // Make sure that the caret is at first position for a new command!
      txt_user_entry.selectPositionCaret(0);
      Response response = AppController.chatbot.manageInput(userInput);
      list_chat.getItems().add(new Message(response, "chatbot"));
    }
  }

}
