package bean.com.entities;

import bean.com.entities.util.MobilePageController;
import com.entities.MockData;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "mockDataController")
@ViewScoped
public class MockDataController extends AbstractController<MockData> {

    @Inject
    private MobilePageController mobilePageController;

    public MockDataController() {
        // Inform the Abstract parent controller of the concrete MockData Entity
        super(MockData.class);
    }

}
