package userService.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Yevgen Kogut
 * @generated
 */
public class UsersSoap implements Serializable {
    private long _userId;
    private String _userName;
    private String _email;
    private String _text;

    public UsersSoap() {
    }

    public static UsersSoap toSoapModel(Users model) {
        UsersSoap soapModel = new UsersSoap();

        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setEmail(model.getEmail());
        soapModel.setText(model.getText());

        return soapModel;
    }

    public static UsersSoap[] toSoapModels(Users[] models) {
        UsersSoap[] soapModels = new UsersSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static UsersSoap[][] toSoapModels(Users[][] models) {
        UsersSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new UsersSoap[models.length][models[0].length];
        } else {
            soapModels = new UsersSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static UsersSoap[] toSoapModels(List<Users> models) {
        List<UsersSoap> soapModels = new ArrayList<UsersSoap>(models.size());

        for (Users model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new UsersSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _userId;
    }

    public void setPrimaryKey(long pk) {
        setUserId(pk);
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getText() {
        return _text;
    }

    public void setText(String text) {
        _text = text;
    }
}
