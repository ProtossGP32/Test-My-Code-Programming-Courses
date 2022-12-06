
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("File:");
        String file = scan.nextLine();
        System.out.println("Team:");
        String team = scan.nextLine();

        ArrayList<SportsData> matches = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(Paths.get(file))) {
            while (fileScanner.hasNextLine()) {
                String[] matchInfo = fileScanner.nextLine().split(",");
                // Only save the match info if it matches the requested team
                if (team.equals(matchInfo[0]) || team.equals(matchInfo[1])) {
                    matches.add(new SportsData(matchInfo[0], matchInfo[1], Integer.parseInt(matchInfo[2]), Integer.parseInt(matchInfo[3])));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Analyze the whole list of matches
        int wins = 0;
        int losses = 0;
        for (SportsData match : matches) {
            if (match.winnerTeam().equals(team)) {
                ++wins;
            } else {
                ++losses;
            }
        }
        System.out.println("Games: " + (wins + losses));
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }
}
