class WordValue {
    private String word;
    private double value;

    public WordValue(String word, double value) {
        this.word = word;
        this.value = value;
    }

    // returns the word
    public String getWord() {
        return word;
    }

    // returns the value word
    public double getValue() {
        return value;
    }

    // toStringifies it
    @Override
    public String toString() {
        return "WordValue{" +
                "word='" + word + '\'' +
                ", value=" + value +
                '}';
    }
}
