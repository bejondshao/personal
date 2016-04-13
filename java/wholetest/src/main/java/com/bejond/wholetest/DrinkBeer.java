package com.bejond.wholetest;

/**
 * Created by bejond on 16-4-13.
 * 啤酒２元一瓶
 * ４个瓶盖换一瓶
 * ２个空瓶换一瓶
 * 问：１０元能喝几瓶
 */
public class DrinkBeer {
	private int lid; // 瓶盖数
	private int bottle; // 空瓶子数
	private int beer; // 整瓶酒的数量
	private int total; // 一共喝了多少瓶
	private int money; // 一共有多少钱

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getBottle() {
		return bottle;
	}

	public void setBottle(int bottle) {
		this.bottle = bottle;
	}

	public int getBeer() {
		return beer;
	}

	public void setBeer(int beer) {
		this.beer = beer;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void buy() {
		beer = money/2;
	}

	public void exchange() {
		while (true) {
			if (lid >= 4) {
				int tempLid = lid;
				lid = tempLid % 4;
				beer += tempLid / 4;
			}

			if (bottle >= 2) {
				int tempBottle = bottle;
				bottle = tempBottle % 2;
				beer += tempBottle / 2;
			}

			if (lid < 4 && bottle < 2) {
				if (beer > 0) {
					drink();
				} else {
					System.out.println("No more exchange and beer.");
					break;
				}
			}
		}
	}

	public void drink() {
		while (beer > 0) {
			beer--;
			lid++;
			bottle++;
			total++;
		}
	}

	public static void main(String[] args) {
		DrinkBeer drinkBeer = new DrinkBeer();
		drinkBeer.setMoney(16);

		drinkBeer.buy();
		drinkBeer.drink();
		drinkBeer.exchange();

		System.out.println("Beer: " + drinkBeer.getBeer());
		System.out.println("lid: " + drinkBeer.getLid());
		System.out.println("bottle: " + drinkBeer.getBottle());
		System.out.println("total: " + drinkBeer.getTotal());
	}
}
