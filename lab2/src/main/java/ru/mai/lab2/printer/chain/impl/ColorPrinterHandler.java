package ru.mai.lab2.printer.chain.impl;

import ru.mai.lab2.dto.PrintRequest;
import ru.mai.lab2.printer.chain.PrinterHandler;
import ru.mai.lab2.printer.configurer.impl.ColorPrinterConfigurer;

public class ColorPrinterHandler extends PrinterHandler {

  public ColorPrinterHandler(
      PrinterHandler next,
      ColorPrinterConfigurer colorPrinterConfigurer) {
    super(next, colorPrinterConfigurer);
  }

  @Override
  public boolean canHandle(PrintRequest request) {
    return request.isColor();
  }
}
