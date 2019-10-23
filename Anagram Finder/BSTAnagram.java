import java.util.*;
public class BSTAnagram extends AnagramFinder {
	
	TreeMap<String,ArrayList<String>> bst = new TreeMap<String,ArrayList<String>>();

	@Override
	public void add(String word) {
		// TODO Auto-generated method stub
		String baseForm = getBaseFormOf(word);
		if(bst.containsKey(baseForm) == true){
			ArrayList<String> theKey = bst.get(baseForm);
			theKey.add(word);
			bst.put(baseForm, theKey);
		}
		if(bst.containsKey(baseForm)== false){
			ArrayList<String> theKey = new ArrayList<String>();
			theKey.add(word);
			bst.put(baseForm, theKey);
		}
	}

	@Override
	public String[] search(String word) {
		// TODO Auto-generated method stub
		String baseForm = getBaseFormOf(word);
		if(bst.containsKey(baseForm) == true){
			ArrayList<String> theKey = new ArrayList<String>();
			theKey = bst.get(baseForm);
			String[] array = theKey.toArray(new String[theKey.size()]);
			return array;
		}
			String[] array = new String[0];
			return array;
	}

}
