package queryopt.optimizer;

import java.util.ArrayList;
import java.util.Arrays;

import queryopt.entities.Atribute;
import queryopt.entities.Index;
import queryopt.entities.IndexAtribute;
import queryopt.entities.Relation;
import queryopt.entities.SystemInfo;
import queryopt.optimizer.query.CompareSingleRowClause;
import queryopt.optimizer.query.Literal;
import queryopt.optimizer.query.Operator;
import queryopt.optimizer.query.SPJQuery;

public class TestQueries {
	SPJQuery query1;
	SPJQuery query2;
	SPJQuery query3;
	SPJQuery query4;
	SPJQuery query5;
	SPJQuery query6;
	SPJQuery query7;
	SPJQuery query8;
	SPJQuery query9;
	SPJQuery query10;

	void setup() {
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
		employees.setAtributes(Arrays.asList(empId, empName, empSalary, departmentsDeptId));

		// SELECT EMP_NAME FROM EMPLOYEES
		query1 = new SPJQuery();
		query1.getProjectionTerms().add(empName);
		query1.setSystemInfo(systemInfo);
		//

		// SELECT EMP_NAME, EMP_SALARY, DEPT_NAME, DEPT_SALARY
		// FROM EMPLOYEES, DEPARTMENTS
		// WHERE DEPARTMENTS_DEPT_ID = DEPT_ID
		query2 = new SPJQuery();
		query2.setSystemInfo(systemInfo);
		query2.getProjectionTerms().add(empName);
		query2.getProjectionTerms().add(empSalary);
		query2.getProjectionTerms().add(deptName);
		query2.getProjectionTerms().add(deptSalary);

		query2.getSelectionCnfClauses().add(new CompareSingleRowClause(Operator.EQ, departmentsDeptId, deptId));

		// SELECT EMP_NAME FROM EMPLOYEES WHERE EMP_NAME = 'JOHNY'
		query3 = new SPJQuery();
		query3.getProjectionTerms().add(empName);
		query3.setSystemInfo(systemInfo);
		query3.getSelectionCnfClauses().add(new CompareSingleRowClause(Operator.EQ, empName, new Literal("JOHNY")));
		//

		// SELECT EMP_NAME FROM EMPLOYEES WHERE EMP_NAME >= 'A'
		query4 = new SPJQuery();
		query4.getProjectionTerms().add(empName);
		query4.setSystemInfo(systemInfo);
		query4.getSelectionCnfClauses().add(new CompareSingleRowClause(Operator.GT_EQ, empName, new Literal("A")));
		//

		// SELECT EMP_ID FROM EMPLOYEES
		query5 = new SPJQuery();
		query5.getProjectionTerms().add(empId);
		query5.setSystemInfo(systemInfo);
		//

		// SELECT EMP_NAME, EMP_SALARY FROM EMPLOYEES
		query6 = new SPJQuery();
		query6.getProjectionTerms().add(empName);
		query6.getProjectionTerms().add(empSalary);
		query6.setSystemInfo(systemInfo);
		//

		// SELECT EMP_NAME FROM EMPLOYEES WHERE EMP_SALARY=500
		query7 = new SPJQuery();
		query7.getProjectionTerms().add(empName);
		query7.getSelectionCnfClauses().add(new CompareSingleRowClause(Operator.GT_EQ, empSalary, new Literal("5000")));
		query7.setSystemInfo(systemInfo);
		//

		// SELECT EMP_NAME FROM EMPLOYEES WHERE EMP_SALARY=500
		query8 = new SPJQuery();
		query8.getProjectionTerms().add(empName);
		query8.getSelectionCnfClauses().add(new CompareSingleRowClause(Operator.EQ, empSalary, new Literal("9000")));
		query8.setSystemInfo(systemInfo);
		//

		// SELECT EMP_NAME, EMP_SALARY FROM EMPLOYEES WHERE EMP_NAME = 'DRAGAN'
		// AND EMP_SALARY='500';
		query9 = new SPJQuery();
		query9.getProjectionTerms().add(empName);
		query9.getProjectionTerms().add(empSalary);
		query9.getSelectionCnfClauses().add(new CompareSingleRowClause(Operator.GT_EQ, empName, new Literal("DRAGAN")));
		query9.getSelectionCnfClauses().add(new CompareSingleRowClause(Operator.EQ, empSalary, new Literal("500")));
		query9.setSystemInfo(systemInfo);
		//

	}

	void test(SPJQuery query) throws Exception {
		Optimizer optimizer = new Optimizer(query);
		Plan bestPlan = optimizer.generateBestPlan();
		System.out.println(bestPlan.getPlanAsTree());
	}

	public static void main(String[] args) throws Exception {
		TestQueries testQueries = new TestQueries();
		testQueries.setup();

		testQueries.test(testQueries.query1);

		testQueries.test(testQueries.query3);
		testQueries.test(testQueries.query4);
		testQueries.test(testQueries.query5);
		testQueries.test(testQueries.query6);

		testQueries.test(testQueries.query7);
		testQueries.test(testQueries.query8);
		testQueries.test(testQueries.query9);
	}
}
