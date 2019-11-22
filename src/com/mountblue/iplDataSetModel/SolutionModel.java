package com.mountblue.iplDataSetModel;

import java.io.IOException;
import java.util.*;

public class SolutionModel {
    public static void matchesPlayedPerYear(List<DriverMatch> linesOfMatches) {
        Map<String, Integer> playedPerYear = new HashMap<>();
        try {
            for (DriverMatch dataPerLine : linesOfMatches) {
                if (playedPerYear.containsKey(dataPerLine.getSeason())) {
                    playedPerYear.put(dataPerLine.getSeason(), playedPerYear.get(dataPerLine.getSeason()) + 1);
                } else {
                    playedPerYear.put(dataPerLine.getSeason(), 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<Map.Entry<String, Integer>> all = playedPerYear.entrySet();
        System.out.println("YEAR MATCHES");
        for (Map.Entry<String, Integer> e : all) {
            String key = e.getKey();
            int value = e.getValue();
            System.out.println(key + " " + value);
        }
    }

    public static void matchesWonOverYearPerTeam(List<DriverMatch> linesOfMatches) {
        Map<String, Integer> perTeam = new HashMap<>();
        try {
            for (DriverMatch linesPerMatches: linesOfMatches) {
                if (perTeam.containsKey(linesPerMatches.getWinner())) {
                    perTeam.put(linesPerMatches.getWinner(), perTeam.get(linesPerMatches.getWinner()) + 1);
                } else {
                    perTeam.put(linesPerMatches.getWinner(), 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        Set<Map.Entry<String, Integer>> all = perTeam.entrySet();
        System.out.println("TEAM\t\t\t\t\t\t\tMATCHES_WON");
        for (Map.Entry<String, Integer> e : all) {
            String key = e.getKey();
            int value = e.getValue();
            System.out.println(key + "\t\t\t\t\t" + value);
        }
    }

    public static void extraRunPerTeam(List<DriverDelivery> linesOfDeliveries, List<DriverMatch> linesOfMatches) throws IOException {
        Map<String, Integer> extras = new HashMap<>();
        for (DriverMatch matchLines : linesOfMatches) {
            if (matchLines.getSeason().equals("2016")) {
                for (DriverDelivery deliveriesLines : linesOfDeliveries) {
                    if (matchLines.getId().equals(deliveriesLines.getMatch_id())) {
                        if (extras.containsKey(deliveriesLines.getBatting_team())) {
                            extras.put(deliveriesLines.getBatting_team(), (extras.get(deliveriesLines.getBatting_team())) + Integer.parseInt(deliveriesLines.getExtra_runs()));
                        } else {
                            extras.put(deliveriesLines.getBatting_team(), Integer.parseInt(deliveriesLines.getExtra_runs()));
                        }
                    }
                }
            }
        }
        System.out.println("TEAM\t\t\t\t\t\t\tEXTRA RUNS CONCEDED");
        TreeMap<String, Integer> sortedExtras = new TreeMap<>(extras);
        Set<Map.Entry<String, Integer>> all = sortedExtras.entrySet();
        for (Map.Entry<String, Integer> e : all) {
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "\t\t\t\t\t" + value);
        }
    }

    public static void topEconomicalBowler(List<DriverMatch> linesOfMatches, List<DriverDelivery> linesOfDeliveries) {
        Map<String, Integer> scorePerBowler = new HashMap<>();
        Map<String, Integer> ballsPerBowler = new HashMap<>();
        for (DriverMatch matchLines : linesOfMatches) {
            if (matchLines.getSeason().equals("2015")) {
                for (DriverDelivery deliveriesLines : linesOfDeliveries) {
                    if (matchLines.getId().equals(deliveriesLines.getMatch_id())) {
                        int score = Integer.parseInt(deliveriesLines.getTotal_runs()) - Integer.parseInt(deliveriesLines.getBye_runs()) - Integer.parseInt(deliveriesLines.getLegbye_runs());
                        if (scorePerBowler.containsKey(deliveriesLines.getBowler()) && ballsPerBowler.containsKey(deliveriesLines.getBowler())) {

                            if (deliveriesLines.getWide_runs().equals("0") && deliveriesLines.getNoball_runs().equals("0"))
                                ballsPerBowler.put(deliveriesLines.getBowler(), ballsPerBowler.get(deliveriesLines.getBowler()) + 1);

                            scorePerBowler.put(deliveriesLines.getBowler(), scorePerBowler.get(deliveriesLines.getBowler()) + score);

                        } else {
                            if (deliveriesLines.getWide_runs().equals("0") && deliveriesLines.getNoball_runs().equals("0"))
                                ballsPerBowler.put(deliveriesLines.getBowler(), 1);
                            else
                                ballsPerBowler.put(deliveriesLines.getBowler(), 0);
                            scorePerBowler.put(deliveriesLines.getBowler(), score);
                        }
                    }
                }
            }
        }
        System.out.println("TEAM\t\t\t\t\t\t\tSCORE\t\tBALLS");
        for (Map.Entry<String, Integer> e : scorePerBowler.entrySet()) {
            String key = e.getKey();
            Integer score = e.getValue();
            Integer balls = ballsPerBowler.get(key);
            float overs = balls / 6f;
            float economy = score / overs;
            System.out.println(key + "\t\t\t\t\t\t\t" + economy);
        }
    }
}