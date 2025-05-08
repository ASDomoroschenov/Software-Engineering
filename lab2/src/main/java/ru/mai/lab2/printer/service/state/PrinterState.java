package ru.mai.lab2.printer.service.state;

import ru.mai.lab2.dto.PrintRequest;

public interface PrinterState {

  void print(PrintRequest request);
}
