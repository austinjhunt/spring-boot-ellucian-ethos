package edu.charleston.spring_boot_ellucian_ethos.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import edu.charleston.spring_boot_ellucian_ethos.model.Course;
import edu.charleston.spring_boot_ellucian_ethos.model.Department;
import edu.charleston.spring_boot_ellucian_ethos.model.Document;
import edu.charleston.spring_boot_ellucian_ethos.model.Employee;
import edu.charleston.spring_boot_ellucian_ethos.model.FOAP;
import edu.charleston.spring_boot_ellucian_ethos.model.FormData;
import edu.charleston.spring_boot_ellucian_ethos.model.Grade;
import edu.charleston.spring_boot_ellucian_ethos.model.SiteConfiguration;
import edu.charleston.spring_boot_ellucian_ethos.model.Student;
import edu.charleston.spring_boot_ellucian_ethos.model.Term;
import edu.charleston.spring_boot_ellucian_ethos.model.WorkflowRole;
import edu.charleston.spring_boot_ellucian_ethos.model.WorkflowUser;
import edu.charleston.spring_boot_ellucian_ethos.model.WormData;
import edu.charleston.spring_boot_ellucian_ethos.model.XRef;

/**
 * Service for interacting with the CofC REST services.
 */
@Service
public class CofCRestService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final SiteConfiguration siteConfiguration;

    @Autowired
    public CofCRestService(RestTemplate restTemplate, ObjectMapper objectMapper, SiteConfiguration siteConfiguration) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.siteConfiguration = siteConfiguration;
    }

    /**
     * 
     * @return boolean - true if rest service available based on student test record
     *         response, false otherwise
     */
    public boolean isAvailable() {
        try {
            Student record = getStudent(siteConfiguration.getTestCWID());
            return record != null && record.getCwid() != null && !record.getCwid().isEmpty();
        } catch (Exception e) {
            e.printStackTrace(); // consider using logger with logger factory
            return false;
        }

    }

    /**
     * Calls a CofC REST service and returns the deserialized object.
     *
     * @param <T>          The type of the expected response object.
     * @param url          The URL of the REST service.
     * @param responseType The class of the expected response object.
     * @return The deserialized response object, or null if an error occurred.
     */
    private <T> T get(String url, Class<T> responseType) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return objectMapper.readValue(response.getBody(), responseType);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger instead of printStackTrace
        }
        return null;
    }

    /**
     * Calls a CofC REST service and returns a list of deserialized objects.
     *
     * @param <T>          The type of the expected response objects.
     * @param url          The URL of the REST service.
     * @param responseType The TypeReference of the expected response list.
     * @return The deserialized response list, or null if an error occurred.
     */
    private <T> List<T> list(String url, TypeReference<List<T>> responseType) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return objectMapper.readValue(response.getBody(), responseType);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger instead of printStackTrace
        }
        return null;
    }

    /**
     * Calls a CofC REST service to save data and returns the deserialized object.
     *
     * @param <T>          The type of the data object and the expected response
     *                     object.
     * @param url          The URL of the REST service.
     * @param data         The data object to save.
     * @param responseType The class of the expected response object.
     * @return The deserialized response object, or null if an error occurred.
     */
    private <T> T create(String url, T data, Class<T> responseType) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<T> requestEntity = new HttpEntity<>(data, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return objectMapper.readValue(response.getBody(), responseType);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger instead of printStackTrace
        }
        return null;
    }

    /**
     * Calls a CofC REST service to delete data and returns the deserialized object.
     *
     * @param <T>          The type of the expected response object.
     * @param url          The URL of the REST service.
     * @param responseType The class of the expected response object.
     * @return The deserialized response object, or null if an error occurred.
     */
    private <T> T delete(String url, Class<T> responseType) {
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return objectMapper.readValue(response.getBody(), responseType);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger instead of printStackTrace
        }
        return null;
    }

    /**
     * Calls a CofC REST service to update data and returns the deserialized object.
     *
     * @param <T>          The type of the expected response object.
     * @param url          The URL of the REST service.
     * @param responseType The class of the expected response object.
     * @return The deserialized response object, or null if an error occurred.
     */
    private <T> T update(String url, Class<T> responseType) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return objectMapper.readValue(response.getBody(), responseType);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger instead of printStackTrace
        }
        return null;
    }

    // ******************************************************************************
    // *** Course
    // *******************************************************************
    // ******************************************************************************

    /**
     * Retrieves course information.
     * 
     * @param term    term of the course
     * @param subject subject of the course
     * @param number  course number
     * @param section section of the course
     * @return Course object.
     */
    public Course getCourse(String term, String subject, String number, String section) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "course/%s/%s/%s/%s", term, subject,
                number, section);
        return get(url, Course.class);
    }

    /**
     * Retrieves course information by CRN.
     * 
     * @param term     term of the course.
     * @param crn      crn of the course.
     * @param partTerm part term of the course.
     * @param levlCode level code of the course.
     * @return Course object.
     */
    public Course getCourseByCRN(String term, String crn, String partTerm, String levlCode) {
        String url = siteConfiguration.getCofCRestServices() + "course";
        if (levlCode != null && !levlCode.isEmpty()) {
            url += levlCode.equalsIgnoreCase(Course.CourseLevelCodes.GRAD.toString()) ? "/grad" : "/undergrad";
        }
        url += String.format("/%s/%s", term, crn);
        if (partTerm != null && !partTerm.isEmpty()) {
            url += String.format("/%s", partTerm);
        }
        return get(url, Course.class);
    }

    /**
     * Retrieves subjects for a given term.
     *
     * @param term     term of the subjects.
     * @param partTerm part term of the subjects.
     * @param levlCode level code of the subjects.
     * @return List of Course objects.
     */
    public List<Course> getSubjects(String term, String partTerm, String levlCode) {
        String url = siteConfiguration.getCofCRestServices() + "course/subjects";
        if (levlCode != null && !levlCode.isEmpty()) {
            url += levlCode.equalsIgnoreCase(Course.CourseLevelCodes.GRAD.toString()) ? "/grad" : "/undergrad";
        }
        url += String.format("/%s", term);
        if (partTerm != null && !partTerm.isEmpty()) {
            url += String.format("/%s", partTerm);
        }
        return list(url, new TypeReference<List<Course>>() {
        });
    }

    /**
     * Retrieves course numbers for a given term and subject.
     *
     * @param term     term of the courses.
     * @param subject  subject of the courses.
     * @param partTerm part term of the courses.
     * @param levlCode level code of the courses.
     * @return List of Course objects.
     */
    public List<Course> getNumbers(String term, String subject, String partTerm, String levlCode) {
        String url = siteConfiguration.getCofCRestServices() + "course/numbers";
        if (levlCode != null && !levlCode.isEmpty()) {
            url += levlCode.equalsIgnoreCase(Course.CourseLevelCodes.GRAD.toString()) ? "/grad" : "/undergrad";
        }
        url += String.format("/%s/%s", term, subject);
        if (partTerm != null && !partTerm.isEmpty()) {
            url += String.format("/%s", partTerm);
        }
        return list(url, new TypeReference<List<Course>>() {
        });
    }

    /**
     * Retrieves course sections for a given term, subject, and number.
     *
     * @param term     term of the courses.
     * @param subject  subject of the courses.
     * @param number   course number.
     * @param partTerm part term of the courses.
     * @return List of Course objects.
     */
    public List<Course> getSections(String term, String subject, String number, String partTerm) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "course/sections/%s/%s/%s", term, subject,
                number);
        if (partTerm != null && !partTerm.isEmpty()) {
            url += String.format("/%s", partTerm);
        }
        return list(url, new TypeReference<List<Course>>() {
        });
    }

    /**
     * Retrieves course information for a registered course.
     *
     * @param term term of the course.
     * @param crn  CRN of the course.
     * @param cwid CWID of the student.
     * @return Course object.
     */
    public Course getCourseRegistered(String term, String crn, String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "course/registered/%s/%s/%s", term, crn,
                cwid);
        return get(url, Course.class);
    }

    /**
     * Retrieves course information for a graded course.
     *
     * @param term term of the course.
     * @param crn  CRN of the course.
     * @param cwid CWID of the student.
     * @return Course object.
     */
    public Course getCourseGraded(String term, String crn, String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "course/graded/%s/%s/%s", term, crn, cwid);
        return get(url, Course.class);
    }

    /**
     * Retrieves cross-referenced courses.
     *
     * @param term     term of the courses.
     * @param partTerm part term of the courses.
     * @param dept     department of the courses.
     * @param index    index of the courses.
     * @return List of Course objects.
     */
    public List<Course> getXRefCourses(String term, String partTerm, String dept, String index) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "course/subjects/xref/%s/%s/%s/%s", term,
                partTerm, dept, index);
        return list(url, new TypeReference<List<Course>>() {
        });
    }

    /**
     * Retrieves catalog years.
     *
     * @return List of Course objects representing catalog years.
     */
    public List<Course> getCatalogYears() {
        String url = siteConfiguration.getCofCRestServices() + "course/catyears";
        return list(url, new TypeReference<List<Course>>() {
        });
    }

    // ******************************************************************************
    // *** Department
    // ***************************************************************
    // ******************************************************************************

    /**
     * Retrieves all departments.
     *
     * @return List of Department objects.
     */
    public List<Department> getDepartments() {
        String url = siteConfiguration.getCofCRestServices() + "department/all";
        return list(url, new TypeReference<List<Department>>() {
        });
    }

    /**
     * Retrieves departments for an employee.
     *
     * @param cwid CWID of the employee.
     * @return List of Department objects.
     */
    public List<Department> getEmplDepartment(String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "department/%s", cwid);
        return list(url, new TypeReference<List<Department>>() {
        });
    }

    // ******************************************************************************
    // *** Document
    // *****************************************************************
    // ******************************************************************************

    /**
     * Saves a document.
     *
     * @param document Document object to save.
     * @return Saved Document object.
     */
    public Document saveDocument(Document document) {
        String url = siteConfiguration.getCofCRestServices() + "document/new";
        return create(url, document, Document.class);
    }

    /**
     * Retrieves a document by ID.
     *
     * @param id ID of the document.
     * @return Document object.
     */
    public Document getDocument(String id) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "document/%s", id);
        return get(url, Document.class);
    }

    /**
     * Removes a document by ID.
     *
     * @param id ID of the document to remove.
     * @return String result of the removal.
     */
    public String removeDocument(String id) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "document/%s", id);
        return delete(url, String.class);
    }

    /**
     * Updates the form ID of a document.
     *
     * @param documentID ID of the document.
     * @param newFormID  new form ID.
     * @return String result of the update.
     */
    public String updateDocumentFormID(String documentID, String newFormID) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "document/%s/%s", documentID, newFormID);
        return update(url, String.class);
    }

    /**
     * Retrieves annual salary information for an employee.
     *
     * @param cwid CWID of the employee.
     * @return Employee object containing annual salary information.
     */
    public Employee getAnnualSalary(String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "finance/empl/%s", cwid);
        return get(url, Employee.class);
    }

    /**
     * Retrieves hourly rate information for an employee.
     *
     * @param cwid CWID of the employee.
     * @return Employee object containing hourly rate information.
     */
    public Employee getHourlyRate(String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "finance/empl/hr/%s", cwid);
        return get(url, Employee.class);
    }

    /**
     * Retrieves position information for an employee.
     *
     * @param cwid CWID of the employee.
     * @return Employee object containing position information.
     */
    public Employee getPosition(String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "finance/empl/pos/%s", cwid);
        return get(url, Employee.class);
    }

    /**
     * Retrieves FOAP information by index.
     *
     * @param index FOAP index.
     * @return FOAP object.
     */
    public FOAP getFOAP(String index) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "finance/foap/%s", index);
        return get(url, FOAP.class);
    }

    /**
     * Retrieves valid account information.
     *
     * @param account Account number.
     * @return FOAP object.
     */
    public FOAP getValidAccount(String account) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "finance/acct/%s", account);
        return get(url, FOAP.class);
    }

    /**
     * Retrieves valid index information.
     *
     * @param index FOAP index.
     * @return FOAP object.
     */
    public FOAP getValidIndex(String index) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "finance/acci/%s", index);
        return get(url, FOAP.class);
    }

    // ******************************************************************************
    // *** Form Data
    // ****************************************************************
    // ******************************************************************************

    /**
     * Creates a new form data record.
     *
     * @param data FormData object to create.
     * @return Created FormData object.
     */
    public FormData createFormDataRecord(FormData data) {
        String url = siteConfiguration.getCofCRestServices() + "formdata/new";
        return create(url, data, FormData.class);
    }

    /**
     * Retrieves form data by key.
     *
     * @param key Key of the form data.
     * @return FormData object.
     */
    public FormData getFormData(String key) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "formdata/%s", key);
        return get(url, FormData.class);
    }

    /**
     * Retrieves form information by ID.
     *
     * @param id ID of the form.
     * @return FormData object containing form information.
     */
    public FormData getFormInfo(String id) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "formdata/info/%s", id);
        return get(url, FormData.class);
    }

    /**
     * Retrieves the CWID of the form initiator by session hash.
     *
     * @param hash Session hash.
     * @return CWID of the form initiator.
     */
    public String getFormInitiatorCWID(String hash) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "formdata/session/%s", hash);
        return get(url, String.class);
    }

    /**
     * Retrieves the SSB term by session hash.
     *
     * @param hash Session hash.
     * @return SSB term.
     */
    public String getSSBTerm(String hash) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "formdata/session/term/%s", hash);
        return get(url, String.class);
    }

    /**
     * Retrieves the agreement text for a form.
     *
     * @param formID ID of the form.
     * @return Agreement text.
     */
    public String getAgreementText(String formID) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "formdata/agr/%s", formID);
        return get(url, String.class);
    }

    /**
     * Saves form data as a PDF.
     *
     * @param key Key of the form data.
     * @return Boolean indicating success or failure.
     */
    public boolean saveFormDataAsPDF(String key) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "formdata/pdf/%s", key);
        return get(url, Boolean.class);
    }

    // ******************************************************************************
    // *** Grade
    // ********************************************************************
    // ******************************************************************************

    /**
     * Retrieves default grades for a course.
     *
     * @param term term of the course.
     * @param subj subject of the course.
     * @param numb course number.
     * @return List of Grade objects.
     */
    public List<Grade> getDefaultGrade(String term, String subj, String numb) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "grade/default/%s/%s/%s", term, subj,
                numb);
        return list(url, new TypeReference<List<Grade>>() {
        });
    }

    /**
     * Retrieves default grades for a graduate course.
     *
     * @param term term of the course.
     * @param subj subject of the course.
     * @param numb course number.
     * @return List of Grade objects.
     */
    public List<Grade> getDefaultGradeGrad(String term, String subj, String numb) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "grade/default/grad/%s/%s/%s", term, subj,
                numb);
        return list(url, new TypeReference<List<Grade>>() {
        });
    }

    /**
     * Retrieves the final grade for a student in a course.
     *
     * @param term term of the course.
     * @param crn  CRN of the course.
     * @param cwid CWID of the student.
     * @return Grade object.
     */
    public Grade getFinalGrade(String term, String crn, String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "grade/final/%s/%s/%s", term, crn, cwid);
        return get(url, Grade.class);
    }

    /**
     * Retrieves possible grades for a student in a course.
     *
     * @param term term of the course.
     * @param crn  CRN of the course.
     * @param cwid CWID of the student.
     * @return List of Grade objects.
     */
    public List<Grade> getPossibleGrades(String term, String crn, String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "grade/%s/%s/%s", term, crn, cwid);
        return list(url, new TypeReference<List<Grade>>() {
        });
    }

    /**
     * Retrieves possible grades for a graduate student in a course.
     *
     * @param term term of the course.
     * @param crn  CRN of the course.
     * @param cwid CWID of the student.
     * @return List of Grade objects.
     */
    public List<Grade> getPossibleGradesGrad(String term, String crn, String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "grade/grad/%s/%s/%s", term, crn, cwid);
        return list(url, new TypeReference<List<Grade>>() {
        });
    }

    // ******************************************************************************
    // *** Student
    // ******************************************************************
    // ******************************************************************************

    /**
     * Retrieves student information by CWID.
     *
     * @param cwid CWID of the student.
     * @return Student object.
     */
    public Student getStudent(String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "student/%s", cwid);
        return get(url, Student.class);
    }

    /**
     * Retrieves students by advisor.
     *
     * @param cwid CWID of the advisor.
     * @param term term of the students.
     * @return List of Student objects.
     */
    public List<Student> getStudentsByAdvisor(String cwid, String term) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "student/students/byadvisor/%s/%s", cwid,
                term);
        return list(url, new TypeReference<List<Student>>() {
        });
    }

    /**
     * Retrieves advisors by student.
     *
     * @param cwid CWID of the student.
     * @param term term of the advisors.
     * @return List of Student objects representing advisors.
     */
    public List<Student> getAdvisorsByStudent(String cwid, String term) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "student/advisors/bystudent/%s/%s", cwid,
                term);
        return list(url, new TypeReference<List<Student>>() {
        });
    }

    /**
     * Retrieves class level for a student.
     *
     * @param cwid CWID of the student.
     * @param term term of the class level.
     * @return Student object containing class level information.
     */
    public Student getClassLevel(String cwid, String term) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "student/levelbyterm/%s/%s", cwid, term);
        return get(url, Student.class);
    }

    /**
     * Retrieves advisor information for a student.
     *
     * @param cwid CWID of the student.
     * @param term term of the advisor.
     * @return Student object representing the advisor.
     */
    public Student getAdvisor(String cwid, String term) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "student/advisor/%s/%s", cwid, term);
        return get(url, Student.class);
    }

    /**
     * Retrieves employee status by CWID.
     *
     * @param cwid CWID of the employee.
     * @return Employee status.
     */
    public String getEmployeeStatus(String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "student/empl/%s", cwid);
        return get(url, String.class);
    }

    /**
     * Retrieves employee class information by CWID.
     *
     * @param cwid CWID of the employee.
     * @return Student object containing employee class information.
     */
    public Student getEmployeeClass(String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "student/empl/class/%s", cwid);
        return get(url, Student.class);
    }

    /**
     * Retrieves SSB roles by CWID.
     *
     * @param cwid CWID of the user.
     * @return SSB roles.
     */
    public String getSSBRolesByCWID(String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "student/roles/%s", cwid);
        return get(url, String.class);
    }

    /**
     * Retrieves addresses for a student.
     *
     * @param cwid CWID of the student.
     * @return List of Student objects representing addresses.
     */
    public List<Student> getAddresses(String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "student/address/%s", cwid);
        return list(url, new TypeReference<List<Student>>() {
        });
    }

    /**
     * Retrieves phone numbers for a student.
     *
     * @param cwid CWID of the student.
     * @return List of Student objects representing phone numbers.
     */
    public List<Student> getPhones(String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "student/phone/%s", cwid);
        return list(url, new TypeReference<List<Student>>() {
        });
    }

    /**
     * Retrieves the supervisor information for a student.
     *
     * @param cwid CWID of the student.
     * @return Student object representing the supervisor.
     */
    public Student getSupervisor(String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "student/supervisor/%s", cwid);
        return get(url, Student.class);
    }

    // ******************************************************************************
    // *** Term
    // *********************************************************************
    // ******************************************************************************

    /**
     * Retrieves terms within a specified range of days.
     *
     * @param daysBack    Number of days back from the current date.
     * @param daysForward Number of days forward from the current date.
     * @return List of Term objects.
     */
    public List<Term> getTerms(int daysBack, int daysForward) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "term/%d/%d", daysBack, daysForward);
        return list(url, new TypeReference<List<Term>>() {
        });
    }

    /**
     * Retrieves part terms for a given term.
     *
     * @param term Term identifier.
     * @return List of Term objects.
     */
    public List<Term> getPartTerm(String term) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "term/%s", term);
        return list(url, new TypeReference<List<Term>>() {
        });
    }

    /**
     * Retrieves the current term.
     *
     * @return Term object representing the current term.
     */
    public Term getCurrentTerm() {
        String url = siteConfiguration.getCofCRestServices() + "term/current";
        return get(url, Term.class);
    }

    // ******************************************************************************
    // *** Workflow
    // *****************************************************************
    // ******************************************************************************

    /**
     * Retrieves owner roles for a user.
     *
     * @param cwid CWID of the user.
     * @return List of WorkflowRole objects.
     */
    public List<WorkflowRole> getOwnerRoles(String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "workflow/roles/%s", cwid);
        return list(url, new TypeReference<List<WorkflowRole>>() {
        });
    }

    /**
     * Retrieves all roles for a user.
     *
     * @param cwid CWID of the user.
     * @return List of WorkflowRole objects.
     */
    public List<WorkflowRole> getAllRolesByCWID(String cwid) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "workflow/roles/all/%s", cwid);
        return list(url, new TypeReference<List<WorkflowRole>>() {
        });
    }

    /**
     * Retrieves assigned roles for an owner role.
     *
     * @param ownerRole Owner role identifier.
     * @return List of WorkflowRole objects.
     */
    public List<WorkflowRole> getAssignedRoles(String ownerRole) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "workflow/roles/assigned/%s", ownerRole);
        return list(url, new TypeReference<List<WorkflowRole>>() {
        });
    }

    /**
     * Retrieves user roles for a specific user and owner role.
     *
     * @param userName  User name.
     * @param ownerRole Owner role identifier.
     * @return List of WorkflowRole objects.
     */
    public List<WorkflowRole> getUserRoles(String userName, String ownerRole) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "workflow/roles/assigned/%s/%s", userName,
                ownerRole);
        return list(url, new TypeReference<List<WorkflowRole>>() {
        });
    }

    /**
     * Retrieves users by owner role.
     *
     * @param ownerRole Owner role identifier.
     * @return List of WorkflowUser objects.
     */
    public List<WorkflowUser> getUsersByOwnerRole(String ownerRole) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "workflow/users/%s", ownerRole);
        return list(url, new TypeReference<List<WorkflowUser>>() {
        });
    }

    // ******************************************************************************
    // *** Worm Data
    // ****************************************************************
    // ******************************************************************************

    /**
     * Creates a new worm data record.
     *
     * @param data WormData object to create.
     * @return Created WormData object.
     */
    public WormData createWormDataRecord(WormData data) {
        String url = siteConfiguration.getCofCRestServices() + "formdata/new/worm";
        return create(url, data, WormData.class);
    }

    // ******************************************************************************
    // *** XRef
    // *********************************************************************
    // ******************************************************************************

    /**
     * Retrieves all cross-referenced departments.
     *
     * @return List of XRef objects representing departments.
     */
    public List<XRef> getXRefDepartments() {
        String url = siteConfiguration.getCofCRestServices() + "xref/dept/all";
        return list(url, new TypeReference<List<XRef>>() {
        });
    }

    /**
     * Retrieves cross-referenced departments for the north region.
     *
     * @return List of XRef objects representing departments.
     */
    public List<XRef> getXRefDepartmentsNorth() {
        String url = siteConfiguration.getCofCRestServices() + "xref/dept/north";
        return list(url, new TypeReference<List<XRef>>() {
        });
    }

    /**
     * Retrieves cross-referenced departments for the summer region.
     *
     * @return List of XRef objects representing departments.
     */
    public List<XRef> getXRefDepartmentsSummer() {
        String url = siteConfiguration.getCofCRestServices() + "xref/dept/summer";
        return list(url, new TypeReference<List<XRef>>() {
        });
    }

    /**
     * Retrieves cross-referenced indexes by department.
     *
     * @param dept Department identifier.
     * @return List of XRef objects representing indexes.
     */
    public List<XRef> getXRefIndexesByDept(String dept) {
        String url = String.format(siteConfiguration.getCofCRestServices() + "xref/indexes/%s", dept);
        return list(url, new TypeReference<List<XRef>>() {
        });
    }

    /**
     * Retrieves all cross-referenced accounts.
     *
     * @return List of XRef objects representing accounts.
     */
    public List<XRef> getXRefAccounts() {
        String url = siteConfiguration.getCofCRestServices() + "xref/acct/all";
        return list(url, new TypeReference<List<XRef>>() {
        });
    }

    /**
     * Retrieves cross-referenced accounts for the summer region.
     *
     * @return List of XRef objects representing accounts.
     */
    public List<XRef> getXRefAccountsSummer() {
        String url = siteConfiguration.getCofCRestServices() + "xref/acct/summer";
        return list(url, new TypeReference<List<XRef>>() {
        });
    }

    /**
     * Retrieves cross-referenced accounts excluding the summer region.
     *
     * @return List of XRef objects representing accounts.
     */
    public List<XRef> getXRefAccountsNoSummer() {
        String url = siteConfiguration.getCofCRestServices() + "xref/acct/nosummer";
        return list(url, new TypeReference<List<XRef>>() {
        });
    }

}