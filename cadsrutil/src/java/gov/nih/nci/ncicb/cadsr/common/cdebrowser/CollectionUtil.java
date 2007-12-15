package gov.nih.nci.ncicb.cadsr.cdebrowser;
import gov.nih.nci.ncicb.cadsr.dto.bc4j.BC4JDataElementTransferObject;
import gov.nih.nci.ncicb.cadsr.resource.DataElement;
import gov.nih.nci.ncicb.cadsr.util.DTOTransformer;
import java.util.Iterator;
import java.util.List;

/**
 * Collection and cdebrowser related utilities
 */
public class CollectionUtil 
{
  public CollectionUtil()
  {
  }
  public static DataElement locateDataElement(
    List results,
    String deId) {
    Iterator it = results.iterator();
    DataElement de = null;

    while (it.hasNext()) {
      de = (DataElement) it.next();

      if (de.getDeIdseq().equals(deId)) {
        return DTOTransformer.toDataElement((BC4JDataElementTransferObject) de);
      }
    }

    return de;
  }  
}