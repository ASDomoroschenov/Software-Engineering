package ru.mai.lab1.service;

import ru.mai.lab1.dto.request.CreateStudentRequest;
import ru.mai.lab1.dto.request.UpdateStudentRequest;
import ru.mai.lab1.dto.response.CreateStudentResponse;
import ru.mai.lab1.dto.response.DeleteStudentResponse;
import ru.mai.lab1.dto.response.ReadStudentResponse;
import ru.mai.lab1.dto.response.UpdateStudentResponse;

public interface StudentService {

  CreateStudentResponse createStudent(CreateStudentRequest request);

  UpdateStudentResponse updateStudent(UpdateStudentRequest request);

  ReadStudentResponse readStudent(Long id);

  DeleteStudentResponse deleteStudent(Long id);
}
