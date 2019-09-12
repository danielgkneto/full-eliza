import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        String[] hedges = new String[] {"Please tell me more", "Many of my patients tell me the same thing", "It is getting late, maybe we had better quit"};
        String[] qualifiers = new String[] {"Why do you say that ", "You seem to think that ", "So, you are concerned that "};
        String user, therapist;
        String[] splitAnswer;
        boolean anyReplacementMade;

        HashMap<String, String> replacements = new HashMap<>();
        replacements.put("i", "you");
        replacements.put("me", "you");
        replacements.put("my", "your");
        replacements.put("am", "are");

        System.out.println("Welcome to Full Eliza");
        System.out.println("What is your problem? ");

        while (true) {
            anyReplacementMade = false;
            user = kb.nextLine();
            user = user.toLowerCase();
            if (user.equals("q"))
                break;

            splitAnswer = user.split(" ");

            for (int i = 0; i < splitAnswer.length; i++) {
                if (replacements.containsKey(splitAnswer[i])) {
                    splitAnswer[i] = replacements.get(splitAnswer[i]);
                    anyReplacementMade = true;
                }
            }

            if (anyReplacementMade) {
                therapist = qualifiers[new Random().nextInt(3)];
                for (String word : splitAnswer)
                    therapist = therapist.concat(word + " ");
            } else
                therapist = hedges[new Random().nextInt(3)];

            System.out.println(therapist);
        }

        System.out.println("Bye");
    }
}