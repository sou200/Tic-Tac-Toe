import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class TicTacToe{

public static void main(String args[]){
    Scanner playerIN = new Scanner(System.in);
    String user = "player";
    int playerPos=-1;
    boolean gameStatu = true;
    ArrayList<Integer> fullPos = new ArrayList<>();
    String shape[][] = {
        {"   ","|","   ","|","   "},
        {"---","+","---","+","---"},
        {"   ","|","   ","|","   "},
        {"---","+","---","+","---"},
        {"   ","|","   ","|","   "}
};
    
        printBoard(shape);
    
    while(gameStatu){
        
    String sign = "   ";
    if(user.equals("player")){
    
        System.out.println("Enter your placment (1-9):");
        playerPos = playerIN.nextInt();
        sign = " O ";
        
        while(!checkPos(fullPos, playerPos)){
            System.out.println("position is full !! Try Again:");
            playerPos = playerIN.nextInt();
        }
        
        play(shape,playerPos,sign);
        printBoard(shape);
        
        fullPos.add(playerPos);
        
        user = "computer";
    } else if (user.equals("computer")){
        sign = " X ";
        
        playerPos = rand();
        
        while(!checkPos(fullPos, playerPos)){
            playerPos = rand();
        }
        
        play(shape,playerPos,sign);
        printBoard(shape);
        
        fullPos.add(playerPos);
        
        user = "player";
    }
    if(win(shape).equals(" X ")){
    System.out.print("Computer win !!!\n");
    gameStatu=false;
    } else if (win(shape).equals(" O ")){
    System.out.print("player win !!!\n");
    gameStatu=false;
    } else if (fullPos.size() >=9 && win(shape) == null){
    System.out.print("draw !!!!!\n");
    }
    }
}
    
    public static void printBoard(String shape[][]){

    for(String rows[] : shape){
        for(String row : rows){
        System.out.print(row);
        }
    System.out.println();
    }
    }
    
     public static void play(String shape[][],int pos,String user){
     if(pos <= 9 && pos > 0){
        switch(pos){
            case 1: shape[0][0]=user;break;
            case 2: shape[0][2]=user;break;
            case 3: shape[0][4]=user;break;
            case 4: shape[2][0]=user;break;
            case 5: shape[2][2]=user;break;
            case 6: shape[2][4]=user;break;
            case 7: shape[4][0]=user;break;
            case 8: shape[4][2]=user;break;
            case 9: shape[4][4]=user;break;
        }
    }
     }
     public static boolean checkPos(ArrayList<Integer> fullpos, int pos){
        for(int p:fullpos){
            if(p == pos){
            return false;
            }
        }
        return true;
     }
     public static int rand(){
        Random ran = new Random();
        return ran.nextInt(9) + 1;
     }
     public static String win(String shape[][]){
         
             String[][] poss = {{shape[0][0],shape[0][2],shape[0][4]},
                      {shape[2][0],shape[2][2],shape[2][4]},
                      {shape[4][0],shape[4][2],shape[4][4]}};
         
         //vertical
         boolean case1 = poss[0][0] == poss[0][1] && poss[0][1] == poss[0][2];
         boolean case2 = poss[1][0] == poss[1][1] && poss[1][1] == poss[1][2];
         boolean case3 = poss[2][0] == poss[2][1] && poss[2][1] == poss[2][2];
         //horizontal
         boolean case4 = poss[0][0] == poss[1][0] && poss[1][0] == poss[2][0];
         boolean case5 = poss[0][1] == poss[1][1] && poss[1][1] == poss[2][1];
         boolean case6 = poss[0][2] == poss[1][2] && poss[1][2] == poss[2][2];
         // ver&hor
         boolean case7 = poss[0][0] == poss[1][1] && poss[1][1] == poss[2][2];
         boolean case8 = poss[2][0] == poss[1][1] && poss[1][1] == poss[0][2];
         
         if(case1 && !poss[0][0].trim().isEmpty()){
         return poss[0][0];
         } else if(case2 && !poss[1][0].trim().isEmpty()){
         return poss[1][0];
         } else if(case3 && !poss[2][0].trim().isEmpty()){
         return poss[2][0];
         } else if(case4 && !poss[0][0].trim().isEmpty()){
         return poss[0][0];
         } else if(case5 && !poss[0][1].trim().isEmpty()){
         return poss[0][1];
         } else if(case6 && !poss[0][2].trim().isEmpty()){
         return poss[0][2];
         } else if(case7 && !poss[0][0].trim().isEmpty()){
         return poss[0][0];
         } else if(case8 && !poss[2][0].trim().isEmpty()){
         return poss[2][0];
         } else {
         return "";
         }
     }
}
