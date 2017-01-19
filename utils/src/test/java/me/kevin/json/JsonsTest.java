package me.kevin.json;

import com.fasterxml.jackson.databind.JavaType;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/19.
 */
public class JsonsTest {
    private Jsons jsonNormal;
    private Jsons jsonNoneEmpty;
    private Jsons jsonNoneDef;
    private Person p1;
    private Person p2;
    private List<Person> persons;

    @Before
    public void init() {
        jsonNormal = new Jsons();
        jsonNoneEmpty = Jsons.nonEmptyMapper();
        jsonNoneDef = Jsons.nonDefaultMapper();
        p1 = new Person();
        p2 = new Person();
        persons =new ArrayList<>();

        p1.setName("kevin");

        p2.setName("chris");
        p2.setAge(1);
        p2.setAddr("gd.sz");
        p2.setSex(Sex.MALE);
        List<String> hobby = new ArrayList<>();
        hobby.add("play pingpong");
        hobby.add("play basketball");
        hobby.add("swim");
        p2.setHobby(hobby);

        persons.add(p1);
        persons.add(p2);
    }

    @Test
    public void jsonNomalTest() {
        // print out all
        String s1 = jsonNormal.toJson(p1);
        String s2 = jsonNormal.toJson(p2);
        String s3 = jsonNormal.toJson(persons);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        Person pp1 = jsonNormal.fromJson(s1, Person.class);
        Person pp2 = jsonNormal.fromJson(s2,Person.class);

        assertThat(p1).isEqualToIgnoringNullFields(pp1);
        assertThat(p2).isEqualToComparingFieldByField(pp2);

        JavaType javaType = jsonNormal.contructCollectionType(List.class,Person.class);
        List<Person> pp3 = jsonNormal.fromJson(s3,javaType);
        System.out.println(pp3);
        assertThat(persons).hasSize(2);
    }

    @Test
    public void jsonNoneEmptyTest() {
        // always print out without null value
        String s1 = jsonNoneEmpty.toJson(p1);
        String s2 = jsonNoneEmpty.toJson(p2);
        String s3 = jsonNoneEmpty.toJson(persons);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        Person pp1 = jsonNoneEmpty.fromJson(s1, Person.class);
        Person pp2 = jsonNoneEmpty.fromJson(s2,Person.class);

        assertThat(p1).isEqualToIgnoringNullFields(pp1);
        assertThat(p2).isEqualToComparingFieldByField(pp2);

        JavaType javaType = jsonNoneEmpty.contructCollectionType(List.class,Person.class);
        List<Person> pp3 = jsonNoneEmpty.fromJson(s3,javaType);
        System.out.println(pp3);
        assertThat(persons).hasSize(2);
    }

    @Test
    public void jsonNoneDefTest() {
        // noneDefault print out without init value
        String s1 = jsonNoneDef.toJson(p1);
        String s2 = jsonNoneDef.toJson(p2);
        String s3 = jsonNoneDef.toJson(persons);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        Person pp1 = jsonNoneDef.fromJson(s1, Person.class);
        Person pp2 = jsonNoneDef.fromJson(s2,Person.class);

        assertThat(p1).isEqualToIgnoringNullFields(pp1);
        assertThat(p2).isEqualToComparingFieldByField(pp2);

        JavaType javaType = jsonNoneDef.contructCollectionType(List.class,Person.class);
        List<Person> pp3 = jsonNoneDef.fromJson(s3,javaType);
        System.out.println(pp3);
        assertThat(persons).hasSize(2);
    }
}

class Person {

    private String name;
    private int age;
    private Sex sex;
    private String addr;
    private List<String> hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", addr='" + addr + '\'' +
                ", hobby=" + hobby +
                '}';
    }
}

enum Sex {
    MALE, FEMALE
}