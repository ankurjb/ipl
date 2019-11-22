package com.mountblue.iplDataSet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Solution {
    public static void matchesPlayedPerYear(List<List<String>> linesOfMatches) {
        Map<String, Integer> playedPerYear = new HashMap<>();
        try {
            for (List<String> dataPerLine : linesOfMatches) {
                if (playedPerYear.containsKey(dataPerLine.get(1))) {
                    playedPerYear.put(dataPerLine.get(1), playedPerYear.get(dataPerLine.get(1)) + 1);
                } else {
                    playedPerYear.put(dataPerLine.get(1), 1);
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

    public void matchesWonPerYearPerTeam(String path) {
        Map<String, Map> perYear = new HashMap<>();
        Map<String, Integer> perTeam = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            int i = 0;
            for (String line : lines) {
                String[] result = line.split(",");
                if (i != 0) {
                    if (perYear.containsKey(result[1])) {
                        if (perTeam.containsKey(result[10])) {
                            perTeam.put(result[10], perTeam.get(result[10]) + 1);
                        } else {
                            perTeam.put(result[10], 1);
                        }
                    } else {
                        perTeam.clear();
                        perYear.put(result[1], perTeam);
                    }
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        //System.out.println(perYear);
        Set<Map.Entry<String, Map>> all = perYear.entrySet();
        System.out.println("YEAR MATCHES_PLAYED");
        for (Map.Entry<String, Map> e : all) {
            String key = e.getKey();
            Map<String, Integer> value = e.getValue();
            if (key != null) {
                System.out.print(key + " ");
                Set<Map.Entry<String, Integer>> all2 = value.entrySet();
                for (Map.Entry<String, Integer> f : all2) {
                    String key2 = f.getKey();
                    Integer value2 = f.getValue();
                    if (key != null) {
                        System.out.println(key2 + " " + value2);
                    }
                }
            }
        }
    }

    public static void matchesWonOverYearPerTeam(List<List<String>> linesOfMatches) {
        Map<String, Integer> perTeam = new HashMap<>();
        try {
            for (List<String> linesPerMatches: linesOfMatches) {
                if (perTeam.containsKey(linesPerMatches.get(10))) {
                    perTeam.put(linesPerMatches.get(10), perTeam.get(linesPerMatches.get(10)) + 1);
                } else {
                    perTeam.put(linesPerMatches.get(10), 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        //System.out.println(perTeam);
        Set<Map.Entry<String, Integer>> all = perTeam.entrySet();
        System.out.println("TEAM\t\t\t\t\t\t\tMATCHES_WON");
        for (Map.Entry<String, Integer> e : all) {
            String key = e.getKey();
            int value = e.getValue();
            System.out.println(key + "\t\t\t\t\t" + value);
        }
    }

    public static void extraRunPerTeam(List<List<String>> linesOfDeliveries, List<List<String>> linesOfMatches) throws IOException {
        Map<String, Integer> extras = new HashMap<>();
        for (List<String> matchLines : linesOfMatches) {
            if (matchLines.get(1).equals("2016")) {
                for (List<String> deliveriesLines : linesOfDeliveries) {
                    if (matchLines.get(0).equals(deliveriesLines.get(0))) {
                        if (extras.containsKey(deliveriesLines.get(2))) {
                            extras.put(deliveriesLines.get(2), (extras.get(deliveriesLines.get(2))) + Integer.parseInt(deliveriesLines.get(16)));
                        } else {
                            extras.put(deliveriesLines.get(2), Integer.parseInt(deliveriesLines.get(16)));
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

    static void topEconomicalBowler(List<List<String>> linesOfMatches, List<List<String>> linesOfDeliveries) {
        Map<String, Integer> scorePerBowler = new HashMap<>();
        Map<String, Integer> ballsPerBowler = new HashMap<>();
        for (List<String> matchLines : linesOfMatches) {
            if (matchLines.get(1).equals("2015")) {
                for (List<String> deliveriesLines : linesOfDeliveries) {

                    if (matchLines.get(0).equals(deliveriesLines.get(0))) {

                        int score = Integer.parseInt(deliveriesLines.get(17)) - Integer.parseInt(deliveriesLines.get(11)) - Integer.parseInt(deliveriesLines.get(12));
                        if (scorePerBowler.containsKey(deliveriesLines.get(8)) && ballsPerBowler.containsKey(deliveriesLines.get(8))) {

                            if (deliveriesLines.get(10).equals("0") && deliveriesLines.get(13).equals("0"))
                                ballsPerBowler.put(deliveriesLines.get(8), ballsPerBowler.get(deliveriesLines.get(8)) + 1);

                            scorePerBowler.put(deliveriesLines.get(8), scorePerBowler.get(deliveriesLines.get(8)) + score);

                        } else {
                            if (deliveriesLines.get(10).equals("0") && deliveriesLines.get(13).equals("0"))
                                ballsPerBowler.put(deliveriesLines.get(8), 1);
                            else
                                ballsPerBowler.put(deliveriesLines.get(8), 0);
                            scorePerBowler.put(deliveriesLines.get(8), score);
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