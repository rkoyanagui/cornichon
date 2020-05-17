package br.com.rkoyanagui.cornichon.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "webdriver")
@Data
public class WebDriverProperties {

  private String browser;

  private Executables executables;

  private String downloadFolder;

  private boolean headless;

  private boolean remote;

  private Server server;

  @Configuration
  @Data
  public static class Executables {

    private String chrome;
  }

  @Configuration
  @Data
  public static class Server {

    private String host;

    private int port;
  }
}
