package com.demo.algorithm.UserBasedNeighbor;

import java.util.ArrayList;
import java.util.List;

/*
* 数据集合
* */

public class UserSet {

    //所有用户集合
    public List<User> users = new ArrayList<>();

    public UserSet() {
    }

    public User put(String username) {
        return new User(username);
    }

    //获得指定位置用户
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
        public String username;     //用户名
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
        public String username;    //电影名
        public int score;        //评分

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
