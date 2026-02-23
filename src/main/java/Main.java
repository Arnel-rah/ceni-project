

public class Main {

    public static void main(String[] args) {
        DataRetriever dataRetriever = new DataRetriever();
        System.out.println("totale vote = " + dataRetriever.countAllVotes());


        System.out.println(dataRetriever.countVotesByType());
    }

}
