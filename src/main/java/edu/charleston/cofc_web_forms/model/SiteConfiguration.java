package edu.charleston.cofc_web_forms.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Repository for the configuration settings based on application.properties or
 * application.yml.
 */
@Component
public class SiteConfiguration {

    @Value("${mail.server}")
    private String mailServer;

    @Value("${enable.error.log.email}")
    private boolean enableErrorLogEmail;

    @Value("${check.workflow}")
    private boolean checkWorkFlow;

    @Value("${use.hashcode}")
    private boolean useHashCode;

    @Value("${error.log.email}")
    private String errorLogEmail;

    @Value("${web.site.email}")
    private String webSiteEmail;

    @Value("${test.email}")
    private String testEmail;

    @Value("${site.name}")
    private String siteName;

    @Value("${web.address}")
    private String webAddress;

    @Value("${ssl.web.address}")
    private String sslWebAddress;

    @Value("${cofc.rest.services}")
    private String cofcRestServices;

    @Value("${test.cwid}")
    private String testCWID;

    @Value("${workflow.principal}")
    private String workFlowPrincipal;

    @Value("${workflow.credential}")
    private String workFlowCredential;

    @Value("${workflow.primary.key}")
    private String workFlowPrimaryKey;

    @Value("${max.file.size.for.upload}")
    private int maxFileSizeForUpload;

    /**
     * Gets the mail server address.
     *
     * @return The mail server address.
     */
    public String getMailServer() {
        return mailServer;
    }

    /**
     * Checks if error log email is enabled.
     *
     * @return True if error log email is enabled, false otherwise.
     */
    public boolean isEnableErrorLogEmail() {
        return enableErrorLogEmail;
    }

    /**
     * Checks if workflow is enabled.
     *
     * @return True if workflow is enabled, false otherwise.
     */
    public boolean isCheckWorkFlow() {
        return checkWorkFlow;
    }

    /**
     * Checks if hash code is used.
     *
     * @return True if hash code is used, false otherwise.
     */
    public boolean isUseHashCode() {
        return useHashCode;
    }

    /**
     * Gets the error log email address.
     *
     * @return The error log email address.
     */
    public String getErrorLogEmail() {
        return errorLogEmail;
    }

    /**
     * Gets the website email address.
     *
     * @return The website email address.
     */
    public String getWebSiteEmail() {
        return webSiteEmail;
    }

    /**
     * Gets the test email address.
     *
     * @return The test email address.
     */
    public String getTestEmail() {
        return testEmail;
    }

    /**
     * Gets the site name.
     *
     * @return The site name.
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * Gets the web address.
     *
     * @return The web address.
     */
    public String getWebAddress() {
        return webAddress;
    }

    /**
     * Gets the SSL web address.
     *
     * @return The SSL web address.
     */
    public String getSslWebAddress() {
        return sslWebAddress;
    }

    /**
     * Gets the CofC REST services URL.
     *
     * @return The CofC REST services URL.
     */
    public String getCofCRestServices() {
        return cofcRestServices;
    }

    /**
     * Gets the test CWID.
     *
     * @return The test CWID.
     */
    public String getTestCWID() {
        return testCWID;
    }

    /**
     * Gets the workflow principal.
     *
     * @return The workflow principal.
     */
    public String getWorkFlowPrincipal() {
        return workFlowPrincipal;
    }

    /**
     * Gets the workflow credential.
     *
     * @return The workflow credential.
     */
    public String getWorkFlowCredential() {
        return workFlowCredential;
    }

    /**
     * Gets the workflow primary key.
     *
     * @return The workflow primary key.
     */
    public String getWorkFlowPrimaryKey() {
        return workFlowPrimaryKey;
    }

    /**
     * Gets the maximum file size for upload.
     *
     * @return The maximum file size for upload.
     */
    public int getMaxFileSizeForUpload() {
        return maxFileSizeForUpload;
    }

}
