package userService.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import userService.NoSuchUsersException;
import userService.model.Users;
import userService.model.impl.UsersImpl;
import userService.model.impl.UsersModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Yevgen Kogut
 * @see UsersPersistence
 * @see UsersUtil
 * @generated
 */
public class UsersPersistenceImpl extends BasePersistenceImpl<Users>
    implements UsersPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link UsersUtil} to access the users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = UsersImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, UsersImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, UsersImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ = new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, UsersImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBy",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ = new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, UsersImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBy",
            new String[] { Long.class.getName(), String.class.getName() },
            UsersModelImpl.USERID_COLUMN_BITMASK |
            UsersModelImpl.USERNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ = new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBy",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN__USERID_2 = "users.userId = ? AND ";
    private static final String _FINDER_COLUMN__USERNAME_1 = "users.userName IS NULL";
    private static final String _FINDER_COLUMN__USERNAME_2 = "users.userName = ?";
    private static final String _FINDER_COLUMN__USERNAME_3 = "(users.userName IS NULL OR users.userName = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, UsersImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, UsersImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
            new String[] { Long.class.getName() },
            UsersModelImpl.USERID_COLUMN_BITMASK |
            UsersModelImpl.USERNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "users.userId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERNAME = new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, UsersImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME =
        new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, UsersImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserName",
            new String[] { String.class.getName() },
            UsersModelImpl.USERNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERNAME = new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_USERNAME_USERNAME_1 = "users.userName IS NULL";
    private static final String _FINDER_COLUMN_USERNAME_USERNAME_2 = "users.userName = ?";
    private static final String _FINDER_COLUMN_USERNAME_USERNAME_3 = "(users.userName IS NULL OR users.userName = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEXT = new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, UsersImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytext",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEXT = new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, UsersImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytext",
            new String[] { String.class.getName() },
            UsersModelImpl.TEXT_COLUMN_BITMASK |
            UsersModelImpl.USERNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TEXT = new FinderPath(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytext",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_TEXT_TEXT_1 = "users.text IS NULL";
    private static final String _FINDER_COLUMN_TEXT_TEXT_2 = "users.text = ?";
    private static final String _FINDER_COLUMN_TEXT_TEXT_3 = "(users.text IS NULL OR users.text = '')";
    private static final String _SQL_SELECT_USERS = "SELECT users FROM Users users";
    private static final String _SQL_SELECT_USERS_WHERE = "SELECT users FROM Users users WHERE ";
    private static final String _SQL_COUNT_USERS = "SELECT COUNT(users) FROM Users users";
    private static final String _SQL_COUNT_USERS_WHERE = "SELECT COUNT(users) FROM Users users WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "users.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Users exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Users exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(UsersPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "text"
            });
    private static Users _nullUsers = new UsersImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Users> toCacheModel() {
                return _nullUsersCacheModel;
            }
        };

    private static CacheModel<Users> _nullUsersCacheModel = new CacheModel<Users>() {
            @Override
            public Users toEntityModel() {
                return _nullUsers;
            }
        };

    public UsersPersistenceImpl() {
        setModelClass(Users.class);
    }

    /**
     * Returns all the userses where userId = &#63; and userName = &#63;.
     *
     * @param userId the user ID
     * @param userName the user name
     * @return the matching userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Users> findBy(long userId, String userName)
        throws SystemException {
        return findBy(userId, userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

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
    @Override
    public List<Users> findBy(long userId, String userName, int start, int end)
        throws SystemException {
        return findBy(userId, userName, start, end, null);
    }

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
    @Override
    public List<Users> findBy(long userId, String userName, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_;
            finderArgs = new Object[] { userId, userName };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_;
            finderArgs = new Object[] {
                    userId, userName,
                    
                    start, end, orderByComparator
                };
        }

        List<Users> list = (List<Users>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Users users : list) {
                if ((userId != users.getUserId()) ||
                        !Validator.equals(userName, users.getUserName())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_USERS_WHERE);

            query.append(_FINDER_COLUMN__USERID_2);

            boolean bindUserName = false;

            if (userName == null) {
                query.append(_FINDER_COLUMN__USERNAME_1);
            } else if (userName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN__USERNAME_3);
            } else {
                bindUserName = true;

                query.append(_FINDER_COLUMN__USERNAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(UsersModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (bindUserName) {
                    qPos.add(userName);
                }

                if (!pagination) {
                    list = (List<Users>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Users>(list);
                } else {
                    list = (List<Users>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

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
    @Override
    public Users findBy_First(long userId, String userName,
        OrderByComparator orderByComparator)
        throws NoSuchUsersException, SystemException {
        Users users = fetchBy_First(userId, userName, orderByComparator);

        if (users != null) {
            return users;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", userName=");
        msg.append(userName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUsersException(msg.toString());
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
    @Override
    public Users fetchBy_First(long userId, String userName,
        OrderByComparator orderByComparator) throws SystemException {
        List<Users> list = findBy(userId, userName, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Users findBy_Last(long userId, String userName,
        OrderByComparator orderByComparator)
        throws NoSuchUsersException, SystemException {
        Users users = fetchBy_Last(userId, userName, orderByComparator);

        if (users != null) {
            return users;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", userName=");
        msg.append(userName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUsersException(msg.toString());
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
    @Override
    public Users fetchBy_Last(long userId, String userName,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBy(userId, userName);

        if (count == 0) {
            return null;
        }

        List<Users> list = findBy(userId, userName, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Removes all the userses where userId = &#63; and userName = &#63; from the database.
     *
     * @param userId the user ID
     * @param userName the user name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBy(long userId, String userName)
        throws SystemException {
        for (Users users : findBy(userId, userName, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(users);
        }
    }

    /**
     * Returns the number of userses where userId = &#63; and userName = &#63;.
     *
     * @param userId the user ID
     * @param userName the user name
     * @return the number of matching userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBy(long userId, String userName) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_;

        Object[] finderArgs = new Object[] { userId, userName };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_USERS_WHERE);

            query.append(_FINDER_COLUMN__USERID_2);

            boolean bindUserName = false;

            if (userName == null) {
                query.append(_FINDER_COLUMN__USERNAME_1);
            } else if (userName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN__USERNAME_3);
            } else {
                bindUserName = true;

                query.append(_FINDER_COLUMN__USERNAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (bindUserName) {
                    qPos.add(userName);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the userses where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Users> findByuserId(long userId) throws SystemException {
        return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Users> findByuserId(long userId, int start, int end)
        throws SystemException {
        return findByuserId(userId, start, end, null);
    }

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
    @Override
    public List<Users> findByuserId(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Users> list = (List<Users>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Users users : list) {
                if ((userId != users.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_USERS_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(UsersModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Users>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Users>(list);
                } else {
                    list = (List<Users>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first users in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching users
     * @throws NoSuchUsersException if a matching users could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users findByuserId_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchUsersException, SystemException {
        Users users = fetchByuserId_First(userId, orderByComparator);

        if (users != null) {
            return users;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUsersException(msg.toString());
    }

    /**
     * Returns the first users in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching users, or <code>null</code> if a matching users could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users fetchByuserId_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Users> list = findByuserId(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last users in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching users
     * @throws NoSuchUsersException if a matching users could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users findByuserId_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchUsersException, SystemException {
        Users users = fetchByuserId_Last(userId, orderByComparator);

        if (users != null) {
            return users;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUsersException(msg.toString());
    }

    /**
     * Returns the last users in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching users, or <code>null</code> if a matching users could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users fetchByuserId_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByuserId(userId);

        if (count == 0) {
            return null;
        }

        List<Users> list = findByuserId(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Removes all the userses where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByuserId(long userId) throws SystemException {
        for (Users users : findByuserId(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(users);
        }
    }

    /**
     * Returns the number of userses where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByuserId(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_USERS_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the userses where userName = &#63;.
     *
     * @param userName the user name
     * @return the matching userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Users> findByuserName(String userName)
        throws SystemException {
        return findByuserName(userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

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
    @Override
    public List<Users> findByuserName(String userName, int start, int end)
        throws SystemException {
        return findByuserName(userName, start, end, null);
    }

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
    @Override
    public List<Users> findByuserName(String userName, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME;
            finderArgs = new Object[] { userName };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERNAME;
            finderArgs = new Object[] { userName, start, end, orderByComparator };
        }

        List<Users> list = (List<Users>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Users users : list) {
                if (!Validator.equals(userName, users.getUserName())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_USERS_WHERE);

            boolean bindUserName = false;

            if (userName == null) {
                query.append(_FINDER_COLUMN_USERNAME_USERNAME_1);
            } else if (userName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
            } else {
                bindUserName = true;

                query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(UsersModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUserName) {
                    qPos.add(userName);
                }

                if (!pagination) {
                    list = (List<Users>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Users>(list);
                } else {
                    list = (List<Users>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first users in the ordered set where userName = &#63;.
     *
     * @param userName the user name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching users
     * @throws NoSuchUsersException if a matching users could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users findByuserName_First(String userName,
        OrderByComparator orderByComparator)
        throws NoSuchUsersException, SystemException {
        Users users = fetchByuserName_First(userName, orderByComparator);

        if (users != null) {
            return users;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userName=");
        msg.append(userName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUsersException(msg.toString());
    }

    /**
     * Returns the first users in the ordered set where userName = &#63;.
     *
     * @param userName the user name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching users, or <code>null</code> if a matching users could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users fetchByuserName_First(String userName,
        OrderByComparator orderByComparator) throws SystemException {
        List<Users> list = findByuserName(userName, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last users in the ordered set where userName = &#63;.
     *
     * @param userName the user name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching users
     * @throws NoSuchUsersException if a matching users could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users findByuserName_Last(String userName,
        OrderByComparator orderByComparator)
        throws NoSuchUsersException, SystemException {
        Users users = fetchByuserName_Last(userName, orderByComparator);

        if (users != null) {
            return users;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userName=");
        msg.append(userName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUsersException(msg.toString());
    }

    /**
     * Returns the last users in the ordered set where userName = &#63;.
     *
     * @param userName the user name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching users, or <code>null</code> if a matching users could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users fetchByuserName_Last(String userName,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByuserName(userName);

        if (count == 0) {
            return null;
        }

        List<Users> list = findByuserName(userName, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Users[] findByuserName_PrevAndNext(long userId, String userName,
        OrderByComparator orderByComparator)
        throws NoSuchUsersException, SystemException {
        Users users = findByPrimaryKey(userId);

        Session session = null;

        try {
            session = openSession();

            Users[] array = new UsersImpl[3];

            array[0] = getByuserName_PrevAndNext(session, users, userName,
                    orderByComparator, true);

            array[1] = users;

            array[2] = getByuserName_PrevAndNext(session, users, userName,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Users getByuserName_PrevAndNext(Session session, Users users,
        String userName, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_USERS_WHERE);

        boolean bindUserName = false;

        if (userName == null) {
            query.append(_FINDER_COLUMN_USERNAME_USERNAME_1);
        } else if (userName.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
        } else {
            bindUserName = true;

            query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(UsersModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUserName) {
            qPos.add(userName);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(users);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Users> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the userses where userName = &#63; from the database.
     *
     * @param userName the user name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByuserName(String userName) throws SystemException {
        for (Users users : findByuserName(userName, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(users);
        }
    }

    /**
     * Returns the number of userses where userName = &#63;.
     *
     * @param userName the user name
     * @return the number of matching userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByuserName(String userName) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERNAME;

        Object[] finderArgs = new Object[] { userName };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_USERS_WHERE);

            boolean bindUserName = false;

            if (userName == null) {
                query.append(_FINDER_COLUMN_USERNAME_USERNAME_1);
            } else if (userName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
            } else {
                bindUserName = true;

                query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUserName) {
                    qPos.add(userName);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the userses where text = &#63;.
     *
     * @param text the text
     * @return the matching userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Users> findBytext(String text) throws SystemException {
        return findBytext(text, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Users> findBytext(String text, int start, int end)
        throws SystemException {
        return findBytext(text, start, end, null);
    }

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
    @Override
    public List<Users> findBytext(String text, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEXT;
            finderArgs = new Object[] { text };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEXT;
            finderArgs = new Object[] { text, start, end, orderByComparator };
        }

        List<Users> list = (List<Users>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Users users : list) {
                if (!Validator.equals(text, users.getText())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_USERS_WHERE);

            boolean bindText = false;

            if (text == null) {
                query.append(_FINDER_COLUMN_TEXT_TEXT_1);
            } else if (text.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TEXT_TEXT_3);
            } else {
                bindText = true;

                query.append(_FINDER_COLUMN_TEXT_TEXT_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(UsersModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindText) {
                    qPos.add(text);
                }

                if (!pagination) {
                    list = (List<Users>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Users>(list);
                } else {
                    list = (List<Users>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first users in the ordered set where text = &#63;.
     *
     * @param text the text
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching users
     * @throws NoSuchUsersException if a matching users could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users findBytext_First(String text,
        OrderByComparator orderByComparator)
        throws NoSuchUsersException, SystemException {
        Users users = fetchBytext_First(text, orderByComparator);

        if (users != null) {
            return users;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("text=");
        msg.append(text);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUsersException(msg.toString());
    }

    /**
     * Returns the first users in the ordered set where text = &#63;.
     *
     * @param text the text
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching users, or <code>null</code> if a matching users could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users fetchBytext_First(String text,
        OrderByComparator orderByComparator) throws SystemException {
        List<Users> list = findBytext(text, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last users in the ordered set where text = &#63;.
     *
     * @param text the text
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching users
     * @throws NoSuchUsersException if a matching users could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users findBytext_Last(String text,
        OrderByComparator orderByComparator)
        throws NoSuchUsersException, SystemException {
        Users users = fetchBytext_Last(text, orderByComparator);

        if (users != null) {
            return users;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("text=");
        msg.append(text);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUsersException(msg.toString());
    }

    /**
     * Returns the last users in the ordered set where text = &#63;.
     *
     * @param text the text
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching users, or <code>null</code> if a matching users could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users fetchBytext_Last(String text,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBytext(text);

        if (count == 0) {
            return null;
        }

        List<Users> list = findBytext(text, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Users[] findBytext_PrevAndNext(long userId, String text,
        OrderByComparator orderByComparator)
        throws NoSuchUsersException, SystemException {
        Users users = findByPrimaryKey(userId);

        Session session = null;

        try {
            session = openSession();

            Users[] array = new UsersImpl[3];

            array[0] = getBytext_PrevAndNext(session, users, text,
                    orderByComparator, true);

            array[1] = users;

            array[2] = getBytext_PrevAndNext(session, users, text,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Users getBytext_PrevAndNext(Session session, Users users,
        String text, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_USERS_WHERE);

        boolean bindText = false;

        if (text == null) {
            query.append(_FINDER_COLUMN_TEXT_TEXT_1);
        } else if (text.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_TEXT_TEXT_3);
        } else {
            bindText = true;

            query.append(_FINDER_COLUMN_TEXT_TEXT_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(UsersModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindText) {
            qPos.add(text);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(users);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Users> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the userses where text = &#63; from the database.
     *
     * @param text the text
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBytext(String text) throws SystemException {
        for (Users users : findBytext(text, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(users);
        }
    }

    /**
     * Returns the number of userses where text = &#63;.
     *
     * @param text the text
     * @return the number of matching userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBytext(String text) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TEXT;

        Object[] finderArgs = new Object[] { text };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_USERS_WHERE);

            boolean bindText = false;

            if (text == null) {
                query.append(_FINDER_COLUMN_TEXT_TEXT_1);
            } else if (text.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TEXT_TEXT_3);
            } else {
                bindText = true;

                query.append(_FINDER_COLUMN_TEXT_TEXT_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindText) {
                    qPos.add(text);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the users in the entity cache if it is enabled.
     *
     * @param users the users
     */
    @Override
    public void cacheResult(Users users) {
        EntityCacheUtil.putResult(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersImpl.class, users.getPrimaryKey(), users);

        users.resetOriginalValues();
    }

    /**
     * Caches the userses in the entity cache if it is enabled.
     *
     * @param userses the userses
     */
    @Override
    public void cacheResult(List<Users> userses) {
        for (Users users : userses) {
            if (EntityCacheUtil.getResult(UsersModelImpl.ENTITY_CACHE_ENABLED,
                        UsersImpl.class, users.getPrimaryKey()) == null) {
                cacheResult(users);
            } else {
                users.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all userses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(UsersImpl.class.getName());
        }

        EntityCacheUtil.clearCache(UsersImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the users.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Users users) {
        EntityCacheUtil.removeResult(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersImpl.class, users.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Users> userses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Users users : userses) {
            EntityCacheUtil.removeResult(UsersModelImpl.ENTITY_CACHE_ENABLED,
                UsersImpl.class, users.getPrimaryKey());
        }
    }

    /**
     * Creates a new users with the primary key. Does not add the users to the database.
     *
     * @param userId the primary key for the new users
     * @return the new users
     */
    @Override
    public Users create(long userId) {
        Users users = new UsersImpl();

        users.setNew(true);
        users.setPrimaryKey(userId);

        return users;
    }

    /**
     * Removes the users with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param userId the primary key of the users
     * @return the users that was removed
     * @throws NoSuchUsersException if a users with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users remove(long userId)
        throws NoSuchUsersException, SystemException {
        return remove((Serializable) userId);
    }

    /**
     * Removes the users with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the users
     * @return the users that was removed
     * @throws NoSuchUsersException if a users with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users remove(Serializable primaryKey)
        throws NoSuchUsersException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Users users = (Users) session.get(UsersImpl.class, primaryKey);

            if (users == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(users);
        } catch (NoSuchUsersException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Users removeImpl(Users users) throws SystemException {
        users = toUnwrappedModel(users);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(users)) {
                users = (Users) session.get(UsersImpl.class,
                        users.getPrimaryKeyObj());
            }

            if (users != null) {
                session.delete(users);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (users != null) {
            clearCache(users);
        }

        return users;
    }

    @Override
    public Users updateImpl(Users users)
        throws SystemException {
        users = toUnwrappedModel(users);

        boolean isNew = users.isNew();

        UsersModelImpl usersModelImpl = (UsersModelImpl) users;

        Session session = null;

        try {
            session = openSession();

            if (users.isNew()) {
                session.save(users);

                users.setNew(false);
            } else {
                session.merge(users);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !UsersModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((usersModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        usersModelImpl.getOriginalUserId(),
                        usersModelImpl.getOriginalUserName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_,
                    args);

                args = new Object[] {
                        usersModelImpl.getUserId(), usersModelImpl.getUserName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_,
                    args);
            }

            if ((usersModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { usersModelImpl.getOriginalUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { usersModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }

            if ((usersModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        usersModelImpl.getOriginalUserName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERNAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME,
                    args);

                args = new Object[] { usersModelImpl.getUserName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERNAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME,
                    args);
            }

            if ((usersModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEXT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { usersModelImpl.getOriginalText() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEXT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEXT,
                    args);

                args = new Object[] { usersModelImpl.getText() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEXT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEXT,
                    args);
            }
        }

        EntityCacheUtil.putResult(UsersModelImpl.ENTITY_CACHE_ENABLED,
            UsersImpl.class, users.getPrimaryKey(), users);

        return users;
    }

    protected Users toUnwrappedModel(Users users) {
        if (users instanceof UsersImpl) {
            return users;
        }

        UsersImpl usersImpl = new UsersImpl();

        usersImpl.setNew(users.isNew());
        usersImpl.setPrimaryKey(users.getPrimaryKey());

        usersImpl.setUserId(users.getUserId());
        usersImpl.setUserName(users.getUserName());
        usersImpl.setEmail(users.getEmail());
        usersImpl.setText(users.getText());

        return usersImpl;
    }

    /**
     * Returns the users with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the users
     * @return the users
     * @throws NoSuchUsersException if a users with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users findByPrimaryKey(Serializable primaryKey)
        throws NoSuchUsersException, SystemException {
        Users users = fetchByPrimaryKey(primaryKey);

        if (users == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return users;
    }

    /**
     * Returns the users with the primary key or throws a {@link NoSuchUsersException} if it could not be found.
     *
     * @param userId the primary key of the users
     * @return the users
     * @throws NoSuchUsersException if a users with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users findByPrimaryKey(long userId)
        throws NoSuchUsersException, SystemException {
        return findByPrimaryKey((Serializable) userId);
    }

    /**
     * Returns the users with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the users
     * @return the users, or <code>null</code> if a users with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Users users = (Users) EntityCacheUtil.getResult(UsersModelImpl.ENTITY_CACHE_ENABLED,
                UsersImpl.class, primaryKey);

        if (users == _nullUsers) {
            return null;
        }

        if (users == null) {
            Session session = null;

            try {
                session = openSession();

                users = (Users) session.get(UsersImpl.class, primaryKey);

                if (users != null) {
                    cacheResult(users);
                } else {
                    EntityCacheUtil.putResult(UsersModelImpl.ENTITY_CACHE_ENABLED,
                        UsersImpl.class, primaryKey, _nullUsers);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(UsersModelImpl.ENTITY_CACHE_ENABLED,
                    UsersImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return users;
    }

    /**
     * Returns the users with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param userId the primary key of the users
     * @return the users, or <code>null</code> if a users with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Users fetchByPrimaryKey(long userId) throws SystemException {
        return fetchByPrimaryKey((Serializable) userId);
    }

    /**
     * Returns all the userses.
     *
     * @return the userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Users> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Users> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Users> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Users> list = (List<Users>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_USERS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_USERS;

                if (pagination) {
                    sql = sql.concat(UsersModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Users>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Users>(list);
                } else {
                    list = (List<Users>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the userses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Users users : findAll()) {
            remove(users);
        }
    }

    /**
     * Returns the number of userses.
     *
     * @return the number of userses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_USERS);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the users persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.Users")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Users>> listenersList = new ArrayList<ModelListener<Users>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Users>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(UsersImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
