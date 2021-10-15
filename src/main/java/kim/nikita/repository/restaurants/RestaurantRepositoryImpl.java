package kim.nikita.repository.restaurants;

import kim.nikita.model.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRepositoryImpl implements RestaurantRepository {


    private String url="jdbc:postgresql://localhost:5432/rvs";
    private String username="postgres";
    private String password="postgres";
    private String selectTableSQL="select * from restaurants";

    @Override
    public List<Restaurant> getAll() {
        List<Restaurant> restaurants =new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed");
            e.printStackTrace();

        }

        try {
            Connection conn= DriverManager.getConnection(url,username,password);
            Statement statement = conn.createStatement();


            ResultSet rs = statement.executeQuery(selectTableSQL);


            while (rs.next()) {

                int restid = rs.getInt("id");
                String restname = rs.getString("name");
                String address=rs.getString("address");
                Restaurant restaurant=new Restaurant(restid,restname,address);
                restaurants.add(restaurant);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return restaurants;
    }
}
