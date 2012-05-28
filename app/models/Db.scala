package models

object Query {
  def apply(cmd: String) = {
    queryMap(cmd)
  }

  val queryMap = Map(
    "getEmployees" -> """
		  SELECT * FROM employees
		  """,
    "getEmployeeById" -> """
		  SELECT * FROM employees where employee_id = :id
		  """,
    "getEmployeeByFirstName" -> """
		  SELECT * FROM employees where firstname = :firstname
		  """,
    "getEmployeeByLastName" -> """
		  SELECT * FROM employees where lastname = :lastname
		  """)
}
