package br.com.rkoyanagui.cornichon.screen.interactions;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.greaterThan;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import org.awaitility.core.ConditionFactory;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;

public final class Waitable {

  private Waitable() {
  }

  public static ConditionFactory willWait() {
    return await()
        .ignoreExceptionsInstanceOf(NotFoundException.class)
        .ignoreExceptionsInstanceOf(StaleElementReferenceException.class);
  }

  public static void willWait(long timeoutInSeconds) {

    long pollInterval = 1_000L;
    LongAdder counter = new LongAdder();

    ScheduledFuture<?> scheduledFuture = Executors.newSingleThreadScheduledExecutor()
        .scheduleAtFixedRate(counter::increment, 0L, pollInterval, TimeUnit.MILLISECONDS);

    await().pollInterval(Duration.ofMillis(pollInterval))
        .atMost(Duration.ofMinutes(5L))
        .untilAdder(counter, greaterThan(timeoutInSeconds));

    scheduledFuture.cancel(true);
  }
}
