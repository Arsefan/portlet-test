/**
 * Created by Arsefan on 28.11.2015.
 */
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.util.bridges.mvc.MVCPortlet;
import userService.model.Users;
import userService.model.UsersClp;
import userService.service.UsersLocalServiceUtil;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.Writer;

public class MyPortlet extends MVCPortlet{

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        super.doView(renderRequest, renderResponse);
        Users users;
//usersClp.setUserName(request.getParameter("name"));
//usersClp.setEmail(request.getParameter("email"));
//usersClp.setText(request.getParameter("text"));

        try {
            long Id;
            Id = CounterLocalServiceUtil.increment(UsersClp.class.getName());
            users = UsersLocalServiceUtil.createUsers(Id);
            UsersLocalServiceUtil.addUsers(users);
            users.setUserName("Yevgen");
            users.setText("test text");
            users.setEmail("evgen.kogut.89@gmail.com");
            users = UsersLocalServiceUtil.updateUsers(users);

            sendMailMessage(users, renderResponse);

        } catch (SystemException e) {
            e.printStackTrace();
        } catch (AddressException e) {
            e.printStackTrace();
        }
    }
    public void sendMailMessage(@NotNull Users user, RenderResponse response)
            throws IOException, PortletException, AddressException {
//        String mailSubject= ParamUtil.getString(actionRequest, "mailSubject");
//        String mailBody=ParamUtil.getString(actionRequest,"editor");
//        String senderMailAddress=ParamUtil.getString(actionRequest,"senderEmailAddess");
//        String receiverMailAddress=ParamUtil.getString(actionRequest,"receiverEmailAddess");
        String mailSubject = "testPortlet";
        String mailBody = user.getUserName() + " send mail to you";
        String senderMailAddress = "Arsefan@i.ua";
        String receiverMailAddress = "evgen.kogut.89@gmail.com";

        try {
            MailMessage mailMessage = new MailMessage();
            mailMessage.setTo(new InternetAddress(receiverMailAddress));
            mailMessage.setFrom(new InternetAddress(senderMailAddress));
            mailMessage.setSubject(mailSubject);
            mailMessage.setBody(mailBody);
            Writer w = response.getWriter();
            MailServiceUtil.sendEmail(mailMessage);
            w.write("message wos send on email "+ receiverMailAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
