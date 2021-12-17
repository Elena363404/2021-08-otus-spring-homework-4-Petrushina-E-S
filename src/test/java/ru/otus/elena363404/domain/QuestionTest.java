package ru.otus.elena363404.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
  InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
  ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@DisplayName("Класс Question")
class QuestionTest {

  @MockBean
  private Shell shell;

  @DisplayName("корректно создается конструктором")
  @Test
  void shouldHaveCorrectConstructor() {
    Integer num = 1;
    Integer id = 1;
    List<Option> options = new ArrayList<Option>();
    options.add(new Option(num, id, "List"));
    id++;
    options.add(new Option(num, id,"Set"));
    id++;
    options.add(new Option(num, id, "Map"));
    Answer answer = new Answer(num, 3);

    Question question = new Question(num, "Which of those doesn't have an index based structure?", options, answer);

    assertEquals(1, question.getNum());
    assertEquals(options, question.getOptions());
    assertEquals(answer, question.getAnswer());
    assertEquals("Which of those doesn't have an index based structure?", question.getQuestion());
  }
}