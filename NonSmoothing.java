import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.*;
import java.lang.*;

public  class NonSmoothing{
  //    private sortMapKey sortmap = new sortMapKey();
    //private FileSplitter fileSplitter = new FileSplitter();
    //private Cleaning cleaningUp = new Cleaning();
    private HashMap<String , Integer> mapClass1 ;
    private HashMap<String , Integer> mapClass2 ;
    private int wordNumbersClass1;
    private int wordNumbersClass2;

   /* public HashMap<String , Integer> getMap (){
        return  map;
    } */

    private HashMap<String  , Double> probabilitiesClass1 ;
    private HashMap<String , Double>  probabilitiesClass2;

    public String counter(String inputfile) throws FileNotFoundException, IOException {

        InputStream CleanedUpFile = getClass().getResourceAsStream(inputfile);
        BufferedReader readFile = new BufferedReader(new InputStreamReader(CleanedUpFile));
        PrintWriter file = null;
        file = new PrintWriter(new BufferedWriter(new  FileWriter(  "C:/Users/Heydari/Desktop/pr2/src/"+inputfile+"countWordsMap")));
        String inputLine = null;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Set<Map.Entry<String, Integer>> entrySet = null;

        try {
            while ((inputLine = readFile.readLine()) != null) {
                String[] words = inputLine.split("[ \n\t\r.,;:!?(){}]");

                for (int wordCounter = 0; wordCounter < words.length; wordCounter++) {
                    String key = words[wordCounter].toLowerCase();
                    if (key.length() > 0) {
                        if (map.get(key) == null) {
                            map.put(key, 1);
                        }
                        else {
                            int value = map.get(key).intValue();
                            value++;
                            map.put(key, value);
                        }
                    }
               entrySet = map.entrySet();

                }

            }
            if( inputfile.equals("eshghtokenscleanedUp")){
            this.mapClass1 =map;}
            else if( inputfile.equals("fekrtokenscleanedUp")){
                this.mapClass2 = map;
            }
            int allWords = 0;
            for(Map.Entry<String, Integer> entry : entrySet){
              allWords+=  entry.getValue();
            }
            if( inputfile.equals("eshghtokenscleanedUp")){
               this.wordNumbersClass1 = allWords;}

            else if( inputfile.equals("fekrtokenscleanedUp")){
                this.wordNumbersClass2 = allWords;;
            }

           // System.out.println("for file " + inputfile + ":");
           // System.out.printf("number of all words is %d \n" , allWords);
            for (Map.Entry<String, Integer> entry : entrySet) {

                //   sentences[i] = sentences[i].replaceAll(" ", "");
                file.println(entry.getValue() + "\t" + entry.getKey());

                //    System.out.println(entry.getValue() + "\t" + entry.getKey());
            }

        }
        catch (IOException error) {
            System.out.println("Invalid File");
        }

        finally {
            readFile.close();
file.close();

        }

  return inputfile+"countWordsMap";

    }

    public void probabilityFile(String inputFile) throws IOException {
        PrintWriter probFile = null;
        probFile = new PrintWriter(new BufferedWriter(new  FileWriter(  "C:/Users/Heydari/Desktop/pr2/src/"+inputFile+"probMap")));
        counter(inputFile);
        int wordNumbers;
        HashMap<String , Integer> map = new HashMap<String ,Integer>();
        HashMap<String , Double>  probs = new HashMap<String , Double>();
       if(inputFile.equals("eshghtokenscleanedUp")){
           map = mapClass1;
           wordNumbers=wordNumbersClass1;
       }
       else{
           map = mapClass2;
           wordNumbers=wordNumbersClass2;
       }
      //  HashMap<String ,Integer> numbers = getMap();

        Set<Map.Entry<String, Double>> entSet = null;
        String[] keys = new String[map.size()];
        int[] values = new int[map.size()];
int j = 0;
        for(Map.Entry<String,Integer> en : map.entrySet()){
          //  System.out.println( en.getKey());
            keys[j] = en.getKey();
            values[j]=en.getValue();
            j++;
        }
        double x = 0;
        for (int i=0 ; i< map.size() ; i ++){
            x = ((Math.log10(values[i]))  -  Math.log10(wordNumbers)) ;
            probs.put(keys[i], x);
         // System.out.println(x);
        }
entSet =  probs.entrySet();

        for (Map.Entry<String, Double> entry : entSet) {

            probFile.println(entry.getValue() + "\t" + entry.getKey());

            //    System.out.println(entry.getValue() + "\t" + entry.getKey());
        }
        probFile.close();
        if(inputFile.equals("eshghtokenscleanedUp")){
            probabilitiesClass1 =probs;
        }
        else{
            probabilitiesClass2 =probs;
        }

    }

    public void TestClass1NoneSmooth(){
        InputStream class1 = getClass().getResourceAsStream("testOfEshgh (3)");
        BufferedReader readFile = new BufferedReader(new InputStreamReader(class1));
        String inputLine = null;
        Set<Map.Entry<String, Double>> es1 = null;
        es1 =  probabilitiesClass1.entrySet();
        int wrongResult=0;
        int rightResult=0;
        Set<Map.Entry<String, Double>> es2 = null;
        es2 =  probabilitiesClass2.entrySet();

        try {
            while ((inputLine = readFile.readLine()) != null) {
               // System.out.println(inputLine);
                int counterx  =0;
                int countery=0;
                double probClass1=0;
                double probClass2=0;
                String[] words = inputLine.split("");
                for ( int i =0 ; i<words.length ; i++) {
                    loop1:
                    for (Map.Entry<String, Double> entry : es1) {
                        counterx++;
                        if (entry.getKey().equals(words[i])) {
                            probClass1 = +entry.getValue();
                            break loop1;
                        }
                    }

                    loop2:
                    for (Map.Entry<String, Double> entry : es2) {
                        countery++;
                        if (entry.getKey().equals(words[i])) {
                            probClass2 = +entry.getValue();
                            break loop2;
                        }

                    }

                }

                if(Math.abs(probClass1 )< Math.abs(probClass2)){
                    //  System.out.println("belogs to ClassOne");
                    rightResult++;
                }else{
                    //     System.out.println("belogs to ClassTwo");
                    wrongResult++;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Test of class1 nonsmoothing");
System.out.printf("right results : %d  \n" , rightResult);
        System.out.printf("wrong results : %d  \n" , wrongResult);
    }

    public void TestClass2NonSmooth(){
        InputStream class1 = getClass().getResourceAsStream("testOfFekr (2)");
        BufferedReader readFile = new BufferedReader(new InputStreamReader(class1));
        String inputLine = null;
        Set<Map.Entry<String, Double>> es1 = null;
        es1 =  probabilitiesClass1.entrySet();
        int wrongResult=0;
        int rightResult=0;
        Set<Map.Entry<String, Double>> es2 = null;
        es2 =  probabilitiesClass2.entrySet();

        try {
            while ((inputLine = readFile.readLine()) != null) {
                double probClass1=0;
                double probClass2=0;
                String[] words = inputLine.split("");
                for ( int i =0 ; i<words.length ; i++) {
                    outerloop:
                    for (Map.Entry<String, Double> entry : es1) {

                        if (entry.getKey().equals(words[i])) {
                            probClass1 = entry.getValue()  + probClass1;
                            break outerloop;
                        }

                    }
                    outlabel:
                    for (Map.Entry<String, Double> entry : es2) {
                        if (entry.getKey().equals(words[i])) {
                            probClass2 = entry.getValue() + probClass2;
                            break outlabel;
                        }

                    }
                }

                    if(Math.abs(probClass1 )< Math.abs(probClass2)){
                       // System.out.println("belogs to ClassOne");
                        wrongResult++;
                    }else{
                     //   System.out.println("belogs to ClassTwo");
                        rightResult++;
                    }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Test of class2 nonsmoothing");
        System.out.printf("right results : %d  \n" , rightResult);
        System.out.printf("wrong results : %d  \n" , wrongResult);
    }






    public static void main(String[] args) throws IOException {
        FileSplitter fileSplitter = new FileSplitter();
        Cleaning cleaningUp = new Cleaning();

        NonSmoothing w1 = new NonSmoothing();
       // WordCounter w2 = new WordCounter();
        fileSplitter.tokenizer("eshgh");
        cleaningUp.cleanUp("eshghtokens");
        w1.probabilityFile("eshghtokenscleanedUp");


        fileSplitter.tokenizer("fekr");
        cleaningUp.cleanUp("fekrtokens");
        w1.probabilityFile("fekrtokenscleanedUp");
        w1.TestClass1NoneSmooth();
       w1.TestClass2NonSmooth();


       //now test smoothing
        Smoothing sm = new Smoothing();
        sm.probabilityFile("eshghtokenscleanedUp");
        sm.probabilityFile("fekrtokenscleanedUp");

        sm.TestClass1Smooth();
        sm.TestClass2Smooth();


    }


}