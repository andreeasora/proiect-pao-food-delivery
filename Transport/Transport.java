package Transport;

public class Transport
{
    protected Integer maximumSpeed;
    protected Integer maximumNoOfOrdersPerTransport; //numar maxim de comenzi transportate la un drum

    public Transport()
    {
        this.maximumSpeed = 0;
        this.maximumNoOfOrdersPerTransport = 0;
    }

    public Transport(Integer maximumSpeed, Integer maximumNoOfOrdersPerTransport)
    {
        this.maximumSpeed = maximumSpeed;
        this.maximumNoOfOrdersPerTransport = maximumNoOfOrdersPerTransport;
    }

    public Transport(Transport t)
    {
        this.maximumSpeed = t.maximumSpeed;
        this.maximumNoOfOrdersPerTransport = t.maximumNoOfOrdersPerTransport;
    }

    public Integer getMaximumSpeed()
    {
        return maximumSpeed;
    }

    public void setMaximumSpeed(Integer maximumSpeed)
    {
        this.maximumSpeed = maximumSpeed;
    }

    public Integer getMaximumNoOfOrdersPerTransport()
    {
        return maximumNoOfOrdersPerTransport;
    }

    public void setMaximumNoOfOrdersPerTransport(Integer maximumNoOfOrdersPerTransport)
    {
        this.maximumNoOfOrdersPerTransport = maximumNoOfOrdersPerTransport;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "maximumSpeed=" + maximumSpeed +
                ", maximumNoOfOrdersPerTransport=" + maximumNoOfOrdersPerTransport +
                '}';
    }
}
