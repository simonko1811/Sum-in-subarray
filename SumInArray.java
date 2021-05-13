import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
 
class ZeroSumSubarray
{
    static Boolean subArrayExists(ArrayList<Integer> array)
    {
        Set<Integer> intSet = new HashSet<Integer>();
        int sum = 0;

        for (int i = 0; i < array.size(); i++)
        {
            sum = sum + array.get(i);

            // check all possibilities, even 0 and 10
            if (array.get(i) == 0 || sum == 0 || intSet.contains(sum))
                return true;
 
                intSet.add(sum);
        }

        return false;
    }
 
    // main
    public static void main(String arg[]) throws IOException
    {
        Reader myFile = new FileReader("input.txt");
        FileWriter fw = new FileWriter("output.txt");

        try{            
            BufferedReader br = new BufferedReader(myFile);
            String line;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");
                ArrayList<Integer> intNums = new ArrayList<Integer>();
                for (String s : numbers){
                    intNums.add(Integer.parseInt(s));
                }

                if (subArrayExists(intNums))
                    fw.write("yes");
                else
                    fw.write("no");

                fw.write("\r\n");
            }
            myFile.close();
            br.close();
            fw.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}