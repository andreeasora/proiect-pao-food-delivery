package Transport;

public class Bicycle extends Transport
{
    private Boolean hasProtectiveEquipment;
    private Boolean isElectric;

    public Bicycle()
    {
        super();
        this.hasProtectiveEquipment = false;
        this.isElectric = false;
    }

    public Bicycle(Integer idTransport, Integer maximumSpeed, Integer maximumNoOfOrdersPerTransport, Boolean hasProtectiveEquipment, Boolean isElectric)
    {
        super(idTransport, maximumSpeed, maximumNoOfOrdersPerTransport);
        this.hasProtectiveEquipment = hasProtectiveEquipment;
        this.isElectric = isElectric;
    }

    public Bicycle(Bicycle b)
    {
        super(b);
        this.hasProtectiveEquipment = b.hasProtectiveEquipment;
        this.isElectric = b.isElectric;
    }

    public Boolean getHasProtectiveEquipment()
    {
        return hasProtectiveEquipment;
    }

    public void setHasProtectiveEquipment(Boolean hasProtectiveEquipment)
    {
        this.hasProtectiveEquipment = hasProtectiveEquipment;
    }

    public Boolean getElectric()
    {
        return isElectric;
    }

    public void setElectric(Boolean electric)
    {
        isElectric = electric;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "hasProtectiveEquipment=" + hasProtectiveEquipment +
                ", isElectric=" + isElectric +
                ", maximumSpeed=" + maximumSpeed +
                ", maximumNoOfOrdersPerTransport=" + maximumNoOfOrdersPerTransport +
                '}';
    }
}
