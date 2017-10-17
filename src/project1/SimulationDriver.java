package project1;

import java.util.Random;

/**	In this simulation of student question/answers, the only aspect that truly needs to be tracked 
 * 	is the answers submitted. The simulation can send IVoteService the responses necessary without
 * 	outputting a specific trivia question first.
 * 	 
 * 
 *  @author Donovan Rush - 10/17/17
 *
 */

public class SimulationDriver {

	private static IVoteService Service;
	private static QuestionSingle Single = new QuestionSingle();
	private static QuestionMultiple Multiple = new QuestionMultiple();
	private static Random random = new Random();
	private static String[] options;
	
	public static void main(String[] args) 
	{
		boolean multiple = random.nextBoolean();
		if (multiple){
			Service = new IVoteService(AnswerFormat.MULTIPLE);
			options = Multiple.getAnswers();
		}
		else {
			Service = new IVoteService(AnswerFormat.SINGLE);
			options = Single.getAnswers();
		}
	
		// Generate many random student IDs. 
		generateStudents();
	
		// When finished, tell IVoteService to compile data together.
		Service.tallyAnswers();
		
	}
	
	private static void generateStudents()
	{
		int class_size = random.nextInt(41) + 10;	// random number between 10-50 students 
		System.out.println("Number of students: " + class_size);
		
		for(int i = 0; i < class_size; i++)
		{
			int ID = random.nextInt(10000);	// ID is a random integer between 0-9999
			Student student = new Student(String.valueOf(ID));	// convert ID to string, make a student with it
			
			int guess = random.nextInt(options.length);		// Generate random answer submissions for each student.
			student.submitAnswer(options[guess]);
		}
	}


}
