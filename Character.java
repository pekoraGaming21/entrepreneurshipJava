import java.util.ArrayList;

public class Character {
    private double baseHP;
    private double baseATK;
    private double baseDEF;

    private double totalHP;
    private double totalATK;
    private double totalDEF;
    private double EM = 0.0;

    private double CR = 5.0;
    private double CD = 50.0;

    private double ER = 100.0;  
    
    private String weaponName;
    private double weaponATK;
    private String element;
    private int level;

    private String ascendName;
    private double ascendValue;

    private String[] ExtraStatNames;
    private double[] ExtraStatValues;

    // PHDMG, PDMG, HDMG, ADMG, EDMG, DDMG, CDMG, GDMG
    private double[] elementalDMG = {0, 0, 0, 0, 0, 0, 0, 0};

    private Artifact[] arts = new Artifact[5];

    // In a future update, make it so you can set
    // your character and level and it'll autofill
    public Character(String element, int level, double bhp, double bat, double bdf, String weaponName, double weaponATK, Artifact[] a, String ascensionStatName, double ascensionStatValue, String[] ExtraStatNames, double[] ExtraStatValues){
        this.element = element;
        this.level = level;

        this.weaponName = weaponName;
        this.weaponATK = weaponATK;
        
        baseHP = bhp;
        baseATK = bat + weaponATK;
        baseDEF = bdf;
        arts = a;

        totalHP = baseHP;
        totalATK = baseATK;
        totalDEF = baseDEF;

        ascendName = ascensionStatName;
        ascendValue = ascensionStatValue;

        this.ExtraStatNames = ExtraStatNames;
        this.ExtraStatValues = ExtraStatValues;

        for (Artifact ar: a){
            
            totalATK += getRealValue("ATK", ar.getATK());
            totalATK += getRealValue("PATK", ar.getPATK()) * baseATK;
            
            totalDEF += getRealValue("DEF", ar.getDEF());
            totalDEF += getRealValue("PDEF", ar.getPDEF()) * baseDEF;
            
            totalHP += getRealValue("HP", ar.getHP());
            totalHP += getRealValue("PHP", ar.getPHP()) * baseHP;

            CR += getRealValue("CR", ar.getCR());
            CD += getRealValue("CD", ar.getCD());
            EM += getRealValue("EM", ar.getEM());
            ER += getRealValue("ER", ar.getER());

            switch (ar.getMain()){
                case "HP":
                    totalHP += ar.getMainV();
                    break;
                case "DEF":
                    totalDEF += ar.getMainV();
                    break;
                case "ATK":
                    totalATK += ar.getMainV();
                    break;
                case "PHP":
                    totalHP += ar.getMainV()*baseHP;
                    break;
                case "PDEF":
                    totalDEF += ar.getMainV()*baseDEF;
                    break;
                case "PATK":
                    totalATK += ar.getMainV()*baseATK;
                    break;
                case "EM":
                    EM += ar.getMainV();
                    break;
                case "ER":
                    ER += ar.getMainV();
                    break;
                case "CR":
                    CR += ar.getMainV();
                    break;
                case "CD":
                    CD += ar.getMainV();
                    break;
                case "PHDMG":
                    elementalDMG[0] += ar.getMainV();
                    break;
                case "PDMG":
                    elementalDMG[1] += ar.getMainV();
                    break;
                case "HDMG":
                    elementalDMG[2] += ar.getMainV();
                    break;
                case "ADMG":
                    elementalDMG[3] += ar.getMainV();
                    break;
                case "EDMG":
                    elementalDMG[4] += ar.getMainV();
                    break;
                case "DDMG":
                    elementalDMG[5] += ar.getMainV();
                    break;
                case "CDMG":
                    elementalDMG[6] += ar.getMainV();
                    break;
                case "GDMG":
                    elementalDMG[7] += ar.getMainV();
                    break;
            }
        }
        switch (ascendName){
            case "HP":
                totalHP += ascendValue;
                break;
            case "DEF":
                totalDEF += ascendValue;
                break;
            case "ATK":
                totalATK += ascendValue;
                break;
            case "PHP":
                totalHP += ascendValue * baseHP;
                break;
            case "PDEF":
                totalDEF += ascendValue * baseDEF;
                break;
            case "PATK":
                totalATK += ascendValue * baseATK;
                break;
            case "EM":
                EM += ascendValue;
                break;
            case "ER":
                ER += ascendValue;
                break;
            case "CR":
                CR += ascendValue;
                break;
            case "CD":
                CD += ascendValue;
                break;
            case "PHDMG":
                elementalDMG[0] += ascendValue;
                break;
            case "PDMG":
                elementalDMG[1] += ascendValue;
                break;
            case "HDMG":
                elementalDMG[2] += ascendValue;
                break;
            case "ADMG":
                elementalDMG[3] += ascendValue;
                break;
            case "EDMG":
                elementalDMG[4] += ascendValue;
                break;
            case "DDMG":
                elementalDMG[5] += ascendValue;
                break;
            case "CDMG":
                elementalDMG[6] += ascendValue;
                break;
            case "GDMG":
                elementalDMG[7] += ascendValue;
                break;
        }
        for (int i = 0; i < ExtraStatNames.length; i++)
        {
            switch (ExtraStatNames[i]){
                case "HP":
                    totalHP += ExtraStatValues[i];
                    break;
                case "DEF":
                    totalDEF += ExtraStatValues[i];
                    break;
                case "ATK":
                    totalATK += ExtraStatValues[i];
                    break;
                case "PHP":
                    totalHP += ExtraStatValues[i] * baseHP;
                    break;
                case "PDEF":
                    totalDEF += ExtraStatValues[i] * baseDEF;
                    break;
                case "PATK":
                    totalATK += ExtraStatValues[i] * baseATK;
                    break;
                case "EM":
                    EM += ExtraStatValues[i];
                    break;
                case "ER":
                    ER += ExtraStatValues[i];
                    break;
                case "CR":
                    CR += ExtraStatValues[i];
                    break;
                case "CD":
                    CD += ExtraStatValues[i];
                    break;
                case "PHDMG":
                    elementalDMG[0] += ExtraStatValues[i];
                    break;
                case "PDMG":
                    elementalDMG[1] += ExtraStatValues[i];
                    break;
                case "HDMG":
                    elementalDMG[2] += ExtraStatValues[i];
                    break;
                case "ADMG":
                    elementalDMG[3] += ExtraStatValues[i];
                    break;
                case "EDMG":
                    elementalDMG[4] += ExtraStatValues[i];
                    break;
                case "DDMG":
                    elementalDMG[5] += ExtraStatValues[i];
                    break;
                case "CDMG":
                    elementalDMG[6] += ExtraStatValues[i];
                    break;
                case "GDMG":
                    elementalDMG[7] += ExtraStatValues[i];
                    break;
            }
        }
    }

    public void updateStats(String element, int level, double bhp, double bat, double bdf, String weaponName, double weaponATK, Artifact[] a, String ascensionStatName, double ascensionStatValue){
        this.element = element;
        this.level = level;

        this.weaponName = weaponName;
        this.weaponATK = weaponATK;
        
        baseHP = bhp;
        baseATK = bat + weaponATK;
        baseDEF = bdf;
        arts = a;

        totalHP = baseHP;
        totalATK = baseATK;
        totalDEF = baseDEF;

        EM = 0.0;

        CR = 5.0;
        CD = 50.0;

        ER = 100.0;  

        ascendName = ascensionStatName;
        ascendValue = ascensionStatValue;

        this.ExtraStatNames = ExtraStatNames;
        this.ExtraStatValues = ExtraStatValues;

        for (Artifact ar: a){
            totalATK += getRealValue("ATK", ar.getATK());
            totalATK += getRealValue("PATK", ar.getPATK()) * baseATK;

            totalDEF += getRealValue("DEF", ar.getDEF());
            totalDEF += getRealValue("PDEF", ar.getPDEF()) * baseDEF;
            
            totalHP += getRealValue("HP", ar.getHP());
            totalHP += getRealValue("PHP", ar.getPHP()) * baseHP;

            CR += getRealValue("CR", ar.getCR());
            CD += getRealValue("CD", ar.getCD());

            EM += getRealValue("EM", ar.getEM());
            ER += getRealValue("ER", ar.getER());

            switch (ar.getMain()){
                case "HP":
                    totalHP += ar.getMainV();
                    break;
                case "DEF":
                    totalDEF += ar.getMainV();
                    break;
                case "ATK":
                    totalATK += ar.getMainV();
                    break;
                case "PHP":
                    totalHP += ar.getMainV()*baseHP;
                    break;
                case "PDEF":
                    totalDEF += ar.getMainV()*baseDEF;
                    break;
                case "PATK":
                    totalATK += ar.getMainV()*baseATK;
                    break;
                case "EM":
                    EM += ar.getMainV();
                    break;
                case "ER":
                    ER += ar.getMainV();
                    break;
                case "CR":
                    CR += ar.getMainV();
                    break;
                case "CD":
                    CD += ar.getMainV();
                    break;
                case "PHDMG":
                    elementalDMG[0] += ar.getMainV();
                    break;
                case "PDMG":
                    elementalDMG[1] += ar.getMainV();
                    break;
                case "HDMG":
                    elementalDMG[2] += ar.getMainV();
                    break;
                case "ADMG":
                    elementalDMG[3] += ar.getMainV();
                    break;
                case "EDMG":
                    elementalDMG[4] += ar.getMainV();
                    break;
                case "DDMG":
                    elementalDMG[5] += ar.getMainV();
                    break;
                case "CDMG":
                    elementalDMG[6] += ar.getMainV();
                    break;
                case "GDMG":
                    elementalDMG[7] += ar.getMainV();
                    break;
            }
        }
        switch (ascendName){
            case "HP":
                totalHP += ascendValue;
                break;
            case "DEF":
                totalDEF += ascendValue;
                break;
            case "ATK":
                totalATK += ascendValue;
                break;
            case "PHP":
                totalHP += ascendValue * baseHP;
                break;
            case "PDEF":
                totalDEF += ascendValue * baseDEF;
                break;
            case "PATK":
                totalATK += ascendValue * baseATK;
                break;
            case "EM":
                EM += ascendValue;
                break;
            case "ER":
                ER += ascendValue;
                break;
            case "CR":
                CR += ascendValue;
                break;
            case "CD":
                CD += ascendValue;
                break;
            case "PHDMG":
                elementalDMG[0] += ascendValue;
                break;
            case "PDMG":
                elementalDMG[1] += ascendValue;
                break;
            case "HDMG":
                elementalDMG[2] += ascendValue;
                break;
            case "ADMG":
                elementalDMG[3] += ascendValue;
                break;
            case "EDMG":
                elementalDMG[4] += ascendValue;
                break;
            case "DDMG":
                elementalDMG[5] += ascendValue;
                break;
            case "CDMG":
                elementalDMG[6] += ascendValue;
                break;
            case "GDMG":
                elementalDMG[7] += ascendValue;
                break;
        }
        for (int i = 0; i < ExtraStatNames.length; i++)
        {
            switch (ExtraStatNames[i]){
                case "HP":
                    totalHP += ExtraStatValues[i];
                    break;
                case "DEF":
                    totalDEF += ExtraStatValues[i];
                    break;
                case "ATK":
                    totalATK += ExtraStatValues[i];
                    break;
                case "PHP":
                    totalHP += ExtraStatValues[i] * baseHP;
                    break;
                case "PDEF":
                    totalDEF += ExtraStatValues[i] * baseDEF;
                    break;
                case "PATK":
                    totalATK += ExtraStatValues[i] * baseATK;
                    break;
                case "EM":
                    EM += ExtraStatValues[i];
                    break;
                case "ER":
                    ER += ExtraStatValues[i];
                    break;
                case "CR":
                    CR += ExtraStatValues[i];
                    break;
                case "CD":
                    CD += ExtraStatValues[i];
                    break;
                case "PHDMG":
                    elementalDMG[0] += ExtraStatValues[i];
                    break;
                case "PDMG":
                    elementalDMG[1] += ExtraStatValues[i];
                    break;
                case "HDMG":
                    elementalDMG[2] += ExtraStatValues[i];
                    break;
                case "ADMG":
                    elementalDMG[3] += ExtraStatValues[i];
                    break;
                case "EDMG":
                    elementalDMG[4] += ExtraStatValues[i];
                    break;
                case "DDMG":
                    elementalDMG[5] += ExtraStatValues[i];
                    break;
                case "CDMG":
                    elementalDMG[6] += ExtraStatValues[i];
                    break;
                case "GDMG":
                    elementalDMG[7] += ExtraStatValues[i];
                    break;
            }
        }
    }

    public double getRealValue(String statName, double statValue){
        double[] RealHPList = {0, 209.13, 239.0, 269.88, 298.75, 418.26, 448.13, 478.0, 479.01, 507.88, 508.88, 537.75, 539.76, 568.63, 597.5, 627.39, 657.26, 687.13, 688.14, 717.0, 717.01, 718.01, 746.88, 747.88, 748.89, 776.75, 777.76, 778.76, 806.63, 807.63, 809.64, 836.5, 836.52, 838.51, 866.39, 867.38, 896.25, 896.26, 897.27, 926.13, 926.14, 927.14, 956.0, 956.01, 957.01, 958.02, 985.88, 986.88, 986.89, 987.89, 1015.75, 1015.76, 1016.76, 1017.76, 1018.77, 1045.63, 1045.65, 1046.63, 1047.64, 1048.64, 1075.5, 1075.52, 1076.51, 1077.51, 1079.52, 1105.38, 1105.39, 1106.38, 1106.4, 1108.39, 1135.25, 1135.26, 1135.27, 1136.27, 1137.26, 1165.13, 1165.14, 1166.13, 1166.14, 1167.15, 1195.0, 1195.01, 1196.01, 1196.02, 1197.02, 1224.88, 1224.89, 1225.88, 1225.89, 1226.89, 1227.9, 1254.75, 1254.76, 1254.78, 1255.76, 1256.76, 1256.77, 1257.77, 1284.63, 1284.65, 1285.63, 1285.64, 1286.64, 1287.64, 1288.65, 1314.5, 1314.51, 1314.52, 1315.51, 1315.53, 1316.51, 1317.52, 1318.52, 1344.38, 1344.39, 1344.4, 1345.38, 1345.4, 1346.39, 1347.39, 1349.4, 1374.25, 1374.26, 1374.27, 1375.26, 1375.27, 1376.26, 1376.28, 1378.27, 1404.13, 1404.14, 1405.13, 1405.14, 1405.15, 1406.15, 1407.14, 1434.0, 1434.01, 1434.02, 1435.01, 1435.02, 1436.01, 1436.02, 1437.03, 1463.88, 1463.89, 1464.88, 1464.89, 1465.89, 1465.9, 1466.9, 1493.75, 1493.76, 1494.76, 1494.77, 1495.76, 1495.77, 1496.77, 1497.78, 1523.63, 1523.64, 1524.63, 1524.64, 1525.64, 1526.64, 1526.65, 1527.65, 1553.5, 1553.51, 1554.51, 1555.51, 1555.52, 1556.52, 1557.52, 1558.53, 1583.38, 1584.38, 1584.39, 1585.39, 1586.39, 1587.4, 1588.4, 1613.25, 1613.26, 1614.26, 1615.26, 1616.27, 1617.27, 1619.28, 1643.13, 1644.13, 1645.14, 1646.14, 1648.15, 1673.0, 1674.01, 1675.01, 1677.02, 1702.88, 1703.88, 1705.89, 1732.75, 1734.76, 1763.63, 1792.5};
        double[] RealPHPList = {0, 0.0408, 0.0466, 0.0525, 0.0583, 0.0816, 0.0874, 0.0933, 0.0991, 0.1049, 0.105, 0.1108, 0.1166, 0.1224, 0.1282, 0.1341, 0.1399, 0.1457, 0.1458, 0.1516, 0.1574, 0.1575, 0.1632, 0.1633, 0.169, 0.1691, 0.1749, 0.1807, 0.1865, 0.1866, 0.1924, 0.1982, 0.1983, 0.204, 0.2041, 0.2098, 0.2099, 0.21, 0.2157, 0.2158, 0.2215, 0.2216, 0.2273, 0.2274, 0.233, 0.2332, 0.239, 0.2391, 0.2448, 0.2449, 0.2506, 0.2507, 0.2508, 0.2565, 0.2566, 0.2623, 0.2624, 0.2625, 0.2681, 0.2682, 0.2683, 0.2738, 0.274, 0.2741, 0.2796, 0.2798, 0.2799, 0.2856, 0.2857, 0.2913, 0.2915, 0.2916, 0.2973, 0.2974, 0.3031, 0.3032, 0.3033, 0.309, 0.3091, 0.3148, 0.3149, 0.315, 0.3206, 0.3207, 0.3208, 0.3265, 0.3266, 0.3323, 0.3324, 0.3381, 0.3382, 0.344, 0.3498};
        double[] RealDEFList = {0, 16.2, 18.52, 20.83, 23.15, 32.4, 34.72, 37.03, 37.04, 39.35, 41.66, 41.67, 43.98, 46.3, 48.6, 50.92, 53.23, 53.24, 55.55, 55.56, 57.86, 57.87, 60.18, 60.19, 62.49, 62.5, 64.8, 64.81, 64.82, 67.12, 67.13, 69.43, 69.44, 69.45, 71.75, 71.76, 74.06, 74.07, 74.08, 76.38, 76.39, 78.69, 78.7, 78.71, 81.0, 81.01, 81.02, 83.32, 83.33, 83.34, 85.63, 85.64, 85.65, 87.95, 87.96, 87.97, 90.26, 90.27, 90.28, 92.58, 92.59, 92.6, 94.89, 94.9, 94.91, 97.2, 97.21, 97.22, 97.23, 99.52, 99.53, 99.54, 101.83, 101.84, 101.85, 101.86, 104.15, 104.16, 104.17, 106.46, 106.47, 106.48, 106.49, 108.78, 108.79, 108.8, 111.09, 111.1, 111.11, 111.12, 113.41, 113.42, 113.43, 115.72, 115.73, 115.74, 115.75, 118.04, 118.05, 118.06, 120.35, 120.36, 120.37, 120.38, 122.67, 122.68, 122.69, 124.98, 124.99, 125.0, 125.01, 127.3, 127.31, 127.32, 129.62, 129.63, 129.64, 131.94, 131.95, 134.26, 134.27, 136.58, 138.9};
        double[] RealPDEFList = {0, 0.051, 0.0583, 0.0656, 0.0729, 0.102, 0.1093, 0.1166, 0.1239, 0.1312, 0.1385, 0.1458, 0.153, 0.1603, 0.1676, 0.1749, 0.1822, 0.1895, 0.1968, 0.204, 0.2041, 0.2113, 0.2114, 0.2186, 0.2187, 0.2259, 0.2332, 0.2405, 0.2478, 0.255, 0.2551, 0.2623, 0.2624, 0.2696, 0.2697, 0.2769, 0.277, 0.2842, 0.2843, 0.2915, 0.2916, 0.2988, 0.306, 0.3061, 0.3133, 0.3134, 0.3206, 0.3207, 0.3279, 0.328, 0.3352, 0.3353, 0.3425, 0.3426, 0.3498, 0.3499, 0.3571, 0.3572, 0.3644, 0.3645, 0.3717, 0.379, 0.3863, 0.3936, 0.4009, 0.4082, 0.4155, 0.4228, 0.4301, 0.4374};
        double[] RealATKList = {0, 13.62, 15.56, 17.51, 19.45, 27.24, 29.18, 31.12, 31.13, 33.07, 35.01, 35.02, 36.96, 38.9, 40.86, 42.8, 44.74, 44.75, 46.68, 46.69, 48.63, 48.64, 50.57, 50.58, 52.52, 52.53, 54.46, 54.47, 54.48, 56.41, 56.42, 58.35, 58.36, 58.37, 60.3, 60.31, 62.24, 62.25, 62.26, 64.19, 64.2, 66.13, 66.14, 66.15, 68.08, 68.09, 68.1, 70.02, 70.03, 70.04, 71.97, 71.98, 71.99, 73.91, 73.92, 73.93, 75.86, 75.87, 75.88, 77.8, 77.81, 77.82, 79.75, 79.76, 79.77, 81.69, 81.7, 81.71, 81.72, 83.64, 83.65, 83.66, 85.58, 85.59, 85.6, 85.61, 87.53, 87.54, 87.55, 89.47, 89.48, 89.49, 89.5, 91.42, 91.43, 91.44, 93.36, 93.37, 93.38, 93.39, 95.31, 95.32, 95.33, 97.25, 97.26, 97.27, 97.28, 99.2, 99.21, 99.22, 101.14, 101.15, 101.16, 101.17, 103.09, 103.1, 103.11, 105.03, 105.04, 105.05, 105.06, 106.98, 106.99, 107.0, 108.92, 108.93, 108.94, 110.87, 110.88, 112.81, 112.82, 114.76, 116.7};
        double[] RealPATKList = {0, 0.0408, 0.0466, 0.0525, 0.0583, 0.0816, 0.0874, 0.0933, 0.0991, 0.1049, 0.105, 0.1108, 0.1166, 0.1224, 0.1282, 0.1341, 0.1399, 0.1457, 0.1458, 0.1516, 0.1574, 0.1575, 0.1632, 0.1633, 0.169, 0.1691, 0.1749, 0.1807, 0.1865, 0.1866, 0.1924, 0.1982, 0.1983, 0.204, 0.2041, 0.2098, 0.2099, 0.21, 0.2157, 0.2158, 0.2215, 0.2216, 0.2273, 0.2274, 0.233, 0.2332, 0.239, 0.2391, 0.2448, 0.2449, 0.2506, 0.2507, 0.2508, 0.2565, 0.2566, 0.2623, 0.2624, 0.2625, 0.2681, 0.2682, 0.2683, 0.2738, 0.274, 0.2741, 0.2796, 0.2798, 0.2799, 0.2856, 0.2857, 0.2913, 0.2915, 0.2916, 0.2973, 0.2974, 0.3031, 0.3032, 0.3033, 0.309, 0.3091, 0.3148, 0.3149, 0.315, 0.3206, 0.3207, 0.3208, 0.3265, 0.3266, 0.3323, 0.3324, 0.3381, 0.3382, 0.344, 0.3498};
        double[] RealEMList = {0, 16.32, 18.65, 20.98, 23.31, 32.64, 34.97, 37.3, 39.63, 41.96, 44.29, 46.62, 48.96, 51.29, 53.62, 55.95, 58.28, 60.61, 62.94, 65.27, 65.28, 67.6, 67.61, 69.93, 69.94, 72.27, 74.6, 76.93, 79.26, 81.59, 81.6, 83.92, 83.93, 86.25, 86.26, 88.58, 88.59, 90.91, 90.92, 93.24, 93.25, 95.58, 97.91, 97.92, 100.24, 100.25, 102.57, 102.58, 104.9, 104.91, 107.23, 107.24, 109.56, 109.57, 111.89, 111.9, 114.22, 114.23, 116.55, 116.56, 118.89, 121.22, 123.55, 125.88, 128.21, 130.54, 132.87, 135.2, 137.53, 139.86};
        double[] RealERList = {0, 4.53, 5.18, 5.83, 6.48, 9.06, 9.71, 10.36, 11.01, 11.66, 12.31, 12.96, 13.59, 14.24, 14.89, 15.54, 16.19, 16.84, 17.49, 18.12, 18.14, 18.77, 18.79, 19.42, 19.44, 20.07, 20.72, 21.37, 22.02, 22.65, 22.67, 23.3, 23.32, 23.95, 23.97, 24.6, 24.62, 25.25, 25.27, 25.9, 25.92, 26.55, 27.18, 27.2, 27.83, 27.85, 28.48, 28.5, 29.13, 29.15, 29.78, 29.8, 30.43, 30.45, 31.08, 31.1, 31.73, 31.75, 32.38, 32.4, 33.03, 33.68, 34.33, 34.98, 35.63, 36.28, 36.93, 37.58, 38.23, 38.88};
        double[] RealCRList = {0, 2.72, 3.11, 3.5, 3.89, 5.44, 5.83, 6.22, 6.61, 7.0, 7.39, 7.78, 8.16, 8.55, 8.94, 9.33, 9.72, 10.11, 10.5, 10.88, 10.89, 11.27, 11.28, 11.66, 11.67, 12.05, 12.44, 12.83, 13.22, 13.6, 13.61, 13.99, 14.0, 14.38, 14.39, 14.77, 14.78, 15.16, 15.17, 15.55, 15.56, 15.94, 16.32, 16.33, 16.71, 16.72, 17.1, 17.11, 17.49, 17.5, 17.88, 17.89, 18.27, 18.28, 18.66, 18.67, 19.05, 19.06, 19.44, 19.45, 19.83, 20.22, 20.61, 21.0, 21.39, 21.78, 22.17, 22.56, 22.95, 23.34};
        double[] RealCDList = {0, 5.44, 6.22, 6.99, 7.77, 10.88, 11.66, 12.43, 12.44, 13.21, 13.98, 13.99, 14.76, 15.54, 16.32, 17.1, 17.87, 17.88, 18.65, 18.66, 19.42, 19.43, 20.2, 20.21, 20.97, 20.98, 21.75, 21.76, 22.53, 22.54, 23.31, 23.32, 24.09, 24.1, 24.86, 24.87, 24.88, 25.64, 25.65, 26.41, 26.42, 26.43, 27.19, 27.2, 27.96, 27.97, 27.98, 28.74, 28.75, 28.76, 29.52, 29.53, 29.54, 30.3, 30.31, 30.32, 31.08, 31.09, 31.1, 31.85, 31.86, 31.87, 32.63, 32.64, 32.65, 33.4, 33.41, 33.42, 34.18, 34.19, 34.2, 34.95, 34.96, 34.97, 34.98, 35.73, 35.74, 35.75, 35.76, 36.51, 36.52, 36.53, 36.54, 37.29, 37.3, 37.31, 37.32, 38.07, 38.08, 38.09, 38.84, 38.85, 38.86, 38.87, 39.62, 39.63, 39.64, 40.39, 40.4, 40.41, 40.42, 41.17, 41.18, 41.19, 41.94, 41.95, 41.96, 41.97, 42.72, 42.73, 42.74, 43.5, 43.51, 43.52, 44.28, 44.29, 45.06, 45.07, 45.84, 46.62};

        double[][] RealList = {
            RealHPList, RealPHPList,
            RealDEFList, RealPDEFList,
            RealATKList, RealPATKList,
            RealEMList, RealERList,
            RealCRList, RealCDList
        };

        ArrayList<String> StringList = new ArrayList<String>();

        StringList.add("HP");
        StringList.add("PHP");
        StringList.add("DEF");
        StringList.add("PDEF");
        StringList.add("ATK");
        StringList.add("PATK");
        StringList.add("EM");
        StringList.add("ER");
        StringList.add("CR");
        StringList.add("CD");

        double lowestDiff = 100000;
        int lowestDiffIndex = 0;
        
        for (int i = 0; i < RealList[StringList.indexOf(statName)].length; i++){
            double realStat = RealList[StringList.indexOf(statName)][i];
            if (Math.abs(statValue - realStat) < lowestDiff){
                lowestDiff = Math.abs(statValue - realStat);
                lowestDiffIndex = i;
            }    
        }
        return RealList[StringList.indexOf(statName)][lowestDiffIndex];
    }

    public String getElement(){
        return element;
    }

    public int getLevel(){
        return level;
    }

    public Artifact getArtifact(String type){
        if (type.equals("Flower")){
            return arts[0];
        } else if (type.equals("Feather")){
            return arts[1];
        } else if (type.equals("Sands")){
            return arts[2];
        } else if (type.equals("Goblet")){
            return arts[3];
        } else { // Circlet
            return arts[4];
        }
    }

    public void setArtifact(String type, Artifact artifact){
        if (type.equals("Flower")){
            arts[0] = artifact;
        } else if (type.equals("Feather")){
            arts[1] = artifact;
        } else if (type.equals("Sands")){
            arts[2] = artifact;
        } else if (type.equals("Goblet")){
            arts[3] = artifact;

        } else if (type.equals("Circlet")){
            arts[4] = artifact;
        }
        updateStats(element, level, baseHP, baseATK - weaponATK, baseDEF, weaponName, weaponATK, arts, ascendName, ascendValue);
    }

    public double getTotalATK(){
        return totalATK;
    }

    public double getTotalDEF(){
        return totalDEF;
    }

    public double getTotalHP(){
        return totalHP;
    }

    public double getEM(){
        return EM;
    }

    public double getER(){
        return ER;
    }

    public double getCR(){
        return CR;
    }

    public double getCD(){
        return CD;
    }

    public double getPHDMG(){
        return elementalDMG[0];
    }
    public double getPDMG(){
        return elementalDMG[1];
    }
    public double getHDMG(){
        return elementalDMG[2];
    }
    public double getADMG(){
        return elementalDMG[3];
    }
    public double getEDMG(){
        return elementalDMG[4];
    }
    public double getDDMG(){
        return elementalDMG[5];
    }
    public double getCDMG(){
        return elementalDMG[6];
    }
    public double getGDMG(){
        return elementalDMG[7];
    }
}
