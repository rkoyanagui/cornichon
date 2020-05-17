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
public class CucumberContext implements Context {

  private Map<String, Object> map = new HashMap<>();

  @Override
  public <T> Optional<T> get(@NonNull String key) {

    return (Optional<T>) Optional.ofNullable(map.get(key));
  }

  @Override
  public <T> T getOrDefault(@NonNull String key, T defaultValue) {

    return (T) map.getOrDefault(key, defaultValue);
  }

  @Override
  public Map<String, Object> getAll() {

    return map;
  }

  @Override
  public <T> Optional<T> put(@NonNull String key, T value) {

    return Optional.ofNullable(value).map(v -> (T) map.put(key, v));
  }

  @Override
  public <T> Optional<T> remove(@NonNull String key) {

    return Optional.ofNullable((T) map.remove(key));
  }

  @Override
  public void clear() {

    map.clear();
  }

  @Override
  public void close() {

    this.clear();
  }
}
