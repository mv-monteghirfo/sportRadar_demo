/**
 * 
 */
package sportRadar_demo;

import java.util.Map;

/**
 * @author Manuel
 *
 */
public interface Board {

	/**
	 * Register that a match starts in the system
	 * 
	 * @param homeTeam
	 * @param awayTeam
	 * @return the ID of the match that started
	 */
	String matchStart(String homeTeam, String awayTeam);

	/**
	 * Unregister a match in the system and it´s found by its Id
	 * 
	 * @param Id
	 */
	void matchFinish(String Id);

	/**
	 * Updates the state of a match in the system providing the score info
	 * 
	 * @param homeTeam as a coordinate to find the Match
	 * @param awayTeam as a coordinate to find the Match
	 * @param homeTeamScore to be updated
	 * @param awayTeamScore to be updated
	 * @return the ID of the updated Match
	 */
	String updateMatch(String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore);

	/**
	 * Returns the current state of the Matches in the system
	 * 
	 * @return the matches in the system
	 */
	Map<String, Match> getSummary();

}