package studit.json;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import studit.core.mainpage.ForumPost;

public class ForumPostSerializer extends JsonSerializer<ForumPost> {

  
  /**
  * Serializes a ForumPost item.
  *
  * @param item the item you want to serialize
  */
  @Override
  public void serialize(ForumPost item, JsonGenerator jsonGen, SerializerProvider serializerProvider)
      throws IOException {

    jsonGen.writeStartObject();

    jsonGen.writeStringField("post", item.getText());
    jsonGen.writeNumberField("upvotes", item.getUpvotes());
    jsonGen.writeNumberField("downvotes", item.getDownvotes());
    
    jsonGen.writeEndObject();

  }
}