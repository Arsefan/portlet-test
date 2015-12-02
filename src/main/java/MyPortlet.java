/**
 * Created by Arsefan on 28.11.2015.
 */
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.util.bridges.mvc.MVCPortlet;
import src.main.java.service.model.UsersClp;
import src.main.java.service.service.UsersLocalServiceWrapper;
import src.main.java.service.service.impl.UsersLocalServiceImpl;
//import userService.model.UsersClp;
//import userService.service.UsersLocalServiceWrapper;
//import userService.service.impl.UsersLocalServiceImpl;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;

public class MyPortlet extends MVCPortlet{

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        super.doView(renderRequest, renderResponse);
        UsersClp usersClp = new UsersClp();
        usersClp.setUserName("Yevgen"); //usersClp.setUserName(request.getParameter("name"));
        usersClp.setEmail("evgen.kogut.89@gmail.com"); //usersClp.setEmail(request.getParameter("email"));
        usersClp.setText("test text"); //usersClp.setText(request.getParameter("text"));

        UsersLocalServiceWrapper usersLocalServiceWrapper = new UsersLocalServiceWrapper(new UsersLocalServiceImpl());
        try {
            usersLocalServiceWrapper.addUsers(usersClp);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        try {
            sendMailMessage(usersClp);
        } catch (AddressException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
//        super.render(request, response);
//        UsersClp usersClp = new UsersClp();
//        usersClp.setUserName("Yevgen"); //usersClp.setUserName(request.getParameter("name"));
//        usersClp.setEmail("evgen.kogut.89@gmail.com"); //usersClp.setEmail(request.getParameter("email"));
//        usersClp.setText("test text"); //usersClp.setText(request.getParameter("text"));
//
//        UsersLocalServiceWrapper usersLocalServiceWrapper = new UsersLocalServiceWrapper(new UsersLocalServiceImpl());
//        try {
//            usersLocalServiceWrapper.addUsers(usersClp);
//        } catch (SystemException e) {
//            e.printStackTrace();
//        }
//        try {
//            sendMailMessage(usersClp);
//        } catch (AddressException e) {
//            e.printStackTrace();
//        }
//    }
    public void sendMailMessage(@NotNull UsersClp user)
            throws IOException, PortletException, AddressException {
        System.out.println("====sendMailMessage===");
//        String mailSubject= ParamUtil.getString(actionRequest, "mailSubject");
//        String mailBody=ParamUtil.getString(actionRequest,"editor");
//        String senderMailAddress=ParamUtil.getString(actionRequest,"senderEmailAddess");
//        String receiverMailAddress=ParamUtil.getString(actionRequest,"receiverEmailAddess");
        String mailSubject = "testPortlet";
        String mailBody = user.getUserName() + " send mail to you";
        String senderMailAddress = "liferay@gmail.com";
        String receiverMailAddress = "evgen.kogut.89@gmail.com";

        System.out.println("1111" + mailBody);
        try {
            MailMessage mailMessage = new MailMessage();
            mailMessage.setBody(mailBody);
            mailMessage.setSubject(mailSubject);
            mailMessage.setFrom(new InternetAddress(senderMailAddress));
            mailMessage.setTo(new InternetAddress(receiverMailAddress));
            MailServiceUtil.sendEmail(mailMessage);
//            SessionMessages.add(actionRequest.getPortletSession(), "mail-send-success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
