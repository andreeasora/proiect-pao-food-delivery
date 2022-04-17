package Orders;

public class Ingredient
{
    private String name;
    private Boolean isVegan;

    public Ingredient()
    {
        this.name = "";
    }

    public Ingredient(String name, Boolean isVegan)
    {
        this.name = name;
        this.isVegan = isVegan;
    }

    public Ingredient(Ingredient i)
    {
        this.name = i.name;
        this.isVegan = i.isVegan;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Boolean getVegan()
    {
        return isVegan;
    }

    public void setVegan(Boolean vegan)
    {
        isVegan = vegan;
    }

    @Override
    public String toString()
    {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", isVegan=" + isVegan +
                '}';
    }
}
