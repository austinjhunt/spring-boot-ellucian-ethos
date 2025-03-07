package edu.charleston.spring_boot_ellucian_ethos.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for managing session data.
 */
public class SessionUtil {

    public String FormID;
    public String WorkflowEventName;
    public String InitiatorCWID;
    public String WorkflowOwnerRole;
    public String TermsAndConditions;
    public Course CourseInfo;
    public Departments DepartmentInfo;
    public FOAP FOAPInfo;
    public Student StudentInfo;
    public Map<String, Student> People = new HashMap<>();
    public String Notes;
    public String Department;
    public String CoursePartOfTerm;
    public String CurrentTerm;
    public String StudentAddress;
    public String StudentPhone;
    public String List;
    public DynamicSessions Dates;
    public DynamicSessions Grades;
    public DynamicSessions TextBoxes;
    public DynamicSessions TextAreas;
    public DynamicSessions YesNos;
    public DynamicSessions RadioLists;
    public DynamicSessions Stuff;
    public DynamicSessions UploadedFiles;
    public DynamicSessions DropDowns;
    public RoleUsers OriginalRoles;
    public RoleUsers UpdatedRoles;
    public NavigatorState WebFormNavigator;
    public String SSBTermCode;

    /**
     * Constructs a new SessionUtil instance.
     */
    public SessionUtil() {
    }

    private static final String SESSION_KEY = "__SU";

    /**
     * Gets the current SessionUtil instance from the HttpSession.
     *
     * @param request The HttpServletRequest object.
     * @return The current SessionUtil instance.
     */
    public static SessionUtil getCurrent(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SessionUtil sessionUtil = (SessionUtil) session.getAttribute(SESSION_KEY);

        if (sessionUtil == null) {
            sessionUtil = new SessionUtil();
            session.setAttribute(SESSION_KEY, sessionUtil);
        }

        return sessionUtil;
    }

    /**
     * Checks if the current SessionUtil instance is set in the HttpSession.
     *
     * @param request The HttpServletRequest object.
     * @return True if the session is set, false otherwise.
     */
    public static boolean isCurrentSessionSet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute(SESSION_KEY) != null;
    }

    /**
     * Removes the current SessionUtil instance from the HttpSession.
     *
     * @param request The HttpServletRequest object.
     */
    public static void removeCurrentSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(SESSION_KEY);
    }

    /**
     * Gets the session key based on the current page.
     *
     * @param request The HttpServletRequest object.
     * @return The session key.
     */
    public static String getSessionKey(HttpServletRequest request) {
        // This function relies on a formKeyL label being present on the page.
        // Since there is no direct equivalent of ASP.NET pages and their controls,
        // this function is left as a stub. You will have to replace this with
        // application specific logic.
        return SESSION_KEY + "__";
    }

    /**
     * Gets the current session data as an XML string.
     *
     * @param request The HttpServletRequest object.
     * @return The XML representation of the session data.
     */
    public static String getCurrentSessionAsXML(HttpServletRequest request) {
        SessionUtil current = getCurrent(request);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element formData = doc.createElement("FormData");
            doc.appendChild(formData);

            if (current.StudentInfo != null) {
                addElement(doc, formData, "CWID", current.StudentInfo.CWID);
                addElement(doc, formData, "First Name", current.StudentInfo.FirstName);
                addElement(doc, formData, "Last Name", current.StudentInfo.LastName);
            }

            if (current.DepartmentInfo != null) {
                addElement(doc, formData, "Employee Department", current.DepartmentInfo.getDepartments());
            }

            if (current.CourseInfo != null) {
                addElement(doc, formData, "Course Term", current.CourseInfo.TermDesc);
                addElement(doc, formData, "Course Term Code", current.CourseInfo.Term);
                addElement(doc, formData, "Course Part Of Term", current.CoursePartOfTerm);
                addElement(doc, formData, "Course CRN", current.CourseInfo.CRN);
                addElement(doc, formData, "Course ID", current.CourseInfo.CourseID);
                addElement(doc, formData, "Course Term Start Date", current.CourseInfo.TermStartDate);
                addElement(doc, formData, "Course Term End Date", current.CourseInfo.TermEndDate);
            }

            if (current.FOAPInfo != null) {
                addElement(doc, formData, "FOAP Index", current.FOAPInfo.Index);
                addElement(doc, formData, "FOAP Title", current.FOAPInfo.Title);
                addElement(doc, formData, "FOAP Fund", current.FOAPInfo.Fund);
                addElement(doc, formData, "FOAP Organization", current.FOAPInfo.Organization);
                addElement(doc, formData, "FOAP Program", current.FOAPInfo.Program);
            }

            if (current.Dates != null)
                current.Dates.addAsXML(doc, formData);
            if (current.Grades != null)
                current.Grades.addAsXML(doc, formData);
            if (current.TextBoxes != null)
                current.TextBoxes.addAsXML(doc, formData);
            if (current.TextAreas != null)
                current.TextAreas.addAsXML(doc, formData);
            if (current.YesNos != null)
                current.YesNos.addAsXML(doc, formData);
            if (current.RadioLists != null)
                current.RadioLists.addAsXML(doc, formData);
            if (current.Stuff != null)
                current.Stuff.addAsXML(doc, formData);
            if (current.DropDowns != null)
                current.DropDowns.addAsXML(doc, formData);

            addElement(doc, formData, "Notes", current.Notes);
            addElement(doc, formData, "Department", current.Department);
            addElement(doc, formData, "Workflow Owner Role", current.WorkflowOwnerRole);
            addElement(doc, formData, "Terms And Conditions", current.TermsAndConditions);
            addElement(doc, formData, "Current Term", current.CurrentTerm);
            addElement(doc, formData, "Student Address", current.StudentAddress);
            addElement(doc, formData, "Student Address", current.StudentPhone);

            String xml = transformDocumentToString(doc);
            xml = appendXML(xml, "List", current.List);

            return xml;

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
            return "<FormData></FormData>";
        }
    }

    private static void addElement(Document doc, Element parent, String sessionName, String sessionValue) {
        if (sessionValue != null && !sessionValue.isEmpty()) {
            Element field = doc.createElement("Field");
            field.setAttribute("Name", sessionName);
            field.appendChild(doc.createTextNode(sessionValue.trim()));
            parent.appendChild(field);
        }
    }

    private static String appendXML(String formDataXML, String sessionName, String sessionValue) {
        if (sessionValue != null && !sessionValue.isEmpty()) {
            int index = formDataXML.indexOf("</FormData>");
            if (index > 0) {
                formDataXML = formDataXML.substring(0, index) + "  <Field Name=\"" + sessionName + "\">\r\n  " + sessionValue + "</Field>\r\n  " + formDataXML.substring(index);
            }
        }

    /**
     * Resets the session data.
     *
     * @param request The HttpServletRequest object.
     */
    public static void resetSession(HttpServletRequest request) {
        SessionUtil current = getCurrent(request);
        current.FormID = "";
        current.WorkflowEventName = "";
        current.InitiatorCWID = "";
        current.Notes = "";
        current.Department = "";
        current.CoursePartOfTerm = "";
        current.TermsAndConditions = "";
        current.List = "";
        current.CurrentTerm = "";
        current.StudentAddress = "";
        current.StudentPhone = "";
        current.SSBTermCode = "";

        current.People.clear();

        if (current.CourseInfo != null)
            current.CourseInfo.clear();
        if (current.DepartmentInfo != null)
            current.DepartmentInfo.clear();
        if (current.FOAPInfo != null)
            current.FOAPInfo.clear();
        if (current.StudentInfo != null)
            current.StudentInfo.clear();

        if (current.Grades != null)
            current.Grades.clear();
        if (current.Dates != null)
            current.Dates.clear();
        if (current.TextBoxes != null)
            current.TextBoxes.clear();
        if (current.TextAreas != null)
            current.TextAreas.clear();
        if (current.YesNos != null)
            current.YesNos.clear();
        if (current.RadioLists != null)
            current.RadioLists.clear();
        if (current.Stuff != null)
            current.Stuff.clear();
        if (current.UploadedFiles != null)
            current.UploadedFiles.clear();
        if (current.DropDowns != null)
            current.DropDowns.clear();

        if (current.WebFormNavigator != null)
            current.WebFormNavigator.clear();
    }

    /**
     * Resets the roles-related session data.
     *
     * @param request The HttpServletRequest object.
     */
    public static void resetRolesSession(HttpServletRequest request) {
        SessionUtil current = getCurrent(request);
        current.WorkflowOwnerRole = "";

        if (current.OriginalRoles != null)
            current.OriginalRoles.clear();
        if (current.UpdatedRoles != null)
            current.UpdatedRoles.clear();
    }

    private static String transformDocumentToString(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        return writer.toString();
    }

}