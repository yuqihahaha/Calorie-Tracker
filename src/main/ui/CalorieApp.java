package ui;

import model.Food;
import model.Wishlist;

import java.util.Scanner;

// Calorie Tracker application
public class CalorieApp {
    private Scanner input;
    private Wishlist wishlist;
    private Food poutine;
    private Food tourtiere;
    private Food cheesePizza;
    private Food pepperoniPizza;
    private Food pastaWithMarinara;
    private Food maPoTofu;
    private Food kungPaoChicken;
    private Food sweetSourPork;
    private Food charSiu;
    private Food firedRice;
    private Food tteokbokki;
    private Food bibimbap;
    private Food bulgogi;
    private Food bibimNaengmyeon;
    private Food hangoverStew;


    // EFFECTS: instantiate foods for each country, sets the calorie goal for user,
    //          and runs the calorie tracker application
    public CalorieApp() {
        wishlist = new Wishlist();
        input = new Scanner(System.in);
        input.useDelimiter("\n");

        setGoal();
        runCalorie();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runCalorie() {
        boolean keepRunning = true;
        String command = null;

        init();

        while (keepRunning) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("e")) {
                keepRunning = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nSee you next time!");
    }


    // MODIFIES: this
    // EFFECT: lets user set personal calorie goal
    private void setGoal() {
        System.out.println("Set your goal");
        int goal = input.nextInt();

        System.out.println("Your goal is: " + goal + " calories");

    }

    // REQUIRES: command must be "chn", "kor", "cad", or "wish"
    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("chn")) {
            displayChinaMenu();
            browseChina();
        } else if (command.equals("kor")) {
            displayKoreaMenu();
            browseKorea();
        } else if (command.equals("cad")) {
            displayCanadaMenu();
            browseCanada();
        } else if (command.equals("wish")) {
            displayWishlist();
            editWishlist();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initialize foods
    private void init() {
        // Canadian foods
        poutine = new Food("poutine", "Canada", 233);
        pepperoniPizza = new Food("pepperoni pizza", "Canada", 276);
        cheesePizza = new Food("cheese pizza", "Canada", 276);
        pastaWithMarinara = new Food("pasta with marinara sauce", "Canada", 109);

        // Chinese foods
        maPoTofu = new Food("ma po tofu", "China", 119);
        kungPaoChicken = new Food("kung pao chicken", "China", 129);
        charSiu = new Food("char siu", "China", 238);
        firedRice = new Food("fired rice", "China", 163);

        // Korean foods
        tteokbokki = new Food("tteokbokki", "Korea", 230);
        bibimbap = new Food("bibimbap", "Korea", 79);
        bibimNaengmyeon = new Food("bibim naengmyeon", "Korea", 223);
        hangoverStew = new Food("hangover stew", "Korea", 64);

    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nWELCOME!");
        System.out.println("\nChoose your country:");
        System.out.println("\tcad -> Canada");
        System.out.println("\tchn -> China");
        System.out.println("\tkor -> Korea");
        System.out.println("\t-----------------------------------");
        System.out.println("\twish -> Wishlist");
        System.out.println("\te -> Exit");
    }

    // EFFECTS: displays menu of options in wishlist tab to user
    private void displayWishlist() {
        System.out.println("\nYOUR WISHLIST");
        System.out.println("\tcalc -> Calculate daily total calories");
        System.out.println("\tview -> View wishlist");
        System.out.println("\tedit -> Edit wishlist");
        System.out.println("\tclear -> Clear wishlist");
    }

    // EFFECTS: displays menu of canadian foods available to user
    private void displayCanadaMenu() {
        System.out.println("\nCanadian Foods");
        System.out.println("\nAdd foods you want to wishlist:");
        System.out.println("\tP -> poutine");
        System.out.println("\tPP -> pepperoni pizza");
        System.out.println("\tCP -> cheese pizza");
        System.out.println("\tPAS -> pasta with marinara");
        System.out.println("\n -------------------------");
        System.out.println("\twish -> Wishlist");
    }

    // EFFECTS: displays menu of chinese foods available to user
    private void displayChinaMenu() {
        System.out.println("\nChinese Foods");
        System.out.println("\nAdd foods you want to wishlist:");
        System.out.println("\tMPT -> ma po tofu");
        System.out.println("\tKPC -> kung pao chicken");
        System.out.println("\tCS -> char siu");
        System.out.println("\tFR -> fried rice");
        System.out.println("\n -------------------------");
        System.out.println("\twish -> Wishlist");
    }

    // EFFECTS: displays menu of korean foods available to user
    private void displayKoreaMenu() {
        System.out.println("\nKorean Foods");
        System.out.println("\nAdd foods you want to wishlist:");
        System.out.println("\tT -> tteokbokki");
        System.out.println("\tBI -> bibimbap");
        System.out.println("\tBN -> bibim naengmyeon");
        System.out.println("\tHS -> hangover stew");
        System.out.println("\n -------------------------");
        System.out.println("\twish -> Wishlist");
    }

    // REQUIRES: selectCad must equals one of "P", "PP", "CP", "PAS" or "WISH"
    // MODIFIES: this
    // EFFECTS: allows user to browse canadian foods and adds them into the wishlist
    public void browseCanada() {
        String selectCad = null;
        selectCad =  input.next();
        selectCad = selectCad.toUpperCase();

        if (selectCad.equals("P")) {
            wishlist.addFoodToWishlist(poutine);
            System.out.println("Poutine has been successfully added to your wishlist");
        } else if (selectCad.equals("PP")) {
            wishlist.addFoodToWishlist(pepperoniPizza);
            System.out.println("Pepperoni Pizza has been successfully added to your wishlist");
        } else if (selectCad.equals("CP")) {
            wishlist.addFoodToWishlist(cheesePizza);
            System.out.println("Cheese Pizza has been successfully added to your wishlist");
        } else if (selectCad.equals("PAS")) {
            wishlist.addFoodToWishlist(pastaWithMarinara);
            System.out.println("Pasta with marinara has been successfully added to your wishlist");
        } else {
            displayWishlist();
            editWishlist();
        }
        runCalorie();
    }

    // REQUIRES: selectChn must equals one of "MPT", "KPC", "CS", "FR" or "WISH"
    // MODIFIES: this
    // EFFECTS: allows user to browse chinese foods and adds them into the wishlist
    private void browseChina() {
        String selectChn = null;
        selectChn =  input.next();
        selectChn = selectChn.toUpperCase();

        if (selectChn.equals("MPT")) {
            wishlist.addFoodToWishlist(maPoTofu);
            System.out.println("Ma po tofu has been successfully added to your wishlist");
        } else if (selectChn.equals("KPC")) {
            wishlist.addFoodToWishlist(kungPaoChicken);
            System.out.println("Kung pao chicken has been successfully added to your wishlist");
        } else if (selectChn.equals("CS")) {
            wishlist.addFoodToWishlist(charSiu);
            System.out.println("Char siu has been successfully added to your wishlist");
        } else if (selectChn.equals("FR")) {
            wishlist.addFoodToWishlist(firedRice);
            System.out.println("Fried rice has been successfully added to your wishlist");
        } else {
            displayWishlist();
            editWishlist();
        }
        runCalorie();
    }


    // REQUIRES: selectKor must equals one of "T", "BI", "BN", "HS" or "WISH"
    // MODIFIES: this
    // EFFECTS: allows user to browse korean foods and adds them into the wishlist
    private void browseKorea() {
        String selectKor = null;
        selectKor =  input.next();
        selectKor = selectKor.toUpperCase();

        if (selectKor.equals("T")) {
            wishlist.addFoodToWishlist(tteokbokki);
            System.out.println("Tteokbokki has been successfully added to your wishlist");
        } else if (selectKor.equals("BI")) {
            wishlist.addFoodToWishlist(bibimbap);
            System.out.println("Bibimbap has been successfully added to your wishlist");
        } else if (selectKor.equals("BN")) {
            wishlist.addFoodToWishlist(bibimNaengmyeon);
            System.out.println("Bibim naengmyeon has been successfully added to your wishlist");
        } else if (selectKor.equals("HS")) {
            wishlist.addFoodToWishlist(hangoverStew);
            System.out.println("Hangover stew has been successfully added to your wishlist");
        } else {
            displayWishlist();
            editWishlist();
        }
        runCalorie();
    }

    // REQUIRES: 0 <= index <= (size of items in the wishlist - 1)
    //           editInput must equals "calc" or "view" or "clear" or "edit"
    // MODIFIES: this
    // EFFECTS: calculate daily total calories in the wishlist, or prints list of foods in wishlist to the screen,
    //          or clear all data in the wishlist, or remove one specific unwanted food (according to index)
    private void editWishlist() {
        String editInput = null;
        editInput =  input.next();
        editInput = editInput.toLowerCase();

        if (editInput.equals("calc")) {
            System.out.println(wishlist.calculateDailyTotal());
        } else if (editInput.equals("view")) {
            System.out.printf("Wishlist: " + wishlist.getNamesInWishlist());
        } else if (editInput.equals("clear")) {
            wishlist = new Wishlist();
        } else {
            System.out.println("Enter the corresponding index of the food you want to remove from the wishlist");
            wishlist.removeFromWishlist(input.nextInt());
        }
        runCalorie();

    }


}
