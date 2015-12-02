package userService.service.impl;

import userService.service.base.UsersLocalServiceBaseImpl;

/**
 * The implementation of the users local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link userService.service.UsersLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Yevgen Kogut
 * @see userService.service.base.UsersLocalServiceBaseImpl
 * @see userService.service.UsersLocalServiceUtil
 */
public class UsersLocalServiceImpl extends UsersLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link userService.service.UsersLocalServiceUtil} to access the users local service.
     */
}
