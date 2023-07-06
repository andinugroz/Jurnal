package co.id.mii.serverside.models.dto.request;

public class EmailRequest {
    private String toEmail;
    private String subject;
    private String body;
    private String attachment;

    public EmailRequest() {
    }

    public EmailRequest(String toEmail, String subject, String body) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
    }

    public EmailRequest(String toEmail, String subject, String body, String attachment) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
        this.attachment = attachment;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
