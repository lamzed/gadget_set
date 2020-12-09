package version_01;

import java.io.*;
import java.util.*;

public class Breath {
    static String suffix1 = ".mp4";
    static String suffix2 = ".avi";
    static String suffix3 = ".mkv";
    // static String suffix4 = ".rmvb";
    static String suffix4 = ".java";
    private static String path;
    private static ArrayList<File> all_result = new ArrayList<>();
    // static ArrayList<File> rearchResult = new ArrayList<>();
    private static HashSet<String> format = new HashSet<>();
    // static File[] allFile;

    public static void main(String[] args) throws IOException {
        welcome();
        search();
        save();
        byebye();
    }

    private static void search() throws IOException {
        Scanner scanner = new Scanner(System.in);
        path = scanner.nextLine();
        File file = new File(path);
        suffixFor(file);
        // System.out.println(result);
        // System.out.println("count: " + result.size());

        formatFor(file);
        // System.out.println(format);

        // saveAsTxt();

    }

    // for file type
    private static void formatFor(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String[] tmp = file.getName().split("\\.");
                // System.out.println("file.getName() = " + file.getName());
                // 判断切割后数组长度，若为一不保存
                if (tmp.length>1){
                    format.add(tmp[tmp.length-1]);
                }
            } else if (file.isDirectory()) {
                formatFor(file); } }
    }

    private static void suffixFor(File dir) {
        File[] files = dir.listFiles();
        // assert files != null;
        for (File file : files) {
            if (file.isFile()) {
                if (file.getName().endsWith(suffix1)
                        ||file.getName().endsWith(suffix2)
                        ||file.getName().endsWith(suffix3)
                        ||file.getName().endsWith(suffix4)) {
                    all_result.add(file);
                    // String[] tmp = file.getName().split("\\.");
//                    format.add(tmp[tmp.length-1]);
                }
            } else if (file.isDirectory()) {
                suffixFor(file); } }
    }

    private static void save() throws IOException {
        // OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./format_count.txt","utf-8"));
        OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream(path + "/done_DuplicateKiller.txt"),"utf-8");
        osw.write("All File Type:\r\n");
        // loop for saving files
        for (String e : format) {
            osw.write(e+";  ");
        }
        // osw.close();


        // new tmp for saving file's name without repeat
        ArrayList<String> tmp_name = new ArrayList();
        // temp find file not same
        // ArrayList<String> tmp_size = new ArrayList();

        // add file's name to HashSet to find the files maybe duplicate
        HashSet<String> duplicate_maybe = new HashSet<>();

        // find the file size are same. format: name + path
        ArrayList<String> same_size = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            osw.write("\r\n");
        }

        int count = 0;
        for (File file : all_result) {
            if (!tmp_name.contains(file.getName())){
                tmp_name.add(file.getName());
            }else {
                duplicate_maybe.add("maybe duplicate:  "+file.getName());
                // osw.write("maybe duplicate: "+file.getName()+"\r\n");
            }

            // get same_size_file name and path
            for (int i = count+1; i < all_result.size(); i++) {
                if (file.length()==all_result.get(i).length()){
                    same_size.add("same_size_file:   "+file.getName()+" :  "+file.length()+"  "+file.getAbsolutePath());
                    // osw.write("same_size_file: "+file.getName()+": "+file.length()+"__"+file.getAbsolutePath()+"\r\n");
                }
            }
            count++;
        }

        for (String e : duplicate_maybe) {
            osw.write(e+"\r\n");
        }

        osw.write("\r\n**************************************************************\r\n\r\n");

        for (String e : same_size) {
            osw.write(e+"\r\n");
        }

        // osw.write();

        osw.close();

        // System.out.println(same_size);

        // System.out.println(duplicate_maybe);



//        System.out.println(all_result);
//        System.out.println(duplicate_maybe);
//
//        for (Object e : duplicate_maybe) {
//            duplicate_maybe.remove(e);
//        }

        // FileOutputStream fos = new FileOutputStream("./duplicate_killer.done");
        // fos.write(97);
        // System.out.println(fos);
        // OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");

    }

    private static void welcome() {
        System.out.println("############################");
        System.out.println("# welcome2 DuplicateKiller #");
        System.out.println("############################");
        System.out.println("# plz enter your path: ");
    }

    private static void byebye(){
        String done = "done! result has been written" +" -->>> "+ path + "\\done_DuplicateKiller.txt";
        // for cross line
        StringBuilder cross_line = new StringBuilder("");
        cross_line.append("*".repeat(done.length()));
        // print result
        System.out.println(cross_line);
        System.out.println(done);
        System.out.print(cross_line);
        // System.out.println("byebye");
    }
}
