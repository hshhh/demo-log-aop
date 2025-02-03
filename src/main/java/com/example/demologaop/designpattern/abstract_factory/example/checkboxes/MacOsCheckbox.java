package com.example.demologaop.designpattern.abstract_factory.example.checkboxes;

/**
 * All products families have the same varieties (MacOS/Windows).
 * This is another variant of MacOSCheckbox.
 *
 * @author huangshihao
 */
public class MacOsCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox");
    }
}
