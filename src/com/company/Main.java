package com.company;

//웜 바이러스

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Node> box = new ArrayList<>();
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //총 몇개의 숫자를 입력 받을 것인지
        int a;
        int b;
        int c = 0;
        int d = 0;

        a = sc.nextInt();

        for (int i = 1; i <= a; i++) {
            Node node = new Node(i);
            box.add(node);
        }

        b = sc.nextInt();

        for (int i = 0; i < b; i++) {
            c = sc.nextInt();
            d = sc.nextInt();
            box.get(c - 1).getNodes().add(box.get(d - 1));
        }

        box.get(0).setChecked(true);

        System.out.println(Warm(box.get(0)));

    }

    public static int Warm(Node node) {

        int count = 1;

        if (!node.isChecked()) {
            node.setChecked(true);
        } else {
            count--;
            if (node.getData() != 1) return count;
        }

        for (int i = 0; i < node.getNodes().size(); i++) {
            count += Warm(node.getNodes().get(i));
        }

        return count;
    }


}


class Node {

    private boolean isChecked;
    private int data;
    private ArrayList<Node> nodes;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public Node(int data) {
        this.setChecked(false);
        this.data = data;
        nodes = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
}






