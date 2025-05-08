package ru.mai.lab2.printer.chain.impl;

import ru.mai.lab2.dto.PrintRequest;
import ru.mai.lab2.printer.chain.PrinterHandler;
import ru.mai.lab2.printer.configurer.impl.BlackWhitePrinterConfigurer;

public class BlackWhitePrinterHandler extends PrinterHandler {

  public BlackWhitePrinterHandler(
      PrinterHandler next,
      BlackWhitePrinterConfigurer blackWhitePrinterConfigurer) {
    super(next, blackWhitePrinterConfigurer);
  }

  @Override
  public boolean canHandle(PrintRequest request) {
    return !request.isColor();
  }
}
