package sportRadar_demo;

/**
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Manuel
 *
 */
class FootballBoardTest extends FootballBoard {

// CLASS VARIABLES ----------------------------------------------------------------------

	private static Logger logger = LoggerFactory.getLogger(FootballBoardTest.class);

	private String homeTeam = "Real Madrid FC";
	private String awayTeam = "Barcelona FC";

// CLASS METHODS ------------------------------------------------------------------------

	// Test methods ------------------------

	/**
	 * This test starts a match and try to find it in the database
	 * to check if it was created
	 */
	@Test
	void matchStart_test() {

		logger.debug("\n##############################\n " 
				   + "matchStart_test" 
				   + "\n##############################\n ");

		var board = new FootballBoard();
		logger.debug("Creating a match");
		board.matchStart(homeTeam, awayTeam);
		var isRegistered = findMatchByTeamsPlaying(board, homeTeam, awayTeam).isPresent();
		
		logger.debug("Is the match in the current Board state? :" + isRegistered);
		assertTrue(isRegistered, "The match was not registered");

	}
	

	/**
	 * This test creates a match, finishes it and tries to check if it is 
	 * still registered
	 */
	@Test
	void matchFinish_test() {
		
		logger.debug( "\n##############################\n "
					+ "matchFinish_test"
					+ "\n##############################\n ");

		var board = new FootballBoard();
		
		logger.debug("Creating a match..");
		var matchId = board.matchStart(homeTeam, awayTeam);
		
		logger.debug("Finishing a match..");
		board.matchFinish(matchId);
		var isRegistered = findMatchById(board, matchId).isPresent();

		logger.debug("Is the match in the current Board state? :" + isRegistered);
		assertFalse(isRegistered, "The match was not eliminated");
	
	}

	
	/**
	 * This test creates a match in the system, updates its score
	 * request it to the library and check if it was updated
	 */
	@Test
	void updateMatch_test() {
		
		logger.debug("\n##############################\n "
				   + "updateMatch_test"
				   + "\n##############################\n ");
		
		var board = new FootballBoard();
		logger.debug("Creating a match with the state:\n {} {} - {} {}", homeTeam, 0, awayTeam, 0);
		var matchId = board.matchStart(homeTeam, awayTeam);
		
		logger.debug("Updating match with the state:\n {} {} - {} {}", homeTeam, 1, awayTeam, 1);
		board.updateMatch(homeTeam, awayTeam, 1, 1);
		
		logger.debug("Retrieving the updated match...");
		var updatedMatch = findMatchById (board, matchId);
		logger.debug("Updated match: \n {}", updatedMatch.get());
		
		boolean isUpdated = (updatedMatch.get().getHomeTeamScore() == 1) && (updatedMatch.get().getAwayTeamScore() == 1);
		logger.debug("Updated match: \n {}", updatedMatch.get());
		assertTrue(isUpdated, "The match was not updated");
		
	}
	

	/**
	 * This test creates a match, retrieves it from the library and checks
	 * the state of it to know if it is the expected one
	 */
	@Test
	void getSummary_test() {
		
		logger.debug("\n##############################\n "
				   + "getSummary_test"
				   + "\n##############################\n ");
		
		var board = new FootballBoard();
		
		logger.debug("Creating a match with the state:\n {} {} - {} {}", homeTeam, 0, awayTeam, 0);
		var matchId = board.matchStart(homeTeam, awayTeam);
		var summary = board.getSummary();
		
		logger.debug(summary.toString());
		
		assertTrue(summary.get(matchId).getHomeTeam() == homeTeam && summary.get(matchId).getAwayTeam() == awayTeam );
		
	}

}
