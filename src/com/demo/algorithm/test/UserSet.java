package com.demo.algorithm.test;

import java.util.ArrayList;
import java.util.List;
/*
* 基于用户的最近邻算法（User-Based Neighbor Algorithms），是一种非概率性的协同过滤算法，
* 也是推荐系统中最最古老，最著名的算法，我们称那些兴趣相似的用户为邻居，如果用户n相似于用户u，
* 我们就说n是u的一个邻居。起初算法，对于未知目标的预测是根据该用户的相似用户的评分作出预测的
* */

public class UserSet {

    public List<User> users = new ArrayList<>();

    public UserSet() {
    }

    public User put(String username) {
        return new User(username);
    }


    public User getUser(int position) {
        return users.get(position);
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }


    public final class User {
        public String username;
        public List<Set> list = new ArrayList<>();

        private User(String username) {
            this.username = username;
        }

        public User set(String username, int score) {
            this.list.add(new Set(username, score));
            return this;
        }

        public void create() {
            users.add(this);
        }

        public Set find(String username) {
            for (Set set : list) {
                if (set.username.equals(username)) {
                    return set;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    '}';
        }
    }

    public final class Set implements Comparable<Set> {
        public String username;
        public int score;

        public Set(String username, int score) {
            this.username = username;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Set{" +
                    "username='" + username + '\'' +
                    ", score=" + score +
                    '}';
        }

        @Override
        public int compareTo(Set o) {
            return score > o.score ? -1 : 1;
        }
    }

}
