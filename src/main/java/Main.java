import br.com.mdfilipiaki.school.application.student.enroll.EnrollStudent;
import br.com.mdfilipiaki.school.application.student.enroll.EnrollStudentDto;
import br.com.mdfilipiaki.school.domain.student.student.Cpf;
import br.com.mdfilipiaki.school.domain.student.student.Email;
import br.com.mdfilipiaki.school.domain.student.student.Student;
import br.com.mdfilipiaki.school.infra.student.RepositoryStudentMemory;

public class Main {
    public static void main(String[] args) {
        try {
            String name = "Maicon";
            String cpf = "034.079.800-94";
            String email = "mdfilipiaki@gmail.com";

            RepositoryStudentMemory repositoryStudentMemory = new RepositoryStudentMemory();

            new EnrollStudent(
                    repositoryStudentMemory
            ).exec(new EnrollStudentDto(name, cpf, email));

            System.out.println(repositoryStudentMemory.getAllStudentsEnroll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}