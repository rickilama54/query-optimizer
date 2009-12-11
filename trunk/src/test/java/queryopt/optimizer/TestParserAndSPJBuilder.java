package queryopt.optimizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import queryopt.entities.Atribute;
import queryopt.entities.ExecutionPlan;
import queryopt.entities.Index;
import queryopt.entities.IndexAtribute;
import queryopt.entities.Query;
import queryopt.entities.Relation;
import queryopt.entities.SystemInfo;
import queryopt.optimizer.query.SPJQuery;

public class TestParserAndSPJBuilder {
	private List<Relation> allRelations;
	private SystemInfo systemInfo;

	public void setup() {
		systemInfo = new SystemInfo();
		systemInfo.setBlockingFactorIndexFirstLevelRows(2);
		systemInfo.setMemorySizeInBytes(4000000);
		systemInfo.setPageSizeInBytes(4000);
		systemInfo.setRidSizeInBytes(4);

		Relation departments = new Relation();
		departments.setBlockingFactor(1);
		departments.setIndexes(new ArrayList<Index>());
		departments.setName("DEPARTMENTS");
		departments.setNoOfRows(50);

		Atribute deptId = new Atribute(1, "DEPT_ID", true, 4, 100, departments);
		Atribute deptName = new Atribute(2, "DEPT_NAME", false, 100, 100, departments);
		Atribute deptSalary = new Atribute(3, "DEPT_AVG_SALARY", false, 10, 100, departments);
		departments.setAtributes(Arrays.asList(deptId, deptName, deptSalary));

		deptId.setLowValue("1");
		deptId.setHighValue(String.valueOf(departments.getNoOfRows()));

		Relation employees = new Relation();
		employees.setBlockingFactor(2);
		employees.setIndexes(new ArrayList<Index>());
		employees.setName("EMPLOYEES");
		employees.setNoOfRows(1000);

		Atribute empId = new Atribute(4, "EMP_ID", true, 4, 100, employees);
		Atribute empName = new Atribute(5, "EMP_NAME", false, 100, 100, employees);
		Atribute empSalary = new Atribute(6, "EMP_SALARY", false, 4, 100, employees);
		Atribute departmentsDeptId = new Atribute(7, "DEPARTMENTS_DEPT_ID", false, 4, 100, employees, deptId);

		empId.setLowValue("1");
		empId.setHighValue("10");
		
		departmentsDeptId.setLowValue("1");
		departmentsDeptId.setHighValue("10");

		empName.setHighValue("ZZZZZZ");
		empName.setLowValue("AAAAAA");
		empSalary.setHighValue("10000");
		empSalary.setLowValue("0");

		employees.setAtributes(Arrays.asList(empId, empName, empSalary, departmentsDeptId));
		
		Relation empDetails = new Relation();
		empDetails.setBlockingFactor(2);
		empDetails.setIndexes(new ArrayList<Index>());
		empDetails.setName("EMP_DETAILS");
		empDetails.setNoOfRows(10000);

		Atribute empDetailsId = new Atribute(4, "EMP_DETAILS_ID", true, 4, 100, empDetails);
		Atribute empDetailsName = new Atribute(5, "EMP_DETAILS_NAME", false, 100, 100, empDetails);
		Atribute employeesEmpId = new Atribute(7, "EMPLOYEES_EMP_ID", false, 4, 100, empDetails, empId);

		empDetailsId.setLowValue("1");
		empDetailsId.setHighValue("100000");
		
		employeesEmpId.setLowValue("1");
		employeesEmpId.setHighValue("10");

		empDetails.setAtributes(Arrays.asList(empDetailsId, empDetailsName, employeesEmpId));

		allRelations = new ArrayList<Relation>();
		allRelations.add(employees);
		allRelations.add(departments);
		allRelations.add(empDetails);
		
		Index indexEmpId = new Index();
		indexEmpId.setBTree(true);
		indexEmpId.setLevels(2);
		indexEmpId.setName("indexEmpId");
		indexEmpId.setRelation(employees);
		indexEmpId.setIndexAtributes(Arrays.asList(new IndexAtribute(indexEmpId, empId)));

		Index indexEmpName = new Index();
		indexEmpName.setBTree(true);
		indexEmpName.setLevels(2);
		indexEmpName.setName("indexEmpName");
		indexEmpName.setRelation(employees);
		indexEmpName.setIndexAtributes(Arrays.asList(new IndexAtribute(indexEmpName, empName)));

		Index indexEmpNameEmpSal = new Index();
		indexEmpNameEmpSal.setBTree(true);
		indexEmpNameEmpSal.setLevels(2);
		indexEmpNameEmpSal.setName("indexEmpNameEmpSal");
		indexEmpNameEmpSal.setRelation(employees);
		indexEmpNameEmpSal.setIndexAtributes(Arrays.asList(new IndexAtribute(indexEmpNameEmpSal, empName),
				new IndexAtribute(indexEmpNameEmpSal, empSalary)));

		Index indexEmpSal = new Index();
		indexEmpSal.setBTree(true);
		indexEmpSal.setLevels(2);
		indexEmpSal.setName("indexEmpSal");
		indexEmpSal.setRelation(employees);
		indexEmpSal.setIndexAtributes(Arrays.asList(new IndexAtribute(indexEmpSal, empSalary)));

		Index indexEmpSalEmpName = new Index();
		indexEmpSalEmpName.setBTree(true);
		indexEmpSalEmpName.setLevels(2);
		indexEmpSalEmpName.setName("indexEmpSal");
		indexEmpSalEmpName.setRelation(employees);
		indexEmpSalEmpName.setIndexAtributes(Arrays.asList(new IndexAtribute(indexEmpSalEmpName, empSalary),
				new IndexAtribute(indexEmpSalEmpName, empName)));

		// employees.setIndexes(Arrays.asList(indexEmpId, indexEmpName,
		// indexEmpNameEmpSal));
		// employees.setIndexes(Arrays.asList(indexEmpSalEmpName));
		employees.setIndexes(Arrays.asList(indexEmpId, indexEmpName, indexEmpSal));
	}

	public SPJQuery testSPJQuery(String query) throws Exception {

		Query q = new Query();
		q.setText(query);
		ExecutionPlan execplan1 = new ExecutionPlan();
		execplan1.setQuery(q);
		execplan1.setDisabledIndexes(new ArrayList<Index>());

		SPJQueryBuilder builder = new SPJQueryBuilder(allRelations);
		builder.parse(q.getText());
		SPJQuery spjquery = builder.build(execplan1);
		System.out.println(spjquery);
		spjquery.setSystemInfo(systemInfo);
		return spjquery;
	}

	static void optimize(SPJQuery query) throws Exception {
		Optimizer optimizer = new Optimizer(query);
		Plan plan = optimizer.generateBestPlan();
		System.out.println("Best Plan:\n" + plan.getPlanAsTree());
	}

	public static void main(String[] args) throws Exception {

		String query1 = "SELECT EMP_ID, EMP_NAME, EMP_SALARY " + "FROM EMPLOYEES WHERE EMP_NAME = 'DRAGAN'";
		String query2 = "SELECT EMP_ID, EMP_NAME, EMP_SALARY " + "FROM EMPLOYEES, DEPARTMENTS "
				+ "WHERE DEPARTMENTS_DEPT_ID = DEPT_ID";
		String query3 = "SELECT EMP_ID, EMP_NAME, EMP_SALARY " + "FROM EMPLOYEES, DEPARTMENTS "
				+ "WHERE DEPARTMENTS_DEPT_ID = DEPT_ID AND EMP_NAME > 'DRAGAN' AND EMP_SALARY > 5";
		
		String query4 = "SELECT EMP_ID, EMP_NAME, EMP_SALARY, EMP_DETAILS_NAME " + "FROM EMPLOYEES, DEPARTMENTS, EMP_DETAILS "
		+ "WHERE DEPARTMENTS_DEPT_ID = DEPT_ID AND EMPLOYEES_EMP_ID = EMP_ID";

		String query5 = "SELECT EMP_ID, EMP_NAME, EMP_SALARY, EMP_DETAILS_NAME " + "FROM EMPLOYEES, DEPARTMENTS, EMP_DETAILS "
		+ "WHERE DEPARTMENTS_DEPT_ID = DEPT_ID AND EMPLOYEES_EMP_ID = EMP_ID AND EMP_ID = 1 AND EMP_SALARY > 500 AND DEPT_ID= 2 AND EMP_DETAILS_ID = 10";
		
		TestParserAndSPJBuilder test = new TestParserAndSPJBuilder();
		test.setup();
		SPJQuery spjquery1 = test.testSPJQuery(query1);
		SPJQuery spjquery2 = test.testSPJQuery(query2);
		SPJQuery spjquery3 = test.testSPJQuery(query3);
		SPJQuery spjquery4 = test.testSPJQuery(query4);
		SPJQuery spjquery5 = test.testSPJQuery(query5);
		optimize(spjquery1);
		optimize(spjquery2);
		optimize(spjquery3);
		optimize(spjquery4);
		optimize(spjquery5);
	}
}
