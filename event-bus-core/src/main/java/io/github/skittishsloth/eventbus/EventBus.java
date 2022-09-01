package io.github.skittishsloth.eventbus;

import java.util.function.Consumer;
import java.util.function.Function;

import org.checkerframework.checker.nullness.qual.NonNull;

public interface EventBus {
  <T> Subscription registerListener(@NonNull Consumer<@NonNull ? super T> listener, @NonNull Class<? extends T> eventType);
  
  <T, U> Subscription registerListener(@NonNull Function<@NonNull ? super T, @NonNull ? extends U> listener, @NonNull Class<? extends T> eventType);
  
  void cancel(@NonNull Subscription subscription);
}