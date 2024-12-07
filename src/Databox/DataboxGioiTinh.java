package Databox;

import java.util.ArrayList;
import java.util.List;

public class DataboxGioiTinh {

    private static List<String> data = new ArrayList<>();
    
    public static List<String> getData(){
        data.add("Nam");
        data.add("Nữ");
        data.add("Khác");
        return data;
    }
}
