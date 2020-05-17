package br.com.rkoyanagui.cornichon.utils;

import java.util.Map;
import java.util.Optional;

public interface Context extends AutoCloseable {

  <T> Optional<T> get(String key);

  <T> T getOrDefault(String key, T defaultValue);

  Map<String, Object> getAll();

  <T> Optional<T> put(String key, T value);

  <T> Optional<T> remove(String key);

  void clear();
}
