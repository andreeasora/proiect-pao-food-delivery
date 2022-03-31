package Orders;

import java.util.ArrayList;
import java.util.Hashtable;

public class Product
{
    private String name;
    private Double price;
    private Hashtable<Ingredient, Integer> ingredientList = new Hashtable<Ingredient, Integer>();

    private Product()
    {
        this.name = "";
        this.price = 0.0;
        this.ingredientList = new Hashtable<>();
    }

    public Product(String name, Double price, Hashtable<Ingredient, Integer> ingredientList)
    {
        this.name = name;
        this.price = price;
        this.ingredientList = ingredientList;
    }

    private Product(Product p)
    {
        this.name = p.name;
        this.price = p.price;
        this.ingredientList = p.ingredientList;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Hashtable<Ingredient, Integer> getIngredientList()
    {
        return ingredientList;
    }

    public void setIngredientList(Hashtable<Ingredient, Integer> ingredientList)
    {
        this.ingredientList = ingredientList;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", ingredientList=" + ingredientList +
                '}';
    }
}
