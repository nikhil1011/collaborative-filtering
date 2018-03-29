import java.io.File;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length!=2 && args.length!=0) {
			System.out.println("Invalid number of arguments:" + args.length);
			return;
		}
		String trainingFilePath = "src/netflix/TrainingRatings.txt";
		String testFilePath = "src/netflix/TestingRatings.txt";
		if(args.length == 2) {
			trainingFilePath = args[0];
			testFilePath = args[1];
		}
		File trainingTextFile = new File(trainingFilePath);
		File testTextFile = new File(testFilePath);
		
		CollaborativeFiltering collaborativeFilterer = new CollaborativeFiltering();
		
		collaborativeFilterer.train(trainingTextFile);
		List<Integer> results = collaborativeFilterer.test(testTextFile);
		
		System.out.println("Accuracy: " + (double)(results.get(1))/(double)(results.get(0)));
	}

}
