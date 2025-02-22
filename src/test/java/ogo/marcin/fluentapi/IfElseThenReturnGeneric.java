package ogo.marcin.fluentapi;

import static ogo.marcin.fluentapi.FluentConditionals.*;

//Task 5
public class IfElseThenReturnGeneric {

    public static void main(String[] args) throws Throwable {
        String string =
                when(TestHelper::somethingIsTrue)
                .thenReturn("Yay")
                .orElse("Nah");
        System.out.println(string);//Yay

        SomeClass customObject =
                when(TestHelper::somethingIsTrue)
                .thenReturn(new SomeClass())
                .orElse(SomeClass::new);
        System.out.println(customObject);//SomeClass@723279cf

        SomeClass customObject2 =
                when(!TestHelper.somethingIsTrue())
                        .thenReturn(SomeClass::new)
                        .orElseThrow(RuntimeException::new);
        //exception thrown
    }
}
