package ru.mai.lab2.printer.service.blackwhite.proxy;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import ru.mai.lab2.dto.PrintRequest;
import ru.mai.lab2.printer.content.ContentType;
import ru.mai.lab2.printer.service.Printer;
import ru.mai.lab2.printer.service.blackwhite.BlackWhitePrinter;
import ru.mai.lab2.printer.service.state.PrinterState;

@Slf4j
@RequiredArgsConstructor
public class BlackWhitePrinterProxy implements Printer {

  private final BlackWhitePrinter blackWhitePrinter;

  @Override
  public void setState(PrinterState state) {
    blackWhitePrinter.setState(state);
  }

  @Override
  @SneakyThrows
  public void print(PrintRequest request) {
    if (request.getContentType().equals(ContentType.PHOTO)
        && (request.getContent() == null || request.getContent().length == 0)) {
      log.info("Фото не предано в запросе! Фотографирую...");
      Thread.sleep(1000);
      log.info("Фото сделано, работа продолжается...");
    }

    blackWhitePrinter.print(request);
  }
}
