package studit.core.mainpage;

import java.util.ArrayList;
import java.util.Collection;

public class CourseItem {

  private String courseCode;
  private String courseName;
  private String comment;
  private String score;
  private String examDate;
  private String helpingTools;
  private String evaluation;

  private Collection<ForumPost> forumPosts = new ArrayList<ForumPost>();

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setScore(String score) {
    this.score = score;
  }

  public void setExam(String examDate) {
    this.examDate = examDate;
  }

  public void setHelpingTools(String helpingTools) {
    this.helpingTools = helpingTools;
  }

  public void setEvaluation(String evaluation) {
    this.evaluation = evaluation;
  }

  public String getCourseName() {
    return this.courseName;
  }

  public String getCourseCode() {
    return this.courseCode;
  }

  public String getComment() {
    return this.comment;
  }

  public String getScore() {
    return this.score;
  }

  public String getEvaluation() {
    return this.evaluation;
  }

  public String getExamDate() {
    return this.examDate;
  }

  public String getHelpingTools() {
    return this.helpingTools;
  }

  // ForumPost
  public void addForumPost(ForumPost post) {
    forumPosts.add(post);
  }

  public void deleteForumPost(ForumPost post) {
    forumPosts.remove(post);
  }

  public void setForumPosts(Collection<ForumPost> c) {
    this.forumPosts = c;
  }

  public Collection<ForumPost> getForumPosts() {
    return this.forumPosts;
  }

}