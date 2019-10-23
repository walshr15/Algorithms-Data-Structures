import java.util.Arrays;

public abstract class AnagramFinder {

    public abstract void add(String word);

    public abstract String[] search(String word);

    public void createDictionary(String[] words) {
        for(String s : words){
            add(s);
        }
    }

    protected String getBaseFormOf(String word){
    	char[] characters = word.toCharArray();
    	Arrays.sort(characters);
        return Arrays.toString(characters);
    }
}