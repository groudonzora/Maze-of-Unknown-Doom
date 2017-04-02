package mazeofunknowndoom;

import java.util.Scanner;
/**
 The Magic class accepts and executes the user's spell commands, subtracting mana as 
 * it is used and distinguishing between healing spells and offensive ones.
 */
public class Magic{
    static Scanner input = new Scanner(System.in);
    static String userCast = new String();
    static boolean inputCorrect;
    /**
     The cast() method takes the user's magic commands and converts them to returned integers for 
     * more efficient command execution. If the user inputs an invalid command, 0 is returned.
     */
    private static int cast(){
        System.out.println("Cast a spell:  ");
        inputCorrect = true;
        userCast = "";
        userCast = input.next();
        if(userCast.equalsIgnoreCase("IceShards")){
            return(1);
        }else if(userCast.equalsIgnoreCase("Heal")){
            return(2);
        }else if(userCast.equalsIgnoreCase("MageBlast")){
            return(3);
        }else if(userCast.equalsIgnoreCase("Cure")){
            return(4);
        }else if(userCast.equalsIgnoreCase("Absorb")){
            return(5);
        }else if(userCast.equalsIgnoreCase("Purify")){
            return(6);
        }else if(userCast.equalsIgnoreCase("SuperNova")){
            return(7);
        }else if(userCast.equalsIgnoreCase("Cancel")){
            return(8);
        }else{
        return(0);
        }
    }
    /**
     The magicAttack method executes attacks and subtracts mana based on which attack the user activates.
     * pre: none
     * post: Magic attack executed, unless the user's input is invalid, in which case the user is told this.
     */
    public static int magicAttack(int userHP, int userMana){
        do {
            switch(cast()){
                case 1:
                    if(userMana >= 30){
                        main.mana -= 30;
                        System.out.println("You now have " + main.mana + " mana.");
                        System.out.println("You concentrated and unleashed a torrent of glistening ice shards onto your foe!");
                        return(30);
                    }else{
                    System.out.println("Not enough mana!");
                    inputCorrect = false;
                    }
                    
                    break;
                case 2:
                    if(userMana >= 35){
                        main.mana -= 35;
                        System.out.println("You now have " + main.mana + " mana.");
                        System.out.println("Using the mystic powers of Hostess, you created a magical aura of powdered sugar energy!");
                        return(-35);
                    }else{
                    System.out.println("Not enough mana!");
                    inputCorrect = false;
                    }
                    break;
                case 3:
                    if(userMana >= 50){
                        main.mana -= 50;
                        System.out.println("You now have " + main.mana + " mana.");
                        System.out.println("You channel a pulse of electricity through your hands and release it in an thunderous surge of energy!");
                        return(50);
                    }else{
                    System.out.println("Not enough mana!");
                    inputCorrect = false;
                    }
                    
                    break;
                case 4:
                    if(userMana >= 60){
                        main.mana -= 60;
                        System.out.println("You now have " + main.mana + " mana.");
                        Battle.sleep();
                        System.out.println("You focus the mystic powers of Hostess into a glowing pink sphere of chocolate and coconut.");
                        return(-60);
                    }else{
                    System.out.println("Not enough mana!");
                    inputCorrect = false;
                    }
                    break;
                case 5:
                    if(userMana >= 70){
                        main.mana -= 70;
                        System.out.println("You now have " + main.mana + " mana.");
                        Battle.sleep();
                        System.out.println("You projected a beam of light at your foe and channeled its energy towards yourself!");
                        return(0);
                    }else{
                    System.out.println("Not enough mana!");
                    inputCorrect = false;
                    }
                    break;
                case 6:
                    if(userMana >= 100){
                        main.mana -= 100;
                        System.out.println("You now have " + main.mana + " mana.");
                        System.out.println("You channel the ultimate power of Hostess into a honeyed swirl of life energy!!");
                        return(-100);
                    }else{
                    System.out.println("Not enough mana!");
                    inputCorrect = false;
                    }
                    break;
                case 7:
                    if(userMana >= 150){
                        main.mana -= 150;
                        System.out.println("You now have " + main.mana + " mana.");
                        System.out.println("You summoned a fiery wave of energy, then released it as a massive, searing burst of flames!!");
                        return(150);
                    }else{
                    System.out.println("Not enough mana!");
                    inputCorrect = false;
                    }
                    break;
                case 8:
                    return(-999);
                default:
                    inputCorrect = false;
                    System.out.println("Your input is invalid. Remember, spell names aren't\n" +
                        "case sensitive, but you do have to spell them right.");
                    Battle.sleep();
                    break;
            }
            
        
        } while(inputCorrect == false);
        
    return(-1000);
    }
    
}