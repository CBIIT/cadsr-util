/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

public interface DataElementConcept extends AdminComponent
{
   public String getDecIdseq();
   public void setDecIdseq(String aDecIdseq);

   public String getCdIdseq(); 
   public void setCdIdseq(String aCdIdseq);

   public String getProplName();
   public void setProplName(String aProplName);

   public String getOclName();
   public void setOclName(String aOclName);
   
   public String getObjClassPublicId();
   public void setObjClassPublicId(String aObjClassPublicId);
   
   public String getObjClassQualifier();
   public void setObjClassQualifier(String aObjClassQualifier);

   public String getPropertyPublicId();
   public void setPropertyPublicId(String aPropertyPublicId);

   public String getPropertyQualifier();
   public void setPropertyQualifier(String aPropertyQualifier);

   public String getChangeNote();
   public void setChangeNote(String aChangeNote);
   public String getObjClassPrefName();

   public String getObjClassContextName();
   public String getPropertyPrefName();

   public String getPropertyContextName();
   public Float getObjClassVersion();
   public Float getPropertyVersion();
   public String getContextName();
   public String getCDContextName();
   public String getCDPrefName();
   public Float getCDVersion();
   public int getCDPublicId();
   public void setCDPublicId(int publicId);
   
   public Property getProperty();
   public void setProperty(Property newProperty);
   
   public ObjectClass getObjectClass();
   public void setObjectClass(ObjectClass newObjectClass);   
   
}