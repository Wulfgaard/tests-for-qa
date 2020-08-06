import interfaces.MainPage;
import interfaces.Selector;
import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class MethodInterception {

    @Test
    public void annotationValue() {
        MainPage mainPage = createPage(MainPage.class);
        assertNotNull(mainPage);
        assertEquals(mainPage.buttonSearch(), ".//*[@test-attr='button_search']");
        assertEquals(mainPage.textInputSearch(), ".//*[@test-attr='input_search']");
    }

    private MainPage createPage(Class clazz) {
        return (MainPage) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[] { clazz },
                (proxy, method, methodArgs) -> {
                    if (method.getAnnotation(Selector.class) != null) {
                        return method.getAnnotation(Selector.class).xpath();
                    } else {
                        throw new UnsupportedOperationException(
                                "Unsupported method: " + method.getName());
                    }
                });
    }
}