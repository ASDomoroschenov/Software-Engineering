package ru.mai.lab2.printer.configurer.impl;

import java.lang.reflect.Proxy;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mai.lab2.dto.PrintRequest;
import ru.mai.lab2.printer.configurer.PrinterConfigurer;
import ru.mai.lab2.printer.content.ContentType;
import ru.mai.lab2.printer.service.Printer;
import ru.mai.lab2.printer.service.blackwhite.BlackWhitePrinter;
import ru.mai.lab2.printer.service.blackwhite.proxy.BlackWhitePrinterProxy;
import ru.mai.lab2.printer.service.blackwhite.state.BlackWhiteDocumentState;
import ru.mai.lab2.printer.service.blackwhite.state.BlackWhitePhotoState;
import ru.mai.lab2.printer.service.state.PrinterState;

@Slf4j
@Service
public class BlackWhitePrinterConfigurer implements PrinterConfigurer {

  private static final Map<ContentType, PrinterState> PRINTER_STATES = Map.of(
      ContentType.PHOTO, new BlackWhitePhotoState(),
      ContentType.DOCUMENT, new BlackWhiteDocumentState()
  );

  public Printer configure(PrintRequest request) {
    Printer printer = new BlackWhitePrinterProxy(new BlackWhitePrinter());

    log.info("Настраиваю черно-белый принтер под тип документа...");
    PrinterState printerState = getPrinterState(request.getContentType());
    printer.setState(printerState);
    log.info("Настройка черно-белого принтера завершена!");

    return printer;
  }

  private PrinterState getPrinterState(ContentType contentType) {
    return PRINTER_STATES.getOrDefault(contentType, new BlackWhitePhotoState());
  }
}
