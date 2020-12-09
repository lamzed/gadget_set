package version_01;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        int[] a = {11,22,33,44,55,66,44,55,22,11,99,88,77,66,22,33,55};
        ArrayList<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i]==a[j]){
                    tmp.add(a[i]);
                    System.out.println("i:"+a[i]+"; j:"+a[j]);
                }
            }
        }
        System.out.println(tmp);
        String ab = "sfaffadf";
        System.out.println(ab.contains("x"));
    }
}
