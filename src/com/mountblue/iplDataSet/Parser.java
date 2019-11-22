package com.mountblue.iplDataSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<List<String>> dataOfMatches(String matchesPath){
        List<List<String>> linesOfMatches= new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(matchesPath));
            reader.readLine();
            String line1=null;
            while ((line1 = reader.readLine()) != null){
                String[] dataPerLineStr=line1.split(",");
                List<String> dataPerLine = new ArrayList<>(Arrays.asList(dataPerLineStr));
                linesOfMatches.add(dataPerLine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return linesOfMatches;
    }
    public static List<List<String>> dataOfDeliveries(String deliveriesPath){
        List<List<String>> linesOfDeliveries= new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(deliveriesPath));
            reader.readLine();
            String line1=null;
            while ((line1 = reader.readLine()) != null){
                String[] dataPerLineStr=line1.split(",");
                List<String> dataPerLine = new ArrayList<>(Arrays.asList(dataPerLineStr));
                linesOfDeliveries.add(dataPerLine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return linesOfDeliveries;
    }
}
