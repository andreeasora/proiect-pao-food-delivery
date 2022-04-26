package Transport;

public class Transport
{
    protected Integer idTransport;
    protected Integer maximumSpeed;
    protected Integer maximumNoOfOrdersPerTransport; //numar maxim de comenzi transportate la un drum

    public Transport()
    {
        this.idTransport = 0;
        this.maximumSpeed = 0;
        this.maximumNoOfOrdersPerTransport = 0;
    }

    public Transport(Integer idTransport, Integer maximumSpeed, Integer maximumNoOfOrdersPerTransport)
    {
        this.idTransport = idTransport;
        this.maximumSpeed = maximumSpeed;
        this.maximumNoOfOrdersPerTransport = maximumNoOfOrdersPerTransport;
    }

    public Transport(Transport t)
    {
        this.idTransport = t.idTransport;
        this.maximumSpeed = t.maximumSpeed;
        this.maximumNoOfOrdersPerTransport = t.maximumNoOfOrdersPerTransport;
    }

    public Integer getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(Integer idTransport) {
        this.idTransport = idTransport;
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
                "idTransport=" + idTransport +
                ", maximumSpeed=" + maximumSpeed +
                ", maximumNoOfOrdersPerTransport=" + maximumNoOfOrdersPerTransport +
                '}';
    }
}
