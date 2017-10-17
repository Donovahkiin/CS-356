package project1;

/**	Many objects of this Student class will be created, each given a different student ID.
 * 
 * 	Note that there are no constraints on the ID used. While something such as an eight digit number would
 * 	be a good format to use for student IDs, they are only broadly saved as a string. Any string will work,
 * 	and in the IVoteService class they are only used to compare if a matching string has been used previously.
 * 	 
 * 	Creating two unique students with identical IDs will not be checked as an error. However, they will be
 * 	treated as the same student in the IVoteService class, where submitting an answer from one will overwrite 
 * 	the previous submission from the other.
 */

public class Student 
{
	private String ID;
	
	public Student(String preset)	// a student should always be assigned an ID when it is created.
	{
		ID = preset;
	}

	public void submitAnswer(String submission)	// Students want someone else to think for them. Send submission from Driver.
	{
		IVoteService.collectAnswers(ID, submission);	// Submit an answer to the IVoteService. 
	}
	
}
