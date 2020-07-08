package com.hmx;

/**
 * @ClassName Student
 * @Description TODO
 * @Author xin
 * @Date 2020/5/11 18:13
 * @Version 1.0
 **/
public class Student implements Comparable<Student> {
    private int score;
    private int age;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int score, int age) {
        this.score = score;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return age - o.age;
    }
}
