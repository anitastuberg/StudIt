package studit.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;


import studit.core.mainpage.CourseItem;
import studit.core.mainpage.ForumPost;

public class CourseItemDeserializer extends JsonDeserializer<CourseItem> {

    private ForumPostDeserializer forumPostDeserializer = new ForumPostDeserializer();

  /**
   * Deserialiezes a CourseItem. 
   *
   */
  @Override
  public CourseItem deserialize(JsonParser parser, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    TreeNode treeNode = parser.getCodec().readTree(parser);
    return deserialize((JsonNode) treeNode);
  }

  CourseItem deserialize(JsonNode jsonNode) {
    if (jsonNode instanceof ObjectNode) {
      ObjectNode objectNode = (ObjectNode) jsonNode;
      CourseItem item = new CourseItem();

      JsonNode codeNode = objectNode.get("code");
      if (codeNode instanceof TextNode) {
        item.setFagkode(((TextNode) codeNode).asText());
      }

      JsonNode nameNode = objectNode.get("name");
      if (nameNode instanceof TextNode) {
        item.setFagnavn(((TextNode) nameNode).asText());
      }

      JsonNode rateNode = objectNode.get("rate");
      if (rateNode instanceof TextNode) {
        item.setScore(((TextNode) rateNode).asText());
      }

      JsonNode kommentarNode = objectNode.get("kommentar");
      if (kommentarNode instanceof TextNode) {
        item.setKommentar(((TextNode) kommentarNode).asText());
      }

      JsonNode postsNode = objectNode.get("posts");

  
      if (postsNode instanceof ArrayNode) {
        for (JsonNode elementNode : ((ArrayNode) postsNode)) {
          ForumPost post  = forumPostDeserializer.deserialize(elementNode);
          if (item != null) {
            item.addForumPost(post);
          }
        }
      }
      

      return item;

    }

    return null;
  }
}
