package design.pattern.factory.abastract.impl;

import design.pattern.factory.abastract.INote;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */

public class PythonNote implements INote {

    @Override
    public void edit() {
        System.out.println("python笔记");
    }
}
