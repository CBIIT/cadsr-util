package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.Question;
import gov.nih.nci.ncicb.cadsr.common.resource.QuestionInstruction;


public class QuestionInstructionTransferObject extends InstructionTransferObject
  implements QuestionInstruction {

  private Question term;
  
  public QuestionInstructionTransferObject() {
  }

  public Question getQuestion() {
    return term;
  }

  public void setQuestion(Question term) {
    this.term = term;
  }

  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append(OBJ_SEPARATOR_START);
    sb.append(super.toString());
    sb.append(OBJ_SEPARATOR_END);
    
    Question question = getQuestion();

    if (question != null) {
      sb.append(ATTR_SEPARATOR + "Question=" + question);
    }
    else {
      sb.append(ATTR_SEPARATOR + "Question=" + null);
    }

    sb.append(OBJ_SEPARATOR_END);

    return sb.toString();
  }
  
}
