import java.io.*;

public class CleaningTestFiles {


    public String cleanTests(String fileName) throws IOException {
        PrintWriter file = null;
        char[] chars = {'@','»','«','\f','.', ',', '?', '!', ':','؛' ,
                '"', ')', '(', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '؟',
                '،', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u'
                , 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' ,'-' ,'-'};


        InputStream inputFile = getClass().getResourceAsStream(fileName);
        BufferedReader readFile = new BufferedReader(new InputStreamReader(inputFile));
        String t = "";
        String file_line;
        file = new PrintWriter(new BufferedWriter(new FileWriter("D:/NLP/pr2/src/"+fileName+"cleanedUp")));

        try {
            while ((file_line = readFile.readLine()) != null) {

                t = file_line;
                String curr=" ";
                String[] temp = t.split(" ");
                for (int m = 0; m < temp.length; m++){

                    temp[m] = temp[m].replaceAll(" ", "");
                    temp[m] = temp[m].replace("ک", "ک");
                    temp[m] = temp[m].replaceAll("ي", "ی");
                // temp = temp.replaceAll("\u202C", "");
                //temp = temp.replaceAll("ﮐﻨﺪ\u202A ", "");
                    temp[m] = temp[m].replaceAll("ؤ", "و");
                    temp[m] = temp[m].replaceAll("ﺮ", "ر");


                for (int j = 0; j < temp[m].length(); j++) {
                    char s = temp[m].charAt(j);
                    for (int i = 0; i < chars.length; i++) {
                        if (chars[i] == s) {

                            temp[m] = temp[m].replace(s, ' ');
//System.out.println(temp);
                        }

                    }

                }

                String empty = "";
                for (int i = 0; i < temp[m].length(); i++) {
                    if (temp[m].charAt(i) != ' ') {
                        empty += temp[m].charAt(i);
                    }

                }

                    temp[m] = empty;
                if (!temp[m].isEmpty() && !temp[m].equals(
                        " ")) {
                    temp[m].replaceAll(" ", "");


                }
                curr += temp[m]+" ";
            }
                file.println(curr);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        file.close();
        return fileName+"testCleared";

    }
//test of cleaning class is commented below

    public static void main(String[] args) throws IOException {
        CleaningTestFiles w = new CleaningTestFiles();
        String s =  w.cleanTests("testOfEshgh");
        String s2 =  w.cleanTests("testOfFekr");
        System.out.print(s);
    }

}


