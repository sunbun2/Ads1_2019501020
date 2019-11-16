import java.util.Arrays;
import java.util.Scanner;

class card {
    public String value;
    public String type;
    card(String v,String t) {
        this.value = v;
        this.type = t;
    }
    card (card v) {
        this.value=v.value;
        this.type=v.type;
    }
    public int compareTo(card c) {
        int i1=0;
        int i2=0;
        String s1 = this.type;
        String s2 = c.type;
        if (s1.equals("S")) i1 = 4;
        if (s2.equals("S")) i2 = 4;
        if (s1.equals("H")) i1 = 3;
        if (s2.equals("H")) i2 = 3;
        if (s1.equals("C")) i1 = 2;
        if (s2.equals("C")) i2 = 2;
        if (s1.equals("D")) i1 = 1;
        if (s2.equals("D")) i2 = 1;
        if (i1==i2) {
            int p1 = Integer.parseInt(c.value);
            int p2 = Integer.parseInt(this.value);
            if (p1 < p2) return -1;
            else if(p1>p2) return 1;
            else return 0;
        }
        else if (i1>i2) return 1;
        else return -1;
    }
}

class DeckSort {
    card[] arr = new card[100];

    DeckSort(card[] d) {
        this.arr = d;
    }

    public void exch(int i, int j) {
        card c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public String[] check(int i, int j) {
        card p = arr[i];
        card q = arr[j];
        String[] s = new String[2];
        s[0] = p.value;
        s[1] = q.value;
        return s;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        s.close();
        String[] arr1 = s1.split(" ");
        System.out.println(Arrays.toString(arr1));
        card[] b1 = new card[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            card a = new card(arr1[i].substring(0, 1), arr1[i].substring(1));
            b1[i]= a;
        }
        DeckSort deck = new DeckSort(b1);
        // for (int j=0; j < b1.length-1; j++) {
        //     System.out.println(j+" "+b1.length);
        //     if (b1[j].compareTo(b1[j+1])>0) deck.exch(j, j+1);
        //     else continue;
        // }
        for (int j = 1; j < b1.length; j++) {
            int i = j;
            // System.out.println(i + " " + b1.length);
			while (i > 0 && b1[i].compareTo(b1[i - 1])>0) {
                deck.exch(i - 1,i);
                // for (int k = 0; k < b1.length; k++) {
                //     System.out.print(b1[k].value + "-" + b1[k].type);
                //     System.out.print(" ");
                // }
                // System.err.println(" ");

				// b1[i + 1] = b1[i];
				i--;
			}
			// b1[i + 1] = b1[j];
		}
        
        for (card card : b1) {
            System.out.print(card.value +"" + card.type + ",");
        }

    }
}