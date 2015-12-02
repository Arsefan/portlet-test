package userService.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import userService.service.ClpSerializer;
import userService.service.UsersLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class UsersClp extends BaseModelImpl<Users> implements Users {
    private long _userId;
    private String _userUuid;
    private String _userName;
    private String _email;
    private String _text;
    private BaseModel<?> _usersRemoteModel;
    private Class<?> _clpSerializerClass = userService.service.ClpSerializer.class;

    public UsersClp() {
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
        _userId = userId;

        if (_usersRemoteModel != null) {
            try {
                Class<?> clazz = _usersRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_usersRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_usersRemoteModel != null) {
            try {
                Class<?> clazz = _usersRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_usersRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmail() {
        return _email;
    }

    @Override
    public void setEmail(String email) {
        _email = email;

        if (_usersRemoteModel != null) {
            try {
                Class<?> clazz = _usersRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_usersRemoteModel, email);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getText() {
        return _text;
    }

    @Override
    public void setText(String text) {
        _text = text;

        if (_usersRemoteModel != null) {
            try {
                Class<?> clazz = _usersRemoteModel.getClass();

                Method method = clazz.getMethod("setText", String.class);

                method.invoke(_usersRemoteModel, text);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getUsersRemoteModel() {
        return _usersRemoteModel;
    }

    public void setUsersRemoteModel(BaseModel<?> usersRemoteModel) {
        _usersRemoteModel = usersRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _usersRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_usersRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            UsersLocalServiceUtil.addUsers(this);
        } else {
            UsersLocalServiceUtil.updateUsers(this);
        }
    }

    @Override
    public Users toEscapedModel() {
        return (Users) ProxyUtil.newProxyInstance(Users.class.getClassLoader(),
            new Class[] { Users.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        UsersClp clone = new UsersClp();

        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setEmail(getEmail());
        clone.setText(getText());

        return clone;
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

        if (!(obj instanceof UsersClp)) {
            return false;
        }

        UsersClp users = (UsersClp) obj;

        long primaryKey = users.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
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
        sb.append("userService.model.Users");
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
