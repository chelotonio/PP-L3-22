package main;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase Card
 * Clase que representa una lista de Strings análoga a una carta de un set de cartas válido.
 * @author Marcelo Vásquez
 * @version 0.1, 2022/07/14
 */

public class Card {
    private ArrayList<String> carta;

    // Constructor de Card.
    public Card(ArrayList<String> carta) {
        this.carta = carta;
    }
    public ArrayList<String> getCarta() {
        return carta;
    }
    public void setCarta(ArrayList<String> carta) {
        this.carta = carta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(getCarta(), card.getCarta());
    }
    @Override
    public String toString() {
        return "carta=" + carta;
    }

    public Card agregarCarta(String string) {
        this.carta.add(string);
        Card card = new Card(carta);
        return card;
    }

    public ArrayList<String> cardToString(Card card) {
        ArrayList<String> cardString = new ArrayList<>();
        cardString = card.getCarta();
        return cardString;
    }

}
