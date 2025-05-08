package ru.mai.lab2.printer.service.blackwhite.state;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import ru.mai.lab2.dto.PrintRequest;
import ru.mai.lab2.printer.service.state.PrinterState;

@Slf4j
public class BlackWhiteDocumentState implements PrinterState {

  @Override
  @SneakyThrows
  public void print(PrintRequest request) {
    log.info("Печатаю черно-белый документ...");
    Thread.sleep(1000);
    log.info("Черно-белый документ распечатан!!!");
  }
}
