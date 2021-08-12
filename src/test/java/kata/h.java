package kata;

import java.util.*;

public class h {
    public static void sortByValue() {
        Map<String,String> map = new TreeMap<String,String>();
        map.put("a", "dddd");
        map.put("d", "aaaa");
        map.put("b", "cccc");
        map.put("c", "bbbb");

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, String> e: list) {
            System.out.println(e.getKey()+":"+e.getValue());
        }
    }
}
