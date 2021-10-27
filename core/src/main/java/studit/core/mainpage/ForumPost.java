package studit.core.mainpage;

public class ForumPost {

  private String text;
  private int upvotes;
  private int downvotes;

  public ForumPost(String text, int upvotes, int downvotes){
    this.text = text;
    this.downvotes = downvotes;
    this.upvotes = upvotes;
  }
  
  public void setText(String text){
    this.text = text;
  }

  public void upVote(){
    this.upvotes += 1;
  }

  public void downVote(){
    this.downvotes -=1;
  }
  
  public String getText(){
    return this.text;
  }

  public int getUpvotes(){
    return this.upvotes;
  }

  public int getDownvotes(){
    return this.downvotes;
  }

  public void setUpvote(Integer i){
    this.upvotes = i;
  } 

  public void setDownvote(Integer i){
    this.downvotes = i;
  }

}