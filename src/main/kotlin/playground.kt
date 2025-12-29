fun main() {
    val employee : Employee = Developer()
    print(employee.salary) // 60000
}

abstract class Employee{
    abstract val salary : Int
}

class Developer : Employee(){
    override val salary : Int = 60_000
}