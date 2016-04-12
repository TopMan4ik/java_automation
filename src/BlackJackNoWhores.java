import java.util.*;

/**
 * Created by gef on 4/8/2016.
 */


public class BlackJackNoWhores {

    public static String[] cards = {"2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠", "K♠", "A♠",
            "2♥", "3♥", "4♥", "5♥", "6♥", "7♥", "8♥", "9♥", "10♥", "J♥", "Q♥", "K♥", "A♥",
            "2♣", "3♣", "4♣", "5♣", "6♣", "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♣", "A♣",
            "2♦", "3♦", "4♦", "5♦", "6♦", "7♦", "8♦", "9♦", "10♦", "J♦", "Q♦", "K♦", "A♦",};

    static boolean isGameOver = false;

    public static void main(String[] args) throws Exception {
        List<String> deck = createDeck(cards);
        Set<Player> players = createPlayers(pickPlayersQty());
        playTheGame(players, deck);
    }

    public static List<String> createDeck(String[] cards){
        List<String> deck = new ArrayList<>();
        ArrayList<String> list = (new ArrayList<>(Arrays.asList(cards)));
        for (int i=0; i<52; i++) {
            int rnd = (int)(Math.random() * list.size() + 1);
            deck.add(list.get(rnd - 1));
            list.remove(rnd - 1);
        }
        return deck;
    }

    public static int pickPlayersQty() throws Exception {
        int qty = 2;
        while (true) {
            System.out.print("Pick players qty between 2 and 6 (2 by default and it means you play versus Bank): ");
            Scanner in = new Scanner(System.in);
            String qtyString = in.nextLine();
            if (isNumber(qtyString))
                qty = Integer.valueOf(qtyString);
            if (qty >=2 && qty <=6) break;
        }
        System.out.println("You picked " + qty + " players.\n");
        return qty;
    }

    public static Set<Player> createPlayers(int qty) {
        Set<Player> players = new LinkedHashSet<>();
        Player you = new Player("You");
        players.add(you);
        Player bank = new Player("Bank");
        players.add(bank);
        for (int i=2; i<qty; i++) {
            Player player = new Player("gambler" + i);
            players.add(player);
            System.out.print("Choose behaviour model for " + player.name + " (1-risky, watchful by default): ");
            Scanner in = new Scanner(System.in);
            String playerCharacter = in.nextLine();
            if (playerCharacter.equals("1")) {
                player.riskyCharacter = true;
                System.out.println("Player " + player.name + " character is risky");
            }
            else {
                player.riskyCharacter = false;
                System.out.println("Player " + player.name + " character is watchful");
            }
        }
        return players;
    }

    public static void playTheGame(Set<Player> players, List<String> deck) {
        System.out.println("\nBlackjack game begins!");
        System.out.println("Aces are always 11 points in current game version");
        firstRound(players, deck);
        printCurrentState(players);
        checkStatus(players);
        while (!isGameOver) {
            nextRound(players, deck);
            printCurrentState(players);
            checkStatus(players);
        }
        System.out.println("Game is over. Come again! =)");
    }

    public static void nextRound(Set<Player> players, List<String> deck) {
        System.out.println("\n");
        for (Player player : players) {

            if (player.name.equals("You") && !player.isEnough) {
                System.out.print("Would you like to get more? (1-yes) ");
                Scanner in = new Scanner(System.in);
                String playersChoice = in.nextLine();
                if (playersChoice.equals("1")) {
                    getOneMoreCard(player, deck);
                    if (player.score >= 21) player.isEnough = true;
                }
                else player.isEnough = true;
            }

            if (player.name.contains("gambler") && !player.isEnough) {
                if (player.score < 14) {
                    getOneMoreCard(player, deck);
                    if (player.score > 21)
                        player.isEnough = true;
                } else if (player.riskyCharacter && player.score < 17) {
                    getOneMoreCard(player, deck);
                    if (player.score >= 21)
                        player.isEnough = true;
                }
                else
                    player.isEnough = true;
            }

            if (player.name.equals("Bank") && !player.isEnough) {
                if (player.score < 17) {
                    getOneMoreCard(player, deck);
                    if (player.score >= 21)
                        player.isEnough = true;
                } else
                    player.isEnough = true;
            }
        }
    }

    public static void getOneMoreCard(Player player, List<String> deck) {
        String nextCard = deck.get(0);
        player.cards.add(nextCard);
        deck.remove(0);
        calculateScore(player);
    }

    public static void firstRound(Set<Player> players, List<String> deck) {
        for (int i=0; i<2; i++) {
            for (Player player : players) {
                if (!player.name.equals("Bank"))
                    getOneMoreCard(player, deck);
                if (player.name.equals("Bank") && player.cards.isEmpty())
                    getOneMoreCard(player, deck);
            }
        }
    }

    public static void printCurrentState(Set<Player> players) {
        for (Player player : players) {
            if (player.name.equals("Bank"))
                System.out.println("Bank has next cards: " + player.cards + " and Bank's score is " + player.score);
            else
                System.out.println(player.name + " has next cards: " + player.cards + " and score is " + player.score);
        }
    }

    public static int calculateScore(Player player) {
        int score = 0;
        for (String card : player.cards) {
            if (card.contains("2")) score = score + 2;
            if (card.contains("3")) score = score + 3;
            if (card.contains("4")) score = score + 4;
            if (card.contains("5")) score = score + 5;
            if (card.contains("6")) score = score + 6;
            if (card.contains("7")) score = score + 7;
            if (card.contains("8")) score = score + 8;
            if (card.contains("9")) score = score + 9;
            if (card.contains("10")) score = score + 10;
            if (card.contains("J")) score = score + 10;
            if (card.contains("Q")) score = score + 10;
            if (card.contains("K")) score = score + 10;
            if (card.contains("A")) score = score + 11;
        }
        player.score = score;
        return score;
    }

    public static void checkStatus(Set<Player> players) {
        int bankScore = 0;
        for (Player player : players) {
            if (player.name.equals("Bank"))
                bankScore = player.score;
        }
        Set<String>readiness = new HashSet<>();
        for (Player player : players) {
            if (!player.isEnough)
                readiness.add("false");
            else
                readiness.add("true");
        }
        if (!readiness.contains("false")) {
            isGameOver = true;
            evaluateResults(players, bankScore);
        }
    }

    public static void evaluateResults(Set<Player> players, int bankScore) {
        for (Player player : players) {
            if (!player.name.equals("Bank")) {
                if (bankScore > 21) {
                    if (player.score <= 21)
                        System.out.println(player.name + " won :)");
                    else
                        System.out.println(player.name + " loose :(");
                }
                if (bankScore <= 21 && player.score > 21)
                    System.out.println(player.name + " loose :(");
                if (bankScore <= 21 && player.score <= 21) {
                    if (bankScore > player.score)
                        System.out.println(player.name + " loose :(");
                    else if (bankScore == player.score)
                        System.out.println(player.name + " keep money :|");
                    else System.out.println(player.name + " won :)");
                }
            }
        }
    }

    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') || (!Character.isDigit(c) && c != '-') )
                return false;
        }
        return true;
    }

    public static class Player {

        public Player(String name) {
            this.name = name;
            this.score = 0;
            this.cards = new HashSet<>();
            this.riskyCharacter = false;
            this.isEnough = false;
        }

        public String name;
        public int score;
        boolean riskyCharacter;
        Set<String> cards;
        boolean isEnough;
    }

}