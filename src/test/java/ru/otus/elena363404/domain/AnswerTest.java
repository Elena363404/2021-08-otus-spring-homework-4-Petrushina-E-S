package ru.otus.elena363404.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
  InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
  ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@DisplayName("Класс Answer")
class AnswerTest {

  @MockBean
  private Shell shell;

  @DisplayName("корректно создается конструктором")
  @Test
  void shouldHaveCorrectConstructor() {
    Answer answer = new Answer(1, 2);

    assertEquals(2, answer.getAnswer());
    assertEquals(1, answer.getNum());
  }


}