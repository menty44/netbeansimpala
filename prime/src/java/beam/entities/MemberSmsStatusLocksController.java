package beam.entities;

import beam.entities.util.MobilePageController;
import entities.MemberSmsStatusLocks;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "memberSmsStatusLocksController")
@ViewScoped
public class MemberSmsStatusLocksController extends AbstractController<MemberSmsStatusLocks> {

    @Inject
    private MobilePageController mobilePageController;

    public MemberSmsStatusLocksController() {
        // Inform the Abstract parent controller of the concrete MemberSmsStatusLocks Entity
        super(MemberSmsStatusLocks.class);
    }

}
