/**
 * This class describes a solution.
 *
 * @author   Abhiram Rayala
 */

class Solution {

	/**
	 * sorts the teams array
	 *
	 * @param      teams  The teams
	 *
	 * @return     sorted teams
	 */
	public Team[] sort(final Team[] teams)  {
		for (int j = 1; j < teams.length; j++) {
			Team key = teams[j];
			int i = j - 1;
			while (i >= 0 && key.compareTo(teams[i]) == -1) {
				teams[i + 1] = teams[i];
				i--;
			}
			teams[i + 1] = key;
		}
		return teams;
	}
}

/**
 * This class describes a team.
 */
class Team implements Comparable<Team> {
	String teamName;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;

	/**
	 * Constructs a new instance.
	 *
	 * @param      name    The name
	 * @param      wins    The wins
	 * @param      losses  The losses
	 * @param      draws   The draws
	 */
	Team(final String name, final  int wins, final  int losses, int draws) {
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}

	/**
	 * Compares the specified team.
	 *
	 * @param      team  The team
	 *
	 * @return     1 if greater, 0 if equal and -1 is less
	 */
	public int compareTo(final Team team) {
		if (noOfWins != team.noOfWins) {
			if (noOfWins > team.noOfWins) return -1;
			else return 1;
		} else {
			if (noOfLosses != team.noOfLosses) {
				if (noOfLosses > team.noOfLosses) return 1;
				else return -1;
			} else {
				if (noOfDraws > team.noOfDraws) return -1;
				else if (noOfDraws > team.noOfDraws) return 1;
				else return 0;
			}
		}
	}


	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		// retrun all the attributes as a string but appending with ", "
		return teamName + "," + noOfWins + "," + noOfDraws + "," + noOfLosses;
	}
}