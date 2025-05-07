package Backbone;
import java.util.*;

public interface FileIO {
    public void writeBal(String nameBal, String category, double expense);
    public ArrayList<String[]> readBal();
}

