package Exam1;

import org.junit.Test;

import java.util.*;

public class ListToMap {
    List<Integer> list = new BuildFactoryfromInterface().buildFactory();

@Test
    public void ListSortToMap(){
    Map<Integer,ArrayList> map  = new BuildFactoryfromInterface().ListToMap(list);
    Iterator<Map.Entry<Integer, ArrayList>> it = map.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry<Integer, ArrayList> entry = it.next();
        System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
    }
    }
}
  /*  //使用ArrayList实现一个Key对应一个ArrayList实现一对多
    public static void putAdd(String sr,String[] s){
        if(!m.containsKey(sr)){
            m.put(sr, new ArrayList<String>());
        }
        for(int i=0;i<s.length;i++){
            m.get(sr).add(s[i]);
        }
    }*/