package ru.otus.elena363404.config;

import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocaleProviderByUserInput implements LocaleProvider {

  private final LangConfig config;

  public LocaleProviderByUserInput(LangConfig config) {
    this.config = config;
  }

  @Override
  public Locale getCurrentLocale() {
    return Locale.forLanguageTag(config.getAllLocale().get(config.getLangNum()));
  }
}
