package queryopt.optimizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import queryopt.entities.Atribute;
import queryopt.entities.ExecutionPlan;
import queryopt.entities.Index;
import queryopt.entities.Query;
import queryopt.entities.Relation;
import queryopt.entities.SystemInfo;
import queryopt.optimizer.query.SPJQuery;

public class TestParserAndSPJBuilder {
	private List<Relation> allRelations;

	public void setup() {
		SystemInfo systemInfo = new SystemInfo();
		systemInfo.setBlockingFactorIndexFirstLevelRows(2);
		systemInfo.setMemorySizeInBytes(4000000);
		systemInfo.setPageSizeInBytes(4000);
		systemInfo.setRidSizeInBytes(4);

		Relation departments = new Relation();
		departments.setBlockingFactor(1);
		departments.setIndexes(new ArrayList<Index>());
		departments.setName("DEPARTMENTS");
		departments.setNoOfRows(50);

		Atribute deptId = new Atribute(1, "DEPT_ID", true, 4, 50, departments);
		Atribute deptName = new Atribute(2, "DEPT_NAME", false, 100, 100, departments);
		Atribute deptSalary = new Atribute(3, "DEPT_AVG_SALARY", false, 10, 100, departments);
		departments.setAtributes(Arrays.asList(deptId, deptName, deptSalary));

		Relation employees = new Relation();
		employees.setBlockingFactor(2);
		employees.setIndexes(new ArrayList<Index>());
		employees.setName("EMPLOYEES");
		employees.setNoOfRows(1000);

		Atribute empId = new Atribute(4, "EMP_ID", true, 4, 1000, employees);
		Atribute empName = new Atribute(5, "EMP_NAME", false, 100, 100, employees);
		Atribute empSalary = new Atribute(6, "EMP_SALARY", false, 4, 100, employees);
		Atribute departmentsDeptId = new Atribute(7, "DEPARTMENTS_DEPT_ID", false, 4, 30, employees, deptId);

		empName.setHighValue("ZZZZZZ");
		empName.setLowValue("A");
		empSalary.setHighValue("10000");
		empSalary.setLowValue("0");

		employees.setAtributes(Arrays.asList(empId, empName, empSalary, departmentsDeptId));

		allRelations = new ArrayList<Relation>();
		allRelations.add(employees);
		allRelations.add(departments);
	}

	public void testSPJQuery(String query) throws Exception {

		Query q = new Query();
		q.setText(query);
		ExecutionPlan execplan1 = new ExecutionPlan();
		execplan1.setQuery(q);
		execplan1.setDisabledIndexes(new ArrayList<Index>());

		SPJQueryBuilder builder = new SPJQueryBuilder(allRelations);
		builder.parse(q.getText());
		SPJQuery spjquery = builder.build(execplan1);
		System.out.println(spjquery);
	}

	public static void main(String[] args) throws Exception {

		String query1 = "SELECT EMP_ID, EMP_NAME, EMP_SALARY " + "FROM EMPLOYEES";
		String query2 = "SELECT EMP_ID, EMP_NAME, EMP_SALARY " + "FROM EMPLOYEES, DEPARTMENTS "
				+ "WHERE DEPARTMENTS_DEPT_ID = DEPT_ID AND EMP_NAME = 'DRAGAN' AND EMP_SALARY > 5";

		TestParserAndSPJBuilder test = new TestParserAndSPJBuilder();
		test.setup();
		test.testSPJQuery(query1);
		test.testSPJQuery(query2);
	}
}
