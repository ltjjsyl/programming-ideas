package cn.chuxiao.designpattern.compose.example3;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {

    public List<Long> getDepartmentEmployeeIds(long id) {
        return new ArrayList<>();
    }

    public double getEmployeeSalary(long id) {
        return 0.0;
    }
}
