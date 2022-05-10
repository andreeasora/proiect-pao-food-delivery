package Main;

import Orders.Ingredient;
import Orders.Order;
import Orders.Product;
import Orders.Restaurant;
import Transport.Car;
import java.io.*;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class WriteData
{
    private static WriteData instance;

    public static WriteData getInstance()
    {
        if (instance == null)
        {
            instance = new WriteData();
        }
        return instance;
    }

    private WriteData()
    {

    }

    public <T> void writeInCsv(Object ob, String path, String className)
    {
         try
         {
             FileWriter writer = new FileWriter(path, true);
             if(className.equalsIgnoreCase("class Transport.Car"))
             {
                 Car u = (Car) ob;
                 writer.write("\n");
                 writer.write(u.getIdTransport().toString() + ", ");
                 writer.write(u.getMaximumSpeed().toString() + ", ");
                 writer.write(u.getMaximumNoOfOrdersPerTransport().toString() + ", ");
                 writer.write(u.getBrand() + ", ");
                 writer.write(u.getLicensePlate() + ", ");
                 writer.write(u.getCombustible());
                 writer.flush();
             }
             if(className.equalsIgnoreCase("class Orders.Order"))
             {
                 Order o = (Order) ob;
                 writer.write("\n");
                 writer.write(o.getIdOrder().toString() + ", ");
                 writer.write(o.getIdUser().toString() + ", ");
                 writer.write(o.getIdRestaurant().toString() + ", ");
                 writer.write(o.getValue().toString() + ", ");
                 writer.write(o.getPaymentMethod() + ", ");
                 Hashtable<Product, Integer> lista = o.getProductList();
                 Iterator<Product> it = lista.keySet().iterator();
                 int nr = 0;
                 while (it.hasNext() && nr < 3)
                 {
                     nr = nr + 1;
                     Product key = it.next();
                     writer.write(key.getName() + ", ");
                     if (nr == 3)
                         writer.write(lista.get(key).toString());
                     else
                         writer.write(lista.get(key).toString() + ", ");
                 }
                 if (nr < 3) // 3 deoarece atatea coloane retin in fisierul csv - 3 produse si cantitatile lor/comanda
                 {
                     while (nr < 2)
                     {
                         writer.write(", , ");
                         nr = nr + 1;
                     }
                     writer.write(", ");
                 }
                 writer.flush();
             }
             if(className.equalsIgnoreCase("class Orders.Restaurant"))
             {
                 Restaurant r = (Restaurant) ob;
                 writer.write("\n");
                 writer.write(r.getIdRestaurant().toString() + ", ");
                 writer.write(r.getName() + ", ");
                 writer.write(r.getAddress().getStreet() + ", ");
                 writer.write(r.getAddress().getNumber().toString() + ", ");
                 writer.write(r.getAddress().getCity() + ", ");
                 writer.write(r.getAddress().getCounty() + ", ");
                 writer.write(r.getAddress().getPostalCode().toString() + ", ");
                 List<Product> lista = r.getMenu();
                 int nr = 0;
                 for (int i = 0; i < lista.size() && nr < 7; i++)
                 {
                     nr = nr + 1;
                     if (nr == 7)
                         writer.write(lista.get(i).getName());
                     else
                         writer.write(lista.get(i).getName() + ", ");
                 }
                 if (nr < 7) // 7 deoarece atatea coloane retin in fisierul csv - 7 produse in meniu
                 {
                     while (nr < 6) //deoarece o , o am din afisarea anterioara
                     {
                         writer.write(", ");
                         nr = nr + 1;
                     }
                 }
                 writer.flush();
             }
             if(className.equalsIgnoreCase("class Orders.Product"))
             {
                 Product p = (Product) ob;
                 writer.write("\n");
                 writer.write(p.getName() + ", ");
                 writer.write(p.getPrice().toString() + ", ");
                 Hashtable<Ingredient, Integer> lista = p.getIngredientList();
                 Iterator<Ingredient> it = lista.keySet().iterator();
                 int nr = 0;
                 while (it.hasNext() && nr < 3) {
                     nr = nr + 1;
                     Ingredient key = it.next();
                     writer.write(key.getName() + ", ");
                     writer.write(key.getVegan() + ", ");
                     if (nr == 3)
                         writer.write(lista.get(key).toString());
                     else
                         writer.write(lista.get(key).toString() + ", ");
                 }
                 if (nr < 3) // 3 deoarece atatea coloane retin in fisierul csv - 3 ingrediente si cantitatile lor/produs
                 {
                     while (nr < 2) {
                         writer.write(", , , ");
                         nr = nr + 1;
                     }
                     writer.write(", , ");
                 }
                 writer.flush();
             }
         }
         catch (Exception e)
         {
             System.out.println(e.toString());
         }
    }
}