package studit.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import studit.core.mainpage.ForumPost;

public class ForumListCell extends ListCell<ForumPost> {

  HBox hbox = new HBox();

  Button upBtn = new Button("UpVote");

  Button downBtn = new Button("DownVote");

  Label textView  = new Label("textView");

  @Override
  protected void updateItem(ForumPost item, boolean empty) {
    super.updateItem(item, empty);

    if(empty || item == null) {

            setText(null);
            setGraphic(null);

    } else {

      
    }

    }
      

  }



   