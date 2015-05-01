package application;

/**
 * ENums to represent the 4 types of triage
 *
 *
 */
public enum Triage {
	EMERGENCY("emergency", 1), URGENT("urgent", 2), SEMI_URGENT("semi_urgent",
			3), NON_URGENT("non_urgent", 4);
	private final String triage;

	/**
	 * Variable for the Enum
	 */
	private final int level;

	/**
	 * Constructor with argurments 
	 * @param triage
	 * @param level
	 */
	Triage(String triage, int level) {
		this.triage = triage;
		this.level = level;
	}

	/**
	 * Method to get triage ENum
	 * @return
	 */
	public String getTriage() {
		return triage;
	}

	/**
	 * Method to get triage level 
	 * @return
	 */
	public int getLevel() {
		return level;
	}
}
