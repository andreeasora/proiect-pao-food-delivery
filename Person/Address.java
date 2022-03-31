package Person;

public class Address
{
    private String street;
    private Integer number;
    private String city;
    private String county;
    private Integer postalCode;

    public Address()
    {
        this.street = "";
        this.number = 0;
        this.city = "";
        this.county = "";
        this.postalCode = 0;
    }

    public Address(String street, Integer number, String city, String county, Integer postalCode)
    {
        this.street = street;
        this.number = number;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
    }

    private Address(Address a)
    {
        this.street = a.street;
        this.number = a.number;
        this.city = a.city;
        this.county = a.county;
        this.postalCode = a.postalCode;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public Integer getNumber()
    {
        return number;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCounty()
    {
        return county;
    }

    public void setCounty(String county)
    {
        this.county = county;
    }

    public Integer getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode)
    {
        this.postalCode = postalCode;
    }

    @Override
    public String toString()
    {
        return "Address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
