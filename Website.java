import java.util.*;

/**
 * Class contains information about a webpage.
 * This includes site's name, URL, list of words as well as priority.
 *
 * @Hiep Le
 */
public class Website implements Comparable<Website>
{

    private String name;
    private String url;
    private String priority;

    private ArrayList<String> wordList;

    private ArrayList<String> excludedList;

    /**
     * Constructor for objects of class Webpage
     */
    public Website(String name, String url, String priority)
    {
        this.name = name;
        this.url = url;
        this.priority = priority;
        this.wordList = new ArrayList<String>();
        this.excludedList = new ArrayList<String>();
    }

    public String getName(){return this.name;}

    public String getUrl() {return this.url;}

    public String getPriority() {return this.priority;}

    public ArrayList<String> getWordList() {return this.wordList;}

    /**
     * Method add words to site's list of words
     */
    public void addWords(ArrayList<String> toAdd){   
        for(String word: toAdd){  
            if(!this.wordList.contains(word)){
                this.wordList.add(word);
            }
        }
    }

    public void addWord(String word){
        if(!this.wordList.contains(word)){
            this.wordList.add(word);
        }
    }

    public int compareTo(Website site){
        if(this.getPriority().equals(site.getPriority())){
            return this.getName().compareTo(site.getName());
        }
        else if(this.priority.equals("Low")){
            return -1;
        }
        else if(this.priority.equals("Medium")){
            if(site.getPriority().equals("High")){
                return -1;
            }
            else if(site.getPriority().equals("Low")){
                return 1;
            }
        }
        return 1;
    }

    public void print(){
        System.out.println("Name " + this.name);
        System.out.println("URL " + this.url);
        System.out.println("Priority " + this.url);
        for(int i = 0; i<wordList.size(); i++){
            if(i%10 == 0){
                System.out.println();
            }
            System.out.print(wordList.get(i) + " ");
        }
    }

}