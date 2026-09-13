package Assignment_Programming_Fundamentals;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    static String getComputerMove() {

        Random random = new Random();
        int number = random.nextInt(3);

        if (number == 0) {
            return "Rock";
        } else if (number == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int rounds = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        for (int i = 0; i < rounds; i++) {

            System.out.print("Round " + (i + 1)
                    + " - Enter Rock, Paper or Scissors: ");

            String playerMove = input.nextLine();

            playerMove = playerMove.substring(0, 1).toUpperCase()
                    + playerMove.substring(1).toLowerCase();

            String computerMove = getComputerMove();

            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("----------- FINAL SUMMARY -----------");
        System.out.println("Round\tPlayer Move\tComputer Move\tResult");

        for (int i = 0; i < rounds; i++) {

            System.out.println((i + 1) + "\t"
                    + playerMoves[i] + "\t\t"
                    + computerMoves[i] + "\t\t"
                    + results[i]);
        }

        System.out.println("------------------------------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");

        input.close();
    }
}
