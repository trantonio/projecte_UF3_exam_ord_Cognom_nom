package AguirreAntoniov4.src;

import AguirreAntoniov4.src.AguirreAntonio.v4.CausesAccidentsTransit;

public class Main {

	public static void main(String[] args) {

		CausesAccidentsTransit.csvFile(
				"data/in/emigraciosexe2012_asequible.csv",
				"data/out",
				"Excés de velocitat o inadequada",
				',',
				'"');

		
	}

}
