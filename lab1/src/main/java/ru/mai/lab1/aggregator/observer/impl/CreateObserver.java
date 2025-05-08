package ru.mai.lab1.aggregator.observer.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.mai.lab1.aggregator.event.Event;
import ru.mai.lab1.aggregator.observer.Observer;
import ru.mai.lab1.kafka.KafkaSender;

@Slf4j
@RequiredArgsConstructor
public class CreateObserver implements Observer {

  private final KafkaSender sender;

  @Override
  public void onEvent(Event event) {
    sender.send(event.getEventType().name().toLowerCase(), event);
  }
}
