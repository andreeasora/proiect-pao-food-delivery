package Person;

import Transport.Transport;

public class Driver extends Person
{
    private driversLicenseCategory driversLicenseCategory; ///categorie permis: A1, A2, B2 etc
    private Transport tr;

    public Driver()
    {
        super();
        this.driversLicenseCategory = driversLicenseCategory.A1;
        this.tr = new Transport();
    }

    public Driver(String lastName, String firstName, String email, String phoneNumber, Integer age, driversLicenseCategory driversLicenseCategory, Transport tr)
    {
        super(lastName, firstName, email, phoneNumber, age);
        this.driversLicenseCategory = driversLicenseCategory;
        this.tr = tr;
    }

    public Driver(Driver d)
    {
        super(d);
        this.driversLicenseCategory = d.driversLicenseCategory;
        this.tr = d.tr;
    }

    public driversLicenseCategory getDriversLicenseCategory() {
        return driversLicenseCategory;
    }

    public void setDriversLicenseCategory(driversLicenseCategory driversLicenseCategory) {
        this.driversLicenseCategory = driversLicenseCategory;
    }

    public Transport getTr()
    {
        return tr;
    }

    public void setTr(Transport tr)
    {
        this.tr = tr;
    }

    @Override
    public String toString()
    {
        return "Driver{" +
                "driversLicenseCategory='" + driversLicenseCategory + '\'' +
                ", tr=" + tr +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
