import java.io.*;

public class Cleaning {


    public String cleanUp(String fileName) throws IOException {
        PrintWriter file = null;
        char[] chars = {'@','»','«','\f','.', ',', '?', '!', ':','؛' ,
                '"', ')', '(', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '؟',
                '،', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u'
                , 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' ,'-' ,'-'};


        InputStream inputFile = getClass().getResourceAsStream(fileName);
        BufferedReader readFile = new BufferedReader(new InputStreamReader(inputFile));
        String temp = "";
        String file_line;
        file = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Heydari/Desktop/pr2/src/"+fileName+"cleanedUp")));

        try {
            while ((file_line = readFile.readLine()) != null) {

                temp = file_line;
                temp = temp.replaceAll(" ", "");
                temp = temp.replace("ک", "ک");
                temp = temp.replaceAll("ي", "ی");
              // temp = temp.replaceAll("\u202C", "");
                //temp = temp.replaceAll("ﮐﻨﺪ\u202A ", "");
                temp = temp.replaceAll(  "ؤ", "و");
                temp = temp.replaceAll( "ﺮ" , "ر");


                for (int j = 0; j < temp.length(); j++) {
                    char s = temp.charAt(j);
                    for (int i = 0; i < chars.length; i++) {
                        if (chars[i] == s) {

                            temp = temp.replace(s, ' ');
//System.out.println(temp);
                        }

                    }

                }

                String empty="";
                for(int i=0 ; i<temp.length() ; i++){
                    if(temp.charAt(i)!=' '){
                        empty+= temp.charAt(i);
                    }

                }

                temp = empty;
                if (!temp.isEmpty()  && !temp.equals(
                        " "))  {
                    temp.replaceAll(" ","");

                file.println(temp);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        file.close();
return fileName+"cleanedUp";

    }
//test of cleaning class is commented below

/*   public static void main(String[] args) throws IOException {
        Cleaning w = new Cleaning();
        String s =  w.cleanUp("eshghsentences");
       String s2 =  w.cleanUp("fekrsentences");
        System.out.print(s);
    } */

}


