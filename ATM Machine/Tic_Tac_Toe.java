package ASSIGNMENT;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class TTT{
     String[] Board;
     String turn;

    public String checkWinner(){
        for(int i=0;i<8;i++){
            String line=null;
            switch (i){
                case 0:
                    line=Board[0]+Board[1]+Board[2];
                    break;
                case 1:
                    line=Board[3]+Board[4]+Board[5];
                    break;
                case 2:
                    line=Board[6]+Board[7]+Board[8];
                    break;
                case 3:
                    line=Board[0]+Board[3]+Board[6];
                    break;
                case 4:
                    line=Board[1]+Board[4]+Board[7];
                    break;
                case 5:
                    line=Board[2]+Board[5]+Board[8];
                    break;
                case 6:
                    line=Board[0]+Board[4]+Board[8];
                    break;
                case 7:
                    line=Board[2]+Board[4]+Board[6];
                    break;
            }
            if(line.equals("XXX")){
                return "X";
            }
            else if(line.equals("OOO")) {
                return "O";
            }
        }
        for(int i=0;i<9;i++){
            if(Arrays.asList(Board).contains(String.valueOf(i+1))){
                break;
            } else if (i==8) {
                return  "Draw!";
            }
        }
        System.out.println(turn+"s turn ,enter the box number to place "+turn+" in");
        return null;
    }
    public void displayBoard(){
        System.out.println("|---|---|---|");
        System.out.println("| "+Board[0]+" | "+Board[1]+" | "+Board[2]+" |");
        System.out.println("| "+Board[3]+" | "+Board[4]+" | "+Board[5]+" |");
        System.out.println("| "+Board[6]+" | "+Board[7]+" | "+Board[8]+" |");
        System.out.println("|---|---|---|");
    }
}
public class Tic_Tac_Toe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TTT ttt=new TTT();
        ttt.Board=new String[9];
        ttt.turn="X";
        String Winner=null;

        for(int i=0;i<9;i++){
            ttt.Board[i]=String.valueOf(i+1);
        }
        ttt.displayBoard();
        System.out.println("X will play first,Enter a box number to place X in:");

        while(Winner==null){
            int input;
            try{
                input=sc.nextInt();
                if(!(input>0 && input<=9)){
                    System.out.println("Invalid input! Please re-enter the input:");
                    continue;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input! Please re-enter the input:");
                continue;
            }
            if(ttt.Board[input-1].equals(String.valueOf(input))){
                ttt.Board[input-1]= ttt.turn;
                if(ttt.turn.equals("X")){
                    ttt.turn="O";
                }
                else{
                    ttt.turn="X";
                }
                ttt.displayBoard();
                Winner= ttt.checkWinner();
            }
            else {
                System.out.println("The box is already taken ,re-enter the box number:");
            }
        }
        if(Winner.equalsIgnoreCase("draw")){
            System.out.println("The match is draw!");
        }
        else{
            System.out.println(Winner+"is Winner! Congrats....");
        }

    }
}
