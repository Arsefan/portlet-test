package userService.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import userService.NoSuchUsersException;
import userService.model.Users;
import userService.model.impl.UsersModelImpl;

/**
 * The persistence interface for the users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Yevgen Kogut
 * @see UsersPersistenceImpl
 * @see UsersUtil
 * @generated
 */
public interface UsersPersistence extends BasePersistence<Users> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link UsersUtil} to access the users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the userses where userId = &#63; and userName = &#63;.
    *
    * @param userId the user ID
    * @param userName the user name
    * @return the matching userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findBy(
        long userId, java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the userses where userId = &#63; and userName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param userName the user name
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @return the range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findBy(
        long userId, java.lang.String userName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the userses where userId = &#63; and userName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List<Users> findBy(
        long userId, java.lang.String userName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first users in the ordered set where userId = &#63; and userName = &#63;.
    *
    * @param userId the user ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users
    * @throws NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users findBy_First(long userId,
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            NoSuchUsersException;

    /**
    * Returns the first users in the ordered set where userId = &#63; and userName = &#63;.
    *
    * @param userId the user ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users fetchBy_First(long userId,
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last users in the ordered set where userId = &#63; and userName = &#63;.
    *
    * @param userId the user ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users
    * @throws NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users findBy_Last(long userId,
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            NoSuchUsersException;

    /**
    * Returns the last users in the ordered set where userId = &#63; and userName = &#63;.
    *
    * @param userId the user ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users fetchBy_Last(long userId,
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the userses where userId = &#63; and userName = &#63; from the database.
    *
    * @param userId the user ID
    * @param userName the user name
    * @throws SystemException if a system exception occurred
    */
    public void removeBy(long userId, java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of userses where userId = &#63; and userName = &#63;.
    *
    * @param userId the user ID
    * @param userName the user name
    * @return the number of matching userses
    * @throws SystemException if a system exception occurred
    */
    public int countBy(long userId, java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the userses where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findByuserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the userses where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @return the range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findByuserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the userses where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findByuserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first users in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users
    * @throws NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users findByuserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            NoSuchUsersException;

    /**
    * Returns the first users in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users fetchByuserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last users in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users
    * @throws NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users findByuserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            NoSuchUsersException;

    /**
    * Returns the last users in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users fetchByuserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the userses where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByuserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of userses where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching userses
    * @throws SystemException if a system exception occurred
    */
    public int countByuserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the userses where userName = &#63;.
    *
    * @param userName the user name
    * @return the matching userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findByuserName(
        java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the userses where userName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userName the user name
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @return the range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findByuserName(
        java.lang.String userName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the userses where userName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userName the user name
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findByuserName(
        java.lang.String userName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first users in the ordered set where userName = &#63;.
    *
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users
    * @throws NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users findByuserName_First(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            NoSuchUsersException;

    /**
    * Returns the first users in the ordered set where userName = &#63;.
    *
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users fetchByuserName_First(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last users in the ordered set where userName = &#63;.
    *
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users
    * @throws NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users findByuserName_Last(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            NoSuchUsersException;

    /**
    * Returns the last users in the ordered set where userName = &#63;.
    *
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users fetchByuserName_Last(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the userses before and after the current users in the ordered set where userName = &#63;.
    *
    * @param userId the primary key of the current users
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next users
    * @throws NoSuchUsersException if a users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users[] findByuserName_PrevAndNext(
        long userId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            NoSuchUsersException;

    /**
    * Removes all the userses where userName = &#63; from the database.
    *
    * @param userName the user name
    * @throws SystemException if a system exception occurred
    */
    public void removeByuserName(java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of userses where userName = &#63;.
    *
    * @param userName the user name
    * @return the number of matching userses
    * @throws SystemException if a system exception occurred
    */
    public int countByuserName(java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the userses where text = &#63;.
    *
    * @param text the text
    * @return the matching userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findBytext(
        java.lang.String text)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the userses where text = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param text the text
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @return the range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findBytext(
        java.lang.String text, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the userses where text = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param text the text
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findBytext(
        java.lang.String text, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first users in the ordered set where text = &#63;.
    *
    * @param text the text
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users
    * @throws NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users findBytext_First(
        java.lang.String text,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            NoSuchUsersException;

    /**
    * Returns the first users in the ordered set where text = &#63;.
    *
    * @param text the text
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users fetchBytext_First(
        java.lang.String text,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last users in the ordered set where text = &#63;.
    *
    * @param text the text
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users
    * @throws NoSuchUsersException if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users findBytext_Last(
        java.lang.String text,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            NoSuchUsersException;

    /**
    * Returns the last users in the ordered set where text = &#63;.
    *
    * @param text the text
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching users, or <code>null</code> if a matching users could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users fetchBytext_Last(
        java.lang.String text,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the userses before and after the current users in the ordered set where text = &#63;.
    *
    * @param userId the primary key of the current users
    * @param text the text
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next users
    * @throws NoSuchUsersException if a users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users[] findBytext_PrevAndNext(
        long userId, java.lang.String text,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            NoSuchUsersException;

    /**
    * Removes all the userses where text = &#63; from the database.
    *
    * @param text the text
    * @throws SystemException if a system exception occurred
    */
    public void removeBytext(java.lang.String text)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of userses where text = &#63;.
    *
    * @param text the text
    * @return the number of matching userses
    * @throws SystemException if a system exception occurred
    */
    public int countBytext(java.lang.String text)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the users in the entity cache if it is enabled.
    *
    * @param users the users
    */
    public void cacheResult(Users users);

    /**
    * Caches the userses in the entity cache if it is enabled.
    *
    * @param userses the userses
    */
    public void cacheResult(
        java.util.List<Users> userses);

    /**
    * Creates a new users with the primary key. Does not add the users to the database.
    *
    * @param userId the primary key for the new users
    * @return the new users
    */
    public Users create(long userId);

    /**
    * Removes the users with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userId the primary key of the users
    * @return the users that was removed
    * @throws NoSuchUsersException if a users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users remove(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            NoSuchUsersException;

    public Users updateImpl(
        Users users)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the users with the primary key or throws a {@link NoSuchUsersException} if it could not be found.
    *
    * @param userId the primary key of the users
    * @return the users
    * @throws NoSuchUsersException if a users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users findByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            NoSuchUsersException;

    /**
    * Returns the users with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param userId the primary key of the users
    * @return the users, or <code>null</code> if a users with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public Users fetchByPrimaryKey(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the userses.
    *
    * @return the userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the userses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @return the range of userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the userses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of userses
    * @param end the upper bound of the range of userses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of userses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<Users> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the userses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of userses.
    *
    * @return the number of userses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
