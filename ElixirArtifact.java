import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ElixirArtifact extends Artifact
{
    Character character;

   
    private ElixirArtifact(String type, String main, double mainV, Substat one, Substat two, Substat three, Substat four, String special)
    {   
        super(type, main, mainV, one, two, three, four, special);
    }


    public static ElixirArtifact create(String ArtifactType, String[] Stats)
    {
        // assuming a 1/3 chance for 4 liner (double check)
        boolean threeliner = true;
        if (Math.random() < (1/3))
        {
            threeliner = false;
        }
        
        Random random = new Random();

        String[] StatList = {
        "HP", "HP", "HP", "HP", "HP", "HP", 
        "PHP", "PHP", "PHP", "PHP", 
        "DEF", "DEF", "DEF", "DEF", "DEF", "DEF",
        "PDEF", "PDEF", "PDEF", "PDEF", 
        "ATK", "ATK", "ATK", "ATK", "ATK", "ATK", 
        "PATK", "PATK", "PATK", "PATK", 
        "EM", "EM", "EM", "EM", 
        "ER", "ER", "ER", "ER", 
        "CR", "CR", "CR", 
        "CD", "CD", "CD"
        };

        
        ArrayList<String> StatChoose = new ArrayList<String>(Arrays.asList(StatList));

        
        double mainValue = GetMainStatValue(Stats[0]);
        StatChoose = RemoveStatFromArray(Stats[0], StatChoose);

        String Stat1Name = Stats[1];
        StatChoose = RemoveStatFromArray(Stat1Name, StatChoose);
        String Stat2Name = Stats[2];
        StatChoose = RemoveStatFromArray(Stat2Name, StatChoose);
        String Stat3Name = StatChoose.get(random.nextInt(StatChoose.size()));
        StatChoose = RemoveStatFromArray(Stat3Name, StatChoose);
        String Stat4Name = StatChoose.get(random.nextInt(StatChoose.size()));
        StatChoose = RemoveStatFromArray(Stat4Name, StatChoose);

        double Stat1Value = RandomChooseNumberStat(Stat1Name);
        double Stat2Value = RandomChooseNumberStat(Stat2Name);
        double Stat3Value = RandomChooseNumberStat(Stat3Name);
        double Stat4Value = RandomChooseNumberStat(Stat4Name);

        int guarenteedrolls = 2;

        for (int i = 0; i < 5; i++)
        {
            if (guarenteedrolls > 0)
            {
                guarenteedrolls--;
                int StatSelect = random.nextInt(2) + 1;
                
                if (StatSelect == 1)
                {
                    Stat1Value += RandomChooseNumberStat(Stat1Name);
                }
                else if (StatSelect == 2)
                {
                    Stat2Value += RandomChooseNumberStat(Stat2Name);
                }
            }

            else if (threeliner)
            {
                threeliner = false;
            }
            else
            {
                int StatSelect = random.nextInt(4) + 1;
                
                if (StatSelect == 1)
                {
                    Stat1Value += RandomChooseNumberStat(Stat1Name);
                }
                else if (StatSelect == 2)
                {
                    Stat2Value += RandomChooseNumberStat(Stat2Name);
                }
                else if (StatSelect == 3)
                {
                    
                    Stat3Value += RandomChooseNumberStat(Stat3Name);
                }
                else if (StatSelect == 4)
                {
                    Stat4Value += RandomChooseNumberStat(Stat4Name);
                }   
            }
        }
        return new ElixirArtifact(ArtifactType, Stats[0], mainValue, new Substat(Stat1Name, Stat1Value), new Substat(Stat2Name, Stat2Value), new Substat(Stat3Name, Stat3Value), new Substat(Stat4Name, Stat4Value), "Elixir");
    }
    
    

    //public BetterElixir

    public static double RandomChooseNumberStat(String StatName)
    {
        // All numbers gotten from wiki.
        double[] HPList = {209.13, 239.00, 269.88, 298.75};
        double[] PHPList = {0.0408, 0.0466, 0.0525, 0.0583};
        double[] DEFList = {16.20, 18.52, 20.83, 23.15};
        double[] PDEFList = {0.0510, 0.0583, 0.0656, 0.0729};
        double[] ATKList = {13.62, 15.56, 17.51, 19.45};
        double[] PATKList = {0.0408, 0.0466, 0.0525, 0.0583};
        double[] EMList = {16.32, 18.65, 20.98, 23.31};
        double[] ERList = {4.53, 5.18, 5.83, 6.48};
        double[] CRList = {2.72, 3.11, 3.50, 3.89};
        double[] CDList = {5.44, 6.22, 6.99, 7.77};
        // given a the substat name, will randomly select one of four preset values
        Random random = new Random();
        if (StatName == "HP")
        {
            return HPList[random.nextInt(HPList.length)];
        }
        else if (StatName == "PHP")
        {
            return PHPList[random.nextInt(PHPList.length)];
        }
        else if (StatName == "DEF")
        {
            return DEFList[random.nextInt(DEFList.length)];
        }
        else if (StatName == "PDEF")
        {
            return PDEFList[random.nextInt(PDEFList.length)];
        }
        else if (StatName == "ATK")
        {
            return ATKList[random.nextInt(ATKList.length)];
        }
        else if (StatName == "PATK")
        {
            return PATKList[random.nextInt(PATKList.length)];
        }
        else if (StatName == "EM")
        {
            return EMList[random.nextInt(EMList.length)];
        }
        else if (StatName == "ER")
        {
            return ERList[random.nextInt(ERList.length)];
        }
        else if (StatName == "CR")
        {
            return CRList[random.nextInt(CRList.length)];
        }
        else if (StatName == "CD")
        {
            return CDList[random.nextInt(CDList.length)];
        }
        return -1;
    }

    public static ArrayList<String> RemoveStatFromArray(String Stat, ArrayList<String> StatList)
    {
        // Remove all of a certain stat in the list
        int count = 0;
        for (String stat : StatList)
        {
            if (stat.equals(Stat))
            {count++;}
        }
        for (int i = 0; i < count; i++)
            {StatList.remove(Stat);}

        return StatList;
    }

    public static double GetMainStatValue(String stat)
    {
        double returner = 0;

        if (stat.equals("HP"))
        {returner = 4780;}
        else if (stat.equals("ATK"))
        {returner = 311;}
        else if (stat.equals("PHP") || stat.equals("PATK") || stat.equals("PDMG") || stat.equals("HDMG") || stat.equals("ADMG") || stat.equals("EDMG") || stat.equals("DDMG") || stat.equals("CDMG") || stat.equals("GDMG"))
        {returner = 0.466;}
        else if (stat.equals("PDEF") || stat.equals("PHDMG"))
        {returner = 0.583;}
        else if (stat.equals("EM"))
        {returner = 186.5;}
        else if (stat.equals("ER"))
        {returner = 51.8;}
        else if (stat.equals("CR"))
        {returner = 31.1;}
        else if (stat.equals("CD"))
        {returner = 62.2;}
        else if (stat.equals("HBonus"))
        {returner = 35.9;}


        return returner;
    }


        // Take in artifact type, mainstat, and two stats
        // Determine 3 or 4 liner (accurately) and find the two other stats with their values

        // Roll artifact 
            // guarentee two into the top 2
}    

