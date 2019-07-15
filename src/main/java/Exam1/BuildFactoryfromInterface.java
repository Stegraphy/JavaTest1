package Exam1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildFactoryfromInterface implements BuildList {
    public List<Integer> buildFactory() {
        List<Integer> list = new ArrayList<Integer>();

        // 生成50个0~100内的随机数，存放到一个ArrayList中

            for (int i = 0; i < 50; i++) {
                int ii = (int) ((Math.random()) * 101);
                list.add(ii);
            }
            return list;
    }

    public Map<Integer, ArrayList> ListToMap(List<Integer> list) {
//        List<Integer> list = new BuildFactoryfromInterface().buildFactory();
        List<Integer> ll =new ArrayList<Integer>();
        //将数字/10，转换为map形式
        Map<Integer,ArrayList> map = new HashMap<Integer,ArrayList>();
        for (int i = 0; i <list.size() ; i++) {
//            System.out.println(list.get(i));
            List<Integer> newList = new ArrayList<Integer>();
                    newList.add(list.get(i));
            for (int j = 0; j <list.size() ; j++) {
                map.put((list.get(i)/10), (ArrayList) newList);
            }

        }


        return map;
    }
}
