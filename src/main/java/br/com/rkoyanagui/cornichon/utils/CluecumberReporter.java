package br.com.rkoyanagui.cornichon.utils;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
@Slf4j
public class CluecumberReporter implements Reporter {

  private Map<String, Object> map;
  private ObjectMapper objectMapper;

  @Autowired
  protected CluecumberReporter(ObjectMapper objectMapper) {

    this.objectMapper = objectMapper;
    map = new HashMap<>();
  }

  @Override
  public Optional<Object> get(@NonNull String key) {

    return Optional.ofNullable(map.get(key));
  }

  @Override
  public Map<String, Object> getAll() {

    return map;
  }

  @Override
  public Optional<Object> put(@NonNull String key, Object value) {

    return Optional.ofNullable(value).map(v -> map.put(key, writeValueAsString(v)));
  }

  @Override
  public Optional<Object> remove(@NonNull String key) {

    return Optional.ofNullable(map.remove(key));
  }

  @Override
  public void clear() {

    map.clear();
  }

  protected String writeValueAsString(Object value) {

    try {

      return objectMapper.writeValueAsString(value);

    } catch (JsonProcessingException e) {

      LOG.error("Unable to write value as string!", e);
      throw new ReportingException(e);
    }
  }
}
