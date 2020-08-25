import java.io.*;

public class MalletInput {

    public void readyForMalletTrain(String fileName) throws IOException {
        InputStream inputFile = this.getClass().getResourceAsStream(fileName);
        BufferedReader readFile = new BufferedReader(new InputStreamReader(inputFile));

        PrintWriter trainFile = null;
        trainFile = new PrintWriter(new BufferedWriter(new FileWriter("D:/NLP/Mallet/src/" + "malletTrain.txt")));
        String file_line = "";
       int lineCounter=0;
        while ((file_line = readFile.readLine()) != null) {
            String input="";
            lineCounter++;
        if ( file_line.startsWith("1")){
            file_line=file_line.replace("1", "");
            file_line=file_line.replace("|", "");
            String[] senteces = file_line.split(" ");
            System.out.println(file_line);


            input = "line"+lineCounter+" "+"class1"+" "+"f1"+" "+senteces[senteces.length-2]
            +" "+"f2"+" "+senteces[senteces.length-3];
              trainFile.println(input);

        }else if(file_line.startsWith("-")){
            file_line=file_line.replace("-1", "");
            file_line=file_line.replace("|", "");
            String[] senteces = file_line.split(" ");

        //            " "+"f2"+senteces[4]+" "+"f3"+" "+senteces[senteces.length];
            input = "line"+lineCounter+" "+"class2"+" "+"f1"+" "+senteces[senteces.length-2]
                    +" "+"f2"+" "+senteces[senteces.length-3];
            trainFile.println(input);}

        }
        trainFile.close();
        }


   /* public void readyForMalletTest(String fileName) throws IOException {
        InputStream inputFile = this.getClass().getResourceAsStream(fileName);
        BufferedReader readFile = new BufferedReader(new InputStreamReader(inputFile));

        PrintWriter trainFile = null;
        trainFile = new PrintWriter(new BufferedWriter(new FileWriter("D:/NLP/Mallet/src/" + "malletTest.txt")));
        String file_line = "";
        int lineCounter=0;
        while ((file_line = readFile.readLine()) != null) {
            String input="";
            lineCounter++;
            if ( file_line.startsWith("1")){
                file_line=file_line.replace("1", "");
                file_line=file_line.replace("|", "");
                String[] senteces = file_line.split(" ");
                System.out.println(file_line);


                input = "line"+lineCounter+" "+"class1"+" "+"f1"+" "+senteces[senteces.length-2]
                        +" "+"f2"+" "+senteces[senteces.length-3];
                trainFile.println(input);

            }else if(file_line.startsWith("-")){
                file_line=file_line.replace("-1", "");
                file_line=file_line.replace("|", "");
                String[] senteces = file_line.split(" ");

                //            " "+"f2"+senteces[4]+" "+"f3"+" "+senteces[senteces.length];
                input = "line"+lineCounter+" "+"class2"+" "+"f1"+" "+senteces[senteces.length-2]
                        +" "+"f2"+" "+senteces[senteces.length-3];
                trainFile.println(input);}

        }
        trainFile.close();
    }  */

    public static  void main(String[] args) throws IOException {
        MalletInput mallet = new MalletInput();
        mallet.readyForMalletTrain("VWtrain");

    }

}
