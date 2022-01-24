import br.com.mdfilipiaki.school.domain.student.student.Cpf;

public class Main {
    public static void main(String[] args) {
        try {
            //Email test = new Email("mdfilipiaki@com.br");
            Cpf test = new Cpf("03407980094");
            System.out.println("Ai sim meu consagrado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}