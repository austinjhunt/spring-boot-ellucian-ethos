package edu.charleston.spring_boot_ellucian_ethos.services;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Optional;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Utility class for logging and user information retrieval.
 */
public class LoggingService {

    /**
     * Private constructor to prevent instantiation.
     */
    private LoggingService() {
    }

    /**
     * Resolves the user's culture based on the request's Accept-Language header.
     *
     * @param request The HttpServletRequest object.
     * @return An Optional containing the user's Locale, or an empty Optional if
     *         resolution fails.
     */
    public static Optional<Locale> resolveUserCulture(HttpServletRequest request) {
        String locales = request.getHeader("Accept-Language");
        if (locales == null) {
            return Optional.empty();
        }
        String[] languages = locales.split(",");

        try {
            if (languages != null && languages.length > 0) {
                return Optional.of(Locale.forLanguageTag(languages[0].toLowerCase().trim()));
            }
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }

        return Optional.empty();
    }

    /**
     * Resolves the user's language based on the request's Accept-Language header.
     *
     * @param request The HttpServletRequest object.
     * @return The user's language code, or an empty string if resolution fails.
     */
    public static String resolveUserLanguage(HttpServletRequest request) {
        return resolveUserCulture(request).map(Locale::getLanguage).orElse("");
    }

    /**
     * Resolves the user's country based on the request's Accept-Language header.
     *
     * @param request The HttpServletRequest object.
     * @return The user's country code, or an empty string if resolution fails.
     */
    public static String resolveUserCountry(HttpServletRequest request) {
        return resolveUserCulture(request).map(Locale::getCountry).orElse("");
    }

    /**
     * Gets the user's IP address from the request.
     *
     * @param request The HttpServletRequest object.
     * @return The user's IP address.
     */
    public static String getUserIPAddress(HttpServletRequest request) {
        String ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (ip == null || ip.isEmpty()) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * Gets the MAC address of the first network interface.
     *
     * @return The MAC address, or an empty string if retrieval fails.
     */
    public static String getMACAddress() {
        String macAddress = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                if (macAddress.isEmpty()) {
                    byte[] mac = networkInterface.getHardwareAddress();
                    if (mac != null) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < mac.length; i++) {
                            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                        }
                        macAddress = sb.toString();
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return macAddress;
    }

    /**
     * Gets the user's browser from the request's User-Agent header.
     *
     * @param request The HttpServletRequest object.
     * @return The browser name, or "Unknown Browser" if detection fails.
     */
    public static String getUserBrowser(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent == null) {
            return "";
        }

        // Simple browser extraction (can be improved with a proper User-Agent parser)
        if (userAgent.contains("Chrome")) {
            return "Chrome";
        } else if (userAgent.contains("Firefox")) {
            return "Firefox";
        } else if (userAgent.contains("Safari")) {
            return "Safari";
        } else if (userAgent.contains("Edge")) {
            return "Edge";
        } else if (userAgent.contains("MSIE") || userAgent.contains("Trident/")) {
            return "Internet Explorer";
        } else {
            return "Unknown Browser";
        }
    }

    /**
     * Logs an error message by sending an email.
     *
     * @param errorMessage The error message to log.
     * @param request      The HttpServletRequest object.
     */
    public static void logErrorByEmail(String errorMessage, HttpServletRequest request) {
        if (SiteConfiguration.enableErrorLogEmail) {
            String fullErrorMessage = "Exception generated.\n\n Page location: " + request.getRequestURI()
                    + "\n\n Message: " + errorMessage;

            String subject = SiteConfiguration.siteName + " - Ooops!";
            String body = fullErrorMessage;

            EmailService emailService = new EmailService(
                    SiteConfiguration.webSiteEmailSmtpHost,
                    SiteConfiguration.webSiteEmailSmtpPort,
                    SiteConfiguration.webSiteEmail,
                    SiteConfiguration.webSiteEmailPassword);
            subject = emailService.addTimestampToSubject(subject);

            boolean result = emailService.sendSync(SiteConfiguration.webSiteEmail, SiteConfiguration.errorLogEmail,
                    subject, body, false);

            if (!result) {
                System.out.println("Error sending email");
            }

        }
    }

    /**
     * Logs an exception by sending an email.
     *
     * @param ex      The exception to log.
     * @param request The HttpServletRequest object.
     */
    public static void logErrorByEmail(Exception ex, HttpServletRequest request) {
        if (SiteConfiguration.enableErrorLogEmail) {
            String errorMessage = "Exception generated.\n\n Page location: " + request.getRequestURI()
                    + "\n\n Message: " + ex.getMessage() + "\n\n Source: " + ex.getStackTrace()[0].getClassName()
                    + "\n\n Method: " + ex.getStackTrace()[0].getMethodName() + "\n\n Stack Trace: "
                    + ex.getStackTrace()[0].toString();

            String subject = SiteConfiguration.siteName + " - Ooops!";
            String body = errorMessage;

            EmailService emailService = new EmailService(
                    SiteConfiguration.webSiteEmailSmtpHost,
                    SiteConfiguration.webSiteEmailSmtpPort,
                    SiteConfiguration.webSiteEmail,
                    SiteConfiguration.webSiteEmailPassword);

            subject = emailService.addTimestampToSubject(subject);

            boolean result = emailService.sendSync(SiteConfiguration.webSiteEmail, SiteConfiguration.errorLogEmail,
                    subject, body, false);

            if (!result) {
                System.out.println("Error sending email");
            }
        }
    }
}

/**
 * Configuration class for site settings.
 */
class SiteConfiguration {
    public static boolean enableErrorLogEmail = true;
    public static String siteName = "YourSite";
    public static String webSiteEmail = "your_email@gmail.com";
    public static String errorLogEmail = "error_log@example.com";
    public static String webSiteEmailPassword = "your_password";
    public static String webSiteEmailSmtpHost = "smtp.gmail.com";
    public static int webSiteEmailSmtpPort = 587;
}