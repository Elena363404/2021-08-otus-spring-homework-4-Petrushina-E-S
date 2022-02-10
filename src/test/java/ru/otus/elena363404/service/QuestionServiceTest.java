package ru.otus.elena363404.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.otus.elena363404.config.LangConfig;
import ru.otus.elena363404.dao.QuestionDao;
import ru.otus.elena363404.domain.Answer;
import ru.otus.elena363404.domain.Option;
import ru.otus.elena363404.domain.Question;
import ru.otus.elena363404.exception.QuestionReadingException;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest(properties = {
  InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
  ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@DisplayName("Класс QuestionService")
class QuestionServiceTest {

  @Autowired
  private QuestionService questionService;

  @MockBean
  private Shell shell;

  @MockBean
  private IOService ioService;

  @MockBean
  private QuestionDao dao;

  @MockBean
  private LangConfig config;

  @MockBean
  private LocalMessageService localMessageService;

  @Test
  @DisplayName("ученик провалил тест 1/3")
  void testStudentFailTest() throws QuestionReadingException {

    when(config.getAvailableLang()).thenReturn(getAvailableLang());
    when(config.getCntAvailableLang()).thenReturn(2);
    when(config.getCntQuestion()).thenReturn(3);
    when(config.getCntAnswerToPassTest()).thenReturn(2);
    when(ioService.readString()).thenReturn("1");
    when(ioService.readInt()).thenReturn(3);
    when(dao.getAllQuestions()).thenReturn(getQuestionList());
    when(localMessageService.getLocalMessage("strings.reply.pass.test")).thenReturn("Поздравляем! Вы успешно прошли тестирование. ");
    when(localMessageService.getLocalMessage("strings.reply.fail.test")).thenReturn("Вы не сдали тест! ");
    questionService.testStudent();
    verify(ioService, times(1)).out("Choose language: \n" +
      "1.English\n" +
      "2.Russian\n");
    verify(ioService, times(1)).out("Input num of answer: ");
    verify(ioService, times(1)).out("\n" +
      "Which of those doesn't have an index based structure?1");
    verify(ioService, times(1)).out("\n" +
      "Which of those doesn't have an index based structure?2");
    verify(ioService, times(1)).out("\n" +
      "Which of those doesn't have an index based structure?3");
    verify(ioService, times(3)).out("1.List\n" +
      "2.Set\n" +
      "3.Map\n");
    verify(ioService, times(1)).out("Вы не сдали тест! 1/3");
  }


  @Test
  @DisplayName("ученик успешно прошел тест 3/3")
  void testStudentPassTest() throws QuestionReadingException {
    when(config.getAvailableLang()).thenReturn(getAvailableLang());
    when(config.getCntAvailableLang()).thenReturn(2);
    when(config.getCntQuestion()).thenReturn(3);
    when(config.getCntAnswerToPassTest()).thenReturn(2);
    when(ioService.readString()).thenReturn("1");
    when(ioService.readInt()).thenReturn(1).thenReturn(2).thenReturn(3);
    when(dao.getAllQuestions()).thenReturn(getQuestionList());
    when(localMessageService.getLocalMessage("strings.reply.pass.test")).thenReturn("Поздравляем! Вы успешно прошли тестирование. ");
    when(localMessageService.getLocalMessage("strings.reply.fail.test")).thenReturn("Вы не сдали тест! ");
    questionService.testStudent();
    verify(ioService, times(1)).out("Choose language: \n" +
      "1.English\n" +
      "2.Russian\n");
    verify(ioService, times(1)).out("Input num of answer: ");
    verify(ioService, times(1)).out("\n" +
      "Which of those doesn't have an index based structure?1");
    verify(ioService, times(1)).out("\n" +
      "Which of those doesn't have an index based structure?2");
    verify(ioService, times(1)).out("\n" +
      "Which of those doesn't have an index based structure?3");
    verify(ioService, times(3)).out("1.List\n" +
      "2.Set\n" +
      "3.Map\n");
    verify(ioService, times(1)).out("Поздравляем! Вы успешно прошли тестирование. 3/3");
  }

  public List<Question> getQuestionList() {
    List<Question> questionList = new ArrayList<>();
    int num = 1;

    for (int i = 0; i < 3; i++) {
      num = i + 1;
      questionList.add(new Question(num, "Which of those doesn't have an index based structure?" + num, getOptionList(num), new Answer(num, num)));
    }
    return questionList;
  }

  private List<Option> getOptionList(int num) {
    int id = 1;
    List<Option> options = new ArrayList<Option>();
    options.add(new Option(id, num, "List"));
    id++;
    options.add(new Option(id, num, "Set"));
    id++;
    options.add(new Option(id, num, "Map"));
    return options;
  }

  private String getAvailableLang() {
    String availableLang = "1.English\n2.Russian\n";
    return availableLang;
  }

}