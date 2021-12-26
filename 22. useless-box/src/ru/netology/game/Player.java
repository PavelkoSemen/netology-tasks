package ru.netology.game;

public abstract class Player extends Thread{
    protected final UselessBox volatileUselessBox;

    public Player(String  playerName, UselessBox volatileUselessBox) {
        super(playerName);
        this.volatileUselessBox = volatileUselessBox;
    }



}
