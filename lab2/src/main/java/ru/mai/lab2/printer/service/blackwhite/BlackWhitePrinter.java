package ru.mai.lab2.printer.service.blackwhite;

import ru.mai.lab2.dto.PrintRequest;
import ru.mai.lab2.printer.service.Printer;
import ru.mai.lab2.printer.service.state.PrinterState;

public class BlackWhitePrinter implements Printer {

  private PrinterState printerState;

  @Override
  public void setState(PrinterState state) {
    this.printerState = state;
  }

  @Override
  public void print(PrintRequest request) {
    printerState.print(request);
  }
}
