package com.mountblue.iplDataSetModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class NewParser {
    public static List<DriverMatch> dataOfMatches(String matchesPath){
        List<DriverMatch> linesOfMatches= new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(matchesPath));
            reader.readLine();
            String line1=null;
            while ((line1 = reader.readLine()) != null){
                String[] dataPerLineStr=line1.split(",");
                DriverMatch driverMatch=new DriverMatch(dataPerLineStr);
                linesOfMatches.add(driverMatch);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return linesOfMatches;
    }
    public static List<DriverDelivery> dataOfDeliveries(String deliveriesPath){
        List<DriverDelivery> linesOfDeliveries= new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(deliveriesPath));
            reader.readLine();
            String line1=null;
            while ((line1 = reader.readLine()) != null){
                String[] dataPerLineStr=line1.split(",");
                DriverDelivery driverDelivery=new DriverDelivery(dataPerLineStr);
                linesOfDeliveries.add(driverDelivery);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return linesOfDeliveries;
    }
}
