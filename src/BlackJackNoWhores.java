import java.util.*;

/**
 * Created by gef on 4/8/2016.
 */

/*
Написать Black Jack с возможностью играть с 2 соперниками (ИИ)
при старте игры выбирать количество соперников
+ зашить логку выбора для 1го и для 2го компьютера-игрока
1й будет осторожничать (не брать много)
2й будет как демон брать карты пока меньше чем 18 например
 */

public class BlackJackNoWhores {

    public static String[] cards = {"two of spades", "three of spades", "four of spades", "five of spades", "six of spades", "seven of spades",
            "eight of spades", "nine of spades", "ten of spades", "jack of spades", "queen of spades", "king of spades", "ace of spades",
            "two of clubs", "three of clubs", "four of clubs", "five of clubs", "six of clubs", "seven of clubs",
            "eight of clubs", "nine of clubs", "ten of clubs", "jack of clubs", "queen of clubs", "king of clubs", "ace of clubs",
            "two of diamonds", "three of diamonds", "four of diamonds", "five of diamonds", "six of diamonds", "seven of diamonds",
            "eight of diamonds", "nine of diamonds", "ten of diamonds", "jack of diamonds", "queen of diamonds", "king of diamonds", "ace of diamonds",
            "two of hearts", "three of hearts", "four of hearts", "five of hearts", "six of hearts", "seven of hearts",
            "eight of hearts", "nine of hearts", "ten of hearts", "jack of hearts", "queen of hearts", "king of hearts", "ace of hearts" };

    static boolean gameIsOver = false;

    public static void main(String[] args) throws Exception {
        List<String> deck = createDeck(cards);
        int qty = pickOpponentsQty();
        Set<Player> players = createPlayers(qty);
        playTheGame(players, deck);
    }

    public static List<String> createDeck(String[] cards){
        List<String> deck = new ArrayList<>(); //deck to start game with
        List<String> list = new ArrayList<>();
        for (String card : cards) //TODO: Collections.addAll(Arrays.asList(cards))
            list.add(card);
        for (int i=0; i<52; i++) {
            int rnd = getRandomCard(list.size());
            deck.add(list.get(rnd - 1));
            list.remove(rnd-1);
        }
        return deck;
    }

    public static int getRandomCard(int max) {
        return (int)(Math.random() * max + 1);
    }

    public static int pickOpponentsQty() throws Exception {
        int qty = 2;
        while (true) {
            System.out.print("Pick opponents qty between 2 and 6 (2 by default): ");
            Scanner in = new Scanner(System.in);
            String qtyString = in.nextLine();
            if (isNumber(qtyString))
                qty = Integer.valueOf(qtyString);
            if (qty >=2 && qty <=6) break;
        }
        System.out.println("You picked " + qty + " players.");
        return qty;
    }

    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-')
                    || (!Character.isDigit(c) && c != '-') )
                return false;
        }
        return true;
    }

    public static Set<Player> createPlayers(int qty) {
        Set<Player> players = new LinkedHashSet<>();
        Player you = new Player("You");
        players.add(you);
        for (int i=1; i<qty; i++) {
            Player player = new Player("gambler" + i);
            players.add(player);
            System.out.print("Choose behaviour model for " + player.name + " (1-risky, watchful by default): ");
            Scanner in = new Scanner(System.in);
            String playerCharacter = in.nextLine();
            if (playerCharacter.equals("1"))
                player.riskyCharacter = true;
            else player.riskyCharacter = false;
            System.out.println("Player " + player.name + " character is risky? - " + player.riskyCharacter);
        }
        return players;
    }

    public static void playTheGame(Set<Player> players, List<String> deck) {
        System.out.println("\nBlackjack game has begun!");
        Player bank = new Player("Bank");
        makeFirstRound(players, deck, bank);
        printCurrentState(players, bank);
        while (!gameIsOver) {
            nextRound(players, deck, bank);
            printCurrentState(players, bank);
            checkStatus(players, bank);
        }
    }

    public static void nextRound(Set<Player> players, List<String> deck, Player bank) {
        for (Player player : players) {
            if (player.name.equals("You")) {
                System.out.println("Would you like to get more? (1-yes)");
                Scanner in = new Scanner(System.in);
                String playerChoise = in.nextLine();
                if (playerChoise.equals("1"))
                    getOneMore(player, deck);
            }
            if (player.name.equals("gambler")) {
                if (player.score < 15)
                    getOneMore(player, deck);
                if (player.riskyCharacter && player.score < 17)
                    getOneMore(player, deck);
            }
        }
        if (bank.score < 14)
            getOneMore(bank, deck);
    }

    public static void getOneMore(Player player, List<String> deck) {
        String nextCard = deck.get(0);
        player.cards.add(nextCard);
        deck.remove(0);
    }

    public static void makeFirstRound(Set<Player> players, List<String> deck, Player bank) {
        for (int i=0; i<2; i++) {
            for (Player player : players) {
                String card = deck.get(0);
                player.cards.add(card);
                deck.remove(0);
            }
        }
        String card = deck.get(0);
        bank.cards.add(card);
        deck.remove(0);
    }

    public static void printCurrentState(Set<Player> players, Player bank) {
        System.out.println("Bank has next cards: " + bank.cards + " and Bank score is " + getScore(bank));
        for (Player player : players)
            System.out.println(player.name + " has next cards: " + player.cards + " and score is " + getScore(player));
    }

    public static int getScore(Player player) {
        int score = player.score;
        for (String card : player.cards) {
            if (card.contains("two")) score = score + 2;
            if (card.contains("three")) score = score + 3;
            if (card.contains("four")) score = score + 4;
            if (card.contains("five")) score = score + 5;
            if (card.contains("six")) score = score + 6;
            if (card.contains("seven")) score = score + 7;
            if (card.contains("eight")) score = score + 8;
            if (card.contains("nine")) score = score + 9;
            if (card.contains("ten")) score = score + 10;
            if (card.contains("jack")) score = score + 10;
            if (card.contains("queen")) score = score + 10;
            if (card.contains("king")) score = score + 10;
            if (card.contains("ace")) score = score + 11;
        }
        player.score = score;
        return score;
    }

    public static void checkStatus(Set<Player> players, Player bank) {
        int bankScore = bank.score;
        if (bankScore == 21) {
            System.out.println("Bank have a blackjack!");
        }
        if (bankScore > 21) {
            System.out.println("Bank got too much");
        }
        for (Player player : players) {
            int playerScore = player.score;
            if (playerScore == 21) {
                System.out.println("Player " + player.name + " got " + player.score);
            }
            if (playerScore > 21) {
                System.out.println("Player " + player.name + " got too much " + player.score);
            }
        }
        //TODO: main check
    }

    public static void printDeck(List<String> set) {
        for (String elem : set)
            System.out.println(elem);
    }

    public static class Player {

        public Player(String name) {
            this.name = name;
            this.score = 0;
            this.cards = new HashSet<>();
            this.riskyCharacter = false;
        }

        public String name;
        public int score;
        boolean riskyCharacter;
        Set<String> cards;
    }

}