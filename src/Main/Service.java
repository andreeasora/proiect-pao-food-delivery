package Main;

import Orders.Ingredient;
import Orders.Order;
import Orders.Product;
import Orders.Restaurant;
import Person.Address;
import Person.Driver;
import Person.driversLicenseCategory;
import Person.Person;
import Person.AgeComparator;
import Person.User;
import Transport.Transport;
import Transport.Car;
import Transport.Scooter;
import Transport.Bicycle;
//import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
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
        System.out.println("12. Afisare ingrediente (inclusiv cantitatile) dintr-un produs al carui nume este dat");
        System.out.println("13. Afisare soferi care folosesc un mijloc de transport dat (masina, scuter, bicicleta)");
        System.out.println("14. Afisare restaurante dintr-un oras dat ca parametru");
        System.out.println("15. Afisare toti userii in ordine crescatoare dupa varsta");
        System.out.println("16. Modifica pretul unui produs dat");
        System.out.println("17. Modifica adresa unui user al carui id este dat");
        System.out.println("18. Afisare cel mai comandat produs");
        System.out.println("0. Iesire");
    }

    public User createUser()
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

    public Transport createTransport()
    {
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("Ce mijloc de transport doriti sa creati? (OPTIUNILE SUNT: masina/scuter/bicicleta) ");
        String opt = scanner.nextLine();
        String optiune = opt.replace("\n", "");
        while (true)
        {
            if (optiune.equalsIgnoreCase("masina") || optiune.equals("scuter") || optiune.equalsIgnoreCase("bicicleta"))
                break;
            else
            {
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
        if (optiune.equalsIgnoreCase("masina"))
        {
            System.out.println("Introduceti marca masinii: ");
            String brand = scanner.nextLine();
            System.out.println("Introduceti numarul de inmatriculare: ");
            String licensePlate = scanner.nextLine();
            System.out.println("Introduceti tipul de combustibil: (benzina/motorina etc) ");
            String combustible = scanner.nextLine();
            Transport tr = new Car(idTrans, speed, orders, brand, licensePlate, combustible);
            return tr;
        } else if (optiune.equalsIgnoreCase("scuter"))
        {
            System.out.println("Are echipament de protectie? (true/false) ");
            Boolean hasProtectiveEquipment = scanner.nextBoolean();
            scanner.nextLine();
            System.out.println("Introduceti numarul de inmatriculare: ");
            String licensePlate = scanner.nextLine();
            Transport tr = new Scooter(idTrans, speed, orders, hasProtectiveEquipment, licensePlate);
            return tr;
        } else
        {
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

    public Driver createDriver()
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

    public Ingredient createIngredient()
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

    public Product createProduct()
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
        if (ans.equalsIgnoreCase("da"))
        {
            System.out.println("Cate ingrediente contine produsul? Introduceti numarul lor: ");
            Integer nr = scanner.nextInt();
            scanner.nextLine();
            for (int i = 1; i <= nr; i++)
            {
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

    public Address createAddress()
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

    public Restaurant createRestaurant()
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
        for (int i = 1; i <= nr; i++)
        {
            System.out.println("Produs " + i + ": ");
            Product p = createProduct();
            menu.add(p);
        }
        Restaurant r = new Restaurant(id, name, a, menu);
        return r;
    }

    public Order createOrder(Integer idUser, Integer idRes)
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
        for (int i = 1; i <= nr; i++)
        {
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

    public void setValue(Order orderForSetValue)
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
        List<User> users = new ArrayList<>();
        List<Transport> transports= new ArrayList<>();
        List<Driver> drivers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<Restaurant> restaurants = new ArrayList<>();
        List<Address> addresses = new ArrayList<>();
        int option;
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
                    users.add(u);
                    System.out.println(u);
                    break;
                case 2:
                    Transport t = createTransport();
                    transports.add(t);
                    System.out.println(t);
                    break;
                case 3:
                    Driver d = createDriver();
                    drivers.add(d);
                    System.out.println(d);
                    break;
                case 4:
                    Ingredient i = createIngredient();
                    ingredients.add(i);
                    System.out.println(i);
                    break;
                case 5:
                    Product p = createProduct();
                    products.add(p);
                    System.out.println(p);
                    break;
                case 6:
                    Restaurant r = createRestaurant();
                    restaurants.add(r);
                    System.out.println(r);
                    break;
                case 7:
                    Address a = createAddress();
                    addresses.add(a);
                    System.out.println(a);
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
                        for(Order o : orders)
                        {
                            if(o.getIdUser().equals(IdUser))
                            {
                                System.out.println(o);
                                ok = 1;
                            }
                        }
                        if (ok == 0)
                            System.out.println("User-ul introdus nu a plasat nicio comanda!");
                    }
                    else
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
                            setValue(o);
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
                            break;
                        }
                    }
                    if (!foundRes)
                        System.out.println("Nu exista restaurant cu numele respectiv!");
                    break;
                case 12:
                    System.out.println("Introduceti numele produsului pentru care doriti sa vedeti ingredientele: ");
                    String product = scanner.nextLine();
                    Boolean foundPr = false;
                    for (Product pr : products)
                    {
                        if (pr.getName().equalsIgnoreCase(product))
                        {
                            foundPr = true;
                            showIngredients(pr);
                        }
                    }
                    if (!foundPr)
                        System.out.println("Nu exista produs cu numele respectiv!");
                    break;
                case 13:
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
                case 14:
                    System.out.println("Introduceti numele orasului din care doriti sa vedeti lista de restaurante: ");
                    String city = scanner.nextLine();
                    Boolean foundRestaurant = false;
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
                case 15:
                    AgeComparator comparator = new AgeComparator();
                    users.sort(comparator);
                    for (User user : users)
                    {
                        System.out.println(user);
                    }
                    break;
                case 16:
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
                            break;
                        }
                    }
                    if (!foundProduct)
                        System.out.println("Nu exista produs cu numele respectiv!");
                    break;
                case 17:
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
                            break;
                        }
                    }
                    if (!foundUser)
                        System.out.println("Nu exista user cu id-ul introdus!");
                    break;
                case 18:
                    String result = searchProduct(orders);
                    System.out.println("Cel mai comandat produs este: " + result);
                    break;
                case 0:
                    System.out.println("O zi buna! :)");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiunea este invalida, va rugam introduceti un numar valid!");
                    break;
            }
        } while (option != 0);
    }
}
