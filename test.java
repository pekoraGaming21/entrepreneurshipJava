import java.util.ArrayList;
import java.util.Arrays;

public class test 
{
    public static void main(String[] args) 
    {
        double[] CRList = {2.72, 3.11, 3.50, 3.89};

        double[] RVList = {70, 80, 90, 100};

        
        ArrayList<double[]> CDRVList = new ArrayList<double[]>();

        ArrayList<double[]> SideCDRVList = new ArrayList<double[]>();

        ArrayList<double[]> SideRVList = new ArrayList<double[]>();


        for (int initial = 0; initial < RVList.length; initial++)
        {
            double[] temp = {CRList[initial], RVList[initial]};
            CDRVList.add(temp);
            double[] rvtemp = {RVList[initial]};
            SideRVList.add(rvtemp);

        }

        // first roll

        // iterate how many elements there are in the big list
        for (int roll = 1; roll <= 5; roll++)
        {
            
            for (int first = 0; first < CDRVList.size(); first++)

            // go through every element and add the same element plus one of the rolls

            {
                for (int firstroll = 0; firstroll < RVList.length; firstroll++)
                {
                    boolean isinarray = false;


                    double[] temp1 = {CDRVList.get(first)[0] + CRList[firstroll], CDRVList.get(first)[1] + RVList[firstroll]};

                    for (int element = 0; element < SideRVList.size(); element++)
                    {
                        //System.out.println("Checking comparison: " + (CDRVList.get(first)[1] + RVList[firstroll]) + " and " + SideRVList.get(element)[0]);
                        if ((CDRVList.get(first)[1] + RVList[firstroll]) == (SideRVList.get(element)[0]))
                        {
                            //System.out.println("They are the same");
                            isinarray = true;
                        }
                    }

                    if (!isinarray)
                    {
                        SideCDRVList.add(temp1);
                        double[] rvtemp = {temp1[1]};
                        SideRVList.add(rvtemp);
                    }
                    else
                    {
                        isinarray = false;
                    }  
                }  
            }
            for (int i = 0; i < SideCDRVList.size(); i++)
                {
                    CDRVList.add(SideCDRVList.get(i));
                }
            SideCDRVList.clear();
        }




        
        for (int i = 0; i < CDRVList.size(); i++)
        {
            System.out.println(CDRVList.get(i)[0] + ": " + CDRVList.get(i)[1]);
        }
        


        System.out.print("{");
        for (int i = 0; i < CDRVList.size(); i++)
        {
            System.out.print(CDRVList.get(i)[0] + ", ");
        }
        System.out.print("}");

        System.out.println();
        System.out.println();

        System.out.print("[");
        for (int i = 0; i < SideRVList.size(); i++)
        {
        //System.out.print(SideRVList.get(i)[0] + ", ");
        }
        System.out.print("]");

        //double[] CDList = {5.44, 6.22, 6.99, 7.77, 10.88, 11.66, 12.43, 13.21, 13.989999999999998, 14.76, 15.54, 16.32, 17.1, 17.87, 18.65, 19.43, 20.2, 20.98, 21.759999999999998, 22.53, 23.31, 24.09, 24.87, 25.64, 26.419999999999998, 27.2, 27.97, 28.75, 29.529999999999998, 30.3, 31.08, 31.86, 32.64, 33.41, 34.19, 34.97, 35.739999999999995, 36.519999999999996, 37.3, 38.07, 38.849999999999994, 39.629999999999995, 40.41, 41.17999999999999, 41.959999999999994, 42.739999999999995, 43.50999999999999, 44.28999999999999, 45.06999999999999, 45.84, 46.61999999999999};

        System.out.println();
        //System.out.println("CD List length: " + ShortCDList.length);
        //System.out.println("RV List length: " + SideRVList.size());


    }    
}
