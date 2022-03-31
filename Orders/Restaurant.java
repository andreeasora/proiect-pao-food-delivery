package Orders;

import Person.Address;

import java.util.ArrayList;
import java.util.List;

public class Restaurant
{
    private Integer idRestaurant;
    private String name;
    private Address address;
    private List<Product> menu = new ArrayList<Product>();

    public Restaurant()
    {
        this.idRestaurant = 0;
        this.name = "";
        this.address = new Address();
        this.menu = new ArrayList<>();
    }

    public Restaurant(Integer idRestaurant ,String name, Address address, List<Product> menu)
    {
        this.idRestaurant = idRestaurant;
        this.name = name;
        this.address = address;
        this.menu = menu;
    }

    public Restaurant(Restaurant r)
    {
        this.idRestaurant = r.idRestaurant;
        this.name = r.name;
        this.address = r.address;
        this.menu = r.menu;
    }

    public Integer getIdRestaurant()
    {
        return idRestaurant;
    }

    public void setIdRestaurant(Integer idRestaurant)
    {
        this.idRestaurant = idRestaurant;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public List<Product> getMenu()
    {
        return menu;
    }

    public void setMenu(List<Product> menu)
    {
        this.menu = menu;
    }

    @Override
    public String toString()
    {
        return "Restaurant{" +
                "idRestaurant=" + idRestaurant +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", menu=" + menu +
                '}';
    }
}
