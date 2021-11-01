package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Table<T> {
    protected List<T> players;

    public Table() {
        this.players = new ArrayList<T>();
    }

    public abstract void startGame();

}
