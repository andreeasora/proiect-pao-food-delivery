package Orders;

import java.util.ArrayList;
import java.util.Hashtable;

public class Order
{
    private Integer idOrder;
    private Integer idUser;
    private Integer idRestaurant;
    private Double value;
    private String paymentMethod;
    private Hashtable<Product, Integer> productList = new Hashtable<>();

    public Order()
    {
        this.idOrder = 0;
        this.idUser = 0;
        this.idRestaurant = 0;
        this.value = 0.0;
        this.paymentMethod = "";
        this.productList = new Hashtable<>();
    }

    public Order(Integer idOrder, Integer idUser, Integer idRestaurant, Double value, String paymentMethod, Hashtable<Product, Integer> productList)
    {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.idRestaurant = idRestaurant;
        this.value = value;
        this.paymentMethod = paymentMethod;
        this.productList = productList;
    }

    public Order(Order o)
    {
        this.idOrder = o.idOrder;
        this.idUser = o.idUser;
        this.idRestaurant = o.idRestaurant;
        this.value = o.value;
        this.paymentMethod = o.paymentMethod;
        this.productList = o.productList;
    }

    public Integer getIdOrder()
    {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder)
    {
        this.idOrder = idOrder;
    }

    public Integer getIdUser()
    {
        return idUser;
    }

    public void setIdUser(Integer idUser)
    {
        this.idUser = idUser;
    }

    public Integer getIdRestaurant()
    {
        return idRestaurant;
    }

    public void setIdRestaurant(Integer idRestaurant)
    {
        this.idRestaurant = idRestaurant;
    }

    public Double getValue()
    {
        return value;
    }

    public void setValue(Double value)
    {
        this.value = value;
    }

    public String getPaymentMethod()
    {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    public Hashtable<Product, Integer> getProductList()
    {
        return productList;
    }

    public void setProductList(Hashtable<Product, Integer> productList)
    {
        this.productList = productList;
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", idRestaurant=" + idRestaurant +
                ", value=" + value +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", productList=" + productList +
                '}';
    }
}
