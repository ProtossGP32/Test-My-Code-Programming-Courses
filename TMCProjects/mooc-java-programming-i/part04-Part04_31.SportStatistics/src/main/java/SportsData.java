public class SportsData {
    private String homeTeam;
    private String visitingTeam;
    private int homePoints;
    private int visitingPoints;

    public SportsData(String homeTeam, String visitingTeam, int homePoints, int visitingPoints) {
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        this.homePoints = homePoints;
        this.visitingPoints = visitingPoints;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getVisitingTeam() {
        return visitingTeam;
    }

    public int getHomePoints() {
        return homePoints;
    }

    public int getVisitingPoints() {
        return visitingPoints;
    }

    public String winnerTeam() {
        if (this.homePoints > this.visitingPoints) {
            return this.homeTeam;
        } else {
            return this.visitingTeam;
        }
    }
}
