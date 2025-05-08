package ru.mai.lab2.printer.chain;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ru.mai.lab2.dto.PrintRequest;
import ru.mai.lab2.printer.configurer.PrinterConfigurer;
import ru.mai.lab2.printer.service.Printer;

@Slf4j
@AllArgsConstructor
public abstract class PrinterHandler {

  @Setter
  private PrinterHandler next;
  private PrinterConfigurer printerConfigurer;

  public void handle(PrintRequest request) {
    if (canHandle(request)) {
      log.info("Обработка запроса на печать...");
      Printer configuredPrinter = printerConfigurer.configure(request);
      configuredPrinter.print(request);
      log.info("Запрос обработан");
    } else if (next != null) {
      next.handle(request);
    }
  }

  public abstract boolean canHandle(PrintRequest request);
}
