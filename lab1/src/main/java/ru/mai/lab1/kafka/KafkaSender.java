package ru.mai.lab1.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.mai.lab1.aggregator.event.Event;

@Service
@RequiredArgsConstructor
public class KafkaSender {

  private final KafkaTemplate<String, Object> kafkaTemplate;

  public void send(String topic, Event event) {
    kafkaTemplate.send(topic, event);
  }
}
