package ogo.marcin.fluentapi;

import static ogo.marcin.fluentapi.FluentConditionals.*;
//Task 2
public class IfExecuteElseThrow {

    public static void main(String[] args) throws Throwable {

        when(TestHelper::somethingIsTrue)
                .then(TestHelper::printBar)
                .orElseThrowE(new RuntimeException());
        //'Bar' printed to console

        when(TestHelper::somethingIsTrue)
                .then(TestHelper::printBar)
                .orElseThrow(RuntimeException::new);
        //'Bar' printed to console

        when(TestHelper::somethingIsTrue)
                .then(TestHelper::printBar)
                .orElseThrow(TestHelper::createException);
        //'Bar' printed to console

        when(!TestHelper.somethingIsTrue())
                .then(TestHelper::printFoo)
                .orElseThrow(TestHelper::createException);
        //exception thrown
    }
}
