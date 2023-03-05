package Selenium;

import java.util.Random;
import java.util.Scanner;

    public class RockPaperScissors {
        public static void main(String[] args){
            Random rd = new Random();
            Scanner scan = new Scanner(System.in);
            int win = 0,lose=0,tie=0;
            for (int i = 0; i < 10; i++) {
                System.out.println("Choose one option :");
                System.out.println("1.Rock\n2.Paper\n3.Scissors");
                String answer = scan.nextLine();

                int option = rd.nextInt(1, 4);
                if (answer.equals("Rock") || answer.equals("1") || answer.equals("rock")) {
                    int r = 1;
                    System.out.println(option);
                    if (option == 1) { //אבן נגד אבן = תיקו
                        System.out.println("Tie -> Rock = Rock");
                        tie++;
                    } else if (option == 2) { // אבן נגד נייר = מפסיד
                        System.out.println("You lost -> Paper > Rock");
                        lose++;
                    } else { // אבן נגד מספריים = מנצח
                        System.out.println("You won -> Scissors < Rock");
                        win++;
                    }
                }
                if (answer.equals("Paper") || answer.equals("2") || answer.equals("paper")) {
                    int p = 2;
                    System.out.println(option);
                    if (option == 1) { // נייר נגד אבן = מנצח
                        System.out.println("You won -> Rock < Paper");
                        win++;
                    } else if (option == 2) { // נייר נגד נייר = תיקו
                        System.out.println("Tie -> Paper = Paper");
                        tie++;
                    } else { // נייר נגד מספריים = מפסיד
                        System.out.println("You lost -> Scissors > Paper");
                        lose++;
                    }}
                if (answer.equals("Scissors") || answer.equals("3") || answer.equals("scissors")) {
                    int s = 3;
                    System.out.println(option);
                    if (option == 1) { // מספריים נגד אבן = מפסיד
                        System.out.println("You lost -> Rock > Scissors");
                        lose++;
                    } else if (option == 2) { // מספריים נגד נייר = מנצח
                        System.out.println("You won -> Paper < Scissors");
                        win++;
                    } else { // מספריים נגד מספריים = תיקו
                        System.out.println("Tie -> Scissors = Scissors");
                        tie++;
                    }}
            }
            System.out.println("Numbers of wins = "+win);
            System.out.println("Numbers of ties = "+tie);
            System.out.println("Numbers of loses = "+lose);
        }
    }


