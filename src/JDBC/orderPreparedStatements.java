package JDBC;

import Orders.Order;
import Orders.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class orderPreparedStatements
{
    private Connection connection;
    public orderPreparedStatements(Connection connection)
    {
        this.connection = connection;
        createTableOrder();
    }

    public void createTableOrder()
    {
        String createTablSql = "CREATE TABLE IF NOT EXISTS orderr" +
                "(id int PRIMARY KEY, idUser int, idRestaurant int, value double, payment varchar(40), products varchar(300))";
        try
        {
            PreparedStatement psmt = this.connection.prepareStatement(createTablSql);
            psmt.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //create
    public void insertOrder(Order o)
    {
        String insertOrderSql = "INSERT INTO orderr(id, idUser, idRestaurant, value, payment, products) VALUES(?, ?, ?, ?, ?, ?)";
        try
        {
            Integer id = o.getIdOrder();
            Integer idUser = o.getIdUser();
            Integer idRestaurant = o.getIdRestaurant();
            Double value = o.getValue();
            String paymentMethod = o.getPaymentMethod();
            Hashtable<Product, Integer> pr = o.getProductList();
            String productList = "";
            Iterator<Product> it = pr.keySet().iterator();
            while (it.hasNext())
            {
                Product key = it.next();
                productList += key.getName() + ", " + Double.toString(key.getPrice()) + ", " + Integer.toString(pr.get(key)) + ", ";
            }
            PreparedStatement preparedStatement = this.connection.prepareStatement(insertOrderSql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, idUser);
            preparedStatement.setInt(3, idRestaurant);
            preparedStatement.setDouble(4, value);
            preparedStatement.setString(5, paymentMethod);
            preparedStatement.setString(6, productList);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //read
    public List<Order> getOrders()
    {
        String selectSql = "SELECT * FROM orderr";
        try
        {
            PreparedStatement psmt = this.connection.prepareStatement(selectSql);
            ResultSet rs = psmt.executeQuery();
            List<Order> orderList = new ArrayList<>();
            while (rs.next())
            {
                Integer id = rs.getInt(1);
                Integer idUser = rs.getInt(2);
                Integer idRestaurant = rs.getInt(3);
                Double value = rs.getDouble(4);
                String paymentMethod = rs.getString(5);
                String productList = rs.getString(6);

                String [] productFields = productList.split(", ");
                Hashtable<Product, Integer> pr = new Hashtable<>();
                for (int i = 0; i < productFields.length - 2; i = i + 3)
                {
                    Product p = new Product();
                    p.setName(productFields[i]);
                    p.setPrice(Double.parseDouble(productFields[i + 1]));
                    Integer cant = Integer.parseInt(productFields[i + 2]);
                    pr.put(p, cant);
                }
                Order o = new Order(id, idUser, idRestaurant, value, paymentMethod, pr);
                orderList.add(o);
            }
            return orderList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    //update
    public void updateOrder(Double value, Integer id)
    {
        String updateOrder = "UPDATE orderr SET value = ? WHERE id = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(updateOrder);
            preparedStatement.setDouble(1, value);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //delete
    public void deleteOrder(Integer id)
    {
        String deleteOrder = "DELETE FROM orderr WHERE id = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteOrder);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
