import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class VWoutput {

    public void preRecall(String filename) throws IOException {
        InputStream inputFile1 = this.getClass().getResourceAsStream("predictions_1gram.txt");
        BufferedReader readFile1 = new BufferedReader(new InputStreamReader(inputFile1));

        String temp1 = " ";
        String file_line1="";
        int counter = 0;
        int rightClass1 =0;
        int wrongClass1 =0;
        int rightClass2 =0;
        int wrongClass2 =0;
        try {
            while ((file_line1 = readFile1.readLine()) != null) {
                float prob = Float.parseFloat(file_line1);
                 if (counter%2 == 0) {
                     if(prob > 0){
                         rightClass1 ++;
                     }else
                         wrongClass1++;
                 }
                 else  if( counter%2 == 1){
                     if(prob < 0){
                         rightClass2 ++;
                     }else
                         wrongClass2++;
                 }

                    counter ++;
                 }
            }
        catch (IOException e) {
            e.printStackTrace();

        }
        float presClas1 = (float)rightClass1/ ((float)wrongClass2 + (float)rightClass1);
        float recallcls1 = (float)rightClass1/ ((float)rightClass1+(float)wrongClass1);

        float presClas2 = (float)rightClass2/ ((float)wrongClass1 + (float)rightClass2);
        float recallcls2 = (float)rightClass2/ ((float)rightClass2+(float)wrongClass2);
        System.out.println("for" + " " +filename);
        System.out.printf("presicion of class1 in VW is: %f \n" , presClas1);
        System.out.printf("recall of class1 in VW is: %f \n" , recallcls1);

        System.out.printf("presicion of class2 in VW is: %f \n" , presClas2);
        System.out.printf("recall of class2 in VW is: %f \n" , recallcls2);

    }

    public static void main(String args[]) throws IOException {
        VWoutput vw = new VWoutput();
        vw.preRecall("predictions_1gram.txt");
       // vw.preRecall("predictions_5gram.txt");
    }

    }