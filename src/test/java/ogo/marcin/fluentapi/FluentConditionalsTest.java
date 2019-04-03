package ogo.marcin.fluentapi;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 * @author Marcin Ogorzalek
 */

@Test
public class FluentConditionalsTest {

//    TODO: test with Mockito
//    TODO: learn Mockito
    public void testFluentConditionalThen() {
        Runnable r1 = Mockito.mock(Runnable.class);
        Runnable r2 = Mockito.mock(Runnable.class);

        FluentConditionals.when(true).then(r1).orElse(r2);
        Mockito.verify(r1).run();
        Mockito.verify(r2, Mockito.never()).run();
    }

    public void testFluentConditionalOrElse() {
        Runnable r1 = Mockito.mock(Runnable.class);
        Runnable r2 = Mockito.mock(Runnable.class);

        FluentConditionals.when(false).then(r1).orElse(r2);
        Mockito.verify(r1, Mockito.never()).run();
        Mockito.verify(r2).run();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testFluentConditionalThrowRuntimeException() throws Throwable {
        Runnable r1 = Mockito.mock(Runnable.class);
        FluentConditionals.when(false).then(r1).orElseThrowE(new RuntimeException());
    }
}