package ru.mai.lab1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mai.lab1.dto.mappers.StudentMapper;
import ru.mai.lab1.dto.request.CreateStudentRequest;
import ru.mai.lab1.dto.request.UpdateStudentRequest;
import ru.mai.lab1.dto.response.CreateStudentResponse;
import ru.mai.lab1.dto.response.DeleteStudentResponse;
import ru.mai.lab1.dto.response.ReadStudentResponse;
import ru.mai.lab1.dto.response.UpdateStudentResponse;
import ru.mai.lab1.model.Student;
import ru.mai.lab1.aggregator.annotation.Observer;
import ru.mai.lab1.aggregator.event.EventType;
import ru.mai.lab1.repository.StudentRepository;
import ru.mai.lab1.service.StudentService;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentMapper mapper;
  private final StudentRepository repository;

  @Override
  @Observer(event = EventType.CREATE, table = "student")
  public CreateStudentResponse createStudent(CreateStudentRequest request) {
    Student student = mapper.createRequestToModel(request);
    Student savedStudent = repository.saveAndFlush(student);
    return mapper.modelToCreateResponse(savedStudent);
  }

  @Override
  @Observer(event = EventType.UPDATE, table = "student")
  public UpdateStudentResponse updateStudent(UpdateStudentRequest request) {
    Student student = mapper.updateRequestToModel(request);
    Student updatedStudent = repository.saveAndFlush(student);
    return mapper.modelToUpdateResponse(updatedStudent);
  }

  @Override
  @Observer(event = EventType.READ, table = "student")
  public ReadStudentResponse readStudent(Long id) {
    Student student = repository.findById(id).orElse(null);
    return mapper.modelToReadResponse(student);
  }

  @Override
  @Observer(event = EventType.DELETE, table = "student")
  public DeleteStudentResponse deleteStudent(Long id) {
    Student student = repository.findById(id).orElse(null);

    if (student != null) {
      repository.delete(student);
    }

    return mapper.modelToDeleteResponse(student);
  }
}
