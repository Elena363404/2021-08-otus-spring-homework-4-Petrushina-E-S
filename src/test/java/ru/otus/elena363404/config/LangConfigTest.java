package ru.otus.elena363404.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.otus.elena363404.service.LocalMessageService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
  InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
  ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@DisplayName("Класс LangConfig")
class LangConfigTest {

  @MockBean
  private Shell shell;

  @Autowired
  private LangConfig config;

  @Autowired
  private LocalMessageService localMessageService;

  @Autowired
  private FileNameProvider fileNameProvider;

  @Test
  void getAllLangStr() {
    assertEquals(config.getAvailableLang(), "1.English\n2.Russian\n");
  }


  @Test
  void getCntAvailableLang() {
    assertEquals(config.getCntAvailableLang(), 2);
  }

  @Test
  void getLocalFileName() {
    config.setLangNum(2);
    assertEquals(fileNameProvider.getLocalFileName(), "fileQuizRu.csv");
  }

  @Test
  void getLocalMessage() {
    config.setLangNum(2);
    assertEquals(localMessageService.getLocalMessage("strings.reply.to.input"), "Введите номер ответа: ");
    config.setLangNum(1);
    assertEquals(localMessageService.getLocalMessage("strings.reply.to.input"), "Input num of answer: ");
  }
/*
  @Test
  void getAvailableLang() {
    Map<Integer, String> hm = config.getAvailableLang();

    assertEquals(hm.get(1), "English");
    assertEquals(hm.get(2), "Russian");
  }*/

  @Test
  void getLangNum() {
    config.setLangNum(2);
    assertEquals(config.getLangNum(), 2);
    config.setLangNum(1);
    assertEquals(config.getLangNum(), 1);
  }

  @Test
  void getAllLocale() {
    Map<Integer, String> hm = config.getAllLocale();

    assertEquals(hm.get(1), "en-EN");
    assertEquals(hm.get(2), "ru-RU");
  }
}