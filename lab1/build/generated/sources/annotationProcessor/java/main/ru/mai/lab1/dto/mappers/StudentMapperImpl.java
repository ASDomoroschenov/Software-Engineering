package ru.mai.lab1.dto.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.mai.lab1.dto.request.CreateStudentRequest;
import ru.mai.lab1.dto.request.UpdateStudentRequest;
import ru.mai.lab1.dto.response.CreateStudentResponse;
import ru.mai.lab1.dto.response.DeleteStudentResponse;
import ru.mai.lab1.dto.response.ReadStudentResponse;
import ru.mai.lab1.dto.response.UpdateStudentResponse;
import ru.mai.lab1.model.Student;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-26T13:22:16+0300",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 17.0.14 (Ubuntu)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student createRequestToModel(CreateStudentRequest request) {
        if ( request == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.fullName( request.getFullName() );
        student.groupName( request.getGroupName() );

        return student.build();
    }

    @Override
    public Student updateRequestToModel(UpdateStudentRequest request) {
        if ( request == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.id( request.getId() );
        student.fullName( request.getFullName() );
        student.groupName( request.getGroupName() );

        return student.build();
    }

    @Override
    public CreateStudentResponse modelToCreateResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        CreateStudentResponse.CreateStudentResponseBuilder createStudentResponse = CreateStudentResponse.builder();

        createStudentResponse.id( student.getId() );
        createStudentResponse.fullName( student.getFullName() );
        createStudentResponse.groupName( student.getGroupName() );

        return createStudentResponse.build();
    }

    @Override
    public UpdateStudentResponse modelToUpdateResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        UpdateStudentResponse.UpdateStudentResponseBuilder updateStudentResponse = UpdateStudentResponse.builder();

        updateStudentResponse.id( student.getId() );
        updateStudentResponse.fullName( student.getFullName() );
        updateStudentResponse.groupName( student.getGroupName() );

        return updateStudentResponse.build();
    }

    @Override
    public ReadStudentResponse modelToReadResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        ReadStudentResponse.ReadStudentResponseBuilder readStudentResponse = ReadStudentResponse.builder();

        readStudentResponse.id( student.getId() );
        readStudentResponse.fullName( student.getFullName() );
        readStudentResponse.groupName( student.getGroupName() );

        return readStudentResponse.build();
    }

    @Override
    public DeleteStudentResponse modelToDeleteResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        DeleteStudentResponse.DeleteStudentResponseBuilder deleteStudentResponse = DeleteStudentResponse.builder();

        deleteStudentResponse.id( student.getId() );
        deleteStudentResponse.fullName( student.getFullName() );
        deleteStudentResponse.groupName( student.getGroupName() );

        return deleteStudentResponse.build();
    }
}
