package io.github.skittishsloth.eventbus;

import java.util.UUID;

import org.checkerframework.checker.nullness.qual.NonNull;

import static java.util.Objects.requireNonNull;

public final class Subscription {

  public enum Type {
    FUNCTION,
    CONSUMER;
  }
  
  @NonNull private final EventBus eventBus;
  @NonNull private final UUID subscriptionId;
  @NonNull private final Type type;
  
  private Subscription(
    final @NonNull EventBus eventBus,
    final @NonNull UUID subscriptionId,
    final @NonNull Type type) {
      this.eventBus = requireNonNull(eventBus, "Event Bus must be provided.");
      this.subscriptionId = requireNonNull(subscriptionId, "Subscription Id must be provided.");
      this.type = requireNonNull(type, "Type must be provided.");
    }
  
  public static Subscription function(final @NonNull EventBus eventBus) {
    return new Subscription(eventBus, UUID.randomUUID(), Type.FUNCTION);
  }
  
  public static Subscription consumer(final @NonNull EventBus eventBus) {
    return new Subscription(eventBus, UUID.randomUUID(), Type.CONSUMER);
  }
  public void cancel() {
    eventBus.cancel(this);;
  }
}