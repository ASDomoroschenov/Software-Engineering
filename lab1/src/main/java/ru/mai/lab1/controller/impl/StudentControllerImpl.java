package ru.mai.lab1.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mai.lab1.controller.StudentController;
import ru.mai.lab1.dto.request.CreateStudentRequest;
import ru.mai.lab1.dto.request.UpdateStudentRequest;
import ru.mai.lab1.dto.response.CreateStudentResponse;
import ru.mai.lab1.dto.response.DeleteStudentResponse;
import ru.mai.lab1.dto.response.ReadStudentResponse;
import ru.mai.lab1.dto.response.UpdateStudentResponse;
import ru.mai.lab1.service.StudentService;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentControllerImpl implements StudentController {

  private final StudentService studentService;

  @PostMapping("/create")
  public CreateStudentResponse createStudent(@Valid @RequestBody CreateStudentRequest request) {
    log.info("[student.create] Запрос: {}", request);
    var response = studentService.createStudent(request);
    log.info("[student.create] Ответ: {}", response);
    return response;
  }

  @GetMapping("/read")
  public ReadStudentResponse readStudent(@RequestParam Long id) {
    log.info("[student.read] Запрос: id={}", id);
    var response = studentService.readStudent(id);
    log.info("[student.read] Ответ: {}", response);
    return response;
  }

  @PutMapping("/update")
  public UpdateStudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest request) {
    log.info("[student.update] Запрос: {}", request);
    var response = studentService.updateStudent(request);
    log.info("[student.update] Ответ: {}", response);
    return response;
  }

  @DeleteMapping("/delete")
  public DeleteStudentResponse deleteStudent(@RequestParam Long id) {
    log.info("[student.delete] Запрос: id={}", id);
    var response = studentService.deleteStudent(id);
    log.info("[student.delete] Ответ: {}", response);
    return response;
  }
}
