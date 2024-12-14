import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class SentimentAnalyzer {

    // parses the text file into an ArrayList
    public static List<WordValue> parseTextFile(String filePath) {
        List<WordValue> wordValues = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String word = parts[0];
                    double value = Double.parseDouble(parts[1]);
                    WordValue entry = new WordValue(word, value);
                    wordValues.add(entry);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return wordValues;
    }

    // asks the user to input a sentence using the scanner and returns that sentence as an array
    // of every word
    public List<String> promptSentence() {
        System.out.println("enter a sentence to score");
        Scanner input = new Scanner(System.in);
        String sentence = input.nextLine();
        return sentenceToWords(sentence);
    }

    // converts the sentence the user submitted to a string array of the words in the sentence
    // by splitting on space
    public List<String> sentenceToWords(String sentence) {
        String[] words = sentence.split(" ");
        return Arrays.stream(words).toList();
    }

    // gets the value of every word in the sentence as a double
    public double scoreWord(String word, List<WordValue> wordValues) {
        for (WordValue wordValue : wordValues) {
            if (word.equals(wordValue.getWord())) {
                return wordValue.getValue();
            }
        }
        return 0.0;
    }

    // adds each value of the words in the sentence together
    public double sentenceScore(List<String> sentence, List<WordValue> wordValues) {
        double total = 0.0;
        for (String word : sentence) {
            total += scoreWord(word, wordValues);
        }
        return total;
    }
}
