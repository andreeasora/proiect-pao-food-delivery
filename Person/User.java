package Person;

public class User extends Person
{
    private Integer idUser;
    private String username;
    private Address address;

    public User()
    {
        super();
        this.idUser = 0;
        this.username = "";
        this.address = new Address();
    }

    public User(String lastName, String firstName, String email, String phoneNumber, Integer age, Integer idUser, String username, Address address)
    {
        super(lastName, firstName, email, phoneNumber, age);
        this.idUser = idUser;
        this.username = username;
        this.address = address;
    }

    public User(User u)
    {
        super(u);
        this.idUser = u.idUser;
        this.username = u.username;
        this.address = u.address;
    }

    public Integer getIdUser()
    {
        return idUser;
    }

    public void setIdUser(Integer idUser)
    {
        this.idUser = idUser;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", idUser=" + idUser +
                ", username='" + username + '\'' +
                ", address=" + address +
                '}';
    }
}
