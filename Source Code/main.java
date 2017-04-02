
package mazeofunknowndoom;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.nio.file.*;
public class main {
public static void startAbility() {
Scanner input = new Scanner(System.in);
boolean correctInput = false;
while (correctInput == false) { 
System.out.println("");
System.out.println("Select your starting stat loadout by entering one of these names: ");
System.out.println("Heroic: stats are balanced and well-rounded.");
System.out.println("Warlike: evasive, magic, and defensive skills are replaced with warrior-like stats.");
System.out.println("Brutal: most stats lowered in exchange for massive health and powerful attack.");
System.out.println("Stealthy: more focused on dodging and defending than brute force.");
System.out.println("Magical: mana is mostly focused on.");
System.out.println("Spiritual: lowered attack, defence, and health to compensate for the heightened mana.");
System.out.println("Safe: with increased health, concentration, and evasion for a less risky fight.");
System.out.println("Enter a number: ");
String selector = input.next();
switch (selector.toLowerCase()) {
    case "heroic": health = 100; mana = 100; attack = 10; defense = 10; concentration = 10; evasion = 10; correctInput = true; break;
    case "warlike": health = 150; mana = 60; attack = 16; defense = 9; concentration = 9; evasion = 6; correctInput = true; break;
    case "brutal": health = 200; mana = 0; attack = 22; defense = 8; concentration = 10; evasion = 4; correctInput = true; break;
    case "stealthy": health = 100; mana = 80; attack = 4; defense = 13; concentration = 14; evasion = 18; correctInput = true; break;
    case "magical": health = 90; mana = 150; attack = 5; defense = 9; concentration = 12; evasion = 10; correctInput = true; break;
    case "spiritual": health = 80; mana = 200; attack = 2; defense = 7; concentration = 13; evasion = 4; correctInput = true; break;
    case "safe": health = 110; mana = 60; attack = 6; defense = 10; concentration = 12; evasion = 15; correctInput = true; break;
    default: correctInput = false;
}
}    
maxHealth = health;
maxMana = mana;
stats();
System.out.println();
boolean canCon = false;
System.out.println("Now, select a difficulty level for your quest by typing the name...");
System.out.println("Regular: For a more casual experience to help those who are new to RPG's like this.");
System.out.println("Challenging: For RPG players ready to take on whatever challenges they face.");
System.out.println("Realistic: For experienced players willing to struggle for their success.");
System.out.println("Hardcore: WARNING! Meant solely for players who have completed the game on realistic\n " + 
        "mode. It's similar to realistic, but YOUR PROGRESS WILL NOT BE SAVED!");
while (canCon == false) {
switch ((input.next()).toLowerCase()) {
    case "regular": difficulty = 0; break;
    case "challenging": difficulty = 1; break;
    case "realistic": difficulty = 2; break;
    case "hardcore": difficulty = 3; break;
    default: difficulty = 4; break;
}
if (difficulty == 4) {
    System.out.println("Incorrect input.");
} else {
    canCon = true;
}
}
}
public static void stats() {
    System.out.println("\nHere are your stats: ");
    System.out.println("HEALTH " + health + "/" + maxHealth + "\t" + "MANA " + mana + "/" + maxMana);
    System.out.println("Attack is " + attack + ", Defense is " + defense + ", Concentration is " + concentration + ", and Evasion is " + evasion);
    System.out.println("Your current level is: " + level + ", and you need " + (expNeeded - experience) + " more experience points to level up.\n");
}

public static void save() {
    if (difficulty == 3) {
        return;
    }
    try {
        System.out.println("Saving...");
        PrintWriter write = new PrintWriter("data");
        write.println(name);
        write.println(Integer.toOctalString(progress * 13));
        write.println(Integer.toOctalString(experience * 9));
        write.println(Integer.toOctalString(level * 10));
        write.println(Integer.toOctalString(cap * 14));
        write.println(Integer.toOctalString(maxHealth * 18));
        write.println(Integer.toOctalString(health * 12));
        write.println(Integer.toOctalString(maxMana * 11));
        write.println(Integer.toOctalString(mana * 5));
        write.println(Integer.toOctalString(attack * 19));
        write.println(Integer.toOctalString(defense * 10));
        write.println(Integer.toOctalString(concentration * 13));
        write.println(Integer.toOctalString(evasion * 14));
        write.println(Integer.toOctalString(expNeeded * 19));
        write.println(Integer.toOctalString(difficulty * 2));
        write.close();
    } catch (FileNotFoundException e) {
        System.err.println("Could not write to file. Error code " + e.getMessage());
    }
}
public static int maxHealth, health, maxMana, mana, attack, defense, concentration, evasion, level = 1, experience = 0, expNeeded = 100, progress = 0, difficulty = 0;
public static String name;
public static int cap = 0;
    
    public static void main(String[] args) {
       
    Scanner input = new Scanner(System.in);
    Battle fight = new Battle();
    boolean cont = false;
    try {
        File file = new File("data");
    
    if (!file.exists()) {
            file.createNewFile();
        }
    else {
         System.out.println("You appear to have a save file. Load from the file? Enter \"yes\" if you do. Otherwise, this data will be erased.");
         String answer = input.next();
         if (file.length() > 1 && answer.equalsIgnoreCase("yes")) {
         System.out.println("Loading...");
         BufferedReader in = new BufferedReader(new FileReader(file));
         name = in.readLine();
         progress = Integer.parseInt(in.readLine(),8) / 13;
         experience = Integer.parseInt(in.readLine(),8) / 9;
         level = Integer.parseInt(in.readLine(),8) / 10;
         cap = Integer.parseInt(in.readLine(),8) / 14;
         maxHealth = Integer.parseInt(in.readLine(),8) / 18;
         health = Integer.parseInt(in.readLine(),8) / 12;
         maxMana = Integer.parseInt(in.readLine(),8) / 11;
         mana = Integer.parseInt(in.readLine(),8) / 5;
         attack = Integer.parseInt(in.readLine(),8) / 19;
         defense = Integer.parseInt(in.readLine(),8) / 10;
         concentration = Integer.parseInt(in.readLine(),8) / 13;
         evasion = Integer.parseInt(in.readLine(),8) / 14;
         expNeeded = Integer.parseInt(in.readLine(),8) / 19;
         difficulty = Integer.parseInt(in.readLine(),8) / 2;
         } else {
             file.delete();
             file.createNewFile();
         }
    }
    } catch (IOException e) {
        System.err.println("Error accessing the save file. Error code " + e.getMessage());
    }
    
    
    
    if (progress == 0) {
    System.out.println("The King bursts out of his castle doors, and approaches you.\n" +
            "\"You there! What be thy name?\" He inquires.\n");
    System.out.println("Enter your name: ");
    name = input.next();
    System.out.println("\n\"So, " + name + ", you must be a new guard, argal your fighting prowess\n " +
            "hast nay toning, but all the oth'r guards in my kingdom, especially the strong ones, \n " +
            "are out on an important journey - a quest - and thou seem to be the only one left. As such, I have for you\n " +
            "a tasl that only you will attempt: fight the dragon that approaches from the yonder hillside!\n " +
            "It appears to be coming this way, and it obviously seeks to kill me. You must slay it anon! Hence!\"");
    Battle.contin();
    System.out.println("And so you begin your journey to kill this dragon that appeared so suddenly...");
    startAbility();
    if (difficulty == 3) {
        try {
            Files.delete(Paths.get("data"));
        } catch (IOException e) {
            
        }
    }
    System.out.println("As you walk along, you notice something... sinister: a dark cloud\n " +
            "formed in the distance. Suddenly, a shadow-like blob appeared on the ground in front\n " +
            "of you. The blob started to bubble, and then it formed into a shady figure.\n " +
            "The shadows on the figure dissipated, revealing a monster! Things are about to get ugly...\n");
    Battle.contin();
    fight.fight(1);
    System.out.println("You kill the gelatinous creature, and smirk. Nobody had guessed that you had supernatural power.\n " +
            "Then again, who would? You're just a normal-looking guard, but only you knew better, right? Still, you must carry on,\n " +
            "to fight the dragon coming towards your king. So, you continue onward, ready to fight any more monsters\n " +
            "that you encounter. No regrets, no retreats, no excuses!\n");
    Battle.contin();
    progress++;
    save();
    }
    if (progress == 1) {
    cont = false;
    while (cont == false) {
    System.out.println("Will you continue on? Enter \"boss\" to go on and battle the boss, enter \"fight\" to search for another enemy.");
    System.out.println("Additionally, you may enter \"stats\" to view your stats. ");
    System.out.println("Enter a valid selection: ");
    String choose = input.next();
    switch (choose.toLowerCase()) {
        case "boss": cont = true; break;
        case "fight": cont = false; cap++; fight.fight((int)(Math.random() * 3 + 1)); break;
        case "stats": stats(); cont = false; break;
        default: System.out.println("Incorrect input. "); cont = false;
    }
    }
    
    
    System.out.println("You decide to continue. You walk along the grassy field, until you notice a small shack.\n " +
            "As you walk in, you feel a sort of oddly calming energy about. It relaxes you, and you find some food\n " +
            "and drinks. After about an hour, you feel completely rested. Then, you notice something out the window...\n " +
            "Oh no! It's the dragon you were sent to kill! You grab your stuff, and step out the door. The dragon\n " +
            "feels your presence, and turns around to face you! The dragon states his name: Elragk. You ready your sword.\n " +
            "This is it! No turning back...\n");
    
    Battle.contin();
    health = maxHealth;
    mana = maxMana;
    fight.fight(-1);
    System.out.println("You absorbed the power of the dragon, and learned the Dragon Punch!");
    System.out.println("To execute, input \"DragonPunch\" in battle to use all your mana in a flaming punch!\n");
    
    Battle.contin();
    
    
    System.out.println("After the death of the dragon, you feel stronger than you were before, yet still weak from battle.\n " +
            "You notice a village, in which you might be able to rest for a while, and maybe collect your thoughs.\n " +
            "Inside, the villagers let you rest up, but only if you kill the ogre that ravages the village every night.\n " +
            "You agree, but they tell you that the ogre is supernaturally powerful, so you should fight the enemies\n " +
            "that lurk around the woods near the village in order to practice up for the fight. ");
    health = maxHealth;
    mana = maxMana;
    progress++;
    save();
    Battle.contin();
    }
    if (progress == 2) {
    cont = false;
    while (cont == false) {
    System.out.println("Will you continue on? Enter \"boss\" to go on and battle the boss, enter \"fight\" to search for another enemy.");
    System.out.println("Additionally, you may enter \"stats\" to view your stats. ");
    System.out.println("Enter a valid selection: ");
    String choose = input.next();
    switch (choose.toLowerCase()) {
        case "boss": cont = true; break;
        case "fight": cont = false; cap++; fight.fight((int)(Math.random() * 3 + 4)); break;
        case "stats": stats(); cont = false; break;
        default: System.out.println("Incorrect input. "); cont = false;
    }
    }
    System.out.println("The villagers give you more sustanance, after which they send you out to prepare.\n " +
            "At nightfall, you hear a noise. The ogre comes out. \"Me Graarg,\" he mumbles, \"You... food?\"\n " +
            "You ready yourself, and then you charge! It's time to make that ugly ogre pay...");
    
    Battle.contin();
    health = maxHealth;
    mana = maxMana;
    fight.fight(-2);
    System.out.println("The ogre collapses! Victory is yours! The villagers cheer you on. Your strength\n " +
            "is becoming massive. You feel indestructible! After saying your goodbyes, you head off,\n " +
            "back to your kingdom, ready to show the king that he underestimated you. Your journey is about to end.\n " +
            "...Or is it?...");
    health = maxHealth;
    mana = maxMana;
    Battle.contin();
    System.out.println("You walk towards the kingdom with a smile, but that smile fades upon seeing the castle.\n " +
            "The castle is covered in darkness, and some sort of growth is clinging to the rocky walls!\n " +
            "This is not good. Not in the least bit. You run towards the castle. You notice shades roaming about.\n " +
            "You see your fellow gaurds fighting to stay alive, but they are becoming infested with...\n " +
            "Huh? What is that? That... darkness... in their eyes... It's unnatural! They look ready to fight!\n " +
            "But not with the enemies; they want to fight YOU! Even though there are dark-colored growths and\n " +
            "even mutations, you must fight anything that stands in your way as you climb the castle to\n " +
            "reach your king. You have to make sure he's safe! You must fight even your fellow guards if you have to!");
    Battle.contin();
    progress++;
    save();
    }
    if (progress == 3) {
    cont = false;
    while (cont == false) {
    System.out.println("Will you continue on? Enter \"boss\" to go on and battle the boss, enter \"fight\" to search for another enemy.");
    System.out.println("Additionally, you may enter \"stats\" to view your stats. ");
    System.out.println("Enter a valid selection: ");
    String choose = input.next();
    switch (choose.toLowerCase()) {
        case "boss": cont = true; break;
        case "fight": cont = false; cap++; fight.fight((int)(Math.random() * 4 + 7)); break;
        case "stats": stats(); cont = false; break;
        default: System.out.println("Incorrect input. "); cont = false;
    }
    }
    System.out.println("You stop by your room near the door to the king's quarters. You rest for a moment,\n " +
            "regaining your senses and healing your wounds. You get up, and burst into the king's doors.\n " +
            "You see the king, locked up helplessly in dark shadow-based cage. A myserious ball,\n " +
            "dark as the night sky, floats in the air. Suddenly, a giant eye opens up on it! It gazes at you!\n " +
            "Its stare seems to penetrate right through your soul! You feel greatly disturbed. \"Help!\" Cries the king,\n " +
            "\"Thou must defeat the Sinister Shade! But you best be wary, for it's almost unkillable!\"");
    health = maxHealth;
    mana = maxMana;
    Battle.contin();
    fight.fight(-3);
    System.out.println("As you sheath your weapon, the Shade dissipates into the air. The cage holding the king does the same.\n " +
            "The king is speechless. \"" + name + "...\" he says, \"No. Pardon me. Sir " + name + ".\n " +
            "Thoust show'd genuine nobility and courage. Smiting the dragon, saving me! Remarkable!\n " +
            "I hast nothing else to say except thank you. I don't think there is aught that could do you in!\n " +
            "I believe, argal, that I oweth thou an apology... for underestimating thou. Thy power exceeds all others in this land!\n " +
            "And, well, there is to be nothing more to say to that. Anon... come rest up, for I have one more quest for thou...\"");
    health = maxHealth;
    mana = maxMana;
    Battle.contin();
    System.out.println("The king informs you of what the other knights failed to do:\n " +
            "Travel to the mysterious montains that lie across the valley. Fight your way up the hill.\n " +
            "Battle the guadian. Finally, enter the Maze of Unknown Doom. At the end, lies what is said to be\n " +
            "Untold fortune. With a reassurance, the king sends you off. When you reach the mountain, \n " +
            "you start your ascent, ready for all dangers that come your way!...");
    Battle.contin();
    progress++;
    save();
    }
    if (progress == 4) {
    cont = false;
    while (cont == false) {
    System.out.println("Will you continue on? Enter \"boss\" to go on and battle the boss, enter \"fight\" to search for another enemy.");
    System.out.println("Additionally, you may enter \"stats\" to view your stats. ");
    System.out.println("Enter a valid selection: ");
    String choose = input.next();
    switch (choose.toLowerCase()) {
        case "boss": cont = true; break;
        case "fight": cont = false; cap++; fight.fight((int)(Math.random() * 4 + 11)); break;
        case "stats": stats(); cont = false; break;
        default: System.out.println("Incorrect input. "); cont = false;
    }
    }
    System.out.println("You fight your way to the top. Eventually, you see the gate to the maze.\n " +
            "But, as you walk towards it, a figure appears. It bears the appearance of an 8-foot tall skeleton.\n " +
            "\"I have been waiting for you\" says the figure in a creaky deep voice. \"I am the Skeleton Lord.\"\n " +
            "\"I have been protecting the gate to the maze for almost 2000 years.\n " +
            "I have been waiting for you, O noble " + name + ". If you can best me in battle,\n " +
            "I will let you continue. Don't let your gaurd down, however, because\n " +
            "I have killed many warriors who tried to enter. They were not worthy. But you might be.\n " +
            "Now. fight me without quarter!\" With that, he pulls out his massive sword.");
    health = maxHealth;
    mana = maxMana;
    Battle.contin();
    fight.fight(-4);
    System.out.println("You stand there, panting. The Skeleton Lord falls down into a small pile of bones.\n " +
            "As you put your sword back, the Skeleton Lord resurrects himself. He also sheathes his weapon.\n " +
            "\'Well done. I am impressed. You are powerful, possibly the most powerful force on the planet!\n " +
            "I would be ashamed if I didn't let you in the Maze, because you have proven you're ready for it.\'\n " +
            "The Lord claps his boney hands, and the gate slowly opens. You are about to enter the\n " +
            "Maze of Unknown Doom. But, you rest up first, because what lie in the Maze are cruel...");
    health = maxHealth;
    mana = maxMana;
    Battle.contin();
    System.out.println("You feel you have no choice but to proceed. As you step in the Maze,\n " +
            "a chill runs down your spine. You hear strange noises. Cries. Moans. Even roars. It reeks of evil!\n " +
            "It is terrifying, but you remember your courage, and walk through the dark, moss-covered, rocky halls.\n " +
            "There is no way you could turn back now without regrets, so you try to walk around the maze to find the\n " +
            "center of it, which is the location of the treasure the King was seeking. Better get going...");
    Battle.contin();
    progress++;
    save();
    }
    if (progress == 5) {
    cont = false;
    while (cont == false) {
    System.out.println("Will you continue on? Enter \"boss\" to go on and battle the boss, enter \"fight\" to search for another enemy.");
    System.out.println("Additionally, you may enter \"stats\" to view your stats. ");
    System.out.println("Enter a valid selection: ");
    String choose = input.next();
    switch (choose.toLowerCase()) {
        case "boss": cont = true; break;
        case "fight": cont = false; cap++; fight.fight((int)(Math.random() * 5 + 15)); break;
        case "stats": stats(); cont = false; break;
        default: System.out.println("Incorrect input. "); cont = false;
    }
    }
    System.out.println("You turn a corner, and to your pleasant surprise, there is a small gate next to an oasis.\n " +
            "It appears you have found the end! You rest in the oasis for a while. Then you get up and approach the gate.\n " +
            "But, as you do, a magical being appears. It looks like a beautiful angel, but with a blue tint. \n " +
            "There seems to be several strange tentacle-like appendages hanging off it. It speaks to you.\n " +
            "\'O, noble one. You have no idea what I am protecting here, do you? You mustn't open the gate.\'\n " +
            "It says in a calm and echo-filled voice,\'You don't understand. You cannot fathom what lurks in here.\n " +
            "Do not proceed. Turn back now, mortal!\' You feel as though it is right, but your King's orders are\n " +
            "of much greater importance to you, so you draw your sword. With a look of disapproval, the entity says,\n " +
            "\'So be it. You will learn your lesson the hard way. I will kill you if I have to!\'");
    health = maxHealth;
    mana = maxMana;
    Battle.contin();
    fight.fight(-5);
    System.out.println("As the entity cries in pain and falls to the ground, unable to fight, you put your weapons away.\n " +
            "Then, you approach the gate. Upon opening it up, the entity yells in protest, but it's too late;\n " +
            "the gate is now open. Suddenly, a dark pulse-like beam flies out of the depths behind the gate. You manage to duck.\n " +
            "But then you notice the beam glow. It forms into a demonic figure, black as the night sky.\n " +
            "\'Noooooo! Do you realize what you've done? You just released pure evil! You've doomed humanity!\'\n " +
            "the entity screams. She's right. You can sense the evil of the figure. The figure flies off.\n " +
            "\'No chance to apologize,\' the angelic entity says in a withered voice, \'You must vanquish the figure!\n " +
            "It's your only option. After all, it's your own fault!\' She's right again. You feel guilt. \'Here,\n " +
            "I'll give you what strength I have left. It's all up to you after that...\'");
    health = maxHealth;
    mana = maxMana;
    Battle.contin();
    System.out.println("You exit the maze, and make your way down the mountain. But you never ran into enemies.\n " +
            "You wonder why... at first. But, then you notice the monsters. They've all died out. Dead bodies\n " +
            "of the monsters litter the earth. The reason? Dark monsters roam the ground. They were created by\n " +
            "the dark figure, that's the only possible way. The monsters are huge. But you must kill them.\n " +
            "Then, your eye catches the figure in the center. It's massive. It's... the figure you released accidentally!\n " +
            "It must be commanding those monsters. That's what you have to kill. You're the only one strong enough to stop\n " +
            "it! You must! Although, it wouldn't hurt to kill some other monsters first... Still, you must do something!\n " +
            "So, you pull out your sword, ready to fight! Things are about to get messy...");
    health = maxHealth;
    mana = maxMana;
    Battle.contin();
    progress++;
    save();
    }
    if (progress == 6) {
    cont = false;
    while (cont == false) {
    System.out.println("Will you continue on? Enter \"boss\" to go on and battle the boss, enter \"fight\" to search for another enemy.");
    System.out.println("Additionally, you may enter \"stats\" to view your stats. ");
    System.out.println("Enter a valid selection: ");
    String choose = input.next();
    switch (choose.toLowerCase()) {
        case "boss": cont = true; break;
        case "fight": cont = false; cap++; fight.fight((int)(Math.random() * 5 + 20)); break;
        case "stats": stats(); cont = false; break;
        default: System.out.println("Incorrect input. "); cont = false;
    }
    }
    System.out.println("With haste, you dash towards the center, eyes focused on the demonic ringleader.\n " +
            "You stop only briefly to drink some potions left behind by a dead guard, which revitalizes your body.\n " +
            "When you reach the demon, you yell out a battle cry. The demon turns around, and you can now recognize\n " +
            "a familiar face. No. This can't be. But, as the demon introduces itself, your accusation is confirmed.\n " +
            "\"Art thou the one who set me free?\" It said in a feminine, yet still terrifying, voice, \'Gramercy!\n " +
            "Thank you! Hark, I am Abaddon, Knight of Hell, handpick'd by Lucifer Himself! I reign over all that is destruction,\n " +
            "in the name of the Devil! After mine defeat, mine soul was banish'd to that accurs'd gate, but thou've freed it!\n " +
            "Anon, aside thou wilt stand, and I shall wreak havoc on this pathetic land!...Oh, ye art seeking to slay me? Ha!\n " +
            "As if thither is aught you can do! May fortune favor the foolish.\"She said with a laugh...");
    health = maxHealth;
    mana = maxMana;
    Battle.contin();
    fight.fight(-6);
    System.out.println("Abaddon let out a scream, and fell to the ground in defeat. \"How? HOW? I am an Arch-Demon!\n " +
            "Thou art but a mere mortal human! Fie on it! Wast mine powers not great enough? AAARRRGGG!\"\n " +
            "With a great burst of energy, Abaddon dissipated. Joy seemed to return to your once heavy heart. You are tired,\n " +
            "but you did it. You saved the world from evil. You are a hero. The sky returned to normal, and the conjured shadow beasts\n " +
            "are all gone. They disappeared along with Abaddon. You feel quite weary, and it takes a few moments for you to catch your breath.\n " +
            "Still, you feel a great deal of accomplishment. Finally, brave " + name + ", you feel your work here is done!");
    Battle.contin();
    System.out.println("THE END!");
    Battle.sleep();
    Battle.sleep();
    Battle.sleep();
    System.out.println("WAIT! Hold on...");
    System.out.println("A black light shoots across the sky, causing it to turn dark again. NO! You thought you were done!\n " +
            "\"Fie! Meddling dram pest!\" A familiar voice shouts, \"Thou wast not meant to kill Abaddon! I sent thou to release her!\n " +
            "Thou wast suppos'd to open the gate because I couldn't with mine magic, since 'twas made f'r stopping mine magic!\" You now know.\n " +
            "That voice was coming from the person who sent you on this journey: The King himself. This can't be. You feel betrayed.\n " +
            "You watch in horror as the King appears in front of you. He slowly trasforms into a strange demon-like figure.\n " +
            "Black sillhouette, red glowing eyes, and a menacing set of blood-stained sharp teeth. \"I chose Abaddon to conquer the world,\n " +
            "with mine army of darkness. I was nev'r truely captur'd by the darkness; I was testing to see if thou wast worthy enough to traverse\n " +
            "The Maze. The only reason I want'd thou to kill the dragon f'r me is because I did not want to reveal myself. When I got word of the\n " +
            "dragon's death, I realiz'd thou wast the one I shouldst choose to release abaddon from the maze, so I tested thy mettle with the faux\n " +
            "invasion I set up for thou to save me! But thou hast kill'd her! You... " + name + ". A thousand curses upon you! I wilt destroy\n " +
            "thou f'r fouling up mine plans! For I, the great LUCIFER, will not stand for aught that is different than what I plan!\"\n " +
            "You once again draw your sword. This is truly it. Your fight against the near-invincible Lord of Hell. You must stop Him.\n " +
            "You don't know if you can win, but it's now or never, and you must try! No. Holding. Back...");
    Battle.contin();
    Battle.finalFight = true;
    fight.fight(-7);
    fight.fight(-7);
    Battle.contin();
    System.out.println("A glowing red symbol manifests on the ground beneath the feet of the bleeding and beaten Lucifer.\n " +
             "He is speechless at first, with just an open mouth and shocked eyes alternating between staring at the ground\n " +
             "and gazing at you. After some few precious moments of silence and disbelief, Lucifer lets out a blood-curdling roar.\n " +
             "\"NOOO!\" he shouts, \"Thou... what art thou? Wherefore did the angels above fav'r thou? Beshrew their rules! Why? WHY?!\"\n " +
             "Why must there be a balance? I had this world in mine grasp... only to lose it to a mere... GAAAHHH! How dost a...\n " +
             "What sort of mortal art thou? Ye art strong beyond belief! I envy thou so-\" He stops. The symbol beneath him glows.\n " +
             "As it does so, several hundreds of red-orange arms reach out and start dragging him down into the ground.\n " +
             "\"No... NO! NOOO! I hate thou! I HATE THOU! Fie! This world was mine! I'm so FURIOUS!!!\" But despite his objections,\n " +
             "the hands continue to pull him down to the depths from which he came. After what seemed like an endless struggle,\n " +
             "Lucifer finally vanishes, and the symbol fades away. After a few more moments, the skies begin clearing up.\n " +
             "Everything seems to be returning to normal. Even the grass you stand on seems to grow and flourish. It all feels... right.\n " +
             "As these thoughts left your mind, you are greeted by your guardian angel. Her beautiful voice has a soothing tone,\n " +
             "and she congratulates you. \"I knew you could do it. You have saved the world from a catastrophic tragedy, and all is now well.\n " +
             "Now, come with me. We have a perfect place for you in the afterlife.\" What? Afterlife? What is she talking about?\n " + 
             "\"Oh, you look confused,\" she stated, \"Have you not figured out why you're here? You're here for balancing out the power\n " +
             "that was thrown off by Lucifer. You were the other side. And now thaat Lucifer is gone, you must be gone as well, or the balance\n " +
             "will be off again. It was your destiny to keep the balance, and now you'll be eternally rewarded in the afterlife for fulfilling\n " +
             "it. This is always how it has been. This is always how it will be. Now come. You will become a god up in the afterlife.\"\n " +
             "You are reluctant to, but you know you must. So you nod your head, sheathe your weapon, and take her hand.\n ");
    progress++;
    save();
    Battle.contin();
    System.out.println("Now, " + name + " your journey has come to an end. You are now a god up in the sky, sitting on your thrown, watching\n " +
             "over the land, becoming a legend as time rolls by, content that you saved your planet. You are now part of history.\n " +
             "congratulations, " + name + "!");
    Battle.sleep();
    }
    Battle.contin();
    System.out.println("THE");
    Battle.sleep();
    System.out.println("END");
    
    }

}
