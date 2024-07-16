package com.mruruc.model;

import org.springframework.beans.factory.annotation.Value;

public class Projection {
    public interface EmployeeSummary{
        String getFirstName();
        @Value("#{target.firstName}  #{target.salary}")
        String getInfo();
    }
}
