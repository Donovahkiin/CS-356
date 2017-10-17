package project1;

/**	The provided answer options within the enum can be easily modified as desired, 
 * 	while maintaining normal functionality of the program.
 */

public class QuestionSingle //implements Question
{
	private enum answers
	{
		TRUE, FALSE;
	}
	
	public String[] getAnswers()	// output the options as a String array
	{
		String[] toString = new String[answers.values().length];
		for(int i = 0; i < toString.length; i++)
			toString[i] = answers.values()[i].toString();
		return toString;
	}
}
