package userService.model;

import com.liferay.portal.model.PersistedModel;
import userService.model.impl.UsersImpl;
import userService.model.impl.UsersModelImpl;

/**
 * The extended model interface for the Users service. Represents a row in the &quot;UserServices_Users&quot; database table, with each column mapped to a property of this class.
 *
 * @author Yevgen Kogut
 * @see UsersModel
 * @see UsersImpl
 * @see UsersModelImpl
 * @generated
 */
public interface Users extends UsersModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link UsersImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
}
