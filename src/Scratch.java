import java.util.ArrayList;

public class Scratch {
    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        System.out.println(scratch.record(50));
        System.out.println(scratch.record(25));
        System.out.println(scratch.record(100));
        System.out.println(scratch.record(50));
        System.out.println(scratch.record(200));

        Scratch scratch2 = new Scratch();
        int[] stuScores = { 50, 25, 100, 50, 200, 201, 202, 200};
        scratch2.recordScores(stuScores);
        System.out.println(scratch2);
    }

    private ArrayList<ScoreInfo> scoreList = new ArrayList<>();
    public boolean record(int score){
        //check to see if it is already in the array list
        for (int i = 0; i <= scoreList.size() - 1; i++){
            if(score > scoreList.get(i).getScore()){
                scoreList.add(i, new ScoreInfo(score));
                return true;
            }
            if(score == scoreList.get(i).getScore()){
                scoreList.get(i).increment();
                return false;
            }
        }
        scoreList.add(new ScoreInfo(score));
        return true;

        //if it is increment it and return false
        //if it isnt add it to the array list and keep it in increasing order and return true
    }

    public void recordScores(int[] stuScores){
        for(int i = 0; i < stuScores.length; i++){
            record(stuScores[i]);
        }
    }

    @Override
    public String toString() {
        return "Scratch{" +
                "scoreList=" + scoreList +
                '}';
    }
}