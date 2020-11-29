package ChinesePokerDealer$doudizhu_fapai;

import java.util.ArrayList;
import java.util.Collections;

public class Dealer_ {
    public static void main(String[] args) {
        final ArrayList<String> all_poker = new ArrayList<>(54);
        Collections.addAll(all_poker, "🃏JOKER", "🃏joker");

        final ArrayList<String> num = new ArrayList<>();
        Collections.addAll(num,
                "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        final ArrayList<String> color = new ArrayList<>();
        Collections.addAll(color,"♠","♥","♣","♦");

        for (String num_ : num) {
            for (String color_ : color) {
                Collections.addAll(all_poker,color_+num_);}
        }

        //-------------------------------------------------------
//        final HashMap<Integer,String> All_POKER = new HashMap<>();
//        int sequence = 0;
//
//        for (String poker : all_poker) {
//            All_POKER.put(sequence++,poker);
//        }

        // System.out.println(All_POKER);
        //-------------------------------------------------------

        Collections.shuffle(all_poker);

        ArrayList<String> player_01 = new ArrayList<>(17);
        ArrayList<String> player_02 = new ArrayList<>(17);
        ArrayList<String> player_03 = new ArrayList<>(17);

        while (all_poker.size() > 3){
            player_01.add(all_poker.remove(0));
            player_02.add(all_poker.remove(0));
            player_03.add(all_poker.remove(0));
        }

        // Collections.sort(player_01);
        // Collections.sort(player_02);
        // Collections.sort(player_03);

        System.out.println(player_01);
        System.out.println(player_02);
        System.out.println(player_03);
        System.out.println(all_poker);
    }
}
