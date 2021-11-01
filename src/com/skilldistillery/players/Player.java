package com.skilldistillery.players;

import java.util.Objects;

public abstract class Player {
    private double totalMoney;
    private double currentBet;
    private final String name;
    private boolean isPlaying;

    public Player(String name,double totalMoney) {
        this.name = name;
        isPlaying = true;
        currentBet = 0;
        this.totalMoney = totalMoney;
    }


    /* ------------------------------------------------
        get/set totalMoney
    ------------------------------------------------ */
    public double getTotalMoney() {
        return totalMoney;
    }
    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }


    /* ------------------------------------------------
        get/set/add currentBet
    ------------------------------------------------ */
    public double getCurrentBet() {
        return currentBet;
    }
    public void setCurrentBet(double currentBet) {
        if (totalMoney < currentBet) {
            currentBet = totalMoney;
        }

        this.currentBet = currentBet;
    }


    /* ------------------------------------------------
        get name
    ------------------------------------------------ */
    public String getName() {
        return name;
    }


    /* ------------------------------------------------
        get/set isPlaying
    ------------------------------------------------ */
    public boolean isPlaying() {
        return isPlaying;
    }
    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }



    /* ------------------------------------------------
        hashCode and equals
    ------------------------------------------------ */
    @Override
	public int hashCode() {
		return Objects.hash(currentBet, isPlaying, name, totalMoney);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Double.doubleToLongBits(currentBet) == Double.doubleToLongBits(other.currentBet)
				&& isPlaying == other.isPlaying && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(totalMoney) == Double.doubleToLongBits(other.totalMoney);
	}
}
