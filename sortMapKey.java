import java.util.*;
import java.util.Map.Entry;

/**
 * Created by nikeshjoshi on 4/4/17.
 */
public class sortMapKey {
    public void main(String args[]){
        Map<String,String> map = new HashMap<>();
        map.put("String1","1");
        map.put("String2","2");
        map.put("String3","3");
        map.put("String4","4");
        System.out.println(map);
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println(sortByValue(map));
    }
    public  Map<String,String> sortByValue(Map<String,String> map){
        Set<Entry<String, String>> set = map.entrySet();
        List<Entry<String, String>> list = new ArrayList<Entry<String, String>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, String>>()
        {
            public int compare( Map.Entry<String, String> o1, Map.Entry<String, String> o2 )
            {
                return (o1.getValue()).compareTo( o2.getValue() );
            }
        } );
        Map<String,String> output = new LinkedHashMap<>();
        for(Entry<String,String> entry : list){
            output.put(entry.getKey(),entry.getValue());
        }
        return output;
    }
}