package ru.mai.lab2.printer.configurer;

import ru.mai.lab2.dto.PrintRequest;
import ru.mai.lab2.printer.service.Printer;

public interface PrinterConfigurer {

  Printer configure(PrintRequest request);

  default void configure(Printer printer, PrintRequest request) {
  }
}
