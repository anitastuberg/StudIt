package studit.ui;

public class ForumMessage {

  private String username;
  private int rating;
  private String text;

  public ForumMessage(String username, String text){
    this.username = username;
    this.text = text;
  }

  // public void setUsername(String username) {
  //   this.username = username;
  // }

  // public void settext(String text) {
  //   this.text = text;
  // }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getUsername() {
    return this.username;
  }

  public int getRating() {
    return this.rating;
  }

  public String getText() {
    return this.text;
  }

  }



