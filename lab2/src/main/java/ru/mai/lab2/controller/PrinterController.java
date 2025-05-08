package ru.mai.lab2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mai.lab2.dto.PrintRequest;
import ru.mai.lab2.printer.chain.PrinterHandler;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/printer")
public class PrinterController {

  private final PrinterHandler printerHandler;

  @PostMapping("/print")
  public String print(@RequestBody PrintRequest request) {
    printerHandler.handle(request);
    return "OK";
  }
}
