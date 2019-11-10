/**
 * RansomNote
 * 
 * @author Abhiram Rayala
 */
public class RansomNote {

    /**
     * all the words from the magazine
     */
    public LinearProbing<String, Integer> wordsMagazine;
    /**
     * words from the ransom note
     */
    public LinearProbing<String, Integer> wordsRansom;

    /**
     * takes in the string of words from magazine and then forms a hashtable fr the
     * freq count
     * 
     * @param text magazine string
     * @return hashtable using linear probing
     */
    public LinearProbing<String, Integer> wordsInMagazine(final String text) {
        wordsMagazine = new LinearProbing<String, Integer>(20);
        String[] words = text.split(" ");
        for (String string : words) {
            if (wordsMagazine.contains(string)) {
                int value = wordsMagazine.get(string);
                wordsMagazine.put(string, value += 1);
            } else {
                wordsMagazine.put(string, 1);
            }
        }
        return wordsMagazine;
    }

    /**
     * tells if we can replicate the ransom note or not from the magazine
     * 
     * @param ransomStr ransom note
     */
    public void replicateRansom(final String ransomStr) {
        String[] ransomSt = ransomStr.split(" ");
        LinearProbing<String, Integer> replicaMag = wordsMagazine;
        for (String string : ransomSt) {
            if ((replicaMag.contains(string)) && (replicaMag.get(string) >= 0)) {
                int value = replicaMag.get(string);
                replicaMag.put(string, value - 1);
            } else {
                System.out.println("No cant be used");
                return;
            }
        }
        System.out.println("Yes can be used");
    }

    /**
     * main method
     */
    public static void main(String[] args) {
        RansomNote rn1 = new RansomNote();
        rn1.wordsInMagazine(
                "Just checking for the ransom note If any word from ransom note is missing in magazine the No else Yes");
        // rn1.wordsMagazine.display();
        rn1.replicateRansom("missing in ransom");
        rn1.replicateRansom("missing in money");
    }

}