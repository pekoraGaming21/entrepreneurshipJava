import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class RandomArtifact extends Artifact
{
    private RandomArtifact(String type, String main, double mainV, Substat one, Substat two, Substat three, Substat four)
    {
        super(type, main, mainV, one, two, three, four);
    }

    public static RandomArtifact create(String type)
    {
        String[] artifactTypeList = {"Flower", "Feather", "Sands", "Goblet", "Circlet"};

        boolean threeliner = true;
        Random random = new Random();

        if (type.equals(null))
        {
            type = artifactTypeList[random.nextInt(artifactTypeList.length)];
        }

        String[] StatList = {
        "FlatHP", "FlatHP", "FlatHP", "FlatHP", "FlatHP", "FlatHP", 
        "PHP", "PHP", "PHP", "PHP", 
        "FlatDEF", "FlatDEF", "FlatDEF", "FlatDEF", "FlatDEF", "FlatDEF",
        "PDEF", "PDEF", "PDEF", "PDEF", 
        "FlatATK", "FlatATK", "FlatATK", "FlatATK", "FlatATK", "FlatATK", 
        "PATK", "PATK", "PATK", "PATK", 
        "EM", "EM", "EM", "EM", 
        "ER", "ER", "ER", "ER", 
        "CR", "CR", "CR", 
        "CD", "CD", "CD"
        };

        if (Math.random() >= 0.2)
        {
            threeliner = false;
        }
        
        ArrayList<String> StatChoose = new ArrayList<String>(Arrays.asList(StatList));

        String main = GetMainName(type);
        double mainValue = GetMainStatValue(main);
        StatChoose = RemoveStatFromArray(main, StatChoose);

        String Stat1Name = RandomChooseStats(StatChoose);
        String Stat2Name = RandomChooseStats(StatChoose);
        String Stat3Name = RandomChooseStats(StatChoose);
        String Stat4Name = RandomChooseStats(StatChoose);

        double Stat1Value = RandomChooseNumberStat(Stat1Name);
        double Stat2Value = RandomChooseNumberStat(Stat2Name);
        double Stat3Value = RandomChooseNumberStat(Stat3Name);
        double Stat4Value = RandomChooseNumberStat(Stat4Name);

        for (int i = 0; i < 5; i++)
        {
            if (threeliner)
            {
                threeliner = true;
            }
            else
            {
                int StatSelect = random.nextInt(4) + 1;
                
                if (StatSelect == 1)
                {
                    double increment = RandomChooseNumberStat(Stat1Name);
                    Stat1Value += increment;
                }
                else if (StatSelect == 2)
                {
                    double increment = RandomChooseNumberStat(Stat2Name);
                    Stat2Value += increment;
                }
                else if (StatSelect == 3)
                {
                    double increment = RandomChooseNumberStat(Stat3Name);
                    Stat3Value += increment;
                }
                else if (StatSelect == 4)
                {
                    double increment = RandomChooseNumberStat(Stat4Name);
                    Stat4Value += increment;
                }   
            }
        }
        return new RandomArtifact(type, main, mainValue, new Substat(Stat1Name, Stat1Value), new Substat(Stat2Name, Stat2Value), new Substat(Stat3Name, Stat3Value), new Substat(Stat4Name, Stat4Value));
    }
    
    public static String GetMainName(String artifactType)
    {
        Random random = new Random();
        String[] SandsMainStatList = {
        "PHP", "PHP", "PHP", "PHP", "PHP", "PHP", "PHP", "PHP", 
        "PDEF", "PDEF", "PDEF", "PDEF", "PDEF", "PDEF", "PDEF", "PDEF", 
        "PATK", "PATK", "PATK", "PATK", "PATK", "PATK", "PATK", "PATK", 
        "EM", "EM", "EM", 
        "ER", "ER", "ER"};
        String[] GobletMainStatList = CreateGobletMainStatList(); // probabilities are specific, manual list creation would be extremely long
        String[] CircletMainStatList = {
        "PHP", "PHP", "PHP", "PHP", "PHP", "PHP", "PHP", "PHP", "PHP", "PHP", "PHP", 
        "PDEF", "PDEF", "PDEF", "PDEF", "PDEF", "PDEF", "PDEF", "PDEF", "PDEF", "PDEF", "PDEF", 
        "PATK", "PATK", "PATK", "PATK", "PATK", "PATK", "PATK", "PATK", "PATK", "PATK", "PATK", 
        "EM", "EM", 
        "CR", "CR", "CR", "CR", "CR", 
        "CD", "CD", "CD", "CD", "CD",
        "HBonus", "HBonus", "HBonus", "HBonus", "HBonus"};
        if (artifactType == "Flower")
        {
            return "FlatHP";
        }

        else if (artifactType == "Feather")
        {
            return "FlatATK";
        }
        else if (artifactType == "Sands")
        {
            return SandsMainStatList[random.nextInt(SandsMainStatList.length)];
        }

        else if (artifactType == "Goblet")
        {
            return GobletMainStatList[random.nextInt(GobletMainStatList.length)];
        }
        else
        {
            return CircletMainStatList[random.nextInt(CircletMainStatList.length)];
        }
    }

    public static String RandomChooseStats(ArrayList<String> StatChoose)
    {
        // Select the 4 substats
        Random random = new Random();
        
        String artifactStatName = StatChoose.get(random.nextInt(StatChoose.size()));
        StatChoose = RemoveStatFromArray(artifactStatName, StatChoose);

        return artifactStatName;
    }

    public static double RandomChooseNumberStat(String StatName)
    {
        // All numbers gotten from wiki.
        double[] FlatHPList = {209.13, 239.00, 269.88, 298.75};
        double[] PHPList = {0.0408, 0.0466, 0.0525, 0.0583};
        double[] FlatDEFList = {16.20, 18.52, 20.83, 23.15};
        double[] PDEFList = {0.0510, 0.0583, 0.0656, 0.0729};
        double[] FlatATKList = {13.62, 15.56, 17.51, 19.45};
        double[] PATKList = {0.0408, 0.0466, 0.0525, 0.0583};
        double[] EMList = {16.32, 18.65, 20.98, 23.31};
        double[] ERList = {4.53, 5.18, 5.83, 6.48};
        double[] CRList = {2.72, 3.11, 3.50, 3.89};
        double[] CDList = {5.44, 6.22, 6.99, 7.77};
        // given a the substat name, will randomly select one of four preset values
        Random random = new Random();
        if (StatName == "FlatHP")
        {
            return FlatHPList[random.nextInt(FlatHPList.length)];
        }
        else if (StatName == "PHP")
        {
            return PHPList[random.nextInt(PHPList.length)];
        }
        else if (StatName == "FlatDEF")
        {
            return FlatDEFList[random.nextInt(FlatDEFList.length)];
        }
        else if (StatName == "PDEF")
        {
            return PDEFList[random.nextInt(PDEFList.length)];
        }
        else if (StatName == "FlatATK")
        {
            return FlatATKList[random.nextInt(FlatATKList.length)];
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

    public static String[] CreateGobletMainStatList()
    {
        String[] returnlist = new String[400];
        for (int i = 0; i < 77; i++)
        {returnlist[i] = "PHP";}
        for (int i = 77; i < 154; i++)
        {returnlist[i] = "PATK";}
        for (int i = 154; i < 230; i++)
        {returnlist[i] = "PDEF";}
        for (int i = 230; i < 250; i++)
        {returnlist[i] = "PHDMG";}
        for (int i = 250; i < 270; i++)
        {returnlist[i] = "PDMG";}
        for (int i = 270; i < 290; i++)
        {returnlist[i] = "HDMG";}
        for (int i = 290; i < 310; i++)
        {returnlist[i] = "ADMG";}
        for (int i = 310; i < 330; i++)
        {returnlist[i] = "EDMG";}
        for (int i = 330; i < 350; i++)
        {returnlist[i] = "DDMG";}
        for (int i = 350; i < 370; i++)
        {returnlist[i] = "CDMG";}
        for (int i = 370; i < 390; i++)
        {returnlist[i] = "GDMG";}
        for (int i = 390; i < 400; i++)
        {returnlist[i] = "EM";}
        return returnlist;
    }
}