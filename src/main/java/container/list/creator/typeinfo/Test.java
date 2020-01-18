package container.list.creator.typeinfo;

import container.list.creator.typeinfo.pets.Pet;
import container.list.creator.typeinfo.pets.Pets;

import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2020/01/19 06:28
 */
public class Test {

    public static void main(String[] args) {
        List<Pet> list = Pets.arrayList(10);
        System.out.println(list);
    }
}
