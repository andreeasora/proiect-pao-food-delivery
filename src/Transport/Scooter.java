package Transport;

public class Scooter extends Transport
{
    private Boolean hasProtectiveEquipment;
    private String licensePlate; //numar inmatriculare

    public Scooter()
    {
        super();
        this.hasProtectiveEquipment = false;
        this.licensePlate = "";
    }

    public Scooter(Integer idTransport ,Integer maximumSpeed, Integer maximumNoOfOrdersPerTransport, Boolean hasProtectiveEquipment, String licensePlate)
    {
        super(idTransport, maximumSpeed, maximumNoOfOrdersPerTransport);
        this.hasProtectiveEquipment = hasProtectiveEquipment;
        this.licensePlate = licensePlate;
    }

    public Scooter(Scooter s)
    {
        super(s);
        this.hasProtectiveEquipment = s.hasProtectiveEquipment;
        this.licensePlate = s.licensePlate;
    }

    public Boolean getHasProtectiveEquipment()
    {
        return hasProtectiveEquipment;
    }

    public void setHasProtectiveEquipment(Boolean hasProtectiveEquipment)
    {
        this.hasProtectiveEquipment = hasProtectiveEquipment;
    }

    public String getLicensePlate()
    {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "hasProtectiveEquipment=" + hasProtectiveEquipment +
                ", licensePlate='" + licensePlate + '\'' +
                ", idTransport=" + idTransport +
                ", maximumSpeed=" + maximumSpeed +
                ", maximumNoOfOrdersPerTransport=" + maximumNoOfOrdersPerTransport +
                '}';
    }
}
