package controller;

import model.Faculty;
import model.Student;
import persistence.StudentService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class StudentController implements Serializable {

    private Student student = new Student();
    private List<Student> myList = new ArrayList<>();
    Faculty faculty = new Faculty();


    @EJB
    private StudentService studentService;

    @PostConstruct
    public void init() {
        myList = studentService.getStudent();
    }

    public void createInformations() {
        faculty.setFacultyName("Informatik");
        student.setFaculty(faculty);
        studentService.saveStudentsNew(student);
        myList = studentService.getStudent();
    }

    public void updateNote(Student student) {
        studentService.updateStudents(student);
        myList = studentService.getStudent();
    }

    public void deleteNote(Student student) {
        studentService.deleteStudents(student);
        myList = studentService.getStudent();
    }

    public void changeData(Student student) {
        student.setEditable(false);
        updateNote(student);

        FacesMessage msg = new FacesMessage("Student, mit der Name ''" + student.getName() + "'' ist bearbeitet!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteData(Student student){
        deleteNote(student);

        FacesMessage msg = new FacesMessage("Student, mit der Name ''" + student.getName() + "'' ist gelöscht!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //Todo: Mach mit Enum
    public List<String> completeText() {
        List<String> results = new ArrayList<>();
        results.add("Fortgeschrittene Programmierung");
        results.add("Grundlagen der Informatik");
        results.add("Verteilte Systeme");
        return results;
    }

    public void editAction(Student student) {
        student.setEditable(true);
    }

    public void cancelAction(Student student) {
        student.setEditable(false);
    }

    public String save() {
        createInformations();
        return "saved";
    }

    public String cancel() {
        return "canceled";
    }

    public String startPage() {
        return "index";
    }

    public String newData() {
        return "noten";
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getMyList() {
        return myList;
    }

    public void setMyList(List<Student> myList) {
        this.myList = myList;
    }

}