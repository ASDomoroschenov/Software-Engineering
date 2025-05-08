package ru.mai.lab2.printer.service.color.state;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import ru.mai.lab2.dto.PrintRequest;
import ru.mai.lab2.printer.service.state.PrinterState;

@Slf4j
public class ColorPhotoState implements PrinterState {

  @Override
  @SneakyThrows
  public void print(PrintRequest request) {
    log.info("Печатаю цветное фото...");
    Thread.sleep(1000);
    log.info("Цветное фото распечатано!!!");
  }
}
