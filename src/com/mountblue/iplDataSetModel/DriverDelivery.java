package com.mountblue.iplDataSetModel;

public class DriverDelivery {
    String match_id,inning,batting_team,bowling_team,over,ball,batsman,non_striker,bowler,is_super_over,wide_runs,bye_runs,legbye_runs,noball_runs,penalty_runs,batsman_runs,extra_runs,total_runs,player_dismissed,dismissal_kind,fielder;

    public DriverDelivery(String[] data){
        setMatch_id(data[0]);
        setInning(data[1]);
        setBatting_team(data[2]);
        setBowling_team(data[3]);
        setOver(data[4]);
        setBall(data[5]);
        setBatsman(data[6]);
        setNon_striker(data[7]);
        setBowler(data[8]);
        setWide_runs(data[10]);
        setBye_runs(data[11]);
        setLegbye_runs(data[12]);
        setNoball_runs(data[13]);
        setPenalty_runs(data[14]);
        setBatsman_runs(data[15]);
        setExtra_runs(data[16]);
        setTotal_runs(data[17]);
    }
    public String getMatch_id() {
        return match_id;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }

    public String getInning() {
        return inning;
    }

    public void setInning(String inning) {
        this.inning = inning;
    }

    public String getBatting_team() {
        return batting_team;
    }

    public void setBatting_team(String batting_team) {
        this.batting_team = batting_team;
    }

    public String getBowling_team() {
        return bowling_team;
    }

    public void setBowling_team(String bowling_team) {
        this.bowling_team = bowling_team;
    }

    public String getOver() {
        return over;
    }

    public void setOver(String over) {
        this.over = over;
    }

    public String getBall() {
        return ball;
    }

    public void setBall(String ball) {
        this.ball = ball;
    }

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

    public String getNon_striker() {
        return non_striker;
    }

    public void setNon_striker(String non_striker) {
        this.non_striker = non_striker;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public String getIs_super_over() {
        return is_super_over;
    }

    public void setIs_super_over(String is_super_over) {
        this.is_super_over = is_super_over;
    }

    public String getWide_runs() {
        return wide_runs;
    }

    public void setWide_runs(String wide_runs) {
        this.wide_runs = wide_runs;
    }

    public String getBye_runs() {
        return bye_runs;
    }

    public void setBye_runs(String bye_runs) {
        this.bye_runs = bye_runs;
    }

    public String getLegbye_runs() {
        return legbye_runs;
    }

    public void setLegbye_runs(String legbye_runs) {
        this.legbye_runs = legbye_runs;
    }

    public String getNoball_runs() {
        return noball_runs;
    }

    public void setNoball_runs(String noball_runs) {
        this.noball_runs = noball_runs;
    }

    public String getPenalty_runs() {
        return penalty_runs;
    }

    public void setPenalty_runs(String penalty_runs) {
        this.penalty_runs = penalty_runs;
    }

    public String getBatsman_runs() {
        return batsman_runs;
    }

    public void setBatsman_runs(String batsman_runs) {
        this.batsman_runs = batsman_runs;
    }

    public String getExtra_runs() {
        return extra_runs;
    }

    public void setExtra_runs(String extra_runs) {
        this.extra_runs = extra_runs;
    }

    public String getTotal_runs() {
        return total_runs;
    }

    public void setTotal_runs(String total_runs) {
        this.total_runs = total_runs;
    }

    public String getPlayer_dismissed() {
        return player_dismissed;
    }

    public void setPlayer_dismissed(String player_dismissed) {
        this.player_dismissed = player_dismissed;
    }

    public String getDismissal_kind() {
        return dismissal_kind;
    }

    public void setDismissal_kind(String dismissal_kind) {
        this.dismissal_kind = dismissal_kind;
    }

    public String getFielder() {
        return fielder;
    }

    public void setFielder(String fielder) {
        this.fielder = fielder;
    }
}
