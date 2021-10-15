package kim.nikita.repository.user;

import kim.nikita.model.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {


    private String url="jdbc:postgresql://localhost:5432/rvs";
    private String username="postgres";
    private String password="postgres";
    private String selectTableSQL="select * from users";

    @Override
    public List<User> getAll() {
        List<User> users =new ArrayList<User>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed");
            e.printStackTrace();

        }

        try {
            Connection conn= DriverManager.getConnection(url,username,password);
            Statement statement = conn.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {

                int userid = rs.getInt("id");
                String username = rs.getString("name");
                String email=rs.getString("email");
                LocalDateTime registered=rs.getObject(4,LocalDateTime.class);
                boolean admin=rs.getBoolean(5);
                User user=new User(userid,username,email,registered,admin);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
}
