package models;

import com.sun.istack.NotNull;
import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    private String title;

    // Conexion con Teacher
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    //Conexion con materialCourse
    @OneToOne(mappedBy = "course")
    private CourseMaterial material;

    // getters y setters
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CourseMaterial getMaterial() {
        return material;
    }
}
