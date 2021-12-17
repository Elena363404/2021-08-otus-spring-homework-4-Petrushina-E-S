package ru.otus.elena363404.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.elena363404.config.LocaleProvider;

@Service
public class LocalMessageService implements MessageService {

  private final LocaleProvider localeProvider;
  private final MessageSource messageSource;

  private LocalMessageService(LocaleProvider localeProvider, MessageSource messageSource) {
    this.localeProvider = localeProvider;
    this.messageSource = messageSource;
  }

  public String getLocalMessage(String txtMsg) {
    txtMsg = messageSource.getMessage(txtMsg, null, localeProvider.getCurrentLocale());
    return txtMsg;
  }

}
