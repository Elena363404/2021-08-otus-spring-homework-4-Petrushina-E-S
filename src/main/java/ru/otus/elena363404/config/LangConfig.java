package ru.otus.elena363404.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties(prefix = "features")
@Component
public class LangConfig extends AppConfig {

  private int langNum;
  private int cntAvailableLang;

  private Map<Integer, String> allLocale;
  private String availableLang;

  public int getLangNum() {
    return langNum;
  }

  public void setLangNum(int langNum) {
    this.langNum = langNum;
  }

  public String getAvailableLang() {
    return availableLang;
  }

  public void setAvailableLang(String availableLang) {
    this.availableLang = availableLang;
  }

  public Map<Integer, String> getAllLocale() {
    return allLocale;
  }

  public void setAllLocale(Map<Integer, String> allLocale) {
    this.allLocale = allLocale;
  }

  public int getCntAvailableLang() {
    return cntAvailableLang;
  }

  public void setCntAvailableLang(int cntAvailableLang) {
    this.cntAvailableLang = cntAvailableLang;
  }
}
