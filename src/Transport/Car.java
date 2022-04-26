package Transport;

public class Car extends Transport
{
    private String brand;
    private String licensePlate; //numar inmatriculare
    private String combustible;

    public Car()
    {
        super();
        this.brand = "";
        this.licensePlate = "";
        this.combustible = "";
    }

    public Car(Integer maximumSpeed, Integer maximumNoOfOrdersPerTransport, String brand, String licensePlate, String combustible)
    {
        super(maximumSpeed, maximumNoOfOrdersPerTransport);
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.combustible = combustible;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getLicensePlate()
    {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }

    public String getCombustible()
    {
        return combustible;
    }

    public void setCombustible(String combustible)
    {
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", combustible='" + combustible + '\'' +
                ", maximumSpeed=" + maximumSpeed +
                ", maximumNoOfOrdersPerTransport=" + maximumNoOfOrdersPerTransport +
                '}';
    }
}
