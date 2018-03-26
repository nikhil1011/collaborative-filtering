import java.util.*;

public class CollaborativeFiltering {
	
	Map<Integer, Map<Integer, Double>> dataSet;
	
	public double predict(int userId, int itemId) {
		double predictedValue = 0.0;
		double averageValueOfVotesForCurrentUser = averageValueOfVotesForUser(userId);
		
		
		
		return predictedValue;
	}
	
	private double averageValueOfVotesForUser(int userId) {
		double averageValue = 0.0;
		Map<Integer, Double> userVotes = dataSet.get(userId);
		
		for(Integer itemId: userVotes.keySet()) {
			averageValue = averageValue + userVotes.get(itemId);
		}
		averageValue = averageValue/userVotes.size();
		return averageValue;
	}
	
	private double correlation(int user1, int user2) {
		double correlation = 0;
		Map<Integer, Double> user1Ratings = dataSet.get(user1);
		Map<Integer, Double> user2Ratings = dataSet.get(user2);
		double user1AverageRating = averageValueOfVotesForUser(user1);
		double user2AverageRating = averageValueOfVotesForUser(user2);
		double numerator = 0;
		double denominatorTerm1 = 0;
		double denominatorTerm2 = 0;
		
		for(Integer itemId:	user1Ratings.keySet()) {
			if(user2Ratings.containsKey(itemId)) {
				double user1Rating = user1Ratings.get(itemId);
				double user2Rating = user2Ratings.get(itemId);
				numerator += (user1Rating - user1AverageRating)*(user2Rating-user2AverageRating);
				denominatorTerm1 += (user1Rating - user1AverageRating)*(user1Rating - user1AverageRating);
				denominatorTerm2 += (user2Rating - user2AverageRating)*(user2Rating - user2AverageRating);
			}
		}
		
		correlation = (numerator)/(Math.sqrt(denominatorTerm1*denominatorTerm2));
		return correlation;
	}
}
