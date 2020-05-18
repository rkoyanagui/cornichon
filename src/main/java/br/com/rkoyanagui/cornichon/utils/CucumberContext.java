package br.com.rkoyanagui.cornichon.utils;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.NonNull;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public final class CucumberContext implements Context {

  private final Map<String, Object> contextMap = new HashMap<>();

  @Override
  public <T> Optional<T> get(@NonNull String key) {
    return (Optional<T>) Optional.ofNullable(contextMap.get(key));
  }

  @Override
  public <T> T getOrDefault(@NonNull String key, T defaultValue) {
    return (T) contextMap.getOrDefault(key, defaultValue);
  }

  @Override
  public Map<String, Object> getAll() {
    return contextMap;
  }

  @Override
  public <T> Optional<T> put(@NonNull String key, T value) {
    return Optional.ofNullable((T) contextMap.put(key, value));
  }

  @Override
  public <T> Optional<T> remove(@NonNull String key) {
    return Optional.ofNullable((T) contextMap.remove(key));
  }

  @Override
  public void clear() {
    contextMap.clear();
  }

  @Override
  public void close() {
    this.clear();
  }
}
