import java.util.Arrays;
import java.util.Stack;

class A {
    String a;
    Stack<String> b;
    String[] p;
    public A (String a) {
        this.a = a;
        this.b = new Stack<String>();
    }

    public String[] StringSplit() {
        p= a.split(" ",17);
        System.out.println(Arrays.toString(p));
        return p;
    }

    public void method1() {
        for (String i : p) {
            if (i .equals("-")){
                System.out.println("hii");
                b.pop();
                
            }
            else {
                System.out.println(i);
                b.push(i);
            }
        }
    }


    public static void main(String[] args){
        A x = new A("it was - the best - of times - - - it was - the - -");
        String[] y = x.StringSplit();
        //System.out.println(y[14]);
        x.method1();
        System.out.println(x.b);

    }
}