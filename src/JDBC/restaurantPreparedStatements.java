package JDBC;

import Orders.Product;
import Orders.Restaurant;
import Person.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class restaurantPreparedStatements
{
    private Connection connection;
    public restaurantPreparedStatements(Connection connection)
    {
        this.connection = connection;
        createTableRestaurant();
    }

    public void createTableRestaurant()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS restaurant" +
                "(id int PRIMARY KEY, name varchar(30), address varchar(300), menu varchar(300))";
        try
        {
            PreparedStatement psmt = this.connection.prepareStatement(createTableSql);
            psmt.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //create
    public void insertRestaurant(Restaurant r)
    {
        String insertRestaurantSql = "INSERT INTO restaurant(id, name, address, menu) VALUES(?, ?, ?, ?)";
        try
        {
            Integer id = r.getIdRestaurant();
            String name = r.getName();
            Address a = r.getAddress();
            List<Product> pr = r.getMenu();
            String address = a.getStreet() + ", " + Integer.toString(a.getNumber()) + ", " + a.getCity() + ", " + a.getCounty() + ", " + Integer.toString(a.getPostalCode());
            String menu = "";
            for (Product p : pr)
            {
                menu += p.getName() + ", ";
            }
            PreparedStatement preparedStatement = this.connection.prepareStatement(insertRestaurantSql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, menu);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //read
    public List<Restaurant> getRestaurants()
    {
        String selectSql = "SELECT * FROM restaurant";
        try
        {
            PreparedStatement psmt = this.connection.prepareStatement(selectSql);
            ResultSet rs = psmt.executeQuery();
            List<Restaurant> restaurantList = new ArrayList<>();
            while (rs.next())
            {
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                String menu = rs.getString(4);
                String [] addressFields = address.split(", ");
                String street = addressFields[0];
                Integer number = Integer.parseInt(addressFields[1]);
                String city = addressFields[2];
                String county = addressFields[3];
                Integer postalCode = Integer.parseInt(addressFields[4]);
                Address a = new Address(street, number, city, county, postalCode);
                String [] menuList = menu.split(", ");
                List<Product> m = new ArrayList<>();
                for (int i = 0; i < menuList.length; i++)
                {
                    Product p = new Product();
                    p.setName(menuList[i]);
                    m.add(p);
                }
                Restaurant r = new Restaurant(id, name, a, m);
                restaurantList.add(r);
            }
            return restaurantList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    //update
    public void updateRestaurant(String name, Integer id)
    {
        String updateRestaurant = "UPDATE restaurant SET name = ? WHERE id = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(updateRestaurant);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //delete
    public void deleteRestaurant(Integer id)
    {
        String deleteRestaurant = "DELETE FROM restaurant WHERE id = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteRestaurant);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
