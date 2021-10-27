package studit.core.chatbot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandManagerTest {
  
  private CommandManager cm;
  
  @BeforeEach
  public void init() {
    cm = new CommandManager();
  }

  @Test
  public void testExecuteCommand() {
    Response response = new Response();
    cm.executeCommand("hils", response);
    assertEquals(response.response, "Hei! ");
  }

}
