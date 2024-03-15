package lesson29_annotation._06_repeatable;

@Game(name = "Poker", day = "Sunday")
@Game(day = "Tuesday")
@Game(name = "Golf", day = "Friday")
public class Main {
    public static void main(String[] args) {
        var games = Main.class.getAnnotation(Games.class);
        for (Game game : games.value()) {
            System.out.println(game.name() + " on " + game.day());
        }
    }
}
