import java.io.*;

public class VWready {

    public void readyForVW() throws IOException {
        InputStream inputFile1 = this.getClass().getResourceAsStream("fekrsentencescleaned");
        BufferedReader readFile1 = new BufferedReader(new InputStreamReader(inputFile1));

        String temp1 = " ";
        InputStream inputFile2 = this.getClass().getResourceAsStream("eshghsentencescleaned");
        BufferedReader readFile2 = new BufferedReader(new InputStreamReader(inputFile2));
        String temp2 = " ";

        PrintWriter file = null;
        file = new PrintWriter(new BufferedWriter(new FileWriter("D:/NLP/VW/src/" + "VWInput")));

        String file_line1;
        String file_line2;
        try {
            while ((file_line1 = readFile1.readLine()) != null) {


                file.println("1" + " " + "|" + file_line1);

               // file.println(file_line1 + " 1");
                file_line2 = readFile2.readLine();

                    file.println("-1" + " " + "|" + file_line2);


               // file_line2 = readFile2.readLine();
            //   file.println("-1" + " " + "|" + file_line2);

            }

        }
        catch (IOException e) {
            e.printStackTrace();

        }

        file.close();
    }

    public void CreateTrainTestFile() throws IOException {
        InputStream inputFile1 = this.getClass().getResourceAsStream("VWInput");
        BufferedReader readFile1 = new BufferedReader(new InputStreamReader(inputFile1));

        PrintWriter trainFile = null;
        trainFile = new PrintWriter(new BufferedWriter(new FileWriter("D:/NLP/VW/src/" + "VWtrain")));
        String  file_line1="";


        PrintWriter testFile = null;
        testFile = new PrintWriter(new BufferedWriter(new FileWriter("D:/NLP/VW/src/" + "VWtest")));

        for(int i=8900 ; i>0 ;i--){
        file_line1  = readFile1.readLine();
        trainFile.println(file_line1);
        }
        while ((file_line1 = readFile1.readLine()) != null) {
           testFile.println(file_line1);
        }
        trainFile.close();
        testFile.close();
    }

    public static void main(String[] args) throws IOException {

        sentenceBreaker w = new sentenceBreaker();
        String s =  w.sentenceBreaker("fekr");
        String s2 =  w.sentenceBreaker("eshgh");

        SentenceCleaner w2 = new SentenceCleaner();
        String ss =  w2.cleanTests("eshghsentences");
        String ss2 =  w2.cleanTests("fekrsentences");
        VWready vw = new VWready();
        vw.readyForVW();

        vw.CreateTrainTestFile();
    }
}