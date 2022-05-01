package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Audit
{
    private static Audit instance;

    public static Audit getInstance()
    {
        if (instance == null)
        {
            instance = new Audit();
        }
        return instance;
    }

    private Audit()
    {

    }

    public void writeAction(String action)
    {
        try
        {
            FileWriter writer = new FileWriter("src/CSV_Files/audit.csv", true);
            writer.write("\n");
            writer.write(action);
            writer.write(", ");
            Date date = new Date(System.currentTimeMillis());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = dateFormat.format(date);
            writer.write(strDate);
            writer.flush();
        }
        catch (IOException e)
        {
            System.out.println(e.toString());
        }
    }
}
