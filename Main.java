import java.util.*;

public class Main {
    public static void main(String[] args) {
        Race r = new Race();
        HorseRace horseRace = new HorseRace();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Horse Betting!");

        while (true) {
            System.out.println("\nPlease select from the following options 1-6:");
            System.out.println("1. Place an exacta bet");
            System.out.println("2. Place an exactabox bet");
            System.out.println("3. Place a trifecta bet");
            System.out.println("4. Place a trifectabox bet");
            System.out.println("5. See your USD balance");
            System.out.println("6. Exit");

            String menu = scanner.nextLine();
            switch (menu) {
                case "1":
                    System.out.print("Enter the numbers of two horses separated by space: ");
                    int[] exactaHorses = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                    horseRace.placeBet("exacta", exactaHorses);
                    break;
                case "2":
                    System.out.print("Enter the numbers of two horses separated by space: ");
                    int[] exactaBoxHorses = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                    horseRace.placeBet("exactabox", exactaBoxHorses);
                    break;
                case "3":
                    System.out.print("Enter the numbers of three horses separated by space: ");
                    int[] trifectaHorses = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                    horseRace.placeBet("trifecta", trifectaHorses);
                    break;
                case "4":
                    System.out.print("Enter the numbers of three horses separated by space: ");
                    int[] trifectaBoxHorses = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                    horseRace.placeBet("trifectabox", trifectaBoxHorses);
                    break;
                case "5":
                    HorseRace.displayBalanace();
                    break;
                case "6":
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }


static class HorseRace {
    public static int balance;
    private static int winnings;
    private List<String[]> bets;

    public HorseRace() {
        balance = 200;
        bets = new ArrayList<>();
    }
    public void calculateWinnings(Race r) {
        int[] raceResult = r.getarray();
        for (String[] bet : bets) {
            String betType = bet[0];
            int[] horses = Arrays.stream(bet[1].replaceAll("[\\[\\]]", "").split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();


            switch (betType) {
                case "exacta":
                    if (raceResult[0] == horses[0] && raceResult[1] == horses[1]) {
                        winnings = balance +150;
                        System.out.println("Your balance is " + (winnings));
                        return;
                    }
                    break;
                case "exactabox":
                    if ((raceResult[0] == horses[0] && raceResult[1] == horses[1]) ||
                            (raceResult[1] == horses[0] && raceResult[0] == horses[1])) {
                        winnings = balance +100;
                        System.out.println("Your balance is " + (winnings));
                        return;
                    }
                    break;
                case "trifecta":
                    if (raceResult[0] == horses[0] && raceResult[1] == horses[1] && raceResult[2] == horses[2]) {
                        winnings = balance +250;
                        System.out.println("Your balance is " + (winnings));
                        return;
                    }
                    break;
                case "trifectabox":
                    if (Arrays.equals(raceResult, horses) || Arrays.equals(raceResult, new int[]{horses[0], horses[2], horses[1]}) ||
                            Arrays.equals(raceResult, new int[]{horses[1], horses[0], horses[2]}) || Arrays.equals(raceResult, new int[]{horses[1], horses[2], horses[0]}) ||
                            Arrays.equals(raceResult, new int[]{horses[2], horses[0], horses[1]})) {
                        winnings = balance +180;
                        System.out.println("Your balance is " + (winnings));
                        return;
                    }
                    break;
            }

        }

    }

    public void placeBet(String betType, int[] horses) {
        Race r = new Race();
        int betCost = 0;
        switch (betType) {
            case "exacta":
                betCost = 15;
                break;
            case "exactabox":
                betCost = 10;
                break;
            case "trifecta":
                betCost = 20;
                break;
            case "trifectabox":
                betCost = 18;
                break;
            default:
                System.out.println("Invalid bet type.");
                return;
        }

        if (balance >= betCost) {
            balance -= betCost;
            bets.add(new String[]{betType, Arrays.toString(horses)});
            System.out.println("Bet placed successfully.");
            r.readysetgo();
            System.out.println("(Cheat! Winning Sequence: " + r.first() + r.second() + r.third() + r.fourth() + ")");
            calculateWinnings(r);
        } else {
            System.out.println("Insufficient funds to place bet.");
        }
    }
    public static void displayBalanace() {
        System.out.println("Your balance is " + winnings);
}
}
}