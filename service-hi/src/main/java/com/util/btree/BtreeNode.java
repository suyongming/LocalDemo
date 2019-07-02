package com.util.btree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BtreeNode {
//    6 10 4 14 5 11 15 3 2 12 1 7 8 8 6 3 6 21 5 15 15 6 32 23 45 65 7 8 6 5 4
    private List<BtreeNode> childList = new ArrayList<>(m);

    private int level;

    private String key;

    private String value;

    private static int m = 3;

    public void push(BtreeNode btree){

    }

}
