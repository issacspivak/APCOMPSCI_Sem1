public class Magpie3
{
	/** Get a default greeting @return a greeting*/
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/** getResponse() method
	 * ===========================================
	 * 	Gives a response to a user statement
	 *  @param statement (the user statement)
	 * 	@return a response based on the rules given */
	public String getResponse(String statement)
	{
		String response = "";


		if(findKeyword(statement, "no", -1) >= 0)
		{
			response = "Why so negative?";
		}
		else if(statement.length() == 0)
		{
			response = "Say something, please.";
		}
		

		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Tell me more about your family.";
		}

		 else if (findKeyword(statement, "dog") >= 0
				|| findKeyword(statement, "cat") >= 0
				|| findKeyword(statement, "fish") >= 0
				|| findKeyword(statement, "turtle") >= 0)
				
		{
			response = "Tell me more about your pet.";
		}

		else if(findKeyword(statement, "robinette", 0) >= 0)
		{
			response = "He sounds like a pretty dank teacher.";
		}
		else if(findKeyword(statement, "i want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement,"i") >= 0)
		{
			int psn1 = findKeyword(statement, "i", 0);
			
			if(psn1 >= 0 && findKeyword(statement, "you", psn1) >= 0)
			{
				response = transformIYouStatement(statement);
			}
		}
		else
		{
			//looks for a two word pattern: you (something) me
			int psn = findKeyword(statement, "you", 0);
			
			if(psn >= 0 && findKeyword(statement, "me", psn) >= 0)
			{
				response = transformYouMeStatement(statement);
				//if the two word pattern is found it will call the transformIWantToStatement to transform it
			}
			else
			{
				response = getRandomResponse();
			}
		}
		return response;
	}
	
	//this method finds a statement with "I want to" and turns it into: "What would it mean to"
	//returns the newly transformed statement
	private String transformIWantToStatement(String statement)
	{
		//variable lastChar is the last character in a statement
		String lastChar = statement.substring(statement.length()-1);
		if(lastChar.equals("."))
		{
			//if the lastChar is a period it removes the last character from the statement
			statement = statement.substring(0, statement.length()-1);
		}
		
		//sets int to whats results from findKeyword() method @param statement for "I want to"
		//sets new String restOfStatement to rest of statement following "I want to"
		int psn = findKeyword(statement, "i want to");
		String restOfStatement = statement.substring(psn + 9);
		return "What would it mean to" + restOfStatement + "?";
	}
	
	private String transformYouMeStatement(String statement)
	{
		//variable lastChar is the last character in a statement
		String lastChar = statement.substring(statement.length()-1);
		if(lastChar == ".")
		{
			//if the lastChar is a period it removes the last character from the statement
			statement = statement.substring(0, statement.length()-1);
		}
		
		//sets int psnOfYou to the result of findKeyword at statement and "you"
		int psnOfYou = findKeyword(statement, "you");
		//sets int psnOfMe to result of findKeyword at statement "me" and psnOfYou+3
		int psnOfMe = findKeyword(statement, "me", psnOfYou + 3);
		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe);
		return "What makes you think that I" + restOfStatement + "you?";
	}
	
	
	private String transformIYouStatement(String statement)
	{
		//also trims statement and removes period
		String lastChar = statement.substring(statement.length()-1);
		if(lastChar == ".")
		{
			statement = statement.substring(0, statement.length()-1);
		}
		
		//sets int psnOfI to the result of findKeyword at statement and "i"
		int psnOfI = findKeyword(statement, "i");
		//sets int psnOfU to the result of findKeyword at statement "you", psnOfI+1
		int psnOfU = findKeyword(statement, "you", psnOfI + 1);
		String restOfStatement = statement.substring(psnOfI + 1, psnOfU);
		return "Why do you" + restOfStatement + "me?";
	}

	/** Ex_02: The findKeyword() Method...
	 * ========================================================= */
	private int findKeyword(String statement, String goal, int startPos)
	{
		/* New String variable phrase = a more searchable version of statement.
		 	-Use a combination of trim() and toLowerCase() modify statement.

		   New int variable psn = the location of goal in phrase after
		   startPos

			-->Refinement: Make sure we find goal by itself, and not part
			of another word ("no" vs no in "know"). if you find an occurrence
			of goal, make sure before and after aren't letters.

			As long as psn >= 0...
				Check if psn > 0 - there is no need to check for before at the
				beginning of the word
					set before = the slot in phrase before psn */

		String phrase = statement.trim().toLowerCase();
		String before = " ";
		String after = " ";
		goal = goal.toLowerCase();
		
		int psn = phrase.indexOf(goal, startPos);
		
		while(psn >= 0)
		{
			before = " ";
			after = " ";
			
			
			//checks if psn > 0 and if so will set before to the spot in phrase before psn
			if(psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}

				/*check if you can fit goal into the rest of phrase - no need to
				proceed otherwise
					set after = the slot in phrase after psn + length of goal */

			if(goal.length() + psn < phrase.length())
			{
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1);
			}

				/* if before and after are not letters (compare before to "a"
					and after to "z")
						--return psn

				Otherwise, search for goal in phrase from psn + 1 forward */
			if((before.compareTo("a") < 0 || before.compareTo("z") > 0) && (after.compareTo("a") < 0 || after.compareTo("z") > 0))
			{
				return psn;
			}
			psn = phrase.indexOf(goal, psn + 1);
		}

		return -1;

	}

	/** Override - this method is used if there are only 2 parameters...*/
	private int findKeyword(String statement, String goal)
	{
		//set startPos to 0 if not specified
		return findKeyword(statement, goal, 0);
	}

	/** getRandomResponse() method
	 * =============================================================*/
	/** Pick a default response to use if nothing else fits.
	 * 	@return a non-committal string*/
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
			response = "Interesting, tell me more.";
		else if (whichResponse == 1)
			response = "Hmmm.";
		else if (whichResponse == 2)
			response = "Do you really think so?";
		else if (whichResponse == 3)
			response = "You don't say.";

		return response;
	}
}
