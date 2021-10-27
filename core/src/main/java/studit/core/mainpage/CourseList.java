package studit.core.mainpage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CourseList implements Iterable<CourseItem> {

  private List<CourseItem> items = new ArrayList<>();

  public CourseItem createCourseItem() {
    return new CourseListItem(this);
  }

  /**
   * Adds the provided CourseItem to this CourseList. If the CourseItem is not an
   * instance of CourseListItem, its contents is copied in to a new CourseListItem
   * and that is added instead.
   *
   * @param item the CourseItem to add
   */
  public void addCourseItem(CourseItem item) {
    CourseListItem courseListItem = null;
    if (item instanceof CourseListItem) {
      courseListItem = (CourseListItem) item;
    } else {
      courseListItem = new CourseListItem(this);
      courseListItem.setCourseCode(item.getCourseCode());
      courseListItem.setCourseName(item.getCourseName());
      courseListItem.setComment(item.getComment());
      courseListItem.setScore(item.getScore());
    }
    items.add(courseListItem);
  }

  public void removeCourseItem(CourseItem item) {
    items.remove(item);
  }

  @Override
  public Iterator<CourseItem> iterator() {
    return items.iterator();
  }

  public Collection<CourseItem> getCourseItems() {
    return items;
  }



}
