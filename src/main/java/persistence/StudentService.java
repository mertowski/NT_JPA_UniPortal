package persistence;

import model.Student;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class StudentService {

    @EJB
    private StudentPersistence studentPersistence;

    public List<Student> getStudent() {
        return studentPersistence.getStudent();
    }

    public void saveStudentsNew(Student std) {
        studentPersistence.saveStudentsPersistence(std);
    }

    public void updateStudents(Student student) {
        studentPersistence.updateStudentsPersistence(student);
    }

    public void deleteStudents(Student student) {
        studentPersistence.deleteStudentsPersistence(student);
    }
}