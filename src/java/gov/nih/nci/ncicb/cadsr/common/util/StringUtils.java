package gov.nih.nci.ncicb.cadsr.util;

import gov.nih.nci.ncicb.cadsr.util.logging.Log;
import gov.nih.nci.ncicb.cadsr.util.logging.LogFactory;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Arrays;


public class StringUtils {
  private static Log log = LogFactory.getLog(StringUtils.class.getName());
  public static boolean toBoolean(String inString) {
    boolean retVal = false;
    if (
      inString.toUpperCase().equals("Y") ||
          inString.toUpperCase().equals("TRUE") ||
          inString.equalsIgnoreCase("Yes")) {
      retVal = true;
    }
    else if (
      inString.toUpperCase().equals("N") ||
          inString.toUpperCase().equals("FALSE") ||
          inString.equalsIgnoreCase("No")) {
      retVal = false;
    }
    return retVal;
  }

  public static String booleanToStr(boolean bool) {
    if (bool) {
      return "Yes";
    }
    else {
      return "No";
    }
  }

  public static String booleanToStrYN(boolean bool) {
    if (bool)
      return "Y";
    else
      return "N";
  }

  public static String[] tokenizeCSVList(String values) {
    String[] retVal = null;

    try {
      java.util.StringTokenizer st = new java.util.StringTokenizer(values, ",");
      int numberOfTokens = st.countTokens();
      retVal = new String[numberOfTokens];

      for (int i = 0; i < numberOfTokens; i++) {
        retVal[i] = st.nextToken();
      }
    }
    catch (Exception e) {
      return new String[0];
    }

    return retVal;
  }
  
  public static boolean isArrayWithEmptyStrings(String[] values) {
    
    if(values==null)
      return true;
    boolean result = true;
    for(int i=0;i<values.length;++i)
    {
      if(values[i]!=null&&!values[i].equalsIgnoreCase(""))
      {
        result = false;
      }
    }
    return result;
   }
  public static String getValidJSString(String sourceStr) {
    String newStr = strReplace(sourceStr, "'", "\\'");
    newStr = strReplace(newStr, "\"", "&quot;");

    return newStr;
  }

  public static String replaceNull(Object obj) {
    if (obj == null) {
      return "";
    }
    else {
      return obj.toString().trim();
    }
  }
  /**
   * This method is used to replace null or empty string with  "&nbsp;";
   * Used in jsp pages 
   */
  public static String ifNullReplaceWithnbsp(String obj) {
    if (obj == null) {
      return "&nbsp;";
    }
    else if(obj.equals("")){
       return "&nbsp;";
    }
    else
      return obj;
  }

  public static String strReplace(
    String sourceStr,
    String patternStr,
    String newStr) {
    int bePos = 0;
    int pos = 0;
    int patternStrLen = patternStr.length();
    ;

    int sourceStrLen = sourceStr.length();
    ;

    boolean found = false;
    String outputStr = new String();
    String endStr = new String();
    int endStrIdx = 0;

    while (bePos < sourceStrLen) {
      pos = sourceStr.indexOf(patternStr, bePos);

      if (pos != -1) {
        outputStr += (sourceStr.substring(bePos, pos) + newStr);
        bePos = pos + patternStrLen;
        endStrIdx = pos + patternStrLen;
        found = true;
      }
      else {
        bePos = sourceStrLen;
      }
    }

    if (found) {
      return outputStr + sourceStr.substring(endStrIdx);
    }
    else {
      return sourceStr;
    }
  }

  public static boolean containsKey(
    String[] keys,
    String key) {
    if (keys == null) {
      return false;
    }
    /**
   for(int i=0; i<keys.length;i++)
   {
     String val = keys[i];
     if(val!=null)
     {
       if(val.equals(key))
       {
         return true;
       }
     }
   }
    return false;
    **/

    Arrays.sort(keys);

    int retValue = Arrays.binarySearch(keys, key);
    
    ArrayList list = new ArrayList();
    

    if (retValue >= 0) {
      return true;
    }
    else {
      return false;
    }

  }

  public static java.sql.Date getCurDateDbFormat() {
    java.sql.Date curDate = null;

    try {
      String DEFAULT_DB_ZERO_TIME_DATE_FORMAT = "yyyy-MM-dd";
      java.util.Date theDate = new java.util.Date();
      java.text.SimpleDateFormat simpleDate = new java.text.SimpleDateFormat();
      simpleDate.applyPattern(DEFAULT_DB_ZERO_TIME_DATE_FORMAT);

      String currDateStr = simpleDate.format(theDate);
      curDate = java.sql.Date.valueOf(currDateStr);
    }
    catch (Exception e) {
      log.error(e.getMessage(), e);
    }

    return curDate;
  }

  public static boolean isInteger(String inStr) {
    if (!doesValueExist(inStr)) {
      return false;
    }

    try {
      if (Integer.parseInt(inStr.trim()) < 0) {
        return false;
      }
    }
    catch (NumberFormatException nfe) {
      return false;
    }

    return true;
  }

  public static boolean isDecimal(String inStr) {
    if (!doesValueExist(inStr)) {
      return false;
    }

    try {
      Double.parseDouble(inStr.trim());
    }
    catch (NumberFormatException nfe) {
      return false;
    }

    return true;
  }

  public static boolean doesValueExist(String val) {
    boolean valExist = false;

    if ((val != null) && !val.trim().equals("")) {
      valExist = true;
    }

    return valExist;
  }

  public static boolean doesNumValueExist(Number val) {
    if (val == null) {
      return false;
    }
    else {
      return true;
    }
  }

  public static boolean doesDateValueExist(Date val) {
    if (val == null) {
      return false;
    }
    else {
      return true;
    }
  }

   public static void main(String[] args) {
   String str = "\"test\"";
   String newStr="\\\"";
   System.out.println(str);
   String result = StringUtils.strReplace(str,"\"","\\\"");
   System.out.println(result);
  }
}
