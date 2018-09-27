import java.io.*;

public class FileSplitter {

    public String tokenizer(String fileName) throws IOException {

        InputStream inputFile = getClass().getResourceAsStream(fileName);
        BufferedReader readFile = new BufferedReader(new InputStreamReader(inputFile));
        PrintWriter file = null;
       // file = new PrintWriter(new BufferedWriter(new  FileWriter("./"+fileName+"tokens")));
        file = new PrintWriter(new BufferedWriter(new  FileWriter("C:/Users/Heydari/Desktop/pr2/src/"+fileName+"tokens")));
        String temp ="";
        String file_line;

        try {
            int count = 0;
            while ((file_line = readFile.readLine()) != null) {

                temp=file_line;
             //   temp=temp.replaceAll("\u200C","");
              //  String[] sentences = file_line.split("(?<=[.,!?])\\s*");
                String[] sentences = file_line.split("(?<=[.,!? ])\\s*");
             //   for(int i =0 ; i< sentences.length ; i++){
               //     System.out.println(sentences[i]);}
                for(int i=0; i < sentences.length; i++){
                    file.println(sentences[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        file.close();
      return fileName+"tokens";

    }


    public String sentenceBreaker(String filename) throws IOException {
        PrintWriter file = null;
        file = new PrintWriter(new BufferedWriter(new  FileWriter("D:/NLP/pr2/src/"+filename+"sentences")));
        //  file.close();


        InputStream inputFile = getClass().getResourceAsStream(filename);
        BufferedReader readFile = new BufferedReader(new InputStreamReader(inputFile));
        String temp ="";
        String file_line;

        try {
            int count = 0;
            while ((file_line = readFile.readLine()) != null) {

                temp=file_line;
              //  temp=temp.replace("\u200C"," ");
                String[] sentences = file_line.split("(?<=[.!?])\\s*");
                for(int i =0 ; i< sentences.length ; i++){
System.out.println(sentences[i]);}
                for(int i=0; i < sentences.length; i++){
                 //   sentences[i] = sentences[i].replaceAll(" ", "");
                    file.println(sentences[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

        file.close();
    return  filename+"sentences";

    }


    //test of file splitter is here
  /*   public static void main(String[] args) throws IOException {
        FileSplitter w = new FileSplitter();
      String s =  w.sentenceBreaker("fekr");
         String s2 =  w.sentenceBreaker("eshgh");
System.out.print(s);
    }*/

}
