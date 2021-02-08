
package sportRadar_demo;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Manuel
 *
 */
public class FootballBoard implements Board {
	
// CLASS ATTRIBUTES ---------------------------------------------------------------------
	
	private static Logger logger = LoggerFactory.getLogger(FootballBoard.class);
	

// CLASS METHODS ------------------------------------------------------------------------
	
	/**
	 * Register that a match starts in the system
	 * 
	 * @param homeTeam
	 * @param awayTeam
	 * @return the ID of the match that started
	 */
	@Override
	public String matchStart(String homeTeam, String awayTeam) {
		
		return null;
	}
	
	
	/**
	 * Unregister a match in the system and it´s found by its Id
	 * 
	 * @param Id
	 */
	@Override
	public void matchFinish(String Id) {
		
	}
	
	
	/**
	 * Updates the state of a match in the system providing the score info
	 * 
	 * @param homeTeam as a coordinate to find the Match
	 * @param awayTeam as a coordinate to find the Match
	 * @param homeTeamScore to be updated
	 * @param awayTeamScore to be updated
	 * @return the ID of the updated Match
	 */
	@Override
	public String updateMatch(String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore) {
		
		return null;
	}
	
	
	/**
	 * Returns the current state of the Matches in the system
	 * 
	 * @return the matches in the system
	 */
	@Override
	public Map<String, Match> getSummary() {
		
		return null;
	}
	
	
}
