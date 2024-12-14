import java.util.List;

public class Main {
    public static void main(String[] args) {
        // instantiates the sentiment analyzer class
        SentimentAnalyzer analyzer = new SentimentAnalyzer();
        // creates a list of word values by parsing the text file
        List<WordValue> wordValues =  analyzer.parseTextFile("sentimentvalues.txt");
        // prompts the user for the sentence
        List<String> sentenceWords = analyzer.promptSentence();
        double sentenceScore = analyzer.sentenceScore(sentenceWords, wordValues);
        System.out.println("sentence score: " + sentenceScore);
    }
}