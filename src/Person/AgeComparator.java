package Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person>
{
    @Override
    public int compare(Person p1, Person p2)
    {
        return p1.getAge().compareTo((p2.getAge()));
    }
}
