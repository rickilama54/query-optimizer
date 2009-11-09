package queryopt.optimizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import queryopt.entities.Atribute;
import queryopt.entities.Relation;
import queryopt.optimizer.query.Clause;
import queryopt.optimizer.query.CompareSingleRowClause;
import queryopt.optimizer.query.Operator;
import queryopt.optimizer.query.SPJQuery;
import queryopt.optimizer.query.Term;

public class TestQueries {
	void setup() {
		Relation departments = new Relation();
		departments.setName("DEPARTMENTS");
		departments.setNoOfRows(50);

		Atribute deptId = new Atribute(5, "DEPT_ID", true, 4, 50, departments);
		Atribute deptName = new Atribute(1, "DEPT_NAME", false, 100, 50, departments);
		Atribute deptSalary = new Atribute(1, "DEPT_AVG_SALARY", false, 10, 1000, departments);
		departments.setAtributes(Arrays.asList(deptId, deptName, deptSalary));

		Relation employees = new Relation();
		employees.setName("EMPLOYEES");
		employees.setNoOfRows(1000);

		Atribute epmId = new Atribute(1, "EMP_ID", true, 4, 1000, employees);
		Atribute empName = new Atribute(1, "EMP_NAME", false, 100, 1000, employees);
		Atribute empSalary = new Atribute(1, "EMP_SALARY", false, 4, 15, employees);
		Atribute departmentsDeptId = new Atribute(1, "DEPARTMENTS_DEPT_ID", false, 4, 30, employees, deptId);

		employees.setAtributes(Arrays.asList(epmId, empName, empSalary, departmentsDeptId));

		// SELECT EMP_NAME FROM EMPLOYEES
		SPJQuery query = new SPJQuery();

		List<Term> projectionTerms = new ArrayList<Term>();
		projectionTerms.add(empName);
		query.setProjectionTerms(projectionTerms);
		//

		// SELECT EMP_NAME, EMP_SALARY, DEPT_NAME, DEPT_SALARY
		// FROM EMPLOYEES, DEPARTMENTS
		// WHERE DEPARTMENTS_DEPT_ID = DEPT_ID
		SPJQuery query2 = new SPJQuery();

		projectionTerms = new ArrayList<Term>();
		projectionTerms.add(empName);
		projectionTerms.add(empSalary);
		projectionTerms.add(deptName);
		projectionTerms.add(deptSalary);
		query2.setProjectionTerms(projectionTerms);

		List<Clause> selectionCnfClauses = new ArrayList<Clause>();
		selectionCnfClauses.add(new CompareSingleRowClause(Operator.EQ, departmentsDeptId, deptId));
		query2.setSelectionCnfClauses(selectionCnfClauses);
	}
	
	void test1() {
		
	}
}
