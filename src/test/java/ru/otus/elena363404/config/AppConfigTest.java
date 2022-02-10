package ru.otus.elena363404.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
  InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
  ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@DisplayName("Класс AppConfig")
class AppConfigTest {

  @Autowired
  private AppConfig config;

  @MockBean
  private Shell shell;

  @Test
  void getQuizPath() {
    Map<Integer, String> allQuizPath = config.getAllQuizPath();
    assertEquals(allQuizPath.get(2),"fileQuizRu.csv");
    assertEquals(allQuizPath.get(1),"fileQuizEn.csv");
  }

  @Test
  void getCntQuestion() {
    assertEquals(5, config.getCntQuestion());
  }

  @Test
  void getCntAnswerToPassTest() {
    assertEquals(config.getCntAnswerToPassTest(),4);
  }
}