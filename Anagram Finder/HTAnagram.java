import java.util.*;

public class HTAnagram extends AnagramFinder {
	
	
	Hashtable<String,ArrayList<String>> ht = new Hashtable<String,ArrayList<String>>();

	@Override
	public void add(String word) {
		// TODO Auto-generated method stub
		String baseForm = getBaseFormOf(word);
		if(ht.containsKey(baseForm) == true){
			ArrayList<String> theKey = ht.get(baseForm);
			theKey.add(word);
			ht.put(baseForm, theKey);
		}
		if(ht.containsKey(baseForm)== false){
			ArrayList<String> theKey = new ArrayList<String>();
			theKey.add(word);
			ht.put(baseForm, theKey);
		}
	}

	@Override
	public String[] search(String word) {
		// TODO Auto-generated method stub
		String baseForm = getBaseFormOf(word);
		if(ht.containsKey(baseForm) == true){
			ArrayList<String> theKey = new ArrayList<String>();
			theKey = ht.get(baseForm);
			String[] array = theKey.toArray(new String[theKey.size()]);
			return array;
		}
			String[] array = new String[0];
			return array;
	}
}
