package JDBC;

import Transport.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class carPreparedStatements
{
    private Connection connection;
    public carPreparedStatements(Connection connection)
    {
        this.connection = connection;
        createTableCar();
    }

    public void createTableCar()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS car" +
                "(id int PRIMARY KEY, maxSpeed int, maxOrders int, brand varchar(30), licensePlate varchar(10), combustible varchar(30))";
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
    public void insertCar(Car c)
    {
        String insertCarSql = "INSERT INTO car(id, maxSpeed, maxOrders, brand, licensePlate, combustible) VALUES(?, ?, ?, ?, ?, ?)";
        try
        {
            Integer id = c.getIdTransport();
            Integer speed = c.getMaximumSpeed();
            Integer orders = c.getMaximumNoOfOrdersPerTransport();
            String brand = c.getBrand();
            String licensePlate = c.getLicensePlate();
            String combustible = c.getCombustible();
            PreparedStatement preparedStatement = this.connection.prepareStatement(insertCarSql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, speed);
            preparedStatement.setInt(3, orders);
            preparedStatement.setString(4, brand);
            preparedStatement.setString(5, licensePlate);
            preparedStatement.setString(6, combustible);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //read
    public List<Car> getCars()
    {
        String selectSql = "SELECT * FROM car";
        try
        {
            PreparedStatement psmt = this.connection.prepareStatement(selectSql);
            ResultSet rs = psmt.executeQuery();
            List<Car> carList = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                Integer speed = rs.getInt(2);
                Integer orders = rs.getInt(3);
                String brand = rs.getString(4);
                String licensePlate = rs.getString(5);
                String combustible = rs.getString(6);
                Car c = new Car(id, speed, orders, brand, licensePlate, combustible);
                carList.add(c);
            }
            return carList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    //update
    public void updateCar(String licensePlate, Integer id)
    {
        String updateCar = "UPDATE car SET licensePlate = ? WHERE id = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(updateCar);
            preparedStatement.setString(1, licensePlate);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //delete
    public void deleteCar(Integer id)
    {
        String deleteCar = "DELETE FROM car WHERE id = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteCar);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
