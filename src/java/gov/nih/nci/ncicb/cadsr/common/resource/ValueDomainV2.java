package gov.nih.nci.ncicb.cadsr.common.resource;

import java.util.List;

public interface ValueDomainV2 extends ValueDomain
{
   public List getPermissibleValueV2();
   public void setPermissibleValueV2(List permissibleValuesV2);
 
}