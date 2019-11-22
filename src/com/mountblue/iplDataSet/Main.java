package com.mountblue.iplDataSet;

import com.mountblue.iplDataSetModel.DriverDelivery;
import com.mountblue.iplDataSetModel.DriverMatch;
import com.mountblue.iplDataSetModel.NewParser;
import com.mountblue.iplDataSetModel.SolutionModel;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathMatches = "files/matches.csv";
        String pathDeliveries = "files/deliveries.csv";

        List<List<String>> linesOfMatches = Parser.dataOfMatches(pathMatches);
        List<List<String>> linesOfDeliveries = Parser.dataOfDeliveries(pathDeliveries);

        Solution.matchesPlayedPerYear(linesOfMatches);
        System.out.println();
        Solution.matchesWonOverYearPerTeam(linesOfMatches);
        System.out.println();
        Solution.extraRunPerTeam(linesOfDeliveries,linesOfMatches);
        System.out.println();
        Solution.topEconomicalBowler(linesOfMatches, linesOfDeliveries);

        List<DriverMatch> linesOfMatchesModel = NewParser.dataOfMatches(pathMatches);
        List<DriverDelivery> linesOfDeliveriesModel = NewParser.dataOfDeliveries(pathDeliveries);
        SolutionModel.matchesPlayedPerYear(linesOfMatchesModel);
        System.out.println();
        SolutionModel.matchesWonOverYearPerTeam(linesOfMatchesModel);
        System.out.println();
        SolutionModel.extraRunPerTeam(linesOfDeliveriesModel,linesOfMatchesModel);
        System.out.println();
        SolutionModel.topEconomicalBowler(linesOfMatchesModel,linesOfDeliveriesModel);
    }
}