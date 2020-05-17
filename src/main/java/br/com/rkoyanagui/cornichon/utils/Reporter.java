package br.com.rkoyanagui.cornichon.utils;

import java.util.Map;
import java.util.Optional;

public interface Reporter {

  Optional<Object> get(String key);

  Map<String, Object> getAll();

  Optional<Object> put(String key, Object value);

  Optional<Object> remove(String key);

  void clear();
}
