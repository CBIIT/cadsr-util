/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.util;


public interface SortableColumnHeader
{
 public static int ASCENDING=1;
 public static int DESCENDING=-1;
 public static String DEFAULT_SORT_ORDER="SortableColumnHeaderDefaultSortOrder";
 static String NUMERIC_COLUMNS[] = {"cdeid"};
 public void setTertiary(String tertiary);
 public String getTertiary();
 public void setSecondary(String secondary);
 public String getSecondary();
 public void setPrimary(String primary);
 public String getPrimary();
 public int getOrder();
 public void setOrder(int order);
 public boolean isDefaultOrder();
 public void setDefaultOrder(boolean defaultOrder);
 public boolean isColumnNumeric(String columnName);

}