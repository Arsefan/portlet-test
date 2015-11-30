package userService.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import userService.model.Users;
import userService.model.UsersModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Users service. Represents a row in the &quot;UserServices_Users&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link UsersModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UsersImpl}.
 * </p>
 *
 * @author Yevgen Kogut
 * @see UsersImpl
 * @see Users
 * @see UsersModel
 * @generated
 */
public class UsersModelImpl extends BaseModelImpl<Users> implements UsersModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a users model instance should use the {@link Users} interface instead.
     */
    public static final String TABLE_NAME = "UserServices_Users";
    public static final Object[][] TABLE_COLUMNS = {
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "email", Types.VARCHAR },
            { "text_", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table UserServices_Users (userId LONG not null primary key,userName VARCHAR(75) null,email VARCHAR(75) null,text_ VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table UserServices_Users";
    public static final String ORDER_BY_JPQL = " ORDER BY users.userName ASC";
    public static final String ORDER_BY_SQL = " ORDER BY UserServices_Users.userName ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.Users"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.Users"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.Users"),
            true);
    public static long TEXT_COLUMN_BITMASK = 1L;
    public static long USERID_COLUMN_BITMASK = 2L;
    public static long USERNAME_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.Users"));
    private static ClassLoader _classLoader = Users.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { Users.class };
    private long _userId;
    private String _userUuid;
    private long _originalUserId;
    private boolean _setOriginalUserId;
    private String _userName;
    private String _originalUserName;
    private String _email;
    private String _text;
    private String _originalText;
    private long _columnBitmask;
    private Users _escapedModel;

    public UsersModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _userId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setUserId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _userId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Users.class;
    }

    @Override
    public String getModelClassName() {
        return Users.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("email", getEmail());
        attributes.put("text", getText());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String text = (String) attributes.get("text");

        if (text != null) {
            setText(text);
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _columnBitmask |= USERID_COLUMN_BITMASK;

        if (!_setOriginalUserId) {
            _setOriginalUserId = true;

            _originalUserId = _userId;
        }

        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public long getOriginalUserId() {
        return _originalUserId;
    }

    @Override
    public String getUserName() {
        if (_userName == null) {
            return StringPool.BLANK;
        } else {
            return _userName;
        }
    }

    @Override
    public void setUserName(String userName) {
        _columnBitmask = -1L;

        if (_originalUserName == null) {
            _originalUserName = _userName;
        }

        _userName = userName;
    }

    public String getOriginalUserName() {
        return GetterUtil.getString(_originalUserName);
    }

    @Override
    public String getEmail() {
        if (_email == null) {
            return StringPool.BLANK;
        } else {
            return _email;
        }
    }

    @Override
    public void setEmail(String email) {
        _email = email;
    }

    @Override
    public String getText() {
        if (_text == null) {
            return StringPool.BLANK;
        } else {
            return _text;
        }
    }

    @Override
    public void setText(String text) {
        _columnBitmask |= TEXT_COLUMN_BITMASK;

        if (_originalText == null) {
            _originalText = _text;
        }

        _text = text;
    }

    public String getOriginalText() {
        return GetterUtil.getString(_originalText);
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Users.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Users toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Users) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        UsersImpl usersImpl = new UsersImpl();

        usersImpl.setUserId(getUserId());
        usersImpl.setUserName(getUserName());
        usersImpl.setEmail(getEmail());
        usersImpl.setText(getText());

        usersImpl.resetOriginalValues();

        return usersImpl;
    }

    @Override
    public int compareTo(Users users) {
        int value = 0;

        value = getUserName().compareTo(users.getUserName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Users)) {
            return false;
        }

        Users users = (Users) obj;

        long primaryKey = users.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        UsersModelImpl usersModelImpl = this;

        usersModelImpl._originalUserId = usersModelImpl._userId;

        usersModelImpl._setOriginalUserId = false;

        usersModelImpl._originalUserName = usersModelImpl._userName;

        usersModelImpl._originalText = usersModelImpl._text;

        usersModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Users> toCacheModel() {
        UsersCacheModel usersCacheModel = new UsersCacheModel();

        usersCacheModel.userId = getUserId();

        usersCacheModel.userName = getUserName();

        String userName = usersCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            usersCacheModel.userName = null;
        }

        usersCacheModel.email = getEmail();

        String email = usersCacheModel.email;

        if ((email != null) && (email.length() == 0)) {
            usersCacheModel.email = null;
        }

        usersCacheModel.text = getText();

        String text = usersCacheModel.text;

        if ((text != null) && (text.length() == 0)) {
            usersCacheModel.text = null;
        }

        return usersCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", text=");
        sb.append(getText());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("Users");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>text</column-name><column-value><![CDATA[");
        sb.append(getText());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
