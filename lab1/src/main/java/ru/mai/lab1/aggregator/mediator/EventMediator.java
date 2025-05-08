package ru.mai.lab1.aggregator.mediator;

import ru.mai.lab1.aggregator.event.Event;
import ru.mai.lab1.aggregator.event.EventType;
import ru.mai.lab1.aggregator.observer.Observer;

public interface EventMediator {

  void subscribe(EventType event, Observer listener);

  void unsubscribe(EventType event, Observer listener);

  void publish(Event event);
}
