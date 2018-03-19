package model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({@NamedQuery(name = Student.QRY_GET_STUDENTS, query = "select s from Student s")})
public class Student {

    public static final String QRY_GET_STUDENTS = "studentQuery";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 70)
    private String name;

    @Size(min = 7, max = 7, message = "Matrikelnummer muss 7 Ziffern haben!")
    private String matriculationNumber;

    @DecimalMax(value = "5.0", message = "Note muss zwischen 1.0 und 5.0 sein!")
    private double note;

    private String lecture;

    private boolean editable;

    @ManyToOne(cascade={CascadeType.ALL})
    private Faculty faculty;

    public Student(Long id, String name, String matriculationNumber, double note, String lecture) {
        this.id = id;
        this.name = name;
        this.matriculationNumber = matriculationNumber;
        this.note = note;
        this.lecture = lecture;
    }

    public Student() {
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(String matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEditable() {
        return editable;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}