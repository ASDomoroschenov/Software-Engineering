package ru.mai.lab1.aggregator.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mai.lab1.aggregator.event.EventType;
import ru.mai.lab1.aggregator.observer.Observer;
import ru.mai.lab1.aggregator.observer.impl.CreateObserver;
import ru.mai.lab1.aggregator.observer.impl.DeleteObserver;
import ru.mai.lab1.aggregator.observer.impl.ReadObserver;
import ru.mai.lab1.aggregator.observer.impl.UpdateObserver;
import ru.mai.lab1.aggregator.mediator.EventMediator;
import ru.mai.lab1.aggregator.mediator.impl.EventMediatorImpl;
import ru.mai.lab1.kafka.KafkaSender;

@Configuration
@RequiredArgsConstructor
public class EventMediatorConfig {

  private final KafkaSender kafkaSender;

  @Bean
  public EventMediator eventMediator() {
    EventMediator eventMediator = new EventMediatorImpl();

    eventMediator.subscribe(EventType.CREATE, createEventListener());
    eventMediator.subscribe(EventType.READ, readEventListener());
    eventMediator.subscribe(EventType.UPDATE, updateEventListener());
    eventMediator.subscribe(EventType.DELETE, deleteEventListener());

    return eventMediator;
  }

  @Bean
  public Observer createEventListener() {
    return new CreateObserver(kafkaSender);
  }

  @Bean
  public Observer readEventListener() {
    return new ReadObserver(kafkaSender);
  }

  @Bean
  public Observer updateEventListener() {
    return new UpdateObserver(kafkaSender);
  }

  @Bean
  public Observer deleteEventListener() {
    return new DeleteObserver(kafkaSender);
  }
}
