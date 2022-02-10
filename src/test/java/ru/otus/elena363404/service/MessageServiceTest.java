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

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest(properties = {
  InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
  ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@DisplayName("Класс MessageService")
class MessageServiceTest {

  @MockBean
  private LangConfig config;

  @MockBean
  private Shell shell;

  @Autowired
  private LocalMessageService localMessageService;

  @Test
  void getLocalMessageTest() {
    when(config.getAllLocale()).thenReturn(getAllLocale());
    when(config.getLangNum()).thenReturn(2);

    assertEquals(localMessageService.getLocalMessage("strings.reply.to.input"), "Введите номер ответа: ");

  }

  private Map<Integer, String> getAllLocale() {
    Map<Integer, String> hm = new HashMap<>();

    hm.put(1, "en-EN");
    hm.put(2, "ru-RU");
    return hm;
  }


}