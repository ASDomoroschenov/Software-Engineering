package ru.mai.lab2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.mai.lab2.printer.content.ContentType;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PrintRequest {

  private ContentType contentType;
  private boolean color;
  private byte[] content;
}
