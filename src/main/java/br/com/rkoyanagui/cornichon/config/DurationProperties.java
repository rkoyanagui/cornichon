package br.com.rkoyanagui.cornichon.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "durations")
@Data
public class DurationProperties {

  private long baseline;

  private long writing;

  private long reading;

  private long visibility;

  private long clicking;
}
