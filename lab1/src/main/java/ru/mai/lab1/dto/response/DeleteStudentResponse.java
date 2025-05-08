package ru.mai.lab1.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AdditionalPropertiesValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Schema(
    name = "DeleteStudentResponse",
    description = "Ответ с информацией о студенте",
    additionalProperties = AdditionalPropertiesValue.FALSE
)
public class DeleteStudentResponse {

  @Schema(
      name = "id",
      description = "Идентификатор студента",
      type = "Long"
  )
  private Long id;

  @Schema(
      name = "fullName",
      description = "Полное имя студента",
      type = "String",
      maxLength = 30
  )
  private String fullName;

  @Schema(
      name = "groupName",
      description = "Группа студента",
      type = "String",
      maxLength = 30
  )
  private String groupName;
}
