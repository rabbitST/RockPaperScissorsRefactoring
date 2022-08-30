package hu.adamsan;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        String playerChoice;
        Application app = new Application();
        do {
            System.out.println("Do you pick rock, paper, or scissors?");
            playerChoice = app.GetUserChoice();
        } while (!app.CheckInput(playerChoice))
                ;
        // Computer chooses a move based on a randomly generated int
       String computerMoveChoice=app.ComputerMove();

        // Printing out what the computer chose
        System.out.println("The computer chose: "+ computerMoveChoice);

        // Comparing the choices
        // Both choices are the same (tie)
        PrintIt(app.CheckWinner(playerChoice,computerMoveChoice));
    }

    public String GetUserChoice() {
        Scanner choice = new Scanner(System.in);
        return choice.nextLine();
    }

    public boolean CheckInput(String playerChoice) {
        String[] userOptions = new String[]{"rock", "paper", "scissors"};
        if (!Arrays.asList(userOptions).contains(playerChoice)) {
            System.out.println("Move not recognized! Please try again.");
            return false;
        }
        return true;
    }

    public String ComputerMove() {
        Random randomNumber = new Random();
        String[] computerOptions = new String[]{"rock", "paper", "scissors"};
        return computerOptions[randomNumber.nextInt(3)];
    }
    public List CheckWinner(String player, String computer) {
        List<String> winner= new ArrayList<>();
        List<String> moves=new ArrayList<>(){{
            add(player);add(computer);
        }};
        if(moves.contains("rock") && moves.contains("scissors")){
            winner.add("1");
            winner.add(moves.indexOf("rock")==0?"Player":"Computer");
        }
        if(moves.contains("paper") && moves.contains("rock")){
            winner.add("2");
            winner.add(moves.indexOf("paper")==0?"Player":"Computer");
        }
        if(moves.contains("scissors") && moves.contains("paper")){
            winner.add("3");
            winner.add(moves.indexOf("scissors")==0?"Player":"Computer");
        }
        if(player.equals(computer)){
            winner.add("4");
        }
        return winner;
    }

    private static void PrintIt(List<String> CheckWinner) {
        switch (CheckWinner.get(0)){
            case "1"-> System.out.printf("\nRock beats scissors.The %s wins.",CheckWinner.get(1));
            case "2"-> System.out.printf("\nPaper beats rock.The %s wins.",CheckWinner.get(1));
            case "3"-> System.out.printf("\nScissors beats paper.The %s wins.",CheckWinner.get(1));
            case "4"-> System.out.println("It's a tie!");
        }
    }
}