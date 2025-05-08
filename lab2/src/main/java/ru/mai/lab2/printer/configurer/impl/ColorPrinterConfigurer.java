package ru.mai.lab2.printer.configurer.impl;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mai.lab2.dto.PrintRequest;
import ru.mai.lab2.printer.configurer.PrinterConfigurer;
import ru.mai.lab2.printer.content.ContentType;
import ru.mai.lab2.printer.service.Printer;
import ru.mai.lab2.printer.service.color.ColorPrinter;
import ru.mai.lab2.printer.service.color.proxy.ColorPrinterProxy;
import ru.mai.lab2.printer.service.color.state.ColorDocumentState;
import ru.mai.lab2.printer.service.color.state.ColorPhotoState;
import ru.mai.lab2.printer.service.state.PrinterState;

@Slf4j
@Service
public class ColorPrinterConfigurer implements PrinterConfigurer {

  private static final Map<ContentType, PrinterState> PRINTER_STATES = Map.of(
      ContentType.PHOTO, new ColorPhotoState(),
      ContentType.DOCUMENT, new ColorDocumentState()
  );

  public Printer configure(PrintRequest request) {
    Printer printer = new ColorPrinterProxy(new ColorPrinter());

    log.info("Настраиваю цветной принтер под тип документа...");
    PrinterState printerState = getPrinterState(request.getContentType());
    printer.setState(printerState);
    log.info("Настройка цветного принтера завершена!");

    return printer;
  }

  private PrinterState getPrinterState(ContentType contentType) {
    return PRINTER_STATES.getOrDefault(contentType, new ColorPhotoState());
  }
}
