package persistence;

import model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional
public class StudentPersistence {

    @PersistenceContext(unitName = "UniPortalDS")
    private EntityManager em;

    public List<Student> getStudent() {
        return (List<Student>) em.createNamedQuery("studentQuery").getResultList();
    }

    /**
     * Checks which Students belong to the given ID.
     *
     * @param student
     *
     * @return List with all Students for selected {@link Student}
     */

    public List<Student> saveStudentsPersistence(Student student) {
        TypedQuery<Student> q = em.createNamedQuery(student.QRY_GET_STUDENTS, Student.class);
        em.persist(student);
        return q.getResultList();
    }

    public void updateStudentsPersistence(Student student) {
        em.find(Student.class, student.getId());
        em.merge(student);
    }

    public void deleteStudentsPersistence(Student student) {
        em.find(Student.class, student.getId());
        //em.remove(student);
        em.remove(em.contains(student) ? student : em.merge(student));
    }

}