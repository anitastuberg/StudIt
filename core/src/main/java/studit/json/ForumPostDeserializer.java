package studit.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;
import studit.core.mainpage.ForumPost;

public class ForumPostDeserializer extends JsonDeserializer<ForumPost> {

  /**
   * Deserialiezes a ForumPost. 
   *
   */
  @Override
  public ForumPost deserialize(JsonParser parser, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    TreeNode treeNode = parser.getCodec().readTree(parser);
    return deserialize((JsonNode) treeNode);
  }

  ForumPost deserialize(JsonNode jsonNode) {
    if (jsonNode instanceof ObjectNode) {
      ObjectNode objectNode = (ObjectNode) jsonNode;

      ForumPost forumPost = new ForumPost(null, 0, 0);

      JsonNode postNode = objectNode.get("post");
      if (postNode instanceof TextNode) {
        forumPost.setText(((TextNode) postNode).asText());
      }

      JsonNode upvotesNode = objectNode.get("upvotes");
      if (upvotesNode instanceof TextNode) {
        forumPost.setDownvote(((TextNode) upvotesNode).asInt());
      }

      JsonNode downvotesNode = objectNode.get("downvotes");
      if (downvotesNode instanceof TextNode) {
        forumPost.setDownvote(((TextNode) downvotesNode).asInt());
      }

      return forumPost;

    }

    return null;
  }
}
