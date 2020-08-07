package com.hmx.sort;

/**
 * @program: eoms-workflow
 * @description:
 * @author: HeMingXin
 * @create: 2020/8/6 10:33
 **/
public class CountingSort extends Sort<Integer> {


    @Override
    protected void sort() {
        //找出最值
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }

        //开辟空间，存储次数
        int[] counts = new int[max - min + 1];

        //根据新的统计表获得索引
        for (int i = 0; i < array.length; i++) {
            counts[array[i] - min]++;
        }

        //累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[ i - 1];
        }

        //从后往前便利元素，让其放入有序数组的适应位置
        int[] newArray = new int[array.length];
        //减去数组中最小的元素找到对应索引然后-1就是适合位置
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[--counts[array[i] - min]] = array[i];
        }

        //将有序数据复制到array
        for (int i = 0; i < newArray.length; i++) {
            array[i]  = newArray[i];
        }
    }

    private void sort0(){
        //找出最大值确定数组长度
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        //所需要的数组
        int[] counts = new int[1 + max];
        //统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }

        //根据出现次数，对整数进行排序
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            //判断counts的数据是否放入数组
            while (counts[i]-- > 0) {
                array[index++] = i;
            }
        }
    }

    public static void main(String[] args){
        Person[] people = new Person[]{
                new Person(20,"A"),
                new Person(-20,"B"),
                new Person(13,"C"),
                new Person(-14,"D"),
                new Person(-14,"E"),
                new Person(30,"F"),
        };

        //找出最值
        int max = people[0].age;
        int min = people[0].age;
        for (int i = 0; i < people.length; i++) {
            if(people[i].age > max){
                max = people[i].age;
            }
            if(people[i].age < min){
                min = people[i].age;
            }
        }

        //开辟空间，存储次数
        int[] counts = new int[max - min + 1];

        //根据新的统计表获得索引
        for (int i = 0; i < people.length; i++) {
            counts[people[i].age - min]++;
        }

        //累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[ i - 1];
        }

        //从后往前便利元素，让其放入有序数组的适应位置
        Person[] newArray = new Person[people.length];
        //减去数组中最小的元素找到对应索引然后-1就是适合位置
        for (int i = people.length - 1; i >= 0; i--) {
            newArray[--counts[people[i].age - min]] = people[i];
        }

        //将有序数据复制到array
        for (int i = 0; i < newArray.length; i++) {
            people[i]  = newArray[i];
        }

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }

    private static class Person{
        int age;
        String name;
        Person(int age, String name){
            this.age = age;
            this.name = name;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
