package ru.otus.elena363404.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.elena363404.config.LangConfig;
import ru.otus.elena363404.service.QuestionService;

@ShellComponent
@RequiredArgsConstructor
public class QuizCommands {

  private final QuestionService questionService;

  private final LangConfig config;

  @ShellMethod(value = "test-student", key = {"t", "tes", "test"})
  public String testStudent() {
    questionService.testStudent();
    return "Тестирование завершено";
  }

  @ShellMethod(value = "cnt-questions", key = {"cnt q", "cnt question"})
  public String getCntQuestion() {
    return "Кол-во вопросов в тесте - " + config.getCntQuestion();
  }

  @ShellMethod(value = "cnt-right-answer-for-pass-test", key = {"cnt right an", "cnt answer"})
  public String getCntRightAnswerForPassTest() {
    return "Кол-во правильных ответов для прохождения теста - " + config.getCntAnswerToPassTest();
  }

  @ShellMethod(value = "langs", key = {"lang", "langs"})
  public String getLang() {
    return "Доступные языки - " + config.getAvailableLang();
  }
}
