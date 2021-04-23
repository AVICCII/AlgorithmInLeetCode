package 面试;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aviccii 2021/4/19
 * @Discrimination
 */
public class 重写 {

    class SuperClass{
        protected List<Integer> func() throws Throwable{
            return new ArrayList<>();
        }
    }

    class SubClass extends SuperClass{
        @Override
        protected ArrayList<Integer> func() throws Throwable {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
    }
}
