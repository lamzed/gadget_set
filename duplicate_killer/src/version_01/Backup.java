//import java.io.File;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Backup {
//    import java.io.File;
//import java.util.*;
//
//    public class Breath {
//        public static void main(String[] args) {
//            welcome();
//            search();
//
//
//            // System.out.println(files);
//
//
////
////        File[] tmp = file.listFiles();
////
////        ArrayList tmplist=new ArrayList()
////
////        ArrayList<File> list = new ArrayList<>();
////
////        for (File f : files) {
////            list.add(f);
////        }
////        List<File> list2 = Arrays.asList(files);
////        ArrayList<File> list3 = (ArrayList<File>) Arrays.asList(files);
//            // System.out.print(file.getAbsolutePath());
//
//
//        }
//
//        private static void welcome() {
//            System.out.println("############################");
//            System.out.println("# welcome2 DuplicateKiller #");
//            System.out.println("############################");
//            System.out.println("# plz enter your path: ");
//        }
//
//        private static void search() {
//            // System.out.println(new Search().suffixSearch());
//
//            String suffix = ".html";
//            // 这里不能new，要放在外面传参，不然每次new都是不同的对象。递归会报错。
//            ArrayList<String> result = new ArrayList<>();
//
//            // Scanner scanner = new Scanner(System.in);
//            // String path = scanner.nextLine();
//
//            File[] files = new File("F:\\python_doc\\python-3.9.1rc1-docs-html").listFiles();
//
//            // System.out.println(files);
//            for (File file : files) {
//                if (file.isFile()) {
//                    if (file.getName().endsWith(".html")) {
//                        // System.out.println(file);
//                        result.add(file.getName());
//                    }
//                } else {
//                    // System.out.println("...");
//                    search();
//                }
//            }
//            // return result;
//            System.out.println(result);
//        }
//    }
//
//
//    class Search{
//
//        // System.out.println("plz enter suffix of the file you what2 find");
//        // String suffix = scanner.nextLine();
//        String suffix = ".html";
//        ArrayList<String> result = new ArrayList<>();
//
//        Scanner scanner = new Scanner(System.in);
//        String path = scanner.nextLine();
//
//        File[] files = new File(path).listFiles();
//
//        public ArrayList<String> suffixSearch(){
//
//            for (File file : files) {
//                if (file.isFile()){
//                    if (file.getName().endsWith(".html")){
//                        // System.out.println(file);
//                        result.add(file.getName());
//                    }
//                }else {
//                    // System.out.println("...");
//                    suffixSearch();
//                }
//            }
//            return result;
//        }
//    }
//
////interface Search{
////    void search();
////}
//}
