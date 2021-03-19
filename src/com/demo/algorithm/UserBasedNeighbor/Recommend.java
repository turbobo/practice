package com.demo.algorithm.UserBasedNeighbor;

import java.util.*;

/*
* �����㷨--�Ƽ�
*
 * �����û���������㷨��User-Based Neighbor Algorithms������һ�ַǸ����Ե�Эͬ�����㷨��
 * Ҳ���Ƽ�ϵͳ��������ϣ����������㷨�����ǳ���Щ��Ȥ���Ƶ��û�Ϊ�ھӣ�����û�n�������û�u��
 * ���Ǿ�˵n��u��һ���ھӡ�����㷨������δ֪Ŀ���Ԥ���Ǹ��ݸ��û��������û�����������Ԥ���
 * */
public class Recommend {
 
    /**
     * �ڸ���username������£����������û������ľ��벢����
     * @param username
     * @param set
     * @return
     */
    private Map<Double, String> computeNearestNeighbor(String username, UserSet set) {
        Map<Double, String> distances = new TreeMap<>();
 
        UserSet.User u1 = set.getUser(username);
        for (int i = 0; i < set.users.size(); i++) {
            UserSet.User u2 = set.getUser(i);
 
            if (!u2.username.equals(username)) { //�ǵ�ǰ�û�
                double distance = pearson_dis(u2.list, u1.list);
                distances.put(distance, u2.username);
            }
 
        }
        System.out.println("distance => " + distances);
        return distances;
    }
 
 
    /**
     * ����2��������м��person����
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
        //�ҵ������
        Map<Double, String> distances = computeNearestNeighbor(username, set);
        String nearest = distances.values().iterator().next();
        System.out.println("nearest -> " + nearest);
 
 
        List<UserSet.Set> recommendations = new ArrayList<>();
 
        //�ҵ�����ڿ�������������û�����ĵ�Ӱ�������Ƽ�
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