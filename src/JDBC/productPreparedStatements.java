package JDBC;

import Orders.Ingredient;
import Orders.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class productPreparedStatements
{
    private Connection connection;
    public productPreparedStatements(Connection connection)
    {
        this.connection = connection;
        createTableProduct();
    }

    public void createTableProduct()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS product" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30), price double, ingredientList varchar(300))";
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
    public void insertProduct(Product p)
    {
        String insertProductSql = "INSERT INTO product(name, price, ingredientList) VALUES(?, ?, ?)";
        try
        {
            String name = p.getName();
            Double price = p.getPrice();
            Hashtable<Ingredient, Integer> ing = p.getIngredientList();
            String ingredientList = "";
            Iterator<Ingredient> it = ing.keySet().iterator();
            while (it.hasNext())
            {
                Ingredient key = it.next();
                String vegan = "";
                if (key.getVegan())
                {
                    vegan = "1";
                }
                else
                {
                    vegan = "0";
                }
                ingredientList += key.getName() + ", " + vegan + ", " + Integer.toString(ing.get(key)) + ", ";
            }

            PreparedStatement preparedStatement = this.connection.prepareStatement(insertProductSql);
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(3, ingredientList);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //read
    public List<Product> getProducts()
    {
        String selectSql = "SELECT * FROM product";
        try
        {
            PreparedStatement psmt = this.connection.prepareStatement(selectSql);
            ResultSet rs = psmt.executeQuery();
            List<Product> productList = new ArrayList<>();
            while (rs.next())
            {
          //      Integer id = rs.getInt(1);
                String name = rs.getString(2);
                Double price = rs.getDouble(3);
                String ingredientList = rs.getString(4);

                String [] ingredientFields = ingredientList.split(", ");
                Hashtable<Ingredient, Integer> ing = new Hashtable<>();
                for (int i = 0; i < ingredientFields.length - 2; i = i + 3)
                {
                    Ingredient in = new Ingredient();
                    in.setName(ingredientFields[i]);
                    if (ingredientFields[i + 1].equals("1"))
                    {
                        in.setVegan(true);
                    }
                    else
                    {
                        in.setVegan(false);
                    }
                    Integer cant = Integer.parseInt(ingredientFields[i + 2]);
                    ing.put(in, cant);
                }
                Product p = new Product(name, price, ing);
                productList.add(p);
            }
            return productList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    //update
    public void updateProduct(Double price, String name)
    {
        String updateProduct = "UPDATE product SET price = ? WHERE name = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(updateProduct);
            preparedStatement.setDouble(1, price);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //delete
    public void deleteProduct(String name)
    {
        String deleteProduct = "DELETE FROM product WHERE name = ?";
        try
        {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteProduct);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
