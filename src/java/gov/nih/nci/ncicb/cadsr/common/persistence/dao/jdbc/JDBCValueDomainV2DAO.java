package gov.nih.nci.ncicb.cadsr.common.persistence.dao.jdbc;

import gov.nih.nci.ncicb.cadsr.common.persistence.dao.ValueDomainV2DAO;
import gov.nih.nci.ncicb.cadsr.common.dto.ValueDomainV2TransferObject;
import gov.nih.nci.ncicb.cadsr.common.resource.ValueDomainV2;
import gov.nih.nci.ncicb.cadsr.common.resource.ValueDomain;
import gov.nih.nci.ncicb.cadsr.common.resource.ConceptDerivationRule;
import gov.nih.nci.ncicb.cadsr.common.resource.PermissibleValueV2;
import gov.nih.nci.ncicb.cadsr.common.resource.ValueMeaningV2;
import gov.nih.nci.ncicb.cadsr.common.dto.ConceptDerivationRuleTransferObject;
import gov.nih.nci.ncicb.cadsr.common.dto.PermissibleValueV2TransferObject;
import gov.nih.nci.ncicb.cadsr.common.dto.ValueMeaningV2TransferObject;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;
import java.util.Iterator;

import gov.nih.nci.ncicb.cadsr.common.servicelocator.ServiceLocator;
import gov.nih.nci.ncicb.cadsr.common.servicelocator.SimpleServiceLocator;

public class JDBCValueDomainV2DAO extends JDBCAdminComponentDAO implements
ValueDomainV2DAO {
	public JDBCValueDomainV2DAO(ServiceLocator locator) {
		super(locator);
	}

	public ValueDomainV2 getValueDomainV2ById(String vdId) {
		ValueDomainQuery query = new ValueDomainQuery(getDataSource());
		query.setSql();

		// value domain fully populated but concept is not populated (nor
		// permissible values)
		ValueDomainV2 valueDomainV2 = null;
		List ret = query.getValueDomainById(vdId);
		if (ret != null && !ret.isEmpty()) {
			valueDomainV2 = (ValueDomainV2) ret.get(0);

			// get permissible values
			PermissibleValueQuery pvQuery = new PermissibleValueQuery(
					getDataSource());
			pvQuery.setSql();
			List permissibleValues = pvQuery.getPermissibleValuesByVDId(vdId);
			valueDomainV2.setPermissibleValueV2(permissibleValues);
		}

		return valueDomainV2;
	}

	// based on ValueDomainQuery from JDBCValueDomainDAO
	/**
	 * Inner class to get all valid values for each value domain
	 * 
	 */
	class ValueDomainQuery extends MappingSqlQuery {

		// vd_idseq is the key and vvList is the value (list of valid values)
		ValueDomainQuery(DataSource ds) {
			super();
			this.setDataSource(ds);
		}

		public void setSql() {
			String sql = " SELECT VD_IDSEQ, LONG_NAME, VERSION, VD_ID, ASL_NAME, UOML_NAME, MAX_LENGTH_NUM, MIN_LENGTH_NUM, DECIMAL_PLACE, HIGH_VALUE_NUM, LOW_VALUE_NUM, CONDR_IDSEQ, FORML_NAME, DTL_NAME from SBR.VALUE_DOMAINS_VIEW where VD_IDSEQ=?";
			setSql(sql);
			declareParameter(new SqlParameter("VD_IDSEQ", Types.VARCHAR));
			compile();
		}

		protected Object mapRow(ResultSet rs, int rownum) throws SQLException {

			// reaches to this point for each record retrieved.
			String vdomainIdSeq = rs.getString(1); // VD_IDSEQ

			ValueDomain vd = new ValueDomainV2TransferObject();
			vd.setVdIdseq(vdomainIdSeq);
			vd.setLongName(rs.getString(2));
			vd.setVersion(rs.getFloat(3));
			vd.setPublicId(rs.getInt(4));
			vd.setAslName(rs.getString(5));
			vd.setUnitOfMeasure(rs.getString(6));
			vd.setMaxLength(rs.getString(7));
			vd.setMinLength(rs.getString(8));
			vd.setDecimalPlace(rs.getString(9));
			vd.setHighValue(rs.getString(10));
			vd.setLowValue(rs.getString(11));
			vd.setDisplayFormat(rs.getString(13));
			vd.setDatatype(rs.getString(14));
			ConceptDerivationRule cdr = new ConceptDerivationRuleTransferObject();
			cdr.setIdseq(rs.getString(12));

			vd.setConceptDerivationRule(cdr);
			return vd;
		}

		public List getValueDomainById(String vdId) {
			Object[] obj = new Object[] { vdId };

			return execute(obj);

		}

	}

	class PermissibleValueQuery extends MappingSqlQuery {

		// vd_idseq is the key and vvList is the value (list of valid values)
		PermissibleValueQuery(DataSource ds) {
			super();
			this.setDataSource(ds);
		}

		public void setSql() {
			String sql = "select VALUE, vm.PUBLIC_ID, vm.VERSION, vm.PREFERRED_DEFINITION from CABIO31_VD_PV_VIEW vdpv, CABIO31_PV_VIEW pv, CABIO31_VM_VIEW vm where vdpv.pv_idseq = pv.pv_idseq and pv.vm_idseq = vm.vm_idseq and vdpv.vd_idseq=?";
			setSql(sql);
			declareParameter(new SqlParameter("VD_IDSEQ", Types.VARCHAR));
			compile();
		}

		protected Object mapRow(ResultSet rs, int rownum) throws SQLException {

			PermissibleValueV2 pv = new PermissibleValueV2TransferObject();
			pv.setValue(rs.getString("VALUE"));

			ValueMeaningV2 vm = new ValueMeaningV2TransferObject();
			vm.setPublicId(rs.getInt("PUBLIC_ID"));
			vm.setVersion(rs.getFloat("VERSION"));
			vm.setPreferredDefinition(rs.getString("PREFERRED_DEFINITION"));

			pv.setValueMeaningV2(vm);

			return pv;
		}

		public List getPermissibleValuesByVDId(String vdId) {
			Object[] obj = new Object[] { vdId };

			return execute(obj);

		}
	}

	// /**
	// * Gets all Value Domains and their Valid Values
	// *
	// * @param <b>vdIdseqs</b> list of Value Domain Idseq.
	// *
	// * @return <b>Map</b> Map of Value Domain objects each having
	// * list of Valid Value objects (key: vd idseq, value: vv list).
	// * For non-enummerated VD, vd_idseq with empty list of VV should be
	// returned.
	// *
	// */
	// public Map getValidValues(Collection vdIdseqs){
	//
	// if (vdIdseqs == null) {
	// return new HashMap();
	// }
	//    
	// if (vdIdseqs.size() == 0) {
	// return new HashMap();
	// }
	//
	// Iterator vdIdseqIterator = vdIdseqs.iterator();
	// String whereString = "";
	// Map vvMap = new HashMap();
	//
	// while(vdIdseqIterator.hasNext()) {
	//
	// // put every vd_idseq with empty list into the map
	// List vvList = new ArrayList();
	// String vdomainIdSeq = (String) vdIdseqIterator.next();
	// // vd_idseq is the key and vvList is the value (list of valid values)
	// vvMap.put(vdomainIdSeq, vvList);
	//
	// if (StringUtils.doesValueExist(whereString)){
	// whereString = whereString + " or VD_IDSEQ = '" + vdomainIdSeq + "'";
	// }
	// else {
	// whereString = whereString + " where VD_IDSEQ = '" + vdomainIdSeq + "'";
	// }
	// }
	//    
	// ValidValueQuery query = new ValidValueQuery(vvMap);
	// query.setDataSource(getDataSource());
	// query.setSql(whereString, "");
	//
	// // query.execute returns map of n number of records retrieved from db
	// query.execute();
	// Map records = query.getValidValueMap();
	// return records;
	// }
	//  
	// public Map getPermissibleValues(Collection vdIdseqs) {
	// PermissibleValueQuery pvQry = new PermissibleValueQuery();
	// pvQry.setDataSource(getDataSource());
	// return pvQry.getPermissibleValuesMap(vdIdseqs);
	// }
	//
	// public ValueDomain getValueDomainById(String vdId){
	// ValueDomainQuery query = new ValueDomainQuery(getDataSource());
	// query.setSql();
	//
	// //value domain fully populated but concept is not populated
	// List ret = query.getValueDomainById(vdId);
	// if (ret!=null && !ret.isEmpty()){
	// return (ValueDomain)ret.get(0);
	// }
	// return null;
	// }
	//    
	// public ValueMeaning getValueMeaning(String shortMeaning){
	// ValueMeaningQuery vmQuery = new ValueMeaningQuery(getDataSource());
	// vmQuery.setSql();
	// ValueMeaning vm = vmQuery.getValueMeaning(shortMeaning);
	// vm.setDefinitions(getDefinitions(vm.getIdseq()));
	// vm.setDesignations(getDesignations(vm.getIdseq(), null));
	// //Added for 4.0 release
	// vm.setContext(getContext(vm.getIdseq()));
	// return vm;
	// }
	//    
	// /**
	// * Inner class to get value meanign
	// *
	// */
	// class ValueMeaningQuery extends MappingSqlQuery {
	//    
	// ValueMeaningQuery(DataSource ds) {
	// super();
	// this.setDataSource(ds);
	// }
	//
	// public void setSql() {
	// // String sql =
	// " SELECT * from sbr.value_meanings where short_meaning = ?" ;
	// String sql = " SELECT * from sbr.value_meanings_view where long_name = ?"
	// ;
	// setSql(sql);
	// declareParameter(new SqlParameter("short_meaning", Types.VARCHAR));
	// compile();
	// }
	//      
	// protected Object mapRow(
	// ResultSet rs,
	// int rownum) throws SQLException {
	//
	// // reaches to this point for each record retrieved.
	// ValueMeaning vm = new ValueMeaningTransferObject();
	// vm.setLongName(rs.getString("long_name"));
	// vm.setIdseq(rs.getString("vm_idseq"));
	// vm.setPreferredDefinition(rs.getString("preferred_definition"));
	// //Added for 4.0 release
	// vm.setPublicId(new Integer(rs.getString("vm_id")).intValue());
	// vm.setVersion(new Float(rs.getString("version")).floatValue());
	// vm.setAslName(rs.getString("asl_name"));
	// //
	// return vm;
	// }
	//      
	// public ValueMeaning getValueMeaning(String shortMeaning){
	// Object[] obj =
	// new Object[] { shortMeaning };
	// List ret = execute(obj);
	// if (ret!=null){
	// return (ValueMeaning)(ret.get(0));
	// }else{
	// return null;
	// }
	// }
	// }
	//    
	// /**
	// * Inner class to get all valid values for each value domain
	// *
	// */
	// class ValueDomainQuery extends MappingSqlQuery {
	//  
	// // vd_idseq is the key and vvList is the value (list of valid values)
	// ValueDomainQuery(DataSource ds) {
	// super();
	// this.setDataSource(ds);
	// }
	//
	// public void setSql() {
	// String sql =
	// " SELECT VD_IDSEQ, LONG_NAME, VERSION, VD_ID, ASL_NAME, UOML_NAME, MAX_LENGTH_NUM, MIN_LENGTH_NUM, DECIMAL_PLACE, HIGH_VALUE_NUM, LOW_VALUE_NUM, CONDR_IDSEQ, FORML_NAME, DTL_NAME from SBR.VALUE_DOMAINS_VIEW where VD_IDSEQ=?"
	// ;
	// setSql(sql);
	// declareParameter(new SqlParameter("VD_IDSEQ", Types.VARCHAR));
	// compile();
	// }
	//
	//    
	// protected Object mapRow(
	// ResultSet rs,
	// int rownum) throws SQLException {
	//
	// // reaches to this point for each record retrieved.
	// String vdomainIdSeq = rs.getString(1); // VD_IDSEQ
	//      
	// ValueDomain vd = new ValueDomainTransferObject();
	// vd.setVdIdseq(vdomainIdSeq);
	// vd.setLongName(rs.getString(2));
	// vd.setVersion(rs.getFloat(3));
	// vd.setPublicId(rs.getInt(4));
	// vd.setAslName(rs.getString(5));
	// vd.setUnitOfMeasure(rs.getString(6));
	// vd.setMaxLength(rs.getString(7));
	// vd.setMinLength(rs.getString(8));
	// vd.setDecimalPlace(rs.getString(9));
	// vd.setHighValue(rs.getString(10));
	// vd.setLowValue(rs.getString(11));
	// vd.setDisplayFormat(rs.getString(13));
	// vd.setDatatype(rs.getString(14));
	// ConceptDerivationRule cdr =
	// new ConceptDerivationRuleTransferObject();
	// cdr.setIdseq(rs.getString(12));
	//        
	// vd.setConceptDerivationRule(cdr);
	// return vd;
	// }
	//    
	//    
	// public List getValueDomainById(String vdId){
	// Object[] obj =
	// new Object[] {
	// vdId
	// };
	//
	// return execute(obj);
	//
	//        
	// }
	// }
	//
	//
	// /**
	// * Inner class to get all valid values for each value domain
	// *
	// */
	// class ValidValueQuery extends MappingSqlQuery {
	//    
	// // vd_idseq is the key and vvList is the value (list of valid values)
	// private Map vvMap = null;
	//      
	// ValidValueQuery(Map vvvMap) {
	// super();
	// this.vvMap = vvvMap;
	// }
	//
	// public void setSql(String whereString, String dummy) {
	// super.setSql("SELECT * FROM SBREXT.FB_VD_VV_VIEW " + whereString
	// +"order by upper( PV_VALUE ) ");
	// }
	//
	// public Map getValidValueMap(){
	// return vvMap;
	// }
	//      
	// protected Object mapRow(
	// ResultSet rs,
	// int rownum) throws SQLException {
	//
	// // reaches to this point for each record retrieved.
	// String vdomainIdSeq = rs.getString(1); // VD_IDSEQ
	//        
	// ValidValueTransferObject vvto = new ValidValueTransferObject();
	// vvto.setShortMeaningValue(rs.getString(3)); // PV_VALUE
	// vvto.setShortMeaning(rs.getString(4)); // PV_SHORT_MEANING
	// vvto.setShortMeaningDescription(rs.getString(5)); //
	// PV_MEANING_DESCRIPTION
	// vvto.setVpIdseq(rs.getString(6)); //VP_IDSEQ
	//        
	// ValueMeaning vm = new ValueMeaningTransferObject();
	// vm.setLongName(vvto.getShortMeaning());
	// vm.setPreferredDefinition(rs.getString("VM_DESCRIPTION"));
	// String vmIdSeq = rs.getString("VM_IDSEQ");
	// vm.setIdseq(vmIdSeq);
	// vm.setPublicId(rs.getInt("VM_ID"));
	// vm.setVersion(rs.getFloat("VM_VERSION"));
	//        
	// //set designations and definitions
	// vm.setDefinitions(getDefinitions(vmIdSeq));
	// vm.setDesignations(getDesignations(vmIdSeq, null));
	//                
	// vvto.setValueMeaning(vm);
	//        
	// List vvList = (List) vvMap.get(vdomainIdSeq);
	// vvList.add(vvto);
	// vvMap.put(vdomainIdSeq, vvList);
	// return vvMap;
	// }
	// }
	//    
	//    
	// class PermissibleValueQuery extends MappingSqlQuery {
	//            
	// private Map<String, List<ValidValue>> vvMap ;
	// private Map<String, List<ValidValue>> vmIdSeqs;
	// PermissibleValueQuery() {
	// super();
	// vvMap = new HashMap<String, List<ValidValue>>();
	// vmIdSeqs = new HashMap<String, List<ValidValue>>();
	// }
	//
	// public Map getPermissibleValuesMap(Collection<String> vdIdSeqs){
	// if (vdIdSeqs == null || vdIdSeqs.size() < 1) {
	// return new HashMap();
	// }
	// String sql =
	// "SELECT b.VD_IDSEQ, a.*, sbrext_common_routines.return_number(a.VALUE) display_order FROM PERMISSIBLE_VALUES_VIEW a, VD_PVS_VIEW b where a.PV_IDSEQ = b.PV_IDSEQ and b.VD_IDSEQ in ( ";
	//
	// for (String vdIdSeq: vdIdSeqs) {
	// sql += "'"+vdIdSeq+"',";
	// }
	//
	// if (sql.lastIndexOf(",") == -1) {
	// sql += "'')";
	// }
	// else {
	// sql = sql.substring(0, sql.length() - 1)+")";
	// }
	// sql += " order by display_order, upper(a.VALUE)";
	// super.setSql(sql);
	//    	
	// List results = execute();
	//    	
	// Map<String, List<ValidValue>> resultMap = (Map<String,
	// List<ValidValue>>)results.get(0);
	//    	
	// if (results != null && results.size() > 0) {
	// Map<String, ValueMeaning> valueMeanings =
	// getValueMeanings(vmIdSeqs.keySet());
	//    		
	// for (String vmIdSeq: vmIdSeqs.keySet()) {
	// List<ValidValue> vvs = vmIdSeqs.get(vmIdSeq);
	// for (ValidValue vv: vvs) {
	// vv.setValueMeaning(valueMeanings.get(vmIdSeq));
	// }
	// }
	// }
	//    	
	// return resultMap;
	// }
	//    
	// protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
	//
	// // reaches to this point for each record retrieved.
	// String vdomainIdSeq = rs.getString(1); // VD_IDSEQ
	//      
	// ValidValueTransferObject vvto = new ValidValueTransferObject();
	// vvto.setShortMeaningValue(rs.getString(3)); // PV_VALUE
	// vvto.setShortMeaning(rs.getString(3)); // PV_SHORT_MEANING
	// vvto.setShortMeaningDescription(rs.getString(5)); //
	// PV_MEANING_DESCRIPTION
	//                
	// String vmIdSeq = rs.getString("VM_IDSEQ");
	//      
	// List<ValidValue> valVal = null;
	// if (vmIdSeqs.get(vmIdSeq) == null) {
	// valVal = new ArrayList<ValidValue>();
	// vmIdSeqs.put(vmIdSeq, valVal);
	// }
	// valVal.add(vvto);
	//
	// List<ValidValue> vvList = vvMap.get(vdomainIdSeq);
	// if (vvList == null) {
	// vvList = new ArrayList<ValidValue>();
	// }
	// vvList.add(vvto);
	// vvMap.put(vdomainIdSeq, vvList);
	// return vvMap;
	// }
	// }
	//
	// public Map<String, ValueMeaning> getValueMeanings(Collection<String>
	// vmIds) {
	// if (vmIds == null || vmIds.size() < 1) {
	// return new HashMap<String, ValueMeaning>();
	// }
	// String qry = "select * from VALUE_MEANINGS_VIEW where VM_IDSEQ in ( ";
	// for (String vmId: vmIds) {
	// qry += "'"+vmId+"',";
	// }
	//		
	// if (qry.lastIndexOf(",") == -1) {
	// qry += "'')";
	// }
	// else {
	// qry = qry.substring(0, qry.length() - 1)+")";
	// }
	//		
	// JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	// Map<String, ValueMeaning> vmMap = (Map<String,
	// ValueMeaning>)jdbcTemplate.query(qry, new ResultSetExtractor() {
	// public Object extractData(ResultSet rs) throws SQLException,
	// DataAccessException {
	// Map<String, ValueMeaning> vmMap = new HashMap<String, ValueMeaning>();
	// while (rs.next()) {
	// ValueMeaning vm = new ValueMeaningTransferObject();
	// vm.setPreferredName(rs.getString(1));
	// vm.setPreferredDefinition(rs.getString(2));
	// String vmIdSeq = rs.getString(11);
	// vm.setLongName(rs.getString(14));
	// vm.setDefinitions(getDefinitions(vmIdSeq));
	// vm.setDesignations(getDesignations(vmIdSeq, null));
	//					
	// vmMap.put(vmIdSeq, vm);
	// }
	// return vmMap;
	// }
	// });
	//		
	// return vmMap;
	// }

}
