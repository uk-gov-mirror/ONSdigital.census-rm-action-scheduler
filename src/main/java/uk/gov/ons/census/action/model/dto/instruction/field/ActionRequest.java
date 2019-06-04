//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.2.11
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.04.04 at 08:02:09 AM BST
//

package uk.gov.ons.census.action.model.dto.instruction.field;

import javax.xml.bind.annotation.*;
import lombok.Data;

/**
 * Java class for ActionRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ActionRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ons.gov.uk/ctp/response/action/message/instruction}Action"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="actionPlan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="actionType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="questionSet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contact" type="{http://ons.gov.uk/ctp/response/action/message/instruction}ActionContact" minOccurs="0"/&gt;
 *         &lt;element name="address" type="{http://ons.gov.uk/ctp/response/action/message/instruction}ActionAddress" minOccurs="0"/&gt;
 *         &lt;element name="legalBasis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="respondentStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="enrolmentStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="caseGroupStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="caseId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="priority" type="{http://ons.gov.uk/ctp/response/action/message/instruction}Priority" minOccurs="0"/&gt;
 *         &lt;element name="caseRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="iac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="events" type="{http://ons.gov.uk/ctp/response/action/message/instruction}ActionEvent"/&gt;
 *         &lt;element name="exerciseRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="surveyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="surveyRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="returnByDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sampleUnitRef" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "ActionRequest",
    propOrder = {
      "actionPlan",
      "actionType",
      "questionSet",
      "contact",
      "address",
      "pause",
      "legalBasis",
      "region",
      "respondentStatus",
      "enrolmentStatus",
      "caseGroupStatus",
      "caseId",
      "priority",
      "caseRef",
      "iac",
      "events",
      "exerciseRef",
      "userDescription",
      "surveyName",
      "surveyRef",
      "returnByDate",
      "sampleUnitRef",
      "addressType",
      "addressLevel",
      "treatmentId",
      "fieldOfficerId",
      "coordinatorId",
      "undeliveredAsAddress",
      "blankQreReturned",
      "ccsQuestionnaireUrl",
      "ceDeliveryReqd",
      "ceCE1Complete",
      "ceExpectedResponses",
      "ceActualResponses"
    })
@Data
public class ActionRequest extends Action {
  protected String actionPlan;

  @XmlElement(required = true)
  protected String actionType;

  protected String questionSet;
  protected ActionContact contact;
  protected ActionAddress address;
  protected ActionPause pause;
  protected String legalBasis;
  protected String region;
  protected String respondentStatus;
  protected String enrolmentStatus;
  protected String caseGroupStatus;
  protected String caseId;

  @XmlSchemaType(name = "string")
  protected Priority priority;

  protected String caseRef;
  protected String iac;

  @XmlElement(required = true)
  protected ActionEvent events;

  protected String exerciseRef;
  protected String userDescription;
  protected String surveyName;
  protected String surveyRef;
  protected String returnByDate;

  @XmlElement(required = true)
  protected String sampleUnitRef;

  protected String addressType;
  protected String addressLevel;
  protected String treatmentId;
  protected String fieldOfficerId;
  protected String coordinatorId;

  protected Boolean undeliveredAsAddress;
  protected Boolean blankQreReturned;

  protected String ccsQuestionnaireUrl;
  protected Boolean ceDeliveryReqd;
  protected Boolean ceCE1Complete;
  protected Integer ceExpectedResponses;
  protected Integer ceActualResponses;
}