package ChinesePokerDealer$doudizhu_fapai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Dealer {
    private static final HashMap<Integer,String> all_poker = new HashMap<Integer, String>(54);

    public static void main(String[] args) {
        ArrayList<Integer> dealer = new ArrayList<>();
        all_poker.put(0,"🃏JOKER");
        all_poker.put(1,"🃏joker");
        dealer.add(0);
        dealer.add(1);

        String[] num = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        String[] color = {"♠","♥","♣","♦"};

        int count = 2;
        for (String num_ : num) {
            for (String color_ : color) {
                all_poker.put(count,color_+num_);
                dealer.add(count);
                count++; }
        }

        Collections.shuffle(dealer);

        ArrayList<Integer> player_01 = new ArrayList<>(17);
        ArrayList<Integer> player_02 = new ArrayList<>(17);
        ArrayList<Integer> player_03 = new ArrayList<>(17);

        while (dealer.size()>3){
            player_01.add(dealer.remove(0));
            player_02.add(dealer.remove(0));
            player_03.add(dealer.remove(0));
        }

        Collections.sort(player_01);
        Collections.sort(player_02);
        Collections.sort(player_03);

        play("Player1",player_01);
        play("Player2",player_02);
        play("Player3",player_03);
        play("Dibs",dealer);
    }

    private static void play(String player, ArrayList converter){
        System.out.print(player+": ");
        for (Object poker : converter) {
            System.out.print(all_poker.get(poker)+" ");
        }
        System.out.println();
    }
}
