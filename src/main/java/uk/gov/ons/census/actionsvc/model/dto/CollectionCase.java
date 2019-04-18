package uk.gov.ons.census.actionsvc.model.dto;

import lombok.Data;

@Data
public class CollectionCase {
  private String id;
  private String caseRef;
  private String survey;
  private String collectionExerciseId;
  private Address address;
  private String state;
  private String actionableFrom;

  // OTHER STUFF WE NEED IN THE ACTION SERVICE
  private String actionPlanId;
  private String uac;
  private String treatmentCode;
}
