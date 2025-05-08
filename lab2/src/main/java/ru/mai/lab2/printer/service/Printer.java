package ru.mai.lab2.printer.service;

import ru.mai.lab2.dto.PrintRequest;
import ru.mai.lab2.printer.service.state.PrinterState;

public interface Printer {

  void setState(PrinterState state);

  void print(PrintRequest request);
}
