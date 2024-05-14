package DonjonAndDragons.src.views;

import DonjonAndDragons.src.models.Caracters.Caracter;
import DonjonAndDragons.src.models.Caracters.Player.Player;

public class Ascii {
    public static String [] printTitle(){
        String [] str = {
                "________________________________________________________________________________________" ,
                "|                                                                                       |",
                "|                   T~~                                                                 |",
                "|                   |                                               /     \\             |",
                "|                  /\"\\                                             ((     ))            |",
                "|          T~~     |'| T~~              Welcome to             ===  \\\\_v_//  ===        |",
                "|      T~~ |    T~ WWWW|                   Donjon                ====)_^_(====          |",
                "|      |  /\"\\   |  |  |/\\T~~                 &                   ===/ o o \\===          |",
                "|     /\"\\ WWW  /\"\\ |' |WW|                  Dragons              = | /_ _\\ | =          |",
                "|    WWWWW/\\| /   \\|'/\\|/\"\\                                     =   \\/_ _\\/   =         |",
                "|    |   /__\\/]WWW[\\/__\\WWWW                                         \\_ _/              |",
                "|    |\"  WWWW'|I_I|'WWWW'  |                                         (o_o)              |",
                "|    |   |' |/  -  \\|' |'  |                                          VwV               |",
                "|    |'  |  |LI=H=LI|' |   |                                                            |",
                "|    |   |' | |[_]| |  |'  |                                                            |",
                "|    |   |  |_|###|_|  |   |                                                            |",
                "|    '---'--'-/___\\-'--'---'                                                            |",
                "|_______________________________________________________________________________________|"
        };
        return str;
    }
    public static String [] NegateLetter (){
        String [] str = {
                "____________________________________________________________________________________" ,
                "|         /\\                                                             /\\         |",
                "| _       )( ____________________                   ____________________ )(       _ |",
                "|(_)/////(**)____________________> DEAR ADVENTURER <____________________(**)\\\\\\\\\\(_)|" ,
                "|         )(                                                             )(         |",
                "|         \\/                                                             \\/         |",
                "|                                                                                   |" ,
                "|   We hope this letter finds you well. We write to inform you of our understanding |",
                "| regarding your decision to decline the recent adventure proposal.                 |",
                "|                                                                                   |" ,
                "|   While we understand and respect your decision, we would like to express our     |",
                "| disappointment as well. The spirit of adventure is the lifeblood of our union,    |",
                "| and your absence will be keenly felt on our upcoming expedition.                  |",
                "|                                                                                   |" ,
                "|   Nevertheless, we recognize the importance of every member's contribution,       |",
                "| regardless of the form it takes. As such, enclosed you will find details          |",
                "| regarding the paperwork fee you are entitled to receive for your valuable         |",
                "| services. Rest assured, your dedication to the union's cause is duly noted and    |",
                "| appreciated.                                                                      |",
                "|                                                                                   |",
                "|   We remain hopeful that future opportunities will align more closely with your   |",
                "| interests and availability. Until then, we wish you the best in your endeavors.   |",
                "|                                                                                   |" ,
                "|   Sincerely,                                                                      |" ,
                "|                                                                                   |" ,
                "|       The Union of Adventurers and Wonder Enthusiasts                             |" ,
                "|___________________________________________________________________________________|"
        };
        return str;        
    }
    public static String [] caracterSprite (Caracter caracter){
        switch (caracter.getCaracterClass()){
            case "Dragon":
                return dragonSprite();
            default:
                return playerSprite(caracter);
        }
    }
    public static String [] playerSprite(Caracter caracter) {
        String clas = caracter.getCaracterClass();
        switch (clas){
            case "Warrior" :
                return warriorSprite();
            case "Wizard" :
                return wizardSprite();
            default :
                return defaultSprite();
        }
    }
    public static String [] caracterSpriteAndStats(Caracter caracter) {
        String[] sprite = caracterSprite(caracter);
        String[] statsView = caracterStats(caracter);
        for (int i = 0 ; i < sprite.length; i++){
            if (i<statsView.length){
                sprite[i]+= statsView[i] + "";
            } else {
                sprite[i] += "";
            }
        }
        return sprite;
    }
    public static String [] dragonEncounter(){
        String [] str = {
                    "___________________________________________________________________________________________",
                    "|                                                                                          |",
                    "|                                                             /===-_---~~~~~~~~~------____ |",
                    "|                                                |===-~___                _,-'             |",
                    "|                 -==\\\\                         `//~\\\\   ~~~~`---.___.-~~                  |",
                    "|             ______-==|                         | |  \\\\           _-~`                    |",
                    "|       __--~~~  ,-/-==\\\\                        | |   `\\        ,'                        |",
                    "|    _-~       /'    |  \\\\                      / /      \\      /                          |",
                    "|  .'        /       |   \\\\                   /' /        \\   /'                           |",
                    "| /  ____  /         |    \\`\\.__/-~~ ~ \\ _ _/'  /          \\/'                             |",
                    "|/-'~    ~~~~~---__  |     ~-/~         ( )   /'        _--~`                              |",
                    "|                  \\_|      /        _)   ;  ),   __--~~                                   |",
                    "|                    '~~--_/      _-~/-  / \\   '-~ \\                                       |",
                    "|                   {\\__--_/}    / \\\\_>- )<__\\      \\                                      |",
                    "|                   /'   (_/  _-~  | |__>--<__|      |                                     |",
                    "|                  |0  0 _/) )-~     | |__>--<__|      |                                   |",
                    "|                  / /~ ,_/       / /__>---<__/      |                                     |",
                    "|                 o o _//        /-~_>---<__-~      /                                      |",
                    "|                 (^(~          /~_>---<__-      _-~                                       |",
                    "|                ,/|           /__>--<__/     _-~                                          |",
                    "|             ,//('(          |__>--<__|     /                  .----_                     |",
                    "|            ( ( '))          |__>--<__|    |                 /' _---_~\\                   |",
                    "|         `-)) )) (           |__>--<__|    |               /'  /     ~\\`\\                 |",
                    "|        ,/,'//( (             \\__>--<__\\    \\            /'  //        ||                 |",
                    "|      ,( ( ((, ))              ~-__>--<_~-_  ~--____---~' _/'/        /'                  |",
                    "|    `~/  )` ) ,/|                 ~-_~>--<_/-__       __-~ _/                             |",
                    "|  ._-~//( )/ )) `                    ~~-'_/_/ /~~~~~~~__--~                               |",
                    "|   ;'( ')/ ,)(                              ~~~~~~~~~~                                    |",
                    "|  ' ') '( (/                                                                              |",
                    "|    '   '  `                                                                              |",
                    "|__________________________________________________________________________________________|"
        };
        return str;
    }
    public static String [] dragonSprite(){
        String [] str = {
            "➖➖➖➖➖➖➖🟫➖➖➖➖➖🟫➖➖➖➖➖➖",
            "➖➖➖➖➖➖➖🟫🟨➖➖➖➖🟫➖➖➖➖➖➖",
            "➖➖➖➖➖➖🟨🟫🟨➖🟨➖➖🟫➖➖➖➖➖➖",
            "➖➖➖➖➖➖🟨🟨🟨🟨🟨🟨🟫🟫➖➖➖➖➖➖",
            "➖➖➖➖➖➖🟨🟨🟨🟨🟨🟨🟫➖➖➖➖➖➖➖",
            "➖➖➖➖➖🟪🟪🟨🟪🟪🟨🟪🟪➖➖➖➖➖➖➖",
            "➖➖➖➖➖🟪🟪🟪🟪🟪🟪🟪🟪➖➖➖➖➖➖➖",
            "➖➖➖➖➖⬛🟪🟪🟪⬛🟪🟪🟪➖➖➖➖➖➖➖",
            "➖➖➖➖🟪🟪🟪🟪🟪🟪🟪🟪🟪➖➖➖➖➖➖➖",
            "➖➖➖➖🟪🟪🟪🟪🟪🟪🟪🟪🟪➖➖➖➖➖➖➖",
            "🟧🟧🟧🟧🟪🟪🟪🟪🟪🟪🟪🟪➖➖➖🟧🟧🟧🟧🟧",
            "➖🟪🟪🟧🟫➖🟪🟨🟨🟪🟪➖➖➖🟫🟥🟪🟪🟪➖",
            "➖➖🟪🟧🟫➖➖🟧🟧🟪➖➖➖🟫🟥🟪🟪➖➖➖",
            "➖➖➖🟪🟪🟫➖🟨🟨🟪➖🟫🟫🟥🟥🟪➖➖➖➖",
            "➖➖➖➖➖🟫🟧🟧🟪🟪🟪🟫🟫➖➖➖➖➖➖➖",
            "➖➖➖➖➖➖🟨🟨🟨🟪🟪🟪🟪🟪➖➖➖➖➖➖",
            "➖➖➖➖➖🟪🟧🟧🟧🟧🟪🟪🟪🟪🟪➖➖➖➖➖",
            "➖➖➖➖➖🟪🟨🟨🟨🟨🟪🟪🟪🟪🟪🟧🟧➖➖➖",
            "➖➖➖➖➖🟪🟪🟧🟧🟧🟧🟪🟪🟪🟪🟪🟪➖➖➖",
            "➖➖➖➖➖🟪🟪➖➖🟪🟪🟪🟪🟪🟪➖➖🟪➖➖",
            "➖➖➖➖➖🟪➖➖➖➖🟪🟪➖➖🟪➖➖➖➖➖",
            "➖➖➖➖➖🟪➖➖➖➖➖🟪➖➖➖➖➖➖➖➖",
        };
        return str;
    }
    public static String [] youDied () {
        String [] str = {
            "___________________________________________________________________________________________",
            "|                                                                                          |",
            "|                                        /   \\                                             |",
            "|                                )      ((   ))     (                                      |",
            "|      (@)                      /|\\      ))_((     /|\\                                     |",
            "|      |-|                     / | \\    (/\\|/\\)   / | \\                      (@)           |",
            "|      | | ------------------------voV---\\`|'/--Vov--------------------------|-|           |",
            "|      |-|                         '^`   (o o)  '^`                          | |           |",
            "|      | |                               `\\Y/'                               |-|           |",
            "|      |-|               __   __                _ _          _               | |           |",
            "|      | |               \\ \\ / /__  _   _    __| (_) ___  __| |              |-|           |",
            "|      |-|                \\ V / _ \\| | | |  / _` | |/ _ \\/ _` |              | |           |",
            "|      | |                 | | (_) | |_| | | (_| | |  __/ (_| |              |-|           |",
            "|      |-|                 |_|\\___/ \\__,_|  \\__,_|_|\\___|\\__,_|              | |           |",
            "|      | |                                                                   |-|           |",
            "|      |-|___________________________________________________________________| |           |",
            "|      (@)              l   /\\ /         ( (       \\ /\\   l                `\\|-|           |",
            "|                       l /   V           \\ \\       V   \\ l                  (@)           |",
            "|                       l/                _) )_          \\I                                |",
            "|                                         `\\ /'                                            |",
            "|                                           V                                              |",
            "|__________________________________________________________________________________________|"
        };
        return str;
    }
    public static String [] wizardSprite(){
        String [] str = {
            "➖➖➖➖🟦🟦🟦🟦➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖",
            "➖➖➖🟥➖➖🟦🟨🟦🟦➖➖➖➖➖➖➖➖➖➖➖➖➖",
            "➖➖➖➖➖➖➖🟦🟦🟦🟦🟨🟦➖➖➖➖➖➖➖➖➖➖",
            "➖➖➖➖➖➖➖🟦🟨🟦🟦🟦🟦🟨🟦➖➖➖➖➖➖➖➖",
            "➖➖➖➖➖➖🟨🟦🟦🟦🟨🟦🟦🟦🟦🟨➖➖➖➖➖➖➖",
            "➖➖➖➖➖🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦➖➖➖➖➖➖",
            "➖➖➖🟦🟦🟦🟦🟫🟫🟫🟫🟫🟫🟫🟫🟦🟦🟦➖➖➖➖➖",
            "➖➖➖🟦🟦🟫🟫🟫🟫🟧🟧🟫🟫🟧🟧🟫🟫🟦🟦➖➖➖➖",
            "➖➖➖➖➖🟫🟫🟫🟫🟦🟫🟫🟫🟫🟦🟫🟫➖➖➖➖➖➖",
            "➖➖➖➖➖🟫🟫🟫🟫🟧🟧🟧🟧🟧🟧🟫🟫➖➖➖➖➖➖",
            "➖➖➖➖➖🟫🟫🟫🟫🟧🟧🟫🟫🟧🟧🟫🟫➖➖➖➖➖➖",
            "➖➖➖➖➖➖🟫🟫🟫🟧🟧🟧🟧🟧🟧🟫➖➖➖➖➖➖➖",
            "➖➖➖➖➖➖🟦🟦🟦🟧🟧🟧🟧🟧🟧🟦➖➖🟨➖➖➖➖",
            "➖➖➖➖➖➖🟫🟦🟦🟦🟧🟧🟧🟧🟦🟫➖🟨🟥🟨➖➖➖",
            "➖➖➖➖➖➖➖🟦🟦🟦🟧🟧🟧🟧🟦➖➖➖🟨➖➖➖➖",
            "➖➖➖➖➖➖➖🟦🟦🟦🟦🟧🟧🟦🟦➖➖➖➖➖➖➖➖",
            "➖➖➖➖➖➖➖🟦⬜⬜⬜⬜🟦🟦🟦➖➖➖➖🟨➖➖➖",
            "➖➖➖➖➖➖⬛⬜⬜⬜⬜⬜⬜⬜🟦⬛➖➖🟨🟥🟨➖➖",
            "➖➖➖➖➖⬛🟥⬜⬜⬜⬜⬜⬜⬜⬜⬛➖➖➖🟨➖➖➖",
            "➖➖➖➖⬛🟥🟥⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛➖➖➖➖➖➖",
            "➖➖➖⬛🟥🟥🟨🟨⬜⬜⬜⬜⬜⬜⬜⬛➖➖➖➖➖➖➖",
            "➖➖⬛🟥🟥🟨🟨🟨🟦⬜⬜⬛⬜⬜⬛➖➖➖➖➖➖➖➖",
            "➖⬛🟥🟥🟨🟨🟨🟦🟦⬛⬛➖⬛⬛➖➖➖➖➖➖➖➖➖",
            "⬛🟥🟥🟨🟨🟨🟦🟦⬛➖➖➖➖➖➖➖➖➖➖➖➖➖➖",
        };
        return str;
    }
    public static String [] warriorSprite(){
        String [] str = {
            "➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖",
            "➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖",
            "➖➖➖➖➖➖➖➖➖⬛⬛⬛⬛⬛⬛⬛⬛⬛➖➖➖➖➖",
            "➖➖➖➖➖➖➖➖⬛⬛🟦🟦⬛🟦⬛🟦🟦⬛⬛➖➖➖➖",
            "➖➖➖➖➖➖➖⬛⬛⬛🟦🟦⬛🟦⬛🟦🟦⬛⬛⬛➖➖➖",
            "➖➖➖➖➖➖➖⬛⬛🟦🟦🟦⬛🟦⬛🟦🟦🟦⬛⬛➖➖➖",
            "➖➖➖➖➖➖➖⬛⬛🟦🟦🟦⬛🟦⬛🟦🟦🟦⬛⬛➖➖➖",
            "➖➖➖➖➖➖➖⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛➖➖➖",
            "➖➖➖➖➖➖➖⬛⬛⬛🟧🟧⬛⬛🟧🟧⬛⬛⬛⬛➖➖➖",
            "🟥🟥⬜➖➖➖➖⬛⬛⬛🟦⬜⬛⬛🟦⬜⬛⬛⬛⬛➖➖➖",
            "🟥⬜⬜⬜➖➖➖➖⬛🟧🟧🟧⬛⬛🟧🟧🟧🟧⬛➖➖➖➖",
            "🟥⬜🟦⬜⬜➖➖⬛⬛🟧🟧⬛🟥🟥⬛🟧🟧🟧⬛⬛⬛➖➖",
            "➖🟥⬜🟦⬜⬜⬛🟦⬛⬛⬛🟧🟧🟧🟧🟧⬛⬛⬛⬛🟦⬛➖",
            "➖➖🟥⬜🟦⬜⬜⬛⬛⬛🟦⬛⬛⬛⬛⬛🟦⬛⬛⬛⬛⬛➖",
            "➖➖➖🟥⬜🟦⬜⬜⬛⬛⬛🟦⬜⬜⬜🟦⬛⬛⬜⬜⬜⬛⬛",
            "➖➖➖➖🟥⬜🟦⬜🟫⬛⬛🟦⬜⬜⬜🟦⬛⬜⬜⬜⬜⬜⬛",
            "➖🟥➖➖➖⬜⬜🟫⬛⬛⬛🟦⬜⬜⬜🟦⬛⬜⬜⬜⬜⬜⬛",
            "➖🟥➖➖➖➖🟫⬛🟥⬛⬛🟦⬜⬜⬜🟦⬛⬛⬜⬜⬜⬛⬛",
            "➖➖➖➖➖➖➖⬛⬛⬛⬛🟦⬛⬛⬛🟦⬛⬛⬜⬜⬜⬛➖",
            "➖➖➖➖🟥➖➖➖➖⬛🟦🟦⬜⬜⬜🟦🟦⬛⬛⬜⬛➖➖",
            "➖➖➖➖🟥➖➖➖➖➖⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛➖➖",
            "➖➖➖➖➖➖➖➖➖➖⬛⬛⬛➖➖⬛⬛⬛➖➖➖➖➖",
            "➖➖➖➖➖➖➖➖➖➖⬛⬛⬛➖➖⬛⬛⬛➖➖➖➖➖",
            "🟥🟥➖➖➖➖🟥🟥➖⬛⬛⬛⬛➖⬛⬛⬛⬛➖➖➖➖➖",
            "➖➖➖🟥🟥➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖"
        };
        return str;
    }
    public static String [] doorStep(){
        String [] str = {
"  ░▓▒░░░░██░░░░█░░░░░▒█▓░░░░▒██▓█░░░░░█▒██████████░░░░░░░░░█▓██▓░▓█░▒█░░░░█▒░░▓█░██░░█░",
"  ░█░░░░█▒░█░░█░░░░███░░█▒░▓███░░░░▓████░░░▒░▒░▒░░███▓░░░░░░░░░░░░░▒█░███░░░░░░█░░▓█░▒█",
"  █░░░░█░░░░░███▓░░█░░░░░████░░░░▓██▒░░░▒░░░░░░░▒░░░▓██▓░░░░░░░░░░░░▒░░██░░░░░░▓█▓░██░█",
"  █████▒█████▒░░▒█▒▓░░░░░█░▒░░░░██▒░░▒▒░████████░▒░▒░░██░▒░░░░░░░░░░▒█░░█▓░░░▒████░░█▒░",
"  ░░░▒██░█░██░█░░▒█░░░░██░█░░░███░░█░▓████░█░░░░██░▒░░░░██▓░░░░░░░░░░░█▒░█▓██░░░░▓▓░░█▒",
"  ░░█░░████░░░███░░██░▓█▒█░░███░░░░░██░░░█░████░░░██▒░░░░██▒░░░░░░░░░░▓██░█░░░▒▒░░██░░█",
"  ████▓░░░▓▒██▒▓█░░░░██░█░░███░░▒░███░░██▓▒██░███░░░█▓▒░░░██▒░░░░░░░░░░░█▒▓█░░░░░░▒█░░█",
"  █▓░░█████░░░███░░░░█░▓░░███░▒░███░░█▓▓░░█░░█░░█▓█░██▒▒░░░██░░░░░░░░░░░▓░░██░▒███▒░█░░",
"  █████░█▒▓████░░░░▒█▓▒█▒███░░▒░█▓░░█▒▒░░░█░░█░░█▒░█░██░░░░░██░░░░░░░░░░██░███░░░░░░░█░",
"  ░▓█░▒░█░▒░░▒███░░██░█░███▒▒▒░██░▓███░░░░█░░█░░░░▓██░██▒▒░░░█▓░░░░░░░░░█░░█▓█░░░░░░██░",
"  ▒██▒░░█▒▒▓░█░░▒░██▒▒▓███░░▒▒██░░▓█▓░░░░░█░░█░░░░▒▓██░███▒▒▒█▓░░░░░░░░░█▒▒█░█░░░░░░░█▒",
"  █▒▓█░░░░░░█▓░░░░██░░███▒░░░██░░▓██░░░░░░█░░█░░░░░░██░██░█░░░█▒░░░░███████████░████▓██",
"  ▓▒█▓░███████░░▒░██▒████░░░███░▓█░▒░░▒░░░█░░█░░░▒░░░██░███░░▒█░░▓█▒███░░░░░░░██░░░░░░█",
"  ▓░░█████▓█▒░▒▒░██░▒░███░░░██░░█░░░▒░░░░░█░░█░░░░░░░██░██░░░▒█░░█░█▓░░░░░░░░░░█░░░░░░░",
"  ████░▓██░░░▓░▒░█▒░▓░███░▒░██░░█░░░░░░░░░█░░█░░░░░░▒░█░██░█░░█░░█░█▓▒▒▒░░░░░░▒█░▒░░░░░",
"  █░█░░▒▓█░████░██▒▓█████░▒░██░░█▒░░░░░▒░░█░░█░░░░░░░░█░██▓░▓█░▓░█░▓█▒░░▓████▓▓█▓▒█████",
"  ▒▓░░░░░░░░░██▓░░░░█████░░█░██░▓▒░░░░░▒░░█░░█░▒░░░░░░█░███░░█░▒░█░▓█░█▓█▓▓▓▒▓████░░░░▒",
"  ░█░███▒░▓█░▒██░█▓░█████░░█░██░▓▒░░░░░░▒░█░░█░░░░░░░░█░███░░█░░░█░░▓█░░░░░▒█░░░▓█░░░░░",
"  ░█░░░░▒▓░░░██░░░▒█▓▓███░░█░██░█▒░░░▒░████████▓░░░▒░░█░███░░█░░░█░░██░░░░░░▓░░░▓█░░░░░",
"  ░█░▒░░░░░█░██░░░░░█▓███░░█░██░▓▒░░░░░░░░█░░█░░░░░░░░▓░░███▒▓▓░░░█░░▒█░░░▒▓███████████",
"  ▓█▒██████▓▓██░░▒▓▓█████░░█░██░▓▒░░▒░░░░░█░░█░░░░░░░░▓░███░░█░░░█░░█████░░░░░░░░█░░░░░",
"  ░█░░░░▓░░░░█▓░░▒░█▒░███▒░█░██▒▓▓▒░░░░░░░█░░█░░░▒░░░░▓░███░░▓░▓░█░▓█░█▒█░░░░░▒░░█▓░░░▒",
"  ▒█░░░░█░░░░█████▒▒█▓███░░█░██░▒█░░░░▒░░░█░░█░░░░░░░░▓░███░░█░▒░▓░░█░█░▒░░░▒▒▒▒░██░░░░",
"  ░█░░░░█░░░░█▓░░░░░░░███░░█░██░▓█░░░░░░░░█░░█░░░░▒░░░▓░░██░░█░▓░█░░███████▒▒▒▒▒▓██████",
"  █░░░░░█▒▓░░█▓░░█▓░░▓███░░█░██░▒█░░▒░░░░░█░░█░░░░░░░░█░░█░░░▓▒░█░░░░░░░░░░▒░░░░██░░░░░",
"  ██░░░░█▓░░██░▒░░░▒█▓███░░█░██▒▒████▓▒███▒▓▒▓▓█▒▓▓█▒▓█░░██░▒▓░░▒░▓░█░░▒██████████▒░░█░",
"  ▒█░▒░░░░▓░░█░▓▓▓▓▒▒▒███░░█▓█████░░▒▒▓▓▓█░▒█░▒░░█▓▒█░█░░██████████▒█▒░▒░░░░░░░░▓▒░░░█░",
"  ██░░▒██▓░███▒▒░░░░░░░░░█░░░░░░░░░░▒░░░░▒░░░░▒▒░░░▒░▒░░░░░░▓▓▓░░░░░▒▓██▒░░▓░▒░░██▒▒▓██",
"  ░████▓░░░░░█░░░▓▒▒██░░██████████████████████████████████████▒██▓▒▒░░▒██▓░▒▒▓▒▓█▓░░░░░",
"  ▓█░░░░░░░░▒█░░░░░░░░▓░█▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒█▒░▓▓░░░░░░░█▒░░░░░░█░▒░▓█",
        };
        return str;
    }
    public static String [] skeletonSprite(){
                String [] str = {
                    "___________________________________________________________________________________________",
                    "|                 .7                                                                       |",
                    "|               .'/                                                                        |",
                    "|              / /                                                                         |",
                    "|             / /                                                                          |",
                    "|            / /                                                                           |",
                    "|           / /                                                                            |",
                    "|          / /                                                                             |",
                    "|         / /                                                                              |",
                    "|        / /                                                                               |",
                    "|       / /                                                                                |",
                    "|     __|/                                                                                 |",
                    "|   ,-\\__\\                                                                                 |",
                    "|   |f-#Y\\|                                                                                |",
                    "|   \\()7L/                                                                                 |",
                    "|    cgD                           __ _                                                    |",
                    "|    |\\(                          .'  Y '>,                                                |",
                    "|     \\ \\                         / _   _   \\                                              |",
                    "|      \\\\\\                        )(_) (_)(|}                                              |",
                    "|       \\\\\\                       {  4A   } /                                              |",
                    "|        \\\\\\                       \\uLuJJ/\\l                                               |",
                    "|         \\\\\\                      |3    p)/                                               |",
                    "|          \\\\\\___ __________       /nnm_n//                                                |",
                    "|          c7___-__,__-)\\,__)(#.  \\_>-<_/D                                                 |",
                    "|                           \\_#-._.__G G_c__.-__<#/ ( \\                                    |",
                    "|                            <#-._>__-,G_.___)\\    \\7\\                                     |",
                    "|                           (#-.__.| \\#<.__.-# )    \\ \\                                    |",
                    "|                           |#-.__#\\  |#-.__.-#.\\    \\ \\                                   |",
                    "|                           (#-.__##. \\#-.__.-#.|     \\_\\                                  |",
                    "|                           \\#-.__##|!|#-.__.-#.)      \\ \\                                 |",
                    "|                            #-.__##\\_|#-.__.-#./       \\ l                                |",
                    "|                             #.__###>G>-.__.-#>       .--,_                               |",
                    "|__________________________________________________________________________________________|"
                };
                return str;
    }
    public static String [] defaultSprite(){
        String [] str = {
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
           "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛",
        };
        return str;
    };
    public static String [] caracterStats(Caracter caracter) {
        String[] statsView= {
                "  ______________________________________________________________" , //0
                "  |                                                " ,
                "  |                                                " ,
                "  |                                                " ,
                "  |                                                " ,
                "  |                                                " ,// 5
                "  |                                                " ,
                "  |                                                " ,
                "  |                                                " ,//8
                "  |                                                " ,  
                "  |                                                " ,//10
                "  |                                                " ,
                "  |                                                " ,
                "  |                                                " ,//13
                "  |                                                " ,
                "  |                                                " ,//15
                "  |                                                " ,//16
                "  |                                                " ,
                "  |                                                " ,
                "  |                                                " ,//19
                "  |                                                " ,// 20
                "  |                                                " ,
                "  |                                                " ,
                "  |                                                " ,
                "  |____________________________________________________________" ,//23
        };
           
        statsView[3]= "  |   Name: " + caracter.getFullName();
        statsView[5]= "  |   Life Points: " + caracter.getStats().getLifePoints() ;
        statsView[7]= "  |   Armor: " + caracter.getStats().getArmor() + "   Damage: "+ caracter.getStats().getDamage();
        statsView[8]= statsView[12];
        statsView[9]= "  |   Experience to next level: " + (10 - caracter.getStats().getExperience()) + "   Level: "+ caracter.getLevel();
        statsView[11]= "  |   Position: " + caracter.getPosition() ;
        statsView[13]= "  |   Equipement : " ;
        if (caracter.getEquipment()[0] != null) {
            statsView[14]= "  |      (1) " + caracter.getEquipment()[0].mipple + " " + caracter.getEquipment()[0].toString();
        } else {
            statsView[14]= "  |      (1) " + "📦" + " Empty";
        }
        if (caracter.getEquipment()[1] != null) {
            statsView[15]= "         (2) " + caracter.getEquipment()[1].mipple + " " + caracter.getEquipment()[1].toString();
        } else {
            statsView[15]= "         (2) " + "📦" + " Empty";
        }
        statsView[16]= "  |   Class: " + caracter.getCaracterClass() ;
        statsView[18]= "  |    Inventory : ";
        int index=0;
        for (int i = 0; i < caracter.getInventory().length-1; i=i+2) {
                if (caracter.getInventory()[i] == null) {
                    statsView[19  + index]= "  |      (" + (i + 1) + ") " + "📦" + " Empty";
                } else {
                    statsView[19  + index]= "  |      (" + (i + 1) + ") " + caracter.getInventory()[i].mipple + " " + caracter.getInventory()[i].getName();
                }
                if (caracter.getInventory()[i+1] == null) {
                    statsView[19  + index]+= "       (" + (i + 2) + ") " + "📦" + " Empty";
                } else {
                    statsView[19  + index]+= "       (" + (i + 2) + ") " + caracter.getInventory()[i+1].mipple + " " + caracter.getInventory()[i+1].getName();
                }
                index++;
        }

        return statsView;
    }
    public static String[] gameOver() {
                String [] str = {
            "___________________________________________________________________________________________",
            "|                                                                                          |",
            "|                                        /   \\                                             |",
            "|                                )      ((   ))     (                                      |",
            "|      (@)                      /|\\      ))_((     /|\\                                     |",
            "|      |-|                     / | \\    (/\\|/\\)   / | \\                      (@)           |",
            "|      | | ------------------------voV---\\`|'/--Vov--------------------------|-|           |",
            "|      |-|                         '^`   (o o)  '^`                          | |           |",
            "|      | |                               `\\Y/'                               |-|           |",
            "|      |-|           ____    _    __  __ _____    _____     _______ ____     | |           |",
            "|      | |          / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\    |-|           |",
            "|      |-|         | |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |   | |           |",
            "|      | |         | |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ <    |-|           |",
            "|      |-|          \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\   | |           |",
            "|      | |                                                                   |-|           |",
            "|      |-|___________________________________________________________________| |           |",
            "|      (@)              l   /\\ /         ( (       \\ /\\   l                `\\|-|           |",
            "|                       l /   V           \\ \\       V   \\ l                  (@)           |",
            "|                       l/                _) )_          \\I                                |",
            "|                                         `\\ /'                                            |",
            "|                                           V                                              |",
            "|__________________________________________________________________________________________|"
        };
        return str;
    }
    public static String[] fight() {
        String [] str = {
            "|         /\\                                                             /\\         |",
                "| _       )( ____________________                   ____________________ )(       _ |",
                "|(_)/////(**)____________________>       FIGHT     <____________________(**)\\\\\\\\\\(_)|" ,
                "|         )(                                                             )(         |",
                "|         \\/                                                             \\/         |"
        };
        return str;
    }
}