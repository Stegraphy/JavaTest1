package Exam1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BuildList {
    public List<Integer> buildFactory();
    public Map<Integer, ArrayList> ListToMap(List<Integer> list);
}
