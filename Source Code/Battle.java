
package mazeofunknowndoom;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;


/**
 The battle class handles basically everything that is done in battle, 
 * aside from magic attacks which are relegated to the Magic Class.
 * Methods include "Battle", the constructor, "sleep", the text-delayer, 
 * "selection" which assigns input data, and the major acting method, "fight".
 */
public class Battle {

    public static boolean finalFight = false;
    private String monsterName, monsterMove; private int monsterHp, monsterAttack, monsterDefense; double monsterAcc, monsterEva; int killExp, abilityNum;
    Scanner input = new Scanner(System.in);
    /**
     This is a constructor method. It is declared with an index that determines what monster the battle will be against.
     * pre: none.
     * post: A battle has been initiated with a monster of a certain name with certain statistics.
     */
    public Battle(){    
    }
      /**
     This method serves only to delay the text output. Every time it is called, 
     it stops the text from printing, making text display to the screen more fluidly.
     * pre:none
     * post:none
     */

    public static void sleep(){
        try {
		Thread.sleep(900);        
            }catch (InterruptedException ie) {
		System.out.println(ie.getMessage());
            }
    }
    public static void contin(){
     try {
		System.out.println("\n(Press Enter to continue...)\n");
                System.in.read();        
            }catch (IOException ie) {
		System.out.println("Sorry, there was a glitch.");
            }
    }
    
     /**
     This method manages the user's attack commands and determines what number action to take.
     This number is then returned, unless the user inputs an invalid command.
     * pre: none as long as userMove is a valid string.
     * post: An integer corresponding to the user command has been returned.
     */
    private int selection(String userMove){
        if(userMove.equalsIgnoreCase("attack")){
            return(1);
        }else if(userMove.equalsIgnoreCase("focus")){
            return(2);
        }else if(userMove.equalsIgnoreCase("rage")){
            return(3);
        }else if(userMove.equalsIgnoreCase("Magic")){
            return(4);
        }else if(userMove.equalsIgnoreCase("DragonPunch")){
            return(5);
        }else if(userMove.equalsIgnoreCase("examine")){
            return(6);
        }else {
        
            return(0);
        }
    } 
    /**
     The primary acting method in this class, fight() starts actual combat, takes player's commands, 
     * executes the user's selected attacks and the CPU-controlled enemies' attacks, calls the Magic class,
     * and manages deaths by the user and the monsters.
     * pre:none
     * post: The user has successfully or unsuccessfully battled an enemy and either died or obtained EXP.
     */
    public void fight(int index){
        switch(index){
          case -7: monsterName = "Lucifer"; monsterMove = " warps over to you and unleashes fury!"; monsterHp = 1000; monsterAttack = 75; monsterDefense =  50; monsterAcc = 60; monsterEva = 60; killExp = 0; abilityNum = 3; break; 
          case -6: monsterName = "Abaddon"; monsterMove = " summons a flame and magically throws it!"; monsterHp = 800; monsterAttack = 30; monsterDefense =  10; monsterAcc = 10; monsterEva = 10; killExp = 1000; abilityNum = 2; break; 
          case -5: monsterName = "Mystical Guardian"; monsterMove = " flashes a beam at you!"; monsterHp = 500; monsterAttack = 15; monsterDefense =  20; monsterAcc = 40; monsterEva = 20; killExp = 600; abilityNum = 1; break; 
          case -4: monsterName = "Skeleton Lord"; monsterMove = " swings his sword swiftly!"; monsterHp = 300; monsterAttack = 25; monsterDefense =  25; monsterAcc = 25; monsterEva = 13; killExp = 400; abilityNum = 1; break; 
          case -3: monsterName = "The Sinister Shade"; monsterMove = " charges at you!"; monsterHp = 380; monsterAttack = 11; monsterDefense =  15; monsterAcc = 15; monsterEva = 25; killExp = 350; abilityNum = 2; break; 
          case -2: monsterName = "Graarg"; monsterMove = " takes a mighty swing!"; monsterHp = 400; monsterAttack = 25; monsterDefense =  10; monsterAcc = 8; monsterEva = 7; killExp = 300; abilityNum = 0; break; 
          case -1: monsterName = "Elragk"; monsterMove = " strikes with his powerful claws and teeth!"; monsterHp = 170; monsterAttack = 15; monsterDefense =  10; monsterAcc = 12; monsterEva = 8; killExp = 200; abilityNum = 1; break; 
          case 1: monsterName = "Slime"; monsterMove = " jumps up to smack you in the face!"; monsterHp = 45; monsterAttack = 5; monsterDefense =  9; monsterAcc = 6; monsterEva = 3; killExp = 55; break; 
          case 2: monsterName = "Keese"; monsterMove = " dives in for your jugular!"; monsterHp = 20; monsterAttack = 6; monsterDefense =  5; monsterAcc = 10; monsterEva = 9; killExp = 64; break;
          case 3: monsterName = "Goblin"; monsterMove = " rakes at you with its claws!"; monsterHp = 60; monsterAttack = 10; monsterDefense =  8; monsterAcc = 4; monsterEva = 2; killExp = 60; break;
          case 4: monsterName = "Anacobra"; monsterMove = " strikes out to bite you!"; monsterHp = 75; monsterAttack = 10; monsterDefense =  5; monsterAcc = 20; monsterEva = 12; killExp = 109; break;
          case 5: monsterName = "Adorable Kitten"; monsterMove = " swings its claws at you!"; monsterHp = 120; monsterAttack = 12; monsterDefense =  6; monsterAcc = 12; monsterEva = 15; killExp = 114; break;
          case 6: monsterName = "Native Warrior"; monsterMove = " stabs at you with his spear!"; monsterHp = 100; monsterAttack = 15; monsterDefense =  8; monsterAcc = 10; monsterEva = 10; killExp = 106; break;
          case 7: monsterName = "Corrupted Guard"; monsterMove = " tries to slash you!"; monsterHp = 120; monsterAttack = 18; monsterDefense =  17; monsterAcc = 18; monsterEva = 9; killExp = 222; break;
          case 8: monsterName = "Lurking Shadow"; monsterMove = " launches some ectoplasm!"; monsterHp = 120; monsterAttack = 13; monsterDefense =  14; monsterAcc = 23; monsterEva = 14; killExp = 228; break;
          case 9: monsterName = "Plagued Growth"; monsterMove = " whips at you with a tentacle of some sort!"; monsterHp = 250; monsterAttack = 24; monsterDefense = 9; monsterAcc = 13; monsterEva = 4; killExp = 225; break;
          case 10: monsterName = "Mutation"; monsterMove = " uses one of its odd appendages!"; monsterHp = 200; monsterAttack = 19; monsterDefense =  18; monsterAcc = 12; monsterEva = 8; killExp = 231; break;
          case 11: monsterName = "Rock Golem"; monsterMove = " lobs a rock!"; monsterHp = 200; monsterAttack = 26; monsterDefense =  28; monsterAcc = 16; monsterEva = 2; killExp = 297; break;
          case 12: monsterName = "Wild Ape"; monsterMove = " swings its arm angrily!"; monsterHp = 150; monsterAttack = 20; monsterDefense =  12; monsterAcc = 28; monsterEva = 25; killExp = 300; break;
          case 13: monsterName = "Velociraptor"; monsterMove = " jumps at you!"; monsterHp = 145; monsterAttack = 16; monsterDefense =  10; monsterAcc = 35; monsterEva = 32; killExp = 321; break;
          case 14: monsterName = "Neanderthal"; monsterMove = " swings his club!"; monsterHp = 120; monsterAttack = 20; monsterDefense =  8; monsterAcc = 32; monsterEva = 25; killExp = 291; break;
          case 15: monsterName = "Minotaur"; monsterMove = " charges!"; monsterHp = 200; monsterAttack = 22; monsterDefense =  16; monsterAcc = 28; monsterEva = 24; killExp = 440; break;
          case 16: monsterName = "Giant Slime"; monsterMove = " jumps forward to land on you!"; monsterHp = 215; monsterAttack = 20; monsterDefense = 29; monsterAcc = 24; monsterEva = 12; killExp = 440; break;
          case 17: monsterName = "Deathworm"; monsterMove = " lunges to feast on you!"; monsterHp = 160; monsterAttack = 15; monsterDefense =  10; monsterAcc = 40; monsterEva = 30; killExp = 444; break;
          case 18: monsterName = "Mini-Demon"; monsterMove = " shoots a fireball!"; monsterHp = 400; monsterAttack = 30; monsterDefense =  8; monsterAcc = 18; monsterEva = 20; killExp = 464; break;
          case 19: monsterName = "Large Crawling Hand"; monsterMove = " attempts to punch you!"; monsterHp = 220; monsterAttack = 30; monsterDefense =  10; monsterAcc = 30; monsterEva = 15; killExp = 428; break;
          case 20: monsterName = "Goliath"; monsterMove = " tries to stomp on you!"; monsterHp = 500; monsterAttack = 50; monsterDefense =  15; monsterAcc = 10; monsterEva = 1; killExp = 504; break;
          case 21: monsterName = "Shadow-Rex"; monsterMove = " bends down to bite!"; monsterHp = 400; monsterAttack = 40; monsterDefense =  20; monsterAcc = 15; monsterEva = 10; killExp = 500; break;
          case 22: monsterName = "Black Dragon"; monsterMove = " claws and bites!"; monsterHp = 350; monsterAttack = 35; monsterDefense =  20; monsterAcc = 24; monsterEva = 16; killExp = 520; break;
          case 23: monsterName = "Demon"; monsterMove = " launches a large fireball!"; monsterHp = 450; monsterAttack = 45; monsterDefense =  12; monsterAcc = 15; monsterEva = 20; killExp = 508; break;
          case 24: monsterName = "Evil Phoenix"; monsterMove = " swoops down with open claws!"; monsterHp = 300; monsterAttack = 15; monsterDefense = 8; monsterAcc = 30; monsterEva = 40; killExp = 480; break;
            
        
        }
        if (index > 0) { 
        System.out.println("A " + monsterName + " appeared!");
        } else {
        System.out.println("Get ready to fight " + monsterName + "!");
        }
        int damage, monsterDamage; double hitchance, monsterHitchance; String userMove; int magicPow;
        while(main.health > 0 && monsterHp > 0){
            if(main.health > 0){
            System.out.println("\nYour Health: " + main.health);
            System.out.println("Your Mana: " + main.mana);
            System.out.println("What will you do?\n");
            boolean correctInput = false;
            while (correctInput == false) {
            correctInput = true;
            userMove = input.next();
            switch(selection(userMove)){
                case 1: //the standard attack
                    damage = (int)((20 + ((int)((20 * Math.random()) - 6))) * (main.attack / monsterDefense));
                    switch (main.difficulty) {
                        case 0: damage *= 1.5; break;
                        case 1: damage *= 1.25; break;
                    }
                    hitchance = 50 * ((main.concentration/monsterEva));
                    switch (main.difficulty) {
                        case 0: hitchance *= 1.5; break;
                        case 1: hitchance *= 1.25; break;
                    }
                    if (Math.random() * 100 < hitchance){
                    if (damage > 0) {monsterHp -= damage;}
                    else {damage += 1; monsterHp -= damage;}
               
                    if (index > 0) {
                        System.out.println("You hit " + monsterName + " for " + damage + " damage!");
                    }
                    else {
                        System.out.println(monsterName + " took " + damage + " damage!");
                    }
                
                }else{ 
                if (index > 0) {
                    System.out.println("The " + monsterName + " swiftly avoided the attack!");
                }
                else {
                    System.out.println(monsterName + " dodged smoothly!");
                }
                }
                    break;
                case 2: if (main.mana >= 5) {System.out.println("You focused your mind, shutting out everything but your target...");
                    sleep();
                    sleep();
                    damage = (int)(.90 * (20 + ((int)((10 * Math.random()) - 6))) * (main.attack / monsterDefense));
                    switch (main.difficulty) {
                        case 0: damage *= 1.5; break;
                        case 1: damage *= 1.25; break;
                    }
                    hitchance = 80 * ((main.concentration/monsterEva)); 
                    switch (main.difficulty) {
                        case 0: hitchance *= 1.5; break;
                        case 1: hitchance *= 1.25; break;
                    }
                    if (Math.random() * 100 < hitchance){
                    monsterHp -= damage;
                    if (index > 0) {
                        System.out.println("You swiftly struck the " + monsterName + " for " + damage + " damage!");
                    }
                    else {
                        System.out.println("You quickly hit " + monsterName + " for " + damage + " damage!");
                    }
                    }else{ 
                        System.out.println("With an incredible burst of speed (or maybe some luck), your opponent narrowly avoided your attack!");
                    }
                    main.mana -= 5;
                } else {System.out.println("You lack mana!");}
                    break;
                case 3: if (main.mana >= 5) {System.out.println("You angrily charge forward!");
                    sleep();
                    damage = 5 + (int)(1.5 * (20 + ((int)((10 * Math.random()) -6))) * (main.attack / monsterDefense));
                    switch (main.difficulty) {
                        case 0: damage *= 1.5; break;
                        case 1: damage *= 1.25; break;
                    }
                    hitchance = 40 * ((main.concentration/monsterEva));
                    switch (main.difficulty) {
                        case 0: hitchance *= 1.5; break;
                        case 1: hitchance *= 1.25; break;
                    }
                    if (Math.random() * 100 < hitchance){
                    monsterHp -= damage;
                    if (index > 0) {
                        System.out.println("You pounded the " + monsterName + " with all your might, dealing a crushing " + damage + " damage!");
                    }
                    else {
                        System.out.println("You pummeled " + monsterName + " with all your might, dealing a crushing " + damage + " damage!");
                    }
                    }else{ 
                    System.out.println("Your foe evaded your attack, laughing spitefully!");
                    }
                    main.mana -= 5;
                } else {System.out.println("You lack mana!");}
                    break;
                case 4: //Case 4 is a magic number, yes it is, it's a magic number.
                    magicPow = Magic.magicAttack(main.health, main.mana);
                    if (magicPow != -999) {
                    if (magicPow != -1000) {magicPow = (magicPow * main.concentration) / 15;
                    switch (main.difficulty) {
                        case 0: magicPow *= 1.5; break;
                        case 1: magicPow *= 1.25; break;
                    }
                    }
                    if(magicPow == -1000){
                        System.out.println("Your attempt at using magic failed!");
                        System.out.println("Your enemy uses the opening to attack!");
                    }else if(magicPow > 0){
                        monsterHp -= magicPow;
                        if (index > 0) {
                            System.out.println("The " + monsterName + " took " + magicPow + " damage!");
                        }
                        else {
                            System.out.println(monsterName + " took " + magicPow + " damage!");
                        }
                    }else if(magicPow < 0){
                        magicPow = -magicPow;
                        if(main.health + magicPow >= main.maxHealth){
                            main.health = main.maxHealth;
                            System.out.println("Your health is now maxed out at " + main.maxHealth + "!");
                        }else{
                        main.health += magicPow;
                        System.out.println("You recovered " + magicPow + " health!");
                        System.out.println("You now have " + main.health + " health.");
                        }
                    }else if(magicPow == 0){
                        if(main.health + 30 >= main.maxHealth){
                            main.health = main.maxHealth;
                            monsterHp -= 30;
                            System.out.println("You absorbed life energy from your target to fully replenish your own!");
                        }else{
                        main.health += 30;
                        monsterHp -= 30;
                        System.out.println("You absorbed 30 points of health from the target and brought your own health to " + main.health + ".");
                        }
                    }
                    } else {
                        correctInput = false;
                    } 
                    break;
                case 5:
                    if (main.progress >= 2) {
                    if (main.mana > 0) {
                    damage = main.mana * 2;
                    switch (main.difficulty) {
                        case 0: damage *= 1.5; break;
                        case 1: damage *= 1.25; break;
                    }
                    main.mana = 0;
                    System.out.println("You channeled the power of the Flame Dragon into your fist..."); sleep();
                System.out.println("Leaping through the air, you launched a bone-shattering, earth-shaking punch that hits your opponent for " + damage + " damage!");
                monsterHp -= damage;
                    } else {
                        System.out.println("No mana. Your hand makes an odd farting noise.");
                    }
                    } else {
                        System.out.println("You don't have that ability yet...");
                    }
                    break;
                    
                case 6: 
                    if (main.mana > 0) {
                        main.mana -= 5;
                        System.out.println("You use your magic and examine the vitality of your foe...");
                        System.out.println("The opponent has " + monsterHp + " health right now.");
                        double multi;
                        switch (main.difficulty) {
                            case 0: multi = 1.5; break;
                            case 1: multi = 1.25; break;
                            default: multi = 1; break;
                    }
                        if ((main.attack * multi / monsterAttack) >= 2) {
                            System.out.println("Your attack power is far superior to your opponent's.");
                        } else if ((main.attack * multi / monsterAttack) >= 1.5) {
                            System.out.println("Your attack power exceeds that of your foe's.");
                        } else if ((main.attack * multi / monsterAttack) <= (2/3)) {
                            System.out.println("Your foe's attack power is higher than yours.");
                        } else if ((main.attack * multi / monsterAttack) <= 0.5) {
                            System.out.println("Your foe's attack power completely tops yours.");
                        } else {
                            System.out.println("Your attack power is about the same as your enemy's.");
                        }
                        if ((main.defense * multi / monsterDefense) >= 2) {
                            System.out.println("Your defensive ability is far superior to your opponent's.");
                        } else if ((main.defense * multi / monsterDefense) >= 1.5) {
                            System.out.println("Your defensive ability exceeds that of your foe's.");
                        } else if ((main.defense * multi / monsterDefense) <= (2/3)) {
                            System.out.println("Your foe's defensive ability is higher than yours.");
                        } else if ((main.defense * multi / monsterDefense) <= 0.5) {
                            System.out.println("Your foe's defensive ability completely tops yours.");
                        } else {
                            System.out.println("Your defensive ability is about the same as your enemy's.");
                        }
                        if ((main.concentration * multi / monsterAcc) >= 2) {
                            System.out.println("Your concentration is far superior to your opponent's.");
                        } else if ((main.concentration * multi / monsterAcc) >= 1.5) {
                            System.out.println("Your concentration exceeds that of your foe's.");
                        } else if ((main.concentration * multi / monsterAcc) <= (2/3)) {
                            System.out.println("Your foe's concentration is higher than yours.");
                        } else if ((main.concentration * multi / monsterAcc) <= 0.5) {
                            System.out.println("Your foe's concentration completely tops yours.");
                        } else {
                            System.out.println("Your concentration is about the same as your enemy's.");
                        }
                        if ((main.evasion * multi / monsterEva) >= 2) {
                            System.out.println("Your evasion stat is far superior to your opponent's.");
                        } else if ((main.evasion * multi / monsterAcc) >= 1.5) {
                            System.out.println("Your evasion stat exceeds that of your foe's.");
                        } else if ((main.evasion * multi / monsterAcc) <= (2/3)) {
                            System.out.println("Your foe's evasion stat is higher than yours.");
                        } else if ((main.evasion * multi / monsterAcc) <= 0.5) {
                            System.out.println("Your foe's evasion stat completely tops yours.");
                        } else {
                            System.out.println("Your evasion stat is about the same as your enemy's.");
                        }
                    }
                    else {
                        System.out.println("You have no mana, so you lose your focus!");
                    }
                    break;
                default: correctInput = false; System.out.println("Incorrect input. Try again...");
                    break;
            }
            }
            
            sleep();
            }
            if(monsterHp > 0){
            if (index < 0 && abilityNum > 0) {
                int baseDam;
                switch (main.difficulty) {
                        case 0: baseDam = 30; break;
                        case 1: baseDam = 40; break;
                        default: baseDam = 50; break;
                    }
                switch (index) {
                    case -1:System.out.println("Elragk breathes out fire that you can't avoid or defend! It burns you!\n You took " + baseDam + " damage!"); main.health -= baseDam; abilityNum -= 1; break; 
                    case -3:if (monsterHp > 200) {System.out.println("The Shade's gaze cripples you in pain!\n You took " + (baseDam * 2) + " damage!"); main.health -= (baseDam * 2);} else {System.out.println("The Shade powers itself up, healing it by " + (baseDam * 2) + " health!"); monsterHp += 100;} abilityNum -= 1; break; 
                    case -4:if (monsterHp <= 100) {System.out.println("The Lord lunges with a supernatural force!\n You took " + (baseDam * 2) + " damage!"); main.health -=(baseDam * 2); abilityNum -= 1;}
                    else {monsterDamage = (int)((20 + ((int)((20 * Math.random()) - 6))) * (monsterAttack / main.defense));
            switch (main.difficulty) {
                        case 0: monsterDamage *= .6; break;
                        case 1: monsterDamage *= .8; break;
                    }
            monsterHitchance = 50 * (monsterAcc / main.evasion);
            switch (main.difficulty) {
                        case 0: monsterHitchance *= 0.6; break;
                        case 1: monsterHitchance *= 0.8; break;
                    }
            System.out.println(monsterName + monsterMove);
            if (Math.random() * 100 < monsterHitchance){
            if (monsterDamage > 0) {main.health -= monsterDamage;}
                    else {monsterDamage += 1; main.health -= monsterDamage;}
            System.out.println("You took " + monsterDamage + " damage!");
           } else { 
            System.out.println("You swiftly sidestep the attack!");
            } 
            sleep();}
            break;
                    case -5: if (monsterHp <= 100) {System.out.println("The Guardian glows brilliantly, then unleashes a ray of light!\n You took " + (baseDam * 2) + " damage, and your opponent was healed by " + (baseDam * 2) + "!"); main.health -= (baseDam * 2); monsterHp += (baseDam); abilityNum -= 1;}
                    else {monsterDamage = (int)((20 + ((int)((20 * Math.random()) - 6))) * (monsterAttack / main.defense));
             switch (main.difficulty) {
                        case 0: monsterDamage *= 0.6; break;
                        case 1: monsterDamage *= 0.8; break;
                    }
            monsterHitchance = 50 * (monsterAcc / main.evasion); 
             switch (main.difficulty) {
                        case 0: monsterHitchance *= 0.6; break;
                        case 1: monsterHitchance *= 0.8; break;
                    }
            System.out.println(monsterName + monsterMove);
            if (Math.random() * 100 < monsterHitchance){
            if (monsterDamage > 0) {main.health -= monsterDamage;}
                    else {monsterDamage += 1; main.health -= monsterDamage;}
            System.out.println("You took " + monsterDamage + " damage!");
           } else { 
            System.out.println("You swiftly sidestep the attack!");
            } 
            sleep();}
            break;
                    case -6:if (monsterHp > 500) {System.out.println("Abaddon picks you up with telekinesis, then throws you down!\n You took " + (baseDam * 3) + " damage!"); main.health -= (baseDam * 3);} else {System.out.println("Your eyes start to bleed, which allows Abaddon to heal her wounds " + (baseDam * 3) + " health points!"); monsterHp += (baseDam * 3);} abilityNum -= 1; break; 
                    case -7:if (monsterHp > 750) {System.out.println("Lucifer lets loose with a fire-like energy!\n You took " + (baseDam * 4) + " damage!"); main.health -= (baseDam * 4);} else if (monsterHp > 350) {{System.out.println("Lucifer freezes you with his breath, and takes the oppurtunity to power himself up, healing by " + (baseDam * 4) +"!"); monsterHp += (baseDam * 4);}} else {System.out.println("Lucifer mumbles ominously, and you feel weakened. He causes you to release " + Math.min(baseDam, main.mana) + " mana!"); main.mana -= Math.min(baseDam, main.mana);}abilityNum -= 1; break; 
                }
            } else {
            monsterDamage = (int)((20 + ((int)((20 * Math.random()) - 6))) * (monsterAttack / main.defense));
             switch (main.difficulty) {
                        case 0: monsterDamage *= 0.6; break;
                        case 1: monsterDamage *= 0.8; break;
                    }
            monsterHitchance = 50 * (monsterAcc / main.evasion);
             switch (main.difficulty) {
                        case 0: monsterHitchance *= 0.6; break;
                        case 1: monsterHitchance *= 0.8; break;
                    }
            System.out.println(monsterName + monsterMove);
            if (Math.random() * 100 < monsterHitchance){
            if (monsterDamage > 0) {main.health -= monsterDamage;}
                    else {monsterDamage += 1; main.health -= monsterDamage;}
            System.out.println("You took " + monsterDamage + " damage!");
           } else { 
            System.out.println("You swiftly sidestep the attack!");
            }
            
            sleep();
            }
            
        }
        }
        //repeat until last standing then give EXP after the while
        if (main.health <= 0){
            if (finalFight == false) {
            System.out.println(main.name + " falls to the ground in defeat.");
            sleep();
            System.out.print("GAME ");
            sleep();
            System.out.print("OVER ");
            main.health = main.maxHealth;
            main.mana = main.maxMana;
            if (index > -7) {
            System.out.println("\nWould you like to save your data to keep your experience points? (type \"yes\" if you want to)");
            String answer = input.next();
            if (answer.equalsIgnoreCase("yes")) {
                main.save();
            }
            }
            System.exit(0);
            } else {
               finalFight = false;
               main.health = main.maxHealth;
               main.mana = main.maxMana;
               sleep();
               System.out.println("You have 0 health left...");
               sleep();
               sleep();
               sleep();
               System.out.println("\nYou fall down in defeat, watching as a blurry image of Lucifer chortling cruelly fades to black.\n " +
                       "How could this be? You've come so far, only to get killed by your own king! You've accomplished nothing!");
               contin();
               System.out.println("...You are awakened by a calm, soothing, female voice. It tells you to stand up. You do so, taking notice of your surroundings.\n " +
                       "The world around you is calm and peaceful. You are standing on a white cloud... wait, the whole ground is a cloud!\n " +
                       "The sky is blue and sunny. Time seems to be... gone. Along with worries and cares. What is this wonderful place?\n " +
                       "You notice an angel floating beside you. She speaks with that gentle voice, \"I have been watching over you.\n " +
                       "You look confused. I am the angel that watches over the planet. I am known as the Protecter. I was the one who sent the dragon. I was the one who\n " +
                       "made the ogre attack the village. I did not intend any harm, though. Instead, I knew that Lucifer would eventually find a way to release\n " +
                       "Abaddon, even without your help. But I cannot interfere directly with Lucifer, as that is not permitted in the rules of the balance.\n " +
                       "The rules state that, as long as I am able to watch over the land and control life, I am not allowed to mess with the affairs of evil, as to\n " +
                       "maintain the balance between good and evil. So I was troubled... until I realized your potential. I understood you could be able to stop Lucifer.\n " +
                       "So I lured every other guard away with a quest that I set up, and then I sent the dragon, followed by the ogre. Not to kill you, but rather\n " +
                       "to strengthen you. I let you fight through the maze so that you'll be strong. Then you would be ready. But you lost.\n " +
                       "Yet, not because you weren't enough. Instead, it was because he was too much. You see, in his rage from you killing Abaddon,\n " +
                       "he started to take over the world himself. But he drew too much power, and has now upset the balance! This is not allowed.\n " +
                       "Normally, I might try to regain balance by fighting Lucifer myself, but I fear I don't have the power. But you do.\n " +
                       "So, in order to maintain balance, I will resurrect you, and give you more power, for unlike me, you have the\n " +
                       "capabilites to use that extra power. As such, you will come alive again, ready to fight, and you will be more powerful\n " +
                       "than ever before! But use this new strength wisely, for the fate of the world is in your hands! Good luck, brave " + main.name + "...\'\n ");
                sleep();
                contin();
                System.out.println("You wake up, with energy surging through you. Lucifer turns around in utter astonishment.\n " +
                        "\"No! Thou're suppos'd to be dead! Be. . . be it the work of the Protecter? Might she be angry that I upset the balance?\n " +
                        "No matter. I shalt kill thou again. This time, however, I aim to ensure it's... permanent!\"\n " +
                        "But you can tell Lucifer doesn't know that you now have super-strength. You feel energy coursing through your veins.\n " +
                        "And with that energy, a seething rage against Lucifer, and a burning passion to defeat him. Stats increased!\n ");
                main.health = main.health + 100;
                main.maxHealth = main.maxHealth + 100;
                main.maxMana = main.maxMana + 100;
                main.mana = main.mana + 100;
                main.attack = main.attack + 40;
                main.defense = main.defense + 40;
                main.concentration = main.concentration + 40;
                main.evasion = main.evasion + 40;
                System.out.println("Health: " + main.health);
                System.out.println("Mana: " + main.mana);
                System.out.println("Attack: " + main.attack);
                System.out.println("Defense: " + main.defense);
                System.out.println("Concentration: " + main.concentration);
                System.out.println("Evasion: " + main.evasion);
                contin();
                
            }
        } else if(monsterHp <= 0) {
            if (finalFight == false) {
            if (index > 0) {System.out.println("You defeated the " + monsterName + "!");}
            else {System.out.println("Congratulations! You have slain the mighty " + monsterName + "!");}
            if (index > -7) {System.out.println("Recieved " + killExp + " experience points!");
            main.experience += killExp;
            System.out.println("");
            levelUp();
            }
            } else {
                monsterHp = 1000;
                System.out.println("Lucifer roars in anger and shakes off his wounds.");
                System.out.println("In his rage, he strikes at you with supernatural power!");
                System.out.println("You took " + (main.health - 1) + " damage!");
                main.health = 1;
            }
        }
       
    }
    /**
     Levels up character when a certain number of EXP is reached.
     * pre: none
     * post: Levels are added for experience, and stats are increased.
     */
        public void levelUp() {
            if (main.experience > main.expNeeded) {
                main.experience -= main.expNeeded;
                main.level ++;
                System.out.println("Level Up! Your level is now " + main.level + "!");
                main.expNeeded += 100;
                main.mana = main.maxMana;
                main.health = main.maxHealth;
                System.out.println("Do you want to upgrade Health or Mana? Type your answer.");
                boolean canCon = false;
                while (canCon == false) {
                String selector = input.next();
                if (selector.equalsIgnoreCase("health")) {
                    main.health += 25;
                    main.maxHealth += 25;
                    canCon = true;
                } else if (selector.equalsIgnoreCase("mana")) {
                    main.maxMana += 20;
                    main.mana += 20;
                    canCon = true;
                }
                else {
                    System.out.println("Invalid command. Try again.");
                }
                }
                System.out.println("Now, choose which stat to upgrade the most, by typing either attack, defense, concentration, or evasion.");
                canCon = false;
                while (canCon == false) {
                String selector = input.next();
                switch (selector) {
                    case "attack": main.attack += 1; canCon = true; break;
                    case "defense": main.defense += 1; canCon = true; break;
                    case "concentration": main.concentration += 1; canCon = true; break;
                    case "evasion": main.evasion += 1; canCon = true; break;
                    default: System.out.println("Invalid command. Try again. "); break;
                }
                }
                main.attack ++;
                main.defense ++;
                main.concentration ++;
                main.evasion ++;
                System.out.println("");
            } 
        }
}

/*
while(hp > 0){
damage = (20 + ((int)((10 * Math.random()) -6))) * (attack / defense); //<rounded up> 
hitchance = 50 * ((acc/eva)); //<rounded normally>
//if (Math.random() * 100 < hitchance) then hit equals true;
//if (hit equals true) then hp -= damage
    }
 */

