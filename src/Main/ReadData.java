package Main;

import Orders.Ingredient;
import Orders.Order;
import Orders.Product;
import Orders.Restaurant;
import Person.Address;
import Transport.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ReadData
{
    private static ReadData instance;

    public static ReadData getInstance()
    {
        if (instance == null)
        {
            instance = new ReadData();
        }
        return instance;
    }

    private ReadData()
    {

    }

    public <T> List<T> readCsv(String path, String className)
    {
        List<T> list = new ArrayList<>();
        try
        {
            var reader = new BufferedReader(new FileReader(path));
            List<String[]> info = new ArrayList<>();
            String line = reader.readLine();
            while (line != null)
            {
                String[] values = line.replaceAll(" ", "").split(",");
                info.add(values);
                line = reader.readLine();
            }
            if(className.equalsIgnoreCase("class Transport.Car"))
            {
                int ok = 0;
                for (var el : info)
                {
                    if (ok == 0)
                        ok = 1;
                    else
                    {
                        int id = Integer.parseInt(el[0]);
                        int sp = Integer.parseInt(el[1]);
                        int maxOr = Integer.parseInt(el[2]);
                        Car c = new Car(id, sp, maxOr, el[3], el[4], el[5]);
                        list.add((T) c);
                    }
                }
            }
            if(className.equalsIgnoreCase("class Orders.Restaurant"))
            {
                int ok = 0;
                for (var el : info)
                {
                    if (ok == 0)
                        ok = 1;
                    else
                    {
                        int id = Integer.parseInt(el[0]);
                        int nrAdresa = Integer.parseInt(el[3]);
                        int cod = Integer.parseInt(el[6]);
                        Address a = new Address(el[2], nrAdresa, el[4], el[5], cod);
                        List<Product> p = new ArrayList<>();
                        for (int i = 7; i<el.length; i++)
                        {
                            if (el[i] != null)
                            {
                                Product pr = new Product();
                                pr.setName(el[i]);
                                p.add(pr);
                            }
                        }
                        Restaurant r = new Restaurant(id, el[1], a, p);
                        list.add((T) r);
                    }
                }
            }
            if(className.equalsIgnoreCase("class Orders.Order"))
            {
                int ok = 0;
                for (var el : info)
                {
                    if (ok == 0)
                        ok = 1;
                    else
                    {
                        int idO = Integer.parseInt(el[0]);
                        int idU = Integer.parseInt(el[1]);
                        int idR = Integer.parseInt(el[2]);
                        double v = 0.0;
                        if (!el[3].equals(""))
                        {
                            v = Double.parseDouble(el[3]);
                        }
                        Hashtable<Product, Integer> lista = new Hashtable<>();
                        for (int i = 5; i<el.length-1; i = i+2)
                        {
                            if (el[i] != null && el[i+1]!=null)
                            {
                                Product pr = new Product();
                                pr.setName(el[i]);
                                int cant = Integer.parseInt(el[i+1]);
                                lista.put(pr, cant);
                            }
                        }

                        Order od = new Order(idO, idU, idR, v, el[4], lista);
                        list.add((T) od);
                    }
                }
            }
            if(className.equalsIgnoreCase("class Orders.Product"))
            {
                int ok = 0;
                for (var el : info)
                {
                    if (ok == 0)
                        ok = 1;
                    else
                    {
                        double price = Double.parseDouble(el[1]);
                        Hashtable<Ingredient, Integer> lista = new Hashtable<>();
                        for (int i = 2; i<el.length-2; i = i+3)
                        {
                            if (el[i] != null && el[i+1]!=null && el[i+2] != null)
                            {
                                boolean vegan = Boolean.parseBoolean(el[i+1]);
                                Ingredient ing = new Ingredient(el[i], vegan);
                                int cant = Integer.parseInt(el[i+2]);
                                lista.put(ing, cant);
                            }
                        }
                        Product pr = new Product(el[0], price, lista);
                        list.add((T) pr);
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return list;
    }
}
