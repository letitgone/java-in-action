package lombok.test;

import lombok.test.pojo.Person;

/**
 * @Author ZhangGJ
 * @Date 2019/10/16
 */
public class Test {
    private Person person;

    public Person getName(Person person){
        person.setClassName(person.getClassName());
        person.setClassname(person.getClassname());
        return person;
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setClassname("小写");
        p.setClassName("大写");
        new Test().getName(p);
    }
}
