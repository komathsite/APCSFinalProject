enum Response {
	Attack, Defend, Investigate, Heal, HealBarbarian,
	HealCleric, HealMage, HealFighter, Status, None
}

public class TextReader
{
	
	/** getResponse() method
	 * ===========================================
	 * 	Gives a response to a user statement
	 *  @param statement (the user statement)
	 * 	@return a response based on the rules given */
	public Response getResponse(String statement)
	{
		Response response;

		/** Exercise_01:
		 * ==================================================
		 * 	Code that asks the user "Say something, please."
		 * 	if you enter nothing, or if you accidentally hit
		 * 	enter. Think to yourself: "What is the length of
		 * 	an empty String?" */


		/** To be completed in Exercise_02:
		 * 	Modify the following code to use the findKeyword
		 * 	Method (details in "Exercise_02" below. */
		 
		if (statement.length() == 0)
		{
			response = Response.None; //0
		}
		
		else if (findKeyword(statement,"nothing") >= 0)
		{
			response = Response.None; //1
		}


		else if (findKeyword(statement,"attack") >= 0)
		{
			response = Response.Attack; //2
		}

		else if (findKeyword(statement,"defend") >= 0)
		{
			response = Response.Defend; //3
		}
		else if (findKeyword(statement,"investigate") >= 0)
		{
			response = Response.Investigate; //4
		}
		else if (findKeyword(statement,"heal")>= 0)
		{
			response = Response.Heal; //5
		}
		else if (findKeyword(statement,"target") >= 0 && findKeyword(statement,"heal") >=0 && findKeyword(statement,"cleric") >=0)
		{
			response = Response.HealCleric; //6
		}
		else if (findKeyword(statement,"target") >= 0 && findKeyword(statement,"heal") >=0 && findKeyword(statement,"fighter") >=0)
		{
			response = Response.HealFighter; //7
		}
		else if (findKeyword(statement,"target") >= 0 && findKeyword(statement,"heal") >=0 && findKeyword(statement,"barbarian") >=0)
		{
			response = Response.HealBarbarian; //8
		}
		else if (findKeyword(statement,"target") >= 0 && findKeyword(statement,"heal") >=0 && findKeyword(statement,"mage") >=0)
		{
			response = Response.HealMage; //9
		}
		else if (findKeyword(statement,"status") >= 0)
		{
			response = Response.Status; //11
		}
		else
		{
			response = Response.None; //10
		}
		return response;
	}

	/** Ex_02: The findKeyword() Method...
	 * ========================================================= */
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.toLowerCase().trim();
		int psn = goal.indexOf(statement, startPos);
		String before= "";
		String after = "";
		while(psn >= 0)
		{
			if(psn > 0)
			{
				before = phrase.substring(psn-1,psn);
			}
			if(goal.length() + psn < phrase.length())
			{
				after = phrase.substring(psn+ goal.length(), goal.length() + psn + 1);
			}
			if((before.compareTo("a") < 0 || before.compareTo("z") > 0) && (after.compareTo("z") > 0 || after.compareTo("a") < 0))
			{
				return psn;
			}
			psn = phrase.indexOf(goal, psn+1);
			
		}
		return -1;
	}

	/** Override - this method is used if there are only 2 parameters...*/
	private int findKeyword(String statement, String goal)
	{
		//set startPos to 0 if not specified
		return findKeyword(statement, goal, 0);
	}
}
