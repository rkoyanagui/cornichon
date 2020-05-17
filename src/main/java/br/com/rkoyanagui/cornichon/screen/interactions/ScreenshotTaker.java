package br.com.rkoyanagui.cornichon.screen.interactions;

import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.Optional;
import java.util.stream.Stream;

public interface ScreenshotTaker {

  Optional<byte[]> takeScreenshot(WebDriverContainer webDriverContainer);

  Optional<byte[]> takeScreenshot();

  Optional<byte[]> push(byte[] picture);

  Optional<byte[]> pop();

  Stream<byte[]> getAll();

  void clear();
}
