package userService.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import userService.model.Users;

import java.util.List;

/**
 * The persistence utility for the users service. This utility wraps {@link UsersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Yevgen Kogut
 * @see UsersPersistence
 * @see UsersPersistenceImpl
 * @generated
 */
public class UsersUtil {
    private static UsersPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Users users) {
        getPersistence().clearCache(users);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Users> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Users> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Users> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Users update(Users users) throws SystemException {
        return getPersistence().update(users);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Users update(Users users, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(users, serviceContext);
    }

    /**
    * Returns all the userses where userId = &#63; and userName = &#63;.
    *
    * @param userId the user ID
    * @param userName the user name
    * @return the matching userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findBy(long userId,
        java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBy(userId, userName);
    }

    /**
    * Returns a range of all the userses where userId = &#63; and userName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userService.model.impl.UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param userName the user name
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @return the range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findBy(long userId,
        java.lang.String userName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBy(userId, userName, start, end);
    }

    /**
    * Returns an ordered range of all the userses where userId = &#63; and userName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userService.model.impl.UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param userName the user name
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findBy(long userId,
        java.lang.String userName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBy(userId, userName, start, end, orderByComparator);
    }

    /**
    * Returns the first users in the ordered set where userId = &#63; and userName = &#63;.
    *
    * @param userId the user ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users
    * @throws userService.NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users findBy_First(long userId,
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            userService.NoSuchUsersException {
        return getPersistence().findBy_First(userId, userName, orderByComparator);
    }

    /**
    * Returns the first users in the ordered set where userId = &#63; and userName = &#63;.
    *
    * @param userId the user ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users fetchBy_First(long userId,
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBy_First(userId, userName, orderByComparator);
    }

    /**
    * Returns the last users in the ordered set where userId = &#63; and userName = &#63;.
    *
    * @param userId the user ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users
    * @throws userService.NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users findBy_Last(long userId,
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            userService.NoSuchUsersException {
        return getPersistence().findBy_Last(userId, userName, orderByComparator);
    }

    /**
    * Returns the last users in the ordered set where userId = &#63; and userName = &#63;.
    *
    * @param userId the user ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users fetchBy_Last(long userId,
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBy_Last(userId, userName, orderByComparator);
    }

    /**
    * Removes all the userses where userId = &#63; and userName = &#63; from the database.
    *
    * @param userId the user ID
    * @param userName the user name
    * @throws SystemException if a system exception occurred
    */
    public static void removeBy(long userId, java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBy(userId, userName);
    }

    /**
    * Returns the number of userses where userId = &#63; and userName = &#63;.
    *
    * @param userId the user ID
    * @param userName the user name
    * @return the number of matching userses
    * @throws SystemException if a system exception occurred
    */
    public static int countBy(long userId, java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBy(userId, userName);
    }

    /**
    * Returns all the userses where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findByuserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByuserId(userId);
    }

    /**
    * Returns a range of all the userses where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userService.model.impl.UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @return the range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findByuserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByuserId(userId, start, end);
    }

    /**
    * Returns an ordered range of all the userses where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userService.model.impl.UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findByuserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByuserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first users in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users
    * @throws userService.NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users findByuserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            userService.NoSuchUsersException {
        return getPersistence().findByuserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first users in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users fetchByuserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByuserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last users in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users
    * @throws userService.NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users findByuserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            userService.NoSuchUsersException {
        return getPersistence().findByuserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last users in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users fetchByuserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByuserId_Last(userId, orderByComparator);
    }

    /**
    * Removes all the userses where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByuserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByuserId(userId);
    }

    /**
    * Returns the number of userses where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching userses
    * @throws SystemException if a system exception occurred
    */
    public static int countByuserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByuserId(userId);
    }

    /**
    * Returns all the userses where userName = &#63;.
    *
    * @param userName the user name
    * @return the matching userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findByuserName(
        java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByuserName(userName);
    }

    /**
    * Returns a range of all the userses where userName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userService.model.impl.UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userName the user name
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @return the range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findByuserName(
        java.lang.String userName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByuserName(userName, start, end);
    }

    /**
    * Returns an ordered range of all the userses where userName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userService.model.impl.UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userName the user name
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findByuserName(
        java.lang.String userName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByuserName(userName, start, end, orderByComparator);
    }

    /**
    * Returns the first users in the ordered set where userName = &#63;.
    *
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users
    * @throws userService.NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users findByuserName_First(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            userService.NoSuchUsersException {
        return getPersistence().findByuserName_First(userName, orderByComparator);
    }

    /**
    * Returns the first users in the ordered set where userName = &#63;.
    *
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users fetchByuserName_First(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByuserName_First(userName, orderByComparator);
    }

    /**
    * Returns the last users in the ordered set where userName = &#63;.
    *
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users
    * @throws userService.NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users findByuserName_Last(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            userService.NoSuchUsersException {
        return getPersistence().findByuserName_Last(userName, orderByComparator);
    }

    /**
    * Returns the last users in the ordered set where userName = &#63;.
    *
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users fetchByuserName_Last(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByuserName_Last(userName, orderByComparator);
    }

    /**
    * Returns the userses before and after the current users in the ordered set where userName = &#63;.
    *
    * @param userId the primary key of the current users
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next users
    * @throws userService.NoSuchUsersException if a users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users[] findByuserName_PrevAndNext(
        long userId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            userService.NoSuchUsersException {
        return getPersistence()
                   .findByuserName_PrevAndNext(userId, userName,
            orderByComparator);
    }

    /**
    * Removes all the userses where userName = &#63; from the database.
    *
    * @param userName the user name
    * @throws SystemException if a system exception occurred
    */
    public static void removeByuserName(java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByuserName(userName);
    }

    /**
    * Returns the number of userses where userName = &#63;.
    *
    * @param userName the user name
    * @return the number of matching userses
    * @throws SystemException if a system exception occurred
    */
    public static int countByuserName(java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByuserName(userName);
    }

    /**
    * Returns all the userses where text = &#63;.
    *
    * @param text the text
    * @return the matching userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findBytext(
        java.lang.String text)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytext(text);
    }

    /**
    * Returns a range of all the userses where text = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userService.model.impl.UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param text the text
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @return the range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findBytext(
        java.lang.String text, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytext(text, start, end);
    }

    /**
    * Returns an ordered range of all the userses where text = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userService.model.impl.UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param text the text
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findBytext(
        java.lang.String text, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytext(text, start, end, orderByComparator);
    }

    /**
    * Returns the first users in the ordered set where text = &#63;.
    *
    * @param text the text
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users
    * @throws userService.NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users findBytext_First(
        java.lang.String text,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            userService.NoSuchUsersException {
        return getPersistence().findBytext_First(text, orderByComparator);
    }

    /**
    * Returns the first users in the ordered set where text = &#63;.
    *
    * @param text the text
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users fetchBytext_First(
        java.lang.String text,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBytext_First(text, orderByComparator);
    }

    /**
    * Returns the last users in the ordered set where text = &#63;.
    *
    * @param text the text
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users
    * @throws userService.NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users findBytext_Last(
        java.lang.String text,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            userService.NoSuchUsersException {
        return getPersistence().findBytext_Last(text, orderByComparator);
    }

    /**
    * Returns the last users in the ordered set where text = &#63;.
    *
    * @param text the text
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users fetchBytext_Last(
        java.lang.String text,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBytext_Last(text, orderByComparator);
    }

    /**
    * Returns the userses before and after the current users in the ordered set where text = &#63;.
    *
    * @param userId the primary key of the current users
    * @param text the text
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next users
    * @throws userService.NoSuchUsersException if a users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users[] findBytext_PrevAndNext(
        long userId, java.lang.String text,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            userService.NoSuchUsersException {
        return getPersistence()
                   .findBytext_PrevAndNext(userId, text, orderByComparator);
    }

    /**
    * Removes all the userses where text = &#63; from the database.
    *
    * @param text the text
    * @throws SystemException if a system exception occurred
    */
    public static void removeBytext(java.lang.String text)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBytext(text);
    }

    /**
    * Returns the number of userses where text = &#63;.
    *
    * @param text the text
    * @return the number of matching userses
    * @throws SystemException if a system exception occurred
    */
    public static int countBytext(java.lang.String text)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBytext(text);
    }

    /**
    * Caches the users in the entity cache if it is enabled.
    *
    * @param users the users
    */
    public static void cacheResult(userService.model.Users users) {
        getPersistence().cacheResult(users);
    }

    /**
    * Caches the userses in the entity cache if it is enabled.
    *
    * @param userses the userses
    */
    public static void cacheResult(
        java.util.List<userService.model.Users> userses) {
        getPersistence().cacheResult(userses);
    }

    /**
    * Creates a new users with the primary key. Does not add the users to the database.
    *
    * @param userId the primary key for the new users
    * @return the new users
    */
    public static userService.model.Users create(long userId) {
        return getPersistence().create(userId);
    }

    /**
    * Removes the users with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userId the primary key of the users
    * @return the users that was removed
    * @throws userService.NoSuchUsersException if a users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users remove(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            userService.NoSuchUsersException {
        return getPersistence().remove(userId);
    }

    public static userService.model.Users updateImpl(
        userService.model.Users users)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(users);
    }

    /**
    * Returns the users with the primary key or throws a {@link userService.NoSuchUsersException} if it could not be found.
    *
    * @param userId the primary key of the users
    * @return the users
    * @throws userService.NoSuchUsersException if a users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users findByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            userService.NoSuchUsersException {
        return getPersistence().findByPrimaryKey(userId);
    }

    /**
    * Returns the users with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param userId the primary key of the users
    * @return the users, or <code>null</code> if a users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static userService.model.Users fetchByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(userId);
    }

    /**
    * Returns all the userses.
    *
    * @return the userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the userses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userService.model.impl.UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @return the range of userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the userses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userService.model.impl.UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of userses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<userService.model.Users> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the userses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of userses.
    *
    * @return the number of userses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static UsersPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (UsersPersistence) PortletBeanLocatorUtil.locate(userService.service.ClpSerializer.getServletContextName(),
                    UsersPersistence.class.getName());

            ReferenceRegistry.registerReference(UsersUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(UsersPersistence persistence) {
    }
}
