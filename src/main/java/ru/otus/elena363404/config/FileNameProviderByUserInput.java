package ru.otus.elena363404.config;

import org.springframework.stereotype.Component;

@Component
public class FileNameProviderByUserInput implements FileNameProvider {

  private final LangConfig config;
  private String localFileName;

  public FileNameProviderByUserInput(LangConfig config) {
    this.config = config;
  }

  public String getLocalFileName() {
    localFileName = config.getAllQuizPath().get(config.getLangNum());
    return localFileName;
  }
}
