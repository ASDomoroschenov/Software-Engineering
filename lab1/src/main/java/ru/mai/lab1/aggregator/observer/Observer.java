package ru.mai.lab1.aggregator.observer;

import ru.mai.lab1.aggregator.event.Event;

public interface Observer {

  void onEvent(Event event);
}
