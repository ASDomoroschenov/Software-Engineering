package ru.mai.lab1.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import ru.mai.lab1.dto.request.CreateStudentRequest;
import ru.mai.lab1.dto.request.UpdateStudentRequest;
import ru.mai.lab1.dto.response.CreateStudentResponse;
import ru.mai.lab1.dto.response.DeleteStudentResponse;
import ru.mai.lab1.dto.response.ReadStudentResponse;
import ru.mai.lab1.dto.response.UpdateStudentResponse;
import ru.mai.lab1.model.Student;

@Mapper(componentModel = ComponentModel.SPRING)
public interface StudentMapper {

  Student createRequestToModel(CreateStudentRequest request);

  Student updateRequestToModel(UpdateStudentRequest request);

  CreateStudentResponse modelToCreateResponse(Student student);

  UpdateStudentResponse modelToUpdateResponse(Student student);

  ReadStudentResponse modelToReadResponse(Student student);

  DeleteStudentResponse modelToDeleteResponse(Student student);
}
