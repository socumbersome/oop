/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package z1_facade;

import java.io.InputStream;
import javax.mail

/**
 *
 * @author ja
 */
public class SmtpFacade {
    
    public void Send(String From, String To, String Subject,
            String Body, InputStream Attachment,
            String AttachmentMimeType)
    {
        MimeMessage msg = new MimeMessage(session);
        
    }
}
