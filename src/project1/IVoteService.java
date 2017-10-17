package project1;

import java.util.ArrayList;
import java.util.List;

public class IVoteService 
{
	QuestionSingle Single = new QuestionSingle();
	QuestionMultiple Multiple = new QuestionMultiple();
	private String[] options;

	// used for storing student submissions before statistics are tallied
	private static List<String> submissionsID = new ArrayList<String>();
	private static List<String> submissionsData = new ArrayList<String>();
	
	public IVoteService(AnswerFormat type)		// type is either MULTIPLE or SINGLE
	{
		if(type == AnswerFormat.MULTIPLE)
			options = Multiple.getAnswers();
		else if(type == AnswerFormat.SINGLE)
			options = Single.getAnswers();
	}

	/**	make collectAnswers a static method. Students can make an object of the class, call this method, and each 
	 * 	will submit to the same source. */
	public static void collectAnswers(String ID, String submission)
	{
		/** How about I just let every student data dump into this method? This method saves each ID and submission
		 * 	from students, searches past results to check for a repeat ID and overwrites that submission if 
		 * 	there's a repeat. Then, let the Driver class tell IVoteService when to compile the data together.	
		 * 	This way it's easier to overwrite multiple submissions from a single student. */

		if(submissionsID.contains(ID))	// if this student has already submitted an answer
		{
			int index = submissionsID.indexOf(ID);
			submissionsData.set(index, submission);	// overwrite his previous submission
		}
		else	// otherwise, add it to the list
		{
			submissionsID.add(ID);
			submissionsData.add(submission);
		}
		
	}
	
	// I have submissionsData, a list with all my answers I need to tally, the empty array tally with
	// spaces equal to the possible answers (2 or 5), and options, the String array with the selections in it.
	/**	for each student input
	 * 	search array for matching answer
	 * 	mirrored array of same size holds the tally
	 * 	tally +1 for tally[array.index] of array matching location 
	 */
	public void tallyAnswers()	
	{
		int[] tally = new int[options.length];	// initially empty array with all values initialized to 0
		
		for(int i = 0; i < submissionsData.size(); i++)		// mark one tally for each answer submitted
		{
			int j = 0;
			boolean loop = true;
			while(j < options.length && loop)	// int j navigates answer options, looking for the matching string
			{
				if(options[j].equals(submissionsData.get(i)))	// 'i'th student submission
				{
					tally[j] += 1;
					loop = false;	// break early once a matching answer is found. No need to search all of it.
				}
				j++;
			}
		}	// every submission has now been tallied.
		
		System.out.println("Number of students who selected each answer: ");
		for(int i = 0; i < options.length; i++)
			System.out.println(options[i] + ": " + tally[i]);
	}
}
