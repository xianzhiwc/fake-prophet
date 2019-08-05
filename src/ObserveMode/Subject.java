package ObserveMode;

import java.util.ArrayList;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

//主题类（被观察者对象）
public interface Subject {
	void AttachObserve();

}


public class ConcreteSubject implements Subject{
	private List<Observe> oblist = new ArrayList<Observe>();	
	
}

