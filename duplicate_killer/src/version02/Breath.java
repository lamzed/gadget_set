package version02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Breath {
    static String suffix1 = ".mp4";
    static String suffix2 = ".avi";
    static String suffix3 = ".mkv";
    // static String suffix4 = ".rmvb";
    static String suffix4 = ".ppt";
    private static String path;
    private static ArrayList<File> all_result = new ArrayList<>();
    private static HashSet<String> format = new HashSet<>();

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

        formatFor(file);

    }

    // for file type
    private static void formatFor(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String[] tmp = file.getName().split("\\.");
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


        // new tmp for saving file's name without repeat
        ArrayList<String> tmp_name = new ArrayList();

        // add file's name to HashSet to find the files maybe duplicate
        HashSet<String> duplicate_maybe = new HashSet<>();

        // find the file size are same. format: name + path
        // ArrayList<String> same_size = new ArrayList<>();
        HashMap<Long,String> same_size = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            osw.write("\r\n");
        }

        for (File file : all_result) {
            if (!tmp_name.contains(file.getName())) {
                tmp_name.add(file.getName());
            } else {
                duplicate_maybe.add("maybe duplicate:  " + file.getName());
                // osw.write("maybe duplicate: "+file.getName()+"\r\n");
            }
        }

        // ******************************************************************************************************************

        for (int i = 0; i < all_result.size(); i++) {
            // get same_size_file name and path
            for (int j = i+1; j < all_result.size(); j++) {
                if (all_result.get(i).length()==all_result.get(j).length()){
                    if (!same_size.containsKey(all_result.get(i).length())){
                        same_size.put(all_result.get(i).length(),"  file_name:  "+all_result.get(i).getAbsolutePath()+"   ");
                    }else {
                        String tmp = same_size.get(all_result.get(i).length());
                        same_size.put(all_result.get(i).length(),tmp+all_result.get(i).getAbsolutePath()+"   ");
                    }

                    // same_size.add("same_size_file:   "+file.getName()+" :  "+file.length()+"  "+file.getAbsolutePath());
                    // osw.write("same_size_file: "+file.getName()+": "+file.length()+"__"+file.getAbsolutePath()+"\r\n");
                }
            }
        }

        // ******************************************************************************************************************

        for (String e : duplicate_maybe) {
            osw.write(e+"\r\n");
        }

        osw.write("\r\n**************************************************************\r\n\r\n");

//        for (String e : same_size) {
//            osw.write(e+"\r\n");
//        }

        // osw.write();

        Set<Map.Entry<Long, String>> set = same_size.entrySet();

        // System.out.println(all_result);
        System.out.println(all_result.size());

        for (Map.Entry<Long, String> entry : set) {
            System.out.println(entry.getKey()+entry.getValue());
            // osw.write(entry.getKey()+entry.getValue()+"\r\n");
        }

        osw.close();

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
