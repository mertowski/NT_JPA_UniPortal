package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Faculty {

    @Id
    @GeneratedValue
    private Long id;

    private String facultyName;

    public Faculty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String name) {
        this.facultyName = name;
    }
    //ToDo: Fakultät muss direkt ausgegeben, wenn man Fach auswählt.
}
