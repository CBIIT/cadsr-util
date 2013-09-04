/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.formbuilder.common;

import gov.nih.nci.ncicb.cadsr.common.resource.NCIUser;

import java.util.Date;

/**This class is used to keep the information of the user/session who owned this form element.
 * 
 */
public class FormElementLocker {
    private String acIdSeq;
    private String sessionId;
    private NCIUser nciUser;
    private Date timeStamp; //this is the time when this form is locked
    
    public FormElementLocker(String acIdSeq, NCIUser user, String sessionId) {
        setAcIdSeq(acIdSeq);
        nciUser = user;
        this.sessionId = sessionId;
        timeStamp = new Date();
    }


    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setAcIdSeq(String acIdSeq) {
        this.acIdSeq = acIdSeq;
    }

    public String getAcIdSeq() {
        return acIdSeq;
    }

    public void setNciUser(NCIUser nciUser) {
        this.nciUser = nciUser;
    }

    public NCIUser getNciUser() {
        return nciUser;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
    
}
