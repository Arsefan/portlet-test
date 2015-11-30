package userService.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import userService.model.Users;
import userService.service.ClpSerializer;
import userService.service.UsersLocalServiceUtil;

/**
 * @author Yevgen Kogut
 * @generated
 */
public abstract class UsersActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public UsersActionableDynamicQuery() throws SystemException {
        setBaseLocalService(UsersLocalServiceUtil.getService());
        setClass(Users.class);

        setClassLoader(ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("userId");
    }
}
