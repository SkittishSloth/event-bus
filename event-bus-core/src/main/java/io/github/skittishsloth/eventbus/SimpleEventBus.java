package io.github.skittishsloth.eventbus;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.function.Function;

import org.checkerframework.checker.nullness.qual.NonNull;

public class SimpleEventBus implements EventBus {
  
  private final ConcurrentHashMap<Class<?>, ConcurrentLinkedQueue<Consumer<?>>> consumers = new ConcurrentHashMap<>();
  private final ConcurrentHashMap<Class<?>, ConcurrentLinkedQueue<Function<?, ?>>> functions = new ConcurrentHashMap<>();
  
  private final ConcurrentHashMap<Subscription, ?> subscriptions = new ConcurrentHashMap<>();

  @Override
  public <T> Subscription registerListener(@NonNull Consumer<@NonNull ? super T> listener, @NonNull Class<? extends T> eventType) {
    final ConcurrentLinkedQueue<Consumer<?>> consumerQueue = consumers.computeIfAbsent(eventType, __ -> new ConcurrentLinkedQueue<>());
    final Subscription subscription = Subscription.consumer(this);
    subscriptions.put(subscription, listener);
    consumerQueue.add(listener);
    
    return subscription;
  }

  @Override
  public <T, U> Subscription registerListener(@NonNull Function<@NonNull ? super T, @NonNull ? extends U> listener, @NonNull Class<? extends T> eventType) {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public void cancel(@NonNull Subscription subscription) {
    // TODO Auto-generated method stub
    
  }
  
}
