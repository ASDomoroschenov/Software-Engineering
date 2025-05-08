package ru.mai.lab2.printer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mai.lab2.printer.chain.PrinterHandler;
import ru.mai.lab2.printer.chain.impl.BlackWhitePrinterHandler;
import ru.mai.lab2.printer.chain.impl.ColorPrinterHandler;
import ru.mai.lab2.printer.configurer.impl.BlackWhitePrinterConfigurer;
import ru.mai.lab2.printer.configurer.impl.ColorPrinterConfigurer;

@Configuration
@RequiredArgsConstructor
public class PrinterChainConfiguration {

  private final ColorPrinterConfigurer colorPrinterConfigurer;
  private final BlackWhitePrinterConfigurer blackWhitePrinterConfigurer;

  @Bean
  public PrinterHandler printerHandler() {
    ColorPrinterHandler colorPrinterHandler = new ColorPrinterHandler(
        null,
        this.colorPrinterConfigurer
    );
    return new BlackWhitePrinterHandler(
        colorPrinterHandler,
        this.blackWhitePrinterConfigurer
    );
  }
}
