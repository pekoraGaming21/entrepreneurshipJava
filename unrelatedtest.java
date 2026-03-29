import java.util.Random;
public class unrelatedtest 
{
    public static void main(String[] args) 
    {

        int numberofhits = 1000000;
        int numberofcrits = 0;
        double totaldamage = 0;
        for (int i = 1; i <= numberofhits; i++)
        {
            boolean crit = false;
            if (Math.random() <= 0.4)
            {
                crit = true;
            }

            if (i % 2 == 0)
            {
                crit = true;
            }
            if (crit == true)
            {
                numberofcrits++;
                //System.out.println("add crit");
            }
            totaldamage += 20;
            if (crit)
            {
                totaldamage += 4;
            }
        }

        System.out.println("Number of Crits: " + numberofcrits);
        double avgdamage = totaldamage / numberofhits;
        System.out.println("avg damage:" + avgdamage);    
    }
}
