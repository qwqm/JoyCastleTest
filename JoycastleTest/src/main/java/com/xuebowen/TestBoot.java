package com.xuebowen;

public class TestBoot {
    public static void main(String[] args) {  
        //示例，添加玩家到排行榜并查询排名  
//        Player player1 = new Player(1, 810, System.currentTimeMillis(), "哈哈", 100);  
        Player player2 = new Player(2, 820, System.currentTimeMillis(), "哈哈", 100);  
//        Player player3 = new Player(3, 830, System.currentTimeMillis(), "哈哈", 100);  
  
        Player player4 = new Player(4, 820, 66666, "哈哈", 100);  
        Player player5 = new Player(5, 820, 666667, "哈哈", 100);  
        Player player6 = new Player(6, 820, 66666, "哈哈", 99);  
        Player player7 = new Player(7, 820, 66666, "a哈哈", 100);  
//        BucketSortRanking.addPlayer(player1);  
        BucketSortRanking.addPlayer(player2);  
//        BucketSortRanking.addPlayer(player3);  
        BucketSortRanking.addPlayer(player4);  
        BucketSortRanking.addPlayer(player5);  
        BucketSortRanking.addPlayer(player6);  
        BucketSortRanking.addPlayer(player6);  
        BucketSortRanking.addPlayer(player7);  
        
        System.out.println("Player 1 Rank: " + BucketSortRanking.getPlayerRank(1));  
        System.out.println("Player 2 Rank: " + BucketSortRanking.getPlayerRank(2));
        System.out.println("Player 3 Rank: " + BucketSortRanking.getPlayerRank(3));
        System.out.println("Player 4 Rank: " + BucketSortRanking.getPlayerRank(4));  
        System.out.println("Player 5 Rank: " + BucketSortRanking.getPlayerRank(5));
        System.out.println("Player 6 Rank: " + BucketSortRanking.getPlayerRank(6));
        System.out.println("Player 7 Rank: " + BucketSortRanking.getPlayerRank(7));
    }
}
