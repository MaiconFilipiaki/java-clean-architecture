package br.com.mdfilipiaki.school.infra.student;

import br.com.mdfilipiaki.school.domain.student.student.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepositoryStudentJDBC implements RepositoryStudent {

    final private Connection connection;

    public RepositoryStudentJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enroll(Student student) {
        try {
            String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getCpf());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.execute();

            sql = "INSERT INTO PHONE VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            for (Phone phone : student.getPhones()) {
                ps.setString(1, phone.getDdd());
                ps.setString(1, phone.getNumber());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findByCpf(Cpf cpf) throws SQLException {
        try {
            String sql = "SELECT id, name, email FROM STUDENT WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getCode());

            ResultSet rs = ps.executeQuery();
            boolean find = rs.next();
            if (!find) {
                throw new StudentNotFound(cpf);
            }

            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Student student = new Student(cpf, name, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, number FROM PHONE WHERE student_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String number = rs.getString("number");
                String ddd = rs.getString("ddd");
                student.addPhone(new Phone(ddd, number));
            }
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getAllStudentsEnroll() {
        return null;
    }
}
