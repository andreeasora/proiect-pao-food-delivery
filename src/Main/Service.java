package Main;

import Orders.Ingredient;
import Orders.Order;
import Orders.Product;
import Orders.Restaurant;
import Person.Address;
import Person.Driver;
import Person.driversLicenseCategory;
import Person.AgeComparator;
import Person.User;
import Transport.Transport;
import Transport.Car;
import Transport.Scooter;
import Transport.Bicycle;
import JDBC.conexiuneJDBC;
import JDBC.carPreparedStatements;
import JDBC.orderPreparedStatements;
import JDBC.restaurantPreparedStatements;
import JDBC.productPreparedStatements;
//import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.util.*;

public class Service
{
    public Service()
    {

    }

    private void printOptions()
    {
        System.out.println("\n---Sora Andreea-Ioana/Grupa 234/Grupa 11 Lab PAO/Proiect - Programare avansata pe obiecte/Tema: Food Delivery---");
        System.out.println("Actiunile posibile: ");
        System.out.println("1. Creare User");
        System.out.println("2. Adaugare mijloc de transport (masina, scuter sau bicicleta)");
        System.out.println("3. Adaugare sofer");
        System.out.println("4. Adaugare ingredient");
        System.out.println("5. Adaugare produs");
        System.out.println("6. Adaugare restaurant");
        System.out.println("7. Adaugare adresa");
        System.out.println("8. Afisare comenzi pentru un user dat");
        System.out.println("9. Plaseaza comanda pentru un user dat (id) , catre un restaurant dat (id)");
        System.out.println("10. Seteaza valoarea unei comenzi (id comanda citit de la tastatura) in functie de preparatele pe care le cuprinde, cat si de cantitatile lor");
        System.out.println("11. Afisare meniu al unui restaurant al carui nume este dat");
        System.out.println("12. Afisare soferi care folosesc un mijloc de transport dat (masina, scuter, bicicleta)");
        System.out.println("13. Afisare restaurante dintr-un oras dat ca parametru");
        System.out.println("14. Afisare toti userii in ordine crescatoare dupa varsta");
        System.out.println("15. Modifica pretul unui produs dat");
        System.out.println("16. Modifica adresa unui user al carui id este dat");
        System.out.println("17. Afisare cel mai comandat produs");
        System.out.println("18. Streams - Pentru lista username-urilor tuturor userilor cititi, se fac diferite afisari - cu majuscule, cele ce contin litera e, sortate alfabetic");
        System.out.println("19. Lambda - Afisati pentru fiecare user: Nume - Prenume - Username");
        System.out.println("20. Afisare toate informatiile din tabelele din baza de date (order, product, car, restaurant)");
        System.out.println("21. Modifica numarul de inmatriculare al unei masini al carei id este citit de la tastatura");
        System.out.println("22. Modifica numele unui restaurant al carui id este citit de la tastatura");
        System.out.println("23. Stergere din baza de date dupa un anumit id din tabela restaurant");
        System.out.println("24. Stergere din baza de date dupa un anumit id din tabela car");
        System.out.println("25. Stergere din baza de date dupa un anumit nume din tabela product");
        System.out.println("26. Stergere din baza de date dupa un anumit id din tabela order");
        System.out.println("0. Iesire");
    }

    public User createUser()
    {
        try
        {
            Scanner scanner;
            scanner = new Scanner(System.in);
            System.out.println("Introduceti numele userului: ");
            String lastName = scanner.nextLine();
            System.out.println("Introduceti prenumele userului: ");
            String firstName = scanner.nextLine();
            System.out.println("Introduceti email-ul userului: ");
            String email = scanner.nextLine();
            System.out.println("Introduceti numarul de telefon al userului: ");
            String phoneNo = scanner.nextLine();
            System.out.println("Introduceti varsta userului: ");
            Integer age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Introduceti id-ul user-ului: ");
            Integer id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Introduceti username: ");
            String username = scanner.nextLine();
            Address a = createAddress();
            User u = new User(lastName, firstName, email, phoneNo, age, id, username, a);
            return u;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
    }

    public Transport createTransport()
    {
        try
        {
            Scanner scanner;
            scanner = new Scanner(System.in);
            System.out.println("Ce mijloc de transport doriti sa creati? (OPTIUNILE SUNT: masina/scuter/bicicleta) ");
            String opt = scanner.nextLine();
            String optiune = opt.replace("\n", "");
            while (true) {
                if (optiune.equalsIgnoreCase("masina") || optiune.equals("scuter") || optiune.equalsIgnoreCase("bicicleta"))
                    break;
                else {
                    System.out.println("Nu ati introdus o optiune valida, incercati din nou!");
                    System.out.println("Reintroduceti optiunea: ");
                    opt = scanner.nextLine();
                    optiune = opt.replace("\n", "");
                }
            }
            System.out.println("Introduceti id-ul mijlocului de transport: ");
            Integer idTrans = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Introduceti viteza maxima a mijlocului de transport: ");
            Integer speed = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Introduceti numarul de comenzi maxim ce poate fi transportat la un drum: ");
            Integer orders = scanner.nextInt();
            scanner.nextLine();
            if (optiune.equalsIgnoreCase("masina")) {
                System.out.println("Introduceti marca masinii: ");
                String brand = scanner.nextLine();
                System.out.println("Introduceti numarul de inmatriculare: ");
                String licensePlate = scanner.nextLine();
                System.out.println("Introduceti tipul de combustibil: (benzina/motorina etc) ");
                String combustible = scanner.nextLine();
                Transport tr = new Car(idTrans, speed, orders, brand, licensePlate, combustible);
                return tr;
            } else if (optiune.equalsIgnoreCase("scuter")) {
                System.out.println("Are echipament de protectie? (true/false) ");
                Boolean hasProtectiveEquipment = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println("Introduceti numarul de inmatriculare: ");
                String licensePlate = scanner.nextLine();
                Transport tr = new Scooter(idTrans, speed, orders, hasProtectiveEquipment, licensePlate);
                return tr;
            } else {
                System.out.println("Are echipament de protectie? (true/false) ");
                Boolean hasProtectiveEquipment = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println("Este electrica? (true/false) ");
                Boolean isElectric = scanner.nextBoolean();
                scanner.nextLine();
                Transport tr = new Bicycle(idTrans, speed, orders, hasProtectiveEquipment, isElectric);
                return tr;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
    }

    public Driver createDriver()
    {
        try
        {
            Scanner scanner;
            scanner = new Scanner(System.in);
            System.out.println("Introduceti numele soferului: ");
            String lastName = scanner.nextLine();
            System.out.println("Introduceti prenumele soferului: ");
            String firstName = scanner.nextLine();
            System.out.println("Introduceti email-ul soferului: ");
            String email = scanner.nextLine();
            System.out.println("Introduceti numarul de telefon al soferului: ");
            String phoneNo = scanner.nextLine();
            System.out.println("Introduceti varsta soferului: ");
            Integer age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Introduceti categoria de permis pe care o are: (A1, A2, B1, B, C1, C) ");
            String drivers = scanner.nextLine();
            driversLicenseCategory driverLicense;
            if (drivers.equalsIgnoreCase("A1"))
                driverLicense = driversLicenseCategory.A1;
            else if (drivers.equalsIgnoreCase("A2"))
                driverLicense = driversLicenseCategory.A2;
            else if (drivers.equalsIgnoreCase("B1"))
                driverLicense = driversLicenseCategory.B1;
            else if (drivers.equalsIgnoreCase("B"))
                driverLicense = driversLicenseCategory.B;
            else if (drivers.equalsIgnoreCase("C1"))
                driverLicense = driversLicenseCategory.C1;
            else if (drivers.equalsIgnoreCase("C"))
                driverLicense = driversLicenseCategory.C;
            else
                driverLicense = driversLicenseCategory.A1;
            Transport transport = createTransport();
            Driver dr = new Driver(lastName, firstName, email, phoneNo, age, driverLicense, transport);
            return dr;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
    }

    public Ingredient createIngredient()
    {
        try
        {
            Scanner scanner;
            scanner = new Scanner(System.in);
            System.out.println("Introduceti numele ingredientului: ");
            String name = scanner.nextLine();
            System.out.println("Ingredientul este vegan? (true/false) ");
            Boolean vegan = scanner.nextBoolean();
            scanner.nextLine();
            Ingredient i = new Ingredient(name, vegan);
            return i;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
    }

    public Product createProduct()
    {
        try
        {
            Scanner scanner;
            scanner = new Scanner(System.in);
            System.out.println("Introduceti numele produsului: ");
            String name = scanner.nextLine();
            System.out.println("Introduceti pretul produsului: ");
            Double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Doriti sa stabiliti lista de ingrediente pentru acest produs? (da/nu) ");
            String ans = scanner.nextLine();
            Hashtable<Ingredient, Integer> ingregientList = new Hashtable<>();
            if (ans.equalsIgnoreCase("da")) {
                System.out.println("Cate ingrediente contine produsul? Introduceti numarul lor: ");
                Integer nr = scanner.nextInt();
                scanner.nextLine();
                for (int i = 1; i <= nr; i++) {
                    System.out.println("Ingredientul " + i + " : ");
                    Ingredient ing = createIngredient();
                    System.out.println("In ce cantitate se gaseste ingredientul " + i + "? (numar intreg -> exemplu: 3 oua/exprimat in grame -> exemplu: 300 g zahar) ");
                    Integer cant = scanner.nextInt();
                    scanner.nextLine();
                    ingregientList.put(ing, cant);
                }
            }
            Product p = new Product(name, price, ingregientList);
            return p;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
    }

    public Address createAddress()
    {
        try
        {
            Scanner scanner;
            scanner = new Scanner(System.in);
            System.out.println("Strada: ");
            String street = scanner.nextLine();
            System.out.println("Numar: ");
            Integer no = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Oras: ");
            String city = scanner.nextLine();
            System.out.println("Judet: ");
            String county = scanner.nextLine();
            System.out.println("Cod postal: ");
            Integer postalCode = scanner.nextInt();
            Address a = new Address(street, no, city, county, postalCode);
            return a;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
    }

    public Restaurant createRestaurant()
    {
        try
        {
            Scanner scanner;
            scanner = new Scanner(System.in);
            System.out.println("Introduceti id-ul restaurantului: ");
            Integer id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Introduceti numele restaurantului: ");
            String name = scanner.nextLine();
            System.out.println("Adresa restaurantului: ");
            Address a = createAddress();
            System.out.println("Meniul restaurantului: ");
            System.out.println("Cate produse contine meniul? ");
            Integer nr = scanner.nextInt();
            scanner.nextLine();
            List<Product> menu = new ArrayList<Product>();
            for (int i = 1; i <= nr; i++) {
                System.out.println("Produs " + i + ": ");
                Product p = createProduct();
                menu.add(p);
            }
            Restaurant r = new Restaurant(id, name, a, menu);
            return r;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
    }

    public Order createOrder(Integer idUser, Integer idRes)
    {
        try
        {
            Scanner scanner;
            scanner = new Scanner(System.in);
            System.out.println("Introduceti id-ul comenzii: ");
            Integer idOrder = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Introduceti metoda de plata: (cash/card) ");
            String methodOfPayment = scanner.nextLine();
            Double value = 0.0;
            System.out.println("Cate produse (diferite) contine comanda? Introduceti numarul lor: ");
            Integer nr = scanner.nextInt();
            scanner.nextLine();
            Hashtable<Product, Integer> productList = new Hashtable<Product, Integer>();
            for (int i = 1; i <= nr; i++) {
                System.out.println("Produsul " + i + " : ");
                Product p = createProduct();
                System.out.println("In ce cantitate se gaseste produsul " + i + "?");
                Integer cant = scanner.nextInt();
                scanner.nextLine();
                productList.put(p, cant);
            }
            Order o = new Order(idOrder, idUser, idRes, value, methodOfPayment, productList);
            return o;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
    }

    public void setValue(Order orderForSetValue, orderPreparedStatements orderJDBC)
    {
        Hashtable<Product, Integer> productList = orderForSetValue.getProductList();
        Iterator<Product> it = productList.keySet().iterator();
        double totalPrice = 0.0;
        while (it.hasNext())
        {
            Product key = it.next();
            totalPrice += key.getPrice() * productList.get(key);
        }
        orderForSetValue.setValue(totalPrice);
        orderJDBC.updateOrder(totalPrice, orderForSetValue.getIdOrder());
        System.out.println("Valoarea comenzii cu id-ul citit este: " + totalPrice);
    }

    public void showMenu(Restaurant r)
    {
        System.out.println(r.getMenu());
    }

    public void showIngredients(Product p)
    {
        Hashtable<Ingredient, Integer> ingredientList = p.getIngredientList();
        Iterator<Ingredient> it = ingredientList.keySet().iterator();
        while (it.hasNext())
        {
            Ingredient key = it.next();
            System.out.println(key + " in cantitatea: " + ingredientList.get(key));
        }
    }

    public String searchProduct(List<Order> orders)
    {
        Hashtable<Product, Integer> productList;
        Hashtable<String, Integer> list = new Hashtable<String, Integer>();
        for (Order o:orders)
        {
            productList = o.getProductList();
            Iterator<Product> it = productList.keySet().iterator();
            while (it.hasNext())
            {
                Product key = it.next();
                list.put(key.getName(),list.getOrDefault(key.getName(), 0)+productList.get(key));
            }
        }
        int maxim = -9999999;
        String produs = "";
        Iterator<String> iter = list.keySet().iterator();
        while (iter.hasNext())
        {
            String key = iter.next();
            if (list.get(key) > maxim)
            {
                maxim = list.get(key);
                produs = key;
            }
        }
        return produs;
    }

    public void chooseOption()
    {
        Scanner scanner;
        scanner = new Scanner(System.in);
        ReadData rd = ReadData.getInstance();
        List<User> users = new ArrayList<>();
        List<Transport> transports = rd.readCsv("src/CSV_Files/car.csv", "class Transport.Car");
        List<Driver> drivers = new ArrayList<>();
     //   List<Order> orders = rd.readCsv("src/CSV_Files/order.csv", "class Orders.Order");
        List<Ingredient> ingredients = new ArrayList<>();
       // List<Product> products = rd.readCsv("src/CSV_Files/product.csv", "class Orders.Product");
       // List<Restaurant> restaurants = rd.readCsv("src/CSV_Files/restaurant.csv", "class Orders.Restaurant");
        List<Address> addresses = new ArrayList<>();
        WriteData wr = WriteData.getInstance();
        Connection connection = conexiuneJDBC.getDatabaseConnection();
        carPreparedStatements carJDBC = new carPreparedStatements(connection);
        orderPreparedStatements orderJDBC = new orderPreparedStatements(connection);
        restaurantPreparedStatements restaurantJDBC = new restaurantPreparedStatements(connection);
        productPreparedStatements productJDBC = new productPreparedStatements(connection);
        List<Product> products = productJDBC.getProducts();
        List<Order> orders = orderJDBC.getOrders();
        List<Restaurant> restaurants = restaurantJDBC.getRestaurants();
        List<Car> cars = carJDBC.getCars();
        int option;
        Audit audit = Audit.getInstance();
        do
        {
            printOptions();
            System.out.println("\nIntroduceti optiunea dorita: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option)
            {
                case 1:
                    User u = createUser();
                    if (u != null)
                    {
                        users.add(u);
                    }
                    System.out.println(u);
                    audit.writeAction("createUser");
                    break;
                case 2:
                    Transport t = createTransport();
                    if (t != null)
                    {
                        transports.add(t);
                    }
                    System.out.println(t);
                    if (t.getClass().toString().equalsIgnoreCase("class Transport.Car"))
                    {
                       // wr.writeInCsv(t,"src/CSV_Files/car.csv","class Transport.Car");
                        carJDBC.insertCar((Car)t);
                        cars = carJDBC.getCars();
                    }
                    audit.writeAction("createTransport");
                    break;
                case 3:
                    Driver d = createDriver();
                    if (d != null)
                    {
                        drivers.add(d);
                    }
                    System.out.println(d);
                    audit.writeAction("createDriver");
                    break;
                case 4:
                    Ingredient i = createIngredient();
                    if (i != null)
                    {
                        ingredients.add(i);
                    }
                    System.out.println(i);
                    audit.writeAction("createIngredient");
                    break;
                case 5:
                    Product p = createProduct();
                    if (p != null)
                    {
                        products.add(p);
                    }
                //    wr.writeInCsv(p,"src/CSV_Files/product.csv","class Orders.Product");
                    productJDBC.insertProduct(p);
                    products = productJDBC.getProducts();
                    audit.writeAction("createProduct");
                    System.out.println(p);
                    break;
                case 6:
                    Restaurant r = createRestaurant();
                    if (r != null)
                    {
                        restaurants.add(r);
                    }
                    System.out.println(r);
                    restaurantJDBC.insertRestaurant(r);
                    restaurants = restaurantJDBC.getRestaurants();
                 //   wr.writeInCsv(r,"src/CSV_Files/restaurant.csv","class Orders.Restaurant");
                    audit.writeAction("createRestaurant");
                    break;
                case 7:
                    Address a = createAddress();
                    if (a != null)
                    {
                        addresses.add(a);
                    }
                    System.out.println(a);
                    audit.writeAction("createAddress");
                    break;
                case 8:
                    System.out.println("Introduceti id-ul user-ului pentru care doriti vizualizarea comenzilor: ");
                    Integer IdUser = scanner.nextInt();
                    scanner.nextLine();
                    boolean foundID = false;
                    int ok = 0;
                    for (User us : users)
                    {
                        if ((us.getIdUser()).equals(IdUser))
                        {
                            foundID = true;
                            break;
                        }
                    }
                    if (foundID)
                    {
                        for (Order o : orders)
                        {
                            if (o.getIdUser().equals(IdUser))
                            {
                                System.out.println(o);
                                ok = 1;
                            }
                        }
                        audit.writeAction("ordersForGivenUser");
                        if (ok == 0)
                            System.out.println("User-ul introdus nu a plasat nicio comanda!");
                    } else
                        System.out.println("Nu exista user cu id-ul introdus!");
                    break;
                case 9:
                    System.out.println("Introduceti id-ul user-ului pentru care doriti plasarea comenzii: ");
                    Integer idUser = scanner.nextInt();
                    scanner.nextLine();
                    boolean found1 = false;
                    for (User us : users)
                    {
                        if ((us.getIdUser()).equals(idUser))
                        {
                            found1 = true;
                            break;
                        }
                    }
                    if (found1)
                    {
                        boolean found2 = false;
                        System.out.println("Introduceti id-ul restaurantului catre care plasati comanda: ");
                        Integer idRes = scanner.nextInt();
                        scanner.nextLine();
                        for (Restaurant res : restaurants)
                        {
                            if ((res.getIdRestaurant()).equals(idRes))
                            {
                                found2 = true;
                                break;
                            }
                        }
                        if (found2)
                        {
                            Order o = createOrder(idUser, idRes);
                            orders.add(o);
                            orderJDBC.insertOrder(o);
                            orders = orderJDBC.getOrders();
                          //  wr.writeInCsv(o,"src/CSV_Files/order.csv","class Orders.Order");
                            audit.writeAction("placeOrder");
                            System.out.println(o);
                        }
                        else
                            System.out.println("Id-ul restaurantului nu exista!");
                    }
                    else
                        System.out.println("Id-ul userului nu exista!");
                    break;
                case 10:
                    System.out.println("Introduceti id-ul comenzii pentru care doriti setarea corespunzatoare a valorii ei: ");
                    Integer idOrder = scanner.nextInt();
                    scanner.nextLine();
                    boolean foundId = false;
                    for (Order o: orders)
                    {
                        if ((o.getIdOrder()).equals(idOrder))
                        {
                            foundId = true;
                            setValue(o, orderJDBC);
                            audit.writeAction("setValueForOrder");
                            break;
                        }
                    }
                    if (!foundId)
                        System.out.println("Nu exista comanda cu id-ul introdus!");
                    break;
                case 11:
                    System.out.println("Introduceti numele restaurantului pentru care doriti sa vedeti meniul: ");
                    String name = scanner.nextLine();
                    Boolean foundRes = false;
                    for (Restaurant res : restaurants){
                        if (res.getName().equalsIgnoreCase(name))
                        {
                            showMenu(res);
                            foundRes = true;
                            audit.writeAction("showMenu");
                            break;
                        }
                    }
                    if (!foundRes)
                        System.out.println("Nu exista restaurant cu numele respectiv!");
                    break;
                case 12:
                    System.out.println("Introduceti mijlocul de transport pentru care doriti sa vedeti lista soferilor care il folosesc: (masina/scuter/bicicleta) ");
                    String transport = scanner.nextLine();
                    String trOpt = transport.replace("\n", "");
                    while (true)
                    {
                        if (trOpt.equalsIgnoreCase("masina") || trOpt.equalsIgnoreCase("scuter") || trOpt.equalsIgnoreCase("bicicleta"))
                            break;
                        else
                        {
                            System.out.println("Nu ati introdus o optiune valida, incercati din nou!");
                            System.out.println("Reintroduceti optiunea: ");
                            transport = scanner.nextLine();
                            trOpt = transport.replace("\n", "");
                        }
                    }
                    boolean foundDriver = false;
                    audit.writeAction("driversListWithGivenTransport");
                    for (Driver dr : drivers)
                    {
                        if (dr.getTr() instanceof Car && trOpt.equalsIgnoreCase("masina"))
                        {
                            System.out.println(dr);
                            foundDriver = true;
                        }
                        else if (dr.getTr() instanceof Scooter && trOpt.equalsIgnoreCase("scuter"))
                        {
                            System.out.println(dr);
                            foundDriver = true;
                        }
                        else if (dr.getTr() instanceof Bicycle && trOpt.equalsIgnoreCase("bicicleta"))
                        {
                            System.out.println(dr);
                            foundDriver = true;
                        }
                    }
                    if (!foundDriver)
                        System.out.println("Nu exista niciun sofer care foloseste mijlocul de transport introdus!");
                    break;
                case 13:
                    System.out.println("Introduceti numele orasului din care doriti sa vedeti lista de restaurante: ");
                    String city = scanner.nextLine();
                    Boolean foundRestaurant = false;
                    audit.writeAction("restaurantsFromGivenCity");
                    for (Restaurant res : restaurants)
                    {
                        Address ad = res.getAddress();
                        if (ad.getCity().equalsIgnoreCase(city))
                        {
                            System.out.println(res);
                            foundRestaurant = true;
                        }
                    }
                    if (!foundRestaurant)
                        System.out.println("Nu exista niciun restaurant in orasul transmis ca parametru!");
                    break;
                case 14:
                    AgeComparator comparator = new AgeComparator();
                    users.sort(comparator);
                    for (User user : users)
                    {
                        System.out.println(user);
                    }
                    audit.writeAction("sortUsersByAge");
                    break;
                case 15:
                    System.out.println("Introduceti numele produsului pentru care doriti sa modificati pretul: ");
                    String productPrice = scanner.nextLine();
                    Boolean foundProduct = false;
                    for (Product pr : products)
                    {
                        if (pr.getName().equalsIgnoreCase(productPrice))
                        {
                            foundProduct = true;
                            System.out.println("Introduceti noul pret: ");
                            Double newPrice = scanner.nextDouble();
                            scanner.nextLine();
                            pr.setPrice(newPrice);
                            System.out.println(pr);
                            productJDBC.updateProduct(newPrice, productPrice);
                            products = productJDBC.getProducts();
                            audit.writeAction("changePriceForGivenProduct");
                            break;
                        }
                    }
                    if (!foundProduct)
                        System.out.println("Nu exista produs cu numele respectiv!");
                    break;
                case 16:
                    System.out.println("Introduceti id-ul user-ului pentru care doriti schimbarea adresei: ");
                    Integer idUserAddr = scanner.nextInt();
                    scanner.nextLine();
                    boolean foundUser = false;
                    for (User us : users)
                    {
                        if ((us.getIdUser()).equals(idUserAddr))
                        {
                            foundUser = true;
                            System.out.println("Introduceti noua adresa: ");
                            Address newAddress = createAddress();
                            us.setAddress(newAddress);
                            System.out.println(us);
                            audit.writeAction("changeAddressForGivenUser");
                            break;
                        }
                    }
                    if (!foundUser)
                        System.out.println("Nu exista user cu id-ul introdus!");
                    break;
                case 17:
                    String result = searchProduct(orders);
                    System.out.println("Cel mai comandat produs este: " + result);
                    audit.writeAction("searchProduct");
                    break;
                case 18:
                    List<String> usernameList = new ArrayList<>();
                    for (User us:users)
                    {
                        usernameList.add(us.getUsername());
                    }
                    System.out.println("Username-uri cu majuscule - MAP: ");
                    usernameList.stream()
                            .map(usname->usname.toUpperCase())
                            .forEach(System.out::println);
                    System.out.println("Username-uri ce contin litera e - FILTER: ");
                    usernameList.stream()
                            .filter(usname->usname.contains("e"))
                            .forEach(System.out::println);
                    System.out.println("Username-uri sortate alfabetic - SORTED: ");
                    usernameList.stream()
                            .sorted()
                            .forEach(System.out::println);
                    audit.writeAction("streamsUsername");
                    break;
                case 19:
                    users.forEach(us -> System.out.println(us.getFirstName() + " " + us.getLastName() + " " + us.getUsername()));
                    audit.writeAction("lambdaUser");
                    break;
                case 20:
                    cars = carJDBC.getCars();
                    System.out.println("Masinile din tabela car: ");
                    for (Car c : cars)
                    {
                        System.out.println(c);
                    }
                    restaurants = restaurantJDBC.getRestaurants();
                    System.out.println("Restaurantele din tabela restaurant: ");
                    for (Restaurant rt : restaurants)
                    {
                        System.out.println(rt);
                    }
                    products = productJDBC.getProducts();
                    System.out.println("Produsele din tabela product: ");
                    for (Product prd : products)
                    {
                        System.out.println(prd);
                    }
                    orders = orderJDBC.getOrders();
                    System.out.println("Comenzile din tabela order: ");
                    for (Order ord : orders)
                    {
                        System.out.println(ord);
                    }
                    audit.writeAction("getFromDB");
                    break;
                case 21:
                    System.out.println("Introduceti id-ul masinii careia vreti sa ii modificati numarul de inmatriculare: ");
                    Integer idCar = scanner.nextInt();
                    scanner.nextLine();
                    boolean foundIdCar = false;
                    for (Car car: cars)
                    {
                        if ((car.getIdTransport()).equals(idCar))
                        {
                            foundIdCar = true;
                            System.out.println("Introduceti noul numar de inmatriculare: ");
                            String newLicensePlate = scanner.nextLine();
                            carJDBC.updateCar(newLicensePlate, idCar);
                            cars = carJDBC.getCars();
                            audit.writeAction("changeLicensePlate");
                            break;
                        }
                    }
                    if (!foundIdCar)
                        System.out.println("Nu exista masina cu id-ul introdus!");
                    break;
                case 22:
                    System.out.println("Introduceti id-ul restaurantului caruia vreti sa ii modificati numele: ");
                    Integer idResUpdate = scanner.nextInt();
                    scanner.nextLine();
                    boolean foundIdResUpdate = false;
                    for (Restaurant rs : restaurants)
                    {
                        if ((rs.getIdRestaurant()).equals(idResUpdate))
                        {
                            foundIdResUpdate = true;
                            System.out.println("Introduceti noul nume al restaurantului: ");
                            String newName = scanner.nextLine();
                            restaurantJDBC.updateRestaurant(newName, idResUpdate);
                            restaurants = restaurantJDBC.getRestaurants();
                            audit.writeAction("changeRestaurantName");
                            break;
                        }
                    }
                    if (!foundIdResUpdate)
                        System.out.println("Nu exista restaurant cu id-ul introdus!");
                    break;
                case 23:
                    System.out.println("Introduceti id-ul restaurantului pe care doriti sa il stergeti din baza de date: ");
                    Integer idResDelete = scanner.nextInt();
                    scanner.nextLine();
                    boolean foundIdRes = false;
                    for (Restaurant res: restaurants)
                    {
                        if ((res.getIdRestaurant()).equals(idResDelete))
                        {
                            foundIdRes = true;
                            restaurantJDBC.deleteRestaurant(idResDelete);
                            restaurants = restaurantJDBC.getRestaurants();
                            audit.writeAction("deleteRestaurantFromDB");
                            break;
                        }
                    }
                    if (!foundIdRes)
                        System.out.println("Nu exista restaurant cu id-ul introdus!");
                    break;
                case 24:
                    System.out.println("Introduceti id-ul masinii pe care doriti sa o stergeti din baza de date: ");
                    Integer idCarDelete = scanner.nextInt();
                    scanner.nextLine();
                    boolean foundIdCarDelete = false;
                    for (Car car: cars)
                    {
                        if ((car.getIdTransport()).equals(idCarDelete))
                        {
                            foundIdCarDelete = true;
                            carJDBC.deleteCar(idCarDelete);
                            cars = carJDBC.getCars();
                            audit.writeAction("deleteCarFromDB");
                            break;
                        }
                    }
                    if (!foundIdCarDelete)
                        System.out.println("Nu exista masina cu id-ul introdus!");
                    break;
                case 25:
                    System.out.println("Introduceti numele produsului pe care doriti sa il stergeti din baza de date: ");
                    String namePr = scanner.nextLine();
                    boolean foundNameProductDelete = false;
                    for (Product pr: products)
                    {
                        if ((pr.getName()).equals(namePr))
                        {
                            foundNameProductDelete = true;
                            productJDBC.deleteProduct(namePr);
                            products = productJDBC.getProducts();
                            audit.writeAction("deleteProductFromDB");
                            break;
                        }
                    }
                    if (!foundNameProductDelete)
                        System.out.println("Nu exista produs cu numele introdus!");
                    break;
                case 26:
                    System.out.println("Introduceti id-ul comenzii pe care doriti sa o stergeti din baza de date: ");
                    Integer idOrderDelete = scanner.nextInt();
                    scanner.nextLine();
                    boolean foundIdOrderDelete = false;
                    for (Order or: orders)
                    {
                        if ((or.getIdOrder()).equals(idOrderDelete))
                        {
                            foundIdOrderDelete = true;
                            orderJDBC.deleteOrder(idOrderDelete);
                            orders = orderJDBC.getOrders();
                            audit.writeAction("deleteOrderFromDB");
                            break;
                        }
                    }
                    if (!foundIdOrderDelete)
                        System.out.println("Nu exista comanda cu id-ul introdus!");
                    break;
                case 0:
                    System.out.println("O zi buna! :)");
                    audit.writeAction("exit");
                    conexiuneJDBC.closeDatabaseConfiguration();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiunea este invalida, va rugam introduceti un numar valid!");
                    break;
            }
        } while (option != 0);
    }
}