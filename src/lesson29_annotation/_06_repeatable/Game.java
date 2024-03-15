package lesson29_annotation._06_repeatable;

import java.lang.annotation.Repeatable;

@Repeatable(Games.class)
public @interface Game {
    String name()default "Some activity";
    String day();
}
