/**
 * Class FacebookCircles: calculates the statistics about the friendship circles in facebook data.
 *
 * @author
 *
 * @version 01/12/15 02:03:28
 */
public class FacebookCircles {

	private int[] id;
	private int[] size;
	private int largestCircle;
//	private int smallestCircle;

	/**
	 * Constructor
	 * @param numberOfFacebookUsers : the number of users in the sample data.
	 * Each user will be represented with an integer id from 0 to numberOfFacebookUsers-1.
	 */
	public FacebookCircles(int numberOfFacebookUsers) {
		id = new int[numberOfFacebookUsers];
		size = new int[numberOfFacebookUsers];
		for (int i = 0; i < numberOfFacebookUsers; i++){
			id[i] = i;
			size[i] = 1;
		}
		largestCircle = 1;
	}

	/**
	 * creates a friendship connection between two users, represented by their corresponding integer ids.
	 * @param user1 : int id of first user
	 * @param user2 : int id of second  user
	 */
	public void friends( int user1, int user2 ) {
		// TODO
		int i = root(user1);
		int j = root(user2);
		if(i != j){
			if(size[i] < size[j])
			{
				id[i] = j;
				size[j] += size[i];
				size[i] = 0;
				if(size[j] >= largestCircle){
					largestCircle = size[j];
				}
			}else{
				id[j] = i;
				size[i] += size[j];
				size[j] = 0;
				if(size[i] >= largestCircle){
					largestCircle = size[i];
				}
			}
		}
	}

	/**
	 * @return the number of friend circles in the data already loaded.
	 */
	public int numberOfCircles() {
		// TODO
		int circles = 0;
		int temp = 0;
		for(int i = 0; i<size.length; i++){
			temp = size[i];
			if(temp != 0){
				circles++;
			}
		}
		return circles;
	}

	/**
	 * @return the size of the largest circle in the data already loaded.
	 */
	public int sizeOfLargestCircle() {
		// TODO
		return largestCircle;
	}

	/**
	 * @return the size of the median circle in the data already loaded.
	 */
	public int sizeOfAverageCircle() {
		// TODO
		int sizeTotal = 0;
		int numOfCircles = numberOfCircles();
		for(int i = 0; i < size.length; i++){
			if(size[i] != 0){
				sizeTotal += size[i];
			}
		}
		return sizeTotal/numOfCircles;
	}

	/**
	 * @return the size of the smallest circle in the data already loaded.
	 */
	public int sizeOfSmallestCircle() {
		// TODO
		int smallestCircle = 0;
		for(int i = 0; i < size.length; i++){
			if(size[i] != 0){
				smallestCircle = size[i];
			}
		}

		for(int i = 0; i < size.length; i++){
			if(size[i] < smallestCircle && size[i] != 0){
				smallestCircle = size[i];
			}
		}
		return smallestCircle;
	}

	public int root(int i) {
		while (i != id[i]){ 
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
}