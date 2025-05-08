package ru.mai.lab1.aggregator.aspect;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ru.mai.lab1.aggregator.annotation.Observer;
import ru.mai.lab1.aggregator.event.Event;
import ru.mai.lab1.aggregator.mediator.EventMediator;

@Aspect
@Component
@RequiredArgsConstructor
public class ObserverAspect {

  private final EventMediator eventMediator;

  @Around("@annotation(ru.mai.lab1.aggregator.annotation.Observer)")
  public Object trackEntityChange(ProceedingJoinPoint joinPoint) throws Throwable {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = signature.getMethod();
    Observer annotation = method.getAnnotation(Observer.class);

    Object result = joinPoint.proceed();

    eventMediator.publish(
        Event.builder()
            .eventType(annotation.event())
            .target(annotation.table())
            .payload(result)
            .timestamp(LocalDateTime.now())
            .build()
    );

    return result;
  }
}
