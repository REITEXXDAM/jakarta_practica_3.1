package idao;
import models.Student;
import java.util.List;

public interface StudentDao {

    List<Student> listStudentsByCourseId(int courseId);
}
