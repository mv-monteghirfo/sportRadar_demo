
package sportRadar_demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Manuel
 *
 */
public class FootballBoard implements Board {
	
// CLASS ATTRIBUTES ---------------------------------------------------------------------
	
	private static Logger logger = LoggerFactory.getLogger(FootballBoard.class);
	
	private final Map<String, Match> currentMatches = new HashMap<String, Match>();
	

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
		
		Match newMatch = new Match(homeTeam, awayTeam);
		String newId = newMatch.getId();
		
		currentMatches.put(newId, newMatch);
		
		return newId;
	}
	
	
	/**
	 * Unregister a match in the system and it´s found by its Id
	 * 
	 * @param Id
	 */
	@Override
	public void matchFinish(String Id) {
		currentMatches.remove(Id);
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
		
		var matchToUpdate = findMatchByTeamsPlaying(this, homeTeam, awayTeam);
		matchToUpdate.get().setHomeTeamScore(homeTeamScore);
		matchToUpdate.get().setAwayTeamScore(awayTeamScore);
		
		return matchToUpdate.get().getId();
	}
	
	
	/**
	 * Returns the current state of the Matches in the system
	 * 
	 * @return the matches in the system
	 */
	@Override
	public Map<String, Match> getSummary() {
		
		if (this.currentMatches.isEmpty()) return new HashMap<String, Match>();
		// returns a copy of the matches in the system, keeping the encapsulation of the collection 
		else return Map.copyOf(this.currentMatches);
	}
	
	
	// ###########################
	// Helper methods 
	
	protected Optional<Match> findMatchByTeamsPlaying(Board board, String homeTeam, String awayTeam) {

		Map<String, Match> summary = board.getSummary();
		
		logger.debug("Searching match with coordinates:\n home team:{} | away team {}", homeTeam, homeTeam);
		Optional<Match> match = summary.values()
										.stream()
										.filter(actMatch -> (actMatch.getHomeTeam() == homeTeam) && (actMatch.getAwayTeam() == awayTeam))
										.findFirst();
		
		if (match.isPresent()) logger.debug("Match found:\n {}", match.get().toString());
		
		return match;

	}
	
	
	protected Optional<Match> findMatchById (Board board, String Id){
		
		var matchesList = board.getSummary();
		
		return Optional.ofNullable(matchesList.get(Id));
		
	}
	
	
}
