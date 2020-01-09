package co.gofun.java.sort;

import co.gofun.java.link.CreateLink;
import co.gofun.java.link.SinglyNode;

public class LinkSort {

    SinglyNode link = CreateLink.create();

    public static void main(String[] args) {


    }

    public void maoPao() {
        int count = 0;
        while (link.next != null) {
            count++;
        }

        for (int i = 0; i < count - 1; i++) {
            System.out.println("第" + (i + 1) + "轮");
//            flag = false;
            for (int j = 0; j < count - 1 - i; j++) {

            }
        }
    }

    public void sort() {

        SinglyNode pre = link;
        SinglyNode min = link.next;


        SinglyNode old = link.next;

        while (old.next != null) {

//            if()

        }
    }
}
