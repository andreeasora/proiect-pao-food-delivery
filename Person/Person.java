package Person;

public class Person implements Comparable<Person>
{
    protected String lastName;
    protected String firstName;
    protected String email;
    protected String phoneNumber;
    protected Integer age;

    public Person()
    {
        this.lastName  = "";
        this.firstName = "";
        this.email = "";
        this.phoneNumber = "";
        this.age = 0;
    }

    public Person(String lastName, String firstName, String email, String phoneNumber, Integer age)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Person(Person p)
    {
        this.lastName = p.lastName;
        this.firstName = p.firstName;
        this.email = p.email;
        this.phoneNumber = p.phoneNumber;
        this.age = p.age;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    @Override
    public int compareTo(Person p)
    {
        return this.age - p.age; //ordine crescatoare
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
