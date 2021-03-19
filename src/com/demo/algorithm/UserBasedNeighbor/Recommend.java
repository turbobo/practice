package com.demo.algorithm.UserBasedNeighbor;

import java.util.*;

/*
* 核心算法--推荐
*
 * 基于用户的最近邻算法（User-Based Neighbor Algorithms），是一种非概率性的协同过滤算法，
 * 也是推荐系统中最最古老，最著名的算法，我们称那些兴趣相似的用户为邻居，如果用户n相似于用户u，
 * 我们就说n是u的一个邻居。起初算法，对于未知目标的预测是根据该用户的相似用户的评分作出预测的
 * */
public class Recommend {
 
    /**
     * 在给定username的情况下，计算其他用户和它的距离并排序
     * @param username
     * @param set
     * @return
     */
    private Map<Double, String> computeNearestNeighbor(String username, UserSet set) {
        Map<Double, String> distances = new TreeMap<>();
 
        UserSet.User u1 = set.getUser(username);
        for (int i = 0; i < set.users.size(); i++) {
            UserSet.User u2 = set.getUser(i);
 
            if (!u2.username.equals(username)) { //非当前用户
                double distance = pearson_dis(u2.list, u1.list);
                distances.put(distance, u2.username);
            }
 
        }
        System.out.println("distance => " + distances);
        return distances;
    }
 
 
    /**
     * 计算2个打分序列间的person距离
     *
     * @param rating1
     * @param rating2
     * @return
     */
    private double pearson_dis(List<UserSet.Set> rating1, List<UserSet.Set> rating2) {
        int sum_xy = 0;
        int sum_x = 0;
        int sum_y = 0;
        double sum_x2 = 0;
        double sum_y2 = 0;
        int n = 0;
        for (int i = 0; i < rating1.size(); i++) {
            UserSet.Set key1 = rating1.get(i);
            for (int j = 0; j < rating2.size(); j++) {
                UserSet.Set key2 = rating2.get(j);
                if (key1.username.equals(key2.username)) {
                    n += 1;
                    int x = key1.score;
                    int y = key2.score;
                    sum_xy += x * y;
                    sum_x += x;
                    sum_y += y;
                    sum_x2 += Math.pow(x, 2);
                    sum_y2 += Math.pow(y, 2);
                }
 
            }
        }
        double denominator = Math.sqrt(sum_x2 - Math.pow(sum_x, 2) / n) * Math.sqrt(sum_y2 - Math.pow(sum_y, 2) / n);
        if (denominator == 0) {
            return 0;
        } else {
            return (sum_xy - (sum_x * sum_y) / n) / denominator;
        }
    }
 
 
    public List<UserSet.Set> recommend(String username, UserSet set) {
        //找到最近邻
        Map<Double, String> distances = computeNearestNeighbor(username, set);
        String nearest = distances.values().iterator().next();
        System.out.println("nearest -> " + nearest);
 
 
        List<UserSet.Set> recommendations = new ArrayList<>();
 
        //找到最近邻看过，但是我们没看过的电影，计算推荐
        UserSet.User neighborRatings = set.getUser(nearest);
        System.out.println("neighborRatings -> " + neighborRatings.list);
 
        UserSet.User userRatings = set.getUser(username);
        System.out.println("userRatings -> " + userRatings.list);

        for (UserSet.Set artist : neighborRatings.list) {
            if (userRatings.find(artist.username) == null) {
                recommendations.add(artist);
            }
        }
        Collections.sort(recommendations);
        System.out.println("recommendations -> " + recommendations.toString());
        return recommendations;
    }
 
 
}