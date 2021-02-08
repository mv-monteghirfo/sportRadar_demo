/**
 * 
 */
package sportRadar_demo;

import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel
 *
 */
@Getter
@EqualsAndHashCode
public class Match {

// CLASS ATTRIBUTES ---------------------------------------------------------------------

	private final String Id;
	private final String homeTeam;
	private final String awayTeam;
	@Setter
	private int homeTeamScore;
	@Setter
	private int awayTeamScore;

	
// CLASS CONSTRUCTORS -------------------------------------------------------------------

	public Match(String homeTeam, String awayTeam) {
		super();

		this.Id = UUID.randomUUID().toString();
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamScore = 0;
		this.awayTeamScore = 0;
	}
	

// CLASS METHODS ------------------------------------------------------------------------

	@Override
	public String toString() {
		return "" + homeTeam + " " + homeTeamScore + " - " + awayTeam + " " + awayTeamScore;
	}

}
