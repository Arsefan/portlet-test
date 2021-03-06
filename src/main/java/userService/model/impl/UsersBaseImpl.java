package userService.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import userService.model.Users;

import userService.service.UsersLocalServiceUtil;

/**
 * The extended model base implementation for the Users service. Represents a row in the &quot;UserServices_Users&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UsersImpl}.
 * </p>
 *
 * @author Yevgen Kogut
 * @see UsersImpl
 * @see userService.model.Users
 * @generated
 */
public abstract class UsersBaseImpl extends UsersModelImpl implements Users {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a users model instance should use the {@link Users} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            UsersLocalServiceUtil.addUsers(this);
        } else {
            UsersLocalServiceUtil.updateUsers(this);
        }
    }
}
