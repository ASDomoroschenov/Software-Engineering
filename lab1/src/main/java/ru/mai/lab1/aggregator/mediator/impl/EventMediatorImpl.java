package ru.mai.lab1.aggregator.mediator.impl;

import java.util.HashMap;
import java.util.Map;
import ru.mai.lab1.aggregator.event.Event;
import ru.mai.lab1.aggregator.event.EventType;
import ru.mai.lab1.aggregator.observer.Observer;
import ru.mai.lab1.aggregator.mediator.EventMediator;

public class EventMediatorImpl implements EventMediator {

  public final Map<EventType, Observer> listeners = new HashMap<>();

  @Override
  public void subscribe(EventType event, Observer listener) {
    listeners.put(event, listener);
  }

  @Override
  public void unsubscribe(EventType event, Observer listener) {
    listeners.remove(event);
  }

  @Override
  public void publish(Event event) {
    Observer listener = listeners.get(event.getEventType());

    if (listener != null) {
      listener.onEvent(event);
    }
  }
}
